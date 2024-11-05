package com.geo.test.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data

public class ApiError {
    private Integer errorCode;
    private String errorDesc;
    private Date date;

    public ApiError(Integer errorCode, String errorDesc, Date date) {
        this.errorCode = errorCode;
        this.errorDesc = errorDesc;
        this.date = date;
    }
}
