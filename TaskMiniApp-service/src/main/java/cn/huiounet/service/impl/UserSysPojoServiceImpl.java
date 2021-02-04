package cn.huiounet.service.impl;

import cn.huiounet.common.AppException;
import cn.huiounet.dao.user.UserSysPojoMapper;
import cn.huiounet.pojo.user.UserSysPojo;
import cn.huiounet.service.UserSysPojoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 作者 ：冷瑞阳
 * 首次编辑时间 ：2021/1/21 19:57
 */
@Service
public class UserSysPojoServiceImpl implements UserSysPojoService {
    @Autowired(required = false)
    private UserSysPojoMapper userSysPojoMapper;

    @Override
    public UserSysPojo findById(int id) throws AppException{
        if(userSysPojoMapper.findById(id) == null){
            throw new AppException("未找到用户");
        }
        UserSysPojo byId = userSysPojoMapper.findById(id);
        return byId;
    }

    @Override
    public UserSysPojo findByOpenId(String open_id)throws AppException {
        if(userSysPojoMapper.findByOpenId(open_id) == null){
            throw new AppException("未找到用户");
        }
        UserSysPojo byOpenId = userSysPojoMapper.findByOpenId(open_id);
        return byOpenId;
    }

    @Override
    public void saveUser(UserSysPojo userSysPojo) {
        userSysPojoMapper.insert(userSysPojo);
    }
}
