package com.mycompany.socialmediaplatform;


import java.util.Scanner;

public class Post{
Scanner input = new Scanner(System.in);
    private String UserName;
    private static int nextPostId = 0;
     private int PostId;
    private String Description ;
    private String commentDescription;
    private int LikesCount ;
    private int CommentsCounts = 0;

    
    private String[] likedBy= new String[100]; // Array to store usernames of users who liked the post
    private int likedByIndex=0;
    
    public void addLike(String username, Post[] arr) {
        // Check if the user has already liked the post
        boolean alreadyLiked = false;
        for (int i = 0; i < likedByIndex; i++) {
            if (likedBy[i].equals(username)) {
                alreadyLiked = true;
                break;
            }
        }
        if (!alreadyLiked) {
            // Find the Post object in the array and update its likes count
            for (int i = 0; i < arr.length; i++) {
                // Ensure that the Post object exists and its ID matches this.PostId
                if (arr[i].getPostId() == this.PostId-1) {
                    // Increment likes count
                    arr[i].setLikesCount(arr[i].getLikesCount() + 1);

                    // Add the username to the array of users who liked the post
                    likedBy[likedByIndex] = username;
                    likedByIndex++;
                    System.out.println("Post liked.");
                    return; // Exit the method after liking the post
                }
            }

            // If the loop completes without finding the Post object, print an error message
            System.out.println("Post not found.");
        } else {
            System.out.println("You have already liked this post.");
        }
    }
    
    
    public void dislike(String username, Post[] arr) {
        // Check if the user has already liked the post
        boolean alreadyLiked = false;
        int likedIndex = -1; // Store the index of the liked post
        for (int i = 0; i < likedByIndex; i++) {
            if (likedBy[i].equals(username)) {
                alreadyLiked = true;
                likedIndex = i;
                break;
            }
        }
        if (alreadyLiked) {
            // If liked, find the Post object in the array and update its likes count
            for (int i = 0; i < arr.length; i++) {
                if (arr[i].getPostId() == this.PostId - 1) {
                    arr[i].setLikesCount(arr[i].getLikesCount() - 1); // Decrement likes count
                    break;
                }
            }
            // Remove the username from the array of users who liked the post
            if (likedIndex != -1) {
                // Shift elements to the left to remove the disliked username
                for (int j = likedIndex; j < likedByIndex - 1; j++) {
                    likedBy[j] = likedBy[j + 1];
                }
                // Decrement likedByIndex
                likedByIndex--;
            }
            System.out.println("Post disliked.");
        } else {
            System.out.println("You haven't liked this post yet.");
        }
    }
    
    
    
    public void CreatePost(String username, String des)
    {
    setPostId(PostId);
    PostId++;
    setUserName(username);
//    System.out.println(" Please enter the Post description: ");
//    String temp = input.nextLine();
    setDescription(des);
    }
   
    public void CreatePost(String username)
    {
    setPostId(PostId);
    PostId++;
    setUserName(username);
    System.out.println(" Please enter the Post description: ");
    String temp = input.nextLine();
    setDescription(temp);
    }
    
    
    
    public static void ShowFeed(Post[] arr, int size) {
        if (size == 0)
            System.out.println(" oops... There is no posts at the moment");
        else
            for (int i = 0; i < size; i++) {
                System.out.println(" //////////////////////////////////////////////////////// ");
                System.out.println(" Post By: " + arr[i].getUserName());
                System.out.println(" Post ID: " + arr[i].getPostId());
                System.out.println(" Post Description: " + arr[i].getDescription());
                System.out.println(" Post Likes: " + arr[i].getLikesCount());
                System.out.println(" Post comments' count: " + arr[i].getCommentsCounts());
                System.out.println(" //////////////////////////////////////////////////////// ");
            }
    }
    
    
    
public static String ShowFeedd(Post arr[], int size) {
    StringBuilder result = new StringBuilder("<html>");

    if (size == 0) {
        result.append("Oops... There is no posts at the moment");
    } else {
        for (int i = 0; i < size; i++) {
            result.append("<br/>Post By: ").append(arr[i].getUserName()).append("<br/>")
                  .append("Post ID: ").append(arr[i].getPostId()).append("<br/>")
                  .append("Post Description: ").append(arr[i].getDescription()).append("<br/>")
                  .append("Post Likes: ").append(arr[i].getLikesCount()).append("<br/>")
                  .append("Post comments' count: ").append(arr[i].getCommentsCounts()).append("<br/><br/>");
        }
    }
    
    result.append("</html>");
    return result.toString();
}


public static void ShowFriendFeed(Post arr[], int size, String name,int index)
{
    if(size==0)
        System.out.println(" oops... There is no posts at the moment");
    else 
    {
for(int i=0;i<size;i++)
{
    if (name.equals(arr[i].getUserName())){
System.out.println(" ///////////////////////////////////////////////////////////");
System.out.println(" Post By: " + arr[i].getUserName());
System.out.println(" Post ID: " + arr[i].getPostId());
System.out.println(" Post Description: " + arr[i].getDescription());
System.out.println(" Post Likes: " + arr[i].getLikesCount());
System.out.println(" Post comments' count: " + arr[i].getCommentsCounts());
System.out.println(" ///////////////////////////////////////////////////////////");
}
    else
        System.out.println(" oops... There is no posts at the moment");
}
    }
}

    
      public void setUserName(String UserName) {
        this.UserName = UserName;
      }
    
      public String getUserName() {
        return UserName;
      }
    
      public void setPostId(int PostId) {
        this.PostId = PostId;
      }
    
      public int getPostId() {
        return PostId;
      }
    
      public void setDescription(String Description) {
        this.Description = Description;
      }
    
      public String getDescription() {
        return Description;
      }
    
      public void setLikesCount(int Likescount) {
        this.LikesCount = Likescount;
      }
    
      public int getLikesCount() {
        return LikesCount;
      }
    
      public void setCommentsCounts(int CommentsCounts) {
        this.CommentsCounts = CommentsCounts;
      }
    
      public int getCommentsCounts() {
        return CommentsCounts;
      }



      public void CreateComment(String username, String commentDescription, int PostId, CommentsArray arr[], int CommentsArraySize)
{
    Comment comment= new Comment();
    
CommentsCounts++;
//setPostId(PostId);
this.UserName=username;
arr[CommentsArraySize].setCommentDescription(commentDescription);


}

      
      

}