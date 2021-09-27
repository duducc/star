package util;

import java.sql.Timestamp;

public final class TimeUtil
{
  public static Timestamp getCurSQLTimestamp()
  {
    java.util.Date date = new java.util.Date();
    Timestamp timestamp = new Timestamp(date.getTime());
    return timestamp;
  }

  public static java.sql.Date getCurSQLDate()
  {
    java.util.Date date = new java.util.Date();
    return new java.sql.Date(date.getTime());
  }
}