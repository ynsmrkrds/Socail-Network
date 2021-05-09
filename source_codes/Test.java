import java.util.Scanner;
import java.util.ArrayList;

public class Test 
{
	public static void main(String[] args) 
	{
		User mainUser = new User("Yunus Emre KARADAŞ" , "ynsmrkrds@gmail.com" , "12.02.2019" , "Erzurum" );
		
		User person1 = new User("Semih DÖNMEZ" , "smh.dnmz@gmail.com" , "18.05.2019" , "Bursa" );
		User person2 = new User("Burak Abdulbaki ULU" , "brkulu@gmail.com" , "02.05.1996" , "Aksaray" );
		User person3 = new User("Burak ÇAKIROĞLU" , "brkcgrgl@gmail.com" , "10.05.1999" , "Aydın" );
		User person4 = new User("Enes TÜRKMEN" , "enstrkmn@gmail.com" , "05.07.1998" , "Kırşehir" );
		User person5 = new User("Muhammed DİVARCI" , "mhmddvrc@gmail.com" , "07.08.1998" , "Konya" );
		User person6 = new User("Mustafa DİZOĞLU" , "mstfdzgl@gmail.com" , "02.05.1998" , "Adana" );
		User person7 = new User("Serhat BOZKURT" , "srhtbzkrt@gmail.com" , "05.07.1999" , "Muş" );
		
		Scanner scanInt = new Scanner(System.in);
		Scanner scanString = new Scanner(System.in);
		
		int choiceInt;
		String choiceString;
		int choiceMenu;
		
		ArrayList<User> users =new ArrayList<User>();
		
		users.add(mainUser);
		users.add(person1);
		users.add(person2);
		users.add(person3);
		users.add(person4);
		users.add(person5);
		users.add(person6);
		users.add(person7);
		
		person1.followUser(mainUser);
		person2.followUser(mainUser);
		person1.followUser(person2);
		person2.followUser(person1);
		mainUser.followUser(person1);
		mainUser.followUser(person2);
		person1.sharePost("Hello World !!!");
		person2.sharePost("This is my world.");
		person1.sendMessage(mainUser, "Hello my friend.");
		person2.sendMessage(mainUser, "How are you?");
		mainUser.sendMessage(person1, "Hello.");
		mainUser.sendMessage(person2, "I am fine and you?");

		for(int i=0 ; i < users.size() ; i++)
		{
			users.get(i).controlBirthday();
		}
		
		do
		{
			System.out.println("Welcome " + mainUser.getName() + " , please choose a operation which you want;");
			
			System.out.println(
					  "1. Show Inbox\n"
					+ "2. Show Outbox\n" 
					+ "3. Send Message\n"
					+ "4. Share Post\n" 
					+ "5. Show timeline\n"
					+ "6. Show contact list\n"
					+ "7. Show Notifications\n"
					+ "8. Follow People\n"
					+ "9. Show My Post List\n"
					+ "   Your Choise : ");
			
			choiceMenu = scanInt.nextInt();
			
			switch(choiceMenu)
			{
				case 1:
					mainUser.showIncomingMessageBox();
					break;
				case 2:
					mainUser.showOutgoingMessageBox();
					break;
				case 3:
					System.out.println("Choose the person whom you want to send message;\n");
					mainUser.showFollowedUserList();
					System.out.print("Your Choice: ");
					choiceInt = scanInt.nextInt();					
					System.out.println("----------\n");	
					System.out.println("Enter the message you want to send;");
					System.out.print("       Your Message: ");
					choiceString = scanString.nextLine();			
					mainUser.sendMessage(mainUser.searchUserList(choiceInt), choiceString);				
					break;	
				case 4:
					System.out.println("Enter the post you want to share;\n");
					System.out.print("Post : ");
					choiceString = scanString.nextLine();
					mainUser.sharePost(choiceString);	
					break;	
				case 5:
					mainUser.showTimeLine();
					System.out.print("Choose the post you want to like : ");
					choiceInt = scanInt.nextInt();
					mainUser.likePost(choiceInt);			
					break;
				case 6:
					mainUser.showFollowedUserList();
					break;		
				case 7:
					mainUser.showNotificationBox();
					break;
				case 8:		
					System.out.println("Choose the person you want to follow ;\n");
					
					for(int i = 0 ; i < users.size() ; i++)
					{
						System.out.println((i+1) + "- " + users.get(i).getInformationOfUser());
						System.out.print("\n");
					}
					
					System.out.print("Your Choice : ");
					choiceInt = scanInt.nextInt();
					
					if(choiceInt > users.size() || choiceInt < 1)
					{
						System.out.println("WRONG CHOICE !!!");
					}
					else
					{
						mainUser.followUser(users.get(choiceInt - 1));
					}
					break;
				case 9 : 
					System.out.println("1. My Posts\n"
								     + "2.Favorite Posts\n");
					choiceInt = scanInt.nextInt();
					switch(choiceInt)
					{
						case 1:
							mainUser.showPosts();
							break;
						case 2:
							mainUser.showFavouritePosts();
							break;
						default:
							System.out.println("Invalid operation.");
							break;
					}							
					break;
				case 0 : 
					System.out.println("GOOD BYE " + mainUser.getName());
					break;
				default :
					System.out.println("Invalid operation.");
					break;
			}
		}
		while(choiceMenu != 0);		
	}
}