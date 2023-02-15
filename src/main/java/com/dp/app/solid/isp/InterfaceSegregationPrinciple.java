package com.dp.app.solid.isp;

public class InterfaceSegregationPrinciple {
    
}

class Document {

    String content = "Document content";

}

interface Printer {
    void print(Document document);
}

interface Scanner {
    void scan(Document document);
}

interface Fax {
    void fax(Document document);
}

class JustAPrinter implements Printer {

    @Override
    public void print(Document document) {
        
    }
}

class Photocopier implements Printer, Scanner {

    private Printer printer;
    private Scanner scanner;

    public Photocopier(Printer printer, Scanner scanner) {
        this.printer = printer;
        this.scanner = scanner;
    }

    @Override
    public void scan(Document document) {
        printer.print(document);
        
    }

    @Override
    public void print(Document document) {
        scanner.scan(document);
    }
}

interface MultiFunctionDevice extends Printer, Scanner {}

/*
 * Decorator pattern
 */
class MultiFunctionMachine implements MultiFunctionDevice {

    private Printer printer;
    private Scanner scanner;

    public MultiFunctionMachine(Printer printer, Scanner scanner) {
        this.printer = printer;
        this.scanner = scanner;
    }

    @Override
    public void print(Document document) {
        printer.print(document);
    }

    @Override
    public void scan(Document document) {
        scanner.scan(document);        
    }

}



