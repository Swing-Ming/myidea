import com.google.common.collect.Lists;
import com.kaishengit.mapper.NodeMapper;
import com.kaishengit.mapper.UserMapper;
import com.kaishengit.pojo.User;
import com.kaishengit.util.MybaitsUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class MybatisNodeTestCase {
    Logger logger = LoggerFactory.getLogger(MybatisTestCase.class);
    @Test
    public void bathSaves(){
        SqlSession sqlSession = MybaitsUtil.getSqlSession();
        NodeMapper nodeMapper = sqlSession.getMapper(NodeMapper.class);
        List<User> userList = Lists.newArrayList();

        userList.add(new User("lili","123"));
        userList.add(new User("tom","1"));
        userList.add(new User("jim","2"));
        userList.add(new User("lx","3"));
        userList.add(new User("lucy","4"));
        nodeMapper.bathSave(userList);
        sqlSession.commit();
        sqlSession.close();

    }
    @Test
    public void del(){
        SqlSession sqlSession = MybaitsUtil.getSqlSession();
       NodeMapper nodeMapper = sqlSession.getMapper(NodeMapper.class);
       List<Integer> nodeList = Lists.newArrayList(13,14);


        nodeMapper.del(nodeList);

        sqlSession.commit();
        sqlSession.close();



    }
}
