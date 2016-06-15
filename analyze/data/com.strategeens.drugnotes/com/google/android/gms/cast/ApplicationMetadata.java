package com.google.android.gms.cast;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.cast.class_977;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.class_322;
import com.google.android.gms.internal.class_336;
import java.util.ArrayList;
import java.util.List;

public final class ApplicationMetadata implements SafeParcelable {
   public static final Creator<ApplicationMetadata> CREATOR = new class_977();
   // $FF: renamed from: CK int
   private final int field_3674;
   // $FF: renamed from: Fo java.lang.String
   String field_3675;
   // $FF: renamed from: Fp java.util.List
   List<WebImage> field_3676;
   // $FF: renamed from: Fq java.util.List
   List<String> field_3677;
   // $FF: renamed from: Fr java.lang.String
   String field_3678;
   // $FF: renamed from: Fs android.net.Uri
   Uri field_3679;
   String mName;

   private ApplicationMetadata() {
      this.field_3674 = 1;
      this.field_3676 = new ArrayList();
      this.field_3677 = new ArrayList();
   }

   ApplicationMetadata(int var1, String var2, String var3, List<WebImage> var4, List<String> var5, String var6, Uri var7) {
      this.field_3674 = var1;
      this.field_3675 = var2;
      this.mName = var3;
      this.field_3676 = var4;
      this.field_3677 = var5;
      this.field_3678 = var6;
      this.field_3679 = var7;
   }

   public boolean areNamespacesSupported(List<String> var1) {
      return this.field_3677 != null && this.field_3677.containsAll(var1);
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
         if(!class_322.method_2262(this.field_3675, var2.field_3675) || !class_322.method_2262(this.field_3676, var2.field_3676) || !class_322.method_2262(this.mName, var2.mName) || !class_322.method_2262(this.field_3677, var2.field_3677) || !class_322.method_2262(this.field_3678, var2.field_3678) || !class_322.method_2262(this.field_3679, var2.field_3679)) {
            return false;
         }
      }

      return true;
   }

   // $FF: renamed from: fP () android.net.Uri
   public Uri method_4830() {
      return this.field_3679;
   }

   public String getApplicationId() {
      return this.field_3675;
   }

   public List<WebImage> getImages() {
      return this.field_3676;
   }

   public String getName() {
      return this.mName;
   }

   public String getSenderAppIdentifier() {
      return this.field_3678;
   }

   int getVersionCode() {
      return this.field_3674;
   }

   public int hashCode() {
      Object[] var1 = new Object[]{Integer.valueOf(this.field_3674), this.field_3675, this.mName, this.field_3676, this.field_3677, this.field_3678, this.field_3679};
      return class_336.hashCode(var1);
   }

   public boolean isNamespaceSupported(String var1) {
      return this.field_3677 != null && this.field_3677.contains(var1);
   }

   public String toString() {
      return this.mName;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_977.method_5439(this, var1, var2);
   }
}
