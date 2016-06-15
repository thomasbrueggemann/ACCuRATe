package com.google.android.gms.common.internal.safeparcel;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

// $FF: renamed from: com.google.android.gms.common.internal.safeparcel.a
public class class_705 {
   // $FF: renamed from: A (android.os.Parcel, int) java.lang.String[]
   public static String[] method_4053(Parcel var0, int var1) {
      int var2 = method_4060(var0, var1);
      int var3 = var0.dataPosition();
      if(var2 == 0) {
         return null;
      } else {
         String[] var4 = var0.createStringArray();
         var0.setDataPosition(var2 + var3);
         return var4;
      }
   }

   // $FF: renamed from: B (android.os.Parcel, int) java.util.ArrayList
   public static ArrayList<Integer> method_4054(Parcel var0, int var1) {
      int var2 = method_4060(var0, var1);
      int var3 = var0.dataPosition();
      if(var2 == 0) {
         return null;
      } else {
         ArrayList var4 = new ArrayList();
         int var5 = var0.readInt();

         for(int var6 = 0; var6 < var5; ++var6) {
            var4.add(Integer.valueOf(var0.readInt()));
         }

         var0.setDataPosition(var3 + var2);
         return var4;
      }
   }

   // $FF: renamed from: C (android.os.Parcel, int) java.util.ArrayList
   public static ArrayList<String> method_4055(Parcel var0, int var1) {
      int var2 = method_4060(var0, var1);
      int var3 = var0.dataPosition();
      if(var2 == 0) {
         return null;
      } else {
         ArrayList var4 = var0.createStringArrayList();
         var0.setDataPosition(var2 + var3);
         return var4;
      }
   }

   // $FF: renamed from: D (android.os.Parcel, int) android.os.Parcel
   public static Parcel method_4056(Parcel var0, int var1) {
      int var2 = method_4060(var0, var1);
      int var3 = var0.dataPosition();
      if(var2 == 0) {
         return null;
      } else {
         Parcel var4 = Parcel.obtain();
         var4.appendFrom(var0, var3, var2);
         var0.setDataPosition(var2 + var3);
         return var4;
      }
   }

   // $FF: renamed from: E (android.os.Parcel, int) android.os.Parcel[]
   public static Parcel[] method_4057(Parcel var0, int var1) {
      int var2 = method_4060(var0, var1);
      int var3 = var0.dataPosition();
      if(var2 == 0) {
         return null;
      } else {
         int var4 = var0.readInt();
         Parcel[] var5 = new Parcel[var4];

         for(int var6 = 0; var6 < var4; ++var6) {
            int var7 = var0.readInt();
            if(var7 != 0) {
               int var8 = var0.dataPosition();
               Parcel var9 = Parcel.obtain();
               var9.appendFrom(var0, var8, var7);
               var5[var6] = var9;
               var0.setDataPosition(var7 + var8);
            } else {
               var5[var6] = null;
            }
         }

         var0.setDataPosition(var3 + var2);
         return var5;
      }
   }

   // $FF: renamed from: F (android.os.Parcel) int
   public static int method_4058(Parcel var0) {
      return var0.readInt();
   }

   // $FF: renamed from: G (android.os.Parcel) int
   public static int method_4059(Parcel var0) {
      int var1 = method_4058(var0);
      int var2 = method_4060(var0, var1);
      int var3 = var0.dataPosition();
      if(method_4065(var1) != 20293) {
         throw new class_705.class_1425("Expected object header. Got 0x" + Integer.toHexString(var1), var0);
      } else {
         int var4 = var3 + var2;
         if(var4 >= var3 && var4 <= var0.dataSize()) {
            return var4;
         } else {
            throw new class_705.class_1425("Size read is invalid start=" + var3 + " end=" + var4, var0);
         }
      }
   }

   // $FF: renamed from: a (android.os.Parcel, int) int
   public static int method_4060(Parcel var0, int var1) {
      return (var1 & -65536) != -65536?'\uffff' & var1 >> 16:var0.readInt();
   }

