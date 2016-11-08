package com.aditya.spring.life;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Life implements BeanNameAware, InitializingBean, DisposableBean {

    private Integer id;

    public void initLife() {
        System.out.println("Init Life " + id);
    }

    public void destroyLife() {
        System.out.println("destroy Life " + id);
    }

    public Life() {
    }

    public void setId(Integer id) {
        System.out.println("Setter");
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Life [id=" + id + "]";
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("destroy ");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet");
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("setBeanName");

    }

}
