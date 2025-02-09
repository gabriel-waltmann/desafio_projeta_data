package utils;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class CurrencyUtil {
  public String format(BigDecimal value) {
    DecimalFormat df = new DecimalFormat("#,##0.00");

    // replace . by ,
    DecimalFormatSymbols symbols = new DecimalFormatSymbols(new Locale("pt", "BR"));
    df.setDecimalFormatSymbols(symbols);

    // set thousands separator: .
    df.setGroupingUsed(true);

    return df.format(value);
  }
}
