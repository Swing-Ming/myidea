import com.kaishengit.pojo.Dept;
import com.kaishengit.pojo.Employee;
import com.kaishengit.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.junit.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HibernateOneToManyTestCase {

    @Test
    public void insertTest(){
        Session session = HibernateUtil.getSession();
        session.beginTransaction();


        Dept dept = new Dept();
        dept.setDeptname("H5");


        Employee employee = new Employee();
        employee.setEmpname("lili");
        employee.setDept(dept);

        Employee employee1 = new Employee();
        employee1.setEmpname("hary");
        employee1.setDept(dept);

        Set<Employee> employeeSet = new HashSet<Employee>();
        employeeSet.add(employee);
        employeeSet.add(employee1);

        dept.setEmployeeSet(employeeSet);

        //三条insert语句
        //若改变顺序则会多出 update 语句
        session.save(dept);
        session.save(employee);
        session.save(employee1);

        session.getTransaction().commit();
    }

    @Test
    public void findOneTest(){
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        Dept dept = (Dept) session.get(Dept.class,21);
        System.out.println(dept);
        //通过获取deptid 在employee表中查询出员工
        Set<Employee> employees = dept.getEmployeeSet();
        for(Employee employee : employees){
            System.out.println(employee.getEmpname());
        }

        session.getTransaction();
    }

    @Test
    public void findAllTest(){
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Employee.class);//只能根据特定的类查询
        //在查询所有时小心 N+1 的出现 在多的配置文件中添加 fetch = join 属性
        List<Employee> employeeList = criteria.list();
        for(Employee employee : employeeList){
            System.out.println(employee.getId() +":"+employee.getEmpname()+":"+employee.getDept().getDeptname());
        }

        session.getTransaction().commit();

    }

    @Test
    public void deleteTest(){

        //级联删除
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        Dept dept = (Dept) session.get(Dept.class,20);

        session.delete(dept);

        session.getTransaction().commit();
    }


}
