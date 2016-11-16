/*
 * Copyright (C), 2002-2015, �������Ͷ���������޹�˾
 * FileName: JavaMethodAreaOOM.java
 * Author:   DD240
 * Date:     2015-12-29 ����6:51:08
 * Description: //ģ��Ŀ�ġ���������      
 * History: //�޸ļ�¼
 * <author> sunlj     <time>      <version>    <desc>
 * �޸�������             �޸�����            �汾��                  ����
 */
package com.javase.jvm.mem;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * VM Args : -XX:PermSize=10M -XX:MaxPermSize=10M
 * @author sunlj
 * @see 
 * @since 1.0
 */
public class JavaMethodAreaOOM {
    public static void main(String[] args) {
        while(true) {
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(OOMObject.class);
            enhancer.setUseCache(false);
            enhancer.setCallback(new MethodInterceptor() {
                public Object intercept(Object obj, Method method, Object[] args, 
                        MethodProxy proxy) throws Throwable {
                    return proxy.invokeSuper(obj, args);
                }
            });
            enhancer.create();
        }
    }
    
    static class OOMObject {
        
    }
}
/*
Exception in thread "main" 
Exception: java.lang.OutOfMemoryError thrown from the UncaughtExceptionHandler in thread "main"
*/
