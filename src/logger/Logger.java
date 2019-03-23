package logger;

import java.util.List;

public class Logger {

  private List<Loggable> loggers;

  protected Logger(List<Loggable> loggers) {
    this.loggers = loggers;
  }

  void log(String  text){
    for (Loggable logger: loggers) {
      System.out.println(logger.log(text));
    }
  }

}
