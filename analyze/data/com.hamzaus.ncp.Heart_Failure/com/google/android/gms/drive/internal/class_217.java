package com.google.android.gms.drive.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.drive.events.DriveEvent;
import com.google.android.gms.drive.internal.OnEventResponse;
import com.google.android.gms.drive.internal.class_152;
import com.google.android.gms.internal.class_347;

// $FF: renamed from: com.google.android.gms.drive.internal.x
public class class_217<C extends DriveEvent> extends class_152.class_854 {
   // $FF: renamed from: In int
   private final int field_706;
   // $FF: renamed from: Jk com.google.android.gms.drive.events.DriveEvent$Listener
   private final DriveEvent.Listener<C> field_707;
   // $FF: renamed from: Jl com.google.android.gms.drive.internal.x$a
   private final class_217.class_1232<C> field_708;

   public class_217(Looper var1, int var2, DriveEvent.Listener<C> var3) {
      this.field_706 = var2;
      this.field_707 = var3;
      this.field_708 = new class_217.class_1232(var1);
   }

   // $FF: renamed from: a (com.google.android.gms.drive.internal.OnEventResponse) void
   public void method_824(OnEventResponse var1) throws RemoteException {
      boolean var2;
      if(this.field_706 == var1.getEventType()) {
         var2 = true;
      } else {
         var2 = false;
      }

      class_347.method_2159(var2);
      switch(var1.getEventType()) {
      case 1:
         this.field_708.method_4264(this.field_707, var1.method_2988());
         return;
      case 2:
         this.field_708.method_4264(this.field_707, var1.method_2989());
         return;
      default:
         Log.w("EventCallback", "Unexpected event type:" + var1.getEventType());
      }
   }

   private static class class_1232<E extends DriveEvent> extends Handler {
      private class_1232(Looper var1) {
         super(var1);
      }

      // $FF: synthetic method
      class_1232(Looper var1, Object var2) {
         this(var1);
      }

      // $FF: renamed from: a (com.google.android.gms.drive.events.DriveEvent$Listener, com.google.android.gms.drive.events.DriveEvent) void
      public void method_4264(DriveEvent.Listener<E> var1, E var2) {
         this.sendMessage(this.obtainMessage(1, new Pair(var1, var2)));
      }

      public void handleMessage(Message var1) {
         switch(var1.what) {
         case 1:
            Pair var2 = (Pair)var1.obj;
            ((DriveEvent.Listener)var2.first).onEvent((DriveEvent)var2.second);
            return;
         default:
            Log.wtf("EventCallback", "Don\'t know how to handle this event");
         }
      }
   }
}
