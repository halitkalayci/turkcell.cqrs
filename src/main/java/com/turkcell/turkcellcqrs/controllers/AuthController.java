package com.turkcell.turkcellcqrs.controllers;

import an.awesome.pipelinr.Pipeline;
import com.turkcell.turkcellcqrs.application.auth.command.login.LoginCommand;
import com.turkcell.turkcellcqrs.application.auth.command.login.LoginCommandResponse;
import com.turkcell.turkcellcqrs.core.web.BaseController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController extends BaseController {
    public AuthController(Pipeline pipeline) {
        super(pipeline);
    }

    @PostMapping
    public LoginCommandResponse login(@RequestBody LoginCommand loginCommand){
        return loginCommand.execute(pipeline);
    }
}
