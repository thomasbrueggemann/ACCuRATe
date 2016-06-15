package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.cast.class_752;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.class_332;
import com.google.android.gms.internal.class_349;
import java.util.Locale;

public class LaunchOptions implements SafeParcelable {
   public static final Creator<LaunchOptions> CREATOR = new class_752();
   // $FF: renamed from: An boolean
   private boolean field_4274;
   // $FF: renamed from: Ao java.lang.String
   private String field_4275;
   // $FF: renamed from: xJ int
   private final int field_4276;

   public LaunchOptions() {
      this(1, false, class_332.method_2121(Locale.getDefault()));
   }

   LaunchOptions(int var1, boolean var2, String var3) {
      this.field_4276 = var1;
      this.field_4274 = var2;
      this.field_4275 = var3;
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      if(var1 != this) {
         if(!(var1 instanceof LaunchOptions)) {
            return false;
         }

         LaunchOptions var2 = (LaunchOptions)var1;
         if(this.field_4274 != var2.field_4274 || !class_332.method_2117(this.field_4275, var2.field_4275)) {
            return false;
         }
      }

      return true;
   }

   public String getLanguage() {
      return this.field_4275;
   }

   public boolean getRelaunchIfRunning() {
      return this.field_4274;
   }

   int getVersionCode() {
      return this.field_4276;
   }

   public int hashCode() {
      Object[] var1 = new Object[]{Boolean.valueOf(this.field_4274), this.field_4275};
      return class_349.hashCode(var1);
   }

   public void setLanguage(String var1) {
      this.field_4275 = var1;
   }

   public void setRelaunchIfRunning(boolean var1) {
      this.field_4274 = var1;
   }

   public String toString() {
      Object[] var1 = new Object[]{Boolean.valueOf(this.field_4274), this.field_4275};
      return String.format("LaunchOptions(relaunchIfRunning=%b, language=%s)", var1);
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_752.method_4305(this, var1, var2);
   }

   public static final class Builder {
      // $FF: renamed from: Ap com.google.android.gms.cast.LaunchOptions
      private LaunchOptions field_3564 = new LaunchOptions();

      public LaunchOptions build() {
         return this.field_3564;
      }

      public LaunchOptions.Builder setLocale(Locale var1) {
         this.field_3564.setLanguage(class_332.method_2121(var1));
         return this;
      }

      public LaunchOptions.Builder setRelaunchIfRunning(boolean var1) {
         this.field_3564.setRelaunchIfRunning(var1);
         return this;
      }
   }
}
