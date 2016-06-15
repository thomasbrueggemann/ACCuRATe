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
import com.google.android.gms.internal.class_284;
import com.google.android.gms.internal.class_349;
import java.util.ArrayList;
import java.util.List;

public final class QuestEntity implements SafeParcelable, Quest {
   public static final QuestEntityCreator CREATOR = new QuestEntityCreator();
   // $FF: renamed from: AQ int
   private final int field_2112;
   // $FF: renamed from: Mm java.lang.String
   private final String field_2113;
   // $FF: renamed from: Rq com.google.android.gms.games.GameEntity
   private final GameEntity field_2114;
   // $FF: renamed from: TM java.lang.String
   private final String field_2115;
   // $FF: renamed from: TN long
   private final long field_2116;
   // $FF: renamed from: TO android.net.Uri
   private final Uri field_2117;
   // $FF: renamed from: TP java.lang.String
   private final String field_2118;
   // $FF: renamed from: TQ long
   private final long field_2119;
   // $FF: renamed from: TR android.net.Uri
   private final Uri field_2120;
   // $FF: renamed from: TS java.lang.String
   private final String field_2121;
   // $FF: renamed from: TT long
   private final long field_2122;
   // $FF: renamed from: TU long
   private final long field_2123;
   // $FF: renamed from: TV java.util.ArrayList
   private final ArrayList<MilestoneEntity> field_2124;
   // $FF: renamed from: Ty long
   private final long field_2125;
   private final String mName;
   private final int mState;
   // $FF: renamed from: xJ int
   private final int field_2126;

   QuestEntity(int var1, GameEntity var2, String var3, long var4, Uri var6, String var7, String var8, long var9, long var11, Uri var13, String var14, String var15, long var16, long var18, int var20, int var21, ArrayList<MilestoneEntity> var22) {
      this.field_2126 = var1;
      this.field_2114 = var2;
      this.field_2115 = var3;
      this.field_2116 = var4;
      this.field_2117 = var6;
      this.field_2118 = var7;
      this.field_2113 = var8;
      this.field_2119 = var9;
      this.field_2125 = var11;
      this.field_2120 = var13;
      this.field_2121 = var14;
      this.mName = var15;
      this.field_2122 = var16;
      this.field_2123 = var18;
      this.mState = var20;
      this.field_2112 = var21;
      this.field_2124 = var22;
   }

   public QuestEntity(Quest var1) {
      this.field_2126 = 2;
      this.field_2114 = new GameEntity(var1.getGame());
      this.field_2115 = var1.getQuestId();
      this.field_2116 = var1.getAcceptedTimestamp();
      this.field_2113 = var1.getDescription();
      this.field_2117 = var1.getBannerImageUri();
      this.field_2118 = var1.getBannerImageUrl();
      this.field_2119 = var1.getEndTimestamp();
      this.field_2120 = var1.getIconImageUri();
      this.field_2121 = var1.getIconImageUrl();
      this.field_2125 = var1.getLastUpdatedTimestamp();
      this.mName = var1.getName();
      this.field_2122 = var1.method_235();
      this.field_2123 = var1.getStartTimestamp();
      this.mState = var1.getState();
      this.field_2112 = var1.getType();
      List var2 = var1.method_234();
      int var3 = var2.size();
      this.field_2124 = new ArrayList(var3);

      for(int var4 = 0; var4 < var3; ++var4) {
         this.field_2124.add((MilestoneEntity)((MilestoneEntity)((Milestone)var2.get(var4)).freeze()));
      }

   }

   // $FF: renamed from: a (com.google.android.gms.games.quest.Quest) int
   static int method_2704(Quest var0) {
      Object[] var1 = new Object[]{var0.getGame(), var0.getQuestId(), Long.valueOf(var0.getAcceptedTimestamp()), var0.getBannerImageUri(), var0.getDescription(), Long.valueOf(var0.getEndTimestamp()), var0.getIconImageUri(), Long.valueOf(var0.getLastUpdatedTimestamp()), var0.method_234(), var0.getName(), Long.valueOf(var0.method_235()), Long.valueOf(var0.getStartTimestamp()), Integer.valueOf(var0.getState())};
      return class_349.hashCode(var1);
   }

