package cn.guojifeng.blog.util;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SimpleTest {

    @Before
    public void firstStart(){
        System.out.println("----------------start-----------------------");
    }
    @After
    public void endStart(){
        System.out.println("-------------------end-----------------------");
    }

    @Test
    public void doTest() {
        int num = new Integer(1);
        Assert.assertEquals(num, 1);
        System.out.println("----------------runtime----------------------");
    }


    @Test
    public void doTest2() {
        String[] string1 = {"1", "2"};
        String[] string2 = string1;
        String[] string3 = {"1", "2"};

        Assert.assertEquals(string1, string2);
        Assert.assertEquals(string2, string3);
        Assert.assertSame(string1, string2);
        Assert.assertSame(string2, string3); //验证不通过，string2、string3指向的引用不同
    }
}