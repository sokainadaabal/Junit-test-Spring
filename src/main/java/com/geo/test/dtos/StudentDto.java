package com.geo.test.dtos;


import lombok.*;

/*
public record StudentDto(
    Long id,
    String name,
    Long age
){}
*/
@Data



public class StudentDto{
    Long id;
    String name;
    Long age;

    public StudentDto() {
    }

    public StudentDto(Long id, String name, Long age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }
}