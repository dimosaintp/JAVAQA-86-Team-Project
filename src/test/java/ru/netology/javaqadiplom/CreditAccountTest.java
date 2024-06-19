package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CreditAccountTest {

    @Test
    public void shouldAddToPositiveBalance() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        account.add(3_000);

        Assertions.assertEquals(3_000, account.getBalance());
    }

    @Test
    public void shouldShowExceptionWhenInitialBalanceIsNegative() throws IllegalArgumentException {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            CreditAccount account = new CreditAccount(
                    -1_000,
                    5_000,
                    15
            );
        });
    }

    @Test
    public void shouldShowExceptionWhenCreditLimitIsNegative() throws IllegalArgumentException {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            CreditAccount account = new CreditAccount(
                    1_000,
                    -5_000,
                    15
            );
        });
    }

    @Test
    public void shouldShowExceptionWhenRateIsNegative() throws IllegalArgumentException {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            CreditAccount account = new CreditAccount(
                    1_000,
                    5_000,
                    -15
            );
        });
    }

    @Test
    public void shouldReturnTrueWhenAmountMoreBalanceAndLessCreditLimit() {
        CreditAccount account = new CreditAccount(
                1_000,
                5_000,
                15
        );

        Assertions.assertTrue(account.pay(2000));
    }

    @Test
    public void shouldReturnTrueWhenAmountLessBalance() {
        CreditAccount account = new CreditAccount(
                1_000,
                5_000,
                15
        );

        Assertions.assertTrue(account.pay(700));
    }

    @Test
    public void shouldReturnTrueWhenAmountLessBalancePlusCreditLimit() {
        CreditAccount account = new CreditAccount(
                1_000,
                5_000,
                15
        );

        Assertions.assertTrue(account.pay(5800));
    }

    @Test
    public void shouldReturnFalseWhenAmountMoreBalancePlusCreditLimit() {
        CreditAccount account = new CreditAccount(
                1_000,
                5_000,
                15
        );

        System.out.println(account.getBalance());

        Assertions.assertFalse(account.pay(7000));
    }

    //Todo: добавить тесты на ожидаемый баланс после покупки.








}