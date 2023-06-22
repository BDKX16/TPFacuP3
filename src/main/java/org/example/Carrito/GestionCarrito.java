package org.example.Carrito;
import org.example.Persona.Clientes.Cliente;
import org.example.Productos.Producto;

import java.io.Serializable;
import java.util.ArrayList;

public class GestionCarrito implements Serializable {

    private SerializaCarrito carritoEstado = new SerializaCarrito();
    private Carrito carrito;
    private ArrayList<Producto> listaProductos = carritoEstado.listarProdCarrito();

    public GestionCarrito() {
        carrito = new Carrito();
    }

    public void agregarProducto(Producto producto) {
        listaProductos.add(producto);
        double total = carrito.getTotal() + producto.getValor();
        carrito.setTotal(total);
        System.out.println("Producto agregado al carrito: " + producto.getNombre());
        carritoEstado.agregarProdCarrito(producto);
    }
    public Producto quitarProducto(Producto producto){
        if (listaProductos.contains(producto)){
            listaProductos.remove(producto);
            carritoEstado.eliminarProdCarrito(producto);
        }else{
            System.out.println("No existe el producto en el carrito");
        }
        return producto;
    }
    public void mostrarCarrito() {
        double total=0;
        carritoEstado.listarProdCarrito();
        if (listaProductos.isEmpty()) {
            System.out.println("El carrito está vacío.");
        } else {
            System.out.println("Productos en el carrito:");
            for (Producto producto : listaProductos) {
                total=total+producto.getValor();
                System.out.println("- " + producto.getNombre() + " ($" + producto.getValor() + ")");

            }
            carrito.setTotal(total);
            System.out.println("Total: $" + carrito.getTotal());
        }
    }
    public void detallesDeCompra(){
        double total=0;
        System.out.println("Usted compro:");
        for (Producto producto: listaProductos){
            total=total+producto.getValor();
            System.out.println("- " + producto.getNombre() + " ($" + producto.getValor() + ")");
        }
        carrito.setTotal(total);
        System.out.println("- Cantidad de productos: "+listaProductos.size()+" - Total: $" + carrito.getTotal());
        System.out.println("Gracias por su compra");
        vaciarCarrito();
    }
    public void vaciarCarrito(){
        for (Producto producto: listaProductos){
            carritoEstado.eliminarProdCarrito(producto);
        }
    }
}
