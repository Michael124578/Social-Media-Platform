package com.mycompany.socialmediaplatform;
public class Comment {
    private String USERNAME;
    private String Description;
    private int PostId;



    public void setUserName(String UserName) {
        this.USERNAME = UserName;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public void setPostNum(int PostNum) {
        this.PostId = PostNum;
    }



    public int getPostNum(int i) {
        return sharedInfo.cc[i].getPostId();
    }

    
    
    
    
    
 }