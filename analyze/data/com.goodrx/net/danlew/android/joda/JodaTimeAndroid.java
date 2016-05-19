package net.danlew.android.joda;

import android.content.Context;
import android.content.IntentFilter;
import java.io.IOException;
import net.danlew.android.joda.ResourceZoneInfoProvider;
import net.danlew.android.joda.TimeZoneChangedReceiver;
import org.joda.time.DateTimeZone;

public final class JodaTimeAndroid {
   private static boolean sInitCalled = false;

   private JodaTimeAndroid() {
      throw new AssertionError();
   }

   public static void init(Context var0) {
      if(!sInitCalled) {
         sInitCalled = true;

         try {
            DateTimeZone.setProvider(new ResourceZoneInfoProvider(var0));
         } catch (IOException var2) {
            throw new RuntimeException("Could not read ZoneInfoMap");
         }

         var0.getApplicationContext().registerReceiver(new TimeZoneChangedReceiver(), new IntentFilter("android.intent.action.TIMEZONE_CHANGED"));
      }
   }
}
