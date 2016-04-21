package com.google.android.gms.games.multiplayer;

import com.google.android.gms.common.data.DataBuffer;
import com.google.android.gms.games.multiplayer.Participant;
import com.google.android.gms.games.multiplayer.ParticipantRef;

public final class ParticipantBuffer extends DataBuffer<Participant> {
    public Participant get(int var1) {
        return new ParticipantRef(this.II, var1);
    }
}
