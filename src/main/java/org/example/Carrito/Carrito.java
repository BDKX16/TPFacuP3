package org.example.Carrito;
import org.example.Productos.Producto;

import java.io.Serializable;
import java.util.Objects;

public class Carrito extends Producto implements Serializable {
    private double total=0.0;

    public Carrito() {
    }
    public Carrito(int id, String nombre, double valor, int stock, Categoria categoria, double total) {
        super(id, nombre, valor, stock, categoria);
        this.total = total;
    }
    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Carrito carrito)) return false;
        if (!super.equals(o)) return false;
        return Double.compare(carrito.total, total) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), total);
    }

}