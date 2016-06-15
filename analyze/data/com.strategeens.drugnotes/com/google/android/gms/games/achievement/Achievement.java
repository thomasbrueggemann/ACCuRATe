package com.google.android.gms.games.achievement;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcelable;
import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.games.Player;

public interface Achievement extends Parcelable, Freezable<Achievement> {
   int STATE_HIDDEN = 2;
   int STATE_REVEALED = 1;
   int STATE_UNLOCKED = 0;
   int TYPE_INCREMENTAL = 1;
   int TYPE_STANDARD;

   String getAchievementId();

   int getCurrentSteps();

   String getDescription();

   void getDescription(CharArrayBuffer var1);

   String getFormattedCurrentSteps();

   void getFormattedCurrentSteps(CharArrayBuffer var1);

   String getFormattedTotalSteps();

   void getFormattedTotalSteps(CharArrayBuffer var1);

   long getLastUpdatedTimestamp();

   String getName();

   void getName(CharArrayBuffer var1);

   Player getPlayer();

   Uri getRevealedImageUri();

   @Deprecated
   String getRevealedImageUrl();

   int getState();

   int getTotalSteps();

   int getType();

   Uri getUnlockedImageUri();

   @Deprecated
   String getUnlockedImageUrl();

   long getXpValue();
}
