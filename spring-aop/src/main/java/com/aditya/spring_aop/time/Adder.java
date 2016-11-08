package com.aditya.spring_aop.time;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Adder {

    public void addToList() {
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < 1000; i++) {
            list.add(i);
        }
    }

    public void addToVector() {
        List<Integer> vector = new Vector<Integer>();
        for (int i = 0; i < 1000; i++) {
            vector.add(i);
        }
    }
}
