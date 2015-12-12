/*
 * Copyright (C), 2002-2015, 北京世纪鼎点软件有限公司
 * FileName: ReflectDemo1.java
 * Author:   DD240
 * Date:     2015-11-30 上午9:20:16
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author> sunlj     <time>      <version>    <desc>
 * 修改人姓名             修改日期            版本号                  描述
 */
package com.usual.reflect;

/**
 * 〈一句话功能简述〉<br> 
 * 〈功能详细描述〉
 *
 * @author sunlj
 * @see 
 * @since 1.0
 */

class A {
    
}

public class ReflectDemo1 {
    public static void main(String[] args) {
        System.out.println("String.class " + String.class); // String的类的类型
        
        Class<?> demo1 = null; 
        
        try {
            demo1 = Class.forName("com.usual.reflect.A");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        System.out.println("demo1 ： " + demo1.getName());
        
        System.out.println("demo1 ： " + demo1.getClass().getName());
        
        System.out.println("demo1 ： " + String.class.getName());
        
        
        Class<?> person = null;
        
         try {
            person = Class.forName("com.usual.reflect.Person");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

         
         Person p = null;
         try {
            p = (Person)person.newInstance();
        } catch (InstantiationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
         
         p.setId(1);
         p.setName("name");
         // p.setAddress("23");
         
         System.out.println(p.toString());        
        
    }
}

class Person {
    
    
    
    
    /**
     * 
     */
    public Person() {
        
    }

    /**
     * @param id
     */
    public Person(int id) {
        this.id = id;
    }

    /**
     * @param id
     * @param name
     * @param age
     * @param address
     */
    public Person(int id, String name, int age, String address) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
    }

    private int id;
    
    private String name;
    
    private int age;
    
    private String address;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person [id=" + id + ", name=" + name + ", age=" + age
                + ", address=" + address + "]";
    }

    
    
    
}


