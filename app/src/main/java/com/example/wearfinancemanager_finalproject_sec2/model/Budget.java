package com.example.wearfinancemanager_finalproject_sec2.model;

import java.util.Date;

public class Budget {

    private String name;
    private double limit;
    private Date startDate;
    private Date endDate;

    public Budget(String name, double limit, Date startDate, Date endDate) {
        this.name = name;
        this.limit = limit;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getName() {
        return name;
    }

    public double getLimit() {
        return limit;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }
}
