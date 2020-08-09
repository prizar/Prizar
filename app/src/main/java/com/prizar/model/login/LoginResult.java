package com.prizar.model.login;


public class LoginResult {

    private String status;
    private String message;
    private LoginData data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LoginData getData() {
        return data;
    }

    public void setData(LoginData data) {
        this.data = data;
    }

    public class LoginData {

        private Integer id;
        private String name;
        private Object personalPhone;
        private String token;
        private Boolean fcmToken;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Object getPersonalPhone() {
            return personalPhone;
        }

        public void setPersonalPhone(Object personalPhone) {
            this.personalPhone = personalPhone;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public Boolean getFcmToken() {
            return fcmToken;
        }

        public void setFcmToken(Boolean fcmToken) {
            this.fcmToken = fcmToken;
        }

    }
}
