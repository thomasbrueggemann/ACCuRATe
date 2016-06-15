package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.wearable.DataApi;
import com.google.android.gms.wearable.DataEventBuffer;
import com.google.android.gms.wearable.MessageApi;
import com.google.android.gms.wearable.NodeApi;
import com.google.android.gms.wearable.internal.class_1000;
import com.google.android.gms.wearable.internal.class_187;
import com.google.android.gms.wearable.internal.class_985;

// $FF: renamed from: com.google.android.gms.wearable.internal.bb
public class class_558 extends class_187.class_1336 {
   private final IntentFilter[] axD;
   private DataApi.DataListener ayl;
   private MessageApi.MessageListener aym;
   private NodeApi.NodeListener ayn;

   private class_558(DataApi.DataListener var1, MessageApi.MessageListener var2, NodeApi.NodeListener var3, IntentFilter[] var4) {
      this.ayl = var1;
      this.aym = var2;
      this.ayn = var3;
      this.axD = var4;
   }

   // $FF: renamed from: a (com.google.android.gms.wearable.NodeApi$NodeListener) com.google.android.gms.wearable.internal.bb
   public static class_558 method_3414(NodeApi.NodeListener var0) {
      return new class_558((DataApi.DataListener)null, (MessageApi.MessageListener)null, var0, (IntentFilter[])null);
   }

   // $FF: renamed from: b (com.google.android.gms.wearable.DataApi$DataListener, android.content.IntentFilter[]) com.google.android.gms.wearable.internal.bb
   public static class_558 method_3415(DataApi.DataListener var0, IntentFilter[] var1) {
      return new class_558(var0, (MessageApi.MessageListener)null, (NodeApi.NodeListener)null, var1);
   }

   // $FF: renamed from: b (com.google.android.gms.wearable.MessageApi$MessageListener, android.content.IntentFilter[]) com.google.android.gms.wearable.internal.bb
   public static class_558 method_3416(MessageApi.MessageListener var0, IntentFilter[] var1) {
      return new class_558((DataApi.DataListener)null, var0, (NodeApi.NodeListener)null, var1);
   }

   // $FF: renamed from: a (com.google.android.gms.wearable.internal.ai) void
   public void method_976(class_1000 var1) {
      if(this.aym != null) {
         this.aym.onMessageReceived(var1);
      }

   }

   // $FF: renamed from: a (com.google.android.gms.wearable.internal.al) void
   public void method_977(class_985 var1) {
      if(this.ayn != null) {
         this.ayn.onPeerConnected(var1);
      }

   }

   // $FF: renamed from: aa (com.google.android.gms.common.data.DataHolder) void
   public void method_978(DataHolder var1) {
      if(this.ayl != null) {
         try {
            this.ayl.onDataChanged(new DataEventBuffer(var1));
         } finally {
            var1.close();
         }

      } else {
         var1.close();
      }
   }

   // $FF: renamed from: b (com.google.android.gms.wearable.internal.al) void
   public void method_979(class_985 var1) {
      if(this.ayn != null) {
         this.ayn.onPeerDisconnected(var1);
      }

   }

   public void clear() {
      this.ayl = null;
      this.aym = null;
      this.ayn = null;
   }

   // $FF: renamed from: rs () android.content.IntentFilter[]
   public IntentFilter[] method_3417() {
      return this.axD;
   }
}
