import com.kaishengit.adminDao.AdminDao;
import com.kaishengit.pojo.Admin;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:ApplicationContext.xml")
public class jdbc_springTestCase {
    @Autowired
    private AdminDao adminDao;
    @Test
    public void testJdbc(){
        Admin admin = new Admin();
        admin.setName("lili");
        admin.setPwd("123123");

        adminDao.save(admin);




    }





}
