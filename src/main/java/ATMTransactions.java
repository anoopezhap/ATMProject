import java.util.Scanner;

public class ATMTransactions {

    public static void main(String[] args)
    {
        ResourceClass rc = new ResourceClass();
        ATMOperations atm = new ATMOperationsImpl();
        final int ATMNumber = 12345;
        final int ATMPin = 123;
        int optionNumber;
        System.out.println("Welcome To The ATM Machine");
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter your ATM number");
        int EnteredATMNumber = sc.nextInt();
        System.out.println("Please enter your ATM pin");
        int EnteredATMPin = sc.nextInt();
        if(EnteredATMNumber==ATMNumber && EnteredATMPin==ATMPin)
        {
            while (true)
            {
                rc.menuOptions();
                optionNumber = sc.nextInt();
                switch (optionNumber)
                {
                    case 1:
                        atm.viewBalance();
                        break;
                    case 2:
                        System.out.println("Please enter the amount to withdraw");
                        double WithdrawAmount = sc.nextDouble();
                        atm.withdrawAmount(WithdrawAmount);
                        atm.viewBalance();
                        break;
                    case 3:
                        System.out.println("Please enter the amount to deposit ");
                        double DepositAmount = sc.nextDouble();
                        atm.depositAmount(DepositAmount);
                        atm.viewBalance();
                        break;
                    case 4:
                        atm.viewMiniStatement();
                        break;
                    case 5:
                        System.exit(0);
                }

            }
        }
        else
        {
            System.out.println("Wrong credentials entered");
            System.exit(0);
        }
    }
}
