package org.example.springripper.bean_post_processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.cglib.proxy.InvocationHandler;
import org.springframework.cglib.proxy.Proxy;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class ProfilingAnnotationBeanPostProcessor implements BeanPostProcessor {
    private final Map<String, Object> beans = new HashMap<>();

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Profiling declaredAnnotation = bean.getClass().getDeclaredAnnotation(Profiling.class);
        if (declaredAnnotation != null) {
            beans.put(beanName, bean);
            return bean;
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        InvocationHandler handler = (o, method, args) -> {
            System.out.println("Start profiling...");
            long start = System.nanoTime();
            Object retVal = method.invoke(bean, args);
            long end = System.nanoTime();
            System.out.println("End");
            System.out.println("Result: " + (end - start));
            return retVal;
        };
        if (beans.containsKey(beanName)) {
            return Proxy.newProxyInstance(bean.getClass().getClassLoader(), bean.getClass().getInterfaces(), handler);
        }
        return bean;
    }
}