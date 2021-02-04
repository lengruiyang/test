package cn.huiounet.service.impl;

import cn.huiounet.common.AppException;
import cn.huiounet.dao.app.UpdateSysPojoMapper;
import cn.huiounet.pojo.app.UpdateSysPojo;
import cn.huiounet.service.UpdateSysPojoService;
import com.alibaba.druid.filter.AutoLoad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 作者 ：冷瑞阳
 * 首次编辑时间 ：2021/1/22 10:48
 */
@Service
public class UpdateSysPojoServiceImpl implements UpdateSysPojoService {
    @Autowired(required = false)
    private UpdateSysPojoMapper updateSysPojoMapper;

    @Override
    public List<UpdateSysPojo> findByVersion(String version)throws AppException {
        List<UpdateSysPojo> byVersion = updateSysPojoMapper.findByVersion(version);
        if(byVersion.size() == 0){
            throw new AppException("未找到该版本更新信息");
        }
        return byVersion;
    }
}
