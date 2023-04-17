import java.util.Scanner;

public class ATM {
    // Class instance Variables
    static int userId = 1234;
    static int userPin = 1234;
    static int noOfTrials = 3;
    static double balance;

    // Scanner class - Class scope
    static Scanner sc = new Scanner(System.in);

    static void checkPin() {
        System.out.print("Enter User ID: ");
        int userid = sc.nextInt();
        System.out.print("Enter User Pin: ");
        int userpin = sc.nextInt();

        if (userpin == userPin && userid == userId) {
            System.out.println();
        } else {
            System.out.println("Invalid User Details");
        }
    }

    static void mainMenu() {
        System.out.println("*******************************");
        System.out.println("** WELCOME TO BANK OF INDIA  **");
        System.out.println("*******************************");

        System.out.println();

        System.out.println("Press 1 - WITHDRAW FUNDS");
        System.out.println("Press 2 - DEPOSIT FUNDS");
        System.out.println("Press 3 - TRANSFER FUNDS");
        System.out.println("Press 4 - TRANSACTION HISTORY");
        System.out.println("Press 5 - QUIT");
    }

    static void withdraw() {
        System.out.print("Enter Amount: ");
        int amount = sc.nextInt();
        System.out.print("Enter User Pin: ");
        int userpin = sc.nextInt();

        if (amount <= balance) {
            if (userpin == userPin) {
                balance -= amount;
                System.out.println("Withdrawal Successful");
                System.out.println("Your Current Balnace is "+balance);
            } else {
                System.out.println("Pin is Incorrect!");
                System.out.println("You have "+ noOfTrials + " trials Left");
                noOfTrials--;
                if (noOfTrials == 0) {
                    System.out.println("Account Blocked!");
                }
            }
        } else {
            System.out.println("Insufficient Funds! Please topup");
            System.out.println("Your Current Balance is "+balance);
        }
    }

    static void deposit () {
        System.out.print("Enter amount: ");
        int amount = sc.nextInt();

        balance += amount;
        System.out.println("Deposit successful!");
        System.out.println(amount + " has been added to your account");
        System.out.println("Your Current Balance is "+balance);
    }

    static void transfer () {
        int noOfTrials = 3;
        System.out.print("Enter amount: ");
        int amount =  sc.nextInt();
        System.out.print("Enter Receipient A/C No: ");
        Long accountNo = sc.nextLong();
        System.out.print("Enter User Pin: ");
        int userpin =  sc.nextInt();

        if (amount <= balance) {
            if (userpin == userPin) {
                balance -= amount;
                System.out.println("Transfer to " + accountNo + " was Successful");
                System.out.println("Your Current Balnace is " + balance);
            } else {
                System.out.println("Pin is Incorrect!");
                System.out.println("You have " + noOfTrials + " trialsLeft");
                noOfTrials--;
                if (noOfTrials == 0) {
                    System.out.println("Account Blocked!");
                }
            }
        } else {
            System.out.println("Insufficient Funds! Please topup");
            System.out.println("Your Current Balance is " + balance);
        }
    }

    static void quit () {
        System.out.println("--------------Take your receipt!!!------------------");
        System.out.println("-----Thank you for using ATM Banking Machine!!!-----");
        System.out.println("-----BROUGHT TO YOU BY Gospel John-----");
    }
    public static void main(String[] args) {
        boolean again = true;
        checkPin();
        System.out.flush();

        while (again) {
            mainMenu();
            System.out.print("Choose Option: ");
            int option = sc.nextInt();

            switch (option) {
                case 1:
                    System.out.println("-----Withdraw Section-----");
                    withdraw();
                    break;
                case 2:
                    System.out.println("-----Deposit Section-----");
                    deposit();
                    break;
                case 3:
                    System.out.println("-----Transfer Section-----");
                    transfer();
                    break;
                case 4:
                break;
                case 5:
                    break;
                default:
                System.out.println("Enter a Valid Option");
                    break;
            }

            System.out.println();
            System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            System.out.println("Would you like to do another transaction: ");
            System.out.println("< 1 > Yes");
            System.out.println("< 2 > No\n");

            System.out.print("Enter a choice: ");
            int choice = sc.nextInt();

            if (choice == 2) {
                again = false;
                quit();
            }

        }
    }
}
