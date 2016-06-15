package com.google.android.gms.games.quest;

import android.os.Parcelable;
import com.google.android.gms.common.data.Freezable;

public interface Milestone extends Parcelable, Freezable<Milestone> {
   int STATE_CLAIMED = 4;
   int STATE_COMPLETED_NOT_CLAIMED = 3;
   int STATE_NOT_COMPLETED = 2;
   int STATE_NOT_STARTED = 1;
   long UNSET_CRITERIA = -1L;

   byte[] getCompletionRewardData();

   long getCurrentProgress();

   String getEventId();

   String getMilestoneId();

   int getState();

   long getTargetProgress();
}
