/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.socialmediaplatform;
 
import java.util.Scanner;
import javax.swing.JOptionPane;



public class Users {
    
    Scanner input= new Scanner(System.in);
    private String first_name;
    private String second_name;
    private String username;
    private String email;
    private String password;
    public static boolean IsLiked[] = new boolean[100];
    public static int IndexInArrayOfIsLiked=0;
    
    static {
        for (int z = 0; z < IsLiked.length; z++) {
            IsLiked[z] = false;
        }
    }

    
    
    public String getUsername() {
        return username;
    }

    
    
    public void setUsernamee(String name)                      
    {
        this.username = name;
    }
    
   private int setUsername(Users arr[], int size) {
       int check=-1;
    for (int j = 0; j < 5; j++) {
        System.out.print("Please enter a username: ");
        String temp = input.nextLine();
        boolean usernameTaken = false;
        for (int i = 0; i < size; i++) {
            if (arr[i].getUsername() != null && arr[i].getUsername().equals(temp)) {
                usernameTaken = true;
                break;
            }
        }
        if (!usernameTaken) {
            this.username = temp;
            check=1;
            break;
        } else {
            System.out.println("Username entered is already taken. Enter a new one.");
            System.out.println("You have " + (4 - j) + " tries left.");
        }
    }
    return check;
}

   
   
   private int setUsername(Users arr[], int size, String u) {
       int check=-1;
    for (int j = 0; j < 5; j++) {
        System.out.print("Please enter a username: ");
        String temp = u;
        boolean usernameTaken = false;
        for (int i = 0; i < size; i++) {
            if (arr[i].getUsername() != null && arr[i].getUsername().equals(temp)) {
                usernameTaken = true;
                break;
            }
        }
        if (!usernameTaken) {
            this.username = temp;
            check=1;
            break;
        } else {
            System.out.println("Username entered is already taken. Enter a new one.");
            System.out.println("You have " + (4 - j) + " tries left.");
        }
    }
    return check;
}
   
   
    public void setFirst_namee(String name)                    
    {
       this.first_name=name; 
    }
    private void setFirst_name() {
        System.out.print(" Please enter your First Name :  ");
        this.first_name=input.nextLine();
    }
    
