import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Machine {

    private List<Currency> machineMoney;
    private List<Currency> money;
    private Float userCredit;
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

    final static String[] coinNames = {
            "TWO_POUND",
            "POUND",
            "FIFTY_PENCE",
            "TWENTY_PENCE",
            "TEN_PENCE",
            "FIVE_PENCE",
            "ONE_PENCE"
    };



    public Machine(Float money, User currentUser) {
        this.money = new ArrayList<Currency>();
        this.currentUser = currentUser;
        this.slots = new ArrayList<Slot>();
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

        Item result = purchaseProduct(input);

        depositItem(result);
    }

    private Item purchaseProduct(int input) {

        this.userCredit = getCredit();

        Slot chosenSlot = this.slots.get(input);

        Float price = chosenSlot.getSlotPrice();

        this.userCredit -= price;

        this.money.clear();

        System.out.println(this.userCredit);

        // Convert to coins;
        convertToChange(this.userCredit);

        return chosenSlot.removeStock();
    }

    private void convertToChange(Float userCredit) {
        while(userCredit > 0) {
            Currency coin = null;
            if (userCredit >= 2.00F){
                coin = CoinFactory.createCoin("TWO_POUND");
                this.money.add(coin);
            } else if (userCredit >= 1.00F) {
                coin = CoinFactory.createCoin("POUND");
                this.money.add(coin);
            } else if (userCredit >= 0.50F) {
                coin = CoinFactory.createCoin("FIFTY_PENCE");
                this.money.add(coin);
            } else if (userCredit >= 0.20F) {
                coin = CoinFactory.createCoin("TWENTY_PENCE");
                this.money.add(coin);
            } else if (userCredit >= 0.10F) {
                coin = CoinFactory.createCoin("TEN_PENCE");
                this.money.add(coin);
            } else if (userCredit >= 0.05F) {
                coin = CoinFactory.createCoin("FIVE_PENCE");
                this.money.add(coin);
            }
              else if (userCredit >= 0.01F) {
                coin = CoinFactory.createCoin("FIVE_PENCE");
                this.money.add(coin);
            }
            assert coin != null;
            userCredit -= coin.Value();

        }
    }

    private void depositItem(Item item){
        System.out.println("You received one " + item.name() + ".");
    }

    private Float getCredit() {
        System.out.println("You are now viewing your current credits in the Machine");
        float total = 0f;
        for (Currency coin : this.money) {
            total += coin.Value();

        }
        System.out.println("£" + total);

        return total;
    }

    private void addCredit() {
        int number = 1;
        System.out.println("You are now Inserting Credits into the Machine");
        for (String coin : coinNames) {
            System.out.println(number + ": " + coin + ".");
            number++;
        }
        System.out.println("Please input the number corresponding to the coin type you wish to deposit.");
        int response = getInput();

        System.out.println("You have selected to insert " + coinNames[response - 1]);
        System.out.println("Please select the amount you wish to deposit (Integer).");

        int amount = getInput();

        // Instantiate the coins and add them to the money variable
        for (int i = 0; i < amount; i++) {
            Currency coin = CoinFactory.createCoin(coinNames[response - 1]);
            this.money.add(coin);
        }

        System.out.println("You have successfully deposited " + " " + amount + " " + coinNames[response - 1] + " " + "coins.");
    }

    private void refund() {
        for (Currency coin : this.money) {
            System.out.println("You Received : " + coin.Name());
        }
        this.money.clear();
    }

    public int getInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public List<Currency> getMoney() {
        return this.money;
    }

    public User getCurrentUser() {
        return currentUser;
    }


}
