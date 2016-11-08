package com.aditya.spring.order;

public class Order {

    private Integer id;
    private Item item;

    public Order() {
    }

    public Order(Integer id, Item item) {
        super();
        this.id = id;
        this.item = item;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return "Order [id=" + id + ", item=" + item + "]";
    }

}
