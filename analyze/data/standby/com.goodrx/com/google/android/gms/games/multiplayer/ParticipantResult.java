package com.google.android.gms.games.multiplayer;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.internal.constants.MatchResult;
import com.google.android.gms.games.multiplayer.ParticipantResultCreator;

public final class ParticipantResult implements SafeParcelable {
   public static final Creator<ParticipantResult> CREATOR = new ParticipantResultCreator();
   private final int mVersionCode;
   private final String zzaFa;
   private final int zzaJP;
   private final int zzaJQ;

   public ParticipantResult(int var1, String var2, int var3, int var4) {
      this.mVersionCode = var1;
      this.zzaFa = (String)zzx.zzz(var2);
      zzx.zzab(MatchResult.isValid(var3));
      this.zzaJP = var3;
      this.zzaJQ = var4;
   }

   public ParticipantResult(String var1, int var2, int var3) {
      this(1, var1, var2, var3);
   }

   public int describeContents() {
      return 0;
   }

   public String getParticipantId() {
      return this.zzaFa;
   }

   public int getPlacing() {
      return this.zzaJQ;
   }

   public int getResult() {
      return this.zzaJP;
   }

   public int getVersionCode() {
      return this.mVersionCode;
   }

   public void writeToParcel(Parcel var1, int var2) {
      ParticipantResultCreator.zza(this, var1, var2);
   }
}
