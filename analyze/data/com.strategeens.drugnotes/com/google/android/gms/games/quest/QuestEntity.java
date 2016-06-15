package com.google.android.gms.games.quest;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.quest.Milestone;
import com.google.android.gms.games.quest.MilestoneEntity;
import com.google.android.gms.games.quest.Quest;
import com.google.android.gms.games.quest.QuestEntityCreator;
import com.google.android.gms.internal.class_336;
import com.google.android.gms.internal.class_719;
import java.util.ArrayList;
import java.util.List;

public final class QuestEntity implements SafeParcelable, Quest {
   public static final QuestEntityCreator CREATOR = new QuestEntityCreator();
   // $FF: renamed from: CK int
   private final int field_1809;
   // $FF: renamed from: Gt int
   private final int field_1810;
   // $FF: renamed from: UO java.lang.String
   private final String field_1811;
   // $FF: renamed from: XH long
   private final long field_1812;
   private final GameEntity acs;
   private final String aeK;
   private final long aeL;
   private final Uri aeM;
   private final String aeN;
   private final long aeO;
   private final Uri aeP;
   private final String aeQ;
   private final long aeR;
   private final long aeS;
   private final ArrayList<MilestoneEntity> aeT;
   private final String mName;
   private final int mState;

   QuestEntity(int var1, GameEntity var2, String var3, long var4, Uri var6, String var7, String var8, long var9, long var11, Uri var13, String var14, String var15, long var16, long var18, int var20, int var21, ArrayList<MilestoneEntity> var22) {
      this.field_1809 = var1;
      this.acs = var2;
      this.aeK = var3;
      this.aeL = var4;
      this.aeM = var6;
      this.aeN = var7;
      this.field_1811 = var8;
      this.aeO = var9;
      this.field_1812 = var11;
      this.aeP = var13;
      this.aeQ = var14;
      this.mName = var15;
      this.aeR = var16;
      this.aeS = var18;
      this.mState = var20;
      this.field_1810 = var21;
      this.aeT = var22;
   }

   public QuestEntity(Quest var1) {
      this.field_1809 = 2;
      this.acs = new GameEntity(var1.getGame());
      this.aeK = var1.getQuestId();
      this.aeL = var1.getAcceptedTimestamp();
      this.field_1811 = var1.getDescription();
      this.aeM = var1.getBannerImageUri();
      this.aeN = var1.getBannerImageUrl();
      this.aeO = var1.getEndTimestamp();
      this.aeP = var1.getIconImageUri();
      this.aeQ = var1.getIconImageUrl();
      this.field_1812 = var1.getLastUpdatedTimestamp();
      this.mName = var1.getName();
      this.aeR = var1.method_265();
      this.aeS = var1.getStartTimestamp();
      this.mState = var1.getState();
      this.field_1810 = var1.getType();
      List var2 = var1.method_264();
      int var3 = var2.size();
      this.aeT = new ArrayList(var3);

      for(int var4 = 0; var4 < var3; ++var4) {
         this.aeT.add((MilestoneEntity)((MilestoneEntity)((Milestone)var2.get(var4)).freeze()));
      }

   }

   // $FF: renamed from: a (com.google.android.gms.games.quest.Quest) int
   static int method_3073(Quest var0) {
      Object[] var1 = new Object[]{var0.getGame(), var0.getQuestId(), Long.valueOf(var0.getAcceptedTimestamp()), var0.getBannerImageUri(), var0.getDescription(), Long.valueOf(var0.getEndTimestamp()), var0.getIconImageUri(), Long.valueOf(var0.getLastUpdatedTimestamp()), var0.method_264(), var0.getName(), Long.valueOf(var0.method_265()), Long.valueOf(var0.getStartTimestamp()), Integer.valueOf(var0.getState())};
      return class_336.hashCode(var1);
   }

