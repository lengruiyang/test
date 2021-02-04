package cn.huiounet.service;

import cn.huiounet.pojo.app.DaoHangPojo;

import java.util.List;

/**
 * 作者 ：冷瑞阳
 * 首次编辑时间 ：2021/1/31 16:23
 */
public interface DaoHangPojoService {
    /**
     * 寻找导航链接
     * @return
     */
    List<DaoHangPojo> findAll();
}
