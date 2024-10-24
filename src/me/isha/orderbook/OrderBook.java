package me.isha.orderbook;

import java.util.TreeMap;
import java.util.HashMap;

public class OrderBook {
    TreeMap<Float, Limit> bidLimits;
    TreeMap<Float, Limit> askLimits;
    HashMap<Integer, Limit> idToLimit;
    

    public OrderBook() {
        this.bidLimits = new TreeMap<>();
        this.askLimits = new TreeMap<>();
        this.idToLimit = new HashMap<>();
    }

    private TreeMap<Float, Limit> getLimitSide(Side side) {
        return (side == Side.BID) ? this.bidLimits : this.askLimits;
    }

    public void addOrder(Order order, Side side) {
        TreeMap<Float, Limit> limitSide = getLimitSide(side);

        Limit limit = null;
        if (!limitSide.containsKey(order.limitPrice)) {
            limit = new Limit();
            limitSide.put(order.limitPrice, limit);
        }
        else {
            limit = limitSide.get(order.limitPrice);
        }
        limit.addOrder(order);
        this.idToLimit.put(order.id, limit);
    }
    
    public void cancelOrder(int id) {
        this.idToLimit.get(id).cancelOrder(id);
    }

    public void executeOrder(int id1, int id2) {
        this.cancelOrder(id1);
        this.cancelOrder(id2);
    }
}
