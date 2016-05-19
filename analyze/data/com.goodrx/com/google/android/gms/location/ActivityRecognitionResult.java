package com.google.android.gms.location;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.location.ActivityRecognitionResultCreator;
import com.google.android.gms.location.DetectedActivity;
import java.util.Iterator;
import java.util.List;

public class ActivityRecognitionResult implements SafeParcelable {
   public static final ActivityRecognitionResultCreator CREATOR = new ActivityRecognitionResultCreator();
   Bundle extras;
   private final int mVersionCode;
   List<DetectedActivity> zzaNu;
   long zzaNv;
   long zzaNw;
   int zzaNx;

   public ActivityRecognitionResult(int var1, List<DetectedActivity> var2, long var3, long var5, int var7, Bundle var8) {
      this.mVersionCode = var1;
      this.zzaNu = var2;
      this.zzaNv = var3;
      this.zzaNw = var5;
      this.zzaNx = var7;
      this.extras = var8;
   }

   private static boolean zzc(Bundle var0, Bundle var1) {
      if(var0 == null && var1 == null) {
         return true;
      } else if(var0 == null && var1 != null || var0 != null && var1 == null) {
         return false;
      } else if(var0.size() != var1.size()) {
         return false;
      } else {
         Iterator var2 = var0.keySet().iterator();

         while(var2.hasNext()) {
            String var3 = (String)var2.next();
            if(!var1.containsKey(var3)) {
               return false;
            }

            if(var0.get(var3) == null) {
               if(var1.get(var3) != null) {
                  return false;
               }
            } else if(var0.get(var3) instanceof Bundle) {
               if(!zzc(var0.getBundle(var3), var1.getBundle(var3))) {
                  return false;
               }
            } else if(!var0.get(var3).equals(var1.get(var3))) {
               return false;
            }
         }

         return true;
      }
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      if(this != var1) {
         if(var1 != null && this.getClass() == var1.getClass()) {
            ActivityRecognitionResult var2 = (ActivityRecognitionResult)var1;
            if(this.zzaNv == var2.zzaNv && this.zzaNw == var2.zzaNw && this.zzaNx == var2.zzaNx && zzw.equal(this.zzaNu, var2.zzaNu) && zzc(this.extras, var2.extras)) {
               return true;
            } else {
               return false;
            }
         } else {
            return false;
         }
      } else {
         return true;
      }
   }

   public int getVersionCode() {
      return this.mVersionCode;
   }

   public int hashCode() {
      Object[] var1 = new Object[]{Long.valueOf(this.zzaNv), Long.valueOf(this.zzaNw), Integer.valueOf(this.zzaNx), this.zzaNu, this.extras};
      return zzw.hashCode(var1);
   }

   public String toString() {
      return "ActivityRecognitionResult [probableActivities=" + this.zzaNu + ", timeMillis=" + this.zzaNv + ", elapsedRealtimeMillis=" + this.zzaNw + "]";
   }

   public void writeToParcel(Parcel var1, int var2) {
      ActivityRecognitionResultCreator.zza(this, var1, var2);
   }
}
