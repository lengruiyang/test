package cn.huiounet.service;

import cn.huiounet.pojo.app.LunBoImgPojo;

import java.util.List;

/**
 * 作者 ：冷瑞阳
 * 首次编辑时间 ：2021/1/31 16:13
 */
public interface LunBoImgPojoService {
    /**
     * 得到全部轮播图
     * @return
     */
    List<LunBoImgPojo> findAll();
}
