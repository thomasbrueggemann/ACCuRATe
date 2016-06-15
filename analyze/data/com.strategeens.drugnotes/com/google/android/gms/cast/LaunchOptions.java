package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.cast.class_975;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.class_322;
import com.google.android.gms.internal.class_336;
import java.util.Locale;

public class LaunchOptions implements SafeParcelable {
   public static final Creator<LaunchOptions> CREATOR = new class_975();
   // $FF: renamed from: CK int
   private final int field_4419;
   // $FF: renamed from: FQ boolean
   private boolean field_4420;
   // $FF: renamed from: FR java.lang.String
   private String field_4421;

   public LaunchOptions() {
      this(1, false, class_322.method_2266(Locale.getDefault()));
   }

   LaunchOptions(int var1, boolean var2, String var3) {
      this.field_4419 = var1;
      this.field_4420 = var2;
      this.field_4421 = var3;
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
         if(this.field_4420 != var2.field_4420 || !class_322.method_2262(this.field_4421, var2.field_4421)) {
            return false;
         }
      }

      return true;
   }

   public String getLanguage() {
      return this.field_4421;
   }

   public boolean getRelaunchIfRunning() {
      return this.field_4420;
   }

   int getVersionCode() {
      return this.field_4419;
   }

   public int hashCode() {
      Object[] var1 = new Object[]{Boolean.valueOf(this.field_4420), this.field_4421};
      return class_336.hashCode(var1);
   }

   public void setLanguage(String var1) {
      this.field_4421 = var1;
   }

   public void setRelaunchIfRunning(boolean var1) {
      this.field_4420 = var1;
   }

   public String toString() {
      Object[] var1 = new Object[]{Boolean.valueOf(this.field_4420), this.field_4421};
      return String.format("LaunchOptions(relaunchIfRunning=%b, language=%s)", var1);
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_975.method_5433(this, var1, var2);
   }

   public static final class Builder {
      // $FF: renamed from: FS com.google.android.gms.cast.LaunchOptions
      private LaunchOptions field_3686 = new LaunchOptions();

      public LaunchOptions build() {
         return this.field_3686;
      }

      public LaunchOptions.Builder setLocale(Locale var1) {
         this.field_3686.setLanguage(class_322.method_2266(var1));
         return this;
      }

      public LaunchOptions.Builder setRelaunchIfRunning(boolean var1) {
         this.field_3686.setRelaunchIfRunning(var1);
         return this;
      }
   }
}
