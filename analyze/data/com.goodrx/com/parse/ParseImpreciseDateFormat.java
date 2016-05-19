package com.parse;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.SimpleTimeZone;

class ParseImpreciseDateFormat {
   private static final ParseImpreciseDateFormat INSTANCE = new ParseImpreciseDateFormat();
   private static final String TAG = "ParseDateFormat";
   private final DateFormat dateFormat;
   private final Object lock = new Object();

   private ParseImpreciseDateFormat() {
      SimpleDateFormat var1 = new SimpleDateFormat("yyyy-MM-dd\'T\'HH:mm:ss\'Z\'", Locale.US);
      var1.setTimeZone(new SimpleTimeZone(0, "GMT"));
      this.dateFormat = var1;
   }

   public static ParseImpreciseDateFormat getInstance() {
      return INSTANCE;
   }

   String format(Date param1) {
      // $FF: Couldn't be decompiled
   }

   Date parse(String param1) {
      // $FF: Couldn't be decompiled
   }
}
