package org.example;

public interface IUserRepository {
    boolean isEmailExistsInDatabase(String email);
    void saveUser(User new_user);
    User findByEmail(String email);
}
