package com.squareup.okhttp;

import com.squareup.okhttp.internal.Base64;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.Proxy;
import java.net.URL;
import java.util.List;

public interface OkAuthenticator {
    OkAuthenticator.Credential authenticate(Proxy var1, URL var2, List<OkAuthenticator.Challenge> var3) throws IOException;

    OkAuthenticator.Credential authenticateProxy(Proxy var1, URL var2, List<OkAuthenticator.Challenge> var3) throws IOException;

    public static final class Challenge {
        private final String realm;
        private final String scheme;

        public Challenge(String var1, String var2) {
            this.scheme = var1;
            this.realm = var2;
        }

        public boolean equals(Object var1) {
            return var1 instanceof OkAuthenticator.Challenge && ((OkAuthenticator.Challenge)var1).scheme.equals(this.scheme) && ((OkAuthenticator.Challenge)var1).realm.equals(this.realm);
        }

        public String getRealm() {
            return this.realm;
        }

        public String getScheme() {
            return this.scheme;
        }

        public int hashCode() {
            return this.scheme.hashCode() + 31 * this.realm.hashCode();
        }

        public String toString() {
            return this.scheme + " realm=\"" + this.realm + "\"";
        }
    }

    public static final class Credential {
        private final String headerValue;

        private Credential(String var1) {
            this.headerValue = var1;
        }

        public static OkAuthenticator.Credential basic(String var0, String var1) {
            try {
                String var3 = Base64.encode((var0 + ":" + var1).getBytes("ISO-8859-1"));
                OkAuthenticator.Credential var4 = new OkAuthenticator.Credential("Basic " + var3);
                return var4;
            } catch (UnsupportedEncodingException var5) {
                throw new AssertionError();
            }
        }

        public boolean equals(Object var1) {
            return var1 instanceof OkAuthenticator.Credential && ((OkAuthenticator.Credential)var1).headerValue.equals(this.headerValue);
        }

        public String getHeaderValue() {
            return this.headerValue;
        }

        public int hashCode() {
            return this.headerValue.hashCode();
        }

        public String toString() {
            return this.headerValue;
        }
    }
}
