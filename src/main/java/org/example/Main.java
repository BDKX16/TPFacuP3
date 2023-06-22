package org.example;

import org.example.Exceptions.RepiteDNI;
import org.example.Exceptions.RepiteID;
import org.example.Persona.Admin.Admin;
import org.example.Persona.Admin.GestionAdmin;
import org.example.Persona.Clientes.Cliente;
import org.example.Persona.Clientes.GestionCliente;
import org.example.Productos.GestionProducto;
import org.example.Productos.Producto;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws RepiteDNI, RepiteID {
        Scanner scan = new Scanner(System.in);
        String control = "s";
        while (control.equalsIgnoreCase("s")){
            System.out.println("Elija un Menu:");
            System.out.println("1. Menu Cliente");
            System.out.println("2. Menu Administrador");
            System.out.print("-> ");
            String opcion=scan.nextLine();
            switch (opcion) {
                case "1" -> {
                    while (control.equalsIgnoreCase("s")) {
                        System.out.println("Elija una opcion:");
                        System.out.println("1. Registrar nuevo Cliente Automatico");
                        System.out.println("2. Registrar nuevo Cliente Manual");
                        System.out.println("3. Eliminar Cliente");
                        System.out.println("4. Modificar Cliente");
                        System.out.println("5. Comprar productos");
                        System.out.print("-> ");
                        String opcion1 = scan.nextLine();
                        switch (opcion1) {
                            case "1" -> {
                                Cliente cliente = new Cliente(8475, 1, "Marcos", "Ramirez", "41236578", "Guido", 5021, "Mar del Plata", 20000);
                                GestionCliente client = new GestionCliente();
                                client.alta(cliente);
                                System.out.println("Se registro el cliente: " + cliente);
                            }
                            case "2" -> {
                                Cliente cliente = new Cliente();
                                GestionCliente client = new GestionCliente();
                                client.altaManual(cliente);
                                System.out.println("Se registro el cliente: " + cliente);
                            }
                            case "3" -> {
                                System.out.println("Ingrese su ID");
                                System.out.print("-> ");
                                int id = scan.nextInt();
                                GestionCliente client = new GestionCliente();
                                client.baja(id);
                                System.out.println("Se elimino correctamente el cliente con el ID: " + id);
                            }
                            case "4" -> {
                                System.out.println("Ingrese su ID");
                                System.out.print("-> ");
                                int id = scan.nextInt();
                                GestionCliente client = new GestionCliente();
                                client.modificarM(id);
                                System.out.println("Se modifico correctamente el cliente con el ID: " + id);
                            }
                            default -> System.out.println("La eleccion es invalida");
                        }
                        System.out.println("Desea volver al menu de clientes? s/n");
                        control = scan.nextLine();
                    }
                }
                case "2" -> {
                    GestionAdmin adm = new GestionAdmin();
                    Admin admin = new Admin();
                    adm.AdminPassword(admin);
                    System.out.print("Ingrese el pin de Admin: ");
                    int verificador = scan.nextInt();
                    scan.nextLine();
                    while (verificador==admin.getPin() && control.equalsIgnoreCase("s")) {
                        System.out.println("Elija una opcion:");
                        System.out.println("1. Agregar Producto Automatico");
                        System.out.println("2. Agregar Producto Manual");
                        System.out.println("3. Eliminar Producto");
                        System.out.println("4. Mostrar Productos");
                        System.out.println("5. Modificar Producto");
                        System.out.println("6. Mostrar Clientes");
                        System.out.print("-> ");
                        String opcion2 = scan.nextLine();
                        switch (opcion2) {
                            case "1" -> {
                                Producto producto = new Producto(1, "Naranja", 30, 500, Producto.Categoria.FRUTAS);
                                GestionProducto product = new GestionProducto();
                                product.alta(producto);
                                System.out.println("Se agrego el producto: " + producto);
                            }
                            case "2" -> {
                                Producto producto = new Producto();
                                GestionProducto product = new GestionProducto();
                                product.altaManual(producto);
                                System.out.println("Se agrego el producto: " + producto);
                            }
                            case "3" -> {
                                System.out.println("Ingrese ID de producto");
                                System.out.print("-> ");
                                int id = scan.nextInt();
                                GestionProducto product = new GestionProducto();
                                product.baja(id);
                                System.out.println("Se elimino correctamente el producto con el ID: " + id);

                            }
                            case "4" -> {
                                GestionProducto product = new GestionProducto();
                                product.mostrar();
                            }
                            case "5" -> {
                                System.out.println("Ingrese ID de producto");
                                System.out.print("-> ");
                                int id = scan.nextInt();
                                GestionProducto product = new GestionProducto();
                                product.modificarM(id);
                                System.out.println("Se modifico correctamente el producto con el ID: " + id);
                            }
                            case "6" -> {
                                GestionCliente client = new GestionCliente();
                                client.mostrar();
                            }
                            default -> System.out.println("La eleccion es invalida");
                        }
                        System.out.println("Desea volver al menu de productos? s/n");
                        control = scan.nextLine();
                    }
                    if (verificador!=admin.getPin()){
                        System.out.println("El pin ingresado es erroneo");
                    }
                }
                default -> System.out.println("La eleccion es invalida");
            }
            System.out.println("Desea volver al menu principal? s/n");
            control = scan.nextLine();
        }
    }
}