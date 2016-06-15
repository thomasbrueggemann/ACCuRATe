package com.google.android.gms.analytics;

import android.content.Context;
import android.content.res.XmlResourceParser;
import android.content.res.Resources.NotFoundException;
import com.google.android.gms.analytics.class_137;
import com.google.android.gms.analytics.class_669;
import com.google.android.gms.analytics.j;

// $FF: renamed from: com.google.android.gms.analytics.k
abstract class class_644<T extends j> {
   Context mContext;
   // $FF: renamed from: tJ com.google.android.gms.analytics.k$a
   class_644.class_1322<T> field_3391;

   public class_644(Context var1, class_644.class_1322<T> var2) {
      this.mContext = var1;
      this.field_3391 = var2;
   }

   // $FF: renamed from: a (android.content.res.XmlResourceParser) com.google.android.gms.analytics.j
   private T method_3695(XmlResourceParser param1) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: r (int) com.google.android.gms.analytics.j
   public T method_3696(int var1) {
      try {
         class_137 var3 = this.method_3695(this.mContext.getResources().getXml(var1));
         return var3;
      } catch (NotFoundException var4) {
         class_669.method_3891("inflate() called with unknown resourceId: " + var4);
         return null;
      }
   }

   public interface class_1322<U extends j> {
      // $FF: renamed from: a (java.lang.String, int) void
      void method_766(String var1, int var2);

      // $FF: renamed from: c (java.lang.String, java.lang.String) void
      void method_767(String var1, String var2);

      // $FF: renamed from: c (java.lang.String, boolean) void
      void method_768(String var1, boolean var2);

      // $FF: renamed from: cw () com.google.android.gms.analytics.j
      U method_769();

      // $FF: renamed from: d (java.lang.String, java.lang.String) void
      void method_770(String var1, String var2);
   }
}
