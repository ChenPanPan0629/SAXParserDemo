package com.example.panda.saxparserdemo;

/**
 * Created by panpan on 2019/03/20.
 */


public class InnerListBean {
    private String author;
    private String fileNameList;
    private String tableName;
    private String title;
    private String unit;
    private String date;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getFileNameList() {
        return fileNameList;
    }

    public void setFileNameList(String fileNameList) {
        this.fileNameList = fileNameList;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "InnerListBean={" +
                "author='" + author + '\'' +
                ", fileNameList='" + fileNameList + '\'' +
                ", tableName='" + tableName + '\'' +
                ", title='" + title + '\'' +
                ", unit='" + unit + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
