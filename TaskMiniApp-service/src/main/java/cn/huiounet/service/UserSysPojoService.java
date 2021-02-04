package cn.huiounet.service;

import cn.huiounet.common.AppException;
import cn.huiounet.pojo.user.UserSysPojo;

/**
 * 作者 ：冷瑞阳
 * 首次编辑时间 ：2021/1/21 19:56
 */
public interface UserSysPojoService {

    /**
     *
     * @param id 用户ID
     * @return 用户信息
     */
    UserSysPojo findById(int id)throws AppException;


    /**
     *
     * @param open_id 用户openId
     * @return 用户信息
     */
    UserSysPojo findByOpenId(String open_id)throws AppException;

    /**
     *
     * @param userSysPojo 保存用户
     */
    void saveUser(UserSysPojo userSysPojo);
}
