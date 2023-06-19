package org.example.Persona.Clientes;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import org.example.Interfaces.Repository;
import org.example.Productos.Producto;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SerializaCliente implements Repository<Cliente> {
    private final File archivoCliente = new File("src\\main\\java\\resources\\cliente.json");
    private final ObjectMapper mapper = new ObjectMapper();
    private  List<Cliente> listaCliente;
    @Override
    public void cargar() {
        try {
            CollectionType collectionType = mapper.getTypeFactory().constructCollectionType(List.class, Cliente.class);
            this.listaCliente = mapper.readValue(archivoCliente, collectionType);
        }catch (IOException e){
            this.listaCliente = new ArrayList<>();
        }
    }

    @Override
    public void guardar() {
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(archivoCliente, listaCliente);
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void agregar(Cliente objeto) {
        cargar();
        this.listaCliente.add(objeto);
        guardar();
    }

    @Override
    public List<Cliente> listar() {
        cargar();
        return this.listaCliente;
    }

    @Override
    public Cliente buscaPorID(int id) {
        cargar();
        for (Cliente cliente: listaCliente){
            if (cliente.getId()==id){
                return cliente;
            }
        }
        return null;
    }

    @Override
    public void eliminar(int id) {
        cargar();
        for (Cliente cliente: this.listaCliente){
            if(cliente.getId()==id){
                this.listaCliente.remove(cliente);
            }
        }
        guardar();
    }
}
