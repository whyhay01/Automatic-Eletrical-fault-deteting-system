package com.example.automaticelectricfaultdetectingsystem;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CurrentFeeds {

    @SerializedName("feeds")
    private List<CurrentValue> feeds;

    public List<CurrentValue> getFeeds() {
        return feeds;
    }

    public void setFeeds(List<CurrentValue> feeds) {
        this.feeds = feeds;
    }
}
