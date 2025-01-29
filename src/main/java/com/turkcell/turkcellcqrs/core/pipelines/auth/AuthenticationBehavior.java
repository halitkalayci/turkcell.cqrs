package com.turkcell.turkcellcqrs.core.pipelines.auth;

import an.awesome.pipelinr.Command;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AuthenticationBehavior implements Command.Middleware {
    @Override
    public <R, C extends Command<R>> R invoke(C c, Next<R> next) {
        if (c instanceof AuthenticatedRequest || c instanceof AuthorizedRequest) {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            if (auth == null || !auth.isAuthenticated()) {
                throw new RuntimeException("Authentication required");
            }

            if(c instanceof AuthorizedRequest)
            {
                boolean hasRequiredRoles = auth
                        .getAuthorities()
                        .stream()
                        .anyMatch(
                                role -> ((AuthorizedRequest) c)
                                        .getRequiredRoles()
                                        .stream()
                                        .anyMatch(req -> req.equalsIgnoreCase(role.getAuthority()))
                        );
                if(!hasRequiredRoles)
                    throw new RuntimeException("You dont have the required roles");
            }
        }

        return next.invoke();
    }
}
