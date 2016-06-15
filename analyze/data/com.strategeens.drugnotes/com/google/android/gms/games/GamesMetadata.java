package com.google.android.gms.games;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameBuffer;

public interface GamesMetadata {
   Game getCurrentGame(GoogleApiClient var1);

   PendingResult<GamesMetadata.LoadGamesResult> loadGame(GoogleApiClient var1);

   public interface LoadExtendedGamesResult extends Releasable, Result {
   }

   public interface LoadGameInstancesResult extends Releasable, Result {
   }

   public interface LoadGameSearchSuggestionsResult extends Releasable, Result {
   }

   public interface LoadGamesResult extends Releasable, Result {
      GameBuffer getGames();
   }
}
