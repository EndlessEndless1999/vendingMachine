import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        User user = startUp();

        Machine machine = new Machine(0F, user);

        System.out.println(machine.getCurrentUser());
        System.out.println(machine.getMoney());

        machine.Init();
        machine.displayOptions();

    }
    public static User startUp() {
        final int password = 2504;
        User currentUser = null;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Vending Machine, please specify your authorisation");
        System.out.println("1 : Customer");
        System.out.println("2 : Admin");

        var user = scanner.nextInt();

        if (user == 1){
            currentUser = new Customer();
        }
        else if (user == 2) {

            System.out.println("Please enter the password.");
            int input = scanner.nextInt();

            if (input == password) {
                System.out.println("Authorisation accepted. Welcome Admin");
                currentUser = new Admin();
            }
            else {
                System.out.println("Incorrect password. Access Denied");
                System.exit(0);
            }
        }

        return currentUser;
    }
}