   // $FF: renamed from: a (android.os.Parcel, int, android.os.Parcelable.Creator) android.os.Parcelable
   public static <T extends Parcelable> T method_4061(Parcel var0, int var1, Creator<T> var2) {
      int var3 = method_4060(var0, var1);
      int var4 = var0.dataPosition();
      if(var3 == 0) {
         return null;
      } else {
         Parcelable var5 = (Parcelable)var2.createFromParcel(var0);
         var0.setDataPosition(var3 + var4);
         return var5;
      }
   }

   // $FF: renamed from: a (android.os.Parcel, int, int) void
   private static void method_4062(Parcel var0, int var1, int var2) {
      int var3 = method_4060(var0, var1);
      if(var3 != var2) {
         throw new class_705.class_1425("Expected size " + var2 + " got " + var3 + " (0x" + Integer.toHexString(var3) + ")", var0);
      }
   }

   // $FF: renamed from: a (android.os.Parcel, int, int, int) void
   private static void method_4063(Parcel var0, int var1, int var2, int var3) {
      if(var2 != var3) {
         throw new class_705.class_1425("Expected size " + var3 + " got " + var2 + " (0x" + Integer.toHexString(var2) + ")", var0);
      }
   }

   // $FF: renamed from: a (android.os.Parcel, int, java.util.List, java.lang.ClassLoader) void
   public static void method_4064(Parcel var0, int var1, List var2, ClassLoader var3) {
      int var4 = method_4060(var0, var1);
      int var5 = var0.dataPosition();
      if(var4 != 0) {
         var0.readList(var2, var3);
         var0.setDataPosition(var4 + var5);
      }
   }

   // $FF: renamed from: aH (int) int
   public static int method_4065(int var0) {
      return '\uffff' & var0;
   }

   // $FF: renamed from: b (android.os.Parcel, int) void
   public static void method_4066(Parcel var0, int var1) {
      var0.setDataPosition(method_4060(var0, var1) + var0.dataPosition());
   }

   // $FF: renamed from: b (android.os.Parcel, int, android.os.Parcelable.Creator) java.lang.Object[]
   public static <T> T[] method_4067(Parcel var0, int var1, Creator<T> var2) {
      int var3 = method_4060(var0, var1);
      int var4 = var0.dataPosition();
      if(var3 == 0) {
         return null;
      } else {
         Object[] var5 = var0.createTypedArray(var2);
         var0.setDataPosition(var3 + var4);
         return var5;
      }
   }

   // $FF: renamed from: c (android.os.Parcel, int, android.os.Parcelable.Creator) java.util.ArrayList
   public static <T> ArrayList<T> method_4068(Parcel var0, int var1, Creator<T> var2) {
      int var3 = method_4060(var0, var1);
      int var4 = var0.dataPosition();
      if(var3 == 0) {
         return null;
      } else {
         ArrayList var5 = var0.createTypedArrayList(var2);
         var0.setDataPosition(var3 + var4);
         return var5;
      }
   }

   // $FF: renamed from: c (android.os.Parcel, int) boolean
   public static boolean method_4069(Parcel var0, int var1) {
      method_4062(var0, var1, 4);
      return var0.readInt() != 0;
   }

   // $FF: renamed from: d (android.os.Parcel, int) java.lang.Boolean
   public static Boolean method_4070(Parcel var0, int var1) {
      int var2 = method_4060(var0, var1);
      if(var2 == 0) {
         return null;
      } else {
         method_4063(var0, var1, var2, 4);
         boolean var3;
         if(var0.readInt() != 0) {
            var3 = true;
         } else {
            var3 = false;
         }

         return Boolean.valueOf(var3);
      }
   }

   // $FF: renamed from: e (android.os.Parcel, int) byte
   public static byte method_4071(Parcel var0, int var1) {
      method_4062(var0, var1, 4);
      return (byte)var0.readInt();
   }

   // $FF: renamed from: f (android.os.Parcel, int) short
   public static short method_4072(Parcel var0, int var1) {
      method_4062(var0, var1, 4);
      return (short)var0.readInt();
   }

