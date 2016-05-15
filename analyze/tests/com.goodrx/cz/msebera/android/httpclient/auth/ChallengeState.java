package cz.msebera.android.httpclient.auth;

public enum ChallengeState {
   PROXY,
   TARGET;

   static {
      ChallengeState[] var0 = new ChallengeState[]{TARGET, PROXY};
   }
}
