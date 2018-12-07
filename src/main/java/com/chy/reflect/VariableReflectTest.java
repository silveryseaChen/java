package com.chy.reflect;

import java.lang.reflect.Field;

/**
 * Created by chy on 2018/11/27.
 */
public class VariableReflectTest {

    public static void main(String[] args) throws Exception {

        User user = new User();
        Field[] fields = user.getClass().getDeclaredFields();
        if(fields != null){
            for (Field f: fields) {
                System.out.println(f.getName() + "-" + f.getModifiers());
                try{
                    System.out.println(f.getName()+ "-" + f.get(user));
                } catch (IllegalAccessException e){
                    f.setAccessible(true);  //私有变量 设置访问权限
                    System.out.println(f.getName()+ "-" + f.get(user) + "-private");

                }

            }
        }
    }

}
