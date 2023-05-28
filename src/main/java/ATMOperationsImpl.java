import java.sql.Array;
import java.util.*;

//Class implementing ATMOperations interface
public class ATMOperationsImpl implements ATMOperations
{
    SensitiveData data = new SensitiveData();
    Scanner sc = new Scanner(System.in);
    ArrayList<Double> withdrawnAmount = new ArrayList<Double>();
    ArrayList<Double> depositAmount = new ArrayList<Double>();

    Map<String, ArrayList<Double>> mini = new HashMap<String, ArrayList<Double>>();

    @Override
    public void viewBalance() {
        System.out.println("Available Balance is : " + data.getAvailableBalance());
    }

    @Override
    public void withdrawAmount(double WithdrawAmount) {
        data.setWithdrawAmount(WithdrawAmount);
        if (data.getAvailableBalance() >= data.getWithdrawAmount()) {
            data.setAvailableBalance(data.getAvailableBalance() - WithdrawAmount);
            System.out.println(WithdrawAmount + " Successfully withdrawn");
            withdrawnAmount.add(data.getWithdrawAmount());
            mini.put("Amount withdrawn : ", withdrawnAmount);
        } else {
            System.out.println("You don't have enough balance");
        }
    }

    @Override
    public void depositAmount(double DepositAmount) {
        data.setAvailableBalance(data.getAvailableBalance() + DepositAmount);
        System.out.println(DepositAmount + " is successfully deposited");
        depositAmount.add(DepositAmount);
        mini.put("Amount Deposited : ", depositAmount);
    }

    @Override
    public void viewMiniStatement()
    {
        for (String s : mini.keySet())
        {
            for (Double d : mini.get(s))
            {
                System.out.println(s + "" + d);
            }
        }
        viewBalance();
    }
}

