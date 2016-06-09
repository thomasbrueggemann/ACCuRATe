package cz.msebera.android.httpclient.impl.auth;

import cz.msebera.android.httpclient.impl.auth.NTLMEngineException;

public interface NTLMEngine {
   String generateType1Msg(String var1, String var2) throws NTLMEngineException;

   String generateType3Msg(String var1, String var2, String var3, String var4, String var5) throws NTLMEngineException;
}
