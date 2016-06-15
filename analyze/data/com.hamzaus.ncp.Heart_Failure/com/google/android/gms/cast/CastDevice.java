package com.google.android.gms.cast;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.cast.class_753;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.class_332;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class CastDevice implements SafeParcelable {
   public static final Creator<CastDevice> CREATOR = new class_753();
   // $FF: renamed from: Ae java.lang.String
   private String field_1997;
   // $FF: renamed from: Af java.lang.String
   String field_1998;
   // $FF: renamed from: Ag java.net.Inet4Address
   private Inet4Address field_1999;
   // $FF: renamed from: Ah java.lang.String
   private String field_2000;
   // $FF: renamed from: Ai java.lang.String
   private String field_2001;
   // $FF: renamed from: Aj java.lang.String
   private String field_2002;
   // $FF: renamed from: Ak int
   private int field_2003;
   // $FF: renamed from: Al java.util.List
   private List<WebImage> field_2004;
   // $FF: renamed from: Am int
   private int field_2005;
   // $FF: renamed from: xJ int
   private final int field_2006;

   private CastDevice() {
      this(2, (String)null, (String)null, (String)null, (String)null, (String)null, -1, new ArrayList(), 0);
   }

   CastDevice(int var1, String var2, String var3, String var4, String var5, String var6, int var7, List<WebImage> var8, int var9) {
      this.field_2006 = var1;
      this.field_1997 = var2;
      this.field_1998 = var3;
      if(this.field_1998 != null) {
         try {
            InetAddress var11 = InetAddress.getByName(this.field_1998);
            if(var11 instanceof Inet4Address) {
               this.field_1999 = (Inet4Address)var11;
            }
         } catch (UnknownHostException var12) {
            this.field_1999 = null;
         }
      }

      this.field_2000 = var4;
      this.field_2001 = var5;
      this.field_2002 = var6;
      this.field_2003 = var7;
      this.field_2004 = var8;
      this.field_2005 = var9;
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
         } else if(!class_332.method_2117(this.field_1997, var2.field_1997) || !class_332.method_2117(this.field_1999, var2.field_1999) || !class_332.method_2117(this.field_2001, var2.field_2001) || !class_332.method_2117(this.field_2000, var2.field_2000) || !class_332.method_2117(this.field_2002, var2.field_2002) || this.field_2003 != var2.field_2003 || !class_332.method_2117(this.field_2004, var2.field_2004) || this.field_2005 != var2.field_2005) {
            return false;
         }
      }

      return true;
   }

   public int getCapabilities() {
      return this.field_2005;
   }

   public String getDeviceId() {
      return this.field_1997;
   }

   public String getDeviceVersion() {
      return this.field_2002;
   }

   public String getFriendlyName() {
      return this.field_2000;
   }

   public WebImage getIcon(int var1, int var2) {
      WebImage var3 = null;
      if(this.field_2004.isEmpty()) {
         return null;
      } else if(var1 > 0 && var2 > 0) {
         Iterator var4 = this.field_2004.iterator();

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
               var5 = (WebImage)this.field_2004.get(0);
            }
         }

         return var5;
      } else {
         return (WebImage)this.field_2004.get(0);
      }
   }

   public List<WebImage> getIcons() {
      return Collections.unmodifiableList(this.field_2004);
   }

   public Inet4Address getIpAddress() {
      return this.field_1999;
   }

   public String getModelName() {
      return this.field_2001;
   }

   public int getServicePort() {
      return this.field_2003;
   }

   int getVersionCode() {
      return this.field_2006;
   }

   public boolean hasIcons() {
      return !this.field_2004.isEmpty();
   }

   public int hashCode() {
      return this.field_1997 == null?0:this.field_1997.hashCode();
   }

   public boolean isSameDevice(CastDevice var1) {
      if(var1 != null) {
         if(this.getDeviceId() != null) {
            return class_332.method_2117(this.getDeviceId(), var1.getDeviceId());
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
      Object[] var1 = new Object[]{this.field_2000, this.field_1997};
      return String.format("\"%s\" (%s)", var1);
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_753.method_4308(this, var1, var2);
   }
}
