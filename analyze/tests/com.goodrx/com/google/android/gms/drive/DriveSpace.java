package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.zzg;
import com.google.android.gms.internal.zzmr;
import java.util.Set;
import java.util.regex.Pattern;

public class DriveSpace implements SafeParcelable {
   public static final Creator<DriveSpace> CREATOR = new zzg();
   public static final DriveSpace zzaoP = new DriveSpace("DRIVE");
   public static final DriveSpace zzaoQ = new DriveSpace("APP_DATA_FOLDER");
   public static final DriveSpace zzaoR = new DriveSpace("PHOTOS");
   public static final Set<DriveSpace> zzaoS;
   public static final String zzaoT;
   private static final Pattern zzaoU;
   private final String mName;
   final int mVersionCode;

   static {
      zzaoS = zzmr.zza(zzaoP, zzaoQ, zzaoR);
      zzaoT = TextUtils.join(",", zzaoS.toArray());
      zzaoU = Pattern.compile("[A-Z0-9_]*");
   }

   DriveSpace(int var1, String var2) {
      this.mVersionCode = var1;
      this.mName = (String)zzx.zzz(var2);
   }

   private DriveSpace(String var1) {
      this(1, var1);
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return var1 != null && var1.getClass() == DriveSpace.class?this.mName.equals(((DriveSpace)var1).mName):false;
   }

   public String getName() {
      return this.mName;
   }

   public int hashCode() {
      return 1247068382 ^ this.mName.hashCode();
   }

   public String toString() {
      return this.mName;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzg.zza(this, var1, var2);
   }
}
