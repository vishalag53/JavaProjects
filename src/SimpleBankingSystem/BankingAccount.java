package SimpleBankingSystem;

public class BankingAccount {
    private String name;
    private String id;
    private double balance;

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void addBalance(double amount){
        balance += amount;
    }

    public void subtractBalance(double amount){
        balance -= amount;
    }
}
