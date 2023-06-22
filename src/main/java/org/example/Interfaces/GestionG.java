package org.example.Interfaces;

import org.example.Exceptions.RepiteDNI;
import org.example.Exceptions.RepiteID;
import org.example.Persona.Clientes.Cliente;

public interface GestionG<T> {
    void alta(T objeto)throws RepiteID, RepiteDNI;
    void altaManual(T objeto)throws RepiteID, RepiteDNI;
    public void baja(int id);
    void mostrar();
    void modificarM(int id) throws RepiteDNI;
}
