package org.example.springripper.mbeans;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import javax.management.MBeanServer;
import javax.management.ObjectName;
import java.lang.management.ManagementFactory;

@SpringBootApplication
public class MBeansAppl {
    public static void main(String[] args) {
        ConfigurableApplicationContext ctx =
                SpringApplication.run(MBeansAppl.class, args);
    }

    @Bean
    CommandLineRunner run(EnableDisableSomethingController controllerMBean) {
        return (args) -> {
            MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();
            mBeanServer.registerMBean(controllerMBean, new ObjectName("MyBeanDomain", "MyBeanKey", "myBeanValue"));
            while (true) {
                System.out.println(controllerMBean.isEnableSomething());
                Thread.sleep(1000L);
            }
        };
    }
}
