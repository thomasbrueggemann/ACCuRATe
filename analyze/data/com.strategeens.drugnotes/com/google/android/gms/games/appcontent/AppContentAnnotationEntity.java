package com.google.android.gms.games.appcontent;

import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.appcontent.AppContentAnnotation;
import com.google.android.gms.games.appcontent.AppContentAnnotationEntityCreator;
import com.google.android.gms.internal.class_336;

public final class AppContentAnnotationEntity implements SafeParcelable, AppContentAnnotation {
   public static final AppContentAnnotationEntityCreator CREATOR = new AppContentAnnotationEntityCreator();
   // $FF: renamed from: CK int
   private final int field_3669;
   // $FF: renamed from: OH java.lang.String
   private final String field_3670;
   // $FF: renamed from: UO java.lang.String
   private final String field_3671;
   // $FF: renamed from: XN android.net.Uri
   private final Uri field_3672;
   // $FF: renamed from: vc java.lang.String
   private final String field_3673;

   AppContentAnnotationEntity(int var1, String var2, Uri var3, String var4, String var5) {
      this.field_3669 = var1;
      this.field_3671 = var2;
      this.field_3672 = var3;
      this.field_3670 = var4;
      this.field_3673 = var5;
   }

   public AppContentAnnotationEntity(AppContentAnnotation var1) {
      this.field_3669 = 1;
      this.field_3671 = var1.getDescription();
      this.field_3672 = var1.method_263();
      this.field_3670 = var1.getTitle();
      this.field_3673 = var1.getType();
   }

   // $FF: renamed from: a (com.google.android.gms.games.appcontent.AppContentAnnotation) int
   static int method_4826(AppContentAnnotation var0) {
      Object[] var1 = new Object[]{var0.getDescription(), var0.method_263(), var0.getTitle(), var0.getType()};
      return class_336.hashCode(var1);
   }

   // $FF: renamed from: a (com.google.android.gms.games.appcontent.AppContentAnnotation, java.lang.Object) boolean
   static boolean method_4827(AppContentAnnotation var0, Object var1) {
      boolean var2 = true;
      if(!(var1 instanceof AppContentAnnotation)) {
         var2 = false;
      } else if(var0 != var1) {
         AppContentAnnotation var3 = (AppContentAnnotation)var1;
         if(!class_336.equal(var3.getDescription(), var0.getDescription()) || !class_336.equal(var3.method_263(), var0.method_263()) || !class_336.equal(var3.getTitle(), var0.getTitle()) || !class_336.equal(var3.getType(), var0.getType())) {
            return false;
         }
      }

      return var2;
   }

   // $FF: renamed from: b (com.google.android.gms.games.appcontent.AppContentAnnotation) java.lang.String
   static String method_4828(AppContentAnnotation var0) {
      return class_336.method_2312(var0).method_3424("Description", var0.getDescription()).method_3424("ImageUri", var0.method_263()).method_3424("Title", var0.getTitle()).method_3424("Type", var0.getType()).toString();
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return method_4827(this, var1);
   }

   // $FF: synthetic method
   public Object freeze() {
      return this.method_4829();
   }

   public String getDescription() {
      return this.field_3671;
   }

   public String getTitle() {
      return this.field_3670;
   }

   public String getType() {
      return this.field_3673;
   }

   public int getVersionCode() {
      return this.field_3669;
   }

   public int hashCode() {
      return method_4826(this);
   }

   public boolean isDataValid() {
      return true;
   }

   // $FF: renamed from: kL () android.net.Uri
   public Uri method_263() {
      return this.field_3672;
   }

   // $FF: renamed from: kM () com.google.android.gms.games.appcontent.AppContentAnnotation
   public AppContentAnnotation method_4829() {
      return this;
   }

   public String toString() {
      return method_4828(this);
   }

   public void writeToParcel(Parcel var1, int var2) {
      AppContentAnnotationEntityCreator.method_5140(this, var1, var2);
   }
}
