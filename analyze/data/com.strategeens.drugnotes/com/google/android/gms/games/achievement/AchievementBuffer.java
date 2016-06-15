package com.google.android.gms.games.achievement;

import com.google.android.gms.common.data.DataBuffer;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.achievement.Achievement;
import com.google.android.gms.games.achievement.AchievementRef;

public final class AchievementBuffer extends DataBuffer<Achievement> {
   public AchievementBuffer(DataHolder var1) {
      super(var1);
   }

   public Achievement get(int var1) {
      return new AchievementRef(this.JG, var1);
   }
}
