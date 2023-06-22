package org.example.Productos;

import org.example.Exceptions.RepiteDNI;
import org.example.Exceptions.RepiteID;
import org.example.Interfaces.GestionG;
import org.example.Persona.Clientes.Cliente;

import java.util.Scanner;

public class GestionProducto implements GestionG<Producto> {
    private SerializaProducto productosEstado = new SerializaProducto();


    @Override
    public void alta(Producto objeto){
        try {
            productosEstado.cargar();
            if (null == productosEstado.buscaPorID(objeto.getId())) {
                productosEstado.agregar(objeto);
            } else {
                throw new RepiteID("El ID ingresado ya existe, por favor ingrese otro ID");
            }
            productosEstado.guardar();
            System.out.println("Se agrego el producto: " + objeto);
        } catch (RepiteID e) {
            System.out.println("ERROR: " + e);
        }
    }

    @Override
    public void baja(int id) {
        productosEstado.eliminar(id);
    }

    @Override
    public void mostrar() {
        System.out.println("Lista de productos:");
        for (Producto producto : productosEstado.listar()) {
            System.out.println(producto);
        }
    }

    @Override
    public void modificarM(int id) {
        Producto productoModificado = productosEstado.buscaPorID(id);
        if (productoModificado!=null) {
            Scanner scan = new Scanner(System.in);
            System.out.println("Ingrese nombre de producto");
            productoModificado.setNombre(scan.nextLine());
            System.out.println("Ingrese valor de producto");
            productoModificado.setValor(scan.nextDouble());
            System.out.println("Ingrese el stock del producto");
            productoModificado.setStock(scan.nextInt());
            System.out.println("Elija la categoria para el producto:");
            System.out.println("1. FRUTAS");
            System.out.println("2. VERDURAS");
            System.out.println("3. BEBIDAS");
            System.out.println("4. CONGELADOS");
            System.out.print("-> ");
            int o = scan.nextInt();
            scan.nextLine();
            if (o == 1) {
                productoModificado.setCategoria(Producto.Categoria.FRUTAS);
            } else if (o == 2) {
                productoModificado.setCategoria(Producto.Categoria.VERDURAS);
            } else if (o == 3) {
                productoModificado.setCategoria(Producto.Categoria.BEBIDAS);
            } else if (o == 4) {
                productoModificado.setCategoria(Producto.Categoria.CONGELADOS);
            }
            System.out.println("El producto fue modificado correctamente");
            productosEstado.modificar(productoModificado);
        }
        else{
            System.out.println("El ID "+id+" no existe");
        }
    }

    @Override
    public void altaManual(Producto objeto){
        try {
            productosEstado.cargar();
            int i = 0;
            Scanner scan = new Scanner(System.in);
            System.out.println("Ingrese ID de producto");
            objeto.setId(scan.nextInt());
            scan.nextLine();
            if (null == productosEstado.buscaPorID(objeto.getId())) {
                i = 1;
            } else {
                throw new RepiteID("El ID ingresado ya existe, por favor ingrese otro ID");
            }
            System.out.println("Ingrese nombre de producto");
            objeto.setNombre(scan.nextLine());
            System.out.println("Ingrese valor de producto");
            objeto.setValor(scan.nextDouble());
            System.out.println("Ingrese el stock del producto");
            objeto.setStock(scan.nextInt());
            System.out.println("Elija la categoria para el producto:");
            System.out.println("1. FRUTAS");
            System.out.println("2. VERDURAS");
            System.out.println("3. BEBIDAS");
            System.out.println("4. CONGELADOS");
            System.out.print("-> ");
            int o = scan.nextInt();
            if (o == 1) {
                objeto.setCategoria(Producto.Categoria.FRUTAS);
            } else if (o == 2) {
                objeto.setCategoria(Producto.Categoria.VERDURAS);
            } else if (o == 3) {
                objeto.setCategoria(Producto.Categoria.BEBIDAS);
            } else if (o == 4) {
                objeto.setCategoria(Producto.Categoria.CONGELADOS);
            }
            if (i == 1) {
                productosEstado.agregar(objeto);
                System.out.println("Se agrego el producto: " + objeto);
            }
        } catch (RepiteID e) {
            System.out.println("ERROR: " + e);
        }
    }
}