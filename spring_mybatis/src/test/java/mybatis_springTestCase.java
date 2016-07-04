import com.kaishengit.pojo.User;
import com.kaishengit.service.LoginService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:ApplicationContext.xml")
public class mybatis_springTestCase {
    @Inject
    private LoginService loginService;
    @Test
    public void testCase(){

       loginService.loginService("admin","admin","111.123.0.1");
    }


}
