import com.kaishengit.pojo.Card;
import com.kaishengit.pojo.Person;
import com.kaishengit.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.junit.Test;

import java.util.List;

public class HibernateOneToOneTestCase {

    @Test
    public void insert() {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();

        Person person = new Person();
        person.setName("张三");

        Card card = new Card();
        card.setCardname("vip-0000");
        card.setPerson(person);

        session.save(card);
        session.save(person);

        session.getTransaction().commit();
    }


    @Test
    public void findTest() {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();

        Person person = (Person) session.get(Person.class, 12);
        System.out.println(person.getName() + ":" + person.getCard().getCardname());

        session.getTransaction().commit();
    }

    @Test
    public void findAllTest() {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Person.class);
        List<Person> personList = criteria.list();

        for (Person person : personList) {
            System.out.println(person.getName() + ":" + person.getCard().getCardname());
        }

        session.getTransaction().commit();
    }



    @Test
    public void deleteCard() {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        Card card = (Card) session.get(Card.class, 11);
        session.delete(card);


        session.getTransaction().commit();
    }

    @Test
    public void deletePerson() {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();

        Person person = (Person) session.get(Person.class, 11);
        session.delete(person);

        session.getTransaction().commit();
    }


}
