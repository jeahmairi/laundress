package com.example.user.laundress2;

public class HistoryList {
    private String name, date, laundryweight, status;
    private float ratings;
    private int trans_No, client_ID;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getClient_ID() {
        return client_ID;
    }

    public void setClient_ID(int client_ID) {
        this.client_ID = client_ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLaundryweight() {
        return laundryweight;
    }

    public void setLaundryweight(String laundryweight) {
        this.laundryweight = laundryweight;
    }

    public float getRatings() {
        return ratings;
    }

    public void setRatings(float ratings) {
        this.ratings = ratings;
    }

    public int getTrans_No() {
        return trans_No;
    }

    public void setTrans_No(int trans_No) {
        this.trans_No = trans_No;
    }
}
