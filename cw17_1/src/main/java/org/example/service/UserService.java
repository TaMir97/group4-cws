package org.example.service;


import org.example.entity.User;
import org.example.repository.UserRepo;

public class UserService {

    private final UserRepo repository = new UserRepo();


    public void save(User user){
        try {
            repository.beginTransaction();
            repository.save(user);

            repository.commitTransaction();

        }catch (Exception e){
            repository.rollBack();
        }

    }

}
