package com.aditya.mapping;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "STOCK")
public class Stock {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "price")
    private Long price;

    @ManyToOne(cascade = { CascadeType.ALL })
    @JoinColumn(name = "market_id")
    private Market market;

    public Stock() {
    }

    public Stock(String companyName, Long price, Market market) {
        this.companyName = companyName;
        this.price = price;
        this.market = market;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Market getMarket() {
        return market;
    }

    public void setMarket(Market market) {
        this.market = market;
    }

    @Override
    public String toString() {
        return "Stock [id=" + id + ", companyName=" + companyName + ", price="
                + price + ", market=" + market + "]";
    }

}
