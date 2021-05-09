public class Message
{	
	private String senderUser;
	private User receiverUser;
	private String contentMessage;
	
	public Message(String senderUser , User receiverUser , String contentMessage)
	{
		this.senderUser = senderUser;
		this.receiverUser = receiverUser;
		this.contentMessage = contentMessage;
	}
	
	public String getDetails()
    {		
        return  "-------------------------------------------\n" +
        		"SENDER : " + senderUser + "\n" + "RECEIVER : " + receiverUser.getName() + "\n" + "CONTENT OF MESSAGE : " +  contentMessage
        		+ "\n-------------------------------------------";
    }
}