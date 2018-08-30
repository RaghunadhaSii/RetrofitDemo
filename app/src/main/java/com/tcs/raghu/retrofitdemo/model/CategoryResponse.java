package com.tcs.raghu.retrofitdemo.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CategoryResponse {

    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("total_count")
    @Expose
    private Integer totalCount;
    @SerializedName("category")
    @Expose
    private List<Category> category = null;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public List<Category> getCategory() {
        return category;
    }

    public void setCategory(List<Category> category) {
        this.category = category;
    }

}



