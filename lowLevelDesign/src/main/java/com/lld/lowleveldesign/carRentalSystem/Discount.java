package com.lld.lowleveldesign.carRentalSystem;

public class Discount {
    public int percentageDiscount;
    public int maxDiscount;

    public Discount(int percentageDiscount, int maxDiscount) {
        this.percentageDiscount = percentageDiscount;
        this.maxDiscount = maxDiscount;
    }
    public int getDiscount(int amount){
        return Math.max((int) (((double)percentageDiscount/(double) 100) * (double)amount),(int)maxDiscount);
    }
}
