package com.comscore.android.id;

import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.os.Build.VERSION;
import android.provider.Settings.Secure;
import com.comscore.android.id.API4;
import com.comscore.android.id.API9;
import com.comscore.android.id.DeviceId;
import com.comscore.android.id.class_88;
import com.comscore.android.id.class_89;
import com.comscore.android.id.class_90;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class IdHelperAndroid {
   public static final String[] INVALID_ID_VALUES = new String[]{"0123456789ABCDEF", "0123456789abcdef", "9774d56d682e549c", "9774D56D682E549C", "unknown", "UNKNOWN", "android_id", "ANDROID_ID"};
   public static final String NO_ID_AVAILABLE = "none";
   // $FF: renamed from: a java.lang.String
   private static final String field_524 = "com.google.android.gms";
   // $FF: renamed from: b java.lang.String
   private static final String field_525 = "com.google.android.gms.ads.identifier.service.START";
   // $FF: renamed from: c boolean
   private static boolean field_526 = false;
   // $FF: renamed from: d boolean
   private static final boolean field_527 = false;

   // $FF: renamed from: a (android.content.Context) java.lang.String
   private static String method_470(Context var0) {
      if(Looper.myLooper() == Looper.getMainLooper()) {
         throw new IllegalStateException("Cannot be called from the main thread");
      } else {
         String var1 = "";
         class_90 var2 = new class_90((class_88)null);
         Intent var3 = new Intent(field_525);
         var3.setPackage(field_524);
         if(var0.bindService(var3, var2, 1)) {
            boolean var10 = false;

            String var7;
            label51: {
               try {
                  var10 = true;
                  var7 = (new class_89(var2.getBinder())).getId();
                  var10 = false;
                  break label51;
               } catch (Exception var11) {
                  var10 = false;
               } finally {
                  if(var10) {
                     var0.unbindService(var2);
                  }
               }

               var0.unbindService(var2);
               return var1;
            }

            var1 = var7;
            var0.unbindService(var2);
         }

         return var1;
      }
   }

   // $FF: renamed from: b (android.content.Context) boolean
   private static boolean method_471(Context var0) {
      return VERSION.SDK_INT > 4?(field_527?true:API4.isPackageInstalledFromGooglePlayStore(var0)):false;
   }

   public static boolean checkAndroidId(String var0) {
      for(int var1 = 0; var1 < INVALID_ID_VALUES.length; ++var1) {
         if(INVALID_ID_VALUES[var1].equals(var0)) {
            return false;
         }
      }

      return true;
   }

   public static boolean checkAndroidSerial(String var0) {
      if(var0 != null) {
         int var1 = 0;

         while(true) {
            if(var1 >= INVALID_ID_VALUES.length) {
               if(var0.length() > 3 && !var0.substring(0, 3).equals("***") && !var0.substring(0, 3).equals("000")) {
                  return true;
               }
               break;
            }

            if(INVALID_ID_VALUES[var1].equals(var0)) {
               break;
            }

            ++var1;
         }
      }

      return false;
   }

   public static final DeviceId getAdvertisingDeviceId(Context var0) {
      if(Looper.myLooper() == Looper.getMainLooper()) {
         throw new IllegalStateException("Cannot be called from the main thread");
      } else {
         return method_471(var0)?getGooglePlayAdvertisingDeviceId(var0):getDeviceId(var0);
      }
   }

   public static final DeviceId getAndroidId(Context var0) {
      if(Integer.valueOf(VERSION.SDK_INT).intValue() >= 3) {
         String var1 = Secure.getString(var0.getContentResolver(), "android_id");
         if(var1 != null && var1.length() > 0) {
            return new DeviceId("AndroidId", var1, 7, 2);
         }
      }

      return null;
   }

   public static final DeviceId getAndroidSerial() {
      return Integer.valueOf(VERSION.SDK_INT).intValue() >= 9?new DeviceId("AndroidSerial", API9.getAndroidSerial(), 3, 1):null;
   }

   public static DeviceId getDeviceId(Context var0) {
      DeviceId var1 = getAndroidSerial();
      if(!checkAndroidSerial(var1.getId())) {
         var1 = getAndroidId(var0);
         if(!checkAndroidId(var1.getId())) {
            var1 = null;
         }
      }

      return var1;
   }

   public static final DeviceId getGooglePlayAdvertisingDeviceId(Context var0) {
      if(Looper.myLooper() == Looper.getMainLooper()) {
         throw new IllegalStateException("Cannot be called from the main thread");
      } else {
         boolean var2;
         try {
            var2 = isGooglePlayServicesAvailable(var0);
         } catch (IllegalStateException var4) {
            throw var4;
         }

         if(var2) {
            String var3;
            if(isAdvertisingIdEnabled(var0)) {
               var3 = method_470(var0);
            } else {
               var3 = "none";
            }

            return new DeviceId(var3);
         } else {
            return null;
         }
      }
   }

   public static boolean isAdvertisingIdEnabled(Context var0) {
      if(Looper.myLooper() == Looper.getMainLooper()) {
         throw new IllegalStateException("Cannot be called from the main thread");
      } else {
         boolean var1 = field_526;
         boolean var2 = false;
         if(!var1) {
            class_90 var3 = new class_90((class_88)null);
            Intent var4 = new Intent(field_525);
            var4.setPackage(field_524);
            boolean var6 = var0.bindService(var4, var3, 1);
            var2 = false;
            if(var6) {
               label79: {
                  boolean var12 = false;

                  boolean var9;
                  label69: {
                     try {
                        var12 = true;
                        var9 = (new class_89(var3.getBinder())).isLimitAdTrackingEnabled(true);
                        var12 = false;
                        break label69;
                     } catch (Exception var13) {
                        var12 = false;
                     } finally {
                        if(var12) {
                           var0.unbindService(var3);
                        }
                     }

                     var0.unbindService(var3);
                     var2 = false;
                     break label79;
                  }

                  var2 = false;
                  if(!var9) {
                     var2 = true;
                  }

                  var0.unbindService(var3);
               }
            }

            if(!var2) {
               field_526 = true;
               return var2;
            }
         }

         return var2;
      }
   }

   public static boolean isGooglePlayServicesAvailable(Context var0) {
      if(Looper.myLooper() == Looper.getMainLooper()) {
         throw new IllegalStateException("Cannot be called from the main thread");
      } else {
         if(VERSION.SDK_INT > 8) {
            try {
               var0.getPackageManager().getPackageInfo("com.android.vending", 0);
            } catch (Exception var5) {
               return false;
            }

            class_90 var3 = new class_90((class_88)null);
            Intent var4 = new Intent(field_525);
            var4.setPackage(field_524);
            if(var0.bindService(var4, var3, 1)) {
               var0.unbindService(var3);
               return true;
            }
         }

         return false;
      }
   }

   public static String md5(String var0) {
      byte[] var3;
      try {
         var3 = MessageDigest.getInstance("MD5").digest(var0.getBytes("UTF-8"));
      } catch (NoSuchAlgorithmException var8) {
         throw new RuntimeException("Huh, MD5 should be supported?", var8);
      } catch (UnsupportedEncodingException var9) {
         throw new RuntimeException("Huh, UTF-8 should be supported?", var9);
      }

      StringBuilder var4 = new StringBuilder(2 * var3.length);
      int var5 = var3.length;

      for(int var6 = 0; var6 < var5; ++var6) {
         int var7 = 255 & var3[var6];
         if(var7 < 16) {
            var4.append('0');
         }

         var4.append(Integer.toHexString(var7));
      }

      return var4.toString();
   }
}
