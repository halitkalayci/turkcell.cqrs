package com.turkcell.turkcellcqrs.core.pipelines.logging;

import an.awesome.pipelinr.Command;
import org.springframework.stereotype.Component;

@Component
public class LoggingBehavior implements Command.Middleware {
    // TODO: Implement ELK Stack
    @Override
    public <R, C extends Command<R>> R invoke(C c, Next<R> next) {
        long startTime = System.currentTimeMillis();

        R result = next.invoke();

        long endTime = System.currentTimeMillis();

        System.out.println(c.getClass().getName() + " komutu " +  (endTime - startTime) + " ms sürede tamamlandı");

        return result;
    }
}
