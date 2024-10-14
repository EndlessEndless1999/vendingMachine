public class Coin implements Currency{

    private String currency;
    private Float value;
    private String type;

    Coin(String currency, Float value, String type){
        this.currency = currency;
        this.value = value;
        this.type = type;
    }

    public String getCurrency(){
        return this.currency;
    }

    public Float getValue(){
        return this.value;
    }

    public String getType(){
        return this.type;
    }

}
