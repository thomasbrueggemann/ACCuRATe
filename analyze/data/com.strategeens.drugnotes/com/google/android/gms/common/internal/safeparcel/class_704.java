package com.google.android.gms.common.internal.safeparcel;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

// $FF: renamed from: com.google.android.gms.common.internal.safeparcel.b
public class class_704 {
   // $FF: renamed from: F (android.os.Parcel, int) int
   private static int method_4023(Parcel var0, int var1) {
      var0.writeInt(-65536 | var1);
      var0.writeInt(0);
      return var0.dataPosition();
   }

   // $FF: renamed from: G (android.os.Parcel, int) void
   private static void method_4024(Parcel var0, int var1) {
      int var2 = var0.dataPosition();
      int var3 = var2 - var1;
      var0.setDataPosition(var1 - 4);
      var0.writeInt(var3);
      var0.setDataPosition(var2);
   }

   // $FF: renamed from: H (android.os.Parcel) int
   public static int method_4025(Parcel var0) {
      return method_4023(var0, 20293);
   }

   // $FF: renamed from: H (android.os.Parcel, int) void
   public static void method_4026(Parcel var0, int var1) {
      method_4024(var0, var1);
   }

   // $FF: renamed from: a (android.os.Parcel, int, byte) void
   public static void method_4027(Parcel var0, int var1, byte var2) {
      method_4048(var0, var1, 4);
      var0.writeInt(var2);
   }

   // $FF: renamed from: a (android.os.Parcel, int, double) void
   public static void method_4028(Parcel var0, int var1, double var2) {
      method_4048(var0, var1, 8);
      var0.writeDouble(var2);
   }

   // $FF: renamed from: a (android.os.Parcel, int, float) void
   public static void method_4029(Parcel var0, int var1, float var2) {
      method_4048(var0, var1, 4);
      var0.writeFloat(var2);
   }

   // $FF: renamed from: a (android.os.Parcel, int, long) void
   public static void method_4030(Parcel var0, int var1, long var2) {
      method_4048(var0, var1, 8);
      var0.writeLong(var2);
   }

   // $FF: renamed from: a (android.os.Parcel, int, android.os.Bundle, boolean) void
   public static void method_4031(Parcel var0, int var1, Bundle var2, boolean var3) {
      if(var2 == null) {
         if(var3) {
            method_4048(var0, var1, 0);
         }

      } else {
         int var4 = method_4023(var0, var1);
         var0.writeBundle(var2);
         method_4024(var0, var4);
      }
   }

   // $FF: renamed from: a (android.os.Parcel, int, android.os.IBinder, boolean) void
   public static void method_4032(Parcel var0, int var1, IBinder var2, boolean var3) {
      if(var2 == null) {
         if(var3) {
            method_4048(var0, var1, 0);
         }

      } else {
         int var4 = method_4023(var0, var1);
         var0.writeStrongBinder(var2);
         method_4024(var0, var4);
      }
   }

   // $FF: renamed from: a (android.os.Parcel, int, android.os.Parcel, boolean) void
   public static void method_4033(Parcel var0, int var1, Parcel var2, boolean var3) {
      if(var2 == null) {
         if(var3) {
            method_4048(var0, var1, 0);
         }

      } else {
         int var4 = method_4023(var0, var1);
         var0.appendFrom(var2, 0, var2.dataSize());
         method_4024(var0, var4);
      }
   }

   // $FF: renamed from: a (android.os.Parcel, int, android.os.Parcelable, int, boolean) void
   public static void method_4034(Parcel var0, int var1, Parcelable var2, int var3, boolean var4) {
      if(var2 == null) {
         if(var4) {
            method_4048(var0, var1, 0);
         }

      } else {
         int var5 = method_4023(var0, var1);
         var2.writeToParcel(var0, var3);
         method_4024(var0, var5);
      }
   }

