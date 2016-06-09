package com.facebook.imagepipeline.common;

import com.facebook.common.internal.Preconditions;
import com.facebook.common.util.HashCodeUtil;
import java.util.Locale;

public class ResizeOptions {
   public final int height;
   public final int width;

   public ResizeOptions(int var1, int var2) {
      boolean var3 = true;
      super();
      boolean var4;
      if(var1 > 0) {
         var4 = var3;
      } else {
         var4 = false;
      }

      Preconditions.checkArgument(var4);
      if(var2 <= 0) {
         var3 = false;
      }

      Preconditions.checkArgument(var3);
      this.width = var1;
      this.height = var2;
   }

   public boolean equals(Object var1) {
      if(var1 != this) {
         if(!(var1 instanceof ResizeOptions)) {
            return false;
         }

         ResizeOptions var2 = (ResizeOptions)var1;
         if(this.width != var2.width || this.height != var2.height) {
            return false;
         }
      }

      return true;
   }

   public int hashCode() {
      return HashCodeUtil.hashCode(this.width, this.height);
   }

   public String toString() {
      Locale var1 = (Locale)null;
      Object[] var2 = new Object[]{Integer.valueOf(this.width), Integer.valueOf(this.height)};
      return String.format(var1, "%dx%d", var2);
   }
}
