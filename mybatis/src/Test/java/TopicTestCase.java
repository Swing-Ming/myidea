import com.kaishengit.mapper.TopicMapper;
import com.kaishengit.pojo.Topic;
import com.kaishengit.util.MybaitsUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class TopicTestCase {

    Logger logger = LoggerFactory.getLogger(TopicTestCase.class);
    @Test
    public  void findByIdTest(){
        SqlSession sqlSession = MybaitsUtil.getSqlSession();
        TopicMapper topicMapper = sqlSession.getMapper(TopicMapper.class);
        Topic topic = topicMapper.findById(1);
        logger.debug("Username:{}",topic.getUser().getName());
    }


}
