public class Customer extends Controller implements User{
    Machine machine = null;

    @Override
    public void displayOptions() {
        System.out.println("Please choose from the following options.");
        System.out.println("1 : Insert Credit.");
        System.out.println("2 : Choose Product.");
        System.out.println("3 : View Credit.");
        System.out.println("4 : Deposit Credit To Bucket");
        System.out.println("5 : Take Coins from Bucket");
        System.out.println("6 : Change Authorisation Level");

        int input = this.machine.getInput();

        switch (input) {
            case 0 -> this.machine.end();
            case 1 -> this.machine.addCredit();
            case 2 -> this.machine.chooseProduct();
            case 3 -> this.machine.getCredit();
            case 4 -> this.machine.addFundsToBucket();
            case 5 -> this.machine.refund();
            case 6 -> this.machine.login();
        }
        this.machine.getCurrentUser().displayOptions();
    }
}
