package com.google.android.gms.cast;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.cast.zza;
import com.google.android.gms.cast.internal.zzf;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class ApplicationMetadata implements SafeParcelable {
   public static final Creator<ApplicationMetadata> CREATOR = new zza();
   String mName;
   private final int mVersionCode;
   String zzZC;
   List<String> zzZD;
   String zzZE;
   Uri zzZF;
   List<WebImage> zzxX;

   private ApplicationMetadata() {
      this.mVersionCode = 1;
      this.zzxX = new ArrayList();
      this.zzZD = new ArrayList();
   }

   ApplicationMetadata(int var1, String var2, String var3, List<WebImage> var4, List<String> var5, String var6, Uri var7) {
      this.mVersionCode = var1;
      this.zzZC = var2;
      this.mName = var3;
      this.zzxX = var4;
      this.zzZD = var5;
      this.zzZE = var6;
      this.zzZF = var7;
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      if(var1 != this) {
         if(!(var1 instanceof ApplicationMetadata)) {
            return false;
         }

         ApplicationMetadata var2 = (ApplicationMetadata)var1;
         if(!zzf.zza(this.zzZC, var2.zzZC) || !zzf.zza(this.zzxX, var2.zzxX) || !zzf.zza(this.mName, var2.mName) || !zzf.zza(this.zzZD, var2.zzZD) || !zzf.zza(this.zzZE, var2.zzZE) || !zzf.zza(this.zzZF, var2.zzZF)) {
            return false;
         }
      }

      return true;
   }

   public String getApplicationId() {
      return this.zzZC;
   }

   public List<WebImage> getImages() {
      return this.zzxX;
   }

   public String getName() {
      return this.mName;
   }

   public String getSenderAppIdentifier() {
      return this.zzZE;
   }

   public List<String> getSupportedNamespaces() {
      return Collections.unmodifiableList(this.zzZD);
   }

   int getVersionCode() {
      return this.mVersionCode;
   }

   public int hashCode() {
      Object[] var1 = new Object[]{Integer.valueOf(this.mVersionCode), this.zzZC, this.mName, this.zzxX, this.zzZD, this.zzZE, this.zzZF};
      return zzw.hashCode(var1);
   }

   public String toString() {
      StringBuilder var1 = (new StringBuilder()).append("applicationId: ").append(this.zzZC).append(", name: ").append(this.mName).append(", images.count: ");
      int var2;
      if(this.zzxX == null) {
         var2 = 0;
      } else {
         var2 = this.zzxX.size();
      }

      StringBuilder var3 = var1.append(var2).append(", namespaces.count: ");
      List var4 = this.zzZD;
      int var5 = 0;
      if(var4 != null) {
         var5 = this.zzZD.size();
      }

      return var3.append(var5).append(", senderAppIdentifier: ").append(this.zzZE).append(", senderAppLaunchUrl: ").append(this.zzZF).toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      zza.zza(this, var1, var2);
   }

   public Uri zznx() {
      return this.zzZF;
   }
}
