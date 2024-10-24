package me.isha.orderbook;

public class Order {
    int id;
    int volume;
    float limitPrice;
    float entryTime;

    public Order(int id, int volume, float limitPrice, float entryTime) {
        this.id = id;
        this.volume = volume;
        this.limitPrice = limitPrice;
        this.entryTime = entryTime;
    }
}
