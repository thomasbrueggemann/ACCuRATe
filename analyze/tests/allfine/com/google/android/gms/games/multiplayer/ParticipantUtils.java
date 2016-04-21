package com.google.android.gms.games.multiplayer;

import com.google.android.gms.common.internal.class_1090;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.multiplayer.Participant;
import java.util.ArrayList;

public final class ParticipantUtils {
    // $FF: renamed from: bV (java.lang.String) boolean
    public static boolean method_4388(String var0) {
        class_1090.method_5681(var0, "Participant ID must not be null");
        return var0.startsWith("p_");
    }

    public static String getParticipantId(ArrayList<Participant> var0, String var1) {
        int var2 = var0.size();

        for(int var3 = 0; var3 < var2; ++var3) {
            Participant var4 = (Participant)var0.get(var3);
            Player var5 = var4.getPlayer();
            if(var5 != null && var5.getPlayerId().equals(var1)) {
                return var4.getParticipantId();
            }
        }

        return null;
    }
}
