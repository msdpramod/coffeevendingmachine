package urban.coffeevendingmachine.Utility;

public class CashManager {
    public static int calculateChange(int price, int cashInserted) {
        return cashInserted - price;
    }
}

