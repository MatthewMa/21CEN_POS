package com.matthew.tools;


import java.io.IOException;

public class ServerException extends IOException {
    public ServerException(String message) {
        super(message);
    }
}
