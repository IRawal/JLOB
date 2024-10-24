import me.isha.orderbook.*;
public class Main {
    public static void main(String[] args) {
        OrderBook book = new OrderBook();
        for (int i = 0; i < 1e6; i++) {
            book.addOrder(new Order(i, 1, i, i), Side.BID);
        }
    }
}