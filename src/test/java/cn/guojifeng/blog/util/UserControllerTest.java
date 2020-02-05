package cn.guojifeng.blog.util;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Auther: 郭继峰
 * @Date: 2020/1/6 12:51
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void getName() {
        String name = restTemplate.getForObject("/name", String.class);
        System.out.println(name);
        Assert.assertEquals("Adam", name);
    }


}
