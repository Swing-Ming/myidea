import com.kaishengit.pojo.Student;
import com.kaishengit.pojo.Teacher;
import com.kaishengit.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.junit.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HibernateManyToManyTestCase {

    @Test
    public void save(){

        Session session = HibernateUtil.getSession();
        session.beginTransaction();

        Student student1 = new Student();
        student1.setStuname("s1");

        Student student2 = new Student();
        student2.setStuname("s2");

        Teacher teacher1 = new Teacher();
        teacher1.setTeaname("t1");

        Teacher teacher2 = new Teacher();
        teacher2.setTeaname("t2");

        Set<Student> studentSet = new HashSet<Student>();
        studentSet.add(student1);
        studentSet.add(student2);

        Set<Teacher> teacherSet = new HashSet<Teacher>();
        teacherSet.add(teacher1);
        teacherSet.add(teacher2);


        teacher1.setStudentSet(studentSet);
        teacher2.setStudentSet(studentSet);
        student1.setTeacherSet(teacherSet);
        student2.setTeacherSet(teacherSet);

        session.save(student1);
        session.save(student2);
        session.save(teacher1);
        session.save(teacher2);

        session.getTransaction().commit();
    }

    @Test
    public void findTest(){
        Session session = HibernateUtil.getSession();
        session.beginTransaction();

        Teacher teacher = (Teacher) session.get(Teacher.class,25);
        System.out.println(teacher.getId());
        Set<Student> studentSet = teacher.getStudentSet();

        for(Student student : studentSet){
            System.out.println(student.getStuname());
        }


        session.getTransaction().commit();

    }
}
