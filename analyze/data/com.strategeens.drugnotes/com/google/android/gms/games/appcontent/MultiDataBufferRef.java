package com.google.android.gms.games.appcontent;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.class_251;
import java.util.ArrayList;

public abstract class MultiDataBufferRef extends class_251 {
   // $FF: renamed from: XX java.util.ArrayList
   protected final ArrayList<DataHolder> field_540;

   protected MultiDataBufferRef(ArrayList<DataHolder> var1, int var2, int var3) {
      super((DataHolder)var1.get(var2), var3);
      this.field_540 = var1;
   }
}