   // $FF: renamed from: g (android.os.Parcel, int) int
   public static int method_4073(Parcel var0, int var1) {
      method_4062(var0, var1, 4);
      return var0.readInt();
   }

   // $FF: renamed from: h (android.os.Parcel, int) java.lang.Integer
   public static Integer method_4074(Parcel var0, int var1) {
      int var2 = method_4060(var0, var1);
      if(var2 == 0) {
         return null;
      } else {
         method_4063(var0, var1, var2, 4);
         return Integer.valueOf(var0.readInt());
      }
   }

   // $FF: renamed from: i (android.os.Parcel, int) long
   public static long method_4075(Parcel var0, int var1) {
      method_4062(var0, var1, 8);
      return var0.readLong();
   }

   // $FF: renamed from: j (android.os.Parcel, int) java.lang.Long
   public static Long method_4076(Parcel var0, int var1) {
      int var2 = method_4060(var0, var1);
      if(var2 == 0) {
         return null;
      } else {
         method_4063(var0, var1, var2, 8);
         return Long.valueOf(var0.readLong());
      }
   }

   // $FF: renamed from: k (android.os.Parcel, int) java.math.BigInteger
   public static BigInteger method_4077(Parcel var0, int var1) {
      int var2 = method_4060(var0, var1);
      int var3 = var0.dataPosition();
      if(var2 == 0) {
         return null;
      } else {
         byte[] var4 = var0.createByteArray();
         var0.setDataPosition(var2 + var3);
         return new BigInteger(var4);
      }
   }

   // $FF: renamed from: l (android.os.Parcel, int) float
   public static float method_4078(Parcel var0, int var1) {
      method_4062(var0, var1, 4);
      return var0.readFloat();
   }

   // $FF: renamed from: m (android.os.Parcel, int) double
   public static double method_4079(Parcel var0, int var1) {
      method_4062(var0, var1, 8);
      return var0.readDouble();
   }

   // $FF: renamed from: n (android.os.Parcel, int) java.math.BigDecimal
   public static BigDecimal method_4080(Parcel var0, int var1) {
      int var2 = method_4060(var0, var1);
      int var3 = var0.dataPosition();
      if(var2 == 0) {
         return null;
      } else {
         byte[] var4 = var0.createByteArray();
         int var5 = var0.readInt();
         var0.setDataPosition(var2 + var3);
         return new BigDecimal(new BigInteger(var4), var5);
      }
   }

   // $FF: renamed from: o (android.os.Parcel, int) java.lang.String
   public static String method_4081(Parcel var0, int var1) {
      int var2 = method_4060(var0, var1);
      int var3 = var0.dataPosition();
      if(var2 == 0) {
         return null;
      } else {
         String var4 = var0.readString();
         var0.setDataPosition(var2 + var3);
         return var4;
      }
   }

   // $FF: renamed from: p (android.os.Parcel, int) android.os.IBinder
   public static IBinder method_4082(Parcel var0, int var1) {
      int var2 = method_4060(var0, var1);
      int var3 = var0.dataPosition();
      if(var2 == 0) {
         return null;
      } else {
         IBinder var4 = var0.readStrongBinder();
         var0.setDataPosition(var2 + var3);
         return var4;
      }
   }

   // $FF: renamed from: q (android.os.Parcel, int) android.os.Bundle
   public static Bundle method_4083(Parcel var0, int var1) {
      int var2 = method_4060(var0, var1);
      int var3 = var0.dataPosition();
      if(var2 == 0) {
         return null;
      } else {
         Bundle var4 = var0.readBundle();
         var0.setDataPosition(var2 + var3);
         return var4;
      }
   }

   // $FF: renamed from: r (android.os.Parcel, int) byte[]
   public static byte[] method_4084(Parcel var0, int var1) {
      int var2 = method_4060(var0, var1);
      int var3 = var0.dataPosition();
      if(var2 == 0) {
         return null;
      } else {
         byte[] var4 = var0.createByteArray();
         var0.setDataPosition(var2 + var3);
         return var4;
      }
   }

