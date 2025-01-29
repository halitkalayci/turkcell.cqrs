package com.turkcell.turkcellcqrs.core.pipelines.auth;

import an.awesome.pipelinr.Command;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationBehavior implements Command.Middleware {
    @Override
    public <R, C extends Command<R>> R invoke(C c, Next<R> next) {
        // command çalışmadan önce...
        /*Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if(auth == null || !auth.isAuthenticated()) {
            throw new RuntimeException("Authentication required");
        }*/

        System.out.println("BEFORE: Authentication behavior invoked");

        var response = next.invoke(); // commandı çalıştırdınız.

        System.out.println("AFTER: Authentication behavior invoked");
        // command çalıştıktan sonra.
        return response;
    }
}
