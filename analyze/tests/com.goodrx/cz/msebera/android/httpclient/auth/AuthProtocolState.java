package cz.msebera.android.httpclient.auth;

public enum AuthProtocolState {
   CHALLENGED,
   FAILURE,
   HANDSHAKE,
   SUCCESS,
   UNCHALLENGED;

   static {
      AuthProtocolState[] var0 = new AuthProtocolState[]{UNCHALLENGED, CHALLENGED, HANDSHAKE, FAILURE, SUCCESS};
   }
}
