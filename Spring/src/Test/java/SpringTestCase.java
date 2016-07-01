import com.kaishengit.dao.User;
import com.kaishengit.dao.UserDao;
import com.kaishengit.service.Bookservice;
import com.kaishengit.service.Userservice;
import org.junit.Test;
import org.omg.CORBA.portable.ApplicationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.awt.print.Book;


public class SpringTestCase {

    Logger logger = LoggerFactory.getLogger(SpringTestCase.class);

    @Test
    public void userDaoTestCase(){
        ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");

       Userservice userservice = (Userservice) context.getBean("userservice");
        userservice.start();



        /* Bookservice bookservice = (Bookservice) context.getBean("bookservice");
       bookservice.show();*/


/*        UserDao userDao = (UserDao) context.getBean("mydao");

        UserDao userDao2 = (UserDao) context.getBean("mydao");

        System.out.println(userDao == userDao2);*/




    }


}
