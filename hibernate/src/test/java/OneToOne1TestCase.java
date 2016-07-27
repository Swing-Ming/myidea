import com.kaishengit.pojo.Topic;
import com.kaishengit.pojo.TopicContent;
import com.kaishengit.util.HibernateUtil;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.junit.Test;

public class OneToOne1TestCase {

    @Test
    public void save(){
        Session session  = HibernateUtil.getSession();
        session.beginTransaction();

        Topic topic = new Topic();
        topic.setTitle("t1");

        TopicContent topicContent = new TopicContent();
        topicContent.setContent("aaaaaa");

        topicContent.setTopic(topic);
        topic.setTopicContent(topicContent);


        session.save(topic);
        session.save(topicContent);

        session.getTransaction().commit();

    }
   /* @Test
    public void save() {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();


        Topic topic = new Topic();
        topic.setTitle("t5");

        TopicContent topicContent = new TopicContent();
        topicContent.setContent("eeeeee");

        topic.setTopicContent(topicContent);
        topicContent.setTopic(topic);

        session.save(topic);
        session.save(topicContent);
        session.getTransaction().commit();

    }*/

    @Test
    public void findTest() {

        Session session = HibernateUtil.getSession();
        session.beginTransaction();

        Topic topic = (Topic) session.get(Topic.class, 25);


       /* System.out.println(topic.getTopicContent().getContent());*/
        Hibernate.initialize(topic.getTopicContent());

        session.getTransaction().commit();

    }

    @Test
    public void deleteTest() {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();

        Topic topic = (Topic) session.get(Topic.class, 11);
        System.out.println(topic);
        session.delete(topic);

        session.getTransaction().commit();
    }

}
