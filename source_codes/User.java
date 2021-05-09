import java.util.ArrayList;

public class User 
{
	private String name;
	private String email;
	private String dateOfBirth;
	private String placeOfResidence;
	
	private ArrayList<String> notificationBox;
	private ArrayList<Post> postList;
	private ArrayList<Post> timeLine;
	private ArrayList<Post> favouritePosts;
	private ArrayList<User> followedUserList;
	private ArrayList<Message> incomingMessageBox;
	private ArrayList<Message> outgoingMessageBox;
			
	public User(String name , String email , String dateOfBirth , String placeOfResidence)
	{
		this.name=name;
		this.email=email;
		this.dateOfBirth=dateOfBirth;
		this.placeOfResidence=placeOfResidence;
		notificationBox=new ArrayList<String>();
		postList=new ArrayList<Post>();
		timeLine=new ArrayList<Post>();
		favouritePosts=new ArrayList<Post>();
		followedUserList=new ArrayList<User>();
		incomingMessageBox=new ArrayList<Message>();
		outgoingMessageBox=new ArrayList<Message>();
	}
	
	public void followUser(User userName)//follow new user
	{
		boolean controlFriend = false;
		
		for(int i = 0 ; i < followedUserList.size() ; i++)
		{
			if(followedUserList.get(i).equals(userName))
			{
				controlFriend = true;
				break;
			}
			else
			{
				controlFriend = false;
			}
		}
		
		if(controlFriend == true)
		{
			System.out.println("You already have followed this user !!!");
		}
		else
		{
			followedUserList.add(userName);
		  	userName.notificationBox.add(name + " have followed you.");
		}	
	}
	
	public void showFollowedUserList()//show followed user list
	{		
		for(int i = 0 ; i < followedUserList.size() ; i++)
		{
			System.out.print((i + 1) + "- ");
			System.out.println(followedUserList.get(i).getName());
		}
	}
	
	public void showNotificationBox()//show notification box
	{
		System.out.println("NOTIFICATION BOX");
		System.out.println("------------------");
		
		for(String x : notificationBox)
		{
			System.out.println("- " + x);
		}
		
		System.out.println("---------------------------------\n");
	}
		
	public void sendMessage(User receiverUser , String contentMessage)//you can send message 
	{
		Message message = new Message(name , receiverUser , contentMessage);
		
		outgoingMessageBox.add(message);
		receiverUser.incomingMessageBox.add(message);	
	}
	
	public void showOutgoingMessageBox()
	{
		System.out.println("OUTGOING MESSAGE BOX");
		System.out.println("--------------------");
		
		for(int i = 0 ; i < outgoingMessageBox.size() ; i++)
		{
			System.out.println((i + 1) + ". MESSAGE");
			System.out.println(outgoingMessageBox.get(i).getDetails());
		}
		
		System.out.println("---------------------------------\n");
	}
	
	public void showIncomingMessageBox()
	{
		System.out.println("INCOMING MESSAGE BOX");
		System.out.println("--------------------");
		
		for(int i = 0 ; i < incomingMessageBox.size() ; i++)
		{
			System.out.println((i + 1) + ". MESSAGE");
			System.out.println(incomingMessageBox.get(i).getDetails());
		}
		
		System.out.println("---------------------------------\n");
	}

	public String getName()
	{
		return name;
	}
	
	public String getInformationOfUser()
	{
		return "User Name : " + name + "\n" +
				"User Email : " + email + "\n" +
				"User Date of Birth : " + dateOfBirth + "\n" + 
				"User Residence : " + placeOfResidence ;
	}
	
	public String getDateOfBirthday()
	{
		return dateOfBirth;
	}
	
	public User searchUserList(int index)
	{	
		return followedUserList.get(index - 1);	
	}	
	
	public void sharePost(String message)
	{
		Post post = new Post(name , message);
		postList.add(post);
	}
	
	public void likePost(int index)
	{	
		if(timeLine.size() >= index)
		{
			if(timeLine.get(index - 1).getLike() == 1)
			{
				System.out.println("\nYou already like this post\n");
			}
			else
			{
				timeLine.get(index - 1).setLikes();
				favouritePosts.add(timeLine.get(index - 1));	
			}	
		}
		else
		{
			System.out.println("INCORRECT ENTERED !!!");
		}					
	}
		
	public void showPosts()
	{
		System.out.println("POSTS");
		System.out.println("--------------------");
		
		for(int i = 0 ; i < postList.size() ; i++)
		{
			System.out.println((i + 1) + ". POST");
			System.out.println(postList.get(i).getDetails());
		}
		
		System.out.println("---------------------------------\n");
	}
		
	public void showTimeLine()
	{	
		timeLineToPostList();
		
		System.out.println("TÝME LÝNE");
		System.out.println("--------------------");
		
		for(int i = 0 ; i < timeLine.size() ; i++)
		{			
			System.out.println((i + 1) + ". POST");
			System.out.println(timeLine.get(i).getDetails());
		}

		System.out.println("---------------------------------\n");
	}
		
	private void timeLineToPostList()
	{
		timeLine.removeAll(timeLine);
		
		for(int i=0 ; i < followedUserList.size() ; i++)
		{			
			timeLine.addAll(followedUserList.get(i).postList);		
		}
	}
	
	public void showFavouritePosts()
	{
		System.out.println("FAVOURITE POST");
		System.out.println("--------------------");
		
		for(int i = 0 ; i < favouritePosts.size() ; i++)
		{
			System.out.println((i + 1) + ". POST");
			System.out.println(favouritePosts.get(i).getDetails());
		}
		
		System.out.println("---------------------------------\n");
	}
	
	public void controlBirthday()
	{
		Administrator admnstrtr = new Administrator();
		
		if(dateOfBirth.equals(admnstrtr.getDate()))
		{
			notificationBox.add("Happy Birthday " + name + ".");
		}
	}
}