    public void setSecond_namee(String name)                     
    {
    this.second_name=name;
    }
    private void setSecond_name() {
        System.out.print(" Please enter your Second Name :  ");
        this.second_name=input.nextLine();
    }
    public void setEmaill(String mail)                          
    {
        this.email = mail;
    }
    private int setEmail(Users arr[], int size) {
        int check=-1;
    System.out.print("Please enter your Email: ");
    for (int i = 0; i < 5; i++) {
        String s = input.nextLine();
        boolean emailTaken = false;
        if (s.matches(".*@gmail.com")) {
            for (int j = 0; j < size; j++) {
                if (arr[j] != null && arr[j].getEmail() != null && arr[j].getEmail().equals(s)) {
                    emailTaken = true;
                    break;
                }
            }
            if (!emailTaken) {
                this.email = s;
                check=1;
                System.out.println("Email set");
                break;
            } else {
                JOptionPane.showMessageDialog(null, "Email entered is already taken. Enter a new one.");
                System.out.println("You have " + (4 - i) + " tries left.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please enter a valid email ending with '@gmail.com'");
            System.out.println("You have " + (4 - i) + " tries left.");
        }
    }
    return check;
}

    
    private int setEmail(Users arr[], int size, String mail) {
        int check=-1;
    System.out.print("Please enter your Email: ");
    for (int i = 0; i < 5; i++) {
        String s = mail;
        boolean emailTaken = false;
        if (s.matches(".*@gmail.com")) {
            for (int j = 0; j < size; j++) {
                if (arr[j] != null && arr[j].getEmail() != null && arr[j].getEmail().equals(s)) {
                    emailTaken = true;
                    break;
                }
            }
            if (!emailTaken) {
                this.email = s;
                check=1;
                System.out.println("Email set");
                break;
            } else {
                JOptionPane.showMessageDialog(null, "Email entered is already taken. Enter a new one.");
                System.out.println("You have " + (4 - i) + " tries left.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please enter a valid email ending with '@gmail.com'");
            System.out.println("You have " + (4 - i) + " tries left.");
        }
    }
    return check;
}
    
    
    

    
    public void setPasswordd(String pass)                        
    {
        this.password=pass;
    }
    private int setPassword() {
        int choice=-1;
        System.out.println(" Please enter your password and make sure it contains capital,numbers, and special characters :  ");
        
        for(int i=0;i<=5;i++){
        String s=input.nextLine();    
        if(checkspecialchar(s)  &&  checkcapital(s) && checknumber(s)){
        this.password=s;
        choice=1;
        System.out.println(" password set");
        break;
        }
        else
        {
        JOptionPane.showMessageDialog(null, " Please try again and make sure that your password contains capital,numbers, and special characters :  ");
        System.out.println(" you have " + (5-i) + " tries");
        }
        }
        return choice;
    }
    
    
    private int setPassword(String pass) {
        int choice=-1;
        System.out.println(" Please enter your password and make sure it contains capital,numbers, and special characters :  ");
        
        for(int i=0;i<=5;i++){
        String s=pass;    
        if(checkspecialchar(s)  &&  checkcapital(s) && checknumber(s)){
        this.password=s;
        choice=1;
        System.out.println(" password set");
        break;
        }
        else
        {
        JOptionPane.showMessageDialog(null, " Please try again and make sure that your password contains capital,numbers, and special characters :  ");
        System.out.println(" you have " + (5-i) + " tries");
        }
        }
        return choice;
    }
    
    
    public int create_user(Users arr[], int size){
        int x=-1;
        int y=-1;
        int z=-1;
        int choice=-1;
    setFirst_name();
    setSecond_name();
    x= setUsername(arr,size);
   // setPhone_num();
   
   if(x==1)
    y= setEmail(arr,size);
   else 
   {System.out.println(" try again later ");}
   if(y==1){
    z=setPassword();
    if(z==1)
    {
   choice=1;
    JOptionPane.showMessageDialog(null, " Account Created");
    }
    }
   else 
   {
       System.out.println(" try again later ");
   }
   
    //System.out.println(" account created");
    
    return choice;
    }
    
    
    public int create_user(Users arr[], int size, String firstname, String lastname,String username, String email, String password){
        int x=-1;
        int y=-1;
        int z=-1;
        int choice=-1;
    setFirst_namee(firstname);
    setSecond_namee(lastname);
    x= setUsername(arr,size, username);
   // setPhone_num();
   
   if(x==1)
    y= setEmail(arr,size,email);
   else 
   {System.out.println(" try again later ");}
   if(y==1){
    z=setPassword( password );
    if(z==1)
    {
   choice=1;
    JOptionPane.showMessageDialog(null, " Account Created");
    }
    }
   else 
   {
       System.out.println(" try again later ");
   }
   
    //System.out.println(" account created");
    
    return choice;
    }
    
    

    public String getEmail() {
        return email;
    }


    public String getPassword() {
        return password;
    }
    

private boolean checkcapital(String s){
boolean containsCapital = false;
for (int i = 0; i < s.length(); i++) 
{
if (Character.isUpperCase(s.charAt(i))) {
containsCapital = true;
break;
    }

}
return containsCapital;
}
private boolean checknumber(String s){
        boolean containsNumber = false;
        
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))){
                containsNumber = true;
                break;
            }
        }
        return containsNumber;
    }
private boolean checkspecialchar(String s){
boolean containsSpecialChar = false;
        
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!Character.isLetterOrDigit(ch)) {
                containsSpecialChar = true;
                break;
            }
        }
        return containsSpecialChar;
}


public static int IsEmailRegistered(String s, Users arr[] , int size)
{
    
int isFound = -1;
    
    for (int i = 0; i < size; i++) {
        if (arr[i].getEmail().equals(s)) {
            System.out.println("Email found");
            isFound = i;
            break;
        }
    }
    
    if (isFound==-1) {
        JOptionPane.showMessageDialog(null,"Email not found, please try again,");
    }
    
    return isFound;
}

public static int IspassworCorrect(String s, Users arr[] , int size, int fall)
{
    if(fall<0)
        return 0;
int iscorrect = -1;
    
    
        if (arr[fall].getPassword().equals(s)) {
            System.out.println("correct password, welcome to your account");
            iscorrect = 1;
        }
    
    
    if (iscorrect==-1) {
        JOptionPane.showMessageDialog(null, "password is incorrect");
    }
    
    return iscorrect; 
}

public static int searchUser (Users arr[], int size, String temp)
{
    int userIndex = -1;
    
    for(int i=0; i<size; i++) 
    {
        if((arr[i].getUsername()).equals(temp))
        {
            //JOptionPane.showMessageDialog(null," Username found! ");
            userIndex = i;
            break;
        }
    }
     if (userIndex == -1)
        {
        
        }
return userIndex;
}



}
