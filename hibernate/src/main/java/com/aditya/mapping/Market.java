package com.aditya.mapping;

import java.util.Set;
import java.util.stream.LongStream;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "MARKET")
public class Market {

    @Id
    @GeneratedValue
    @Column(name = "market_id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "total_value")
    private Long totalValue;

    @OneToMany(mappedBy = "market", cascade = { CascadeType.ALL })
    private Set<Stock> stocks;

    public Market() {
    }

    public Market(Long id, String name, Long totalValue) {
        super();
        this.name = name;
        this.totalValue = totalValue;
    }

    public static Long calculateMarketValue(Set<Stock> stocks) {
        return stocks.stream().flatMapToLong(s -> LongStream.of(s.getPrice()))
                .sum();

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(Long totalValue) {
        this.totalValue = totalValue;
    }

    public Set<Stock> getStocks() {
        return stocks;
    }

    public void setStocks(Set<Stock> stocks) {
        this.stocks = stocks;
        totalValue = calculateMarketValue(stocks);
    }

    @Override
    public String toString() {
        return "Market [id=" + id + ", name=" + name + ", totalValue="
                + totalValue + "]";
    }

}
