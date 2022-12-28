package com.example.octopusgameglorytoucrain.mapper;

import org.springframework.stereotype.Service;

@Service
public interface Mapper<T,R> {
    T mapFrom(R object);
    R mapTo(T object);
}
