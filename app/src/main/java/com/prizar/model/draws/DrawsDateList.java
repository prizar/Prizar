package com.prizar.model.draws;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DrawsDateList {
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("denominationsId")
    @Expose
    private String denominationsId;
    @SerializedName("drawNumber")
    @Expose
    private String drawNumber;
    @SerializedName("drawDate")
    @Expose
    private String drawDate;

    public String getId() {
        if (id==null)
        { return "";}
        else{
            return id;}

    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDenominationsId() {

        if (denominationsId==null)
        { return "";}
        else{
            return denominationsId;}

    }

    public void setDenominationsId(String denominationsId) {
        this.denominationsId = denominationsId;
    }

    public String getDrawNumber() {
        if (drawNumber==null)
        { return "";}
        else{
            return drawNumber;}

    }

    public void setDrawNumber(String drawNumber) {
        this.drawNumber = drawNumber;
    }

    public String getDrawDate() {
        if (drawDate==null)
        { return "";}
        else{
            return drawDate;}
    }

    public void setDrawDate(String drawDate) {
        this.drawDate = drawDate;
    }

}