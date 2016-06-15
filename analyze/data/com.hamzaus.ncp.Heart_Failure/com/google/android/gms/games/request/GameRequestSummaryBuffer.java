package com.google.android.gms.games.request;

import com.google.android.gms.common.data.DataBuffer;
import com.google.android.gms.games.request.GameRequestSummary;
import com.google.android.gms.games.request.GameRequestSummaryRef;

public final class GameRequestSummaryBuffer extends DataBuffer<GameRequestSummary> {
   // $FF: renamed from: cB (int) com.google.android.gms.games.request.GameRequestSummary
   public GameRequestSummary method_2621(int var1) {
      return new GameRequestSummaryRef(this.DD, var1);
   }

   // $FF: synthetic method
   public Object get(int var1) {
      return this.method_2621(var1);
   }
}
