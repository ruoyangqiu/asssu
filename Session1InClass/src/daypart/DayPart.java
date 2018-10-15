package daypart;
import java.time.LocalTime;

enum DayParts { MORNING, AFTERNOON, EVENING, NIGHT }

public class DayPart {
	private DayParts dp;
	
	public DayPart(LocalTime lt) {
		int hour = lt.getHour();
		if (hour >= 5 && hour < 12) 
			dp = DayParts.MORNING;
		else if (hour >= 12 && hour < 17) 
			dp = DayParts.AFTERNOON;
		else if (hour > 17 && hour < 20)  
			dp =  DayParts.EVENING;
		else dp =  DayParts.NIGHT;
	}
	public DayPart() {
		this(LocalTime.now());
	}
	public String toString() {
		if (dp.equals(DayParts.MORNING)) return "morning";
		if (dp.equals(DayParts.AFTERNOON)) return "afternoon";
		if (dp.equals(DayParts.EVENING)) return "evening";
		if (dp.equals(DayParts.NIGHT)) return "night";
		return "UNKNOWN";
		}
	public DayParts getDayPart() {
		return dp;
	}
}
