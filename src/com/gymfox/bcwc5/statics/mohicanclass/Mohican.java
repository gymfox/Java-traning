package com.gymfox.bcwc5.statics.mohicanclass;

public class Mohican {
    private static Mohican lastMohican = null;
    private Mohican prev;
    private String name;

    public Mohican(String name) throws NoLastMohicanException {
        this.name = name;

        prev = lastMohican;
        lastMohican = this;

        System.out.println("Last Mohican was borned: " + getLastMohican() + "; prev is: " + getPrev());
    }

    public void deleteLastMohican() throws NoLastMohicanException {
        validate();

        lastMohican = prev;
        prev = this;
    }

    private static void validate() throws NoLastMohicanException {
        if ( lastMohican == null ) {
            throw new NoLastMohicanException();
        }
    }

    static void reset() {
        lastMohican = null;
    }

    public String toString() {
        return getName();
    }

    public static Mohican getLastMohican() throws NoLastMohicanException {
        validate();

        return lastMohican;
    }

    public Mohican getPrev() throws NoLastMohicanException {
        validate();

        return prev;
    }

    public String getName() {
        return name;
    }
}

class Main {
    public static void main(String[] args) throws NoLastMohicanException {
        Mohican m1 = new Mohican("Apache1");
        Mohican m2 = new Mohican("Apache2");
        Mohican m3 = new Mohican("Apache3");
        Mohican m4 = new Mohican("Apache4");

        m3.deleteLastMohican();

        System.out.println(Mohican.getLastMohican());
    }
}