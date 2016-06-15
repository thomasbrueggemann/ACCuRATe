package com.google.android.gms.appstate;

import com.google.android.gms.appstate.AppState;
import com.google.android.gms.internal.class_336;

// $FF: renamed from: com.google.android.gms.appstate.a
public final class class_670 implements AppState {
   // $FF: renamed from: DK int
   private final int field_2900;
   // $FF: renamed from: DL java.lang.String
   private final String field_2901;
   // $FF: renamed from: DM byte[]
   private final byte[] field_2902;
   // $FF: renamed from: DN boolean
   private final boolean field_2903;
   // $FF: renamed from: DO java.lang.String
   private final String field_2904;
   // $FF: renamed from: DP byte[]
   private final byte[] field_2905;

   public class_670(AppState var1) {
      this.field_2900 = var1.getKey();
      this.field_2901 = var1.getLocalVersion();
      this.field_2902 = var1.getLocalData();
      this.field_2903 = var1.hasConflict();
      this.field_2904 = var1.getConflictVersion();
      this.field_2905 = var1.getConflictData();
   }

   // $FF: renamed from: a (com.google.android.gms.appstate.AppState) int
   static int method_3808(AppState var0) {
      Object[] var1 = new Object[]{Integer.valueOf(var0.getKey()), var0.getLocalVersion(), var0.getLocalData(), Boolean.valueOf(var0.hasConflict()), var0.getConflictVersion(), var0.getConflictData()};
      return class_336.hashCode(var1);
   }

   // $FF: renamed from: a (com.google.android.gms.appstate.AppState, java.lang.Object) boolean
   static boolean method_3809(AppState var0, Object var1) {
      boolean var2 = true;
      if(!(var1 instanceof AppState)) {
         var2 = false;
      } else if(var0 != var1) {
         AppState var3 = (AppState)var1;
         if(!class_336.equal(Integer.valueOf(var3.getKey()), Integer.valueOf(var0.getKey())) || !class_336.equal(var3.getLocalVersion(), var0.getLocalVersion()) || !class_336.equal(var3.getLocalData(), var0.getLocalData()) || !class_336.equal(Boolean.valueOf(var3.hasConflict()), Boolean.valueOf(var0.hasConflict())) || !class_336.equal(var3.getConflictVersion(), var0.getConflictVersion()) || !class_336.equal(var3.getConflictData(), var0.getConflictData())) {
            return false;
         }
      }

      return var2;
   }

   // $FF: renamed from: b (com.google.android.gms.appstate.AppState) java.lang.String
   static String method_3810(AppState var0) {
      return class_336.method_2312(var0).method_3424("Key", Integer.valueOf(var0.getKey())).method_3424("LocalVersion", var0.getLocalVersion()).method_3424("LocalData", var0.getLocalData()).method_3424("HasConflict", Boolean.valueOf(var0.hasConflict())).method_3424("ConflictVersion", var0.getConflictVersion()).method_3424("ConflictData", var0.getConflictData()).toString();
   }

   public boolean equals(Object var1) {
      return method_3809(this, var1);
   }

   // $FF: renamed from: fJ () com.google.android.gms.appstate.AppState
   public AppState method_3811() {
      return this;
   }

   // $FF: synthetic method
   public Object freeze() {
      return this.method_3811();
   }

   public byte[] getConflictData() {
      return this.field_2905;
   }

   public String getConflictVersion() {
      return this.field_2904;
   }

   public int getKey() {
      return this.field_2900;
   }

   public byte[] getLocalData() {
      return this.field_2902;
   }

   public String getLocalVersion() {
      return this.field_2901;
   }

   public boolean hasConflict() {
      return this.field_2903;
   }

   public int hashCode() {
      return method_3808(this);
   }

   public boolean isDataValid() {
      return true;
   }

   public String toString() {
      return method_3810(this);
   }
}
