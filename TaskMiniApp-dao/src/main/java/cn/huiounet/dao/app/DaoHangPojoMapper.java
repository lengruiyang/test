package cn.huiounet.dao.app;

import cn.huiounet.pojo.app.DaoHangPojo;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * 作者 ：冷瑞阳
 * 首次编辑时间 ：2021/1/31 16:21
 */
public interface DaoHangPojoMapper extends Mapper<DaoHangPojo> {

    /**
     * 寻找导航链接
     * @return
     */
    List<DaoHangPojo> findAll();
}
