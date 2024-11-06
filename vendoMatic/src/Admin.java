public class Admin extends Controller implements User{

    public Machine machine;
    public void displayOptions() {
        System.out.println("Please choose from the following options.");
        System.out.println("0 : Turn of Machine.");
        System.out.println("1 : Insert Credit.");
        System.out.println("2 : Choose Product.");
        System.out.println("3 : View Credit.");
        System.out.println("4 : Deposit Credit To Bucket.");
        System.out.println("5 : Take Coins from Bucket.");
        System.out.println("6 : Change Authorisation Level.");
        System.out.println("7 : Add Stock to Slot.");
        System.out.println("8 : Add New Slot to Machine.");
        System.out.println("9 : Add Funds to Machine.");
        System.out.println("10 : Withdraw Funds from Machine.");

        int input = this.machine.getInput();

        switch (input) {
            case 0 -> this.machine.end();
            case 1 -> this.machine.addCredit();
            case 2 -> this.machine.chooseProduct();
            case 3 -> this.machine.getCredit();
            case 4 -> this.machine.addFundsToBucket();
            case 5 -> this.machine.refund();
            case 6 -> this.machine.login();
            case 7 -> this.machine.addStock();
            case 8 -> this.machine.addSlot();
            case 9 -> this.machine.addFunds();
            case 10 -> this.machine.withdrawFunds();
        }
        this.machine.getCurrentUser().displayOptions();
    }
}
