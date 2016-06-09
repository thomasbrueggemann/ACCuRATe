package com.google.android.gms.location;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.location.zzb;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class GestureRequest implements SafeParcelable {
   public static final zzb CREATOR;
   private static final List<Integer> zzaNP;
   private static final List<Integer> zzaNQ;
   private static final List<Integer> zzaNR;
   private static final List<Integer> zzaNS;
   private final int mVersionCode;
   private final List<Integer> zzaNT;

   static {
      Integer[] var0 = new Integer[]{Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(4), Integer.valueOf(5), Integer.valueOf(6), Integer.valueOf(7), Integer.valueOf(8), Integer.valueOf(9), Integer.valueOf(10), Integer.valueOf(11), Integer.valueOf(12), Integer.valueOf(13), Integer.valueOf(14), Integer.valueOf(15), Integer.valueOf(16), Integer.valueOf(17), Integer.valueOf(18), Integer.valueOf(19)};
      zzaNP = Collections.unmodifiableList(Arrays.asList(var0));
      Integer[] var1 = new Integer[]{Integer.valueOf(1)};
      zzaNQ = Collections.unmodifiableList(Arrays.asList(var1));
      Integer[] var2 = new Integer[]{Integer.valueOf(2), Integer.valueOf(4), Integer.valueOf(6), Integer.valueOf(8), Integer.valueOf(10), Integer.valueOf(12), Integer.valueOf(14), Integer.valueOf(16), Integer.valueOf(18), Integer.valueOf(19)};
      zzaNR = Collections.unmodifiableList(Arrays.asList(var2));
      Integer[] var3 = new Integer[]{Integer.valueOf(3), Integer.valueOf(5), Integer.valueOf(7), Integer.valueOf(9), Integer.valueOf(11), Integer.valueOf(13), Integer.valueOf(15), Integer.valueOf(17)};
      zzaNS = Collections.unmodifiableList(Arrays.asList(var3));
      CREATOR = new zzb();
   }

   GestureRequest(int var1, List<Integer> var2) {
      this.mVersionCode = var1;
      this.zzaNT = var2;
   }

   public int describeContents() {
      return 0;
   }

   public int getVersionCode() {
      return this.mVersionCode;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzb.zza(this, var1, var2);
   }

   public List<Integer> zzyJ() {
      return this.zzaNT;
   }
}
