package io.github.erfangc.raincove.sdk.models;


public class DeleteBindingResponse {

    private String message;
    private String timestamp;

    public String getMessage() {
        return this.message;
    }

    public DeleteBindingResponse setMessage(String message) {
        this.message = message;
        return this;
    }

    public String getTimestamp() {
        return this.timestamp;
    }

    public DeleteBindingResponse setTimestamp(String timestamp) {
        this.timestamp = timestamp;
        return this;
    }

}