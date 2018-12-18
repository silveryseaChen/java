package com.chy.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by chy on 2018/12/18.
 */
public class ProxyTest {

    public static void main(String[] args) {

        Integer i = 10;
        InvokerHandle handle = new InvokerHandle(i);
        Comparable o = (Comparable)Proxy.newProxyInstance(null, Integer.class.getInterfaces(), handle);
        System.out.println(o.compareTo(11));
    }

    static class InvokerHandle implements InvocationHandler{

        private Object t;

        public InvokerHandle(Object t){
            this.t = t;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

            System.out.print(method.getName()+"(");
            for (int i = 0; args != null && args.length > 0 && i<args.length; i++) {
                Object o = args[i];
                if(i == args.length - 1){
                    System.out.print(o);
                } else {
                    System.out.print(o+",");
                }
            }
            System.out.println(")");

            return method.invoke(t, args);
        }
    }

}
