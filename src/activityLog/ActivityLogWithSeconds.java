package activityLog;

import java.util.Date;
import java.util.List;

public class ActivityLogWithSeconds implements Logger{
  private Logger logger;

  public ActivityLogWithSeconds(Logger logger) {
    this.logger = logger;
  }

  public List<String> addLog(String message){
//    long timeStamp = new Date().getSeconds();
    long timeStamp = 9123;
    return logger.addLog(timeStamp+" "+message);
  }
}
