package org.example.Interfaces;

import org.example.Exceptions.RepiteDNI;

import java.util.List;

public interface Repository<T> {
    void cargar();
    void guardar();
    void agregar(T objeto);
    List<T> listar();
    T buscaPorID(int id);
    void eliminar(int id);
    void modificar(T objeto);
}
