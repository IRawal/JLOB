package me.isha.orderbook;

import java.util.TreeMap;

public class Limit {

    TreeMap<Integer, Order> orders;

    int volume;

    public Limit() {
        this.orders = new TreeMap<>();
        this.volume = 0;
    }

    public void addOrder(Order order) {
        this.orders.put(order.id, order);
        this.volume += order.volume;
    }

    public void cancelOrder(int id) {
        Order order = this.orders.get(id);
        this.orders.remove(id);
        this.volume -= order.volume;
    }

    public Order getEarliest() {
        return this.orders.ceilingEntry(null).getValue();
    }
}
