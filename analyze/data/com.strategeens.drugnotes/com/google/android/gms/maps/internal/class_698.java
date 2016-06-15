package com.google.android.gms.maps.internal;

// $FF: renamed from: com.google.android.gms.maps.internal.a
public final class class_698 {
   // $FF: renamed from: a (byte) java.lang.Boolean
   public static Boolean method_3999(byte var0) {
      switch(var0) {
      case 0:
         return Boolean.FALSE;
      case 1:
         return Boolean.TRUE;
      default:
         return null;
      }
   }

   // $FF: renamed from: c (java.lang.Boolean) byte
   public static byte method_4000(Boolean var0) {
      return (byte)(var0 != null?(var0.booleanValue()?1:0):-1);
   }
}
