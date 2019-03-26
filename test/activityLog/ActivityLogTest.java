package activityLog;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ActivityLogTest {

  @Test
  void shouldReturnStringOfGivenText() {
    ActivityLog activityLog = new ActivityLog();
    List<Object> expected = new ArrayList<>();
    expected.add("First Log");
    assertEquals(expected,activityLog.addLog("First Log"));
  }

  @Test
  void shouldReturnStringWithTime() {
    ActivityLog activityLog = new ActivityLog();
    ActivityLogWithSeconds logger = new ActivityLogWithSeconds(activityLog);
    List<Object> expected = new ArrayList<>();
    expected.add("9123 First Log");
    assertEquals(expected,logger.addLog("First Log"));
  }
}