package com.google.android.gms.drive.events;

import android.app.IntentService;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;
import android.util.Log;
import com.google.android.gms.drive.events.ChangeEvent;
import com.google.android.gms.drive.events.DriveEvent;
import com.google.android.gms.drive.events.FileConflictEvent;
import com.google.android.gms.internal.class_347;
import java.util.concurrent.LinkedBlockingDeque;

public abstract class DriveEventService extends IntentService {
   // $FF: renamed from: Ie java.util.concurrent.LinkedBlockingDeque
   private static final LinkedBlockingDeque<DriveEvent> field_900 = new LinkedBlockingDeque();
   private final String mName;

   protected DriveEventService() {
      this("DriveEventService");
   }

   protected DriveEventService(String var1) {
      super(var1);
      this.mName = var1;
   }

   // $FF: renamed from: a (com.google.android.gms.drive.events.DriveEvent) void
   private void method_1813(DriveEvent var1) {
      try {
         switch(var1.getType()) {
         case 1:
            class_347.method_2162(var1 instanceof ChangeEvent, "Unexpected event type: %s", new Object[]{var1});
            this.onChangeEvent((ChangeEvent)var1);
            return;
         case 2:
            class_347.method_2162(var1 instanceof FileConflictEvent, "Unexpected event type: %s", new Object[]{var1});
            this.method_1815((FileConflictEvent)var1);
            return;
         default:
            Log.w(this.mName, "Unrecognized event: " + var1);
         }
      } catch (ClassCastException var5) {
         Log.wtf(this.mName, "Service does not implement listener for type:" + var1.getType(), var5);
      } catch (Exception var6) {
         Log.w(this.mName, "Error handling event: " + var1, var6);
      }
   }

   // $FF: renamed from: a (com.google.android.gms.drive.events.FileConflictEvent) void
   public void method_1815(FileConflictEvent var1) {
      Log.w("DriveEventService", "Unhandled FileConflictEvent: " + var1);
   }

   public IBinder onBind(Intent var1) {
      return new Binder() {
         protected boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) {
            Log.d("DriveEventService", "onTransact");
            DriveEvent var6 = (DriveEvent)var2.readParcelable(DriveEventService.this.getClassLoader());
            DriveEventService.field_900.add(var6);
            DriveEventService.this.startService(new Intent(DriveEventService.this, DriveEventService.this.getClass()));
            return true;
         }
      };
   }

   public void onChangeEvent(ChangeEvent var1) {
      Log.w("DriveEventService", "Unhandled ChangeEvent: " + var1);
   }

   protected final void onHandleIntent(Intent var1) {
      var1.setExtrasClassLoader(this.getClassLoader());
      DriveEvent var2 = (DriveEvent)var1.getParcelableExtra("event");
      if(var2 == null) {
         var2 = (DriveEvent)field_900.poll();
      }

      if(var2 != null) {
         this.method_1813(var2);
      } else {
         Log.e("DriveEventService", "The event queue is unexpectedly empty.");
      }
   }
}
