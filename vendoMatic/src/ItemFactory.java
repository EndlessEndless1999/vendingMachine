public final class ItemFactory {
    public static Item createItem(final String itemType){
        return switch (itemType) {
            case "COLA" -> new Cola();
            case "FANTA" -> new Fanta();
            case "DR_PEPPER" -> new DrPepper();
            case "SPRITE" -> new Sprite();
            case "VIMTO" -> new Vimto();
            case "KITKAT" -> new KitKat();
            case "TWIX" -> new Twix();
            case "FLAKE" -> new Flake();
            case "PEANUTS" -> new Peanuts();
            case "CRISPS" -> new Crisps();
            default -> throw new IllegalArgumentException("Invalid Item");
        };
    }
    public static Float getItemPrice(final String itemPrice) {
        return switch (itemPrice) {
            case "COLA", "VIMTO" -> 1.50F;
            case "FANTA" -> 1.25F;
            case "DR_PEPPER" -> 1.75F;
            case "SPRITE" -> 1.00F;
            case "KITKAT", "CRISPS" -> 0.75F;
            case "TWIX", "PEANUTS" -> 0.50F;
            case "FLAKE" -> 0.95F;
            default -> throw new IllegalArgumentException("Invalid Item");
        };
    }
}
