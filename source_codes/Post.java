public class Post 
{
    private String userName; 
    private String post;   
    private String timeStamp;
    private int likes;
    private Administrator admnstr;

    public Post(String userName , String post)
    {  
    	admnstr = new Administrator();
        
    	this.userName = userName;
    	this.post = post;   	
    	this.timeStamp = admnstr.getHoursAndDate();
    	this.likes = 0;
    }   
    
    public String getDetails()
    {		
    	return  "-------------------------------------------\n" +
        		"USER NAME : " + userName + "\n" + "POST : " + post + "\n" + "TIME STAMP : " +  timeStamp + 
        		"\n" + "LIKES : " + likes + "\n-------------------------------------------";
    }
    
    public void setLikes()
    {
    	likes++;
    }
    
    public int getLike()
    {
    	return likes;
    }
}