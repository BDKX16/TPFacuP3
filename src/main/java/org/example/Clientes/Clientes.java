package org.example.Clientes;

public class Clientes {
    private int id;
    private String nombre;
    private String apellido;
    private String dni;
    private String calle;
    private int alturaCalle;
    private String ciudad;
    private double saldo;

    public Clientes(int id, String nombre, String apellido, String dni, String calle, int alturaCalle, String ciudad, double saldo) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.calle = calle;
        this.alturaCalle = alturaCalle;
        this.ciudad = ciudad;
        this.saldo = saldo;
    }
}
