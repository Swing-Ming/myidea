import com.google.common.collect.Maps;
import com.kaishengit.pojo.User;
import com.kaishengit.util.MybaitsUtil;
import com.kaishengit.mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.apache.ibatis.io.Resources;

import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.Map;

public class MybatisTestCase {
    private Logger logger = LoggerFactory.getLogger(MybatisTestCase.class);
    @Test
    public void testLoadxml() {
//        1.从classpath路径中读取mybaits配置文件
//       try {
//            Reader reader = Resources.getResourceAsReader("mybatis.xml");
//        2.构建sqlsessionFactory，通过new sqlSessionFactoryBuilder（）；
//            SqlSessionFactory sqlSessionFactory  = new SqlSessionFactoryBuilder().build(reader);
//        3.创建SqlSession对象执行CRUD
//            SqlSession sqlSession = sqlSessionFactory.openSession();
//        CURD
//        str : namespace+id

        SqlSession sqlSession =MybaitsUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.findById(8);
//        User user = sqlSession.selectOne("com.kaishengit.mapper.UserMapper.findById", 8);
        logger.debug("{}", user);

        sqlSession.close();


        Assert.assertNotNull(user);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

    }
    @Test
    public void update() {
        SqlSession sqlSession = MybaitsUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.findById(8);
        user.setName("lilei");
        user.setPassword("0000079");
        userMapper.update(user);
        sqlSession.commit();
        sqlSession.close();
//        User user = sqlSession.selectOne("com.kaishengit.mapper.UserMapper.findById",8);
//        user.setName("lili");
//        user.setPassword("123123123");
//        System.out.println(user);
//        sqlSession.update("com.kaishengit.mapper.UserMapper.update",user);
//        sqlSession.commit();
//        sqlSession.close();
    }

    @Test
    public void insert(){
        SqlSession sqlSession = MybaitsUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setName("lax");
        user.setPassword("000127");
        userMapper.insert(user);
        logger.debug("{}",user.getId());


//        User user = new User();
//        user.setName("alex");
//        user.setPassword("00001");
//        sqlSession.insert("com.kaishengit.mapper.UserMapper.insert",user);
        sqlSession.commit();
        sqlSession.close();

    }
    @Test
    public void delete(){
        SqlSession sqlSession = MybaitsUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        userMapper.del(5);
//        sqlSession.delete("com.kaishengit.mapper.UserMapper.del",3);
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void findAll(){
        SqlSession sqlSession = MybaitsUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = userMapper.findAll();
        for (User user :
                userList) {
            logger.debug("{}",user);

        }
        sqlSession.close();
        Assert.assertEquals(13,userList.size());
//        List<User> userlist =  sqlSession.selectList("com.kaishengit.mapper.UserMapper.findAll");
//        for(User user : userlist){
//            logger.debug("{}",user);
//
//        }
//        sqlSession.close();
//        Assert.assertEquals(13,userlist.size());
    }
    @Test
    public void findByQueryParam(){
        SqlSession sqlSession = MybaitsUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
//            User user = new User();
//        user.setName("yi");
//        user.setPassword("000012");
        Map<String,Object> queryParam = Maps.newHashMap();
        queryParam.put("name","jack");
        queryParam.put("password","000088");
        userMapper.finByObj(queryParam);
        sqlSession.close();
    }
    @Test
    public void findByParam(){
        SqlSession sqlSession = MybaitsUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        userMapper.findByParam("tom","111111");

    }

}
