import java.text.SimpleDateFormat;
import java.util.Date;

public class Administrator 
{
	private String time;
	private SimpleDateFormat dateFormatDate;
	private SimpleDateFormat dateFormatHoursAndDate;
	private Date now;
	
	public Administrator()
	{		
		dateFormatDate = new SimpleDateFormat("dd.MM.yyyy");
		dateFormatHoursAndDate = new SimpleDateFormat("HH:mm:ss dd.MM.yyyy");	
		now = new Date();
	}
	
	public String getDate()
	{
		time = dateFormatDate.format(now);
		
		return time;
	}	
	
	public String getHoursAndDate()
	{
		time = dateFormatHoursAndDate.format(now);
		
		return time;
	}
}