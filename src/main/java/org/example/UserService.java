package org.example;

public class UserService {
    IUserRepository userRepository;

    public UserService(IUserRepository userRepository){
        this.userRepository = userRepository;
    }

    public boolean isValidEmail(String email){
        if(email!=null && email.matches("^[\\w-\\.]+@([\\w-]+\\.)+([\\w-{2,4}$])")){
            return true;
        }
        return false;
    }

    public boolean isEmailAvailable(String email){
        return !userRepository.isEmailExistsInDatabase(email);
    }

    public String registerUser(String email, String password){
       if(!isValidEmail(email) || email==null){
           throw new IllegalArgumentException("Invalid email");
       }
       if(!isEmailAvailable(email)){
           throw new IllegalArgumentException("The user with the email already exists!");
       }

       if(password==null || password.length()<8){
           throw new IllegalArgumentException("Weak password!");
       }

       userRepository.saveUser(new User(email,password));
       return "User "+email+" successfully registered!";
    }
}
