package org.example.Productos;

import java.io.Serializable;
import java.util.Objects;

public class Producto implements Serializable {
    private int id;
    private String nombre;
    private double valor;
    private int stock;
    private Categoria categoria;
    public enum Categoria {FRUTAS, VERDURAS, BEBIDAS, CONGELADOS};

    public Producto(int id, String nombre, double valor, int stock, Categoria categoria) {
        this.id = id;
        this.nombre = nombre;
        this.valor = valor;
        this.stock = stock;
        this.categoria = categoria;
    }

    public Producto() {
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

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Producto producto)) return false;
        return id == producto.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Productos{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", valor=" + valor +
                ", stock=" + stock +
                ", categoria=" + categoria +
                '}';
    }
}
