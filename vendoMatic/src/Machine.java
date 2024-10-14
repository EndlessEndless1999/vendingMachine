import java.util.Scanner;

public class Machine {

    private Float money;
    private User currentUser;

    public Machine(Float money, User currentUser) {
        this.money = money;
        this.currentUser = currentUser;
    }

    public void displayOptions() {
        System.out.println("Please choose from the following options.");
        System.out.println("1 : Insert Credit.");
        System.out.println("2 : Choose Product.");
        System.out.println("3 : View Credit.");

        int input = this.getInput();

        switch (input) {
            case 1 -> this.setCredit();
            case 2 -> this.chooseProduct();
            case 3 -> this.getCredit();
        }
    }

    private void chooseProduct() {
        System.out.println("You are now viewing current products in the Machine");
    }

    private void getCredit() {
        System.out.println("You are now viewing current credits in the Machine");
    }

    private void setCredit() {
        System.out.println("You are now Inserting Credits into the Machine");
    }

    public int getInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public Float getMoney() {
        return money;
    }

    public User getCurrentUser() {
        return currentUser;
    }


}
