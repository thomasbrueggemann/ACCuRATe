package com.google.android.gms.games.quest;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.quest.Milestone;
import com.google.android.gms.games.quest.MilestoneEntityCreator;

public final class MilestoneEntity implements SafeParcelable, Milestone {
   public static final Creator<MilestoneEntity> CREATOR = new MilestoneEntityCreator();
   private final int mState;
   private final int mVersionCode;
   private final String zzaDU;
   private final String zzaFd;
   private final long zzaKt;
   private final long zzaKu;
   private final byte[] zzaKv;

   MilestoneEntity(int var1, String var2, long var3, long var5, byte[] var7, int var8, String var9) {
      this.mVersionCode = var1;
      this.zzaFd = var2;
      this.zzaKt = var3;
      this.zzaKu = var5;
      this.zzaKv = var7;
      this.mState = var8;
      this.zzaDU = var9;
   }

   public MilestoneEntity(Milestone var1) {
      this.mVersionCode = 4;
      this.zzaFd = var1.getMilestoneId();
      this.zzaKt = var1.getCurrentProgress();
      this.zzaKu = var1.getTargetProgress();
      this.mState = var1.getState();
      this.zzaDU = var1.getEventId();
      byte[] var2 = var1.getCompletionRewardData();
      if(var2 == null) {
         this.zzaKv = null;
      } else {
         this.zzaKv = new byte[var2.length];
         System.arraycopy(var2, 0, this.zzaKv, 0, var2.length);
      }
   }

   static int zza(Milestone var0) {
      Object[] var1 = new Object[]{var0.getMilestoneId(), Long.valueOf(var0.getCurrentProgress()), Long.valueOf(var0.getTargetProgress()), Integer.valueOf(var0.getState()), var0.getEventId()};
      return zzw.hashCode(var1);
   }

   static boolean zza(Milestone var0, Object var1) {
      boolean var2 = true;
      if(!(var1 instanceof Milestone)) {
         var2 = false;
      } else if(var0 != var1) {
         Milestone var3 = (Milestone)var1;
         if(!zzw.equal(var3.getMilestoneId(), var0.getMilestoneId()) || !zzw.equal(Long.valueOf(var3.getCurrentProgress()), Long.valueOf(var0.getCurrentProgress())) || !zzw.equal(Long.valueOf(var3.getTargetProgress()), Long.valueOf(var0.getTargetProgress())) || !zzw.equal(Integer.valueOf(var3.getState()), Integer.valueOf(var0.getState())) || !zzw.equal(var3.getEventId(), var0.getEventId())) {
            return false;
         }
      }

      return var2;
   }

   static String zzb(Milestone var0) {
      return zzw.zzy(var0).zzg("MilestoneId", var0.getMilestoneId()).zzg("CurrentProgress", Long.valueOf(var0.getCurrentProgress())).zzg("TargetProgress", Long.valueOf(var0.getTargetProgress())).zzg("State", Integer.valueOf(var0.getState())).zzg("CompletionRewardData", var0.getCompletionRewardData()).zzg("EventId", var0.getEventId()).toString();
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return zza(this, var1);
   }

   public Milestone freeze() {
      return this;
   }

   public byte[] getCompletionRewardData() {
      return this.zzaKv;
   }

   public long getCurrentProgress() {
      return this.zzaKt;
   }

   public String getEventId() {
      return this.zzaDU;
   }

   public String getMilestoneId() {
      return this.zzaFd;
   }

   public int getState() {
      return this.mState;
   }

   public long getTargetProgress() {
      return this.zzaKu;
   }

   public int getVersionCode() {
      return this.mVersionCode;
   }

   public int hashCode() {
      return zza(this);
   }

   public String toString() {
      return zzb(this);
   }

   public void writeToParcel(Parcel var1, int var2) {
      MilestoneEntityCreator.zza(this, var1, var2);
   }
}
