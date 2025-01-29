import java.time.ZonedDateTime;
import java.time.ZoneId;

public class TimeZone {
    public static void main(String[] args) {
      ZonedDateTime gmtTime = ZonedDateTime.now(ZoneId.of("GMT"));
      ZonedDateTime istTime =ZonedDateTime.now(ZoneId.of("Asia/Kolkata"));
      ZonedDateTime pstTime= ZonedDateTime.now(ZoneId.of("America/Los_Angeles"));
        
      System.out.println("Current time in GMT: " + gmtTime);
      System.out.println("Current time in IST: " + istTime);
      System.out.println("Current time in PST: " + pstTime);
    }
}
