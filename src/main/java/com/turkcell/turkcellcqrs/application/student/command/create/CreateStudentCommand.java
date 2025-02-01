package com.turkcell.turkcellcqrs.application.student.command.create;

import an.awesome.pipelinr.Command;
import com.turkcell.turkcellcqrs.application.cart.service.CartService;
import com.turkcell.turkcellcqrs.application.student.mapper.StudentMapper;
import com.turkcell.turkcellcqrs.domain.entity.Student;
import com.turkcell.turkcellcqrs.persistence.student.StudentRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Getter
@Setter
public class CreateStudentCommand implements Command<CreatedStudentResponse>
{
    // Validation
    private String email;
    private String password;

    @Component
    @RequiredArgsConstructor
    public static class CreateStudentCommandHandler
            implements Command.Handler<CreateStudentCommand,CreatedStudentResponse>
    {
        private final StudentRepository studentRepository;
        private final CartService cartService;
        private final StudentMapper studentMapper;

        @Override
        @Transactional
        public CreatedStudentResponse handle(CreateStudentCommand createStudentCommand) {
            Student student = studentMapper.createStudentFromCreateCommand(createStudentCommand);
            studentRepository.save(student);
            cartService.createCartForStudent(student);
            return studentMapper.createCreatedResponseFromStudent(student);
        }
    }
}
