package com.example.octopusgameglorytoucrain.mapper;

public interface Mapper<T,R> {
    T mapFrom(R object);
    R mapTo(T object);
}
