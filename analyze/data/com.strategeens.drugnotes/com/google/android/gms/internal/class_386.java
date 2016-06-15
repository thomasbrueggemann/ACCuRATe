package com.google.android.gms.internal;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.appindexing.AppIndexApi;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.class_150;
import com.google.android.gms.internal.class_300;
import com.google.android.gms.internal.class_387;
import com.google.android.gms.internal.class_388;
import com.google.android.gms.internal.class_394;
import com.google.android.gms.internal.class_402;
import com.google.android.gms.internal.class_404;
import com.google.android.gms.internal.hh;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.zip.CRC32;

// $FF: renamed from: com.google.android.gms.internal.hr
public class class_386 implements SafeParcelable {
   public static final class_387 CREATOR = new class_387();
   // $FF: renamed from: CK int
   final int field_1204;
   // $FF: renamed from: Dw com.google.android.gms.internal.hf
   final class_402 field_1205;
   // $FF: renamed from: Dx long
   final long field_1206;
   // $FF: renamed from: Dy int
   final int field_1207;
   // $FF: renamed from: Dz com.google.android.gms.internal.hd
   final class_404 field_1208;
   // $FF: renamed from: pc java.lang.String
   public final String field_1209;

   class_386(int var1, class_402 var2, long var3, int var5, String var6, class_404 var7) {
      this.field_1204 = var1;
      this.field_1205 = var2;
      this.field_1206 = var3;
      this.field_1207 = var5;
      this.field_1209 = var6;
      this.field_1208 = var7;
   }

   public class_386(class_402 var1, long var2, int var4) {
      this(1, var1, var2, var4, (String)null, (class_404)null);
   }

   public class_386(class_402 var1, long var2, int var4, String var5, class_404 var6) {
      this(1, var1, var2, var4, var5, var6);
   }

   public class_386(String var1, Intent var2, String var3, Uri var4, String var5, List<AppIndexApi.AppIndexingLink> var6) {
      this(1, method_2657(var1, var2), System.currentTimeMillis(), 0, (String)null, method_2656(var2, var3, var4, var5, var6).method_5427());
   }

   // $FF: renamed from: a (android.content.Intent, java.lang.String, android.net.Uri, java.lang.String, java.util.List) com.google.android.gms.internal.hd$a
   public static class_404.class_1530 method_2656(Intent var0, String var1, Uri var2, String var3, List<AppIndexApi.AppIndexingLink> var4) {
      class_404.class_1530 var5 = new class_404.class_1530();
      var5.method_5425(method_2658(var1));
      if(var2 != null) {
         var5.method_5425(method_2660(var2));
      }

      if(var4 != null) {
         var5.method_5425(method_2659(var4));
      }

      String var7 = var0.getAction();
      if(var7 != null) {
         var5.method_5425(method_2663("intent_action", var7));
      }

      String var8 = var0.getDataString();
      if(var8 != null) {
         var5.method_5425(method_2663("intent_data", var8));
      }

      ComponentName var9 = var0.getComponent();
      if(var9 != null) {
         var5.method_5425(method_2663("intent_activity", var9.getClassName()));
      }

      Bundle var10 = var0.getExtras();
      if(var10 != null) {
         String var11 = var10.getString("intent_extra_data_key");
         if(var11 != null) {
            var5.method_5425(method_2663("intent_extra_data", var11));
         }
      }

      return var5.method_5426(var3).method_5424(true);
   }

   // $FF: renamed from: a (java.lang.String, android.content.Intent) com.google.android.gms.internal.hf
   public static class_402 method_2657(String var0, Intent var1) {
      return method_2662(var0, method_2661(var1));
   }

   // $FF: renamed from: av (java.lang.String) com.google.android.gms.internal.hh
   private static class_394 method_2658(String var0) {
      return new class_394(var0, (new class_388.class_1553("title")).method_4112(1).method_4111(true).method_4114("name").method_4115(), "text1");
   }

   // $FF: renamed from: b (java.util.List) com.google.android.gms.internal.hh
   private static hh method_2659(List<AppIndexApi.AppIndexingLink> var0) {
      class_150.class_1434 var1 = new class_150.class_1434();
      class_150.class_1435[] var2 = new class_150.class_1435[var0.size()];

      for(int var3 = 0; var3 < var2.length; ++var3) {
         var2[var3] = new class_150.class_1435();
         AppIndexApi.AppIndexingLink var4 = (AppIndexApi.AppIndexingLink)var0.get(var3);
         var2[var3].afw = var4.appIndexingUrl.toString();
         var2[var3].viewId = var4.viewId;
         if(var4.webUrl != null) {
            var2[var3].afx = var4.webUrl.toString();
         }
      }

      var1.afu = var2;
      return new class_394(class_300.method_2088(var1), (new class_388.class_1553("outlinks")).method_4110(true).method_4114(".private:outLinks").method_4113("blob").method_4115());
   }

   // $FF: renamed from: f (android.net.Uri) com.google.android.gms.internal.hh
   private static class_394 method_2660(Uri var0) {
      return new class_394(var0.toString(), (new class_388.class_1553("web_url")).method_4112(4).method_4110(true).method_4114("url").method_4115());
   }

   // $FF: renamed from: g (android.content.Intent) java.lang.String
   private static String method_2661(Intent var0) {
      String var1 = var0.toUri(1);
      CRC32 var2 = new CRC32();

      try {
         var2.update(var1.getBytes("UTF-8"));
      } catch (UnsupportedEncodingException var4) {
         throw new IllegalStateException(var4);
      }

      return Long.toHexString(var2.getValue());
   }

   // $FF: renamed from: h (java.lang.String, java.lang.String) com.google.android.gms.internal.hf
   private static class_402 method_2662(String var0, String var1) {
      return new class_402(var0, "", var1);
   }

   // $FF: renamed from: i (java.lang.String, java.lang.String) com.google.android.gms.internal.hh
   private static class_394 method_2663(String var0, String var1) {
      return new class_394(var1, (new class_388.class_1553(var0)).method_4110(true).method_4115(), var0);
   }

   public int describeContents() {
      class_387 var10000 = CREATOR;
      return 0;
   }

   public String toString() {
      Object[] var1 = new Object[]{this.field_1205, Long.valueOf(this.field_1206), Integer.valueOf(this.field_1207)};
      return String.format("UsageInfo[documentId=%s, timestamp=%d, usageType=%d]", var1);
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_387 var10000 = CREATOR;
      class_387.method_2664(this, var1, var2);
   }
}
