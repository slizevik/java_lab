package laba_2;

public class Bank_run {
    public static void main(String[] args) {
        BankAccount account = new BankAccount("123456", "Иванов", 1000);

        System.out.println(account.getAccountInfo());
        account.deposit(500);
        System.out.println("После депозита: " + account.getAccountInfo());
        account.withdraw(300);
        System.out.println("После снятия: " + account.getAccountInfo());
    }
}
