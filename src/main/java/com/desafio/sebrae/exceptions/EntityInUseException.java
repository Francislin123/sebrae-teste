package com.desafio.sebrae.exceptions;

public class EntityInUseException extends UserException {

    public EntityInUseException(String message) {
        super(message);
    }

    public EntityInUseException(String message, Throwable cause) {
        super(message, cause);
    }

}
