package com.turkcell.turkcellcqrs.application.auth.command.login;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LoginCommandResponse
{
    private String jwt;
}
