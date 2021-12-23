package org.example.springripper.screensaver_new_scope;

import lombok.SneakyThrows;
import org.springframework.context.annotation.*;

import java.awt.*;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author Sergey Stol
 * 2021-12-14
 */
@Configuration
@ComponentScan(basePackages = "org.example.springripper.screensaver_new_scope")
public class Config {
    @Bean
    @Scope("periodical")
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