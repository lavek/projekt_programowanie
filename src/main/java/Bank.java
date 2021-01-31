import java.util.ArrayList;

public class Bank implements BankingOperations {
    private ArrayList<BankAccount> accounts = new ArrayList<>();

    public Bank() {
    }

    public ArrayList<BankAccount> getAccounts() {
        return accounts;
    }

    @Override
    public void deposit(int nrAccount, double amount) {
        try {
            accounts.stream()
                    .filter(account -> account.getId() == nrAccount)
                    .findFirst().map(bankAccount -> {
                bankAccount.deposit(amount);
                return bankAccount;

            }).orElseThrow(NrAccountEx::new);
        } catch (NrAccountEx nrAccountEx) {
            nrAccountEx.printStackTrace();
        }
    }

    @Override
    public void withdraw(int nrAccount, double amount) {

        accounts.stream()
                .filter(account -> account.getId() == nrAccount)
                .findFirst()
                .map(bankAccount -> {
                    try {
                        bankAccount.withdraw(amount);
                    } catch (NoMoneyEx noMoneyEx) {
                        noMoneyEx.printStackTrace();
                    }
                    return bankAccount;
                });
    }

    @Override
    public void transfer(int nrAccountFrom, int nrAccountTo, double amount) {
        BankAccount accountFrom = getAccountById(nrAccountFrom);
        BankAccount accountTo = getAccountById(nrAccountTo);
        try {
            accountFrom.withdraw(amount);
            accountTo.deposit(amount);
        } catch (NoMoneyEx noMoneyEx) {
            noMoneyEx.printStackTrace();
        }

    }

    public BankAccount getAccountById(int id) {
        try {
            return accounts.stream()
                    .filter(account -> account.getId() == id)
                    .findFirst().orElseThrow(NrAccountEx::new);
        } catch (NrAccountEx nrAccountEx) {
            nrAccountEx.printStackTrace();
        }
        return new BankAccount();
    }
}
