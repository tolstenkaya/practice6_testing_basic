package org.example;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserServiceTest {
    UserService userService=new UserService(new ClassUserRepository());

    @Test
    void testValidEmail(){
        assertTrue(userService.isValidEmail("qwe@gmail.com"));
    }

    @Test
    void testInvalidEmail(){
        assertFalse(userService.isValidEmail("qwerty"));
    }

    @Test
    void testDiscountForVIP(){
        double final_amount = userService.calculateDiscount(1000, true);
        assertEquals(800.0,final_amount);
    }

    @Test
    void testDiscountForRegular(){
        double final_amount = userService.calculateDiscount(1000,false);
        assertEquals(950,final_amount);
    }

    @Test
    void testCalculateDiscount(){
        double start_amount = 1000;
        boolean isVip = true;
        double final_amount_with_discount = userService.calculateDiscount(start_amount,isVip);
        double percent_of_discount = Math.round((1-final_amount_with_discount/start_amount)*100);
        //assertEquals(20,percent_of_discount);
        assertTrue(percent_of_discount<=20);
    }


}
