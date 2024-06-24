package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CreditAccountTest {

    /*
    Конструктор CreditAccount
    */

    // Должно выкидываться исключение при создании счета с отрицательным балансом.
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

    // Должно выкидываться исключение при создании счета с отрицательным кредитным лимитом.
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

    // Должно выкидываться исключение при создании счета с отрицательной ставкой.
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

//    // Должно выкидываться исключение при создании счета с балансом больше, чем кредитный лимит.
//    @Test
//    public void shouldShowExceptionWhenInitialBalanceMoreThanCreditLimit() throws IllegalArgumentException {
//        Assertions.assertThrows(IllegalArgumentException.class, () -> {
//            CreditAccount account = new CreditAccount(
//                    6_000,
//                    5_000,
//                    15
//            );
//        });
//    }

    /*
    Метод pay
    */

    // Успешная оплата. Покупка меньше баланса и меньше лимита.
    @Test
    public void successfulPaymentAmountLessThanBalanceAndLimit() {
        CreditAccount account = new CreditAccount(
                1_000,
                5_000,
                15
        );

        account.pay(500);

        Assertions.assertEquals(500, account.getBalance());
    }

    // Успешная оплата. Покупка равна балансу, но меньше лимита.
    @Test
    public void successfulPaymentAmountEqualBalanceAndLessLimit() {
        CreditAccount account = new CreditAccount(
                1_000,
                5_000,
                15
        );

        account.pay(1_000);

        Assertions.assertEquals(0, account.getBalance());
    }

    // Успешная оплата. Покупка больше баланса, но меньше лимита.
    @Test
    public void successfulPaymentAmountMoreBalanceAndLessLimit() {
        CreditAccount account = new CreditAccount(
                1_000,
                5_000,
                15
        );

        account.pay(2_000);

        Assertions.assertEquals(-1_000, account.getBalance());
    }

    // Успешная оплата. Покупка больше баланса, но равна лимиту.
    @Test
    public void successfulPaymentAmountMoreBalanceAndEqualLimit() {
        CreditAccount account = new CreditAccount(
                1_000,
                5_000,
                15
        );

        account.pay(5_000);

        Assertions.assertEquals(-4_000, account.getBalance());
    }

    // Оплата не возможна. Покупка больше баланса и больше лимита.
    @Test
    public void unsuccessfulPaymentAmountMoreBalanceAndMoreLimit() {
        CreditAccount account = new CreditAccount(
                1_000,
                5_000,
                15
        );

        account.pay(8_000);

        Assertions.assertEquals(1_000, account.getBalance());
    }

    // Оплата не возможна. Сумма покупки отрицательна.
    @Test
    public void unsuccessfulPaymentAmountIsNegative() {
        CreditAccount account = new CreditAccount(
                1_000,
                5_000,
                15
        );

        account.pay(-1_000);

        Assertions.assertEquals(1_000, account.getBalance());
    }

    /*
    Метод add
    */

    // Успешное пополнение счета, если начальный баланс равен нулю.
    @Test
    public void shouldAddToPositiveBalanceIfInitialBalanceIsNull() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        account.add(3_000);

        Assertions.assertEquals(3_000, account.getBalance());
    }

    // Успешное пополнение счета, если на балансе есть любая положительная сумма.
    @Test
    public void shouldAddToPositiveBalanceIfInitialBalanceIsPositive() {
        CreditAccount account = new CreditAccount(
                1_000,
                5_000,
                15
        );

        account.add(2_000);

        Assertions.assertEquals(3_000, account.getBalance());
    }

    // Пополнение невозможно. Сумма пополнения отрицательна.
    @Test
    public void shouldNotAddToPositiveBalanceIfAmountIsNegative() {
        CreditAccount account = new CreditAccount(
                1_000,
                5_000,
                15
        );

        Assertions.assertFalse(account.add(-2_000));
    }

    /*
    Метод yearChange
     */

    // Успешное вычисление процентов на отрицательный баланс счёта.
    @Test
    public void shouldCalculatePercentOnNegativeBalance() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        account.pay(2_000);

        Assertions.assertEquals(-2_300, account.yearChange());
    }

    // Проценты не начисляются если на балансе счета null.
    @Test
    public void shouldNotCalculatePercentOnNullBalance() {
        CreditAccount account = new CreditAccount(
                0,
                12_000,
                13
        );

        Assertions.assertEquals(0, account.yearChange());
    }

    // Проценты не начисляются на положительный баланс счёта.
    @Test
    public void shouldNotCalculatePercentOnPositiveBalance() {
        CreditAccount account = new CreditAccount(
                1_000,
                5_000,
                15
        );

        int expected = 1000;

        Assertions.assertEquals(1000, account.getBalance());
    }

}