package org.example.Persona.Clientes;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import org.example.Exceptions.RepiteDNI;
import org.example.Interfaces.Repository;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
    public Cliente buscaPorDNI(String dni) {
        cargar();
        for (Cliente cliente: listaCliente){
            if (cliente.getDni().equals(dni)){
                return cliente;
            }
        }
        return null;
    }
    @Override
    public void eliminar(int id) {
        cargar();
        Cliente cliente=buscaPorID(id);
        this.listaCliente.remove(cliente);
        guardar();
    }
    @Override
    public void modificar(Cliente objeto)throws RepiteDNI {
        cargar();
        for(Cliente cliente: this.listaCliente){
            if(cliente.getId() == objeto.getId()){
                cliente.setNombre(objeto.getNombre());
                cliente.setApellido(objeto.getApellido());
                if (cliente.getDni().equals(objeto.getDni())) {
                    throw new RepiteDNI("El Dni ingresado ya existe, por favor ingrese otro Dni");
                }
                if (objeto.getDni().equals(cliente.getDni())){
                    Scanner scanner = new Scanner(System.in);
                    System.out.print("-> ");
                    cliente.setDni(scanner.nextLine());
                }
                else {
                    cliente.setDni(objeto.getDni());
                }
                cliente.setCalle(objeto.getCalle());
                cliente.setAlturaCalle(objeto.getAlturaCalle());
                cliente.setCiudad(objeto.getCiudad());
                cliente.setSaldo(objeto.getSaldo());
                break;
            }
        }
        guardar();
    }
    public int verificacion(int id) {
        int check=0;
        Cliente cliente = buscaPorID(id);
        if(cliente==null) {
            System.out.println("El cliente con el ID " + id + " no existe");
        }
        else {
            Scanner scan = new Scanner(System.in);
            if (cliente != null) {
                System.out.println("Ingrese su pin");
                int pin = scan.nextInt();
                scan.nextLine();
                if (pin == cliente.getPin()) {
                    check = 1;
                } else {
                    System.out.println("El pin ingresado no corresponde a su ID");
                }
            }
        }
        return check;
    }
}
