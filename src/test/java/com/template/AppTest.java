package com.template;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static com.template.App.*;
import static org.junit.jupiter.api.Assertions.*;

class AppTest {
    @Test
    void testCreate() {
        App app = new App();
        Map<String, Integer> accounts = new HashMap<>();
        create(accounts, "Juan", 0);
        assertEquals(0, accounts.get("Juan"));
    }
    @Test
    void testDeposit() {
        App app = new App();
        Map<String, Integer> accounts = new HashMap<>();
        create(accounts, "Juan", 0);
        deposit(accounts, "Juan", 5);
        assertEquals(5, accounts.get("Juan"));
    }
    @Test
    void testDepositNonExistentAccount() {
        App app = new App();
        Map<String, Integer> accounts = new HashMap<>();
        Map<String, Integer> result = deposit(accounts, "Juan", 10);
        assertFalse(result.containsKey("Juan"));
    }
    @Test
    void testNegativeDeposit() {
        App app = new App();
        Map<String, Integer> accounts = new HashMap<>();
        create(accounts, "Juan", 5);
        deposit(accounts, "Juan", -10);
        assertEquals(5, accounts.get("Juan"));
    }
    @Test
    void testRetire(){
        App app = new App();
        Map<String, Integer> accounts = new HashMap<>();
        create(accounts, "Juan", 15);
        retire(accounts, "Juan", 5);
        assertEquals(10, accounts.get("Juan"));
    }
    @Test
    void testNegativeRetire() {
        App app = new App();
        Map<String, Integer> accounts = new HashMap<>();
        create(accounts, "Juan", 11);
        retire(accounts, "Juan", -10);
        assertEquals(11, accounts.get("Juan"));
    }
    @Test
    void retireEqualsZero() {
        App app = new App();
        Map<String, Integer> accounts = new HashMap<>();
        create(accounts, "Juan", 5);
        retire(accounts, "Juan", 0);
        assertEquals(5, accounts.get("Juan"));
    }
    @Test
    void testRetireNoBalance() {
        App app = new App();
        Map<String, Integer> accounts = new HashMap<>();
        create(accounts, "Juan", 8);
        retire(accounts, "Juan", 9);
        assertEquals(8, accounts.get("Juan"));
    }
    @Test
    void testRetireNonExistentAccount() {
        App app = new App();
        Map<String, Integer> accounts = new HashMap<>();
        retire(accounts, "Juan", 5);
        assertFalse(accounts.containsKey("Juan"));
    }
    @Test
    void testTransfer() {
        App app = new App();
        Map<String, Integer> accounts = new HashMap<>();
        create(accounts, "Juan", 5);
        create(accounts, "Pedro", 10);
        transfer(accounts, "Juan", "Pedro", 3);
        assertEquals(13 , accounts.get("Pedro"));
        assertEquals(2, accounts.get("Juan"));
    }
    @Test
    void emptyTransfer() {
        App app = new App();
        Map<String, Integer> accounts = new HashMap<>();
        create(accounts, "Juan", 0);
        create(accounts, "Pedro", 0);
        transfer(accounts, "Juan", "Pedro", 5);
        assertEquals(0, accounts.get("Juan"));
        assertEquals(0, accounts.get("Pedro"));
    }
    @Test
    void transferNonExistentAccount() {
        App app = new App();
        Map<String, Integer> accounts = new HashMap<>();
        transfer(accounts, "Juan", "Pedro", 5);
        assertFalse(accounts.containsKey("Juan"));
        assertFalse(accounts.containsKey("Pedro"));
    }
    @Test
    void negativeTransfer() {
        App app = new App();
        Map<String, Integer> accounts = new HashMap<>();
        create(accounts, "Juan", 5);
        create(accounts, "Pedro", 10);
        transfer(accounts, "Juan", "Pedro", -3);
        assertEquals(5, accounts.get("Juan"));
        assertEquals(10, accounts.get("Pedro"));
    }
    @Test
    void sameAccountsTransfer() {
        App app = new App();
        Map<String, Integer> accounts = new HashMap<>();
        create(accounts, "Juan", 5);
        transfer(accounts, "Juan", "Juan", 5);
        assertEquals(5, accounts.get("Juan"));
    }
   @Test
   void transferEqualsZero() {
        App app = new App();
        Map<String, Integer> accounts = new HashMap<>();
        create(accounts, "Juan", 5);
        create(accounts, "Pedro", 10);
        transfer(accounts, "Juan", "Pedro", 0);
        assertEquals(5, accounts.get("Juan"));
        assertEquals(10, accounts.get("Pedro"));
   }
}
