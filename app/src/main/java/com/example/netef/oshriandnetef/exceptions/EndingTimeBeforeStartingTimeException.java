package com.example.netef.oshriandnetef.exceptions;

public class EndingTimeBeforeStartingTimeException extends Exception {

    public EndingTimeBeforeStartingTimeException(String errorOutput) {
        super(errorOutput);
    }
}
