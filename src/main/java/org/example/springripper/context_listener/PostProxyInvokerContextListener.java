package org.example.springripper.context_listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author sstol
 * 2021-12-11
 */
@Component
public class PostProxyInvokerContextListener implements ApplicationListener<ContextRefreshedEvent> {
    @Autowired
    private ConfigurableListableBeanFactory beanFactory;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        ApplicationContext ctx = event.getApplicationContext();
        String[] names = ctx.getBeanDefinitionNames();
        for (String name : names) {
            BeanDefinition beanDefinition = beanFactory.getBeanDefinition(name);
            String originalClassName = beanDefinition.getBeanClassName();
            if (originalClassName == null) {
                continue;
            }
            try {
                Class<?> originalClass = Class.forName(originalClassName);
                Method[] methods = originalClass.getDeclaredMethods();
                for (Method method : methods) {
                    if (method.isAnnotationPresent(PostProxy.class)) {
                        Object bean = ctx.getBean(name);
                        Method currentMethod = bean.getClass().getDeclaredMethod(method.getName(), method.getParameterTypes());
                        currentMethod.setAccessible(true);
                        currentMethod.invoke(bean);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}