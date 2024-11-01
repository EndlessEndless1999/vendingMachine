import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Machine {

    private List<Coin> money;
    private User currentUser;

    public Machine(Float money, User currentUser) {
        this.money = new ArrayList<Coin>();
        this.currentUser = currentUser;
    }

    public void displayOptions() {
        System.out.println("Please choose from the following options.");
        System.out.println("1 : Insert Credit.");
        System.out.println("2 : Choose Product.");
        System.out.println("3 : View Credit.");
        System.out.println("4 : Refund Credit");

        int input = this.getInput();

        switch (input) {
            case 1 -> this.addCredit();
            case 2 -> this.chooseProduct();
            case 3 -> this.getCredit();
            case 4 -> this.refund();
        }
        displayOptions();
    }


    private void chooseProduct() {
        System.out.println("You are now viewing current products in the Machine");
    }

    private void getCredit() {
        System.out.println("You are now viewing current credits in the Machine");
        float total = 0f;
        for (Coin coin : this.money) {
            total += coin.getValue();

        }
        System.out.println("£" + total);
    }

    private void addCredit() {
        System.out.println("You are now Inserting Credits into the Machine");
        Coin coin = new Coin("Sterling", 1.00F, "£1");

        this.money.add(coin);

        System.out.println(this.money);

        this.getCredit();
    }

    private void refund() {
        System.out.println();
    }

    public int getInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public List<Coin> getMoney() {
        return money;
    }

    public User getCurrentUser() {
        return currentUser;
    }


}
