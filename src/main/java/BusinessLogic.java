public class BusinessLogic {
    private Bank bank;

    public BusinessLogic(Bank bank) {
        this.bank = bank;
    }

    public BankAccount addNewAccount(Owner owner, double interest, int id) {
        BankAccount account = new BankAccount(id, interest, 0, owner);
        bank.getAccounts().add(account);
        return account;
    }

    public void deposit(double amount, int nrAccount) {
        bank.deposit(nrAccount, amount);
    }

    public void withdraw(double amount, int nrAccount) {
        bank.withdraw(nrAccount, amount);
    }

    public void transfer(int nrAccountFrom, int nrAccountTo, double amount) {
        bank.transfer(nrAccountFrom, nrAccountTo, amount);
    }

    public Bank getBank() {
        return bank;
    }
}
