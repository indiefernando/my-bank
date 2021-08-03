package com.mybank.account;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CheckingAccountTest {
	// Class under test
	CheckingAccount account;
	CheckingAccount transferTo;

	@BeforeEach
	void setup() {
		this.account = new CheckingAccount(
				"customer 1", 
				"test account", 
				0, 
				"test account number"
				);
		
		this.transferTo = new CheckingAccount(
				"customer 2", 
				"test account 2",
				0, 
				"test account number 2"
				);
	}

	@Test
	void deposit__amount_greater_than_zero__works() {
		// Try with good amount (greater than zero)
		double amount = 42.0;

		// Do the actual test
		account.deposit(amount);

		// Get the actual balance
		double balance = account.getBalance();

		// Check it did work
		assertEquals(amount, balance);
	}

	@Test()
	void deposit__amount_less_than_zero__throws() {
		// Bad amount
		double amount = -1.0;

		assertThrows(IllegalArgumentException.class, () -> {
			account.deposit(amount);
		});
	}

	@Test
	void deposit_amount_equal_to_zero__throws() {
		// Another bad amount
		double amount = 0.0;

		// Do it
		assertThrows(IllegalArgumentException.class, () -> {
			account.deposit(amount);
		});
	}

	@Test
	void withdraw__amount_greater_than_zero__works() throws InsufficientFundsException {
		double amount = 100;
		account.deposit(amount + 1);
		account.withdraw(amount);
		assertEquals(1.0, account.getBalance());
	}

	@Test
	void checking_account_withdraw() throws InsufficientFundsException {
		double withdrawAmount = 500;
		account.setBalance(withdrawAmount);

		assertEquals(withdrawAmount, account.withdraw(withdrawAmount));

		double newAmount = -5.6;

		assertThrows(IllegalArgumentException.class, () -> {
			account.withdraw(newAmount);
		});

		assertThrows(InsufficientFundsException.class, () -> {
			account.withdraw(10);
		});
	}
	
	@Test
	void checking_account__Transfer() throws InsufficientFundsException {
		double amountToTransfer = 50;
		
		account.deposit(100.0);
		account.transfer(transferTo, amountToTransfer);
		
		assertEquals(amountToTransfer, transferTo.getBalance());		
	}

}
