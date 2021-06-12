package com.example.shengqi.WeChat;

public class oneModel {
    private String name;
    private String text;
    private int imageId;

    public oneModel(String name, String text, int imageId) {
        this.name = name;
        this.text = text;
        this.imageId = imageId;
    }

    public String getName() {
        return name;
    }

    public String getText() {
        return text;
    }

    public int getImageId() {
        return imageId;
    }
}
