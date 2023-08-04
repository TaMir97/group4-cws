
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class CheckingAccount extends BankAccount{
    double overdraftAmount;

    public CheckingAccount(String customerNationalId, String accountNumber, double balance, double overdraftAmount) {
        super(customerNationalId, accountNumber, balance);
        this.overdraftAmount = overdraftAmount;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
