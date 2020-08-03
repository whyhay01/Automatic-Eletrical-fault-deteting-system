package com.example.automaticelectricfaultdetectingsystem;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CurrentFeeds {

    @SerializedName("feeds")
    private List<CurrentValue> feeds;

    @SerializedName("id")
    String id;

    @SerializedName("name")
    String name;

    @SerializedName("description")
    String description;

    @SerializedName("field1")
    String field1;

    @SerializedName("field2")
    String field2;

    @SerializedName("last_entry_id")
    String last_entry_id;

    public CurrentFeeds(String id, String name, String description, String field1, String field2, String last_entry_id) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.field1 = field1;
        this.field2 = field2;
        this.last_entry_id = last_entry_id;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getField1() {
        return field1;
    }

    public String getField2() {
        return field2;
    }

    public String getLast_entry_id() {
        return last_entry_id;
    }

    public List<CurrentValue> getFeeds() {
        return feeds;
    }

    public void setFeeds(List<CurrentValue> feeds) {
        this.feeds = feeds;
    }
}
