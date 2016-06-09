package com.google.android.gms.games.internal;

import com.google.android.gms.common.internal.DowngradeableSafeParcel;
import com.google.android.gms.internal.zzmw;

public abstract class GamesDowngradeableSafeParcel extends DowngradeableSafeParcel {
   protected static boolean zzd(Integer var0) {
      return var0 == null?false:zzmw.zzcn(var0.intValue());
   }
}
