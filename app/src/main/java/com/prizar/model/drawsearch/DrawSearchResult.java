package com.prizar.model.drawsearch;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;
public class DrawSearchResult {

    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("success")
    @Expose
    private Boolean success;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("data")
    @Expose

        private List<DrawList> data = null;

        public String getStatus() {
            if (status==null)
            {   return "";}
            else
            {
            return status;}
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getMessage() {
            if (message==null)
            { return "";}
            else
            {
            return message;}
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public List<DrawList> getData() {

            return data;
        }

        public void setData(List<DrawList> data) {
            this.data = data;
        }



}


