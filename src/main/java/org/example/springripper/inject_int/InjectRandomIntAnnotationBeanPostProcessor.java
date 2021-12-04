package org.example.springripper.inject_int;

import lombok.SneakyThrows;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;

@Component
public class InjectRandomIntAnnotationBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Field[] declaredFields = bean.getClass().getDeclaredFields();
        for (Field declaredField : declaredFields) {
            InjectNumber annotation = declaredField.getDeclaredAnnotation(InjectNumber.class);
            if (annotation != null) {
                int number = annotation.number();
                declaredField.setAccessible(true);
                ReflectionUtils.setField(declaredField, bean, number);
            }
        }
        return bean;
    }

    @Override
    @SneakyThrows
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        Field[] declaredFields = bean.getClass().getDeclaredFields();
        for (Field declaredField : declaredFields) {
            InjectNumber annotation = declaredField.getDeclaredAnnotation(InjectNumber.class);
            if (annotation != null) {
                declaredField.setAccessible(true);
                declaredField.set(bean, 10);
            }
        }
        return bean;
    }
}