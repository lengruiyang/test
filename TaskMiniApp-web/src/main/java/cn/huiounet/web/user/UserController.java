package cn.huiounet.web.user;

import cn.huiounet.common.AppException;
import cn.huiounet.common.RequestReturn;
import cn.huiounet.common.http.HttpRequest;
import cn.huiounet.common.redis.RedisUtil;
import cn.huiounet.common.send_message.RamNumberUtil;
import cn.huiounet.common.send_message.SendMessageUtil;
import cn.huiounet.pojo.app.AppSysPojo;
import cn.huiounet.pojo.user.UserSysPojo;
import cn.huiounet.service.AppSysPojoService;
import cn.huiounet.service.UserSysPojoService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 作者 ：冷瑞阳
 * 首次编辑时间 ：2021/1/21 20:24
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserSysPojoService userSysPojoService;
    @Autowired
    private AppSysPojoService appSysPojoService;

    @PostMapping("/request/findByUserId")
    public Map getUserInfoById(String id){
        int i = Integer.parseInt(id);
        UserSysPojo byId = null;
        try {
            byId = userSysPojoService.findById(i);
        } catch (AppException e) {
            e.printStackTrace();
            return RequestReturn.getReturn(true,"未找到用户或未登录","002","");
        }
        return RequestReturn.getReturn(false,"","200",byId);
    }

    @PostMapping("/request/findByUserOpenId")
    public Map getUserInfoByOpenId(String open_id){
        UserSysPojo byId = null;
        try {
            byId = userSysPojoService.findByOpenId(open_id);
        } catch (AppException e) {
            e.printStackTrace();
            return RequestReturn.getReturn(true,"未找到用户或未登录","002","");
        }
        return RequestReturn.getReturn(false,"","200",byId);
    }

    @PostMapping("/request/reg")
    public Map getOpenId(String code)throws Exception{
        AppSysPojo byId = appSysPojoService.findById(1);
        String jsonString = HttpRequest.sendGet("https://api.weixin.qq.com/sns/jscode2session", "appid=" + byId.getApp_id() + "&secret=" + byId.getApp_key() + "&js_code=" + code + "&grant_type=authorization_code");
        JSONObject json = JSONObject.fromObject(jsonString);
        String open_id = json.getString("openid");
        Map map = new HashMap();
        map.put("openId",open_id);
        map.put("code","200");
        return map;
    }

    @PostMapping("/request/sendMessage")
    public Map sendMessage(String phone){
        String randomStr = RamNumberUtil.getRandomStr(6, 0);
        String mess = null;
        try {
            mess = SendMessageUtil.getMess(phone, randomStr, "5");
        } catch (Exception e) {
            return RequestReturn.getReturn(true,"验证码发送失败"+e.getMessage(),"004","");
        }
        RedisUtil.redisSetString(phone,randomStr,true,300000);
        return RequestReturn.getReturn(false,"","200",mess);
    }

    @PostMapping("/request/saveUser")
    public Map saveUser(String code, String open_id,String nick_name,String user_head_img,
                        String phone_number,String sex,String fromUser){
        String s = RedisUtil.redisGetString(phone_number);
        if(!code.equals(s)){
            return RequestReturn.getReturn(true,"验证码错误","005","");
        }
        UserSysPojo userSysPojo = new UserSysPojo();
        userSysPojo.setNick_name(nick_name);
        userSysPojo.setSex(sex);
        userSysPojo.setUser_head_img(user_head_img);
        userSysPojo.setOpen_id(open_id);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = df.format(new Date());
        userSysPojo.setCreate_time(format);
        userSysPojo.setFrom_user(fromUser);
        userSysPojo.setPhone_number(phone_number);
        userSysPojo.setStatus("1");
        userSysPojoService.saveUser(userSysPojo);
        return RequestReturn.getReturn(false,"","200",userSysPojo);
    }
}
