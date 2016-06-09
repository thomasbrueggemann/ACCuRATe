package com.google.android.gms.appindexing;

import android.net.Uri;
import android.os.Bundle;
import com.google.android.gms.common.internal.zzx;

public class Thing {
   final Bundle zzUG;

   Thing(Bundle var1) {
      this.zzUG = var1;
   }

   public Bundle zzmk() {
      return this.zzUG;
   }

   public static class Builder {
      final Bundle zzUH = new Bundle();

      public Thing build() {
         return new Thing(this.zzUH);
      }

      public Thing.Builder put(String var1, Thing var2) {
         zzx.zzz(var1);
         if(var2 != null) {
            this.zzUH.putParcelable(var1, var2.zzUG);
         }

         return this;
      }

      public Thing.Builder put(String var1, String var2) {
         zzx.zzz(var1);
         if(var2 != null) {
            this.zzUH.putString(var1, var2);
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
         zzx.zzz(var1);
         this.put("name", var1);
         return this;
      }

      public Thing.Builder setUrl(Uri var1) {
         zzx.zzz(var1);
         this.put("url", var1.toString());
         return this;
      }
   }
}
