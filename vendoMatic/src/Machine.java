import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Machine {

    private List<Coin> money;
    private User currentUser;
    private List<Slot> slots;
    private ItemFactory itemFactory;

    final static String[] itemNames = {
            "COLA",
            "FANTA",
            "DR_PEPPER",
            "SPRITE",
            "VIMTO",
            "KITKAT",
            "TWIX",
            "FLAKE",
            "PEANUTS",
            "CRISPS"
    };



    public Machine(Float money, User currentUser) {
        this.money = new ArrayList<Coin>();
        this.currentUser = currentUser;
        this.slots = new ArrayList<Slot>();
        this.itemFactory = new ItemFactory();
    }

    public void Init() {
        int i = 0;
        for (String string : itemNames){
            ArrayList<Item> items = new ArrayList<Item>();
            Float price = ItemFactory.getItemPrice(string);

            Slot slot = new Slot(items, i, string, price);
            while (slot.getStock() < slot.maxStorage){
                Item newItem = ItemFactory.createItem(string);
                items.add(newItem);
            }
            this.slots.add(slot);
            i++;
        }
        System.out.println(this.slots);
    }

    public void displayOptions() {

        //While Loop is cleaner for this implementation

        System.out.println("Please choose from the following options.");
        System.out.println("1 : Insert Credit.");
        System.out.println("2 : Choose Product.");
        System.out.println("3 : View Credit.");
        System.out.println("4 : Refund Credit");

        int input = this.getInput();

        switch (input) {
            case 0 -> this.end();
            case 1 -> this.addCredit();
            case 2 -> this.chooseProduct();
            case 3 -> this.getCredit();
            case 4 -> this.refund();
        }
        displayOptions();
    }

    private void end() {
        System.exit(0);
    }


    private void chooseProduct() {
        System.out.println("You are now viewing current products in the Machine");

        for (Slot slot : this.slots) {
            System.out.println(slot.getSlotId() + ": " + slot.getSlotName() + ", Price: £" + slot.getSlotPrice() + ", Stock: " + slot.getStock());
        }

        System.out.println();
        System.out.println("Please enter the Number for the product you want.");

        int input = this.getInput();
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
