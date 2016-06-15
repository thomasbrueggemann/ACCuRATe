package com.google.android.gms.internal;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.appindexing.AppIndexApi;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.class_18;
import com.google.android.gms.internal.class_246;
import com.google.android.gms.internal.class_385;
import com.google.android.gms.internal.class_388;
import com.google.android.gms.internal.class_398;
import com.google.android.gms.internal.class_400;
import com.google.android.gms.internal.class_402;
import com.google.android.gms.internal.fh;
import com.google.android.gms.internal.fl;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.CRC32;

// $FF: renamed from: com.google.android.gms.internal.fs
public class class_386 implements SafeParcelable {
   public static final class_385 CREATOR = new class_385();
   // $FF: renamed from: mN java.lang.String
   public final String field_1741;
   // $FF: renamed from: xJ int
   final int field_1742;
   // $FF: renamed from: yn com.google.android.gms.internal.fj
   final class_400 field_1743;
   // $FF: renamed from: yo long
   final long field_1744;
   // $FF: renamed from: yp int
   final int field_1745;
   // $FF: renamed from: yq com.google.android.gms.internal.fh
   final class_402 field_1746;

   class_386(int var1, class_400 var2, long var3, int var5, String var6, class_402 var7) {
      this.field_1742 = var1;
      this.field_1743 = var2;
      this.field_1744 = var3;
      this.field_1745 = var5;
      this.field_1741 = var6;
      this.field_1746 = var7;
   }

   public class_386(class_400 var1, long var2, int var4) {
      this(1, var1, var2, var4, (String)null, (class_402)null);
   }

   public class_386(String var1, Intent var2, String var3, Uri var4, String var5, List<AppIndexApi.AppIndexingLink> var6) {
      this(1, method_2458(var1, var2), System.currentTimeMillis(), 0, (String)null, method_2457(var2, var3, var4, var5, var6));
   }

   // $FF: renamed from: a (android.content.Intent, java.lang.String, android.net.Uri, java.lang.String, java.util.List) com.google.android.gms.internal.fh
   static fh method_2457(Intent var0, String var1, Uri var2, String var3, List<AppIndexApi.AppIndexingLink> var4) {
      ArrayList var5 = new ArrayList();
      var5.add(method_2460(var1));
      if(var2 != null) {
         var5.add(method_2461(var2));
      }

      if(var4 != null) {
         var5.add(method_2459(var4));
      }

      String var7 = var0.getAction();
      if(var7 != null) {
         var5.add(method_2462("intent_action", var7));
      }

      String var8 = var0.getDataString();
      if(var8 != null) {
         var5.add(method_2462("intent_data", var8));
      }

      ComponentName var9 = var0.getComponent();
      if(var9 != null) {
         var5.add(method_2462("intent_activity", var9.getClassName()));
      }

      Bundle var10 = var0.getExtras();
      if(var10 != null) {
         String var11 = var10.getString("intent_extra_data_key");
         if(var11 != null) {
            var5.add(method_2462("intent_extra_data", var11));
         }
      }

      return new class_402(var3, true, (class_398[])var5.toArray(new class_398[var5.size()]));
   }

   // $FF: renamed from: a (java.lang.String, android.content.Intent) com.google.android.gms.internal.fj
   public static class_400 method_2458(String var0, Intent var1) {
      return new class_400(var0, "", method_2463(var1));
   }

   // $FF: renamed from: a (java.util.List) com.google.android.gms.internal.fl
   private static fl method_2459(List<AppIndexApi.AppIndexingLink> var0) {
      class_18.class_1087 var1 = new class_18.class_1087();
      class_18.class_1088[] var2 = new class_18.class_1088[var0.size()];

      for(int var3 = 0; var3 < var2.length; ++var3) {
         var2[var3] = new class_18.class_1088();
         AppIndexApi.AppIndexingLink var4 = (AppIndexApi.AppIndexingLink)var0.get(var3);
         var2[var3].field_822 = var4.appIndexingUrl.toString();
         var2[var3].field_823 = var4.webUrl.toString();
         var2[var3].viewId = var4.viewId;
      }

      var1.field_820 = var2;
      return new class_398(class_246.method_1720(var1), (new class_388.class_1254("outlinks")).method_4471(true).method_4469(".private:outLinks").method_4468("blob").method_4470());
   }

   // $FF: renamed from: ab (java.lang.String) com.google.android.gms.internal.fl
   private static class_398 method_2460(String var0) {
      return new class_398(var0, (new class_388.class_1254("title")).method_4467(1).method_4472(true).method_4469("name").method_4470(), "text1");
   }

   // $FF: renamed from: e (android.net.Uri) com.google.android.gms.internal.fl
   private static class_398 method_2461(Uri var0) {
      return new class_398(var0.toString(), (new class_388.class_1254("web_url")).method_4467(4).method_4471(true).method_4469("url").method_4470());
   }

   // $FF: renamed from: f (java.lang.String, java.lang.String) com.google.android.gms.internal.fl
   private static class_398 method_2462(String var0, String var1) {
      return new class_398(var1, (new class_388.class_1254(var0)).method_4471(true).method_4470(), var0);
   }

   // $FF: renamed from: f (android.content.Intent) java.lang.String
   private static String method_2463(Intent var0) {
      String var1 = var0.toUri(1);
      CRC32 var2 = new CRC32();

      try {
         var2.update(var1.getBytes("UTF-8"));
      } catch (UnsupportedEncodingException var4) {
         throw new IllegalStateException(var4);
      }

      return Long.toHexString(var2.getValue());
   }

   public int describeContents() {
      class_385 var10000 = CREATOR;
      return 0;
   }

   public String toString() {
      Object[] var1 = new Object[]{this.field_1743, Long.valueOf(this.field_1744), Integer.valueOf(this.field_1745)};
      return String.format("UsageInfo[documentId=%s, timestamp=%d, usageType=%d]", var1);
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_385 var10000 = CREATOR;
      class_385.method_2454(this, var1, var2);
   }
}
