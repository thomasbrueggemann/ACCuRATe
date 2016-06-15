package com.google.android.gms.fitness.data;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.class_703;
import com.google.android.gms.fitness.FitnessActivities;
import com.google.android.gms.fitness.data.class_1048;
import com.google.android.gms.fitness.data.class_1051;
import com.google.android.gms.internal.class_335;
import com.google.android.gms.internal.class_336;
import java.util.concurrent.TimeUnit;

public class Session implements SafeParcelable {
   public static final Creator<Session> CREATOR = new class_1048();
   public static final String EXTRA_SESSION = "vnd.google.fitness.session";
   public static final String MIME_TYPE_PREFIX = "vnd.google.fitness.session/";
   // $FF: renamed from: CK int
   private final int field_4364;
   // $FF: renamed from: LW long
   private final long field_4365;
   // $FF: renamed from: TO long
   private final long field_4366;
   // $FF: renamed from: TZ int
   private final int field_4367;
   // $FF: renamed from: UN java.lang.String
   private final String field_4368;
   // $FF: renamed from: UO java.lang.String
   private final String field_4369;
   // $FF: renamed from: Um com.google.android.gms.fitness.data.a
   private final class_1051 field_4370;
   private final String mName;

   Session(int var1, long var2, long var4, String var6, String var7, String var8, int var9, class_1051 var10) {
      this.field_4364 = var1;
      this.field_4365 = var2;
      this.field_4366 = var4;
      this.mName = var6;
      this.field_4368 = var7;
      this.field_4369 = var8;
      this.field_4367 = var9;
      this.field_4370 = var10;
   }

   private Session(Session.Builder var1) {
      this.field_4364 = 2;
      this.field_4365 = var1.field_4150;
      this.field_4366 = var1.field_4151;
      this.mName = var1.mName;
      this.field_4368 = var1.field_4153;
      this.field_4369 = var1.field_4154;
      this.field_4367 = var1.field_4152;
      this.field_4370 = var1.field_4155;
   }

   // $FF: synthetic method
   Session(Session.Builder var1, Object var2) {
      this(var1);
   }

   // $FF: renamed from: a (com.google.android.gms.fitness.data.Session) boolean
   private boolean method_5697(Session var1) {
      return this.field_4365 == var1.field_4365 && this.field_4366 == var1.field_4366 && class_336.equal(this.mName, var1.mName) && class_336.equal(this.field_4368, var1.field_4368) && class_336.equal(this.field_4369, var1.field_4369) && class_336.equal(this.field_4370, var1.field_4370) && this.field_4367 == var1.field_4367;
   }

   public static Session extract(Intent var0) {
      return var0 == null?null:(Session)class_703.method_4019(var0, "vnd.google.fitness.session", CREATOR);
   }

   public static String getMimeType(String var0) {
      return "vnd.google.fitness.session/" + var0;
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return var1 == this || var1 instanceof Session && this.method_5697((Session)var1);
   }

   public String getActivity() {
      return FitnessActivities.getName(this.field_4367);
   }

   public String getAppPackageName() {
      return this.field_4370 == null?null:this.field_4370.getPackageName();
   }

   public String getDescription() {
      return this.field_4369;
   }

   public long getEndTime(TimeUnit var1) {
      return var1.convert(this.field_4366, TimeUnit.MILLISECONDS);
   }

   public String getIdentifier() {
      return this.field_4368;
   }

   public String getName() {
      return this.mName;
   }

   public long getStartTime(TimeUnit var1) {
      return var1.convert(this.field_4365, TimeUnit.MILLISECONDS);
   }

   int getVersionCode() {
      return this.field_4364;
   }

   public int hashCode() {
      Object[] var1 = new Object[]{Long.valueOf(this.field_4365), Long.valueOf(this.field_4366), this.field_4368};
      return class_336.hashCode(var1);
   }

   public boolean isOngoing() {
      return this.field_4366 == 0L;
   }

   // $FF: renamed from: jm () int
   public int method_5698() {
      return this.field_4367;
   }

   // $FF: renamed from: jo () long
   public long method_5699() {
      return this.field_4365;
   }

