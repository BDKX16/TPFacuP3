package org.example.Persona.Clientes;

import org.example.Exceptions.RepiteDNI;
import org.example.Exceptions.RepiteID;
import org.example.Interfaces.GestionG;
import java.util.Scanner;

public class GestionCliente implements GestionG<Cliente> {
    private SerializaCliente clientesEstado = new SerializaCliente();


    @Override
    public void alta(Cliente objeto){
        try{
            clientesEstado.cargar();
            int i=0;
            if(null==clientesEstado.buscaPorID(objeto.getId())){
                i++;
            }
            else{
                throw new RepiteID("El ID ingresado ya existe, por favor ingrese otro ID");
            }
            if(null==clientesEstado.buscaPorDNI(objeto.getDni())){
                i++;
            }
            else{
                throw new RepiteDNI("El Dni ingresado ya existe, por favor ingrese otro Dni");
            }
            if(i == 2){
                clientesEstado.agregar(objeto);
            }

            System.out.println("Se registro el cliente: " + objeto);
        }catch(RepiteID | RepiteDNI e){
            System.out.println("Error: " + e);
        }
    }

    @Override
    public void baja(int id) {
        int check=clientesEstado.verificacion(id);
        if(check==1){
            clientesEstado.eliminar(id);
            System.out.println("Se elimino correctamente el cliente con el ID: " + id);
        }
    }

    @Override
    public void mostrar() {
        System.out.println("Lista de clientes:");
        for (Cliente cliente: clientesEstado.listar()){
            System.out.println(cliente);
        }
    }

    @Override
    public void modificarM(int id){
        int check=0;
        Cliente clienteModificado=clientesEstado.buscaPorID(id);
        Scanner scan = new Scanner(System.in);
        if(check!=clientesEstado.verificacion(id)){
            System.out.println("Ingrese el nuevo nombre del cliente");
            clienteModificado.setNombre(scan.nextLine());
            System.out.println("Ingrese el nuevo apellido del cliente");
            clienteModificado.setApellido(scan.nextLine());
            System.out.println("Ingrese la calle del cliente");
            clienteModificado.setCalle(scan.nextLine());
            System.out.println("Ingrese la altura de la calle del cliente");
            clienteModificado.setAlturaCalle(scan.nextInt());
            scan.nextLine();
            System.out.println("Ingrese la ciudad del cliente");
            clienteModificado.setCiudad(scan.nextLine());
            System.out.println("Ingrese el nuevo saldo del cliente");
            clienteModificado.setSaldo(scan.nextDouble());
            clientesEstado.modificar(clienteModificado);
            System.out.println("Se modifico correctamente el cliente con el ID: " + id);
        }
    }

    @Override
    public void altaManual(Cliente objeto){
        int i=0;
        Scanner scan = new Scanner(System.in);
        try {
            clientesEstado.cargar();
            System.out.println("Ingrese un ID que desee");
            objeto.setId(scan.nextInt());
            if (null == clientesEstado.buscaPorID(objeto.getId())) {
                i++;
            } else {
                throw new RepiteID("El ID ingresado ya existe, por favor ingrese otro ID");
            }
            System.out.println("Ingrese su Pin");
            objeto.setPin(scan.nextInt());
            scan.nextLine();
            System.out.println("Ingrese nombre");
            objeto.setNombre(scan.nextLine());
            System.out.println("Ingrese apellido");
            objeto.setApellido(scan.nextLine());
            System.out.println("Ingrese DNI");
            objeto.setDni(scan.nextLine());
            if (null == clientesEstado.buscaPorDNI(objeto.getDni())) {
                i++;
            } else {
                throw new RepiteDNI("El DNI ingresado ya existe, por favor ingrese otro Dni");
            }
            System.out.println("Ingrese la calle en la que reside");
            objeto.setCalle(scan.nextLine());
            System.out.println("Ingrese la altura de la calle");
            objeto.setAlturaCalle(scan.nextInt());
            scan.nextLine();
            System.out.println("Ingrese la ciudad de residencia");
            objeto.setCiudad(scan.nextLine());
            System.out.println("Ingrese su saldo de cuenta");
            objeto.setSaldo(scan.nextDouble());
            if (i == 2) {
                clientesEstado.agregar(objeto);
                System.out.println("Se registro el cliente: " + objeto);
            }
        }catch(RepiteID | RepiteDNI e){
            System.out.println("Error: " + e);
        }
    }
}
