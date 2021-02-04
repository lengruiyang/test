package cn.huiounet.dao.app;

import cn.huiounet.pojo.app.AppSysPojo;
import tk.mybatis.mapper.common.Mapper;

public interface AppSysPojoMapper extends Mapper<AppSysPojo> {

    /**
     * @return 小程序信息
     */
    AppSysPojo findById(int id);
}
