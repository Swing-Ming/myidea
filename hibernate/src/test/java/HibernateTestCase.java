import com.kaishengit.pojo.User;
import com.kaishengit.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import org.hibernate.service.ServiceRegistry;
import org.junit.Test;

import java.util.List;

public class HibernateTestCase {

    @Test
    public void test(){
        Configuration configuration = new Configuration().configure();

        ServiceRegistry service = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        SessionFactory sessionFactory = configuration.buildSessionFactory(service);

        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        User user = new User();
        user.setUsername("lili");
        user.setPassword("123123");
        session.save(user);
        System.out.println(user.getId());

        transaction.commit();

    }

    @Test
    public void testSelect(){
        Session session =  HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        User user = (User) session.get(User.class,52);
        System.out.println(user.toString());
        session.getTransaction().commit();
    }

    @Test
    public void testUpdate(){
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        User user= (User) session.get(User.class,52);
        user.setUsername("李白");
        transaction.commit();
    }

    @Test
    public void testDelete(){
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        User user = (User) session.get(User.class,53);
        session.delete(user);


        transaction.commit();

    }

    @Test
    public void testSelectAll(){
        Session session = HibernateUtil.getSession();
       Transaction transaction = HibernateUtil.getSession().beginTransaction();
        String hql = "from User";
        Query query = session.createQuery(hql);
        List<User>  userList = query.list();

        for(User user : userList){
            System.out.println(user.getId() +":" + user.getUsername());
        }

        transaction.commit();

    }
}
