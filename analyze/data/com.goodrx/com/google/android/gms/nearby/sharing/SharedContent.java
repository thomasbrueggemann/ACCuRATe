package com.google.android.gms.nearby.sharing;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.nearby.sharing.LocalContent;
import com.google.android.gms.nearby.sharing.ViewableItem;
import com.google.android.gms.nearby.sharing.zzc;
import java.util.Arrays;

public class SharedContent implements SafeParcelable {
   public static final Creator<SharedContent> CREATOR = new zzc();
   private final int versionCode;
   @Deprecated
   private String zzbdg;
   private ViewableItem[] zzbdh;
   private LocalContent[] zzbdi;

   private SharedContent() {
      this.versionCode = 2;
   }

   SharedContent(int var1, String var2, ViewableItem[] var3, LocalContent[] var4) {
      this.versionCode = var1;
      this.zzbdg = var2;
      this.zzbdh = var3;
      this.zzbdi = var4;
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      if(var1 != this) {
         if(!(var1 instanceof SharedContent)) {
            return false;
         }

         SharedContent var2 = (SharedContent)var1;
         if(!zzw.equal(this.zzbdh, var2.zzbdh) || !zzw.equal(this.zzbdi, var2.zzbdi) || !zzw.equal(this.zzbdg, var2.zzbdg)) {
            return false;
         }
      }

      return true;
   }

   public String getUri() {
      return this.zzbdg;
   }

   int getVersionCode() {
      return this.versionCode;
   }

   public int hashCode() {
      Object[] var1 = new Object[]{this.zzbdh, this.zzbdi, this.zzbdg};
      return zzw.hashCode(var1);
   }

   public String toString() {
      return "SharedContent[viewableItems=" + Arrays.toString(this.zzbdh) + ", localContents=" + Arrays.toString(this.zzbdi) + "]";
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzc.zza(this, var1, var2);
   }

   public ViewableItem[] zzEL() {
      return this.zzbdh;
   }

   public LocalContent[] zzEM() {
      return this.zzbdi;
   }
}
