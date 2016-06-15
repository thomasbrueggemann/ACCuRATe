package com.google.android.gms.games.quest;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.quest.Milestone;
import com.google.android.gms.games.quest.MilestoneEntityCreator;
import com.google.android.gms.internal.class_336;

public final class MilestoneEntity implements SafeParcelable, Milestone {
   public static final MilestoneEntityCreator CREATOR = new MilestoneEntityCreator();
   // $FF: renamed from: CK int
   private final int field_3571;
   // $FF: renamed from: Ye java.lang.String
   private final String field_3572;
   // $FF: renamed from: Zn java.lang.String
   private final String field_3573;
   private final long aeH;
   private final long aeI;
   private final byte[] aeJ;
   private final int mState;

   MilestoneEntity(int var1, String var2, long var3, long var5, byte[] var7, int var8, String var9) {
      this.field_3571 = var1;
      this.field_3573 = var2;
      this.aeH = var3;
      this.aeI = var5;
      this.aeJ = var7;
      this.mState = var8;
      this.field_3572 = var9;
   }

   public MilestoneEntity(Milestone var1) {
      this.field_3571 = 4;
      this.field_3573 = var1.getMilestoneId();
      this.aeH = var1.getCurrentProgress();
      this.aeI = var1.getTargetProgress();
      this.mState = var1.getState();
      this.field_3572 = var1.getEventId();
      byte[] var2 = var1.getCompletionRewardData();
      if(var2 == null) {
         this.aeJ = null;
      } else {
         this.aeJ = new byte[var2.length];
         System.arraycopy(var2, 0, this.aeJ, 0, var2.length);
      }
   }

   // $FF: renamed from: a (com.google.android.gms.games.quest.Milestone) int
   static int method_4745(Milestone var0) {
      Object[] var1 = new Object[]{var0.getMilestoneId(), Long.valueOf(var0.getCurrentProgress()), Long.valueOf(var0.getTargetProgress()), Integer.valueOf(var0.getState()), var0.getEventId()};
      return class_336.hashCode(var1);
   }

   // $FF: renamed from: a (com.google.android.gms.games.quest.Milestone, java.lang.Object) boolean
   static boolean method_4746(Milestone var0, Object var1) {
      boolean var2 = true;
      if(!(var1 instanceof Milestone)) {
         var2 = false;
      } else if(var0 != var1) {
         Milestone var3 = (Milestone)var1;
         if(!class_336.equal(var3.getMilestoneId(), var0.getMilestoneId()) || !class_336.equal(Long.valueOf(var3.getCurrentProgress()), Long.valueOf(var0.getCurrentProgress())) || !class_336.equal(Long.valueOf(var3.getTargetProgress()), Long.valueOf(var0.getTargetProgress())) || !class_336.equal(Integer.valueOf(var3.getState()), Integer.valueOf(var0.getState())) || !class_336.equal(var3.getEventId(), var0.getEventId())) {
            return false;
         }
      }

      return var2;
   }

   // $FF: renamed from: b (com.google.android.gms.games.quest.Milestone) java.lang.String
   static String method_4747(Milestone var0) {
      return class_336.method_2312(var0).method_3424("MilestoneId", var0.getMilestoneId()).method_3424("CurrentProgress", Long.valueOf(var0.getCurrentProgress())).method_3424("TargetProgress", Long.valueOf(var0.getTargetProgress())).method_3424("State", Integer.valueOf(var0.getState())).method_3424("CompletionRewardData", var0.getCompletionRewardData()).method_3424("EventId", var0.getEventId()).toString();
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return method_4746(this, var1);
   }

   public Milestone freeze() {
      return this;
   }

   public byte[] getCompletionRewardData() {
      return this.aeJ;
   }

   public long getCurrentProgress() {
      return this.aeH;
   }

   public String getEventId() {
      return this.field_3572;
   }

   public String getMilestoneId() {
      return this.field_3573;
   }

   public int getState() {
      return this.mState;
   }

   public long getTargetProgress() {
      return this.aeI;
   }

   public int getVersionCode() {
      return this.field_3571;
   }

   public int hashCode() {
      return method_4745(this);
   }

   public boolean isDataValid() {
      return true;
   }

   public String toString() {
      return method_4747(this);
   }

   public void writeToParcel(Parcel var1, int var2) {
      MilestoneEntityCreator.method_4102(this, var1, var2);
   }
}
