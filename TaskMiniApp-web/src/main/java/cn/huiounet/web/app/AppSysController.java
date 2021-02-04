package cn.huiounet.web.app;

import cn.huiounet.common.AppException;
import cn.huiounet.common.RequestReturn;
import cn.huiounet.pojo.app.AppSysPojo;
import cn.huiounet.pojo.app.DaoHangPojo;
import cn.huiounet.pojo.app.LunBoImgPojo;
import cn.huiounet.pojo.app.UpdateSysPojo;
import cn.huiounet.service.AppSysPojoService;
import cn.huiounet.service.DaoHangPojoService;
import cn.huiounet.service.LunBoImgPojoService;
import cn.huiounet.service.UpdateSysPojoService;
import org.apache.poi.ss.formula.functions.T;
import org.apache.shiro.crypto.hash.Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 作者 ：冷瑞阳
 * 首次编辑时间 ：2021/1/21 00:56
 */
@RestController
@RequestMapping("/app")
public class AppSysController {
    @Autowired
    private AppSysPojoService appSysPojoService;
    @Autowired
    private UpdateSysPojoService updateSysPojoService;
    @Autowired
    private LunBoImgPojoService lunBoImgPojoService;
    @Autowired
    private DaoHangPojoService daoHangPojoService;

    /**
     *
     * @return 获取信息
     */
    @PostMapping("/request/sys")
    public Map getSysMessage(){
        AppSysPojo byId = null;
        try {
           byId  = appSysPojoService.findById(1);
        } catch (AppException e) {
            Map aReturn = RequestReturn.getReturn(true, e.getMessage(), "001", "");
            return aReturn;
        }
        Map aReturn = RequestReturn.getReturn(false, "", "", byId);
        return aReturn;
    }

    /**
     * 获取更新版本信息
     * @param version
     * @return
     */
    @PostMapping("/request/update")
    public Map getUpdateList(String version){
        List<UpdateSysPojo> byVersion = null;
        try {
           byVersion = updateSysPojoService.findByVersion(version);
        } catch (AppException e) {
           return RequestReturn.getReturn(true,e.getMessage(),"003","");
        }
        return RequestReturn.getReturn(false,"","200",byVersion);
    }

    /**
     * 获取轮播图信息
     * @param
     * @return
     */
    @PostMapping("/index/getLunBoImg")
    public Map getLunBoImg(){
      Map map = new HashMap();
      List<LunBoImgPojo> all = lunBoImgPojoService.findAll();
      map.put("code","200");
      map.put("data",all);
      return map;
    }

    /**
     * 获取导航图信息
     * @param
     * @return
     */
    @PostMapping("/index/getDaoHangImg")
    public Map getDaoHangImg(){
        Map map = new HashMap();
        List<DaoHangPojo> all = daoHangPojoService.findAll();
        map.put("code","200");
        map.put("data",all);
        return map;
    }
}
