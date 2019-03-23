package logger;

import java.util.ArrayList;

public class Main {
  public static void main(String[] args) {
    FileLogger fileLogger = new FileLogger();
    ConsoleLogger consoleLogger = new ConsoleLogger();
    ArrayList<Loggable> loggers = new ArrayList<>();
    loggers.add(fileLogger);
    loggers.add(consoleLogger);
    Logger loggerSystem = new Logger(loggers);
    loggerSystem.log("Hiii");
  }
}
