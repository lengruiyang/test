package cn.huiounet.pojo.app;

import javax.persistence.Table;
import java.io.Serializable;

/**
 * 作者 ：冷瑞阳
 * 首次编辑时间 ：2021/1/31 16:19
 */
@Table(name = "huiou_daohang")
public class DaoHangPojo implements Serializable {
    private int id;
    private String daohang_img;
    private String to_do;
    private String status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDaohang_img() {
        return daohang_img;
    }

    public void setDaohang_img(String daohang_img) {
        this.daohang_img = daohang_img;
    }

    public String getTo_do() {
        return to_do;
    }

    public void setTo_do(String to_do) {
        this.to_do = to_do;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public DaoHangPojo() {
    }
}
