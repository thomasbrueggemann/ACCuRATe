package com.parse;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.SimpleTimeZone;

class ParseDateFormat {
   private static final ParseDateFormat INSTANCE = new ParseDateFormat();
   private static final String TAG = "ParseDateFormat";
   private final DateFormat dateFormat;
   private final Object lock = new Object();

   private ParseDateFormat() {
      SimpleDateFormat var1 = new SimpleDateFormat("yyyy-MM-dd\'T\'HH:mm:ss.SSS\'Z\'", Locale.US);
      var1.setTimeZone(new SimpleTimeZone(0, "GMT"));
      this.dateFormat = var1;
   }

   public static ParseDateFormat getInstance() {
      return INSTANCE;
   }

   String format(Date param1) {
      // $FF: Couldn't be decompiled
   }

   Date parse(String param1) {
      // $FF: Couldn't be decompiled
   }
}
