package com.workintech.exceptions;

import lombok.AllArgsConstructor;
import java.time.LocalDateTime;

@AllArgsConstructor
public class ExceptionResponse {

    private String message;
    private int status;
    private LocalDateTime dateTime;

}
