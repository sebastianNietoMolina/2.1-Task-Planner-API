package edu.escuelaing.edu.co.app.excepciones;

public class UserException extends Exception{

    public UserException(String mensaje){
        super(mensaje);
    }
    public UserException(String mensaje, Throwable causa){
        super(mensaje, causa);
    }
}
