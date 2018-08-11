package org.bibi.demo;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * 反射原理四：泛型本质
 *
 * @author Tom（bibi8086@gmail.com）
 * @date 2018/8/10 18:28
 */
public class ReflectDemo4 {

    public static void main(String[] args) {
        // 没有泛型，可以放入任何类型元素
        List list1 = new ArrayList();
        list1.add("abc");
        list1.add(100);
        // 只能放入整形元素
        List<Integer> list2 = new ArrayList<>();
        list2.add(200);
        // 只能放入字符串元素
        List<String> list3 = new ArrayList<>();
        list3.add("bbb");
        //反射的操作都是编译之后的操作
        Class c1 = list1.getClass();
        Class c2 = list2.getClass();
        Class c3 = list3.getClass();
        // true
        System.out.println(c1 == c2);
        // true
        System.out.println(c1 == c3);
        // 反射的操作都是编译之后的操作
        // c1 == c2 == c3 说明编译之后集合的泛型是去泛型化的
        // Java中集合的泛型，是防止错误输入的，只在编译阶段有效，绕过编译就无效了
        // 通过方法的反射来操作，就可以绕过编译

        try {
            Method m = c2.getMethod("add", Object.class);
            // 绕过编译操作就绕过了泛型
            m.invoke(list2, "ccc");
            // 2
            System.out.println(list2.size());
            // [200, ccc]
            System.out.println(list2);
            for (Integer i : list2){
                System.out.println(i);
                // 200
                // java.lang.ClassCastException: java.lang.String cannot be cast to java.lang.Integer
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
