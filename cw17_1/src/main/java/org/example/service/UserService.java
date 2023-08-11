package org.example.service;


import org.example.entity.User;
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

    public void update(User user) {
        try {
            repository.beginTransaction();
            repository.update(user);
            repository.commitTransaction();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            repository.rollBack();
        }
    }

    public User readById(Long id) {
        try {
            return repository.readById(id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public void deleteById(Long id) {
        try {
            repository.beginTransaction();
            repository.deleteById(id);
            repository.commitTransaction();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            repository.rollBack();
        }

    }

    public boolean contains(User user) {
        return repository.contains(user);

    }

}
