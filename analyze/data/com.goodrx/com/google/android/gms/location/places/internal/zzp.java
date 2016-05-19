package com.google.android.gms.location.places.internal;

import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.location.places.PlacePhotoMetadata;

public class zzp implements PlacePhotoMetadata {
   private int mIndex;
   private final int zzDF;
   private final int zzDG;
   private final String zzaQR;
   private final CharSequence zzaQS;

   public zzp(String var1, int var2, int var3, CharSequence var4, int var5) {
      this.zzaQR = var1;
      this.zzDF = var2;
      this.zzDG = var3;
      this.zzaQS = var4;
      this.mIndex = var5;
   }

   public boolean equals(Object var1) {
      if(var1 != this) {
         if(!(var1 instanceof zzp)) {
            return false;
         }

         zzp var2 = (zzp)var1;
         if(var2.zzDF != this.zzDF || var2.zzDG != this.zzDG || !zzw.equal(var2.zzaQR, this.zzaQR) || !zzw.equal(var2.zzaQS, this.zzaQS)) {
            return false;
         }
      }

      return true;
   }

   // $FF: synthetic method
   public Object freeze() {
      return this.zzzz();
   }

   public int hashCode() {
      Object[] var1 = new Object[]{Integer.valueOf(this.zzDF), Integer.valueOf(this.zzDG), this.zzaQR, this.zzaQS};
      return zzw.hashCode(var1);
   }

   public PlacePhotoMetadata zzzz() {
      return this;
   }
}
