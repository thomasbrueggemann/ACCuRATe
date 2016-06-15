package com.google.android.gms.appstate;

import com.google.android.gms.appstate.AppState;
import com.google.android.gms.appstate.class_212;
import com.google.android.gms.common.data.DataBuffer;
import com.google.android.gms.common.data.DataHolder;

public final class AppStateBuffer extends DataBuffer<AppState> {
   public AppStateBuffer(DataHolder var1) {
      super(var1);
   }

   public AppState get(int var1) {
      return new class_212(this.DD, var1);
   }
}
