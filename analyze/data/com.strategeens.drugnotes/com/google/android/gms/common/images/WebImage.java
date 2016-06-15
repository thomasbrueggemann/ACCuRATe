package com.google.android.gms.common.images;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.images.class_560;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.class_336;
import org.json.JSONException;
import org.json.JSONObject;

public final class WebImage implements SafeParcelable {
   public static final Creator<WebImage> CREATOR = new class_560();
   // $FF: renamed from: CK int
   private final int field_4415;
   // $FF: renamed from: LU android.net.Uri
   private final Uri field_4416;
   // $FF: renamed from: li int
   private final int field_4417;
   // $FF: renamed from: lj int
   private final int field_4418;

   WebImage(int var1, Uri var2, int var3, int var4) {
      this.field_4415 = var1;
      this.field_4416 = var2;
      this.field_4417 = var3;
      this.field_4418 = var4;
   }

   public WebImage(Uri var1) throws IllegalArgumentException {
      this(var1, 0, 0);
   }

   public WebImage(Uri var1, int var2, int var3) throws IllegalArgumentException {
      this(1, var1, var2, var3);
      if(var1 == null) {
         throw new IllegalArgumentException("url cannot be null");
      } else if(var2 < 0 || var3 < 0) {
         throw new IllegalArgumentException("width and height must not be negative");
      }
   }

   public WebImage(JSONObject var1) throws IllegalArgumentException {
      this(method_5769(var1), var1.optInt("width", 0), var1.optInt("height", 0));
   }

   // $FF: renamed from: d (org.json.JSONObject) android.net.Uri
   private static Uri method_5769(JSONObject var0) {
      boolean var1 = var0.has("url");
      Uri var2 = null;
      if(var1) {
         Uri var4;
         try {
            var4 = Uri.parse(var0.getString("url"));
         } catch (JSONException var5) {
            return null;
         }

         var2 = var4;
      }

      return var2;
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      if(this != var1) {
         if(var1 != null && var1 instanceof WebImage) {
            WebImage var2 = (WebImage)var1;
            if(class_336.equal(this.field_4416, var2.field_4416) && this.field_4417 == var2.field_4417 && this.field_4418 == var2.field_4418) {
               return true;
            } else {
               return false;
            }
         } else {
            return false;
         }
      } else {
         return true;
      }
   }

   public int getHeight() {
      return this.field_4418;
   }

   public Uri getUrl() {
      return this.field_4416;
   }

   int getVersionCode() {
      return this.field_4415;
   }

   public int getWidth() {
      return this.field_4417;
   }

   public int hashCode() {
      Object[] var1 = new Object[]{this.field_4416, Integer.valueOf(this.field_4417), Integer.valueOf(this.field_4418)};
      return class_336.hashCode(var1);
   }

   public JSONObject toJson() {
      JSONObject var1 = new JSONObject();

      try {
         var1.put("url", this.field_4416.toString());
         var1.put("width", this.field_4417);
         var1.put("height", this.field_4418);
         return var1;
      } catch (JSONException var3) {
         return var1;
      }
   }

   public String toString() {
      Object[] var1 = new Object[]{Integer.valueOf(this.field_4417), Integer.valueOf(this.field_4418), this.field_4416.toString()};
      return String.format("Image %dx%d %s", var1);
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_560.method_3436(this, var1, var2);
   }
}
