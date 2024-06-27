package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BankTest {

    //1 перевод с кредитного счёта на сберегательный
    @Test

    public void transferToSavingAccount() {
        CreditAccount credit = new CreditAccount(
                5_000,
                10_000,
                10);

        SavingAccount saving = new SavingAccount(
                5_000,
                1_000,
                25_000,
                5);

        Bank bank = new Bank();
        bank.transfer(credit, saving, 2_000);

        Assertions.assertEquals(3_000, credit.getBalance());
        Assertions.assertEquals(7_000, saving.getBalance());
    }

    //2 перевод со сберегательного на кредитный

    @Test

    public void transferToCreditAccount () {
        CreditAccount credit = new CreditAccount(
                5_000,
                10_000,
                10);

        SavingAccount saving = new SavingAccount(
                5_000,
                1_000,
                25_000,
                5);
        Bank bank = new Bank();

        bank.transfer(saving, credit, 3_000);

        Assertions.assertEquals(8_000, credit.getBalance());
        Assertions.assertEquals(2_000, saving.getBalance());
    }
    //3 перевести с кредитного счёта до лимита
    @Test

    public void transferFromCreditAccountToTheCreditLimit () {
        CreditAccount credit = new CreditAccount(
                5_000,
                10_000,
                10);

        SavingAccount saving = new SavingAccount(
                5_000,
                1_000,
                25_000,
                5);
        Bank bank = new Bank();

        bank.transfer(credit,saving, 15_000);

        Assertions.assertEquals(-10_000, credit.getBalance());
        Assertions.assertEquals(20_000, saving.getBalance());
    }

    //4 перевести с кредитного счёта больше лимита
    @Test

    public void transferFromCreditAccountOverTheCreditLimit () {
        CreditAccount credit = new CreditAccount(
                5_000,
                10_000,
                10);

        SavingAccount saving = new SavingAccount(
                5_000,
                1_000,
                25_000,
                5);
        Bank bank = new Bank();

        boolean result = bank.transfer(credit,saving,17_000);

        Assertions.assertEquals(5_000, credit.getBalance());
        Assertions.assertEquals(5_000, saving.getBalance());
        Assertions.assertEquals(false, result);
    }

    //5 перевести с кредитного счёта больше, чем макс баланс сберегательного
    @Test

    public void transferFromCreditAccountIsMoreThanTheMaxBalance () {
        CreditAccount credit = new CreditAccount(
                7_000,
                10_000,
                10);

        SavingAccount saving = new SavingAccount(
                5_000,
                1_000,
                10_000,
                5);
        Bank bank = new Bank();

        boolean result = bank.transfer(credit,saving, 6_000);

        Assertions.assertEquals(7_000, credit.getBalance());
        Assertions.assertEquals(5_000, saving.getBalance());
        Assertions.assertEquals(false, result);
    }

    //6 перевести со сберегательного счёта до мин баланса

    @Test

    public void transferFromSavingAccountUpToMinBalance () {
        CreditAccount credit = new CreditAccount(
                5_000,
                10_000,
                10);

        SavingAccount saving = new SavingAccount(
                5_000,
                1_000,
                25_000,
                5);
        Bank bank = new Bank();

        bank.transfer(saving, credit, 4_000);

        Assertions.assertEquals(9_000, credit.getBalance());
        Assertions.assertEquals(1_000, saving.getBalance());
    }
    // 7 перевести со сберегательного счёта больше мин баланса
    @Test

    public void transferFromSavingAccountIsMoreThanMinBalance () {
        CreditAccount credit = new CreditAccount(
                5_000,
                10_000,
                10);

        SavingAccount saving = new SavingAccount(
                5_000,
                1_000,
                25_000,
                5);
        Bank bank = new Bank();

        boolean result = bank.transfer(saving, credit, 5_000);

        Assertions.assertEquals(5_000, credit.getBalance());
        Assertions.assertEquals(5_000, saving.getBalance());
        Assertions.assertEquals(false, result);
    }

    // 8 перевести отрицательную сумму
    @Test

    public void transferNegativeAmount () {
        CreditAccount credit = new CreditAccount(
                5_000,
                10_000,
                10);

        SavingAccount saving = new SavingAccount(
                5_000,
                1_000,
                25_000,
                5);
        Bank bank = new Bank();

        boolean result = bank.transfer(saving, credit, -5_000);

        Assertions.assertEquals(5_000, credit.getBalance());
        Assertions.assertEquals(5_000, saving.getBalance());
        Assertions.assertEquals(false, result);
    }

    //9 перевести 0
    @Test

    public void transferTheAmountEqualToZero () {
        CreditAccount credit = new CreditAccount(
                5_000,
                10_000,
                10);

        SavingAccount saving = new SavingAccount(
                5_000,
                1_000,
                25_000,
                5);
        Bank bank = new Bank();

        boolean result = bank.transfer(saving, credit, 0);

        Assertions.assertEquals(5_000, credit.getBalance());
        Assertions.assertEquals(5_000, saving.getBalance());
        Assertions.assertEquals(false, result);
    }
}
