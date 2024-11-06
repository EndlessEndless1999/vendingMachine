import java.util.List;

public class Slot {
    final int maxStorage = 9;

    private List<Item> currentItems;
    private int slotId;
    private String slotName;
    private Float slotPrice;

    public Slot(List<Item> currentItems, int slotId, String slotName, Float slotPrice) {
        this.currentItems = currentItems;
        this.slotId = slotId;
        this.slotName = slotName;
        this.slotPrice = slotPrice;
    }

    public int getStock() {
        if (this.currentItems.size() < 0) {
            return 0;
        }
        else {
            return this.currentItems.size();
        }
    }

    public int getSlotId(){
        return this.slotId;
    }

    public Float getSlotPrice(){
        return this.slotPrice;
    }

    public String getSlotName(){
        return this.slotName;
    }

    public void addStock(Item item){
        this.currentItems.add(item);
    }

    public Item removeStock() {
        Item item = this.currentItems.removeFirst();
        return item;
    }


}
