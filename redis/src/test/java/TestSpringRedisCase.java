import com.sun.xml.internal.bind.annotation.XmlLocation;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class TestSpringRedisCase {

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void setTest(){
        ValueOperations valueOperations = redisTemplate.opsForValue();
        valueOperations.set("spring","spring-redis");

    }

    @Test
    public void getTest(){
        System.out.println(redisTemplate.opsForValue().get("name:1:reader"));
    }

    @Test
    public void incrbyTest(){
        redisTemplate.opsForValue().increment("name:3:read",3l);
        System.out.println(redisTemplate.opsForValue().get("name:3:read"));
    }


}
