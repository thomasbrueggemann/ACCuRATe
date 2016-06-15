package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.wearable.DataApi;
import com.google.android.gms.wearable.DataEventBuffer;
import com.google.android.gms.wearable.MessageApi;
import com.google.android.gms.wearable.NodeApi;
import com.google.android.gms.wearable.internal.class_150;
import com.google.android.gms.wearable.internal.class_770;
import com.google.android.gms.wearable.internal.class_773;

// $FF: renamed from: com.google.android.gms.wearable.internal.av
public class class_568 extends class_150.class_1306 {
   private final DataApi.DataListener ami;
   private final MessageApi.MessageListener amj;
   private final NodeApi.NodeListener amk;
   private final IntentFilter[] aml;

   public class_568(DataApi.DataListener var1, MessageApi.MessageListener var2, NodeApi.NodeListener var3, IntentFilter[] var4) {
      this.ami = var1;
      this.amj = var2;
      this.amk = var3;
      this.aml = var4;
   }

   // $FF: renamed from: a (com.google.android.gms.wearable.DataApi$DataListener, android.content.IntentFilter[]) com.google.android.gms.wearable.internal.av
   public static class_568 method_3169(DataApi.DataListener var0, IntentFilter[] var1) {
      return new class_568(var0, (MessageApi.MessageListener)null, (NodeApi.NodeListener)null, var1);
   }

   // $FF: renamed from: a (com.google.android.gms.wearable.MessageApi$MessageListener, android.content.IntentFilter[]) com.google.android.gms.wearable.internal.av
   public static class_568 method_3170(MessageApi.MessageListener var0, IntentFilter[] var1) {
      return new class_568((DataApi.DataListener)null, var0, (NodeApi.NodeListener)null, var1);
   }

   // $FF: renamed from: a (com.google.android.gms.wearable.NodeApi$NodeListener) com.google.android.gms.wearable.internal.av
   public static class_568 method_3171(NodeApi.NodeListener var0) {
      return new class_568((DataApi.DataListener)null, (MessageApi.MessageListener)null, var0, (IntentFilter[])null);
   }

   // $FF: renamed from: Y (com.google.android.gms.common.data.DataHolder) void
   public void method_799(DataHolder var1) {
      if(this.ami != null) {
         try {
            this.ami.onDataChanged(new DataEventBuffer(var1));
         } finally {
            var1.close();
         }

      } else {
         var1.close();
      }
   }

   // $FF: renamed from: a (com.google.android.gms.wearable.internal.af) void
   public void method_800(class_773 var1) {
      if(this.amj != null) {
         this.amj.onMessageReceived(var1);
      }

   }

   // $FF: renamed from: a (com.google.android.gms.wearable.internal.ai) void
   public void method_801(class_770 var1) {
      if(this.amk != null) {
         this.amk.onPeerConnected(var1);
      }

   }

   // $FF: renamed from: b (com.google.android.gms.wearable.internal.ai) void
   public void method_802(class_770 var1) {
      if(this.amk != null) {
         this.amk.onPeerDisconnected(var1);
      }

   }

   // $FF: renamed from: np () android.content.IntentFilter[]
   public IntentFilter[] method_3172() {
      return this.aml;
   }
}
