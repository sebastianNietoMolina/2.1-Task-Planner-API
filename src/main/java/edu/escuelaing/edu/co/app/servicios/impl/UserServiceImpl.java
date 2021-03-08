package edu.escuelaing.edu.co.app.servicios.impl;

import edu.escuelaing.edu.co.app.excepciones.UserException;
import edu.escuelaing.edu.co.app.modelo.User;
import edu.escuelaing.edu.co.app.servicios.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("UserServiceImpl")
public class UserServiceImpl implements UserService {

    public List<User> userList;

    public UserServiceImpl(){
        userList = new ArrayList<User>();
        User user1 = new User("1", "Sebastian Nieto", "juan@gmail.com", "123");
        User user2 = new User("2", "Juan Nieto", "seb@gmail.com", "123");
        userList.add(user1);
        userList.add(user2);
    }

    @Override
    public List<User> getAll() {
        return userList;
    }

    @Override
    public User getById(String userId) throws UserException {
        User respuesta = null;
        for(User user: userList){
            if(user.getId().equals(userId)){
                respuesta = user;
            }
        }
        if(respuesta==null){
            throw new UserException("El usuario buscado no existe.");
        }else{
            return respuesta;
        }
    }

    @Override
    public User create(User user) throws UserException {
        for(User u: userList){
            if(u.getMail().equals(user.getMail())){
                throw new UserException("El correo que ingreso ya tiene una cuenta.");
            }
        }
        userList.add(user);
        user.setId(Integer.toString(userList.size()));
        return user;
    }

    @Override
    public User update(User user) throws UserException {
        boolean bandera = true;
        for(User u: userList){
            if(u.getId().equals(user.getId())){
                bandera = false;
                u.setNombre(user.getNombre());
                u.setContraseña(user.getContraseña());
                u.setMail(user.getMail());

            }
        }
        if(bandera){
            throw new UserException("Tu cuenta a dejado de existir");
        }else{
            return user;
        }
    }

    @Override
    public void remove(String userId) throws UserException {
        boolean nuevaPosicion = false;
        for(User u: userList){
            if(nuevaPosicion){
                u.setId(Integer.toString(Integer.parseInt(u.getId())-1));
            }
            if(u.getId().equals(userId)){
                userList.remove(u);
                nuevaPosicion = true;
            }
        }
        if(!nuevaPosicion){
            throw new UserException("Tu cuenta no existe");
        }
    }
}
