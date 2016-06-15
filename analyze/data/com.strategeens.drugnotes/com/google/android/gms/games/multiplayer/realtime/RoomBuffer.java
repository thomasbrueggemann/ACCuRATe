package com.google.android.gms.games.multiplayer.realtime;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.g;
import com.google.android.gms.games.multiplayer.realtime.Room;
import com.google.android.gms.games.multiplayer.realtime.RoomRef;

public final class RoomBuffer extends g<Room> {
   public RoomBuffer(DataHolder var1) {
      super(var1);
   }

   // $FF: renamed from: f (int, int) java.lang.Object
   // $FF: synthetic method
   protected Object method_2987(int var1, int var2) {
      return this.method_2997(var1, var2);
   }

   // $FF: renamed from: ha () java.lang.String
   protected String method_2988() {
      return "external_match_id";
   }

   // $FF: renamed from: l (int, int) com.google.android.gms.games.multiplayer.realtime.Room
   protected Room method_2997(int var1, int var2) {
      return new RoomRef(this.JG, var1, var2);
   }
}
