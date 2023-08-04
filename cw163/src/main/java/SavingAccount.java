
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter

public class SavingAccount extends BankAccount{
    double interestAmount;


    public SavingAccount(String customerNationalId, String accountNumber, double balance, double interestAmount) {
        super(customerNationalId, accountNumber, balance);
        this.interestAmount = interestAmount;
    }

    public void addInterest () {
        balance += balance*interestAmount;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
