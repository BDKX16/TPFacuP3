package org.example.Carrito;

import org.example.Productos.Producto;

import java.util.ArrayList;
import java.util.Objects;

public class Carrito {
    private String nroPedido;
    private ArrayList<Producto> listaProductos = new ArrayList<>();
    private double total=0.0;


    public Carrito() {
    }

    public Carrito(String nroPedido, ArrayList<Producto> listaProductos, double total) {
        this.nroPedido = nroPedido;
        this.listaProductos = listaProductos;
        this.total = total;
    }

    public String getNroPedido() {
        return nroPedido;
    }

    public void setNroPedido(String nroPedido) {
        this.nroPedido = nroPedido;
    }

    public ArrayList<Producto> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(ArrayList<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }

    public double getSubTotal() {
        return total;
    }

    public void setSubTotal(double total) {
        this.total = total;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Carrito carrito = (Carrito) o;
        return nroPedido.equals(carrito.nroPedido);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nroPedido);
    }

    @Override
    public String toString() {
        return "Carrito{" +
                "nroPedido='" + nroPedido + '\'' +
                ", listaProductos=" + listaProductos +
                ", subtotal=" + total +
                '}';
    }
    public void agregarProducto(Producto producto) {
        listaProductos.add(producto);
        total += producto.getValor();
        System.out.println("Producto agregado al carrito: " + producto.getNombre());
        producto.setStock(producto.getStock()-1);
    }
    public void quitarProducto(Producto producto){
        if (listaProductos.contains(producto)){
            listaProductos.remove(producto);
            producto.setStock(producto.getStock()+1);
        }else{
            System.out.println("No existe el producto en el carrito");
        }
    }

    public void mostrarCarrito() {

        if (listaProductos.isEmpty()) {
            System.out.println("El carrito está vacío.");
        } else {
            System.out.println("Pedido #"+nroPedido);
            System.out.println("Productos en el carrito:");
            for (Producto producto : listaProductos) {
                System.out.println("- " + producto.getNombre() + " ($" + producto.getValor() + ")");
            }
            System.out.println("Total: $" + total);
        }
    }



}