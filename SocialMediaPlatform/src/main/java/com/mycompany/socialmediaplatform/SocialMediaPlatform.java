package com.mycompany.socialmediaplatform;

import java.io.*;
import java.util.Scanner;


public class SocialMediaPlatform  {

    public static void main(String[] args) {
    sharedInfo.userr=SocialMediaPlatform.LOAD_USERS_INFO_FROM_FILE(sharedInfo.ss, "UsersInfo.txt");
    sharedInfo.posts=SocialMediaPlatform.LOAD_POSTS_INFO_FROM_FILE(sharedInfo.cc, "PostsInfo.txt");
    sharedInfo.com=SocialMediaPlatform.LOAD_COMMENTS_INFO_FROM_FILE(sharedInfo.ccomments, "CommentsInfo.txt");
    sharedInfo.mescount=SocialMediaPlatform.LOAD_Chat_INFO_FROM_FILE(sharedInfo.mes, "ChatInfo.txt");
    new Intro().setVisible(true);
    Scanner input= new Scanner(System.in); 
    Post[] c=sharedInfo.cc;
    CommentsArray[] array = new CommentsArray[100];
    //Comment[] comments=sharedInfo.ccomments;
    //Users[] s=sharedInfo.ss;
    int comsize=0;
    int aykalam=-1;
    //int users=sharedInfo.userr;
    //int posts=0;
    int temp1=-1;
    //int com=0;
    String tempemail;
    String temppassword;
    for(int i=0;i<100;i++)
    {
    array[i]= new CommentsArray();
    array[i].setCommentDescription("");
    }
    for(int i=0;i<=1;i--)
    {       
            System.out.println(" Enter (1) to create an account, Enter (2) for login, Enter (3) to exit program");
            sharedInfo.choice =input.next();
            switch(sharedInfo.choice)                                                                    //////////////////////////////////////////////////////////////first switch
            {
                case "1":
                                                                       //////////////////////////// create accout
                        int xx=sharedInfo.ss[sharedInfo.userr].create_user(sharedInfo.ss,sharedInfo.userr);
                        if(xx==1){
                        sharedInfo.userr++;
                        System.out.println(" account created");}
                        else
                            System.out.println(" Account not created ");
                 break;
                case "2":                                              ////////////////////////////// login
                   
                            System.out.println(" Enter your email ");
                            tempemail=input.next();
                             sharedInfo.UserInex=Users.IsEmailRegistered(tempemail , sharedInfo.ss, sharedInfo.userr);
                                if(sharedInfo.UserInex>=0)
                                {
                                System.out.println(" Enter your password ");
                                temppassword=input.next();
                                int y=Users.IspassworCorrect(temppassword, sharedInfo.ss, sharedInfo.userr, sharedInfo.UserInex);
                                        if(y==1)
                                        {
                                            ////////////////////////////// the main code body
                                            for(int ii=0;ii<=1;ii--)
                    {
                                            System.out.println(" To show your feed, enter [1].\n To create a post, enter [2].\n To search a friend, enter [3].\n To logout, enter[4].  ");
                                            sharedInfo.choice =input.next();
                                            switch (sharedInfo.choice)                                    ////////////////////////////////////////////////////////////////first nested switch
                                            {
                                                case "1":                                      
                                                    Post.ShowFeed(sharedInfo.cc, sharedInfo.posts);
                                                    if(sharedInfo.posts>0)
                                                    {
                                                    System.out.println(" If you want to add a comment, enter [1].\n To like a post, enter [2].\n To dislike a post, enter [3].\n To Skip, enter [4].\n");
                                                    sharedInfo.choice =input.next();
                                                    
                                                    switch (sharedInfo.choice)
                                                    {
                                                        case "1":
                                                            sharedInfo.ccomments[sharedInfo.com] = new Comment();
                                                             sharedInfo.com++;
                                                            System.out.println(" enter the post owner's username ");
                                                            sharedInfo.choice =input.next();
                                                            for(int iiii=0;iiii<sharedInfo.com;iiii++)
                                                            {
                                                            if((sharedInfo.cc[iiii].getUserName()).equals(sharedInfo.choice))
                                                            {
                                                                System.out.print(" Tell me what is on your mind: ");
                                                                String tempe=input.nextLine();
                                                                String ttempemail=input.nextLine();
                                                                System.out.print(" give me the post id ");
                                                                aykalam=input.nextInt();
                                                                sharedInfo.cc[sharedInfo.com-1].CreateComment(sharedInfo.choice,ttempemail,aykalam,array,comsize);
                                                               
                                                                System.out.print(" comment created ");
                                                                break;
                                                            }else{
                                                            System.out.print(" Enter username correctly ");
                                                            break;
                                                            }
                                                            }
                                                            break;
                                                        case "2":
                                                            System.out.println(" Plese enter the post number ");
                                                            temp1=input.nextInt();
                                                           sharedInfo.cc[temp1].addLike(sharedInfo.ss[sharedInfo.UserInex].getUsername(),c); //Like.LikePost(sharedInfo.ss, sharedInfo.UserInex, sharedInfo., rr, ii, ii);
                                                            break;
                                                        case "3":
                                                            System.out.println(" Not available yet ");
                                                            //Like.unlikePost(s, x, c, posts, temp1);
                                                            break;
                                                        case "4":
                                                            System.out.print(" you skipped ");
                                                            break;
                                                        default:
                                                            System.out.println("Invalid choice. Please enter 1, 2, 3 or 4.");
                                                    }
                                                    }
                                                    break;
                                                case "2":
                                                    sharedInfo.cc[sharedInfo.posts] = new Post();
                                                    sharedInfo.cc[sharedInfo.posts].CreatePost(sharedInfo.ss[sharedInfo.UserInex].getUsername());
                                                    sharedInfo.posts++;
                                                    break;

                                                case "3":
                                                    System.out.println(" Enter desired Username: ");
                                                    String temp = input.next();
                                                    temp1 = Users.searchUser(sharedInfo.ss, sharedInfo.userr, temp);
                                                    if(temp1>=0)
                                                    {
                                                        for(int iii=0;iii<=1;iii--)
                                                        {
                                                            System.out.println(" Look out for his timeline!\n "); 
                                                            Post.ShowFriendFeed(sharedInfo.cc,sharedInfo.posts,temp,temp1); 
                                                            System.out.println(" To like post, enter [1].\n To comment on post, enter [2].\n Go back, enter [3].");
                                                            sharedInfo.choice =input.next();
                                                                switch (sharedInfo.choice)                                                  ///////////////////////////////////////// first nested of nested switch
                                                                  {
                                                                         case "1":
                                                                             System.out.println(" Plese enter the post number ");
                                                                             temp1=input.nextInt();
                                                                             //Like.likePost(sharedInfo.ss, x, sharedInfo.cc, sharedInfo.posts,temp1);
                                                                             break;
                                                                         case "2":
                                                                             System.out.println(" Not available yet ");
                                                                             break;
                                                                         case "3":
                                                                             iii=5;
                                                                             break;
                                                                             default:
                                                                             System.out.println(" Invalid choice. Please enter 1, 2 or 3.");
                                                                   }
                                                         }
                                                    }
                                                break;

                                                case "4":
                                                                            ii=5;
                                                                            System.out.println(" Loged out.");
                                                break;
                                                default:
                                                                            System.out.println("Invalid choice. Please enter 1,2 or 3.");
                                            }

                                    /////////////////////////////// end of main program
            }
                                        }else System.out.println(" try again ");
                                }else System.out.println(" try again ");

                break;
                case "3":
                    i=5;
                    SocialMediaPlatform.SAVE_USERS_INFO_TO_FILE(sharedInfo.ss, sharedInfo.userr, "UsersInfo.txt");
                    SocialMediaPlatform.SAVE_POSTS_INFO_TO_FILE(sharedInfo.cc,sharedInfo.posts, "PostsInfo.txt");
                    //SocialMediaPlatform.SAVE_COMMENTS_INFO_TO_FILE(sharedInfo.ccomments,sharedInfo.com, "CommentsInfo.txt", array,aykalam);
                    SocialMediaPlatform.SAVE_CHAT_INFO_TO_FILE(sharedInfo.mes, sharedInfo.mescount,"ChatInfo.txt");
                    System.out.println(" See you soon ");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter 1, 2, or 3.");
            }
    }

    
    
    
    }
   


    
    public static void saveUsersToFile(String file,String text)
    {
        try{
            File f = new File(file);
            FileWriter fw= new FileWriter(f,true);
            PrintWriter pw = new PrintWriter(fw);
            pw.println(text);
            pw.close();
        }catch(IOException e){
            System.out.println("error: save to file");
        }
    }
    