   // $FF: renamed from: a (com.google.android.gms.games.quest.Quest, java.lang.Object) boolean
   static boolean method_2705(Quest var0, Object var1) {
      boolean var2 = true;
      if(!(var1 instanceof Quest)) {
         var2 = false;
      } else if(var0 != var1) {
         Quest var3 = (Quest)var1;
         if(!class_349.equal(var3.getGame(), var0.getGame()) || !class_349.equal(var3.getQuestId(), var0.getQuestId()) || !class_349.equal(Long.valueOf(var3.getAcceptedTimestamp()), Long.valueOf(var0.getAcceptedTimestamp())) || !class_349.equal(var3.getBannerImageUri(), var0.getBannerImageUri()) || !class_349.equal(var3.getDescription(), var0.getDescription()) || !class_349.equal(Long.valueOf(var3.getEndTimestamp()), Long.valueOf(var0.getEndTimestamp())) || !class_349.equal(var3.getIconImageUri(), var0.getIconImageUri()) || !class_349.equal(Long.valueOf(var3.getLastUpdatedTimestamp()), Long.valueOf(var0.getLastUpdatedTimestamp())) || !class_349.equal(var3.method_234(), var0.method_234()) || !class_349.equal(var3.getName(), var0.getName()) || !class_349.equal(Long.valueOf(var3.method_235()), Long.valueOf(var0.method_235())) || !class_349.equal(Long.valueOf(var3.getStartTimestamp()), Long.valueOf(var0.getStartTimestamp())) || !class_349.equal(Integer.valueOf(var3.getState()), Integer.valueOf(var0.getState()))) {
            return false;
         }
      }

      return var2;
   }

   // $FF: renamed from: b (com.google.android.gms.games.quest.Quest) java.lang.String
   static String method_2706(Quest var0) {
      return class_349.method_2174(var0).method_4301("Game", var0.getGame()).method_4301("QuestId", var0.getQuestId()).method_4301("AcceptedTimestamp", Long.valueOf(var0.getAcceptedTimestamp())).method_4301("BannerImageUri", var0.getBannerImageUri()).method_4301("BannerImageUrl", var0.getBannerImageUrl()).method_4301("Description", var0.getDescription()).method_4301("EndTimestamp", Long.valueOf(var0.getEndTimestamp())).method_4301("IconImageUri", var0.getIconImageUri()).method_4301("IconImageUrl", var0.getIconImageUrl()).method_4301("LastUpdatedTimestamp", Long.valueOf(var0.getLastUpdatedTimestamp())).method_4301("Milestones", var0.method_234()).method_4301("Name", var0.getName()).method_4301("NotifyTimestamp", Long.valueOf(var0.method_235())).method_4301("StartTimestamp", Long.valueOf(var0.getStartTimestamp())).method_4301("State", Integer.valueOf(var0.getState())).toString();
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return method_2705(this, var1);
   }

   public Quest freeze() {
      return this;
   }

   public long getAcceptedTimestamp() {
      return this.field_2116;
   }

   public Uri getBannerImageUri() {
      return this.field_2117;
   }

   public String getBannerImageUrl() {
      return this.field_2118;
   }

   public Milestone getCurrentMilestone() {
      return (Milestone)this.method_234().get(0);
   }

   public String getDescription() {
      return this.field_2113;
   }

   public void getDescription(CharArrayBuffer var1) {
      class_284.method_1876(this.field_2113, var1);
   }

   public long getEndTimestamp() {
      return this.field_2119;
   }

   public Game getGame() {
      return this.field_2114;
   }

   public Uri getIconImageUri() {
      return this.field_2120;
   }

   public String getIconImageUrl() {
      return this.field_2121;
   }

   public long getLastUpdatedTimestamp() {
      return this.field_2125;
   }

   public String getName() {
      return this.mName;
   }

   public void getName(CharArrayBuffer var1) {
      class_284.method_1876(this.mName, var1);
   }

   public String getQuestId() {
      return this.field_2115;
   }

   public long getStartTimestamp() {
      return this.field_2123;
   }

   public int getState() {
      return this.mState;
   }

   public int getType() {
      return this.field_2112;
   }

   public int getVersionCode() {
      return this.field_2126;
   }

   public int hashCode() {
      return method_2704(this);
   }

   // $FF: renamed from: iE () java.util.List
   public List<Milestone> method_234() {
      return new ArrayList(this.field_2124);
   }

   // $FF: renamed from: iF () long
   public long method_235() {
      return this.field_2122;
   }

   public boolean isDataValid() {
      return true;
   }

   public boolean isEndingSoon() {
      return this.field_2122 <= 1800000L + System.currentTimeMillis();
   }

   public String toString() {
      return method_2706(this);
   }

   public void writeToParcel(Parcel var1, int var2) {
      QuestEntityCreator.method_3466(this, var1, var2);
   }
}
