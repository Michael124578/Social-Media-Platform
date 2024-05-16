/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.socialmediaplatform;

/**
 *
 * @author fadij
 */
public class sharedInfo extends Users {
    
    public static String choice;
    public static int userr=-1;
    public static int posts=-1;
    public static int com=-1;
    public static int UserInex=-1;
    public static int UserSearchedIndex=-1;
    public static Users[] ss = new Users[999];
    public static Post[] cc=new Post[99];
    public static Messages[] mes=new Messages[999];
    public static int mescount=0;
    public static Comment[] ccomments=new Comment[19];
    
    
     public static int chatSize = -1; // Tracks the number of chat messages
    public static String[] chatMessages = new String[999]; // Array to store chat messages
    
    static {
        for (int z = 0; z < 999; z++) {
            mes[z]=new Messages();
            mes[z].setDescription(""); // Initialize chat messages array
        }
    }


//public static String ShowChat() {
//    StringBuilder chatDisplay = new StringBuilder("<html>");
//
//    if (sharedInfo.chatSize == 0) {
//        chatDisplay.append("No chat messages available.");
//    } else {
//        for (int i = 0; i < sharedInfo.chatSize; i++) {
//            chatDisplay.append("Msg By: ").append(sharedInfo.chatMessages[i]).append("<br/>");
//        }
//    }
//
//    chatDisplay.append("</html>");
//    return chatDisplay.toString();
//}
    
    static {
        for (int z = 0; z < 999; z++) {
            ss[z] = new Users();
        }
    }
}

