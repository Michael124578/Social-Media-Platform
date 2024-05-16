package com.mycompany.socialmediaplatform;
//import java.time.LocalDateTime;
public class Like {
    private String userName;
    private static int likesCount = 0;

    
    
    

    
    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    public static void setLikesCount(int likesCount) {
        Like.likesCount = likesCount;
    }
    

    
    public String getuserName() {
        return userName;
    }
    
    public static int getLikesCount() {
        return likesCount;
    }


}