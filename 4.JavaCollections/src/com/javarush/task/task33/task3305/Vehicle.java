package com.javarush.task.task33.task3305;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.PROPERTY,property  = "className" )


public abstract class Vehicle {
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    protected String name;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    protected String owner;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    protected int age;
}