package com.dp.app.solid.dip;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.javatuples.Triplet;

// A. High-level modules should not depend on low-level modules. 
// Both should depend on abstractions.

// B. Abstractions should not depend on details. 
// Details should depend on abstractions.
public class DependencyInversionPrinciple {
    
}

enum Relationship {
    PARENT, CHILD, SIBLING
}

class Person {
    String name;

    public Person(String name) {
        this.name = name;
    }
}

interface RelationshipBrowser {
    List<Person> findAllChildrenOf(String name);
    void addParentAndChild(Person parent, Person child);
}

/*
 * low-level
 * regarded to database model
 * implementation the final users should not access it directly
 */
class Relationships implements RelationshipBrowser {
    private List<Triplet<Person, Relationship, Person>> relations = new ArrayList<>();
    
    @Override
    public void addParentAndChild(Person parent, Person child) {
        relations.add(new Triplet<>(parent, Relationship.PARENT, child));
        relations.add(new Triplet<>(child, Relationship.CHILD, parent));
    }

    // public List<Triplet<Person, Relationship, Person>> getRelations() {
    //     return relations;
    // }

    @Override
    public List<Person> findAllChildrenOf(String name) {
        return relations.stream()
            .filter(p -> Objects.equals(p.getValue0().name, name)
                && p.getValue1() == Relationship.PARENT)
            .map(Triplet::getValue2)
            .collect(Collectors.toList());
    }
}

/*
 * high-level
 * regarded to business logic
 * it should not depend of low-level
 * it should depend of abstraction
 */
class Research {
    /*
     * this constructor access the low-level directly
     * can not change the return to other type, because it could affect the stream, etc
     */
    // public Research(Relationships relationships) {
    //     List<Triplet<Person, Relationship, Person>> relations = relationships.getRelations();
    //     relations.stream()
    //     .filter(p -> p.getValue0().name.equals("John")
    //         && p.getValue1() == Relationship.PARENT)
    //     .forEach(ch -> System.out.println("John has a child called " + ch.getValue2().name));

    // }

    /*
     * you can change the code, for example stop using Triplet
     * you should depend of absctration RelationshipBrowser and not the implementation as a code above
     */
    public Research(RelationshipBrowser browser) {
        /*
         * the interface return the List of Person wihtout the Research know how it was implemented
         */
        List<Person> children = browser.findAllChildrenOf("John");
        children.forEach(c -> System.out.println(String.format("Jhon has a child called %s", c.name)));
    }
}

class Demo {
    public static void main(String[] args) {
        Person parent = new Person("John");
        Person child1 = new Person("Chris");
        Person child2 = new Person("Matt");

        Relationships relationships = new Relationships();
        relationships.addParentAndChild(parent, child1);
        relationships.addParentAndChild(parent, child2);

        new Research(relationships);
    }
}
