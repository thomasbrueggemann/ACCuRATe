package com.google.android.gms.games.multiplayer;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.internal.constants.MatchResult;
import com.google.android.gms.games.multiplayer.ParticipantResultCreator;
import com.google.android.gms.internal.class_335;

public final class ParticipantResult implements SafeParcelable {
   public static final ParticipantResultCreator CREATOR = new ParticipantResultCreator();
   public static final int MATCH_RESULT_DISAGREED = 5;
   public static final int MATCH_RESULT_DISCONNECT = 4;
   public static final int MATCH_RESULT_LOSS = 1;
   public static final int MATCH_RESULT_NONE = 3;
   public static final int MATCH_RESULT_TIE = 2;
   public static final int MATCH_RESULT_UNINITIALIZED = -1;
   public static final int MATCH_RESULT_WIN = 0;
   public static final int PLACING_UNINITIALIZED = -1;
   // $FF: renamed from: CK int
   private final int field_4452;
   // $FF: renamed from: Zk java.lang.String
   private final String field_4453;
   private final int aec;
   private final int aed;

   public ParticipantResult(int var1, String var2, int var3, int var4) {
      this.field_4452 = var1;
      this.field_4453 = (String)class_335.method_2311(var2);
      class_335.method_2300(MatchResult.isValid(var3));
      this.aec = var3;
      this.aed = var4;
   }

   public ParticipantResult(String var1, int var2, int var3) {
      this(1, var1, var2, var3);
   }

   public int describeContents() {
      return 0;
   }

   public String getParticipantId() {
      return this.field_4453;
   }

   public int getPlacing() {
      return this.aed;
   }

   public int getResult() {
      return this.aec;
   }

   public int getVersionCode() {
      return this.field_4452;
   }

   public void writeToParcel(Parcel var1, int var2) {
      ParticipantResultCreator.method_2885(this, var1, var2);
   }
}
