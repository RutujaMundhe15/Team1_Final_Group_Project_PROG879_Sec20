package com.example.wearfinancemanager_finalproject_sec2.model;

import java.util.Date;

public class Budget {

    /**
     * Represents a budget in a financial management context.
     * This class is responsible for defining the structure of a budget including its name,
     * spending limit, and the effective date range.
     */
    // Name of the budget.

    private String name;
    // The financial limit for this budget.

    private double limit;
    // The start date from which the budget becomes effective.

    private Date startDate;
    // The end date when the budget expires.

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
