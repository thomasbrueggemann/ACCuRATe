package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.zza;

public final class Application implements SafeParcelable {
   public static final Creator<Application> CREATOR;
   public static final Application zzawa;
   private final int mVersionCode;
   private final String zzTJ;
   private final String zzadc;
   private final String zzawb;

   static {
      zzawa = new Application("com.google.android.gms", String.valueOf(GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE), (String)null);
      CREATOR = new zza();
   }

   Application(int var1, String var2, String var3, String var4) {
      this.mVersionCode = var1;
      this.zzTJ = (String)zzx.zzz(var2);
      this.zzadc = "";
      this.zzawb = var4;
   }

   public Application(String var1, String var2, String var3) {
      this(1, var1, "", var3);
   }

   private boolean zza(Application var1) {
      return this.zzTJ.equals(var1.zzTJ) && zzw.equal(this.zzadc, var1.zzadc) && zzw.equal(this.zzawb, var1.zzawb);
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return this == var1 || var1 instanceof Application && this.zza((Application)var1);
   }

   public String getPackageName() {
      return this.zzTJ;
   }

   public String getVersion() {
      return this.zzadc;
   }

   int getVersionCode() {
      return this.mVersionCode;
   }

   public int hashCode() {
      Object[] var1 = new Object[]{this.zzTJ, this.zzadc, this.zzawb};
      return zzw.hashCode(var1);
   }

   public String toString() {
      Object[] var1 = new Object[]{this.zzTJ, this.zzadc, this.zzawb};
      return String.format("Application{%s:%s:%s}", var1);
   }

   public void writeToParcel(Parcel var1, int var2) {
      zza.zza(this, var1, var2);
   }

   public String zzua() {
      return this.zzawb;
   }
}
