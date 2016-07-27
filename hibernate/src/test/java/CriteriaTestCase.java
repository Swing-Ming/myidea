
import com.kaishengit.pojo.User;
import com.kaishengit.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.*;
import org.junit.Test;

import java.util.List;

public class CriteriaTestCase {

    @Test
    public void Criteria(){

        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(User.class);
        List<User> userList  =  criteria.list();

        for(User user : userList){
            System.out.println(user);
        }
        session.getTransaction().commit();

    }

    @Test
    public void findTest(){
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(User.class);

        /*criteria.add(Restrictions.eq("username","Rose"));
        criteria.add(Restrictions.eq("password","222222"));
        User user = (User) criteria.uniqueResult();
        System.out.println(user);*/

        //LIKE
        /*criteria.add(Restrictions.like("username","o",MatchMode.ANYWHERE));*/

        //in
        criteria.add(Restrictions.in("username",new Object[]{"rose","Jack"}));


        //OR
        Disjunction disjunction = Restrictions.disjunction();
        disjunction.add(Restrictions.eq("username","rose"));
        disjunction.add(Restrictions.eq("username","Jack"));

        criteria.add(disjunction);

        //or

        criteria.add(Restrictions.or(Restrictions.eq("username","rose"),
                                    Restrictions.eq("username","Jack")
                                    ));

        List<User> userList = criteria.list();
        for(User user : userList){
            System.out.println(user);
        }

        session.getTransaction().commit();

    }

    @Test
    public void pageTest(){
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(User.class);
        criteria.addOrder(Order.asc("id"));//排序

        criteria.setFirstResult(0);
        criteria.setMaxResults(3);

        List<User> userList = criteria.list();
        for(User user : userList){
            System.out.println(user);
        }

        session.getTransaction().commit();
    }

    @Test
    public void testCount(){
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(User.class);
        criteria.setProjection(Projections.rowCount());//count(*)
        criteria.setProjection(Projections.count("id"));//count(column)

        ProjectionList projectionList = Projections.projectionList();
        projectionList.add(Projections.rowCount());
        projectionList.add(Projections.count("id"));

        criteria.setProjection(projectionList);


        Object[] objects = (Object[]) criteria.uniqueResult();

        System.out.println("Count"+ objects[0]);
        System.out.println("Count"+ objects[1]);



        session.getTransaction().commit();
    }


}
