package com.google.android.gms.drive.metadata;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.metadata.class_1003;
import com.google.android.gms.internal.class_335;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

public class CustomPropertyKey implements SafeParcelable {
   public static final Creator<CustomPropertyKey> CREATOR = new class_1003();
   public static final int PRIVATE = 1;
   public static final int PUBLIC;
   // $FF: renamed from: Rc java.util.regex.Pattern
   private static final Pattern field_1593 = Pattern.compile("[\\w.!@$%^&*()/-]+");
   // $FF: renamed from: CK int
   final int field_1594;
   // $FF: renamed from: KP java.lang.String
   final String field_1595;
   final int mVisibility;

   CustomPropertyKey(int var1, String var2, int var3) {
      byte var4 = 1;
      super();
      class_335.method_2306(var2, "key");
      class_335.method_2308(field_1593.matcher(var2).matches(), "key name characters must be alphanumeric or one of .!@$%^&*()-_/");
      if(var3 != 0 && var3 != var4) {
         var4 = 0;
      }

      class_335.method_2308((boolean)var4, "visibility must be either PUBLIC or PRIVATE");
      this.field_1594 = var1;
      this.field_1595 = var2;
      this.mVisibility = var3;
   }

   public CustomPropertyKey(String var1, int var2) {
      this(1, var1, var2);
   }

   public static CustomPropertyKey fromJson(JSONObject var0) throws JSONException {
      return new CustomPropertyKey(var0.getString("key"), var0.getInt("visibility"));
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      boolean var2 = true;
      if(var1 != null) {
         if(var1 == this) {
            return var2;
         }

         if(var1 instanceof CustomPropertyKey) {
            CustomPropertyKey var3 = (CustomPropertyKey)var1;
            if(!var3.getKey().equals(this.field_1595) || var3.getVisibility() != this.mVisibility) {
               var2 = false;
            }

            return var2;
         }
      }

      return false;
   }

   public String getKey() {
      return this.field_1595;
   }

   public int getVisibility() {
      return this.mVisibility;
   }

   public int hashCode() {
      return (this.field_1595 + this.mVisibility).hashCode();
   }

   public JSONObject toJson() throws JSONException {
      JSONObject var1 = new JSONObject();
      var1.put("key", this.getKey());
      var1.put("visibility", this.getVisibility());
      return var1;
   }

   public String toString() {
      return "CustomPropertyKey(" + this.field_1595 + "," + this.mVisibility + ")";
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_1003.method_5516(this, var1, var2);
   }
}
