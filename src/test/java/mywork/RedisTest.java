package mywork;

import com.czk.domain.SysUser;
import org.junit.Before;
import org.junit.Test;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

public class RedisTest {
    private RedisTemplate redisTemplate;

    @Before
    public void before(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:applicationContext-redis.xml");
        redisTemplate = ctx.getBean(RedisTemplate.class);

    }
    @Test
    public void test1(){

        SysUser user = new SysUser();
        user.setName("hisawadika");
        ValueOperations<String, SysUser> valueops = redisTemplate.opsForValue();
        valueops.set("1233",user);
    }

    @Test
    public void test2(){
        ValueOperations<String, SysUser> valueops = redisTemplate.opsForValue();
        System.out.println(valueops.get("123").getName());
    }

    @Test
    public void test3(){

        SysUser user = new SysUser();
        user.setName("hisawadika123");
        ValueOperations<String, SysUser> valueops = redisTemplate.opsForValue();
        valueops.set("12345",user);
    }

}
