package com.google.android.gms.games.quest;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.quest.Milestone;
import com.google.android.gms.games.quest.MilestoneEntityCreator;
import com.google.android.gms.internal.class_349;

public final class MilestoneEntity implements SafeParcelable, Milestone {
   public static final MilestoneEntityCreator CREATOR = new MilestoneEntityCreator();
   // $FF: renamed from: Nf java.lang.String
   private final String field_3465;
   // $FF: renamed from: Oq java.lang.String
   private final String field_3466;
   // $FF: renamed from: TJ long
   private final long field_3467;
   // $FF: renamed from: TK long
   private final long field_3468;
   // $FF: renamed from: TL byte[]
   private final byte[] field_3469;
   private final int mState;
   // $FF: renamed from: xJ int
   private final int field_3470;

   MilestoneEntity(int var1, String var2, long var3, long var5, byte[] var7, int var8, String var9) {
      this.field_3470 = var1;
      this.field_3466 = var2;
      this.field_3467 = var3;
      this.field_3468 = var5;
      this.field_3469 = var7;
      this.mState = var8;
      this.field_3465 = var9;
   }

   public MilestoneEntity(Milestone var1) {
      this.field_3470 = 4;
      this.field_3466 = var1.getMilestoneId();
      this.field_3467 = var1.getCurrentProgress();
      this.field_3468 = var1.getTargetProgress();
      this.mState = var1.getState();
      this.field_3465 = var1.getEventId();
      byte[] var2 = var1.getCompletionRewardData();
      if(var2 == null) {
         this.field_3469 = null;
      } else {
         this.field_3469 = new byte[var2.length];
         System.arraycopy(var2, 0, this.field_3469, 0, var2.length);
      }
   }

   // $FF: renamed from: a (com.google.android.gms.games.quest.Milestone) int
   static int method_3799(Milestone var0) {
      Object[] var1 = new Object[]{var0.getMilestoneId(), Long.valueOf(var0.getCurrentProgress()), Long.valueOf(var0.getTargetProgress()), Integer.valueOf(var0.getState()), var0.getEventId()};
      return class_349.hashCode(var1);
   }

   // $FF: renamed from: a (com.google.android.gms.games.quest.Milestone, java.lang.Object) boolean
   static boolean method_3800(Milestone var0, Object var1) {
      boolean var2 = true;
      if(!(var1 instanceof Milestone)) {
         var2 = false;
      } else if(var0 != var1) {
         Milestone var3 = (Milestone)var1;
         if(!class_349.equal(var3.getMilestoneId(), var0.getMilestoneId()) || !class_349.equal(Long.valueOf(var3.getCurrentProgress()), Long.valueOf(var0.getCurrentProgress())) || !class_349.equal(Long.valueOf(var3.getTargetProgress()), Long.valueOf(var0.getTargetProgress())) || !class_349.equal(Integer.valueOf(var3.getState()), Integer.valueOf(var0.getState())) || !class_349.equal(var3.getEventId(), var0.getEventId())) {
            return false;
         }
      }

      return var2;
   }

   // $FF: renamed from: b (com.google.android.gms.games.quest.Milestone) java.lang.String
   static String method_3801(Milestone var0) {
      return class_349.method_2174(var0).method_4301("MilestoneId", var0.getMilestoneId()).method_4301("CurrentProgress", Long.valueOf(var0.getCurrentProgress())).method_4301("TargetProgress", Long.valueOf(var0.getTargetProgress())).method_4301("State", Integer.valueOf(var0.getState())).method_4301("CompletionRewardData", var0.getCompletionRewardData()).method_4301("EventId", var0.getEventId()).toString();
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return method_3800(this, var1);
   }

   public Milestone freeze() {
      return this;
   }

   public byte[] getCompletionRewardData() {
      return this.field_3469;
   }

   public long getCurrentProgress() {
      return this.field_3467;
   }

   public String getEventId() {
      return this.field_3465;
   }

   public String getMilestoneId() {
      return this.field_3466;
   }

   public int getState() {
      return this.mState;
   }

   public long getTargetProgress() {
      return this.field_3468;
   }

   public int getVersionCode() {
      return this.field_3470;
   }

   public int hashCode() {
      return method_3799(this);
   }

   public boolean isDataValid() {
      return true;
   }

   public String toString() {
      return method_3801(this);
   }

   public void writeToParcel(Parcel var1, int var2) {
      MilestoneEntityCreator.method_3433(this, var1, var2);
   }
}
