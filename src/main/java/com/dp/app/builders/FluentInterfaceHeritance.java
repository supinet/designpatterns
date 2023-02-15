package com.dp.app.builders;

class FluentInterfaceHeritance {}

class Person {
    public String name;
    public String position;
    
    @Override
    public String toString() {
        return "Person { " +
            "name='" + name + '\'' +
            ", position='" + position + '\'' +
            '}';
    }
}

/*
 * to propagate fluent interface builder by heritance
 * you can use generic recursive definition
 */
class PersonBuilder<SELF extends PersonBuilder<SELF>> {

    protected Person person = new Person();
    
    public SELF withName(String name) {
        person.name = name;
        return self();
    }

    public Person build() {
        return person;
    }

    protected SELF self() {
        return (SELF) self();
    }
}

class EmployeeBuilder extends PersonBuilder<EmployeeBuilder> {
    
    public EmployeeBuilder worksAt(String position) {
        person.position = position;
        return self();
    }

    @Override
    protected EmployeeBuilder self() {
        return this;
    }
}

class Demo {
    public static void main(String[] args) {
        EmployeeBuilder pb = new EmployeeBuilder();
        Person john = pb
            .withName("John")
            .worksAt("developer")
            .build();
        System.out.println(john);
    }
}
