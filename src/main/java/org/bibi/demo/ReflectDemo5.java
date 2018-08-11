package org.bibi.demo;

/**
 * 反射用例
 *
 * @author Tom（bibi8086@gmail.com）
 * @date 2018/8/11 15:12
 */
public class ReflectDemo5 {


    public static void main(String[] args) {
        office("org.bibi.demo.Word");
        office("org.bibi.demo.Excel");
    }


    private static void office(String officeName) {
        try {
            // 动态加载类，在运行时加载
            Class clazz = Class.forName(officeName);
            // 通过类型类，创建该类对象
            OfficeAble oa = (OfficeAble) clazz.newInstance();
            oa.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


/**
 * office接口
 */
interface OfficeAble {
    /**
     * 开始
     */
    void start();
}



class Word implements OfficeAble {

    /**
     * 开始
     */
    @Override
    public void start() {
        System.out.println("word start...");
    }
}

class Excel implements OfficeAble {

    /**
     * 开始
     */
    @Override
    public void start() {
        System.out.println("excel start...");
    }
}

