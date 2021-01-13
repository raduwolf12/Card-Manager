package com.example.cardmanager.ui.model;

public class CardCredit {
    private String cvv;
    private String data;
    private String cod;
    private String denumire;
    private String titular;

    public CardCredit() {
    }

    public CardCredit(String cvv, String data, String cod, String denumire, String titular) {
        this.cvv = cvv;
        this.data = data;
        this.cod = cod;
        this.denumire = denumire;
        this.titular = titular;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public String getDenumire() {
        return denumire;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }
}
