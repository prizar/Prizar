package com.prizar.model.drawsearch;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DrawList {
    @SerializedName("city")
    @Expose
    private String city;
    @SerializedName("denominations")
    @Expose
    private String denominations;
    @SerializedName("drawDate")
    @Expose
    private String drawDate;
    @SerializedName("prizeNumber")
    @Expose
   private String prizeNumber;
    public String getCity() {
        if (city==null)
        { return "";}
        else{
        return city;}
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDenominations() {
        if (denominations==null)
        {
            return "";}
        else
        {
        return denominations;}
    }

    public void setDenominations(String denominations) {
        this.denominations = denominations;
    }

    public String getDrawDate() {
        if (drawDate==null)
        { return "";}
        else
        {
        return drawDate;}
    }

    public void setDrawDate(String drawDate) {
        this.drawDate = drawDate;
    }

    public String getPrizeNumber() {
        if (prizeNumber==null)
        {return "";}
        else
        {
        return prizeNumber;}
    }

    public void setPrizeNumber(String prizeNumber) {
        this.prizeNumber = prizeNumber;
    }

}
