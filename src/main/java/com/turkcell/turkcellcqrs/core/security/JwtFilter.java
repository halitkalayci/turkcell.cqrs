package com.turkcell.turkcellcqrs.core.security;

import com.turkcell.turkcellcqrs.core.jwt.JwtService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class JwtFilter extends OncePerRequestFilter
{
    private final JwtService jwtService;

    public JwtFilter(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {
        String jwtHeader = request.getHeader("Authorization");

        if(jwtHeader != null && jwtHeader.startsWith("Bearer ")) {
            String jwt = jwtHeader.substring(7);
            String username = jwtService.extractUsername(jwt);
            List<String> roles = jwtService.extractRoles(jwt);

            List<GrantedAuthority> authorities = new ArrayList<>();
            if(roles!=null)
            {
                authorities = roles
                        .stream()
                        .map(role -> (GrantedAuthority) () -> role)
                        .toList();
            }


            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                    username,
                    jwtService.extractId(jwt),
                    authorities
            );

            authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        }

        filterChain.doFilter(request,response);
    }
}
