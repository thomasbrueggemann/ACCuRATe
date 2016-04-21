package com.squareup.okhttp;

import com.squareup.okhttp.Route;
import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.net.ssl.SSLHandshakeException;

public final class RouteDatabase {
    private final Set<Route> failedRoutes = new LinkedHashSet();

    public void connected(Route var1) {
        synchronized(this) {}

        try {
            this.failedRoutes.remove(var1);
        } finally {
            ;
        }

    }

    public void failed(Route var1, IOException var2) {
        synchronized(this) {}

        try {
            this.failedRoutes.add(var1);
            if(!(var2 instanceof SSLHandshakeException)) {
                this.failedRoutes.add(var1.flipTlsMode());
            }
        } finally {
            ;
        }

    }

    public int failedRoutesCount() {
        synchronized(this) {}

        int var2;
        try {
            var2 = this.failedRoutes.size();
        } finally {
            ;
        }

        return var2;
    }

    public boolean shouldPostpone(Route var1) {
        synchronized(this) {}

        boolean var3;
        try {
            var3 = this.failedRoutes.contains(var1);
        } finally {
            ;
        }

        return var3;
    }
}