   // $FF: renamed from: a (android.os.Parcel, int, java.lang.Boolean, boolean) void
   public static void method_4035(Parcel var0, int var1, Boolean var2, boolean var3) {
      if(var2 == null) {
         if(var3) {
            method_4048(var0, var1, 0);
         }

      } else {
         method_4048(var0, var1, 4);
         boolean var4 = var2.booleanValue();
         byte var5 = 0;
         if(var4) {
            var5 = 1;
         }

         var0.writeInt(var5);
      }
   }

   // $FF: renamed from: a (android.os.Parcel, int, java.lang.Integer, boolean) void
   public static void method_4036(Parcel var0, int var1, Integer var2, boolean var3) {
      if(var2 == null) {
         if(var3) {
            method_4048(var0, var1, 0);
         }

      } else {
         method_4048(var0, var1, 4);
         var0.writeInt(var2.intValue());
      }
   }

   // $FF: renamed from: a (android.os.Parcel, int, java.lang.Long, boolean) void
   public static void method_4037(Parcel var0, int var1, Long var2, boolean var3) {
      if(var2 == null) {
         if(var3) {
            method_4048(var0, var1, 0);
         }

      } else {
         method_4048(var0, var1, 8);
         var0.writeLong(var2.longValue());
      }
   }

   // $FF: renamed from: a (android.os.Parcel, int, java.lang.String, boolean) void
   public static void method_4038(Parcel var0, int var1, String var2, boolean var3) {
      if(var2 == null) {
         if(var3) {
            method_4048(var0, var1, 0);
         }

      } else {
         int var4 = method_4023(var0, var1);
         var0.writeString(var2);
         method_4024(var0, var4);
      }
   }

   // $FF: renamed from: a (android.os.Parcel, int, java.util.List, boolean) void
   public static void method_4039(Parcel var0, int var1, List<Integer> var2, boolean var3) {
      if(var2 == null) {
         if(var3) {
            method_4048(var0, var1, 0);
         }

      } else {
         int var4 = method_4023(var0, var1);
         int var5 = var2.size();
         var0.writeInt(var5);

         for(int var6 = 0; var6 < var5; ++var6) {
            var0.writeInt(((Integer)var2.get(var6)).intValue());
         }

         method_4024(var0, var4);
      }
   }

   // $FF: renamed from: a (android.os.Parcel, int, short) void
   public static void method_4040(Parcel var0, int var1, short var2) {
      method_4048(var0, var1, 4);
      var0.writeInt(var2);
   }

   // $FF: renamed from: a (android.os.Parcel, int, boolean) void
   public static void method_4041(Parcel var0, int var1, boolean var2) {
      method_4048(var0, var1, 4);
      byte var3;
      if(var2) {
         var3 = 1;
      } else {
         var3 = 0;
      }

      var0.writeInt(var3);
   }

   // $FF: renamed from: a (android.os.Parcel, int, byte[], boolean) void
   public static void method_4042(Parcel var0, int var1, byte[] var2, boolean var3) {
      if(var2 == null) {
         if(var3) {
            method_4048(var0, var1, 0);
         }

      } else {
         int var4 = method_4023(var0, var1);
         var0.writeByteArray(var2);
         method_4024(var0, var4);
      }
   }

   // $FF: renamed from: a (android.os.Parcel, int, int[], boolean) void
   public static void method_4043(Parcel var0, int var1, int[] var2, boolean var3) {
      if(var2 == null) {
         if(var3) {
            method_4048(var0, var1, 0);
         }

      } else {
         int var4 = method_4023(var0, var1);
         var0.writeIntArray(var2);
         method_4024(var0, var4);
      }
   }

   // $FF: renamed from: a (android.os.Parcel, int, android.os.Parcelable[], int, boolean) void
   public static <T extends Parcelable> void method_4044(Parcel var0, int var1, T[] var2, int var3, boolean var4) {
      if(var2 == null) {
         if(var4) {
            method_4048(var0, var1, 0);
         }

      } else {
         int var5 = method_4023(var0, var1);
         int var6 = var2.length;
         var0.writeInt(var6);

         for(int var7 = 0; var7 < var6; ++var7) {
            Parcelable var8 = var2[var7];
            if(var8 == null) {
               var0.writeInt(0);
            } else {
               method_4047(var0, var8, var3);
            }
         }

         method_4024(var0, var5);
      }
   }

