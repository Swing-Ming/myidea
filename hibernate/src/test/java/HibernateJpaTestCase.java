import com.kaishengit.pojo.User;
import com.kaishengit.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.Test;

import java.util.List;

public class HibernateJpaTestCase {

    @Test
    public void testInsert(){

        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        User user = new User();
        user.setUsername("赵wang武");
        user.setPassword("1111111");
        session.save(user);
        session.clear();

        session.delete(user);



       /* session.persist(user);*/
       /*Integer integer = (Integer) session.save(user);*/
       /* System.out.println(integer);*/





        /*User user= (User) session.get(User.class,62);
        System.out.println(user.getUsername() +":"+user.getPassword());*/

      /*  User user = (User) session.load(User.class,62);
        System.out.println(user.toString());*/


        session.getTransaction().commit();

       /* System.out.println(user.toString());




        Session session1 = HibernateUtil.getSession();
        session1.beginTransaction();

        user.setUsername("李思");
        session1.merge(user);
        System.out.println(user.getId());
        System.out.println(user.getUsername());
        session1.getTransaction().commit();
*/

    }

    @Test
    public void queryTest(){
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        String hql = "from User where password = ?";
        Query query = session.createQuery(hql);

            query.setParameter(0,"00000");
           /* User user = (User) query.uniqueResult();*/
        List<User> userList = query.list();
        for(User user : userList){
            System.out.println(user.getUsername()+":"+user.getPassword());
        }
        session.getTransaction();
    }

    @Test
    public void selectOneColumn(){
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        String hql = "select username from User";
        Query query = session.createQuery(hql);
        List<String> result = query.list();
        System.out.println(result);


        session.getTransaction();

    }

    @Test
    public void selectLotsColumn(){
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        String hql = "select id , username from User";
        Query query = session.createQuery(hql);
        List<Object[]> result = query.list();
        for (Object[] obj : result){
            System.out.println(obj[0]+":"+obj[1]);
        }
        session.getTransaction();

    }

    @Test
    public void count(){
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        String hql = "select count(*),id from User";
        Query query = session.createQuery(hql);

      /*  Long result = (Long) query.uniqueResult();*/
     /*   Object[] objects = (Object[]) query.uniqueResult();*/
        List<Object[]> objects = query.list();
        for(Object[] obj : objects){

            System.out.println(obj[0] +":"+obj[1]);//不允许聚合函数 加多个列的值
        }

        session.getTransaction();

    }

    @Test
    public void pageTest(){

        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        String hql = "from User order by id desc ";
        Query query = session.createQuery(hql);

        query.setFirstResult(0);
        query.setMaxResults(3);

        List<User>  userList = query.list();
        for(User user : userList){
            System.out.println(user.toString());
        }

        session.getTransaction().commit();


    }

    //面向对象查询
    @Test
    public void criteriaTest(){
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        String hql = "from User where id = ?";
        Query   query  = session.createQuery(hql);
        query.setParameter(0,52);

        User user = (User) query.uniqueResult();
        user.getUsername();
        session.update(user);
       /* session.flush();*/

        query.uniqueResult();

        session.getTransaction().commit();

        /*Session session1 = HibernateUtil.getSession();
        session1.beginTransaction();

        user.setUsername("aaaaa11111k11234");

        session1.update(user);
        System.out.println(user.getUsername());
        session1.flush();


        session1.getTransaction().commit();
*/
    }


}
