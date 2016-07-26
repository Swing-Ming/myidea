import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.context.transaction.AfterTransaction;
import redis.clients.jedis.Jedis;

public class TestRedisCase {

    private Jedis jedis = null;
    @Before
    public void before(){
        jedis = new Jedis("192.168.5.128");
    }
    @After
    public void after(){
       jedis.close();
    }

    @Test
    public void setTest(){

        jedis.set("name:1:read","tom");

    }
    @Test
    public void getTest(){

        System.out.println(jedis.get("name:2:read"));
    }


}
