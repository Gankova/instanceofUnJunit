package com.company;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class JSNumberTest {
    private static ArrayList<TestCase> testCases;
    private interface Execuotor{
        JSNumber createJSNumber();
    }
    private static class TestCase {
        private Execuotor exec;
        private Object value;
        private Object expected;
        public TestCase (Execuotor exec, Object v, Object exp) {
            this.exec = exec;
            this.value = v;
            this.expected = exp;
        }
    }


    //@AfterAll - 1 раз после всех (static)
    //@BeforeEach - вызывается перед каждым вызвовом тестового метода
    //@AfterEach - после каждого вызова тестового метода
    //"Ignore - тестовый метод игнорируется (не выполняется)


    @BeforeAll // вызывается ровно 1 раз перед стартом всех тестов
    public static void prepare(){
        testCases = new ArrayList<>();
        testCases.add(new TestCase(() -> new JSNumber(15),"15",true));
        testCases.add(new TestCase(() -> new JSNumber("12.36"),12.58,false));
        testCases.add(new TestCase(() -> new JSNumber(1050),1050.0,true));

    }

    @Test
    public void equalsTest() {

        JSNumber<String> number = new JSNumber<>("12.0");
        boolean res = number.equals(12);
        Assertions.assertEquals(true,res);
        Assertions.assertTrue(res);

        for (TestCase tc : testCases) {
            JSNumber n = tc.exec.createJSNumber();
            Assertions.assertEquals(tc.expected, n.equals(tc.value));
        }
    }
    @Test
    public void correctExceptionTypeTest() {
        //
        Class c = JSNumber.class;
        //
        Assertions.assertThrows(JSNumber.UnsupportTypeException.class, () -> {
            new JSNumber<Boolean>(true);
        });
    }
}
