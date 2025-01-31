package com.turkcell.turkcellcqrs.core.pipelines.logging;

import an.awesome.pipelinr.Command;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class LoggingBehavior implements Command.Middleware {
    // TODO: Implement ELK Stack
    @Override
    public <R, C extends Command<R>> R invoke(C c, Next<R> next) {
        System.out.println("Logging behavior invoked");
        long startTime = System.currentTimeMillis();

        R result = next.invoke();

        long endTime = System.currentTimeMillis();

        System.out.println(c.getClass().getName() + " komutu " +  (endTime - startTime) + " ms sürede tamamlandı");

        return result;
    }
}