    public static void SAVE_USERS_INFO_TO_FILE(Users arr[], int size,String file)
    {
        for(int ii=0;ii<size;ii++)
        {
        try{
            File f = new File(file);
            FileWriter fw= new FileWriter(f,false);
            PrintWriter pw = new PrintWriter(fw);
            pw.println(size);
        for(int i=0;i<size;i++)
        {
            pw.println(arr[i].getEmail() +"\n" + arr[i].getPassword()+"\n"+arr[i].getUsername());
            
        }
        pw.close();
                
    }
    catch(IOException e){
            System.out.println("error: save to file");
}
} 
        
}
    public static int LOAD_USERS_INFO_FROM_FILE(Users arr[], String file) {
    int i = 0;
    int size = 0;
    try {
        Scanner s = new Scanner(new File(file));
        if (s.hasNextInt()) {
            size = s.nextInt(); // Read the size of the array
            s.nextLine(); // Consume newline character after reading the size
            while (s.hasNextLine() && i < size) {
                arr[i] = new Users(); // Initialize user object
                arr[i].setEmaill(s.nextLine()); // Read email
                arr[i].setPasswordd(s.nextLine()); // Read password
                arr[i].setUsernamee(s.nextLine()); // Read username
                i++;
            }
        } else {
            System.out.println("No size found in the file.");
        }
        s.close(); // Close the scanner
    } catch (FileNotFoundException e) {
        System.out.println("Error: File not found.");
    }
    return size;
}  
    public static int LOAD_POSTS_INFO_FROM_FILE(Post arr[], String file) {
    int i = 0;
    int size = 0;
    try {
        Scanner s = new Scanner(new File(file));
        if (s.hasNextInt()) {
            size = s.nextInt(); // Read the size of the array
            s.nextLine(); // Consume newline character after reading the size
            while (s.hasNextLine() && i < size) {
                arr[i] = new Post(); // Initialize post object
                arr[i].setPostId(Integer.parseInt(s.nextLine())); // Read post id
                arr[i].setUserName(s.nextLine()); // Read post by :
                arr[i].setDescription(s.nextLine()); // Read post description
                arr[i].setLikesCount(Integer.parseInt(s.nextLine())); // Read number of likes
                arr[i].setCommentsCounts(Integer.parseInt(s.nextLine())); // Read number of comments
                i++;
            }
        } else {
            System.out.println("No size found in the file.");
        }
        s.close(); // Close the scanner
    } catch (FileNotFoundException e) {
        System.out.println("Error: File not found.");
    }
    return size;
}
    public static void SAVE_POSTS_INFO_TO_FILE(Post arr[], int size,String file)
    {
        for(int ii=0;ii<size;ii++)
        {
        try{
            File f = new File(file);
            FileWriter fw= new FileWriter(f,false);
            PrintWriter pw = new PrintWriter(fw);
            pw.println(size);
        for(int i=0;i<size;i++)
        {
            pw.println(arr[i].getPostId() +"\n" + arr[i].getUserName()+"\n"+arr[i].getDescription()+"\n"+arr[i].getLikesCount()+"\n"+arr[i].getCommentsCounts());
            
        }
        pw.close();
                
    }
    catch(IOException e){
            System.out.println("error: save to file");
}
} 
        
}
    
