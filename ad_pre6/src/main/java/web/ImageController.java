package web;


import com.sun.org.apache.xpath.internal.operations.Mod;
import image.entity.Image;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import service.ImageService;
import org.apache.commons.fileupload.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import Exception.ImageException;
@Controller
public class ImageController {
    @Autowired
    ImageService imageService;
    Logger logger = LoggerFactory.getLogger(this.getClass());
    @RequestMapping(value = "/List/{page}",method = RequestMethod.GET)
    public String List(Model model,@PathVariable("page") String page,HttpServletRequest request){
//        System.out.println(request.getServletContext().getRealPath("/Picture"));
        List<Image> listAll =  imageService.queryAll();
//        注意在这里写分页就代表了耦合度已经变高了
        Integer index =  Integer.parseInt(page);
        List<Image> list = new ArrayList<Image>();
        if(index==11||index==0){
            if (index==0&&listAll.size()<=5){
                for(int i = 0;i<listAll.size();i++){
                    list.add(listAll.get(i));
                }
            }
            else if(listAll.size()>=5){
                for(int i = 0;i<5;i++){
                    list.add(listAll.get(i));
                }
            }
            if(index==11&&listAll.size()>(index-2)*5){
                for(int i = (index-2)*5-1;i<listAll.size();i++){
                    list.add(listAll.get(i));
                }
            }else if(index==11&&listAll.size()<=(index-2)*5){
                list.clear();
            }
        }
        else {
//          i<listAll.size()确定了只能访问到listAll有的对象,即使访问第三第四页也不会造成下标越界
            for(int i = (index-1)*5 , j = 1;i<listAll.size()&&j<=5;i++,j++){
                list.add(listAll.get(i));
            }
        }
        model.addAttribute("list",list);
        return "List";
    }

    @RequestMapping(value = "/createimg",method = RequestMethod.POST)
    public String  createimg(HttpServletRequest request, HttpServletResponse response,@RequestParam("image") MultipartFile image){
        if(!image.isEmpty()){
            try{
//                String ulurl = request.getServletContext().getRealPath("/Picture");
                String ulurl = "/Users/weisong5653/IdeaProjects/ad_pre6/src/main/webapp/Picture";
                File img = new File(ulurl);
                if(!img.exists()){
                    img.mkdir();
                }
                if(image.getSize()>400000){
                    throw new ImageException("超过图片限制大小(不大于40MB)");
                }
                String imgurl = FilenameUtils.concat(ulurl,image.getOriginalFilename());
                image.transferTo(new File(imgurl));

            }catch (ImageException ie){
                logger.debug(ie.getMessage());
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }

        StringBuilder sb = new StringBuilder(request.getParameter("title"));
        StringBuilder imapath = new StringBuilder(image.getOriginalFilename());
        int count = imageService.createimg(imapath.toString(),sb.toString(),"liweisong");
        logger.debug("插入"+count+"条数据");
        return "List";
    }

    @RequestMapping(value = "/todetail",method = RequestMethod.POST)
    public String todetail(@RequestBody Image image, Model model,HttpServletRequest request){
//        model.addAttribute("image",image);
//        request.setAttribute("image",image);
        HttpSession session=request.getSession();
        session.setAttribute("image",image);
        return "detail";
    }
}
