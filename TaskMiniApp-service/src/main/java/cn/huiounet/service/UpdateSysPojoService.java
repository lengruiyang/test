package cn.huiounet.service;

import cn.huiounet.common.AppException;
import cn.huiounet.pojo.app.UpdateSysPojo;

import java.util.List;

/**
 * 作者 ：冷瑞阳
 * 首次编辑时间 ：2021/1/22 10:48
 */
public interface UpdateSysPojoService {
    /**
     * 根据版本查找
     * @param version 版本
     * @return 返回版本更新详情
     */
    List<UpdateSysPojo> findByVersion(String version)throws AppException;
}
