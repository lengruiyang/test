package cn.huiounet.service.impl;

import cn.huiounet.dao.app.DaoHangPojoMapper;
import cn.huiounet.pojo.app.DaoHangPojo;
import cn.huiounet.service.DaoHangPojoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 作者 ：冷瑞阳
 * 首次编辑时间 ：2021/1/31 16:24
 */
@Service
public class DaoHangPojoServiceImpl implements DaoHangPojoService {
    @Autowired(required = false)
    private DaoHangPojoMapper daoHangPojoMapper;

    @Override
    public List<DaoHangPojo> findAll() {
        return daoHangPojoMapper.findAll();
    }
}
