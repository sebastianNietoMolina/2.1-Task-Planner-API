package edu.escuelaing.edu.co.app.servicios;

import edu.escuelaing.edu.co.app.excepciones.UserException;
import edu.escuelaing.edu.co.app.modelo.User;
import java.util.List;

public interface UserService {

    List<User> getAll();

    User getById(String userId) throws UserException;

    User create(User user) throws UserException;

    User update(User user) throws UserException;

    void remove(String userId) throws UserException;

}
