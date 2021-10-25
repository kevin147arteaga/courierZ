package com.example.courierz;

public class User {
    private String Nombres;
    private String Apellidos;
    private String DNI;
    private String Tipo;
    private String Password;

    public User(){}

    public User(String nombres, String apellidos, String DNI, String tipo, String password) {
        Nombres = nombres;
        Apellidos = apellidos;
        this.DNI = DNI;
        Tipo = tipo;
        Password = password;
    }

    public String getNombres() {
        return Nombres;
    }

    public void setNombres(String nombres) {
        Nombres = nombres;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String apellidos) {
        Apellidos = apellidos;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String tipo) {
        Tipo = tipo;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) { Password = password; }
}
