package com.google.android.gms.appindexing;

import android.net.Uri;
import android.os.Bundle;
import com.google.android.gms.internal.class_335;

public class Thing {
   // $FF: renamed from: DI android.os.Bundle
   final Bundle field_3755;

   Thing(Bundle var1) {
      this.field_3755 = var1;
   }

   // $FF: renamed from: fI () android.os.Bundle
   public Bundle method_4907() {
      return this.field_3755;
   }

   public static class Builder {
      // $FF: renamed from: DJ android.os.Bundle
      final Bundle field_3442 = new Bundle();

      public Thing build() {
         return new Thing(this.field_3442);
      }

      public Thing.Builder put(String var1, Thing var2) {
         class_335.method_2311(var1);
         if(var2 != null) {
            this.field_3442.putParcelable(var1, var2.field_3755);
         }

         return this;
      }

      public Thing.Builder put(String var1, String var2) {
         class_335.method_2311(var1);
         if(var2 != null) {
            this.field_3442.putString(var1, var2);
         }

         return this;
      }

      public Thing.Builder setDescription(String var1) {
         this.put("description", var1);
         return this;
      }

      public Thing.Builder setId(String var1) {
         if(var1 != null) {
            this.put("id", var1);
         }

         return this;
      }

      public Thing.Builder setName(String var1) {
         class_335.method_2311(var1);
         this.put("name", var1);
         return this;
      }

      public Thing.Builder setType(String var1) {
         this.put("type", var1);
         return this;
      }

      public Thing.Builder setUrl(Uri var1) {
         class_335.method_2311(var1);
         this.put("url", var1.toString());
         return this;
      }
   }
}
