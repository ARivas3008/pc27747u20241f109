package com.campuslab.platform.u20241f109.shared.application.result;

public record Success <T> (T value) implements Result<T>{
}
