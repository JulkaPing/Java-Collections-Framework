package bank;

import list.*;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

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
        boolean resultAdd = bankService.addUser(new User("Alla", "125478"));
        boolean resultDuplicate = bankService.addUser(new User("Alla", "125478"));
        Assertions.assertNotNull(bankService.findByPassport("125478"));
        Assertions.assertTrue(resultAdd);
        Assertions.assertFalse(resultDuplicate);
        System.out.println(getUsers());
    }

    @Test
    public void addAccount() {
        boolean resultAddUser = bankService.addUser(new User("Alla", "125478"));
        boolean resultAddAccountFirst = bankService.addAccount("125478", new Account("87695", 15));
        boolean resultAddAccountSecond = bankService.addAccount("125478", new Account("82395", 25));
        boolean resultAddAccountDuplicate = bankService.addAccount("125478", new Account("87695", 10));

        Assertions.assertTrue(resultAddUser);
        Assertions.assertTrue(resultAddAccountFirst);
        Assertions.assertTrue(resultAddAccountSecond);
        Assertions.assertFalse(resultAddAccountDuplicate);
        Assertions.assertEquals(15, bankService.findByRequisite("125478", "87695").get().getBalance());
    }

    @Test
    public void addBalanceToAccount() {
        boolean resultAddUser = bankService.addUser(new User("Alla", "125478"));
        boolean resultAddAccountFirst = bankService.addAccount("125478", new Account("87695", 15));
        boolean addBalanceSuccess = bankService.addBalanceToAccount("125478", "87695", 25);
        boolean addBalanceSuccessSecond = bankService.addBalanceToAccount("125478", "87695", 42);
        boolean addBalanceInIncorrectAccount = bankService.addBalanceToAccount("125478", "45253", 15);

        Assertions.assertTrue(resultAddUser);
        Assertions.assertTrue(resultAddAccountFirst);
        Assertions.assertTrue(addBalanceSuccess);
        Assertions.assertTrue(addBalanceSuccessSecond);
        Assertions.assertFalse(addBalanceInIncorrectAccount);
        Assertions.assertEquals(82, bankService.findByRequisite("125478", "87695").get().getBalance());
    }

    @Test
    public void withDrawBalanceFromAccount() {
        boolean resultAddUser = bankService.addUser(new User("Alla", "125478"));
        boolean resultAddAccountFirst = bankService.addAccount("125478", new Account("87695", 15));
        boolean addBalanceSuccess = bankService.addBalanceToAccount("125478", "87695", 25);
        boolean addBalanceSuccessSecond = bankService.addBalanceToAccount("125478", "87695", 42);
        boolean unsuccessResult = bankService.withDrawBalanceFromAccount("125478", "87695", 85);
        boolean successResult = bankService.withDrawBalanceFromAccount("125478", "87695", 80);

        Assertions.assertTrue(resultAddUser);
        Assertions.assertTrue(resultAddAccountFirst);
        Assertions.assertTrue(addBalanceSuccess);
        Assertions.assertTrue(addBalanceSuccessSecond);
        Assertions.assertFalse(unsuccessResult);
        Assertions.assertTrue(successResult);
        Assertions.assertEquals(2, bankService.findByRequisite("125478", "87695").get().getBalance());
    }

    @Test
    public void transferMoney() {
        boolean resultAddUserFrom = bankService.addUser(new User("Alla", "125478"));
        boolean resultAddAccountFrom = bankService.addAccount("125478", new Account("87695", 150));
        boolean resultAddUserTo = bankService.addUser(new User("Oleg", "587469"));
        boolean resultAddAccountTo = bankService.addAccount("587469", new Account("12695", 290));
        boolean transferUnsuccessByMoney = bankService.transferMoney("125478", "87695", "587469", "12695", 160);
        boolean transferUnsuccessByRequisite = bankService.transferMoney("125478", "87695", "587469", "18", 20);
        boolean transferUnsuccess = bankService.transferMoney("125478", "87695", "587469", "12695", 140);

        Assertions.assertTrue(resultAddUserFrom);
        Assertions.assertTrue(resultAddAccountFrom);
        Assertions.assertTrue(resultAddUserTo);
        Assertions.assertTrue(resultAddAccountTo);
        Assertions.assertFalse(transferUnsuccessByMoney);
        Assertions.assertFalse(transferUnsuccessByRequisite);
        Assertions.assertTrue(transferUnsuccess);
        Assertions.assertEquals(10, bankService.findByRequisite("125478", "87695").get().getBalance());
        Assertions.assertEquals(430, bankService.findByRequisite("587469", "12695").get().getBalance());
    }

    @Test
    public void removeAccountAndTransferMoney() {
        boolean addUserSuccess = bankService.addUser(new User("Alla", "125478"));
        boolean addAccountFirst = bankService.addAccount("125478", new Account("87695", 220));
        boolean addAccountSecond = bankService.addAccount("125478", new Account("87694", 220));
        boolean addAccountThird = bankService.addAccount("125478", new Account("87693", 120));
        boolean addAccountFourth = bankService.addAccount("125478", new Account("87692", 220));

        boolean result = bankService.deleteAccountByRequisite("125478", "87693");
        Assertions.assertTrue(result);

        List<Account> accounts = List.of(
                bankService.findByRequisite("125478", "87695").get(),
                bankService.findByRequisite("125478", "87694").get(),
                bankService.findByRequisite("125478", "87692").get()
        );

        boolean resultDeleted = bankService.findByRequisite("125478", "87693").isEmpty();
        Assertions.assertTrue(resultDeleted);
        List<Account> rsl = accounts.stream().filter(account -> account.getBalance() == 340).collect(Collectors.toList());
        Assertions.assertEquals(1, rsl.size());
    }
}