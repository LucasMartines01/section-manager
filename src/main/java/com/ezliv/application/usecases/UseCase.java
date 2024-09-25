package com.ezliv.application.usecases;

public abstract class UseCase<T, P> {
    public abstract T execute(P params);
}
