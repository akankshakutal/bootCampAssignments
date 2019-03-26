package activityLog;

import java.util.List;

public class ActivityLogWithMilliseconds  implements Logger{
  private Logger logger;

  public ActivityLogWithMilliseconds(Logger logger) {
    this.logger = logger;
  }

  public List<String> addLog(String message){
    return logger.addLog(message);
  }
}

