package org.bibi.demo;

/**
 * 反射原理二：通过 【类型类】获取类的成员变量、类的构造方法、类的成员方法
 *
 * @author Tom（bibi8086@gmail.com）
 * @date 2018/8/10 15:47
 */
public class ReflectDemo2 {

    private String aaa;
    public String bbb;

    public ReflectDemo2() {
    }

    public ReflectDemo2(String aaa, String bbb) {
        this.aaa = aaa;
        this.bbb = bbb;
    }

    public String hello(Integer a, String b){
        return a + b;
    }

    public static void main(String[] args) {
        // 打印类的成员变量
        ReflectUtils.printFields(ReflectDemo2.class);
        ReflectUtils.printFields(String.class);
        ReflectUtils.printFields(Integer.class);

        // 打印类的构造方法
        ReflectUtils.printConstructors(ReflectDemo2.class);

        // 打印类的成员方法
        ReflectUtils.printMethod(ReflectDemo2.class);
    }
}
