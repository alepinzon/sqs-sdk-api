package org.example.sqs.dtos;

import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class SimpleMessage {

    @NotNull
    @NotEmpty
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
