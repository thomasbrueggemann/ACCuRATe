package com.google.android.gms.games.quest;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.g;
import com.google.android.gms.games.quest.Quest;
import com.google.android.gms.games.quest.QuestRef;

public final class QuestBuffer extends g<Quest> {
    public QuestBuffer(DataHolder var1) {
        super(var1);
    }

    // $FF: renamed from: f (int, int) java.lang.Object
    // $FF: synthetic method
    protected Object method_2903(int var1, int var2) {
        return this.method_2908(var1, var2);
    }

    // $FF: renamed from: gD () java.lang.String
    protected String method_2904() {
        return "external_quest_id";
    }

    // $FF: renamed from: m (int, int) com.google.android.gms.games.quest.Quest
    protected Quest method_2908(int var1, int var2) {
        return new QuestRef(this.II, var1, var2);
    }
}
