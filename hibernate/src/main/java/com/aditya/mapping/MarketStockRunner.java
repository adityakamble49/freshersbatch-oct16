package com.aditya.mapping;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MarketStockRunner {

    private static Configuration configuration;
    private static SessionFactory sessionFactory;

    public static void main(String[] args) {

        configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        sessionFactory = configuration.buildSessionFactory();

        // addMarket();
        // updateMarket();
        // readMarket();
        deleteMarket();
        sessionFactory.close();
    }

    private static void addMarket() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Market market = new Market();

        Stock appleStock = new Stock("apple", 1000l, market);
        Stock microsoftStock = new Stock("microsoft", 2000l, market);
        Stock googleStock = new Stock("google", 3000l, market);
        HashSet<Stock> stockSet = new HashSet<Stock>();
        stockSet.add(appleStock);
        stockSet.add(microsoftStock);
        stockSet.add(googleStock);

        market.setName("NASDAQ");
        market.setStocks(stockSet);
        session.persist(market);
        session.getTransaction().commit();
        session.close();
    }

    private static void readMarket() {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("from Market");
        List<Market> marketList = query.list();
        for (Market market : marketList) {
            System.out.println(market);
            for (Stock stock : market.getStocks()) {
                System.out.println(stock);
            }
        }
        session.close();
    }

    private static void updateMarket() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Market market = session.load(Market.class, 1l);
        market.setName("NYSE");
        Set<Stock> stocks = market.getStocks();
        stocks.forEach(t -> t.setPrice(t.getPrice() + 100));
        market.setTotalValue(Market.calculateMarketValue(stocks));
        session.getTransaction().commit();
        session.close();
    }

    private static void deleteMarket() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Market market = session.load(Market.class, 1l);
        session.delete(market);
        session.getTransaction().commit();
        session.close();
    }
}
