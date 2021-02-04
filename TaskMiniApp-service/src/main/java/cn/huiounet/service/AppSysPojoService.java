package cn.huiounet.service;

import cn.huiounet.common.AppException;
import cn.huiounet.pojo.app.AppSysPojo;

public interface AppSysPojoService {

    /**
     * @return 小程序信息
     */
    AppSysPojo findById(int id)throws AppException;
}
