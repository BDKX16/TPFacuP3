package org.example.Persona;

public abstract class Persona {
    protected int id;

    public Persona(int id) {
        this.id = id;
    }

    public Persona() {
    }

    public int getId() {
        return id;
    }

}
