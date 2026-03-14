package laba_2;

public interface BankAccountInterface {
    void deposit(double amount);
    void withdraw(double amount);
    double getBalance();
    String getAccountInfo();
}