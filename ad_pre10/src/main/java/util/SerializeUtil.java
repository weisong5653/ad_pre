package util;

import dto.UserTokenDto;

import java.io.*;

/**
 * 序列化工具类
 * @author weisong
 * @date 2018/12/10 7:36 PM
 */
public class SerializeUtil {
    /**
     * 序列化UserTokenDto
     * @param object
     * @return
     */
    public static byte[] serialize(Object object){
        ByteArrayOutputStream baos = null;
        ObjectOutputStream oos = null;
        byte[] bytes = null;
        try {
            baos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(baos);
            oos.writeObject(object);
            bytes = baos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bytes;
    }

    /**
     * 反序列化UserTokenDto
     * @param bytes
     * @return
     */
    public static Object unSerialize(byte[] bytes){
        ByteArrayInputStream bais = null;
        ObjectInputStream ois = null;
        try {
            bais = new ByteArrayInputStream(bytes);
            ois = new ObjectInputStream(bais);
            return ois.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
