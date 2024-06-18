package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CreditAccountTest {

    /** Тесты конструктора CreditAccount.
     * Заданные параметры корректны — создаётся новый объект кредитного счёта. +
     * initialBalance отрицательный — выкидывается IllegalArgumentException.
     * initialBalance null — выкидывается IllegalArgumentException.
     * creditLimit отрицательный — выкидывается IllegalArgumentException.
     * creditLimit null — выкидывается IllegalArgumentException.
     * rate отрицательный — выкидывается IllegalArgumentException.
     * rate null — выкидывается IllegalArgumentException.
     */

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
    public void shouldShowIllegalArgumentException () {
        CreditAccount account = new CreditAccount(
                0,
                -5_000,
                15
        );

        account.add(3_000);

        Assertions.assertThrows(IllegalArgumentException.class, () -> account.creditLimit = -5_000);

    }
}
