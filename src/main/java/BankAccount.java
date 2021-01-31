public class BankAccount extends SavingAccount implements Account {
    private int id;
    private double balance;
    private Owner owner;

    public BankAccount(int id, double interest, double balance, Owner owner) {
        super(interest);
        this.id = id;
        this.balance = balance;
        this.owner = owner;
    }

    public BankAccount() {
        super();
    }

    @Override
    public void deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;

        }
    }

    @Override
    public void withdraw(double amount) throws NoMoneyEx {
        if (amount < balance) {
            this.balance -= amount;
        } else {
            throw new NoMoneyEx();
        }

    }

    public int getId() {
        return id;
    }

    public double getBalance() {
        return balance;
    }

    public Owner getOwner() {
        return owner;
    }
}
