package cn.huiounet.service.impl;

import cn.huiounet.common.AppException;
import cn.huiounet.dao.app.AppSysPojoMapper;
import cn.huiounet.pojo.app.AppSysPojo;
import cn.huiounet.service.AppSysPojoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 作者 ：冷瑞阳
 * 首次编辑时间 ：2021/1/21 00:07
 */
@Service
public class AppSysPojoServiceImpl implements AppSysPojoService {
    @Autowired(required=false)
    private AppSysPojoMapper appSysPojoMapper;

    @Override
    public AppSysPojo findById(int id)throws AppException{
        if(appSysPojoMapper.findById(id) == null){
            throw new AppException("系统参数异常");
        }
        return appSysPojoMapper.findById(id);
    }
}
