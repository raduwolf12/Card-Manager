package com.example.cardmanager.ui.model;

import java.io.Serializable;

public class Item implements Serializable {

    private String pozition;
    private String denumireCard;
    private String numarCard;
    private boolean isCredit;
    private String cvv;
    private String titular;
    private String data;



    private int color;

    public Item(){}

    public Item(String denumireCard)
    {
        this.denumireCard = denumireCard;
    }
    public Item(String denumireCard, int color)
    {
        this.denumireCard = denumireCard;
        this.color=color;
    }

    public Item(String denumireCard, String numarCard, boolean isCredit, String cvv, String titular, String data, int color) {
        this.denumireCard = denumireCard;
        this.numarCard = numarCard;
        this.isCredit = isCredit;
        this.cvv = cvv;
        this.titular = titular;
        this.data = data;
        this.color = color;
    }

    public String getPozition() {
        return pozition;
    }

    public void setPozition(String pozition) {
        this.pozition = pozition;
    }

    public boolean getIsCredit() {
        return isCredit;
    }

    public void setIsCredit(boolean isCredit) {
        this.isCredit = isCredit;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getDenumireCard() {
        return denumireCard;
    }

    public void setDenumireCard(String denumireCard) {
        this.denumireCard = denumireCard;
    }
    public String getNumarCard() {
        return numarCard;
    }

    public void setNumarCard(String numarCard) {
        this.numarCard = numarCard;
    }

    public void setColor(int color)
    {
        this.color=color;
    }

    public int getColor() {
        return color;
    }
}
