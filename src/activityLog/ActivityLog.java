package activityLog;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class ActivityLog implements Logger {

  private List<String> logs;

  ActivityLog() {
    this.logs = new ArrayList<>();
  }

  @Override
  public List<String> addLog(String message) {
    this.logs.add(message);
    return Collections.unmodifiableList(this.logs);
  }

}
