package com.dp.app.solid.liskov;

class Rectangle {
    protected int width;
    protected int height;

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getArea() {
        return width * height;
    }
}

class Square extends Rectangle {
    public Square(int size) {
        super(size, size);
    }

    @Override
    public void setWidth(int width) {
        super.setWidth(width);
        super.setHeight(width);
    }

    @Override
    public void setHeight(int height) {
        super.setHeight(height);
        super.setWidth(height);
    }
}

class LSPDemo {
    public static void processRectangles(Rectangle[] rectangles) {
        for (Rectangle rectangle : rectangles) {
            System.out.println("Width: " + rectangle.getWidth());
            System.out.println("Height: " + rectangle.getHeight());
            System.out.println("Area: " + rectangle.getArea());
        }
    }

    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(5, 10);
        Square square = new Square(5);

        Rectangle[] rectangles = {rectangle, square};
        processRectangles(rectangles);
    }
}
