package org.bibi.demo;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * 通过 【类型类】获取类的成员变量、类的构造方法、类的成员方法
 *
 * @author Tom（bibi8086@gmail.com）
 * @date 2018/8/10 15:51
 */
public class ReflectUtils {


    /**
     * 通过 【类型类】打印类的成员变量信息
     * 成员变量本身也是对象，是java.lang.reflect.Field的实例对象
     * 成员变量包含变量类型、变量名等，其中变量类型也是对象，是java.lang.Class的实例对象
     *
     * @param clazz Class类对象
     * @see Class#getFields() 获取类所有的public成员变量信息，包含父类的public成员变量
     * @see Class#getDeclaredFields() 获取的是该类自己声明的成员变量信息
     */
    public static void printFields(Class clazz) {
        System.out.println("================================");
        System.out.println(clazz.getName() + "：类的成员变量");

        // 成员变量本身也是对象，是java.lang.reflect.Field的实例对象
        // 成员变量包含变量类型、变量名等，其中变量类型也是对象，是java.lang.Class的实例对象

        // getFields() 获取类所有的public成员变量信息，包含父类的public成员变量
        // getDeclaredFields() 获取该类自己声明的成员变量信息
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            // 成员变量的类型的类型类
            Class<?> fieldType = field.getType();
            // 变量类型    变量名称
            System.out.println(fieldType.getName() + " " + field.getName());
        }
    }


    /**
     * 通过 【类型类】打印类的构造方法信息
     *
     * @param clazz Class类对象
     */
    public static void printConstructors(Class clazz) {
        System.out.println("================================");
        System.out.println(clazz.getName() + "：类的构造方法");

        // 构造方法本身也是对象，是java.lang.reflect.Constructor的实例对象

        // getConstructors() 获取类所有的public构造方法信息，包含父类的public构造方法
        // getDeclaredConstructors 获取该类自己声明的构造方法
        Constructor[] constructors = clazz.getDeclaredConstructors();
        for (Constructor constructor : constructors) {
            System.out.print(constructor.getName() + "(");
            StringBuilder sb = new StringBuilder();
            Parameter[] parameters = constructor.getParameters();
            for (Parameter parameter : parameters) {
                sb.append(parameter.getParameterizedType().getTypeName()).append(" ").append(parameter.getName()).append(",");
            }
            if (sb.length() > 0) {
                sb.setLength(sb.length() - 1);
                System.out.print(sb);
            }
            System.out.println(")");

            System.out.print(constructor.getName() + "(");
            sb.setLength(0);
            Class[] parameterTypes = constructor.getParameterTypes();
            for (Class cp : parameterTypes) {
                sb.append(cp.getName()).append(",");
            }
            if (sb.length() > 0) {
                sb.setLength(sb.length() - 1);
                System.out.print(sb);
            }
            System.out.println(")");
        }
    }

    /**
     * 通过 【类型类】打印类的成员方法信息
     *
     * @param clazz Class类对象
     */
    public static void printMethod(Class clazz) {
        System.out.println("================================");
        System.out.println(clazz.getName() + "：类的成员方法");

        // getMethods() 获取类所有的public成员方法信息，包含父类的public方法
        // getDeclaredMethods 获取该类自己声明的成员方法
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            // 方法返回类型的类型类
            Class<?> returnType = method.getReturnType();
            System.out.print(returnType.getName() + " " + method.getName() + "(");
            StringBuilder sb = new StringBuilder();
            Parameter[] parameters = method.getParameters();
            for (Parameter parameter : parameters) {
                sb.append(parameter.getParameterizedType().getTypeName()).append(" ").append(parameter.getName()).append(",");
            }
            if (sb.length() > 0) {
                sb.setLength(sb.length() - 1);
                System.out.print(sb);
            }
            System.out.println(")");

            System.out.print(returnType.getName() + " " + method.getName() + "(");
            sb.setLength(0);
            Class[] parameterTypes = method.getParameterTypes();
            for (Class cp : parameterTypes) {
                sb.append(cp.getName()).append(",");
            }
            if (sb.length() > 0) {
                sb.setLength(sb.length() - 1);
                System.out.print(sb);
            }
            System.out.println(")");
        }
    }
}
