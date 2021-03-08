package edu.escuelaing.edu.co.app.modelo;

public class User {

    public String id;
    public String nombre;
    public String mail;
    public String contraseña;

    public User(){}

    public User(String id, String nombre, String mail, String contraseña) {
        this.id = id;
        this.nombre = nombre;
        this.mail = mail;
        this.contraseña = contraseña;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
}
