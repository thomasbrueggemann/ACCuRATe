package org.joda.time;

import java.util.Locale;
import org.joda.time.DateTime;
import org.joda.time.MutableDateTime;
import org.joda.time.ReadableInstant;

public interface ReadableDateTime extends ReadableInstant {
   int getCenturyOfEra();

   int getDayOfMonth();

   int getDayOfWeek();

   int getDayOfYear();

   int getEra();

   int getHourOfDay();

   int getMillisOfDay();

   int getMillisOfSecond();

   int getMinuteOfDay();

   int getMinuteOfHour();

   int getMonthOfYear();

   int getSecondOfDay();

   int getSecondOfMinute();

   int getWeekOfWeekyear();

   int getWeekyear();

   int getYear();

   int getYearOfCentury();

   int getYearOfEra();

   DateTime toDateTime();

   MutableDateTime toMutableDateTime();

   String toString(String var1) throws IllegalArgumentException;

   String toString(String var1, Locale var2) throws IllegalArgumentException;
}
