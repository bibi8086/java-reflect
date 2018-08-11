package org.bibi.demo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Method;

/**
 * 反射原理三：方法反射
 *
 * @author Tom（bibi8086@gmail.com）
 * @date 2018/8/11 14:14
 */
public class ReflectDemo3 {

    public static void main(String[] args) {

        Abc abc = new Abc(500, "pig");

        // 500
        System.out.println(test1(abc, "aaa"));
        // pig
        System.out.println(test1(abc, "bbb"));

        test2(abc);

        test3(abc);
    }


    /**
     * get方法反射
     *
     * @param obj          对象
     * @param propertyName 属性名称
     * @return 属性值
     */
    private static Object test1(Object obj, String propertyName) {
        // 根据属性名称获取get方法
        String getMethodName = "get" + propertyName.substring(0, 1).toUpperCase() + propertyName.substring(1);
        // 获取方法对象
        Class clazz = obj.getClass();
        try {
            // get方法都是public且无参数
            Method m = clazz.getMethod(getMethodName);
            // 通过方法的反射操作方法
            return m.invoke(obj);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 方法反射调用
     */
    private static void test2(Abc abc) {
        Class clazz = abc.getClass();
        try {
            // 方法的反射
            Method m1 = clazz.getMethod("print");
            Object o = m1.invoke(abc);
            // print：null
            System.out.println("print：" + o);

            //getMethod("add", new Class[]{int.class, int.class})
            Method m2 = clazz.getMethod("add", int.class, int.class);
            int result = (int) m2.invoke(abc, 100, 200);
            // add int：300
            System.out.println("add int：" + result);

            Method m3 = clazz.getMethod("add", String.class, String.class);
            String str = (String) m3.invoke(abc, "hello", "reflect");
            // add String：hello reflect
            System.out.println("add String：" + str);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 方法反射调用
     *
     * @param abc 对象
     */
    private static void test3(Abc abc) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("请输入命令（print|print2|print3）：");
            String action = br.readLine();
            Class clazz = abc.getClass();
            Method m = clazz.getMethod(action);
            m.invoke(abc);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

class Abc {

    private Integer aaa;

    private String bbb;

    public Integer getAaa() {
        return aaa;
    }

    public void setAaa(Integer aaa) {
        this.aaa = aaa;
    }

    public String getBbb() {
        return bbb;
    }

    public void setBbb(String bbb) {
        this.bbb = bbb;
    }

    public Abc() {
    }

    public Abc(Integer aaa, String bbb) {
        this.aaa = aaa;
        this.bbb = bbb;
    }

    public void print() {
        System.out.println("hello print1");
    }

    public void print2() {
        System.out.println("hello print2");
    }

    public void print3() {
        System.out.println("hello print3");
    }


    public int add(int a, int b) {
        return a + b;
    }

    public String add(String a, String b) {
        return a + " " + b;
    }

}
