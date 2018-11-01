package service.impl;

import image.dao.ImgDao;
import image.entity.Image;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.ImageService;

import java.util.List;

@Service
public class ImageServiceImp implements ImageService {
    @Autowired
    ImgDao imgDao;

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    public int createimg(String imgpath, String imgtitle, String imgissuer) {
        int total = imgDao.createimg(imgpath,  imgtitle,  imgissuer);
        return total;
    }

    public List<Image> queryAll() {
        List<Image> list = imgDao.queryAll();
        if(list.size()==0){
            logger.debug("查询到0张图片");
        }
        return list;
    }
}
