package util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;


/**
 * 2018.11.13
 * 工具类
 */
public class FileUtil {

    /**
     * 下载Excel
     * @param filePath
     * @param fileName
     * @param request
     * @param response
     */
    public static void dowload(String filePath, String fileName, HttpServletRequest request, HttpServletResponse response){

        File file = new File(filePath);

        try {
            FileInputStream fis = new FileInputStream(file);
            BufferedInputStream bis = new BufferedInputStream(fis);
            byte[] buf = new byte[1024];

            int len=0;

//            response.reset();

            String filenameutf8 = URLEncoder.encode(fileName,"utf8");

            response.setContentType("utf8");
            response.setContentType("application/octet-stream");
            response.setHeader("Content-Disposition", "attachment; filename=" + filenameutf8);

            OutputStream os = response.getOutputStream();

            while ((len=bis.read(buf))!=-1){
                os.write(buf,0,len);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
