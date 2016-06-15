package com.google.android.gms.games.quest;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.class_206;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameRef;
import com.google.android.gms.games.quest.Milestone;
import com.google.android.gms.games.quest.MilestoneRef;
import com.google.android.gms.games.quest.Quest;
import com.google.android.gms.games.quest.QuestEntity;
import java.util.ArrayList;
import java.util.List;

public final class QuestRef extends class_206 implements Quest {
   // $FF: renamed from: RD int
   private final int field_684;
   // $FF: renamed from: Sp com.google.android.gms.games.Game
   private final Game field_685;

   QuestRef(DataHolder var1, int var2, int var3) {
      super(var1, var2);
      this.field_685 = new GameRef(var1, var2);
      this.field_684 = var3;
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return QuestEntity.method_2705(this, var1);
   }

   public Quest freeze() {
      return new QuestEntity(this);
   }

   public long getAcceptedTimestamp() {
      return this.getLong("accepted_ts");
   }

   public Uri getBannerImageUri() {
      return this.aw("quest_banner_image_uri");
   }

   public String getBannerImageUrl() {
      return this.getString("quest_banner_image_url");
   }

   public Milestone getCurrentMilestone() {
      return (Milestone)this.method_234().get(0);
   }

   public String getDescription() {
      return this.getString("quest_description");
   }

   public void getDescription(CharArrayBuffer var1) {
      this.a("quest_description", var1);
   }

   public long getEndTimestamp() {
      return this.getLong("quest_end_ts");
   }

   public Game getGame() {
      return this.field_685;
   }

   public Uri getIconImageUri() {
      return this.aw("quest_icon_image_uri");
   }

   public String getIconImageUrl() {
      return this.getString("quest_icon_image_url");
   }

   public long getLastUpdatedTimestamp() {
      return this.getLong("quest_last_updated_ts");
   }

   public String getName() {
      return this.getString("quest_name");
   }

   public void getName(CharArrayBuffer var1) {
      this.a("quest_name", var1);
   }

   public String getQuestId() {
      return this.getString("external_quest_id");
   }

   public long getStartTimestamp() {
      return this.getLong("quest_start_ts");
   }

   public int getState() {
      return this.getInteger("quest_state");
   }

   public int getType() {
      return this.getInteger("quest_type");
   }

   public int hashCode() {
      return QuestEntity.method_2704(this);
   }

   // $FF: renamed from: iE () java.util.List
   public List<Milestone> method_234() {
      ArrayList var1 = new ArrayList(this.field_684);

      for(int var2 = 0; var2 < this.field_684; ++var2) {
         var1.add(new MilestoneRef(this.DD, var2 + this.Ez));
      }

      return var1;
   }

   // $FF: renamed from: iF () long
   public long method_235() {
      return this.getLong("notification_ts");
   }

   public boolean isEndingSoon() {
      return this.method_235() <= 1800000L + System.currentTimeMillis();
   }

   public String toString() {
      return QuestEntity.method_2706(this);
   }

   public void writeToParcel(Parcel var1, int var2) {
      ((QuestEntity)this.freeze()).writeToParcel(var1, var2);
   }
}
