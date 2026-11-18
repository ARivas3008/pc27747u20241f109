package com.campuslab.platform.u20241f109.shared.application.result;

public record Failure<T>(FailureType type, String messageKEy) implements Result<T>{
    public enum FailureType {VALIDATION, CONFLICT, INTERNAL}
    public static  <T> Failure <T> invalid(String key){
        return new Failure <> (FailureType.VALIDATION, key);
    }
    public static  <T> Failure <T> conflict(String key){
        return new Failure <> (FailureType.CONFLICT, key);
    }
    public static  <T> Failure <T> internal(String key){
        return new Failure <> (FailureType.INTERNAL, "error.unexpected");
    }

}
