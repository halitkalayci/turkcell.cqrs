package com.turkcell.turkcellcqrs.application.auth.command.login;

import an.awesome.pipelinr.Command;
import com.turkcell.turkcellcqrs.core.exception.type.BusinessException;
import com.turkcell.turkcellcqrs.core.jwt.JwtService;
import com.turkcell.turkcellcqrs.domain.entity.User;
import com.turkcell.turkcellcqrs.persistence.user.UserRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Getter
@Setter
public class LoginCommand implements Command<LoginCommandResponse>
{
    private String email;
    private String password;

    @Component
    @RequiredArgsConstructor
    public static class LoginCommandHandler implements Command.Handler<LoginCommand,LoginCommandResponse>
    {
        private final UserRepository userRepository;
        private final PasswordEncoder passwordEncoder;
        private final JwtService jwtService;
        @Override
        public LoginCommandResponse handle(LoginCommand loginCommand) {
            User user = userRepository.findByEmail(loginCommand.getEmail())
                    .orElseThrow(() -> new BusinessException("Bad credentials"));

            boolean isPasswordCorrect = passwordEncoder.matches(loginCommand.getPassword(), user.getPassword());
            if(!isPasswordCorrect)
                throw new BusinessException("Bad credentials");


            return new LoginCommandResponse(jwtService.generateToken(user.getEmail()));
        }
    }
}
