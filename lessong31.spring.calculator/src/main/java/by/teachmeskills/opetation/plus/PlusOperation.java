package by.teachmeskills.opetation.plus;

import by.teachmeskills.opetation.AbstractSimpleOperation;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component("operation+")
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class PlusOperation extends AbstractSimpleOperation {

    @Override
    public double process(int a, int b) {
        System.out.println("Processing");
        return a + b;
    }
}
