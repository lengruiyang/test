package cn.huiounet.dao.app;

import cn.huiounet.pojo.app.UpdateSysPojo;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * 作者 ：冷瑞阳
 * 首次编辑时间 ：2021/1/22 10:39
 */
public interface UpdateSysPojoMapper extends Mapper<UpdateSysPojo> {


    /**
     * 根据版本查找
     * @param version 版本
     * @return 返回版本更新详情
     */
    List<UpdateSysPojo> findByVersion(String version);

}
