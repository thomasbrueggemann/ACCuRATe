package com.google.android.gms.games.multiplayer;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.internal.constants.MatchResult;
import com.google.android.gms.games.multiplayer.ParticipantResultCreator;
import com.google.android.gms.internal.class_347;

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
   // $FF: renamed from: On java.lang.String
   private final String field_4299;
   // $FF: renamed from: Tc int
   private final int field_4300;
   // $FF: renamed from: Td int
   private final int field_4301;
   // $FF: renamed from: xJ int
   private final int field_4302;

   public ParticipantResult(int var1, String var2, int var3, int var4) {
      this.field_4302 = var1;
      this.field_4299 = (String)class_347.method_2170(var2);
      class_347.method_2159(MatchResult.isValid(var3));
      this.field_4300 = var3;
      this.field_4301 = var4;
   }

   public ParticipantResult(String var1, int var2, int var3) {
      this(1, var1, var2, var3);
   }

   public int describeContents() {
      return 0;
   }

   public String getParticipantId() {
      return this.field_4299;
   }

   public int getPlacing() {
      return this.field_4301;
   }

   public int getResult() {
      return this.field_4300;
   }

   public int getVersionCode() {
      return this.field_4302;
   }

   public void writeToParcel(Parcel var1, int var2) {
      ParticipantResultCreator.method_2492(this, var1, var2);
   }
}
