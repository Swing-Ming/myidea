import com.kaishengit.mapper.NodeMapper;
import com.kaishengit.mapper.TopicMapper;
import com.kaishengit.pojo.Node;
import com.kaishengit.pojo.Topic;
import com.kaishengit.util.MybaitsUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NodeTestCase {
    Logger logger = LoggerFactory.getLogger(TopicTestCase.class);
    @Test
    public  void findByIdTest(){
        SqlSession sqlSession = MybaitsUtil.getSqlSession();
        NodeMapper nodeMapper = sqlSession.getMapper(NodeMapper.class);
        Node node = nodeMapper.findById(1);
         node = nodeMapper.findById(1);
         node = nodeMapper.findById(1);
         node = nodeMapper.findById(1);
         node = nodeMapper.findById(1);

        logger.debug("{}",node);
        sqlSession.close();
    }
}
