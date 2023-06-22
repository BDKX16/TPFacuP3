package org.example.Persona.Clientes;

import org.example.Persona.Persona;

import java.io.Serializable;
import java.util.Objects;

public class Cliente extends Persona implements Serializable {
    private int id;
    private String nombre;
    private String apellido;
    private String dni;
    private String calle;
    private int alturaCalle;
    private String ciudad;
    private double saldo;

    public Cliente(int pin, int id, String nombre, String apellido, String dni, String calle, int alturaCalle, String ciudad, double saldo) {
        super(pin);
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.calle = calle;
        this.alturaCalle = alturaCalle;
        this.ciudad = ciudad;
        this.saldo = saldo;
    }

    public Cliente() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public int getAlturaCalle() {
        return alturaCalle;
    }

    public void setAlturaCalle(int alturaCalle) {
        this.alturaCalle = alturaCalle;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cliente cliente)) return false;
        return id == cliente.id && alturaCalle == cliente.alturaCalle && Double.compare(cliente.saldo, saldo) == 0 && Objects.equals(nombre, cliente.nombre) && Objects.equals(apellido, cliente.apellido) && Objects.equals(dni, cliente.dni) && Objects.equals(calle, cliente.calle) && Objects.equals(ciudad, cliente.ciudad);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, apellido, dni, calle, alturaCalle, ciudad, saldo);
    }

    @Override
    public String toString() {
        return  "[ ID: " + id +
                " | Nombre: " + nombre+
                " | Apellido: " + apellido+
                " | DNI: " + dni+
                " | Calle: " + calle+
                " " + alturaCalle +
                " | Ciudad: " + ciudad+
                " | Saldo: "+saldo+
                " ]";
    }

}

