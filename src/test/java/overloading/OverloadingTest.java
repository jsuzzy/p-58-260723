package overloading;

import org.junit.jupiter.api.Test;

public class OverloadingTest {

    @Test
    void t1(){
        Person p1 = new Person();
        p1.introduce();
    }

    @Test
    void t2(){
        Person p1 = new Person();
        p1.introduce("정수지");
    }

    @Test
    void t3(){
        Person p1 = new Person();
        p1.introduce(25);
    }

    @Test
    void t4(){
        Person p1 = new Person();
        p1.introduce("정수지", 25);
    }
}
