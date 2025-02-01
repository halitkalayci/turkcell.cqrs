package com.turkcell.turkcellcqrs.controllers;

import an.awesome.pipelinr.Pipeline;
import com.turkcell.turkcellcqrs.application.student.command.create.CreateStudentCommand;
import com.turkcell.turkcellcqrs.application.student.command.create.CreatedStudentResponse;
import com.turkcell.turkcellcqrs.core.web.BaseController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/students")
public class StudentsController extends BaseController {
    public StudentsController(Pipeline pipeline) {
        super(pipeline);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreatedStudentResponse create(@RequestBody CreateStudentCommand command) {
        return command.execute(pipeline);
    }
}
