public interface Item {
    String name();
    String type();
    Float cost();
}

class Cola implements Item {
    public String name() {
        return "Cola";
    }
    public String type() {
        return "Drink";
    }
    public Float cost() {
        return 1.50F;
    }
}

class Fanta implements Item {
    public String name() {
        return "Fanta";
    }
    public String type() {
        return "Drink";
    }
    public Float cost() {
        return 1.25F;
    }
}

class DrPepper implements Item {
    public String name() {
        return "Dr Pepper";
    }
    public String type() {
        return "Drink";
    }
    public Float cost() {
        return 1.75F;
    }
}

class Sprite implements Item {
    public String name() {
        return "Sprite";
    }
    public String type() {
        return "Drink";
    }
    public Float cost() {
        return 1.00F;
    }
}

class Vimto implements Item {
    public String name() {
        return "Vimto";
    }
    public String type() {
        return "Drink";
    }
    public Float cost() {
        return 1.50F;
    }
}

class KitKat implements Item {
    public String name() {
        return "KitKat";
    }
    public String type() {
        return "Food";
    }
    public Float cost() {
        return 0.75F;
    }
}

class Twix implements Item {
    public String name() {
        return "Twix";
    }
    public String type() {
        return "Food";
    }
    public Float cost() {
        return 0.50F;
    }
}

class Flake implements Item {
    public String name() {
        return "Flake";
    }
    public String type() {
        return "Food";
    }
    public Float cost() {
        return 0.95F;
    }
}

class Peanuts implements Item {
    public String name() {
        return "Peanuts";
    }
    public String type() {
        return "Food";
    }
    public Float cost() {
        return 0.50F;
    }
}

class Crisps implements Item {
    public String name() {
        return "Crisps";
    }
    public String type() {
        return "Food";
    }
    public Float cost() {
        return 0.75F;
    }
}
