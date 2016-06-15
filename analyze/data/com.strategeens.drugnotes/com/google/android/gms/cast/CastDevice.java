package com.google.android.gms.cast;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.cast.class_976;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.class_322;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class CastDevice implements SafeParcelable {
   public static final Creator<CastDevice> CREATOR = new class_976();
   // $FF: renamed from: CK int
   private final int field_1625;
   // $FF: renamed from: FG java.lang.String
   private String field_1626;
   // $FF: renamed from: FH java.lang.String
   String field_1627;
   // $FF: renamed from: FI java.net.Inet4Address
   private Inet4Address field_1628;
   // $FF: renamed from: FJ java.lang.String
   private String field_1629;
   // $FF: renamed from: FK java.lang.String
   private String field_1630;
   // $FF: renamed from: FL java.lang.String
   private String field_1631;
   // $FF: renamed from: FM int
   private int field_1632;
   // $FF: renamed from: FN java.util.List
   private List<WebImage> field_1633;
   // $FF: renamed from: FO int
   private int field_1634;
   // $FF: renamed from: FP int
   private int field_1635;

   private CastDevice() {
      this(3, (String)null, (String)null, (String)null, (String)null, (String)null, -1, new ArrayList(), 0, -1);
   }

   CastDevice(int var1, String var2, String var3, String var4, String var5, String var6, int var7, List<WebImage> var8, int var9, int var10) {
      this.field_1625 = var1;
      this.field_1626 = var2;
      this.field_1627 = var3;
      if(this.field_1627 != null) {
         try {
            InetAddress var12 = InetAddress.getByName(this.field_1627);
            if(var12 instanceof Inet4Address) {
               this.field_1628 = (Inet4Address)var12;
            }
         } catch (UnknownHostException var13) {
            this.field_1628 = null;
         }
      }

      this.field_1629 = var4;
      this.field_1630 = var5;
      this.field_1631 = var6;
      this.field_1632 = var7;
      this.field_1633 = var8;
      this.field_1634 = var9;
      this.field_1635 = var10;
   }

   public static CastDevice getFromBundle(Bundle var0) {
      if(var0 == null) {
         return null;
      } else {
         var0.setClassLoader(CastDevice.class.getClassLoader());
         return (CastDevice)var0.getParcelable("com.google.android.gms.cast.EXTRA_CAST_DEVICE");
      }
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      if(var1 != this) {
         if(!(var1 instanceof CastDevice)) {
            return false;
         }

         CastDevice var2 = (CastDevice)var1;
         if(this.getDeviceId() == null) {
            if(var2.getDeviceId() != null) {
               return false;
            }
         } else if(!class_322.method_2262(this.field_1626, var2.field_1626) || !class_322.method_2262(this.field_1628, var2.field_1628) || !class_322.method_2262(this.field_1630, var2.field_1630) || !class_322.method_2262(this.field_1629, var2.field_1629) || !class_322.method_2262(this.field_1631, var2.field_1631) || this.field_1632 != var2.field_1632 || !class_322.method_2262(this.field_1633, var2.field_1633) || this.field_1634 != var2.field_1634 || this.field_1635 != var2.field_1635) {
            return false;
         }
      }

      return true;
   }

   public int getCapabilities() {
      return this.field_1634;
   }

   public String getDeviceId() {
      return this.field_1626;
   }

   public String getDeviceVersion() {
      return this.field_1631;
   }

   public String getFriendlyName() {
      return this.field_1629;
   }

   public WebImage getIcon(int var1, int var2) {
      WebImage var3 = null;
      if(this.field_1633.isEmpty()) {
         return null;
      } else if(var1 > 0 && var2 > 0) {
         Iterator var4 = this.field_1633.iterator();

         WebImage var5;
         WebImage var6;
         for(var5 = null; var4.hasNext(); var3 = var6) {
            WebImage var9;
            label66: {
               var6 = (WebImage)var4.next();
               int var7 = var6.getWidth();
               int var8 = var6.getHeight();
               if(var7 >= var1 && var8 >= var2) {
                  if(var5 == null || var5.getWidth() > var7 && var5.getHeight() > var8) {
                     var9 = var6;
                     var6 = var3;
                     break label66;
                  }
               } else if(var7 < var1 && var8 < var2 && (var3 == null || var3.getWidth() < var7 && var3.getHeight() < var8)) {
                  var9 = var5;
                  break label66;
               }

               var6 = var3;
               var9 = var5;
            }

            var5 = var9;
         }

         if(var5 == null) {
            if(var3 != null) {
               var5 = var3;
            } else {
               var5 = (WebImage)this.field_1633.get(0);
            }
         }

         return var5;
      } else {
         return (WebImage)this.field_1633.get(0);
      }
   }

   public List<WebImage> getIcons() {
      return Collections.unmodifiableList(this.field_1633);
   }

   public Inet4Address getIpAddress() {
      return this.field_1628;
   }

   public String getModelName() {
      return this.field_1630;
   }

   public int getServicePort() {
      return this.field_1632;
   }

   public int getStatus() {
      return this.field_1635;
   }

   int getVersionCode() {
      return this.field_1625;
   }

   public boolean hasIcons() {
      return !this.field_1633.isEmpty();
   }

   public int hashCode() {
      return this.field_1626 == null?0:this.field_1626.hashCode();
   }

   public boolean isOnLocalNetwork() {
      return !this.field_1626.startsWith("__cast_nearby__");
   }

   public boolean isSameDevice(CastDevice var1) {
      if(var1 != null) {
         if(this.getDeviceId() != null) {
            return class_322.method_2262(this.getDeviceId(), var1.getDeviceId());
         }

         if(var1.getDeviceId() == null) {
            return true;
         }
      }

      return false;
   }

   public void putInBundle(Bundle var1) {
      if(var1 != null) {
         var1.putParcelable("com.google.android.gms.cast.EXTRA_CAST_DEVICE", this);
      }
   }

   public String toString() {
      Object[] var1 = new Object[]{this.field_1629, this.field_1626};
      return String.format("\"%s\" (%s)", var1);
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_976.method_5436(this, var1, var2);
   }
}
