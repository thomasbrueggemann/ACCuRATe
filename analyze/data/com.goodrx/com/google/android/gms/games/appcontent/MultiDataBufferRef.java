package com.google.android.gms.games.appcontent;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzc;
import java.util.ArrayList;

public abstract class MultiDataBufferRef extends zzc {
   protected final ArrayList<DataHolder> zzaDN;

   protected MultiDataBufferRef(ArrayList<DataHolder> var1, int var2, int var3) {
      super((DataHolder)var1.get(var2), var3);
      this.zzaDN = var1;
   }
}
