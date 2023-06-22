package org.example.Persona;

public abstract class Persona {
    protected int pin;

    public Persona(int pin) {
        this.pin = pin;
    }

    public Persona() {
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }
}
