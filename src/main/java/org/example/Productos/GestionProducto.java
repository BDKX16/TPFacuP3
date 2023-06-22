package org.example.Productos;

import org.example.Exceptions.RepiteDNI;
import org.example.Exceptions.RepiteID;
import org.example.Interfaces.GestionG;
import org.example.Persona.Clientes.Cliente;

import java.util.Scanner;

public class GestionProducto implements GestionG<Producto> {
    private SerializaProducto productosEstado = new SerializaProducto();


    @Override
    public void alta(Producto objeto)throws RepiteID {
        productosEstado.cargar();
        if(null==productosEstado.buscaPorID(objeto.getId())){
            productosEstado.agregar(objeto);
        }
        else{
            throw new RepiteID("El ID ingresado ya existe, por favor ingrese otro ID");
        }
        productosEstado.guardar();
    }

    @Override
    public void baja(int id) {
        productosEstado.eliminar(id);
    }

    @Override
    public void mostrar() {
        for (Producto producto: productosEstado.listar()){
            System.out.println("Lista de productos:");
            System.out.println(producto);
        }
    }

    @Override
    public void modificarM(int id) {
        Producto productoModificado=productosEstado.buscaPorID(id);
        Scanner scan = new Scanner(System.in);
        System.out.println("Ingrese el nuevo nombre del producto");
        productoModificado.setNombre(scan.nextLine());
        System.out.println("Ingrese el nuevo valor del producto");
        productoModificado.setValor(scan.nextDouble());
        System.out.println("Ingrese el stock del producto");
        productoModificado.setStock(scan.nextInt());
        String control = "s";
        while(control.equalsIgnoreCase("s")) {
            System.out.println("Elija la categoria para el producto:");
            System.out.println("1. FRUTAS");
            System.out.println("2. VERDURAS");
            System.out.println("3. BEBIDAS");
            System.out.println("4. CONGELADOS");
            System.out.print("-> ");
            String opcion2 = scan.nextLine();
            switch (opcion2) {
                case "1" -> {
                    productoModificado.setCategoria(Producto.Categoria.FRUTAS);
                }
                case "2" -> {
                    productoModificado.setCategoria(Producto.Categoria.VERDURAS);
                }
                case "3" -> {
                    productoModificado.setCategoria(Producto.Categoria.BEBIDAS);
                }
                case "4" -> {
                    productoModificado.setCategoria(Producto.Categoria.CONGELADOS);
                }
                default -> System.out.println("La eleccion es invalida");
            }
            System.out.println("Si su eleccion no fue correcta presione 's'");
            control = scan.nextLine();
        }
        productoModificado.setCategoria(Producto.Categoria.valueOf(scan.nextLine()));
        productosEstado.modificar(productoModificado);
    }

    @Override
    public void altaManual(Producto objeto) throws RepiteID {
        productosEstado.cargar();
        int i=0;
        Scanner scan = new Scanner(System.in);
        System.out.println("Ingrese ID de producto");
        objeto.setId(scan.nextInt());
        if(null==productosEstado.buscaPorID(objeto.getId())){
            i=1;
        }
        else{
            throw new RepiteID("El ID ingresado ya existe, por favor ingrese otro ID");
        }
        System.out.println("Ingrese nombre de producto");
        objeto.setNombre(scan.nextLine());
        System.out.println("Ingrese valor de producto");
        objeto.setValor(scan.nextDouble());
        System.out.println("Ingrese el stock del producto");
        objeto.setStock(scan.nextInt());
        String control = "s";
        while(control.equalsIgnoreCase("s")) {
            System.out.println("Elija la categoria para el producto:");
            System.out.println("1. FRUTAS");
            System.out.println("2. VERDURAS");
            System.out.println("3. BEBIDAS");
            System.out.println("4. CONGELADOS");
            System.out.print("-> ");
            String opcion2 = scan.nextLine();
            switch (opcion2) {
                case "1" -> {
                    objeto.setCategoria(Producto.Categoria.FRUTAS);
                }
                case "2" -> {
                    objeto.setCategoria(Producto.Categoria.VERDURAS);
                }
                case "3" -> {
                    objeto.setCategoria(Producto.Categoria.BEBIDAS);
                }
                case "4" -> {
                    objeto.setCategoria(Producto.Categoria.CONGELADOS);
                }
                default -> System.out.println("La eleccion es invalida");
            }
            System.out.println("Si su eleccion NO fue correcta presione 's'");
            control = scan.nextLine();
        }
        objeto.setCategoria(Producto.Categoria.valueOf(scan.nextLine()));
        if (i==1){
            productosEstado.agregar(objeto);
        }
    }
}
