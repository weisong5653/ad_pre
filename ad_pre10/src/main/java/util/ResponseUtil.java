package util;

import net.sf.json.JSONObject;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 响应工具类
 * @author weisong
 * @date 2018/11/24 7:22 PM
 */
public class ResponseUtil {
    /**
     * 设置响应的类型
     * @param response
     * @return
     */
    public static void OutputData(HttpServletResponse response, JSONObject data){
        response.setContentType("application/json; charset=utf-8");
        PrintWriter out= null;
        try {
            out = response.getWriter();
            out.print(data.toString());
            System.out.println(data.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        out.flush();
        out.close();
    }
}
