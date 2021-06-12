package com.example.shengqi.Grid;

public class GridData {
    private int ImageId;
    private String color;

    public GridData(int imageId, String color) {
        ImageId = imageId;
        this.color = color;
    }

    public int getImageId() {
        return ImageId;
    }

    public String getColor() {
        return color;
    }
}
