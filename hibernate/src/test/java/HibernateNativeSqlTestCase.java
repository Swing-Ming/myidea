import com.kaishengit.pojo.User;
import com.kaishengit.util.HibernateUtil;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.SQLCriterion;
import org.junit.Test;

import java.util.List;

public class HibernateNativeSqlTestCase {

    @Test
    public void nativeTest(){
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        String sql = "select * from t_user";
       /* SQLQuery query = session.createSQLQuery(sql);*/

        SQLQuery query = session.createSQLQuery(sql).addEntity(User.class);
        List<User> userList = query.list();
        for(User user : userList){
            System.out.println(user);
        }

        session.getTransaction().commit();
    }



}
