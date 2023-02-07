package com.dp.app.solid.ocp;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Stream;

enum Color {
    RED, GREEN, BLUE, BROWN
}

enum Size {
    SMALL, MEDIUM, LARGE, YUGE
}

enum Condition {
    NEW, USED, OLD
}

class Product {

    public String name;
    public Color color;
    public Size size;
    public Condition condition;

    public Product(String name, Color color, Size size, Condition condition) {
        this.name = name;
        this.color = color;
        this.size = size;
        this.condition = condition;
    }
}

interface Specification<T> {
    boolean isSatisfied(T item);
}

interface Filter<T> {
    Stream<T> multipleFilter(List<T> items, List<Specification<T>> specs);
}

class ColorSpecification implements Specification<Product> {

    private Color color;

    public ColorSpecification(Color color) {
        this.color = color;
    }

    @Override
    public boolean isSatisfied(Product p) {
        return p.color == color;
    }
}

class SizeSpecification implements Specification<Product> {

    private Size size;

    public SizeSpecification(Size size) {
        this.size = size;
    }

    @Override
    public boolean isSatisfied(Product p) {
        return p.size == size;
    }
}

class ConditionSpecification implements Specification<Product> {

    private Condition condition;

    public ConditionSpecification(Condition condition) {
        this.condition = condition;
    }

    @Override
    public boolean isSatisfied(Product p) {
        return p.condition == condition;
    }
}

class ProductFilter implements Filter<Product> {

    @Override
    public Stream<Product> multipleFilter(List<Product> items, List<Specification<Product>> specs) {
        return items.stream().filter(p -> {
            AtomicBoolean condition = new AtomicBoolean(true);
            specs.forEach(s -> {
                condition.set(condition.get() && s.isSatisfied(p));
            });
            return condition.get();
        });
    }
}

public class OpenClosedPrinciple {

    public static void main(String[] args) {

        Product apple = new Product("Apple", Color.GREEN, Size.SMALL, Condition.NEW);
        Product tree = new Product("Tree", Color.GREEN, Size.LARGE, Condition.OLD);
        Product house = new Product("House", Color.BLUE, Size.LARGE, Condition.OLD);

        List<Product> products = List.of(apple, tree, house);
        ProductFilter filter = new ProductFilter();
        filter.multipleFilter(products, Arrays.asList(
                          new ColorSpecification(Color.GREEN),
                          new SizeSpecification(Size.SMALL),
                          new ConditionSpecification(Condition.NEW)
                          )
        ).forEach(p -> System.out.println(String.format("%s %s %s %s", p.name, p.color, p.size, p.condition)));
    }
}
