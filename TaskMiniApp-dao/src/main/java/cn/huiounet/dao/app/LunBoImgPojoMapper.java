package cn.huiounet.dao.app;

import cn.huiounet.pojo.app.LunBoImgPojo;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * 作者 ：冷瑞阳
 * 首次编辑时间 ：2021/1/31 16:11
 */
public interface LunBoImgPojoMapper extends Mapper<LunBoImgPojo> {

    /**
     * 得到全部轮播图
     * @return
     */
    List<LunBoImgPojo> findAll();
}