   // $FF: renamed from: a (android.os.Parcel, int, java.lang.String[], boolean) void
   public static void method_4045(Parcel var0, int var1, String[] var2, boolean var3) {
      if(var2 == null) {
         if(var3) {
            method_4048(var0, var1, 0);
         }

      } else {
         int var4 = method_4023(var0, var1);
         var0.writeStringArray(var2);
         method_4024(var0, var4);
      }
   }

   // $FF: renamed from: a (android.os.Parcel, int, byte[][], boolean) void
   public static void method_4046(Parcel var0, int var1, byte[][] var2, boolean var3) {
      int var4 = 0;
      if(var2 == null) {
         if(var3) {
            method_4048(var0, var1, 0);
         }

      } else {
         int var5 = method_4023(var0, var1);
         int var6 = var2.length;
         var0.writeInt(var6);

         while(var4 < var6) {
            var0.writeByteArray(var2[var4]);
            ++var4;
         }

         method_4024(var0, var5);
      }
   }

   // $FF: renamed from: a (android.os.Parcel, android.os.Parcelable, int) void
   private static <T extends Parcelable> void method_4047(Parcel var0, T var1, int var2) {
      int var3 = var0.dataPosition();
      var0.writeInt(1);
      int var4 = var0.dataPosition();
      var1.writeToParcel(var0, var2);
      int var5 = var0.dataPosition();
      var0.setDataPosition(var3);
      var0.writeInt(var5 - var4);
      var0.setDataPosition(var5);
   }

   // $FF: renamed from: b (android.os.Parcel, int, int) void
   private static void method_4048(Parcel var0, int var1, int var2) {
      if(var2 >= '\uffff') {
         var0.writeInt(-65536 | var1);
         var0.writeInt(var2);
      } else {
         var0.writeInt(var1 | var2 << 16);
      }
   }

   // $FF: renamed from: b (android.os.Parcel, int, java.util.List, boolean) void
   public static void method_4049(Parcel var0, int var1, List<String> var2, boolean var3) {
      if(var2 == null) {
         if(var3) {
            method_4048(var0, var1, 0);
         }

      } else {
         int var4 = method_4023(var0, var1);
         var0.writeStringList(var2);
         method_4024(var0, var4);
      }
   }

   // $FF: renamed from: c (android.os.Parcel, int, int) void
   public static void method_4050(Parcel var0, int var1, int var2) {
      method_4048(var0, var1, 4);
      var0.writeInt(var2);
   }

   // $FF: renamed from: c (android.os.Parcel, int, java.util.List, boolean) void
   public static <T extends Parcelable> void method_4051(Parcel var0, int var1, List<T> var2, boolean var3) {
      if(var2 == null) {
         if(var3) {
            method_4048(var0, var1, 0);
         }

      } else {
         int var4 = method_4023(var0, var1);
         int var5 = var2.size();
         var0.writeInt(var5);

         for(int var6 = 0; var6 < var5; ++var6) {
            Parcelable var7 = (Parcelable)var2.get(var6);
            if(var7 == null) {
               var0.writeInt(0);
            } else {
               method_4047(var0, var7, 0);
            }
         }

         method_4024(var0, var4);
      }
   }

   // $FF: renamed from: d (android.os.Parcel, int, java.util.List, boolean) void
   public static void method_4052(Parcel var0, int var1, List var2, boolean var3) {
      if(var2 == null) {
         if(var3) {
            method_4048(var0, var1, 0);
         }

      } else {
         int var4 = method_4023(var0, var1);
         var0.writeList(var2);
         method_4024(var0, var4);
      }
   }
}
