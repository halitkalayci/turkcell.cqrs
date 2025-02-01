package com.turkcell.turkcellcqrs.application.student.command.create;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreatedStudentResponse
{
    private UUID id;
    private String email;
    private String studentNo;
}