   // $FF: renamed from: a (com.google.android.gms.games.quest.Quest, java.lang.Object) boolean
   static boolean method_3074(Quest var0, Object var1) {
      boolean var2 = true;
      if(!(var1 instanceof Quest)) {
         var2 = false;
      } else if(var0 != var1) {
         Quest var3 = (Quest)var1;
         if(!class_336.equal(var3.getGame(), var0.getGame()) || !class_336.equal(var3.getQuestId(), var0.getQuestId()) || !class_336.equal(Long.valueOf(var3.getAcceptedTimestamp()), Long.valueOf(var0.getAcceptedTimestamp())) || !class_336.equal(var3.getBannerImageUri(), var0.getBannerImageUri()) || !class_336.equal(var3.getDescription(), var0.getDescription()) || !class_336.equal(Long.valueOf(var3.getEndTimestamp()), Long.valueOf(var0.getEndTimestamp())) || !class_336.equal(var3.getIconImageUri(), var0.getIconImageUri()) || !class_336.equal(Long.valueOf(var3.getLastUpdatedTimestamp()), Long.valueOf(var0.getLastUpdatedTimestamp())) || !class_336.equal(var3.method_264(), var0.method_264()) || !class_336.equal(var3.getName(), var0.getName()) || !class_336.equal(Long.valueOf(var3.method_265()), Long.valueOf(var0.method_265())) || !class_336.equal(Long.valueOf(var3.getStartTimestamp()), Long.valueOf(var0.getStartTimestamp())) || !class_336.equal(Integer.valueOf(var3.getState()), Integer.valueOf(var0.getState()))) {
            return false;
         }
      }

      return var2;
   }

   // $FF: renamed from: b (com.google.android.gms.games.quest.Quest) java.lang.String
   static String method_3075(Quest var0) {
      return class_336.method_2312(var0).method_3424("Game", var0.getGame()).method_3424("QuestId", var0.getQuestId()).method_3424("AcceptedTimestamp", Long.valueOf(var0.getAcceptedTimestamp())).method_3424("BannerImageUri", var0.getBannerImageUri()).method_3424("BannerImageUrl", var0.getBannerImageUrl()).method_3424("Description", var0.getDescription()).method_3424("EndTimestamp", Long.valueOf(var0.getEndTimestamp())).method_3424("IconImageUri", var0.getIconImageUri()).method_3424("IconImageUrl", var0.getIconImageUrl()).method_3424("LastUpdatedTimestamp", Long.valueOf(var0.getLastUpdatedTimestamp())).method_3424("Milestones", var0.method_264()).method_3424("Name", var0.getName()).method_3424("NotifyTimestamp", Long.valueOf(var0.method_265())).method_3424("StartTimestamp", Long.valueOf(var0.getStartTimestamp())).method_3424("State", Integer.valueOf(var0.getState())).toString();
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return method_3074(this, var1);
   }

   public Quest freeze() {
      return this;
   }

   public long getAcceptedTimestamp() {
      return this.aeL;
   }

   public Uri getBannerImageUri() {
      return this.aeM;
   }

   public String getBannerImageUrl() {
      return this.aeN;
   }

   public Milestone getCurrentMilestone() {
      return (Milestone)this.method_264().get(0);
   }

   public String getDescription() {
      return this.field_1811;
   }

   public void getDescription(CharArrayBuffer var1) {
      class_719.method_4197(this.field_1811, var1);
   }

   public long getEndTimestamp() {
      return this.aeO;
   }

   public Game getGame() {
      return this.acs;
   }

   public Uri getIconImageUri() {
      return this.aeP;
   }

   public String getIconImageUrl() {
      return this.aeQ;
   }

   public long getLastUpdatedTimestamp() {
      return this.field_1812;
   }

   public String getName() {
      return this.mName;
   }

   public void getName(CharArrayBuffer var1) {
      class_719.method_4197(this.mName, var1);
   }

   public String getQuestId() {
      return this.aeK;
   }

   public long getStartTimestamp() {
      return this.aeS;
   }

   public int getState() {
      return this.mState;
   }

   public int getType() {
      return this.field_1810;
   }

   public int getVersionCode() {
      return this.field_1809;
   }

   public int hashCode() {
      return method_3073(this);
   }

   public boolean isDataValid() {
      return true;
   }

   public boolean isEndingSoon() {
      return this.aeR <= 1800000L + System.currentTimeMillis();
   }

   // $FF: renamed from: mQ () java.util.List
   public List<Milestone> method_264() {
      return new ArrayList(this.aeT);
   }

   // $FF: renamed from: mR () long
   public long method_265() {
      return this.aeR;
   }

   public String toString() {
      return method_3075(this);
   }

   public void writeToParcel(Parcel var1, int var2) {
      QuestEntityCreator.method_4155(this, var1, var2);
   }
}
