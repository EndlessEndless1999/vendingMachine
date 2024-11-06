import java.util.InputMismatchException;
import java.util.Scanner;


public class Main {
    static Machine machine = null;
    static User user;
    public static void main(String[] args) {

        machine = new Machine(0F, null);
        startUp();
        machine.setUser(user);

        machine.Init();
        machine.getCurrentUser().displayOptions();

    }
    public static void startUp() {
        final int password = 2504;
        User currentUser = null;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Vending Machine, please specify your authorisation");
        System.out.println("1 : Customer");
        System.out.println("2 : Admin");

        try {
            var _user = scanner.nextInt();

            if (_user != 1 && _user != 2){
                throw new InputMismatchException("Invalid User input. Please try Again.");
            }
            // EXCEPTION HERE.


            if (_user == 1){
                currentUser = new Customer();
                ((Customer) currentUser).machine = machine;
            }
            else if (_user == 2) {

                System.out.println("Please enter the password.");
                int input = scanner.nextInt();

                if (input == password) {
                    System.out.println("Authorisation accepted. Welcome Admin");
                    currentUser = new Admin();
                    ((Admin) currentUser).machine = machine;
                }
                else {
                    System.out.println("Incorrect password. Access Denied");
                    System.exit(0);
                }
            }
            machine.setUser(currentUser);
            user = currentUser;

        } catch (InputMismatchException e) {
            startUp();
        }
    }
}
