package com.copa.api.strategy;

// Design Pattern: Strategy Pattern (Solicitado nas regras do AP2)
public interface ValidationStrategy<T> {

    void validate(T dto);

}