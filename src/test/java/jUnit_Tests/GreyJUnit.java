package jUnit_Tests;


import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class GreyJUnit {

    @BeforeClass
    public static void setup(){
        System.out.println("JUnit before class");
    }
    @Before
    public void b(){
        System.out.println("before annotation");
    }

    @Test
    public void test1() {
        System.out.println("JUnit test 1");
        Assert.assertEquals("here",5,5 );

    }
    @Test
    public void test2() {
        System.out.println("JUnit test 2");
    }
}
