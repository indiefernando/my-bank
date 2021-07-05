package MyBank.src.com.mybank.account;

public class SavingsAccount extends AbstractAccount {

    public SavingsAccount(String customer, String accountName, double balance, String accountNumber) {
        super(customer, accountName, balance, accountNumber);
    }

    @Override
    public Double deposit(double amount) {
        if (amount > 0.0) {
            super.deposit(amount);
            return amount;
        } else {
            System.out.println("Invalid amount to deposit: " + amount);
            return null;
        }
    }

    @Override
    public Double withdraw(double amount) {
        System.out.println("Cannot withdraw from a savings account.");
        return null;
    }
}
