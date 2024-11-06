import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Machine {

    private List<Coin> machineMoneyTwoPound;
    private List<Coin> machineMoneyPound;
    private List<Coin> machineMoneyFiftyPence;
    private List<Coin> machineMoneyTwentyPence;
    private List<Coin> machineMoneyTenPence;
    private List<Coin> machineMoneyFivePence;
    private List<Coin> machineMoneyOnePence;
    private List<Coin> money;
    private List<Coin> bucket;
    private Float userCredit;
    private User currentUser;
    private List<Slot> slots;

    private static String[] itemNames = {
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

    private static String[] itemDictionary = {
            "COLA",
            "FANTA",
            "DR_PEPPER",
            "SPRITE",
            "VIMTO",
            "KITKAT",
            "TWIX",
            "FLAKE",
            "PEANUTS",
            "CRISPS",
            "BEER"
    };

    private static String[] coinNames = {
            "TWO_POUND",
            "POUND",
            "FIFTY_PENCE",
            "TWENTY_PENCE",
            "TEN_PENCE",
            "FIVE_PENCE",
            "ONE_PENCE"
    };



    public Machine(Float money, User currentUser) {
        this.money = new ArrayList<Coin>();
        this.bucket = new ArrayList<Coin>();
        this.machineMoneyTwoPound = new ArrayList<Coin>();
        this.machineMoneyPound = new ArrayList<Coin>();
        this.machineMoneyFiftyPence = new ArrayList<Coin>();
        this.machineMoneyTwentyPence = new ArrayList<Coin>();
        this.machineMoneyTenPence = new ArrayList<Coin>();
        this.machineMoneyFivePence = new ArrayList<Coin>();
        this.machineMoneyOnePence = new ArrayList<Coin>();

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

    public void login() {
        Main.startUp();
    }

    public void end() {
        System.exit(0);
    }


    public void chooseProduct() {
        System.out.println("You are now viewing current products in the Machine");

        for (Slot slot : this.slots) {
            System.out.println(slot.getSlotId() + ": " + slot.getSlotName() + ", Price: £" + slot.getSlotPrice() + ", Stock: " + slot.getStock());
        }

        System.out.println();
        System.out.println("Please enter the Number for the product you want.");

        int input = this.getInput(slots.size());

        Item result = purchaseProduct(input);

        depositItem(result);
    }

    public Item purchaseProduct(int input) {

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
        while(userCredit > 0.001F) {
            Float value = 0F;
            if (userCredit >= 2.00F){
                Coin search = this.machineMoneyTwoPound.removeFirst();
                this.money.add(search);
                value = 2.00F;
            } else if (userCredit >= 1.00F) {
                Coin search = this.machineMoneyPound.removeFirst();
                this.money.add(search);
                value = 1.00F;
            } else if (userCredit >= 0.50F) {
                Coin search = this.machineMoneyFiftyPence.removeFirst();
                this.money.add(search);
                value = 0.50F;
            } else if (userCredit >= 0.20F) {
                Coin search = this.machineMoneyTwentyPence.removeFirst();
                this.money.add(search);
                value = 0.20F;
            } else if (userCredit >= 0.10F) {
                Coin search = this.machineMoneyTenPence.removeFirst();
                this.money.add(search);
                value = 0.10F;
            } else if (userCredit >= 0.05F) {
                Coin search = this.machineMoneyFivePence.removeFirst();
                this.money.add(search);
                value = 0.05F;
            } else if (userCredit >= 0.01F) {
                Coin search = this.machineMoneyOnePence.removeFirst();
                this.money.add(search);
                value = 0.01F;
            }
            userCredit -= value;

        }
    }

    private void depositItem(Item item){
        System.out.println("You received one " + item.name() + ".");
    }

    public Float getCredit() {
        System.out.println("You are now viewing your current credits in the Machine");
        float total = 0f;
        for (Coin coin : this.money) {
            total += coin.Value();

        }
        System.out.println("£" + total);

        return total;
    }

    public void addCredit() {
        int number = 0;
        System.out.println("You are now Inserting Credits into the Machine");
        for (String coin : coinNames) {
            System.out.println(number + ": " + coin + ".");
            number++;
        }
        System.out.println("Please input the number corresponding to the coin type you wish to deposit.");
        int response = getInput(8);

        if (response == -1){
            addCredit();
            return;
        }

        System.out.println("You have selected to insert " + coinNames[response]);
        System.out.println("Please select the amount you wish to deposit (Integer).");

        int amount = getInput(999);

        if (amount == -1){
            addCredit();
            return;
        }

        // Instantiate the coins and add them to the money variable
        for (int i = 0; i < amount; i++) {
            Coin coin = CoinFactory.createCoin(coinNames[response ]);
            this.money.add(coin);
        }

        System.out.println("You have successfully deposited " + " " + amount + " " + coinNames[response] + " " + "coins.");
    }

    public void addFundsToBucket() {
        this.bucket.addAll(this.money);

        this.money.clear();

        System.out.println("Deposited Coins to Bucket. Please Collect.");
    }

    public void refund() {
        for (Coin coin : this.bucket) {
            System.out.println("You Received : " + coin.Name());
        }
        this.bucket.clear();
    }

    public int getInput(int max) {
        Scanner scanner = new Scanner(System.in);
        int result;
        try {
            result = scanner.nextInt();
            if (result < 0 || result >= max) {
                throw new ArrayIndexOutOfBoundsException("Input is out of bounds.");
            }
        } catch (ArrayIndexOutOfBoundsException | InputMismatchException e){
            return -1;
        }
        return result;

    }

    public List<Coin> getMoney() {
        return this.money;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void setUser(User user) {
        this.currentUser = user;
    }


    public Slot getSlot(int id) {
        return slots.get(id);
    }

    public void addStock() {
        System.out.println("You are now viewing current stock in the Machine.");

        for (Slot slot : this.slots) {
            System.out.println(slot.getSlotId() + ": " + slot.getSlotName() + ", Price: £" + slot.getSlotPrice() + ", Stock: " + slot.getStock());
        }

        System.out.println("Please Choose which slot (int : id) you would like to add stock to.");
        int target = this.getInput(slots.size());
        if (target == -1) {
            addStock();
            return;
        }
        Slot slot = getSlot(target);
        System.out.println(slot);
        System.out.println("You have chosen slot " + slot.getSlotId() + "containing " + slot.getStock() + " " + slot.getSlotName() + ".");
        System.out.println("Please choose how many " + slot.getSlotName() + " to add to the slot.");
        int amount = this.getInput(999);

        for (int i = 0; i < amount; i++) {
            Item output = ItemFactory.createItem(itemNames[slot.getSlotId()]);
            slot.addStock(output);
        }

    }

    public void addSlot() {
        //Initialise and create new slot.
        ArrayList<Item> items = new ArrayList<Item>();
        int index = this.slots.size() + 1;
        System.out.println("Please Choose an item to designate to the slot.");
        for (int i = 0; i < itemDictionary.length; i++) {
            System.out.println(i + " " + itemDictionary[i]);
        }
        System.out.println("Please Type the Number as written in the console of the item you want. (int)");

        int result = this.getInput(11);

        if (result == -1) {
            addSlot();
            return;
        }

        Slot slot = new Slot(items, index - 1, itemDictionary[result], ItemFactory.getItemPrice(itemDictionary[result]));
        this.slots.add(slot);

        System.out.println("Successfully created slot of type " + itemDictionary[result] + ".");
    }

    public void addFunds() {
        System.out.println("Adding Funds to the Machine.");

        System.out.println("How Many of Each Coin would you like to add to the Machine? (MAX 99)");

        int result = this.getInput(99);


        if (result == -1) {
            addFunds();
            return;
        }

        for (int i = 0; i < result; i++){
            Coin output = CoinFactory.createCoin("TWO_POUND");
            this.machineMoneyTwoPound.add(output);
        }
        for (int i = 0; i < result; i++){
            Coin output = CoinFactory.createCoin("POUND");
            this.machineMoneyPound.add(output);
        }
        for (int i = 0; i < result; i++){
            Coin output = CoinFactory.createCoin("FIFTY_PENCE");
            this.machineMoneyFiftyPence.add(output);
        }
        for (int i = 0; i < result; i++){
            Coin output = CoinFactory.createCoin("TWENTY_PENCE");
            this.machineMoneyTwentyPence.add(output);
        }
        for (int i = 0; i < result; i++){
            Coin output = CoinFactory.createCoin("TEN_PENCE");
            this.machineMoneyTenPence.add(output);
        }
        for (int i = 0; i < result; i++){
            Coin output = CoinFactory.createCoin("FIVE_PENCE");
            this.machineMoneyFivePence.add(output);
        }
        for (int i = 0; i < result; i++){
            Coin output = CoinFactory.createCoin("ONE_PENCE");
            this.machineMoneyOnePence.add(output);
        }

    }

    public void withdrawFunds() {
        // Withdraw Funds from machine
        System.out.println("Emptying all Money from the Machine.");

        int[] total = new int[]{this.machineMoneyTwoPound.size(), this.machineMoneyPound.size(), this.machineMoneyFiftyPence.size(),
        this.machineMoneyTwentyPence.size(), this.machineMoneyTenPence.size(), this.machineMoneyFivePence.size(), this.machineMoneyOnePence.size()};

        System.out.println("You got " + total[0] + " Two Pound Coins, " + total[1] + " One Pound Coins, " + total[2] + " 50p coins, "
        + total[3] + " 20p coins, " + total[4] + " 10p coins, " + total[5] + " 5p coins, " + total[6] + " 1p coins.");

        this.machineMoneyTwoPound.clear();
        this.machineMoneyPound.clear();
        this.machineMoneyFiftyPence.clear();
        this.machineMoneyTwentyPence.clear();
        this.machineMoneyTenPence.clear();
        this.machineMoneyFivePence.clear();
        this.machineMoneyOnePence.clear();
    }
}
