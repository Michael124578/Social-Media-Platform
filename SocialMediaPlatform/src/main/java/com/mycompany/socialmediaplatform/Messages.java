/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.socialmediaplatform;

/**
 *
 * @author fadij
 */
public class Messages {
    public String description;
    public String usernameee;
    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public String getUsernameee() {
        return usernameee;
    }

    public void setUsernameee(String usernameee) {
        this.usernameee = usernameee;
    }
    
    
    
    public void CreateMessage( String u,String des)
    {
        setUsernameee(u);
        setDescription(des);
       // sharedInfo.mescount++;
    }
    
    public static String ShowChat(Messages arr[], int size,Users ar[],int index)
    {
        StringBuilder result = new StringBuilder("<html>");

    if (size == 0) {
        result.append("Oops... There is no messages at the moment");
    } else {
        for (int i = 0; i < size; i++) {
            result.append("<br/>Post By: ").append(arr[i].getUsernameee()).append("<br/>")
                  .append(arr[i].getDescription()).append("<br/><br/>");
                  
        }
    }
    
    result.append("</html>");
    return result.toString();
    }
    
}
