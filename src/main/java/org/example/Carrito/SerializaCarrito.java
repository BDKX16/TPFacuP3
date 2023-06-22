package org.example.Carrito;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;

import org.example.Productos.Producto;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SerializaCarrito extends Producto{
    private final File archivoCarrito = new File("src\\main\\java\\resources\\carrito.json");
    private final ObjectMapper mapper = new ObjectMapper();
    private ArrayList<Producto> listaCarrito;
    public void cargarCarrito() {
        try {
            CollectionType collectionType = mapper.getTypeFactory().constructCollectionType(List.class, Carrito.class);
            this.listaCarrito = mapper.readValue(archivoCarrito, collectionType);
        }catch (IOException e){
            this.listaCarrito = new ArrayList<>();
        }
    }
    public void guardarCarrito() {
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(archivoCarrito, listaCarrito);
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }
    public void agregarProdCarrito(Producto objeto) {
        cargarCarrito();

        this.listaCarrito.add(objeto);
        guardarCarrito();
    }
    public void eliminarProdCarrito(Producto objeto) {
        cargarCarrito();
        this.listaCarrito.remove(objeto);
        guardarCarrito();
    }
    public ArrayList<Producto> listarProdCarrito() {
        cargarCarrito();
        return this.listaCarrito;
    }

}
