package by.teachmeskills;

import by.teachmeskills.calculator.Calculator;
import by.teachmeskills.conf.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    public static void main(String[] args) {
        final AnnotationConfigApplicationContext context =
            new AnnotationConfigApplicationContext(AppConfig.class);
        final Calculator calculator = context.getBean("calculator", Calculator.class);
        calculator.run();
    }

}
