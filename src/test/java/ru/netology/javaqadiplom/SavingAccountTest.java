package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SavingAccountTest {

    //1 пополнение меньше максмального баланса
    @Test
    public void shouldAddLessThanMaxBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.add(3_000);

        Assertions.assertEquals(2_000 + 3_000, account.getBalance());
    }

    //2 пополнение больше максимального баланса
    @Test
    public void shouldAddMoreThanMaxBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5);

        boolean result = account.add(12_000);

        Assertions.assertEquals(2_000, account.getBalance());
        Assertions.assertEquals(false, result);
    }

    //3 пополнение на 0
    @Test
    public void shouldBeReplenishedToZero() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5);
        boolean result = account.add(0);

        Assertions.assertEquals(2_000, account.getBalance());
        Assertions.assertEquals(false, result);

    }

    //4 поплнение на отрицательную сумму
    @Test
    public void shouldBeReplenishedToNegative() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5);
        boolean result = account.add(-500);

        Assertions.assertEquals(2_000, account.getBalance());
        Assertions.assertEquals(false, result);
    }

    //6 после покупки баланс больше минимального
    @Test

    public void afterThePurchaseTheBalanceIsGreaterThanTheMin() {
        SavingAccount account = new SavingAccount(
                9_000,
                1_000,
                15_000,
                5);

        boolean result = account.pay(5_000);

        Assertions.assertEquals(4_000, account.getBalance());
        Assertions.assertEquals(true, result);
    }

    //7 после покупки баланс меньше минимального
    @Test

    public void afterThePurchaseTheBalanceIsLessThanTheMin() {
        SavingAccount account = new SavingAccount(
                9_000,
                1_000,
                15_000,
                5);

        boolean result = account.pay(15_000);
        Assertions.assertEquals(9_000, account.getBalance());
        Assertions.assertEquals(false, result);
    }


    //8 покупка на сумму 0
    @Test

    public void purchaseAmountIsZero() {
        SavingAccount account = new SavingAccount(
                5_000,
                1_000,
                10_000,
                5);

        boolean result = account.pay(0);

        Assertions.assertEquals(5_000,  account.getBalance());
        Assertions.assertEquals(false, result);
    }
   //9 покупка на отрицательную сумму
    @Test

    public void purchaseAmountIsNegative() {
        SavingAccount account = new SavingAccount(
                5_000,
                1_000,
                10_000,
                5);

        boolean result = account.pay(-1_500);

        Assertions.assertEquals(5_000,  account.getBalance());
        Assertions.assertEquals(false, result);
    }

    //10 процентная ставка

    @Test
    public void calculationOfTheInterestRate() {
        SavingAccount account = new SavingAccount(
                1_000,
                500,
                10_000,
                20);


        Assertions.assertEquals(200, account.yearChange());
    }

    //11 исключение отрицательного начального баланса
    @Test
    public void throwExceptionIfTheInitialBalanceIsNegative () {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> {
            SavingAccount account = new SavingAccount(
                    -1000,
                    1_000,
                    10_000,
                    5);
            System.out.println(account.getBalance());
        }  );
    }
    //12 исключение отрицательной ставки
    @Test
    public void throwExceptionIfTheRateIsNegative () {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> {
                    SavingAccount account = new SavingAccount(
                            1000,
                            1_000,
                            10_000,
                            -5);
                }  );
    }

    //13 исключение отрицвтельного минимального баланса
    @Test
    public void throwExceptionIfTheMinBalanceIsNegative () {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> {
                    SavingAccount account = new SavingAccount(
                            1000,
                            -500,
                            10_000,
                            5);
                }  );
    }

    //14 исключение, если макс баланс меньше минимального
    @Test
    public void throwExceptionIfTheMaxBalanceLessThanMinBalance () {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> {
                    SavingAccount account = new SavingAccount(
                            1000,
                            10_000,
                            1_000,
                            5);
                }  );
    }

    //15 исключение, если начальный баланс меньше минимального
    @Test
    public void throwExceptionIfTheInitialBalanceLessThanMinBalance () {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> {
                    SavingAccount account = new SavingAccount(
                            0,
                            1_000,
                            10_000,
                            5);
                }  );
    }
    //16 исключение, если начальный баланс больше максимального
    @Test
    public void throwExceptionIfTheInitialBalanceMoreThanMaxBalance () {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> {
                    SavingAccount account = new SavingAccount(
                            15_000,
                            1_000,
                            10_000,
                            5);
                }  );
    }

    // 17 после покупки баланс равен минимальному
    @Test

    public void initialBalanceIsEqualToTheMinBalance() {
        SavingAccount account = new SavingAccount(
                9_000,
                1_000,
                15_000,
                5);

        boolean result = account.pay(8_000);

        Assertions.assertEquals(1_000, account.getBalance());
        Assertions.assertEquals(true, result);
    }

    // 18 после пополнения баланс равен максимальному

    @Test

    public void initialBalanceIsEqualToTheMaxBalance() {
        SavingAccount account = new SavingAccount(
                9_000,
                1_000,
                15_000,
                5);

        boolean result = account.add(6_000);

        Assertions.assertEquals(15_000, account.getBalance());
        Assertions.assertEquals(true, result);
    }

    // 19 ставка равна 0

    @Test
    public void cumulativeRateIsZero() {
        SavingAccount account = new SavingAccount(
                1_000,
                500,
                10_000,
                0);


        Assertions.assertEquals(0, account.yearChange());
    }

    // 20 вызов минимального баланса

    @Test
    public void giveMinBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5);


        Assertions.assertEquals(1_000, account.getMinBalance());

    }
    //21 вызов максимального баланса

        @Test
        public void giveMaxBalance() {
            SavingAccount account = new SavingAccount(
                    2_000,
                    1_000,
                    10_000,
                    5);


            Assertions.assertEquals(10_000, account.getMaxBalance());
        }

}