    public static int LOAD_COMMENTS_INFO_FROM_FILE(Comment arr[], String file) {
    int i = 0;
    int size = 0;
    try {
        Scanner s = new Scanner(new File(file));
        if (s.hasNextInt()) {
            size = s.nextInt(); // Read the size of the array
            s.nextLine(); // Consume newline character after reading the size
            while (s.hasNextLine() && i < size) {
                arr[i] = new Comment(); // Initialize post object
                arr[i].setUserName(s.nextLine());
                arr[i].setPostNum(Integer.parseInt(s.nextLine())); // Read post id
                arr[i].setDescription(s.nextLine()); // Read post description 
                i++;
            }
        } else {
            System.out.println("No size found in the file.");
        }
        s.close(); // Close the scanner
    } catch (FileNotFoundException e) {
        System.out.println("Error: File not found.");
    }
    return size;
}
    public static void SAVE_COMMENTS_INFO_TO_FILE(Comment arr[], int size, String file, CommentsArray orr[], int postindex)
    {
        for(int ii=0;ii<size;ii++)
        {
        try{
            File f = new File(file);
            FileWriter fw= new FileWriter(f,false);
            PrintWriter pw = new PrintWriter(fw);
            pw.println(size);
        for(int i=0;i<size;i++)
        {
            //for(int j=0;j<size;j++)
            pw.println(sharedInfo.ss[sharedInfo.UserInex].getUsername()+"\n" + (arr[i].getPostNum(postindex)-1)+"\n"+orr[i].getCommentDescription());
            
        }
        pw.close();
                
    }
    catch(IOException e){
            System.out.println("error: save to file");
}
} 
        
}
    

   public static int LOAD_Chat_INFO_FROM_FILE(Messages arr[], String file) {
    int i = 0;
    int size = 0;
    try {
        Scanner s = new Scanner(new File(file));
        if (s.hasNextInt()) {
            size = s.nextInt(); // Read the size of the array
            s.nextLine(); // Consume newline character after reading the size
            while (s.hasNextLine() && i < size) {
                arr[i] = new Messages(); // Initialize post object
                arr[i].setUsernameee(s.nextLine()); // Read post by :
                arr[i].setDescription(s.nextLine()); // Read message description
                
                i++;
            }
        } else {
            System.out.println("No size found in the file.");
        }
        s.close(); // Close the scanner
    } catch (FileNotFoundException e) {
        System.out.println("Error: File not found.");
    }
    return size;
}
   
   
   public static void SAVE_CHAT_INFO_TO_FILE(Messages arr[], int size, String file) {
       //System.out.println("i am in save messages method");
    try {
        File f = new File(file);
        FileWriter fw = new FileWriter(f, false); // 'false' for overwriting existing file
        PrintWriter pw = new PrintWriter(fw);
        pw.println(size);
        // Writing messages
        for (int i = 0; i < size; i++) {
            pw.println(sharedInfo.mes[i].getUsernameee());
            pw.println(arr[i].getDescription());
        }
        
        pw.close();
        System.out.println("Chat info saved to file successfully."); // Add a success message
    } catch (IOException e) {
        System.out.println("Error: Failed to save chat info to file.");
        e.printStackTrace(); // Print the stack trace for debugging
    }
}

     
    
    
    
}