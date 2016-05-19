package com.google.android.gms.games.quest;

import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzc;
import com.google.android.gms.games.internal.GamesLog;
import com.google.android.gms.games.quest.Milestone;
import com.google.android.gms.games.quest.MilestoneEntity;

public final class MilestoneRef extends zzc implements Milestone {
   MilestoneRef(DataHolder var1, int var2) {
      super(var1, var2);
   }

   private long zzxQ() {
      return this.getLong("initial_value");
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return MilestoneEntity.zza(this, var1);
   }

   public Milestone freeze() {
      return new MilestoneEntity(this);
   }

   public byte[] getCompletionRewardData() {
      return this.getByteArray("completion_reward_data");
   }

   public long getCurrentProgress() {
      long var1 = 0L;
      long var3;
      switch(this.getState()) {
      case 1:
         var3 = var1;
         break;
      case 2:
         var3 = this.getLong("current_value");
         if(this.getLong("quest_state") != 6L) {
            var3 -= this.zzxQ();
         }
         break;
      case 3:
      case 4:
         var3 = this.getTargetProgress();
         break;
      default:
         var3 = var1;
      }

      if(var3 < var1) {
         GamesLog.zzA("MilestoneRef", "Current progress should never be negative");
      } else {
         var1 = var3;
      }

      if(var1 > this.getTargetProgress()) {
         GamesLog.zzA("MilestoneRef", "Current progress should never exceed target progress");
         var1 = this.getTargetProgress();
      }

      return var1;
   }

   public String getEventId() {
      return this.getString("external_event_id");
   }

   public String getMilestoneId() {
      return this.getString("external_milestone_id");
   }

   public int getState() {
      return this.getInteger("milestone_state");
   }

   public long getTargetProgress() {
      return this.getLong("target_value");
   }

   public int hashCode() {
      return MilestoneEntity.zza(this);
   }

   public String toString() {
      return MilestoneEntity.zzb(this);
   }

   public void writeToParcel(Parcel var1, int var2) {
      ((MilestoneEntity)this.freeze()).writeToParcel(var1, var2);
   }
}
