package org.example.Productos;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import org.example.Interfaces.Repository;
import org.example.Persona.Clientes.Cliente;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class  SerializaProducto implements Repository<Producto> {
    private final File archivoProducto = new File("src\\main\\java\\resources\\producto.json");
    private final ObjectMapper mapper = new ObjectMapper();
    private  List<Producto> listaProducto;
    @Override
    public void cargar() {
        try {
            CollectionType collectionType = mapper.getTypeFactory().constructCollectionType(List.class, Producto.class);
            this.listaProducto = mapper.readValue(archivoProducto, collectionType);
        }catch (IOException e){
            this.listaProducto = new ArrayList<>();
        }

    }

    @Override
    public void guardar() {
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(archivoProducto, listaProducto);
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }
    @Override
    public void agregar(Producto objeto) {
        cargar();
        this.listaProducto.add(objeto);
        guardar();
    }

    @Override
    public List<Producto> listar() {
        cargar();
        return this.listaProducto;
    }

    @Override
    public Producto buscaPorID(int id) {
        cargar();
        for (Producto producto: listaProducto){
            if (producto.getId()==id){
                return producto;
            }
        }
        return null;
    }

    @Override
    public void eliminar(int id) {
        cargar();
        for (Producto producto: listaProducto){
            if (producto.getId()==id){
                listaProducto.remove(producto);
            }
        }
        guardar();
    }

    @Override
    public void modificar(Producto objeto) {
        cargar();
        for(Producto producto: this.listaProducto){
            if(producto.getId() == objeto.getId()){
                producto.setNombre(objeto.getNombre());
                producto.setValor(objeto.getValor());
                producto.setStock(objeto.getStock());
                producto.setCategoria(objeto.getCategoria());
                break;
            }
        }
        guardar();
    }
}
