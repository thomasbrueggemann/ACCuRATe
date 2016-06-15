package com.google.android.gms.analytics;

import android.content.Context;
import android.content.res.XmlResourceParser;
import android.content.res.Resources.NotFoundException;
import com.google.android.gms.analytics.class_171;
import com.google.android.gms.analytics.class_863;
import com.google.android.gms.analytics.m;

// $FF: renamed from: com.google.android.gms.analytics.n
abstract class class_840<T extends m> {
   Context mContext;
   // $FF: renamed from: yL com.google.android.gms.analytics.n$a
   class_840.class_1318<T> field_3496;

   public class_840(Context var1, class_840.class_1318<T> var2) {
      this.mContext = var1;
      this.field_3496 = var2;
   }

   // $FF: renamed from: a (android.content.res.XmlResourceParser) com.google.android.gms.analytics.m
   private T method_4647(XmlResourceParser param1) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: x (int) com.google.android.gms.analytics.m
   public T method_4648(int var1) {
      try {
         class_171 var3 = this.method_4647(this.mContext.getResources().getXml(var1));
         return var3;
      } catch (NotFoundException var4) {
         class_863.method_4842("inflate() called with unknown resourceId: " + var4);
         return null;
      }
   }

   public interface class_1318<U extends m> {
      // $FF: renamed from: c (java.lang.String, int) void
      void method_868(String var1, int var2);

      // $FF: renamed from: e (java.lang.String, java.lang.String) void
      void method_869(String var1, String var2);

      // $FF: renamed from: e (java.lang.String, boolean) void
      void method_870(String var1, boolean var2);

      // $FF: renamed from: er () com.google.android.gms.analytics.m
      U method_871();

      // $FF: renamed from: f (java.lang.String, java.lang.String) void
      void method_872(String var1, String var2);
   }
}
