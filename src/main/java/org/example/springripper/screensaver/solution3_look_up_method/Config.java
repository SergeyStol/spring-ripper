package org.example.springripper.screensaver.solution3_look_up_method;

import lombok.SneakyThrows;
import org.springframework.context.annotation.*;

import java.awt.*;
import java.util.concurrent.ThreadLocalRandom;

import static org.springframework.beans.factory.config.ConfigurableBeanFactory.SCOPE_PROTOTYPE;

/**
 * @author Sergey Stol
 * 2021-12-14
 */
@Configuration
@ComponentScan(basePackages = "org.example.springripper.screensaver.solution3_look_up_method")
public class Config {
    @Bean
    @Scope(value = SCOPE_PROTOTYPE)
    public Color color() {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        return new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));
    }

    @Bean
    public ColorFrame colorFrame() {
        return new ColorFrame() {
            @Override
            protected Color getColor() {
                return color();
            }
        };
    }

    @SneakyThrows
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx
                = new AnnotationConfigApplicationContext(Config.class);
        while (true) {
            ctx.getBean(ColorFrame.class).showOnRandomPlace();
            Thread.sleep(500);
        }
    }
}
