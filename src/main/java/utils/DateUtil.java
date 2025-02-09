package utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateUtil {

  public String format(LocalDate date, String format) {
    DateTimeFormatter formatters = DateTimeFormatter.ofPattern(format);

    return date.format(formatters);
  }
}
