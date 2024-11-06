public interface Coin {
    String Currency();
    String Name();
    Float Value();
}

class TwoPound implements Coin {
    public String Currency() {
        return "Sterling";
    }
    public String Name() {
        return "£2 Coin.";
    }
    public Float Value() {
        return 2.00F;
    }
}

class Pound implements Coin {
    public String Currency() {
        return "Sterling";
    }
    public String Name() {
        return "£1 Coin.";
    }
    public Float Value() {
        return 1.00F;
    }
}

class FiftyPence implements Coin {
    public String Currency() {
        return "Sterling";
    }
    public String Name() {
        return "50p Coin.";
    }
    public Float Value() {
        return 0.50F;
    }
}

class TwentyPence implements Coin {
    public String Currency() {
        return "Sterling";
    }
    public String Name() {
        return "20p Coin.";
    }
    public Float Value() {
        return 0.20F;
    }
}

class TenPence implements Coin {
    public String Currency() {
        return "Sterling";
    }
    public String Name() {
        return "10p Coin.";
    }
    public Float Value() {
        return 0.10F;
    }
}

class FivePence implements Coin {
    public String Currency() {
        return "Sterling";
    }
    public String Name() {
        return "5p Coin.";
    }
    public Float Value() {
        return 0.05F;
    }
}

class Pence implements Coin {
    public String Currency() {
        return "Sterling";
    }
    public String Name() {
        return "1p Coin.";
    }
    public Float Value() {
        return 0.01F;
    }
}
