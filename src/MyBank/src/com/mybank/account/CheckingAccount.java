package MyBank.src.com.mybank.account;

public class CheckingAccount extends AbstractAccount {
    public CheckingAccount(String customer, String accountName, double balance, String accountNumber) {
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

    // returns the amount after withdrawing, if successful. Otherwise null
    @Override
    public Double withdraw(double amount) {
        if (amount > 0.0) {
            if (this.getBalance() >= amount) {
                super.withdraw(amount);
                return amount;
            } else {
                // no money for you, sadge
                System.out.println("Insufficient funds: " + this.getBalance());
                return null;
            }
        } else {
            System.out.println("Invalid amount to withdraw: " + amount);
            return null;
        }
    }
}
