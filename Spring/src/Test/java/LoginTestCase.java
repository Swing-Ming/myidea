import com.kaishengit.service.LoginService;
import com.kaishengit.service.Userservice;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:ApplicationContext.xml")
public class LoginTestCase {
    @Inject
    private LoginService loginService;
    @Test
    public void testLogin(){
        loginService.login("admin","admin","111.168.1.1");
    }


}
