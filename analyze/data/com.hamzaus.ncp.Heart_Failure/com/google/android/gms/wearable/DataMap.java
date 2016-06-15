package com.google.android.gms.wearable;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.internal.class_246;
import com.google.android.gms.internal.class_249;
import com.google.android.gms.internal.class_607;
import com.google.android.gms.internal.class_637;
import com.google.android.gms.wearable.Asset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class DataMap {
   public static final String TAG = "DataMap";
   private final HashMap<String, Object> alh = new HashMap();

   // $FF: renamed from: a (android.os.Bundle, java.lang.String, java.lang.Object) void
   private static void method_4123(Bundle var0, String var1, Object var2) {
      if(var2 instanceof String) {
         var0.putString(var1, (String)var2);
      } else {
         if(var2 instanceof Integer) {
            var0.putInt(var1, ((Integer)var2).intValue());
            return;
         }

         if(var2 instanceof Long) {
            var0.putLong(var1, ((Long)var2).longValue());
            return;
         }

         if(var2 instanceof Double) {
            var0.putDouble(var1, ((Double)var2).doubleValue());
            return;
         }

         if(var2 instanceof Float) {
            var0.putFloat(var1, ((Float)var2).floatValue());
            return;
         }

         if(var2 instanceof Boolean) {
            var0.putBoolean(var1, ((Boolean)var2).booleanValue());
            return;
         }

         if(var2 instanceof Byte) {
            var0.putByte(var1, ((Byte)var2).byteValue());
            return;
         }

         if(var2 instanceof byte[]) {
            var0.putByteArray(var1, (byte[])((byte[])var2));
            return;
         }

         if(var2 instanceof String[]) {
            var0.putStringArray(var1, (String[])((String[])var2));
            return;
         }

         if(var2 instanceof long[]) {
            var0.putLongArray(var1, (long[])((long[])var2));
            return;
         }

         if(var2 instanceof float[]) {
            var0.putFloatArray(var1, (float[])((float[])var2));
            return;
         }

         if(var2 instanceof Asset) {
            var0.putParcelable(var1, (Asset)var2);
            return;
         }

         if(var2 instanceof DataMap) {
            var0.putParcelable(var1, ((DataMap)var2).toBundle());
            return;
         }

         if(var2 instanceof ArrayList) {
            switch(method_4129((ArrayList)var2)) {
            case 0:
               var0.putStringArrayList(var1, (ArrayList)var2);
               return;
            case 1:
               var0.putStringArrayList(var1, (ArrayList)var2);
               return;
            case 2:
               var0.putIntegerArrayList(var1, (ArrayList)var2);
               return;
            case 3:
               var0.putStringArrayList(var1, (ArrayList)var2);
               return;
            case 4:
               ArrayList var3 = new ArrayList();
               Iterator var4 = ((ArrayList)var2).iterator();

               while(var4.hasNext()) {
                  var3.add(((DataMap)var4.next()).toBundle());
               }

               var0.putParcelableArrayList(var1, var3);
               return;
            default:
               return;
            }
         }
      }

   }

   // $FF: renamed from: a (com.google.android.gms.wearable.DataMap, java.lang.String, java.lang.Object) void
   private static void method_4124(DataMap var0, String var1, Object var2) {
      if(var2 instanceof String) {
         var0.putString(var1, (String)var2);
      } else {
         if(var2 instanceof Integer) {
            var0.putInt(var1, ((Integer)var2).intValue());
            return;
         }

         if(var2 instanceof Long) {
            var0.putLong(var1, ((Long)var2).longValue());
            return;
         }

         if(var2 instanceof Double) {
            var0.putDouble(var1, ((Double)var2).doubleValue());
            return;
         }

         if(var2 instanceof Float) {
            var0.putFloat(var1, ((Float)var2).floatValue());
            return;
         }

         if(var2 instanceof Boolean) {
            var0.putBoolean(var1, ((Boolean)var2).booleanValue());
            return;
         }

         if(var2 instanceof Byte) {
            var0.putByte(var1, ((Byte)var2).byteValue());
            return;
         }

         if(var2 instanceof byte[]) {
            var0.putByteArray(var1, (byte[])((byte[])var2));
            return;
         }

         if(var2 instanceof String[]) {
            var0.putStringArray(var1, (String[])((String[])var2));
            return;
         }

         if(var2 instanceof long[]) {
            var0.putLongArray(var1, (long[])((long[])var2));
            return;
         }

         if(var2 instanceof float[]) {
            var0.putFloatArray(var1, (float[])((float[])var2));
            return;
         }

         if(var2 instanceof Asset) {
            var0.putAsset(var1, (Asset)var2);
            return;
         }

         if(var2 instanceof Bundle) {
            var0.putDataMap(var1, fromBundle((Bundle)var2));
            return;
         }

         if(var2 instanceof ArrayList) {
            switch(method_4129((ArrayList)var2)) {
            case 0:
               var0.putStringArrayList(var1, (ArrayList)var2);
               return;
            case 1:
               var0.putStringArrayList(var1, (ArrayList)var2);
               return;
            case 2:
               var0.putIntegerArrayList(var1, (ArrayList)var2);
               return;
            case 3:
               var0.putStringArrayList(var1, (ArrayList)var2);
               return;
            case 4:
            default:
               return;
            case 5:
               var0.putDataMapArrayList(var1, arrayListFromBundleArrayList((ArrayList)var2));
               return;
            }
         }
      }

   }

   // $FF: renamed from: a (java.lang.String, java.lang.Object, java.lang.String, java.lang.ClassCastException) void
   private void method_4125(String var1, Object var2, String var3, ClassCastException var4) {
      this.method_4126(var1, var2, var3, "<null>", var4);
   }

   // $FF: renamed from: a (java.lang.String, java.lang.Object, java.lang.String, java.lang.Object, java.lang.ClassCastException) void
   private void method_4126(String var1, Object var2, String var3, Object var4, ClassCastException var5) {
      StringBuilder var6 = new StringBuilder();
      var6.append("Key ");
      var6.append(var1);
      var6.append(" expected ");
      var6.append(var3);
      var6.append(" but value was a ");
      var6.append(var2.getClass().getName());
      var6.append(".  The default value ");
      var6.append(var4);
      var6.append(" was returned.");
      Log.w("DataMap", var6.toString());
      Log.w("DataMap", "Attempt to cast generated internal exception:", var5);
   }

   // $FF: renamed from: a (com.google.android.gms.wearable.Asset, com.google.android.gms.wearable.Asset) boolean
   private static boolean method_4127(Asset var0, Asset var1) {
      return var0 != null && var1 != null?(!TextUtils.isEmpty(var0.getDigest())?var0.getDigest().equals(var1.getDigest()):Arrays.equals(var0.getData(), var1.getData())):var0 == var1;
   }

   // $FF: renamed from: a (com.google.android.gms.wearable.DataMap, com.google.android.gms.wearable.DataMap) boolean
   private static boolean method_4128(DataMap var0, DataMap var1) {
      if(var0.size() == var1.size()) {
         Iterator var2 = var0.keySet().iterator();

         while(true) {
            while(true) {
               while(true) {
                  while(true) {
                     while(true) {
                        while(var2.hasNext()) {
                           String var3 = (String)var2.next();
                           Object var4 = var0.get(var3);
                           Object var5 = var1.get(var3);
                           if(!(var4 instanceof Asset)) {
                              if(!(var4 instanceof String[])) {
                                 if(!(var4 instanceof long[])) {
                                    if(!(var4 instanceof float[])) {
                                       if(!(var4 instanceof byte[])) {
                                          if(var4 == null || var5 == null) {
                                             boolean var6;
                                             if(var4 == var5) {
                                                var6 = true;
                                             } else {
                                                var6 = false;
                                             }

                                             return var6;
                                          }

                                          if(!var4.equals(var5)) {
                                             return false;
                                          }
                                       } else {
                                          if(!(var5 instanceof byte[])) {
                                             return false;
                                          }

                                          if(!Arrays.equals((byte[])((byte[])var4), (byte[])((byte[])var5))) {
                                             return false;
                                          }
                                       }
                                    } else {
                                       if(!(var5 instanceof float[])) {
                                          return false;
                                       }

                                       if(!Arrays.equals((float[])((float[])var4), (float[])((float[])var5))) {
                                          return false;
                                       }
                                    }
                                 } else {
                                    if(!(var5 instanceof long[])) {
                                       return false;
                                    }

                                    if(!Arrays.equals((long[])((long[])var4), (long[])((long[])var5))) {
                                       return false;
                                    }
                                 }
                              } else {
                                 if(!(var5 instanceof String[])) {
                                    return false;
                                 }

                                 if(!Arrays.equals((String[])((String[])var4), (String[])((String[])var5))) {
                                    return false;
                                 }
                              }
                           } else {
                              if(!(var5 instanceof Asset)) {
                                 return false;
                              }

                              if(!method_4127((Asset)var4, (Asset)var5)) {
                                 return false;
                              }
                           }
                        }

                        return true;
                     }
                  }
               }
            }
         }
      } else {
         return false;
      }
   }

   public static ArrayList<DataMap> arrayListFromBundleArrayList(ArrayList<Bundle> var0) {
      ArrayList var1 = new ArrayList();
      Iterator var2 = var0.iterator();

      while(var2.hasNext()) {
         var1.add(fromBundle((Bundle)var2.next()));
      }

      return var1;
   }

   // $FF: renamed from: c (java.util.ArrayList) int
   private static int method_4129(ArrayList<?> var0) {
      if(var0.isEmpty()) {
         return 0;
      } else {
         Iterator var1 = var0.iterator();

         while(var1.hasNext()) {
            Object var2 = var1.next();
            if(var2 != null) {
               if(var2 instanceof Integer) {
                  return 2;
               }

               if(var2 instanceof String) {
                  return 3;
               }

               if(var2 instanceof DataMap) {
                  return 4;
               }

               if(var2 instanceof Bundle) {
                  return 5;
               }
            }
         }

         return 1;
      }
   }

   public static DataMap fromBundle(Bundle var0) {
      var0.setClassLoader(Asset.class.getClassLoader());
      DataMap var1 = new DataMap();
      Iterator var2 = var0.keySet().iterator();

      while(var2.hasNext()) {
         String var3 = (String)var2.next();
         method_4124(var1, var3, var0.get(var3));
      }

      return var1;
   }

   public static DataMap fromByteArray(byte[] var0) {
      try {
         DataMap var2 = class_607.method_3579(new class_607.class_831(class_249.method_1736(var0), new ArrayList()));
         return var2;
      } catch (class_637 var3) {
         throw new IllegalArgumentException("Unable to convert data", var3);
      }
   }

   public void clear() {
      this.alh.clear();
   }

   public boolean containsKey(String var1) {
      return this.alh.containsKey(var1);
   }

   public boolean equals(Object var1) {
      return !(var1 instanceof DataMap)?false:method_4128(this, (DataMap)var1);
   }

   public <T> T get(String var1) {
      return this.alh.get(var1);
   }

   public Asset getAsset(String var1) {
      Object var2 = this.alh.get(var1);
      if(var2 == null) {
         return null;
      } else {
         try {
            Asset var4 = (Asset)var2;
            return var4;
         } catch (ClassCastException var5) {
            this.method_4125(var1, var2, "Asset", var5);
            return null;
         }
      }
   }

   public boolean getBoolean(String var1) {
      return this.getBoolean(var1, false);
   }

   public boolean getBoolean(String var1, boolean var2) {
      Object var3 = this.alh.get(var1);
      if(var3 == null) {
         return var2;
      } else {
         try {
            boolean var5 = ((Boolean)var3).booleanValue();
            return var5;
         } catch (ClassCastException var6) {
            this.method_4126(var1, var3, "Boolean", Boolean.valueOf(var2), var6);
            return var2;
         }
      }
   }

   public byte getByte(String var1) {
      return this.getByte(var1, (byte)0);
   }

   public byte getByte(String var1, byte var2) {
      Object var3 = this.alh.get(var1);
      if(var3 == null) {
         return var2;
      } else {
         try {
            byte var5 = ((Byte)var3).byteValue();
            return var5;
         } catch (ClassCastException var6) {
            this.method_4126(var1, var3, "Byte", Byte.valueOf(var2), var6);
            return var2;
         }
      }
   }

   public byte[] getByteArray(String var1) {
      Object var2 = this.alh.get(var1);
      if(var2 == null) {
         return null;
      } else {
         try {
            byte[] var4 = (byte[])((byte[])var2);
            return var4;
         } catch (ClassCastException var5) {
            this.method_4125(var1, var2, "byte[]", var5);
            return null;
         }
      }
   }

   public DataMap getDataMap(String var1) {
      Object var2 = this.alh.get(var1);
      if(var2 == null) {
         return null;
      } else {
         try {
            DataMap var4 = (DataMap)var2;
            return var4;
         } catch (ClassCastException var5) {
            this.method_4125(var1, var2, "DataMap", var5);
            return null;
         }
      }
   }

   public ArrayList<DataMap> getDataMapArrayList(String var1) {
      Object var2 = this.alh.get(var1);
      if(var2 == null) {
         return null;
      } else {
         try {
            ArrayList var4 = (ArrayList)var2;
            return var4;
         } catch (ClassCastException var5) {
            this.method_4125(var1, var2, "ArrayList<DataMap>", var5);
            return null;
         }
      }
   }

   public double getDouble(String var1) {
      return this.getDouble(var1, 0.0D);
   }

   public double getDouble(String var1, double var2) {
      Object var4 = this.alh.get(var1);
      if(var4 == null) {
         return var2;
      } else {
         try {
            double var6 = ((Double)var4).doubleValue();
            return var6;
         } catch (ClassCastException var8) {
            this.method_4126(var1, var4, "Double", Double.valueOf(var2), var8);
            return var2;
         }
      }
   }

   public float getFloat(String var1) {
      return this.getFloat(var1, 0.0F);
   }

   public float getFloat(String var1, float var2) {
      Object var3 = this.alh.get(var1);
      if(var3 == null) {
         return var2;
      } else {
         try {
            float var5 = ((Float)var3).floatValue();
            return var5;
         } catch (ClassCastException var6) {
            this.method_4126(var1, var3, "Float", Float.valueOf(var2), var6);
            return var2;
         }
      }
   }

   public float[] getFloatArray(String var1) {
      Object var2 = this.alh.get(var1);
      if(var2 == null) {
         return null;
      } else {
         try {
            float[] var4 = (float[])((float[])var2);
            return var4;
         } catch (ClassCastException var5) {
            this.method_4125(var1, var2, "float[]", var5);
            return null;
         }
      }
   }

   public int getInt(String var1) {
      return this.getInt(var1, 0);
   }

   public int getInt(String var1, int var2) {
      Object var3 = this.alh.get(var1);
      if(var3 == null) {
         return var2;
      } else {
         try {
            int var5 = ((Integer)var3).intValue();
            return var5;
         } catch (ClassCastException var6) {
            this.method_4125(var1, var3, "Integer", var6);
            return var2;
         }
      }
   }

   public ArrayList<Integer> getIntegerArrayList(String var1) {
      Object var2 = this.alh.get(var1);
      if(var2 == null) {
         return null;
      } else {
         try {
            ArrayList var4 = (ArrayList)var2;
            return var4;
         } catch (ClassCastException var5) {
            this.method_4125(var1, var2, "ArrayList<Integer>", var5);
            return null;
         }
      }
   }

   public long getLong(String var1) {
      return this.getLong(var1, 0L);
   }

   public long getLong(String var1, long var2) {
      Object var4 = this.alh.get(var1);
      if(var4 == null) {
         return var2;
      } else {
         try {
            long var6 = ((Long)var4).longValue();
            return var6;
         } catch (ClassCastException var8) {
            this.method_4125(var1, var4, "long", var8);
            return var2;
         }
      }
   }

   public long[] getLongArray(String var1) {
      Object var2 = this.alh.get(var1);
      if(var2 == null) {
         return null;
      } else {
         try {
            long[] var4 = (long[])((long[])var2);
            return var4;
         } catch (ClassCastException var5) {
            this.method_4125(var1, var2, "long[]", var5);
            return null;
         }
      }
   }

   public String getString(String var1) {
      Object var2 = this.alh.get(var1);
      if(var2 == null) {
         return null;
      } else {
         try {
            String var4 = (String)var2;
            return var4;
         } catch (ClassCastException var5) {
            this.method_4125(var1, var2, "String", var5);
            return null;
         }
      }
   }

   public String getString(String var1, String var2) {
      String var3 = this.getString(var1);
      return var3 == null?var2:var3;
   }

   public String[] getStringArray(String var1) {
      Object var2 = this.alh.get(var1);
      if(var2 == null) {
         return null;
      } else {
         try {
            String[] var4 = (String[])((String[])var2);
            return var4;
         } catch (ClassCastException var5) {
            this.method_4125(var1, var2, "String[]", var5);
            return null;
         }
      }
   }

   public ArrayList<String> getStringArrayList(String var1) {
      Object var2 = this.alh.get(var1);
      if(var2 == null) {
         return null;
      } else {
         try {
            ArrayList var4 = (ArrayList)var2;
            return var4;
         } catch (ClassCastException var5) {
            this.method_4125(var1, var2, "ArrayList<String>", var5);
            return null;
         }
      }
   }

   public int hashCode() {
      return 29 * this.alh.hashCode();
   }

   public boolean isEmpty() {
      return this.alh.isEmpty();
   }

   public Set<String> keySet() {
      return this.alh.keySet();
   }

   public void putAll(DataMap var1) {
      Iterator var2 = var1.keySet().iterator();

      while(var2.hasNext()) {
         String var3 = (String)var2.next();
         this.alh.put(var3, var1.get(var3));
      }

   }

   public void putAsset(String var1, Asset var2) {
      this.alh.put(var1, var2);
   }

   public void putBoolean(String var1, boolean var2) {
      this.alh.put(var1, Boolean.valueOf(var2));
   }

   public void putByte(String var1, byte var2) {
      this.alh.put(var1, Byte.valueOf(var2));
   }

   public void putByteArray(String var1, byte[] var2) {
      this.alh.put(var1, var2);
   }

   public void putDataMap(String var1, DataMap var2) {
      this.alh.put(var1, var2);
   }

   public void putDataMapArrayList(String var1, ArrayList<DataMap> var2) {
      this.alh.put(var1, var2);
   }

   public void putDouble(String var1, double var2) {
      this.alh.put(var1, Double.valueOf(var2));
   }

   public void putFloat(String var1, float var2) {
      this.alh.put(var1, Float.valueOf(var2));
   }

   public void putFloatArray(String var1, float[] var2) {
      this.alh.put(var1, var2);
   }

   public void putInt(String var1, int var2) {
      this.alh.put(var1, Integer.valueOf(var2));
   }

   public void putIntegerArrayList(String var1, ArrayList<Integer> var2) {
      this.alh.put(var1, var2);
   }

   public void putLong(String var1, long var2) {
      this.alh.put(var1, Long.valueOf(var2));
   }

   public void putLongArray(String var1, long[] var2) {
      this.alh.put(var1, var2);
   }

   public void putString(String var1, String var2) {
      this.alh.put(var1, var2);
   }

   public void putStringArray(String var1, String[] var2) {
      this.alh.put(var1, var2);
   }

   public void putStringArrayList(String var1, ArrayList<String> var2) {
      this.alh.put(var1, var2);
   }

   public Object remove(String var1) {
      return this.alh.remove(var1);
   }

   public int size() {
      return this.alh.size();
   }

   public Bundle toBundle() {
      Bundle var1 = new Bundle();
      Iterator var2 = this.alh.keySet().iterator();

      while(var2.hasNext()) {
         String var3 = (String)var2.next();
         method_4123(var1, var3, this.alh.get(var3));
      }

      return var1;
   }

   public byte[] toByteArray() {
      return class_246.method_1720(class_607.method_3577(this).amm);
   }

   public String toString() {
      return this.alh.toString();
   }
}
