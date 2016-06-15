package com.google.android.gms.games.internal.experience;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.class_206;
import com.google.android.gms.games.internal.experience.ExperienceEvent;

public final class ExperienceEventRef extends class_206 implements ExperienceEvent {
   public ExperienceEventRef(DataHolder var1, int var2) {
      super(var1, var2);
   }

   public String getIconImageUrl() {
      return this.getString("icon_url");
   }
}
