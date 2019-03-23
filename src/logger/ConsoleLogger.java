package logger;

public class ConsoleLogger implements Loggable {
  @Override
  public String log(String text) {
    return "Logging On Console "+text;
  }
}