   // $FF: renamed from: s (android.os.Parcel, int) byte[][]
   public static byte[][] method_4085(Parcel var0, int var1) {
      int var2 = method_4060(var0, var1);
      int var3 = var0.dataPosition();
      if(var2 == 0) {
         return (byte[][])null;
      } else {
         int var4 = var0.readInt();
         byte[][] var5 = new byte[var4][];

         for(int var6 = 0; var6 < var4; ++var6) {
            var5[var6] = var0.createByteArray();
         }

         var0.setDataPosition(var3 + var2);
         return var5;
      }
   }

   // $FF: renamed from: t (android.os.Parcel, int) boolean[]
   public static boolean[] method_4086(Parcel var0, int var1) {
      int var2 = method_4060(var0, var1);
      int var3 = var0.dataPosition();
      if(var2 == 0) {
         return null;
      } else {
         boolean[] var4 = var0.createBooleanArray();
         var0.setDataPosition(var2 + var3);
         return var4;
      }
   }

   // $FF: renamed from: u (android.os.Parcel, int) int[]
   public static int[] method_4087(Parcel var0, int var1) {
      int var2 = method_4060(var0, var1);
      int var3 = var0.dataPosition();
      if(var2 == 0) {
         return null;
      } else {
         int[] var4 = var0.createIntArray();
         var0.setDataPosition(var2 + var3);
         return var4;
      }
   }

   // $FF: renamed from: v (android.os.Parcel, int) long[]
   public static long[] method_4088(Parcel var0, int var1) {
      int var2 = method_4060(var0, var1);
      int var3 = var0.dataPosition();
      if(var2 == 0) {
         return null;
      } else {
         long[] var4 = var0.createLongArray();
         var0.setDataPosition(var2 + var3);
         return var4;
      }
   }

   // $FF: renamed from: w (android.os.Parcel, int) java.math.BigInteger[]
   public static BigInteger[] method_4089(Parcel var0, int var1) {
      int var2 = method_4060(var0, var1);
      int var3 = var0.dataPosition();
      if(var2 == 0) {
         return null;
      } else {
         int var4 = var0.readInt();
         BigInteger[] var5 = new BigInteger[var4];

         for(int var6 = 0; var6 < var4; ++var6) {
            var5[var6] = new BigInteger(var0.createByteArray());
         }

         var0.setDataPosition(var3 + var2);
         return var5;
      }
   }

   // $FF: renamed from: x (android.os.Parcel, int) float[]
   public static float[] method_4090(Parcel var0, int var1) {
      int var2 = method_4060(var0, var1);
      int var3 = var0.dataPosition();
      if(var2 == 0) {
         return null;
      } else {
         float[] var4 = var0.createFloatArray();
         var0.setDataPosition(var2 + var3);
         return var4;
      }
   }

   // $FF: renamed from: y (android.os.Parcel, int) double[]
   public static double[] method_4091(Parcel var0, int var1) {
      int var2 = method_4060(var0, var1);
      int var3 = var0.dataPosition();
      if(var2 == 0) {
         return null;
      } else {
         double[] var4 = var0.createDoubleArray();
         var0.setDataPosition(var2 + var3);
         return var4;
      }
   }

   // $FF: renamed from: z (android.os.Parcel, int) java.math.BigDecimal[]
   public static BigDecimal[] method_4092(Parcel var0, int var1) {
      int var2 = method_4060(var0, var1);
      int var3 = var0.dataPosition();
      if(var2 == 0) {
         return null;
      } else {
         int var4 = var0.readInt();
         BigDecimal[] var5 = new BigDecimal[var4];

         for(int var6 = 0; var6 < var4; ++var6) {
            byte[] var7 = var0.createByteArray();
            int var8 = var0.readInt();
            var5[var6] = new BigDecimal(new BigInteger(var7), var8);
         }

         var0.setDataPosition(var3 + var2);
         return var5;
      }
   }

   public static class class_1425 extends RuntimeException {
      public class_1425(String var1, Parcel var2) {
         super(var1 + " Parcel: pos=" + var2.dataPosition() + " size=" + var2.dataSize());
      }
   }
}
