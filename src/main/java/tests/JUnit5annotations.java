package tests;

import org.junit.jupiter.api.*;

public class JUnit5annotations {

    @BeforeAll
    static void beforeAll(){
        System.out.println("smth before all Tests");
    }

    @Test
    void fistTest(){
        System.out.println("Started First Test");
    }

    @BeforeEach
    void beforeEach(){
        System.out.println("smth before every Tests");
    }

    @Test
    void secondTest(){
        System.out.println("Started Seconds Test");
    }

    @AfterAll
    static void afterAll(){
        System.out.println("smth after all Tests");
    }

    @AfterEach
    void afterEach(){
        System.out.println("smth after every Tests");
    }
}
