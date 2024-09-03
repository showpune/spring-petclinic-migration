package org.springframework.samples.petclinic.rabbitmq;

public class FlareMessage implements java.io.Serializable {
    private String message;


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
