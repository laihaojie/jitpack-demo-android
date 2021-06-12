package com.example.shengqi.Lianxi;

public class DataObject {
    private String name;
    private String text;
    private int Imageid;

    public DataObject(String name, String text, int imageid) {
        this.name = name;
        this.text = text;
        Imageid = imageid;
    }

    public String getName() {
        return name;
    }

    public String getText() {
        return text;
    }

    public int getImageid() {
        return Imageid;
    }
}
