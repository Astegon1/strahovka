package com.example.betaforall.model;

public class ItemModel {
    private String text1;
    private String text2;
    private String text3;
    private int imageResId;

    public ItemModel(String text1, String text2, String text3, int imageResId) {
        this.text1 = text1;
        this.text2 = text2;
        this.text3 = text3;
        this.imageResId = imageResId;
    }

    public String getText1() {
        return text1;
    }

    public String getText2() {
        return text2;
    }

    public String getText3() {
        return text3;
    }

    public int getImageResId() {
        return imageResId;
    }
}