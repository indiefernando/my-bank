package MyBank.src.com.mybank.account;

import java.util.Arrays;
import java.util.List;

public class MusicalChairs {
    public static void play() throws InsufficientFundsException {
        CheckingAccount one = new CheckingAccount(
                "customer one",
                "customer one account",
                100.0,
                "c1");

        SavingsAccount two = new SavingsAccount(
                "saver two",
                "saver two's savings account",
                100.0,
                "s2"
        );

        CheckingAccount three = new CheckingAccount(
                "customer three",
                "customer three's account",
                100.0,
                "c3"
        );

        SavingsAccount four = new SavingsAccount(
                "saver four",
                "saver four's savings account",
                100.0,
                "s4"
        );

        CheckingAccount five = new CheckingAccount(
                "customer five",
                "customer five's account",
                100.0,
                "c5"
        );

        List<AbstractAccount> allAccounts = Arrays.asList(one, two, three, four, five);

        for(int amount = 1; amount < 1000; amount++) {
            int i = amount % 5; // modulo (%) nifty little trick to keep a number between 0 and 4 in this case
            int j = (i + 1) % 5;
            AbstractAccount fromAccount = allAccounts.get(i);
            AbstractAccount toAccount = allAccounts.get(j);

            // transfer moniez!!!
            Double amountTransferred = fromAccount.transfer(toAccount, amount);

            // check if transfer worked, if not, break out of loop
            if (amountTransferred == null) {
                break;
            }
        }

        // print all balances at the end of the game
        // hint: System.out.println("Account one balance: " + one.getBalance());
        for (AbstractAccount account : allAccounts) {
            System.out.println(account.getAccountName() + " - balance : " + account.getBalance());
        }
    }
}
