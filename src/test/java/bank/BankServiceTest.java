package bank;

import list.*;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

public class BankServiceTest {
    public List<User> getUsers() {
        return List.of(
                new User("Alla", "125478"),
                new User("Oleg", "587469")
                );
    }

    private final BankService bankService = new BankService();

    @Test
    public void addUserTest() {
        bankService.addUser(new User("Alla", "125478"));
        Assertions.assertNotNull(bankService.findByPassport("125478"));

        System.out.println(getUsers());
    }

   /* @Test
    public void addAccount() {
        bankService.addAccount(new Account("8769548587266954858726", 0));

        Assertions.assertIterableEquals((bankService.findByRequisite("125478", "8769548587266954858726")).);
        System.out.println(bankService.addAccount(new Account("8769548587266954858726", 0)));

    }*/

}