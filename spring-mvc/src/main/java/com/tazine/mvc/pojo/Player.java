package com.tazine.mvc.pojo;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author jiaer.ly
 * @date 2018/02/24
 */
public class Player {

    private String name;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;

    private Integer num;

//    public Player(String name, Date date) {
//        this.name = name;
//        this.date = date;
//    }
//
    public Player(String name, Date date, Integer num) {
        this.name = name;
        this.date = date;
        this.num = num;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", date=" + date +
                ", num=" + num +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
