package com.google.android.gms.appstate;

import com.google.android.gms.appstate.AppState;
import com.google.android.gms.appstate.class_569;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.class_206;

// $FF: renamed from: com.google.android.gms.appstate.b
public final class class_212 extends class_206 implements AppState {
   class_212(DataHolder var1, int var2) {
      super(var1, var2);
   }

   // $FF: renamed from: dN () com.google.android.gms.appstate.AppState
   public AppState method_1377() {
      return new class_569(this);
   }

   public boolean equals(Object var1) {
      return class_569.method_3179(this, var1);
   }

   // $FF: synthetic method
   public Object freeze() {
      return this.method_1377();
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
      return !this.ax("conflict_version");
   }

   public int hashCode() {
      return class_569.method_3178(this);
   }

   public String toString() {
      return class_569.method_3180(this);
   }
}
