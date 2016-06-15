package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.appcontent.AppContentAction;
import com.google.android.gms.games.appcontent.AppContentActionRef;
import com.google.android.gms.games.appcontent.AppContentAnnotation;
import com.google.android.gms.games.appcontent.AppContentAnnotationRef;
import com.google.android.gms.games.appcontent.AppContentCondition;
import com.google.android.gms.games.appcontent.AppContentConditionRef;
import com.google.android.gms.games.appcontent.AppContentTupleRef;
import com.google.android.gms.internal.class_724;
import java.util.ArrayList;

public final class AppContentUtils {
   // $FF: renamed from: a (com.google.android.gms.common.data.DataHolder, java.util.ArrayList, java.lang.String, int) java.util.ArrayList
   public static ArrayList<AppContentAction> method_1643(DataHolder var0, ArrayList<DataHolder> var1, String var2, int var3) {
      final ArrayList var4 = new ArrayList();
      method_1644(var0, 1, var2, "action_id", var3, new AppContentUtils.AppContentRunner() {
         // $FF: renamed from: b (java.util.ArrayList, int) void
         public void method_1060(ArrayList<DataHolder> var1, int var2) {
            var4.add(new AppContentActionRef(var1, var2));
         }
      }, var1);
      return var4;
   }

   // $FF: renamed from: a (com.google.android.gms.common.data.DataHolder, int, java.lang.String, java.lang.String, int, com.google.android.gms.games.appcontent.AppContentUtils$AppContentRunner, java.util.ArrayList) void
   private static void method_1644(DataHolder var0, int var1, String var2, String var3, int var4, AppContentUtils.AppContentRunner var5, ArrayList<DataHolder> var6) {
      DataHolder var7 = (DataHolder)var6.get(var1);
      String var8 = var0.method_5831(var2, var4, var0.method_5829(var4));
      if(!TextUtils.isEmpty(var8)) {
         int var9 = var7.getCount();
         String[] var10 = var8.split(",");

         for(int var11 = 0; var11 < var9; ++var11) {
            String var12 = var7.method_5831(var3, var11, var7.method_5829(var11));
            if(!TextUtils.isEmpty(var12) && class_724.method_4216(var10, var12)) {
               var5.method_1060(var6, var11);
            }
         }
      }

   }

   // $FF: renamed from: b (com.google.android.gms.common.data.DataHolder, java.util.ArrayList, java.lang.String, int) java.util.ArrayList
   public static ArrayList<AppContentAnnotation> method_1645(DataHolder var0, ArrayList<DataHolder> var1, String var2, int var3) {
      final ArrayList var4 = new ArrayList();
      method_1644(var0, 2, var2, "annotation_id", var3, new AppContentUtils.AppContentRunner() {
         // $FF: renamed from: b (java.util.ArrayList, int) void
         public void method_1060(ArrayList<DataHolder> var1, int var2) {
            var4.add(new AppContentAnnotationRef(var1, var2));
         }
      }, var1);
      return var4;
   }

   // $FF: renamed from: c (com.google.android.gms.common.data.DataHolder, java.util.ArrayList, java.lang.String, int) java.util.ArrayList
   public static ArrayList<AppContentCondition> method_1646(DataHolder var0, ArrayList<DataHolder> var1, String var2, int var3) {
      final ArrayList var4 = new ArrayList();
      method_1644(var0, 4, var2, "condition_id", var3, new AppContentUtils.AppContentRunner() {
         // $FF: renamed from: b (java.util.ArrayList, int) void
         public void method_1060(ArrayList<DataHolder> var1, int var2) {
            var4.add(new AppContentConditionRef(var1, var2));
         }
      }, var1);
      return var4;
   }

   // $FF: renamed from: d (com.google.android.gms.common.data.DataHolder, java.util.ArrayList, java.lang.String, int) android.os.Bundle
   public static Bundle method_1647(DataHolder var0, ArrayList<DataHolder> var1, String var2, int var3) {
      final Bundle var4 = new Bundle();
      method_1644(var0, 3, var2, "tuple_id", var3, new AppContentUtils.AppContentRunner() {
         // $FF: renamed from: Yc com.google.android.gms.common.data.DataHolder
         // $FF: synthetic field
         final DataHolder field_4230;

         {
            this.field_4230 = var1;
         }

         // $FF: renamed from: b (java.util.ArrayList, int) void
         public void method_1060(ArrayList<DataHolder> var1, int var2) {
            AppContentTupleRef var3 = new AppContentTupleRef(this.field_4230, var2);
            var4.putString(var3.getName(), var3.getValue());
         }
      }, var1);
      return var4;
   }

   private interface AppContentRunner {
      // $FF: renamed from: b (java.util.ArrayList, int) void
      void method_1060(ArrayList<DataHolder> var1, int var2);
   }
}
