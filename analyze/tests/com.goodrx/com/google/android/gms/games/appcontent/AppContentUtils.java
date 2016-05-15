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
import com.google.android.gms.internal.zzmn;
import java.util.ArrayList;

public final class AppContentUtils {
   public static ArrayList<AppContentAction> zza(DataHolder var0, ArrayList<DataHolder> var1, String var2, int var3) {
      final ArrayList var4 = new ArrayList();
      zza(var0, 1, var2, "action_id", var3, new AppContentUtils.AppContentRunner() {
         public void zzb(ArrayList<DataHolder> var1, int var2) {
            var4.add(new AppContentActionRef(var1, var2));
         }
      }, var1);
      return var4;
   }

   private static void zza(DataHolder var0, int var1, String var2, String var3, int var4, AppContentUtils.AppContentRunner var5, ArrayList<DataHolder> var6) {
      DataHolder var7 = (DataHolder)var6.get(var1);
      String var8 = var0.zzd(var2, var4, var0.zzbH(var4));
      if(!TextUtils.isEmpty(var8)) {
         int var9 = var7.getCount();
         String[] var10 = var8.split(",");

         for(int var11 = 0; var11 < var9; ++var11) {
            String var12 = var7.zzd(var3, var11, var7.zzbH(var11));
            if(!TextUtils.isEmpty(var12) && zzmn.zzb(var10, var12)) {
               var5.zzb(var6, var11);
            }
         }
      }

   }

   public static ArrayList<AppContentAnnotation> zzb(DataHolder var0, ArrayList<DataHolder> var1, String var2, int var3) {
      final ArrayList var4 = new ArrayList();
      zza(var0, 2, var2, "annotation_id", var3, new AppContentUtils.AppContentRunner() {
         public void zzb(ArrayList<DataHolder> var1, int var2) {
            var4.add(new AppContentAnnotationRef(var1, var2));
         }
      }, var1);
      return var4;
   }

   public static ArrayList<AppContentCondition> zzc(DataHolder var0, ArrayList<DataHolder> var1, String var2, int var3) {
      final ArrayList var4 = new ArrayList();
      zza(var0, 4, var2, "condition_id", var3, new AppContentUtils.AppContentRunner() {
         public void zzb(ArrayList<DataHolder> var1, int var2) {
            var4.add(new AppContentConditionRef(var1, var2));
         }
      }, var1);
      return var4;
   }

   public static Bundle zzd(DataHolder var0, ArrayList<DataHolder> var1, String var2, int var3) {
      final Bundle var4 = new Bundle();
      zza(var0, 3, var2, "tuple_id", var3, new AppContentUtils.AppContentRunner() {
         // $FF: synthetic field
         final DataHolder zzaDS;

         {
            this.zzaDS = var1;
         }

         public void zzb(ArrayList<DataHolder> var1, int var2) {
            AppContentTupleRef var3 = new AppContentTupleRef(this.zzaDS, var2);
            var4.putString(var3.getName(), var3.getValue());
         }
      }, var1);
      return var4;
   }

   private interface AppContentRunner {
      void zzb(ArrayList<DataHolder> var1, int var2);
   }
}
