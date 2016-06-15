package com.google.android.gms.appstate;

import com.google.android.gms.appstate.AppState;
import com.google.android.gms.internal.class_349;

// $FF: renamed from: com.google.android.gms.appstate.a
public final class class_569 implements AppState {
   // $FF: renamed from: yA byte[]
   private final byte[] field_3003;
   // $FF: renamed from: yB boolean
   private final boolean field_3004;
   // $FF: renamed from: yC java.lang.String
   private final String field_3005;
   // $FF: renamed from: yD byte[]
   private final byte[] field_3006;
   // $FF: renamed from: yy int
   private final int field_3007;
   // $FF: renamed from: yz java.lang.String
   private final String field_3008;

   public class_569(AppState var1) {
      this.field_3007 = var1.getKey();
      this.field_3008 = var1.getLocalVersion();
      this.field_3003 = var1.getLocalData();
      this.field_3004 = var1.hasConflict();
      this.field_3005 = var1.getConflictVersion();
      this.field_3006 = var1.getConflictData();
   }

   // $FF: renamed from: a (com.google.android.gms.appstate.AppState) int
   static int method_3178(AppState var0) {
      Object[] var1 = new Object[]{Integer.valueOf(var0.getKey()), var0.getLocalVersion(), var0.getLocalData(), Boolean.valueOf(var0.hasConflict()), var0.getConflictVersion(), var0.getConflictData()};
      return class_349.hashCode(var1);
   }

   // $FF: renamed from: a (com.google.android.gms.appstate.AppState, java.lang.Object) boolean
   static boolean method_3179(AppState var0, Object var1) {
      boolean var2 = true;
      if(!(var1 instanceof AppState)) {
         var2 = false;
      } else if(var0 != var1) {
         AppState var3 = (AppState)var1;
         if(!class_349.equal(Integer.valueOf(var3.getKey()), Integer.valueOf(var0.getKey())) || !class_349.equal(var3.getLocalVersion(), var0.getLocalVersion()) || !class_349.equal(var3.getLocalData(), var0.getLocalData()) || !class_349.equal(Boolean.valueOf(var3.hasConflict()), Boolean.valueOf(var0.hasConflict())) || !class_349.equal(var3.getConflictVersion(), var0.getConflictVersion()) || !class_349.equal(var3.getConflictData(), var0.getConflictData())) {
            return false;
         }
      }

      return var2;
   }

   // $FF: renamed from: b (com.google.android.gms.appstate.AppState) java.lang.String
   static String method_3180(AppState var0) {
      return class_349.method_2174(var0).method_4301("Key", Integer.valueOf(var0.getKey())).method_4301("LocalVersion", var0.getLocalVersion()).method_4301("LocalData", var0.getLocalData()).method_4301("HasConflict", Boolean.valueOf(var0.hasConflict())).method_4301("ConflictVersion", var0.getConflictVersion()).method_4301("ConflictData", var0.getConflictData()).toString();
   }

   // $FF: renamed from: dN () com.google.android.gms.appstate.AppState
   public AppState method_3181() {
      return this;
   }

   public boolean equals(Object var1) {
      return method_3179(this, var1);
   }

   // $FF: synthetic method
   public Object freeze() {
      return this.method_3181();
   }

   public byte[] getConflictData() {
      return this.field_3006;
   }

   public String getConflictVersion() {
      return this.field_3005;
   }

   public int getKey() {
      return this.field_3007;
   }

   public byte[] getLocalData() {
      return this.field_3003;
   }

   public String getLocalVersion() {
      return this.field_3008;
   }

   public boolean hasConflict() {
      return this.field_3004;
   }

   public int hashCode() {
      return method_3178(this);
   }

   public boolean isDataValid() {
      return true;
   }

   public String toString() {
      return method_3180(this);
   }
}
