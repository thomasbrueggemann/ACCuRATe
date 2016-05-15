package com.google.android.gms.games.quest;

import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.zzc;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.quest.Milestone;
import com.google.android.gms.games.quest.MilestoneRef;
import com.google.android.gms.games.quest.Quest;
import com.google.android.gms.games.quest.QuestEntity;
import java.util.ArrayList;
import java.util.List;

public final class QuestRef extends zzc implements Quest {
   private final int zzaDQ;
   private final Game zzaJc;

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return QuestEntity.zza(this, var1);
   }

   public Quest freeze() {
      return new QuestEntity(this);
   }

   public long getAcceptedTimestamp() {
      return this.getLong("accepted_ts");
   }

   public Uri getBannerImageUri() {
      return this.zzcA("quest_banner_image_uri");
   }

   public String getBannerImageUrl() {
      return this.getString("quest_banner_image_url");
   }

   public String getDescription() {
      return this.getString("quest_description");
   }

   public long getEndTimestamp() {
      return this.getLong("quest_end_ts");
   }

   public Game getGame() {
      return this.zzaJc;
   }

   public Uri getIconImageUri() {
      return this.zzcA("quest_icon_image_uri");
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
      return QuestEntity.zza(this);
   }

   public String toString() {
      return QuestEntity.zzb(this);
   }

   public void writeToParcel(Parcel var1, int var2) {
      ((QuestEntity)this.freeze()).writeToParcel(var1, var2);
   }

   public List<Milestone> zzxR() {
      ArrayList var1 = new ArrayList(this.zzaDQ);

      for(int var2 = 0; var2 < this.zzaDQ; ++var2) {
         var1.add(new MilestoneRef(this.zzahi, var2 + this.zzaje));
      }

      return var1;
   }

   public long zzxS() {
      return this.getLong("notification_ts");
   }
}
