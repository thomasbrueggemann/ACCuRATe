package com.google.android.gms.drive.internal;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Pair;
import com.google.android.gms.drive.events.ChangeEvent;
import com.google.android.gms.drive.events.ChangeListener;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.drive.events.CompletionListener;
import com.google.android.gms.drive.events.DriveEvent;
import com.google.android.gms.drive.events.class_93;
import com.google.android.gms.drive.internal.OnEventResponse;
import com.google.android.gms.drive.internal.class_190;
import com.google.android.gms.drive.internal.class_265;
import com.google.android.gms.internal.class_335;
import java.util.ArrayList;
import java.util.List;

// $FF: renamed from: com.google.android.gms.drive.internal.aa
public class class_872 extends class_190.class_1244 {
   // $FF: renamed from: Pm int
   private final int field_3746;
   // $FF: renamed from: Qw com.google.android.gms.drive.events.c
   private final class_93 field_3747;
   // $FF: renamed from: Qx com.google.android.gms.drive.internal.aa$a
   private final class_872.class_1572 field_3748;
   // $FF: renamed from: Qy java.util.List
   private final List<Integer> field_3749 = new ArrayList();

   public class_872(Looper var1, Context var2, int var3, class_93 var4) {
      this.field_3746 = var3;
      this.field_3747 = var4;
      this.field_3748 = new class_872.class_1572(var1, var2);
   }

   // $FF: renamed from: bw (int) void
   public void method_4905(int var1) {
      this.field_3749.add(Integer.valueOf(var1));
   }

   // $FF: renamed from: bx (int) boolean
   public boolean method_4906(int var1) {
      return this.field_3749.contains(Integer.valueOf(var1));
   }

   // $FF: renamed from: c (com.google.android.gms.drive.internal.OnEventResponse) void
   public void method_1011(OnEventResponse var1) throws RemoteException {
      DriveEvent var2 = var1.method_3562();
      boolean var3;
      if(this.field_3746 == var2.getType()) {
         var3 = true;
      } else {
         var3 = false;
      }

      class_335.method_2300(var3);
      class_335.method_2300(this.field_3749.contains(Integer.valueOf(var2.getType())));
      this.field_3748.method_4138(this.field_3747, var2);
   }

   private static class class_1572 extends Handler {
      private final Context mContext;

      private class_1572(Looper var1, Context var2) {
         super(var1);
         this.mContext = var2;
      }

      // $FF: synthetic method
      class_1572(Looper var1, Context var2, Object var3) {
         this(var1, var2);
      }

      // $FF: renamed from: a (com.google.android.gms.drive.events.c, com.google.android.gms.drive.events.DriveEvent) void
      public void method_4138(class_93 var1, DriveEvent var2) {
         this.sendMessage(this.obtainMessage(1, new Pair(var1, var2)));
      }

      public void handleMessage(Message var1) {
         switch(var1.what) {
         case 1:
            Pair var2 = (Pair)var1.obj;
            class_93 var3 = (class_93)var2.first;
            DriveEvent var4 = (DriveEvent)var2.second;
            switch(var4.getType()) {
            case 1:
               ((ChangeListener)var3).onChange((ChangeEvent)var4);
               return;
            case 2:
               ((CompletionListener)var3).onCompletion((CompletionEvent)var4);
               return;
            default:
               class_265.method_1703("EventCallback", "Unexpected event: " + var4);
               return;
            }
         default:
            class_265.method_1701(this.mContext, "EventCallback", "Don\'t know how to handle this event");
         }
      }
   }
}
