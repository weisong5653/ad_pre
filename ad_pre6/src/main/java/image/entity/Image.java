package image.entity;

public class Image {
    private int imgid;
    private String imgpath;
    private String imgtitle;
    private String imgissuer;


    public void setImgpath(String imgpath) {

        this.imgpath = imgpath;
    }


    public void setImgid(int imgid) {
        this.imgid = imgid;
    }

    public void setImgtitle(String imgtitle) {
        this.imgtitle = imgtitle;
    }

    public void setImgissuer(String imgissuer) {
        this.imgissuer = imgissuer;
    }

    public String getImgpath() {
        return imgpath;
    }

    public int getImgid() {
        return imgid;
    }

    public String getImgtitle() {
        return imgtitle;
    }

    public String getImgissuer() {
        return imgissuer;
    }
    @Override
    public String toString() {
        return "Image{" +
                "imgid=" + imgid +
                ", imgpath='" + imgpath + '\'' +
                ", imgtitle='" + imgtitle + '\'' +
                ", imgissuer='" + imgissuer + '\'' +
                '}';
    }

}
