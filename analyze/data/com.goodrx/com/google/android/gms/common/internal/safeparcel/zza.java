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

public class zza {
   public static BigDecimal[] zzA(Parcel var0, int var1) {
      int var2 = zza(var0, var1);
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

   public static String[] zzB(Parcel var0, int var1) {
      int var2 = zza(var0, var1);
      int var3 = var0.dataPosition();
      if(var2 == 0) {
         return null;
      } else {
         String[] var4 = var0.createStringArray();
         var0.setDataPosition(var2 + var3);
         return var4;
      }
   }

   public static ArrayList<Integer> zzC(Parcel var0, int var1) {
      int var2 = zza(var0, var1);
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

   public static ArrayList<String> zzD(Parcel var0, int var1) {
      int var2 = zza(var0, var1);
      int var3 = var0.dataPosition();
      if(var2 == 0) {
         return null;
      } else {
         ArrayList var4 = var0.createStringArrayList();
         var0.setDataPosition(var2 + var3);
         return var4;
      }
   }

   public static Parcel zzE(Parcel var0, int var1) {
      int var2 = zza(var0, var1);
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

   public static Parcel[] zzF(Parcel var0, int var1) {
      int var2 = zza(var0, var1);
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

   public static int zza(Parcel var0, int var1) {
      return (var1 & -65536) != -65536?'\uffff' & var1 >> 16:var0.readInt();
   }

   public static <T extends Parcelable> T zza(Parcel var0, int var1, Creator<T> var2) {
      int var3 = zza(var0, var1);
      int var4 = var0.dataPosition();
      if(var3 == 0) {
         return null;
      } else {
         Parcelable var5 = (Parcelable)var2.createFromParcel(var0);
         var0.setDataPosition(var3 + var4);
         return var5;
      }
   }

   private static void zza(Parcel var0, int var1, int var2) {
      int var3 = zza(var0, var1);
      if(var3 != var2) {
         throw new zza.zza("Expected size " + var2 + " got " + var3 + " (0x" + Integer.toHexString(var3) + ")", var0);
      }
   }

   private static void zza(Parcel var0, int var1, int var2, int var3) {
      if(var2 != var3) {
         throw new zza.zza("Expected size " + var3 + " got " + var2 + " (0x" + Integer.toHexString(var2) + ")", var0);
      }
   }

   public static void zza(Parcel var0, int var1, List var2, ClassLoader var3) {
      int var4 = zza(var0, var1);
      int var5 = var0.dataPosition();
      if(var4 != 0) {
         var0.readList(var2, var3);
         var0.setDataPosition(var4 + var5);
      }
   }

   public static int zzat(Parcel var0) {
      return var0.readInt();
   }

   public static int zzau(Parcel var0) {
      int var1 = zzat(var0);
      int var2 = zza(var0, var1);
      int var3 = var0.dataPosition();
      if(zzca(var1) != 20293) {
         throw new zza.zza("Expected object header. Got 0x" + Integer.toHexString(var1), var0);
      } else {
         int var4 = var3 + var2;
         if(var4 >= var3 && var4 <= var0.dataSize()) {
            return var4;
         } else {
            throw new zza.zza("Size read is invalid start=" + var3 + " end=" + var4, var0);
         }
      }
   }

   public static void zzb(Parcel var0, int var1) {
      var0.setDataPosition(zza(var0, var1) + var0.dataPosition());
   }

   public static <T> T[] zzb(Parcel var0, int var1, Creator<T> var2) {
      int var3 = zza(var0, var1);
      int var4 = var0.dataPosition();
      if(var3 == 0) {
         return null;
      } else {
         Object[] var5 = var0.createTypedArray(var2);
         var0.setDataPosition(var3 + var4);
         return var5;
      }
   }

   public static <T> ArrayList<T> zzc(Parcel var0, int var1, Creator<T> var2) {
      int var3 = zza(var0, var1);
      int var4 = var0.dataPosition();
      if(var3 == 0) {
         return null;
      } else {
         ArrayList var5 = var0.createTypedArrayList(var2);
         var0.setDataPosition(var3 + var4);
         return var5;
      }
   }

   public static boolean zzc(Parcel var0, int var1) {
      zza(var0, var1, 4);
      return var0.readInt() != 0;
   }

   public static int zzca(int var0) {
      return '\uffff' & var0;
   }

   public static Boolean zzd(Parcel var0, int var1) {
      int var2 = zza(var0, var1);
      if(var2 == 0) {
         return null;
      } else {
         zza(var0, var1, var2, 4);
         boolean var3;
         if(var0.readInt() != 0) {
            var3 = true;
         } else {
            var3 = false;
         }

         return Boolean.valueOf(var3);
      }
   }

   public static byte zze(Parcel var0, int var1) {
      zza(var0, var1, 4);
      return (byte)var0.readInt();
   }

   public static short zzf(Parcel var0, int var1) {
      zza(var0, var1, 4);
      return (short)var0.readInt();
   }

   public static int zzg(Parcel var0, int var1) {
      zza(var0, var1, 4);
      return var0.readInt();
   }

   public static Integer zzh(Parcel var0, int var1) {
      int var2 = zza(var0, var1);
      if(var2 == 0) {
         return null;
      } else {
         zza(var0, var1, var2, 4);
         return Integer.valueOf(var0.readInt());
      }
   }

   public static long zzi(Parcel var0, int var1) {
      zza(var0, var1, 8);
      return var0.readLong();
   }

   public static Long zzj(Parcel var0, int var1) {
      int var2 = zza(var0, var1);
      if(var2 == 0) {
         return null;
      } else {
         zza(var0, var1, var2, 8);
         return Long.valueOf(var0.readLong());
      }
   }

   public static BigInteger zzk(Parcel var0, int var1) {
      int var2 = zza(var0, var1);
      int var3 = var0.dataPosition();
      if(var2 == 0) {
         return null;
      } else {
         byte[] var4 = var0.createByteArray();
         var0.setDataPosition(var2 + var3);
         return new BigInteger(var4);
      }
   }

   public static float zzl(Parcel var0, int var1) {
      zza(var0, var1, 4);
      return var0.readFloat();
   }

   public static Float zzm(Parcel var0, int var1) {
      int var2 = zza(var0, var1);
      if(var2 == 0) {
         return null;
      } else {
         zza(var0, var1, var2, 4);
         return Float.valueOf(var0.readFloat());
      }
   }

   public static double zzn(Parcel var0, int var1) {
      zza(var0, var1, 8);
      return var0.readDouble();
   }

   public static BigDecimal zzo(Parcel var0, int var1) {
      int var2 = zza(var0, var1);
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

   public static String zzp(Parcel var0, int var1) {
      int var2 = zza(var0, var1);
      int var3 = var0.dataPosition();
      if(var2 == 0) {
         return null;
      } else {
         String var4 = var0.readString();
         var0.setDataPosition(var2 + var3);
         return var4;
      }
   }

   public static IBinder zzq(Parcel var0, int var1) {
      int var2 = zza(var0, var1);
      int var3 = var0.dataPosition();
      if(var2 == 0) {
         return null;
      } else {
         IBinder var4 = var0.readStrongBinder();
         var0.setDataPosition(var2 + var3);
         return var4;
      }
   }

   public static Bundle zzr(Parcel var0, int var1) {
      int var2 = zza(var0, var1);
      int var3 = var0.dataPosition();
      if(var2 == 0) {
         return null;
      } else {
         Bundle var4 = var0.readBundle();
         var0.setDataPosition(var2 + var3);
         return var4;
      }
   }

   public static byte[] zzs(Parcel var0, int var1) {
      int var2 = zza(var0, var1);
      int var3 = var0.dataPosition();
      if(var2 == 0) {
         return null;
      } else {
         byte[] var4 = var0.createByteArray();
         var0.setDataPosition(var2 + var3);
         return var4;
      }
   }

   public static byte[][] zzt(Parcel var0, int var1) {
      int var2 = zza(var0, var1);
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

   public static boolean[] zzu(Parcel var0, int var1) {
      int var2 = zza(var0, var1);
      int var3 = var0.dataPosition();
      if(var2 == 0) {
         return null;
      } else {
         boolean[] var4 = var0.createBooleanArray();
         var0.setDataPosition(var2 + var3);
         return var4;
      }
   }

   public static int[] zzv(Parcel var0, int var1) {
      int var2 = zza(var0, var1);
      int var3 = var0.dataPosition();
      if(var2 == 0) {
         return null;
      } else {
         int[] var4 = var0.createIntArray();
         var0.setDataPosition(var2 + var3);
         return var4;
      }
   }

   public static long[] zzw(Parcel var0, int var1) {
      int var2 = zza(var0, var1);
      int var3 = var0.dataPosition();
      if(var2 == 0) {
         return null;
      } else {
         long[] var4 = var0.createLongArray();
         var0.setDataPosition(var2 + var3);
         return var4;
      }
   }

   public static BigInteger[] zzx(Parcel var0, int var1) {
      int var2 = zza(var0, var1);
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

   public static float[] zzy(Parcel var0, int var1) {
      int var2 = zza(var0, var1);
      int var3 = var0.dataPosition();
      if(var2 == 0) {
         return null;
      } else {
         float[] var4 = var0.createFloatArray();
         var0.setDataPosition(var2 + var3);
         return var4;
      }
   }

   public static double[] zzz(Parcel var0, int var1) {
      int var2 = zza(var0, var1);
      int var3 = var0.dataPosition();
      if(var2 == 0) {
         return null;
      } else {
         double[] var4 = var0.createDoubleArray();
         var0.setDataPosition(var2 + var3);
         return var4;
      }
   }

   public static class zza extends RuntimeException {
      public zza(String var1, Parcel var2) {
         super(var1 + " Parcel: pos=" + var2.dataPosition() + " size=" + var2.dataSize());
      }
   }
}
