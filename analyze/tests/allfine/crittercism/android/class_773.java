package crittercism.android;

import crittercism.android.class_661;
import crittercism.android.class_662;
import crittercism.android.class_764;
import crittercism.android.class_772;
import java.net.InetAddress;
import java.net.Socket;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

// $FF: renamed from: crittercism.android.ab
public final class class_773 extends SSLSocketFactory {
    // $FF: renamed from: a javax.net.ssl.SSLSocketFactory
    private SSLSocketFactory field_3649;
    // $FF: renamed from: b crittercism.android.e
    private class_661 field_3650;
    // $FF: renamed from: c crittercism.android.d
    private class_662 field_3651;

    public class_773(SSLSocketFactory var1, class_661 var2, class_662 var3) {
        this.field_3649 = var1;
        this.field_3650 = var2;
        this.field_3651 = var3;
    }

    // $FF: renamed from: a (java.net.Socket) java.net.Socket
    private Socket method_4056(Socket var1) {
        if(var1 != null) {
            class_772 var4;
            try {
                if(!(var1 instanceof SSLSocket)) {
                    return (Socket)var1;
                }

                var4 = new class_772((SSLSocket)var1, this.field_3650, this.field_3651);
            } catch (ThreadDeath var5) {
                throw var5;
            } catch (Throwable var6) {
                class_764.method_4019(var6);
                return (Socket)var1;
            }

            var1 = var4;
        }

        return (Socket)var1;
    }

    // $FF: renamed from: a () javax.net.ssl.SSLSocketFactory
    public final SSLSocketFactory method_4057() {
        return this.field_3649;
    }

    public final Socket createSocket() {
        return this.method_4056(this.field_3649.createSocket());
    }

    public final Socket createSocket(String var1, int var2) {
        return this.method_4056(this.field_3649.createSocket(var1, var2));
    }

    public final Socket createSocket(String var1, int var2, InetAddress var3, int var4) {
        return this.method_4056(this.field_3649.createSocket(var1, var2, var3, var4));
    }

    public final Socket createSocket(InetAddress var1, int var2) {
        return this.method_4056(this.field_3649.createSocket(var1, var2));
    }

    public final Socket createSocket(InetAddress var1, int var2, InetAddress var3, int var4) {
        return this.method_4056(this.field_3649.createSocket(var1, var2, var3, var4));
    }

    public final Socket createSocket(Socket var1, String var2, int var3, boolean var4) {
        return this.method_4056(this.field_3649.createSocket(var1, var2, var3, var4));
    }

    public final String[] getDefaultCipherSuites() {
        return this.field_3649.getDefaultCipherSuites();
    }

    public final String[] getSupportedCipherSuites() {
        return this.field_3649.getSupportedCipherSuites();
    }
}
