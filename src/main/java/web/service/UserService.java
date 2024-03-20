package web.service;

import web.model.User;

import java.util.List;

public interface UserService {

    void saveUser(User user);

    void updateUser (User user);

    List<User> getAllUsers();

    User getUser(Long id);

    void deleteUser (Long id);



}
