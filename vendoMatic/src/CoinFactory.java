public final class CoinFactory {
    public static Coin createCoin(final String coinType){
        return switch (coinType) {
            case "TWO_POUND" -> new TwoPound();
            case "POUND" -> new Pound();
            case "FIFTY_PENCE" -> new FiftyPence();
            case "TWENTY_PENCE" -> new TwentyPence();
            case "TEN_PENCE" -> new TenPence();
            case "FIVE_PENCE" -> new FivePence();
            case "ONE_PENCE" -> new Pence();
            default -> throw new IllegalArgumentException("Invalid Item");
        };
    }
}