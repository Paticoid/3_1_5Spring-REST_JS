package ru.usolkin.SpringJSREST.Exception;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class ExceptionMessage {

    private String message;

    public ExceptionMessage() {
    }

    public ExceptionMessage(String message) {
        this.message = message;
    }

    public String getInfo() {
        return message;
    }
}
