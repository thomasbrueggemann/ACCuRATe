package com.google.android.gms.games.event;

import com.google.android.gms.common.data.DataBuffer;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.event.Event;
import com.google.android.gms.games.event.EventRef;

public final class EventBuffer extends DataBuffer<Event> {
   public EventBuffer(DataHolder var1) {
      super(var1);
   }

   public Event get(int var1) {
      return new EventRef(this.JG, var1);
   }
}
