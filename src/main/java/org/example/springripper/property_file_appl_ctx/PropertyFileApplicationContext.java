package org.example.springripper.property_file_appl_ctx;

import org.springframework.beans.factory.support.PropertiesBeanDefinitionReader;
import org.springframework.context.support.GenericApplicationContext;

/**
 * @author sstol
 * 2021-12-11
 */
public class PropertyFileApplicationContext extends GenericApplicationContext {
    public PropertyFileApplicationContext(String fileName) {
        PropertiesBeanDefinitionReader reader = new PropertiesBeanDefinitionReader(this);
        int i = reader.loadBeanDefinitions(fileName);
        System.out.println("found " + i + " beans");
        refresh();
    }

    public static void main(String[] args) {
        PropertyFileApplicationContext ctx = new PropertyFileApplicationContext("context.properties");
        MyBean bean = ctx.getBean(MyBean.class);
        bean.sayMessage();
    }
}
