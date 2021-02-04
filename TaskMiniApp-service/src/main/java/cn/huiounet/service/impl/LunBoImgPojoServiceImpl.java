package cn.huiounet.service.impl;

import cn.huiounet.dao.app.LunBoImgPojoMapper;
import cn.huiounet.pojo.app.LunBoImgPojo;
import cn.huiounet.service.LunBoImgPojoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 作者 ：冷瑞阳
 * 首次编辑时间 ：2021/1/31 16:13
 */
@Service
public class LunBoImgPojoServiceImpl implements LunBoImgPojoService {
    @Autowired(required = false)
    private LunBoImgPojoMapper lunBoImgPojoMapper;

    @Override
    public List<LunBoImgPojo> findAll() {
        return lunBoImgPojoMapper.findAll();
    }
}
