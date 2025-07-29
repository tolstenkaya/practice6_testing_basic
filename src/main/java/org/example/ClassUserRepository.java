package org.example;

import java.util.ArrayList;
import java.util.List;

public class ClassUserRepository {
    List<User> users = new ArrayList<User>();

    public boolean isEmailExistsInDatabase(String email){
        User found_user = users.stream().filter(u->u.email.equals(email)).findFirst().orElse(null);
        if(found_user!=null)
            return true;

        return false;
    }

    public void saveUser(User new_user){
        users.add(new_user);
    }
}
