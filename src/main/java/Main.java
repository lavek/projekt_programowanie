public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();
        BusinessLogic businessLogic = new BusinessLogic(bank);
        businessLogic.addNewAccount(new Owner("Juliusz","Kowalski"),0.2,1);
        businessLogic.addNewAccount(new Owner("Marek","Kukułka"),0.2,2);
        businessLogic.deposit(1000,1);
        businessLogic.transfer(1,2,300);
        System.out.println(businessLogic.getBank().getAccountById(1).getBalance());
    }
}
