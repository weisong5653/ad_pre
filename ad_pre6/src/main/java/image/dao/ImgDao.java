package image.dao;

import image.entity.Image;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ImgDao {
    public String queryimgpath(String imgid);
    public String queryimgid();
    public String queryimgtitle();
    public String queryimgissuer();
    public List<Image> queryAll();
    public Image queryimage(int imgid);
    public int createimg(@Param("imgpath") String imgpath, @Param("imgtitle") String imgtitle, @Param("imgissuer") String imgissuer);
}