   // $FF: renamed from: jp () long
   public long method_5700() {
      return this.field_4366;
   }

   // $FF: renamed from: jx () com.google.android.gms.fitness.data.a
   public class_1051 method_5701() {
      return this.field_4370;
   }

   public String toString() {
      return class_336.method_2312(this).method_3424("startTime", Long.valueOf(this.field_4365)).method_3424("endTime", Long.valueOf(this.field_4366)).method_3424("name", this.mName).method_3424("identifier", this.field_4368).method_3424("description", this.field_4369).method_3424("activity", Integer.valueOf(this.field_4367)).method_3424("application", this.field_4370).toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_1048.method_5752(this, var1, var2);
   }

   public static class Builder {
      // $FF: renamed from: LW long
      private long field_4150 = 0L;
      // $FF: renamed from: TO long
      private long field_4151 = 0L;
      // $FF: renamed from: TZ int
      private int field_4152 = 4;
      // $FF: renamed from: UN java.lang.String
      private String field_4153;
      // $FF: renamed from: UO java.lang.String
      private String field_4154;
      // $FF: renamed from: Um com.google.android.gms.fitness.data.a
      private class_1051 field_4155;
      private String mName = null;

      public Session build() {
         boolean var1;
         if(this.field_4150 > 0L) {
            var1 = true;
         } else {
            var1 = false;
         }

         boolean var2;
         label24: {
            class_335.method_2302(var1, "Start time should be specified.");
            if(this.field_4151 != 0L) {
               long var6;
               int var5 = (var6 = this.field_4151 - this.field_4150) == 0L?0:(var6 < 0L?-1:1);
               var2 = false;
               if(var5 <= 0) {
                  break label24;
               }
            }

            var2 = true;
         }

         class_335.method_2302(var2, "End time should be later than start time.");
         if(this.field_4153 == null) {
            StringBuilder var3 = new StringBuilder();
            String var4;
            if(this.mName == null) {
               var4 = "";
            } else {
               var4 = this.mName;
            }

            this.field_4153 = var3.append(var4).append(this.field_4150).toString();
         }

         return new Session(this);
      }

      // $FF: renamed from: cV (int) com.google.android.gms.fitness.data.Session$Builder
      public Session.Builder method_5408(int var1) {
         this.field_4152 = var1;
         return this;
      }

      public Session.Builder setActivity(String var1) {
         return this.method_5408(FitnessActivities.method_3193(var1));
      }

      public Session.Builder setDescription(String var1) {
         boolean var2;
         if(var1.length() <= 1000) {
            var2 = true;
         } else {
            var2 = false;
         }

         Object[] var3 = new Object[]{Integer.valueOf(1000)};
         class_335.method_2309(var2, "Session description cannot exceed %d characters", var3);
         this.field_4154 = var1;
         return this;
      }

      public Session.Builder setEndTime(long var1, TimeUnit var3) {
         boolean var4;
         if(var1 >= 0L) {
            var4 = true;
         } else {
            var4 = false;
         }

         class_335.method_2302(var4, "End time should be positive.");
         this.field_4151 = var3.toMillis(var1);
         return this;
      }

      public Session.Builder setIdentifier(String var1) {
         boolean var2;
         if(var1 != null && TextUtils.getTrimmedLength(var1) > 0) {
            var2 = true;
         } else {
            var2 = false;
         }

         class_335.method_2301(var2);
         this.field_4153 = var1;
         return this;
      }

      public Session.Builder setName(String var1) {
         boolean var2;
         if(var1.length() <= 100) {
            var2 = true;
         } else {
            var2 = false;
         }

         Object[] var3 = new Object[]{Integer.valueOf(100)};
         class_335.method_2309(var2, "Session name cannot exceed %d characters", var3);
         this.mName = var1;
         return this;
      }

      public Session.Builder setStartTime(long var1, TimeUnit var3) {
         boolean var4;
         if(var1 > 0L) {
            var4 = true;
         } else {
            var4 = false;
         }

         class_335.method_2302(var4, "Start time should be positive.");
         this.field_4150 = var3.toMillis(var1);
         return this;
      }
   }
}
