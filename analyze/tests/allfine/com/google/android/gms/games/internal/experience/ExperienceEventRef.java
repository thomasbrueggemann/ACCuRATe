package com.google.android.gms.games.internal.experience;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.class_255;
import com.google.android.gms.games.GameRef;
import com.google.android.gms.games.internal.experience.ExperienceEvent;

public final class ExperienceEventRef extends class_255 implements ExperienceEvent {
    private final GameRef aax;

    public ExperienceEventRef(DataHolder var1, int var2) {
        super(var1, var2);
        if(this.aS("external_game_id")) {
            this.aax = null;
        } else {
            this.aax = new GameRef(this.II, this.JX);
        }
    }

    public String getIconImageUrl() {
        return this.getString("icon_url");
    }
}
