package com.example.raji.mybillingapp;

public class Items {

   String orderedTime,orderRef,orderProf,orderStatus,orderRate,orderAddress,orderTax,orderDiscount,orderGrandTotal,orderServices,orderPaymentStatus,orderPlace,orderStartTime,orderEndTime,jobAssignment,orderTotalTime,changeBooking;


   //check the declaration of image


    public Items(String orderedTime, String orderRef, String orderProf, String orderStatus, String orderRate, String orderAddress, String jobAssignment, String orderTax, String orderDiscount, String orderGrandTotal, String orderServices, String orderPaymentStatus, String orderPlace, String orderStartTime, String orderEndTime, String orderTotalTime,String changeBooking) {
        this.orderedTime = orderedTime;
        this.orderRef = orderRef;
        this.orderProf = orderProf;
        this.orderStatus = orderStatus;
        this.orderRate = orderRate;
        this.orderAddress = orderAddress;
        this.orderTax = orderTax;
        this.orderDiscount = orderDiscount;
        this.orderGrandTotal = orderGrandTotal;
        this.orderServices = orderServices;
        this.orderPaymentStatus = orderPaymentStatus;
        this.orderPlace = orderPlace;
        this.orderStartTime = orderStartTime;
        this.orderEndTime = orderEndTime;
        this.orderTotalTime = orderTotalTime;
        this.jobAssignment = jobAssignment;
        this.changeBooking = changeBooking;
    }

    public String getOrderedTime() {
        return orderedTime;
    }

    public String getOrderRef() {
        return orderRef;
    }

    public String getOrderProf() {
        return orderProf;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public String getOrderRate() {
        return orderRate;
    }

    public String getOrderAddress() {
        return orderAddress;
    }

    public String getJobAssignment() {
        return jobAssignment;
    }

    public String getOrderTax() {
        return orderTax;
    }

    public String getOrderDiscount() {
        return orderDiscount;
    }

    public String getOrderGrandTotal() {
        return orderGrandTotal;
    }

    public String getOrderServices() {
        return orderServices;
    }

    public String getOrderPaymentStatus() {
        return orderPaymentStatus;
    }

    public String getOrderPlace() {
        return orderPlace;
    }

    public String getOrderStartTime() {
        return orderStartTime;
    }

    public String getOrderEndTime() {
        return orderEndTime;
    }

    public String getOrderTotalTime() {
        return orderTotalTime;
    }

    public String getChangeBooking() {
        return changeBooking;
    }
}
