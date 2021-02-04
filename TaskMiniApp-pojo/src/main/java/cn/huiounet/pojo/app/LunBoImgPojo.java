package cn.huiounet.pojo.app;

import javax.persistence.Table;
import java.io.Serializable;

/**
 * 作者 ：冷瑞阳
 * 首次编辑时间 ：2021/1/31 16:07
 */
@Table(name = "huiou_lunbo_img")
public class LunBoImgPojo implements Serializable {
    private int id;
    private String image;
    private String do_things;
    private String status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDo_things() {
        return do_things;
    }

    public void setDo_things(String do_things) {
        this.do_things = do_things;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LunBoImgPojo() {
    }
}
