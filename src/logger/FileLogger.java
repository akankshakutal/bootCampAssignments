package logger;

public class FileLogger implements Loggable{

  @Override
  public String log(String text) {
    return "Logging in File "+text;
  }
}
