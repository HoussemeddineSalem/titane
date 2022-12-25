package dev.titane.users.errors;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum ErrorResponses implements IBadRequestError {
    NO_USERS_FOUND("NO_USERS_FOUND");
    private final String message;


    @Override
    public String getMessage() {
        return message;
    }

}
