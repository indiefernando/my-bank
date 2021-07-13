package com.mybank.account;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LoanAccountTest {
	LoanAccount account;

	@BeforeEach
	void setUp() throws Exception {
		this.account = new LoanAccount("test customer", "test account name", 0.0, "test account number", 10000.0);
	}

	    //- Has another field (class variable): limit (how much is the maximum loan amount)
		//- Balance cannot be greater than zero
		//-  Can withdraw, deposit, transfer; but with above restrictions in mind
	
	@Test
	public void constructor__limit_parameter__sets_limit() {
		double limit = account.getLimit();
		assertEquals(10000.0, limit);
	}
	
	@Test
	public void setBalance__greater_than_zero__throws() {
		assertThrows(IllegalArgumentException.class, () ->{
			account.setBalance(42.0);
		});
	
		
	}

}
