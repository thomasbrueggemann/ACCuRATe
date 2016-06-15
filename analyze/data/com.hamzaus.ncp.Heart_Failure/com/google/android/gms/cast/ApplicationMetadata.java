package com.google.android.gms.cast;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.cast.class_754;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.class_332;
import com.google.android.gms.internal.class_349;
import java.util.ArrayList;
import java.util.List;

public final class ApplicationMetadata implements SafeParcelable {
   public static final Creator<ApplicationMetadata> CREATOR = new class_754();
   String mName;
   // $FF: renamed from: xJ int
   private final int field_3523;
   // $FF: renamed from: zM java.lang.String
   String field_3524;
   // $FF: renamed from: zN java.util.List
   List<WebImage> field_3525;
   // $FF: renamed from: zO java.util.List
   List<String> field_3526;
   // $FF: renamed from: zP java.lang.String
   String field_3527;
   // $FF: renamed from: zQ android.net.Uri
   Uri field_3528;

   private ApplicationMetadata() {
      this.field_3523 = 1;
      this.field_3525 = new ArrayList();
      this.field_3526 = new ArrayList();
   }

   ApplicationMetadata(int var1, String var2, String var3, List<WebImage> var4, List<String> var5, String var6, Uri var7) {
      this.field_3523 = var1;
      this.field_3524 = var2;
      this.mName = var3;
      this.field_3525 = var4;
      this.field_3526 = var5;
      this.field_3527 = var6;
      this.field_3528 = var7;
   }

   public boolean areNamespacesSupported(List<String> var1) {
      return this.field_3526 != null && this.field_3526.containsAll(var1);
   }

   // $FF: renamed from: dS () android.net.Uri
   public Uri method_3855() {
      return this.field_3528;
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
         if(!class_332.method_2117(this.field_3524, var2.field_3524) || !class_332.method_2117(this.field_3525, var2.field_3525) || !class_332.method_2117(this.mName, var2.mName) || !class_332.method_2117(this.field_3526, var2.field_3526) || !class_332.method_2117(this.field_3527, var2.field_3527) || !class_332.method_2117(this.field_3528, var2.field_3528)) {
            return false;
         }
      }

      return true;
   }

   public String getApplicationId() {
      return this.field_3524;
   }

   public List<WebImage> getImages() {
      return this.field_3525;
   }

   public String getName() {
      return this.mName;
   }

   public String getSenderAppIdentifier() {
      return this.field_3527;
   }

   int getVersionCode() {
      return this.field_3523;
   }

   public int hashCode() {
      Object[] var1 = new Object[]{Integer.valueOf(this.field_3523), this.field_3524, this.mName, this.field_3525, this.field_3526, this.field_3527, this.field_3528};
      return class_349.hashCode(var1);
   }

   public boolean isNamespaceSupported(String var1) {
      return this.field_3526 != null && this.field_3526.contains(var1);
   }

   public String toString() {
      return this.mName;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_754.method_4311(this, var1, var2);
   }
}
