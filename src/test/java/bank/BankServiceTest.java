package bank;

import list.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BankServiceTest {
    public List<User> getUsers() {
        return List.of(
                new User("Alla", "125478"),
                new User("Oleg", "587469")
                );
    }

    private final BankService bankService = new BankService();

   /* @Test
    public void addUserTest() {

        List<User> result = bankService.findByPassport(isNull);
        List<User> expected = List.of();

        Assertions.assertEquals(2, result.size());
        //Assertions.assertIterableEquals(expected, result);
    }*/

}