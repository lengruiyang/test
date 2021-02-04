package cn.huiounet.pojo.app;

import javax.persistence.Table;
import java.io.Serializable;

/**
 * 作者 ：冷瑞阳
 * 首次编辑时间 ：2021/1/22 10:36
 */
@Table(name = "huiou_update_sys")
public class UpdateSysPojo implements Serializable {
    private int id;
    private String version;
    private String update_sb;//更新详情
    private String create_time;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getUpdate_sb() {
        return update_sb;
    }

    public void setUpdate_sb(String update_sb) {
        this.update_sb = update_sb;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    @Override
    public String toString() {
        return "UpdateSysPojo{" +
                "id=" + id +
                ", version='" + version + '\'' +
                ", update_sb='" + update_sb + '\'' +
                ", create_time='" + create_time + '\'' +
                '}';
    }

    public UpdateSysPojo() {
    }
}
