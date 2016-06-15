package com.google.android.gms.internal;

import com.google.android.gms.internal.class_821;
import com.google.android.gms.internal.class_826;
import com.google.android.gms.internal.class_831;
import com.google.android.gms.internal.qr;
import com.google.android.gms.internal.qy;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

// $FF: renamed from: com.google.android.gms.internal.qt
class class_829 {
   private qr<?, ?> azd;
   private Object aze;
   private List<qy> azf = new ArrayList();

   private byte[] toByteArray() throws IOException {
      byte[] var1 = new byte[this.method_4591()];
      this.method_4588(class_826.method_4522(var1));
      return var1;
   }

   // $FF: renamed from: a (com.google.android.gms.internal.qp) void
   void method_4588(class_826 var1) throws IOException {
      if(this.aze != null) {
         this.azd.method_4606(this.aze, var1);
      } else {
         Iterator var2 = this.azf.iterator();

         while(var2.hasNext()) {
            ((class_821)var2.next()).method_4482(var1);
         }
      }

   }

   // $FF: renamed from: a (com.google.android.gms.internal.qy) void
   void method_4589(class_821 var1) {
      this.azf.add(var1);
   }

   // $FF: renamed from: b (com.google.android.gms.internal.qr) java.lang.Object
   <T> T method_4590(qr<?, T> var1) {
      if(this.aze != null) {
         if(this.azd != var1) {
            throw new IllegalStateException("Tried to getExtension with a differernt Extension.");
         }
      } else {
         this.azd = var1;
         this.aze = var1.method_4609(this.azf);
         this.azf = null;
      }

      return this.aze;
   }

   // $FF: renamed from: c () int
   int method_4591() {
      int var2;
      if(this.aze != null) {
         var2 = this.azd.method_4602(this.aze);
      } else {
         Iterator var1 = this.azf.iterator();

         for(var2 = 0; var1.hasNext(); var2 += ((class_821)var1.next()).method_4483()) {
            ;
         }
      }

      return var2;
   }

   public boolean equals(Object var1) {
      boolean var3;
      if(var1 == this) {
         var3 = true;
      } else {
         boolean var2 = var1 instanceof class_829;
         var3 = false;
         if(var2) {
            class_829 var4 = (class_829)var1;
            if(this.aze == null || var4.aze == null) {
               if(this.azf != null && var4.azf != null) {
                  return this.azf.equals(var4.azf);
               } else {
                  try {
                     boolean var6 = Arrays.equals(this.toByteArray(), var4.toByteArray());
                     return var6;
                  } catch (IOException var9) {
                     throw new IllegalStateException(var9);
                  }
               }
            }

            class_831 var7 = this.azd;
            class_831 var8 = var4.azd;
            var3 = false;
            if(var7 == var8) {
               if(!this.azd.ayX.isArray()) {
                  return this.aze.equals(var4.aze);
               }

               if(this.aze instanceof byte[]) {
                  return Arrays.equals((byte[])((byte[])this.aze), (byte[])((byte[])var4.aze));
               }

               if(this.aze instanceof int[]) {
                  return Arrays.equals((int[])((int[])this.aze), (int[])((int[])var4.aze));
               }

               if(this.aze instanceof long[]) {
                  return Arrays.equals((long[])((long[])this.aze), (long[])((long[])var4.aze));
               }

               if(this.aze instanceof float[]) {
                  return Arrays.equals((float[])((float[])this.aze), (float[])((float[])var4.aze));
               }

               if(this.aze instanceof double[]) {
                  return Arrays.equals((double[])((double[])this.aze), (double[])((double[])var4.aze));
               }

               if(this.aze instanceof boolean[]) {
                  return Arrays.equals((boolean[])((boolean[])this.aze), (boolean[])((boolean[])var4.aze));
               }

               return Arrays.deepEquals((Object[])((Object[])this.aze), (Object[])((Object[])var4.aze));
            }
         }
      }

      return var3;
   }

   public int hashCode() {
      int var2;
      try {
         var2 = Arrays.hashCode(this.toByteArray());
      } catch (IOException var3) {
         throw new IllegalStateException(var3);
      }

      return var2 + 527;
   }
}
