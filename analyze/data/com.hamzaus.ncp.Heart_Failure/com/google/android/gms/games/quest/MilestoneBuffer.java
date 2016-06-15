package com.google.android.gms.games.quest;

import com.google.android.gms.common.data.DataBuffer;
import com.google.android.gms.games.quest.Milestone;
import com.google.android.gms.games.quest.MilestoneRef;

public final class MilestoneBuffer extends DataBuffer<Milestone> {
   public Milestone get(int var1) {
      return new MilestoneRef(this.DD, var1);
   }
}
