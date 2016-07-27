import com.kaishengit.pojo.Task;
import com.kaishengit.util.HibernateUtil;
import org.hibernate.Session;
import org.junit.Test;

public class HibernateTaskTestcase {

    @Test
    public void taskTest(){
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        Task task  = new Task();

        task.setTitle("xxxx");
        session.save(task);

        session.getTransaction().commit();
    }

    @Test
    public void findTest(){
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        Task task = (Task) session.get(Task.class,"4028b481562c739101562c73945e0000");
        System.out.println(session.contains(task));
        //session.clear();清除所有session总的缓存
    /*    session.evict(task);//清楚国定的缓存*/

        /*Task task1 = (Task) session.get(Task.class,"4028b481562c739101562c73945e0000");*/


        session.getTransaction().commit();

        Session session1 = HibernateUtil.getSession();
        session1.beginTransaction();
        session1.get(Task.class,"4028b481562c739101562c73945e0000");

        session1.getTransaction().commit();
    }
}
