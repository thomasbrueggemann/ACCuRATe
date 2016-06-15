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
   protected Object method_2987(int var1, int var2) {
      return this.method_2992(var1, var2);
   }

   // $FF: renamed from: ha () java.lang.String
   protected String method_2988() {
      return "external_quest_id";
   }

   // $FF: renamed from: n (int, int) com.google.android.gms.games.quest.Quest
   protected Quest method_2992(int var1, int var2) {
      return new QuestRef(this.JG, var1, var2);
   }
}
