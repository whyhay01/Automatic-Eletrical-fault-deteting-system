package com.example.automaticelectricfaultdetectingsystem;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class CurrentValue {

    @SerializedName("created_at")
    private Date created_at;

    @SerializedName("entry_id")
    private Integer entry_id;

    @SerializedName("field1")
    private String field1;

    public CurrentValue(Date created_at, Integer entry_id, String field1) {
        this.created_at = created_at;
        this.entry_id = entry_id;
        this.field1 = field1;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public Integer getEntry_id() {
        return entry_id;
    }

    public String getField1() {
        return field1;
    }
}
