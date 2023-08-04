import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor

public class BankAccount {
    String customerNationalId;
    String accountNumber;
    double balance;

    public void withdraw(double amount) {

        if (amount < 0)
            throw new IllegalArgumentException("Sorry, you can not withdraw a negative amount");
        else if (balance < amount)
            throw new RuntimeException("Your balance is not enough");
        else
            balance -= amount;

    }

    public void deposit(double amount) {
        balance += amount;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BankAccount that = (BankAccount) o;
        return customerNationalId.equals(that.customerNationalId) && accountNumber.equals(that.accountNumber);
    }



}
