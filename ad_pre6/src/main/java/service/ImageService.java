package service;

import image.entity.Image;

import java.util.List;

public interface ImageService {
    public int createimg(String imgpath,String imgtitle,String imgissuer);
    public List<Image> queryAll();

}
