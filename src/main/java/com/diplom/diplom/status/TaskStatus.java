package com.diplom.diplom.status;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonValue;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum TaskStatus {
    WAIT_TO_GET_WORK(0),
    IN_WORK(1),
    DONE(2);

    private final int code;

     TaskStatus(int code) {
        this.code=code;
    }

    @JsonValue
    public int getCode() {
        return code;
    }
}
