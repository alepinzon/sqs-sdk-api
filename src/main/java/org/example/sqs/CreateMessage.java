package org.example.sqs;

import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class CreateMessage {

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
