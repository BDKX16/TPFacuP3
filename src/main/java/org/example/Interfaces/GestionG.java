package org.example.Interfaces;

public interface GestionG<T> {
    void alta(T objeto);
    public void baja(int id);
    void mostrar();
    void modificar(int id);
}
