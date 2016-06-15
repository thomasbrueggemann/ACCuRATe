package com.google.android.gms.games.internal.experience;

import com.google.android.gms.common.data.DataBuffer;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.internal.experience.ExperienceEvent;
import com.google.android.gms.games.internal.experience.ExperienceEventRef;

public final class ExperienceEventBuffer extends DataBuffer<ExperienceEvent> {
   public ExperienceEventBuffer(DataHolder var1) {
      super(var1);
   }

   // $FF: renamed from: cn (int) com.google.android.gms.games.internal.experience.ExperienceEvent
   public ExperienceEvent method_2619(int var1) {
      return new ExperienceEventRef(this.DD, var1);
   }

   // $FF: synthetic method
   public Object get(int var1) {
      return this.method_2619(var1);
   }
}
