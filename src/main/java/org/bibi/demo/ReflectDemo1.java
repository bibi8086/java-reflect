package org.bibi.demo;

/**
 * 反射原理一：【类型类】
 * 类是对象，任何类都是java.lang.Class类的实例对象，表示方式有三种
 *
 * @author Tom（bibi8086@gmail.com）
 * @date 2018/8/10 15:11
 */
public class ReflectDemo1 {

    public void run(String str){
        System.out.println(this.toString() + "：" + str);
    }

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {

        ReflectDemo1 reflectDemo1 = new ReflectDemo1();

        // 任何类都是java.lang.Class类的实例对象，表示方式有三种

        // 方式一：任何一个类都有一个隐含的静态成员变量class
        Class c1 = ReflectDemo1.class;
        // 方式二：调用该类的对象的getClass方法
        Class c2 = reflectDemo1.getClass();
        // 方式三：类的动态加载
        Class c3 = Class.forName("org.bibi.demo.ReflectDemo1");
        // true
        System.out.println(c1 == c2);
        // true
        System.out.println(c1 == c3);
        // 这三种方式表示的都是同一个类

        // 通过类的类类型创建类的对象实例，该类必须有无参数的构造方法
        Object o1 = c1.newInstance();
        if(o1 instanceof ReflectDemo1){
            ReflectDemo1 demo1 = (ReflectDemo1) o1;
            System.out.println(demo1);
            demo1.run("hello!!!");
        }

        Object o2 = c2.newInstance();
        if(o2 instanceof ReflectDemo1){
            ReflectDemo1 demo2 = (ReflectDemo1) o2;
            System.out.println(demo2);
            demo2.run("hello!!!");
        }

        Object o3 = c3.newInstance();
        if(o3 instanceof ReflectDemo1){
            ReflectDemo1 demo3 = (ReflectDemo1) o3;
            System.out.println(demo3);
            demo3.run("hello!!!");
        }
    }
}
