package com.google.android.gms.appstate;

import com.google.android.gms.appstate.AppState;
import com.google.android.gms.appstate.class_670;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.class_251;

// $FF: renamed from: com.google.android.gms.appstate.b
public final class class_258 extends class_251 implements AppState {
   class_258(DataHolder var1, int var2) {
      super(var1, var2);
   }

   public boolean equals(Object var1) {
      return class_670.method_3809(this, var1);
   }

   // $FF: renamed from: fJ () com.google.android.gms.appstate.AppState
   public AppState method_1684() {
      return new class_670(this);
   }

   // $FF: synthetic method
   public Object freeze() {
      return this.method_1684();
   }

   public byte[] getConflictData() {
      return this.getByteArray("conflict_data");
   }

   public String getConflictVersion() {
      return this.getString("conflict_version");
   }

   public int getKey() {
      return this.getInteger("key");
   }

   public byte[] getLocalData() {
      return this.getByteArray("local_data");
   }

   public String getLocalVersion() {
      return this.getString("local_version");
   }

   public boolean hasConflict() {
      return !this.aS("conflict_version");
   }

   public int hashCode() {
      return class_670.method_3808(this);
   }

   public String toString() {
      return class_670.method_3810(this);
   }
}
