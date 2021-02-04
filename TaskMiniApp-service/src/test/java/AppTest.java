import cn.huiounet.common.AppException;
import cn.huiounet.common.redis.RedisUtil;
import cn.huiounet.common.send_message.SendMessageUtil;
import cn.huiounet.pojo.app.AppSysPojo;
import cn.huiounet.pojo.user.UserSysPojo;
import cn.huiounet.service.AppSysPojoService;
import cn.huiounet.service.UserSysPojoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 作者 ：冷瑞阳
 * 首次编辑时间 ：2021/1/21 00:12
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:spring/applicationContext-*.xml")
public class AppTest {
    @Autowired
    private AppSysPojoService appSysPojoService;
    @Autowired
    private UserSysPojoService userSysPojoService;

    @Test
    public void test1()throws Exception{

    }
}
