package com.jaehee.new_facerecognition;

// 사용자 계정 정보 모델 클레스

public class UserAccount {

    private String UserIdToken;
    private String UserId;
    private String UserPass;
    private String UserAge;
    private String UserName;
    private String imageUrl; // Add this field for the user image URL

    public UserAccount() { }


    public String getUserIdToken() { return UserIdToken; }
    public void setUserIdToken(String userIdToken) {
        this.UserIdToken = userIdToken;
    }

    public String getUserId() { return UserId; }
    public void setUserId(String userId) {
        this.UserId = userId;
    }

    public String getUserPass() { return UserPass; }
    public void setUserPass(String userPass) {
        this.UserPass = userPass;
    }

    public String getUserAge() { return UserAge; }
    public void setUserAge(String userAge) {
        this.UserAge = userAge;
    }

    public String getUserName() { return UserName; }
    public void setUserName(String userName) {
        this.UserName = userName;
    }
    public String getImageUrl() { return imageUrl;}
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }

}

