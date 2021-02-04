package cn.huiounet.web.task;

import cn.huiounet.common.access_token.GetTokenUtil;
import cn.huiounet.common.redis.RedisUtil;
import cn.huiounet.pojo.app.AppSysPojo;
import cn.huiounet.service.AppSysPojoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 作者 ：冷瑞阳
 * 首次编辑时间 ：2021/1/21 23:56
 */
@RestController
@RequestMapping("/token")
public class TaskController {
    @Autowired
    private AppSysPojoService appSysPojoService;

    /**
     * 定时获取token
     */
    @org.springframework.scheduling.annotation.Scheduled(cron = "0 0 0/1 * * ?")
    public void setWxToken() throws Exception{
        AppSysPojo byId = appSysPojoService.findById(1);
        String token_wx = GetTokenUtil.getToken_wx(byId.getApp_id(),byId.getApp_key());
        RedisUtil.redisSetString(byId.getApp_id(),token_wx,false,0);
    }

    @GetMapping("/token")
    public Map getWxToken() throws Exception{
        AppSysPojo byId = appSysPojoService.findById(1);
        String token_wx = GetTokenUtil.getToken_wx(byId.getApp_id(),byId.getApp_key());
        Map map = new HashMap();
        map.put("code","200");
        map.put("token",token_wx);
        return map;
    }
}
