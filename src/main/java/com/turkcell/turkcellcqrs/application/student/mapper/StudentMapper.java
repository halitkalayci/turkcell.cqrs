package com.turkcell.turkcellcqrs.application.student.mapper;

import com.turkcell.turkcellcqrs.application.student.command.create.CreateStudentCommand;
import com.turkcell.turkcellcqrs.application.student.command.create.CreatedStudentResponse;
import com.turkcell.turkcellcqrs.domain.entity.Student;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface StudentMapper {
    StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);

    @Mapping(target = "studentNo", expression = "java(mapStudentNo())")
    Student createStudentFromCreateCommand(CreateStudentCommand createStudentCommand);


    CreatedStudentResponse createCreatedResponseFromStudent(Student student);

    default String mapStudentNo() {
        int randomNumber = (int) (Math.random() * 100000);
        return String.valueOf(randomNumber);
    }
}
