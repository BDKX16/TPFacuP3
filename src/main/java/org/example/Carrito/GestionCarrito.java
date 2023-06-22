package org.example.Carrito;
import org.example.Persona.Clientes.Cliente;
import org.example.Productos.Producto;

import java.io.Serializable;
import java.util.ArrayList;

public class GestionCarrito implements Serializable {

    private SerializaCarrito carritoEstado = new SerializaCarrito();
    private Carrito carrito;
    private ArrayList<Producto> listaProductos = new ArrayList<>();

    public GestionCarrito() {
        carrito = new Carrito();
    }

    public void agregarProducto(Producto producto) {
        listaProductos.add(producto);
        double total = carrito.getTotal() + producto.getValor();
        carrito.setTotal(total);
        System.out.println("Producto agregado al carrito: " + producto.getNombre());
        carritoEstado.agregarProdCarrito(producto);
        producto.setStock(producto.getStock()-1);
    }
    public Producto quitarProducto(Producto producto){
        listaProductos=carritoEstado.listarProdCarrito();
        if (listaProductos.contains(producto)){
            listaProductos.remove(producto);
            producto.setStock(producto.getStock()+1);
            carritoEstado.eliminarProdCarrito(producto);
        }else{
            System.out.println("No existe el producto en el carrito");
        }
        return producto;
    }
    public void mostrarCarrito() {
        carritoEstado.listarProdCarrito();
        if (listaProductos.isEmpty()) {
            System.out.println("El carrito está vacío.");
        } else {
            System.out.println("Productos en el carrito:");
            for (Producto producto : listaProductos) {
                System.out.println("- " + producto.getNombre() + " ($" + producto.getValor() + ")");
            }
            System.out.println("Total: $" + carrito.getTotal());
        }
    }
    public void detallesDeCompra(){
        int cant=0;
        System.out.println("Usted compro:");
        for (Producto producto: listaProductos){
            System.out.println("- " + producto.getNombre() + " ($" + producto.getValor() + ")");
            cant++;
        }
        System.out.println("- Cantidad de productos: "+listaProductos.size()+" - Total: $" + carrito.getTotal());
        System.out.println("Gracias por su compra");
        vaciarCarrito();
    }


    public void vaciarCarrito(){
        listaProductos.clear();
    }

    @Override
    public String toString() {
        return "GestionCarrito{" +
                "carritoEstado=" + carritoEstado +
                ", carrito=" + carrito +
                ", listaProductos=" + listaProductos +
                '}';
    }
}
