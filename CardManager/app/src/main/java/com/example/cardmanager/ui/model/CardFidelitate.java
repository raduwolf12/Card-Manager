package com.example.cardmanager.ui.model;

public class CardFidelitate {
    private String cod;
    private String denumire;

    public CardFidelitate(){}
    public CardFidelitate(String cod, String denumire) {
        this.cod = cod;
        this.denumire = denumire;
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
