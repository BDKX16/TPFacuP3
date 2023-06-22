package org.example.Persona.Admin;

public class GestionAdmin {
    public int AdminPassword(Admin admin){
        admin.setPin(12345);
        return admin.getPin();
    }
}
