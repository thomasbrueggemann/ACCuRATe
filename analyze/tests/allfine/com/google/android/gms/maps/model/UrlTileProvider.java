package com.google.android.gms.maps.model;

import com.google.android.gms.maps.model.Tile;
import com.google.android.gms.maps.model.TileProvider;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

public abstract class UrlTileProvider implements TileProvider {
    // $FF: renamed from: lf int
    private final int field_1976;
    // $FF: renamed from: lg int
    private final int field_1977;

    public UrlTileProvider(int var1, int var2) {
        this.field_1976 = var1;
        this.field_1977 = var2;
    }

    // $FF: renamed from: a (java.io.InputStream, java.io.OutputStream) long
    private static long method_2991(InputStream var0, OutputStream var1) throws IOException {
        byte[] var2 = new byte[4096];
        long var3 = 0L;

        while(true) {
            int var5 = var0.read(var2);
            if(var5 == -1) {
                return var3;
            }

            var1.write(var2, 0, var5);
            var3 += (long)var5;
        }
    }

    // $FF: renamed from: e (java.io.InputStream) byte[]
    private static byte[] method_2992(InputStream var0) throws IOException {
        ByteArrayOutputStream var1 = new ByteArrayOutputStream();
        method_2991(var0, var1);
        return var1.toByteArray();
    }

    public final Tile getTile(int var1, int var2, int var3) {
        URL var4 = this.getTileUrl(var1, var2, var3);
        if(var4 == null) {
            return NO_TILE;
        } else {
            try {
                Tile var5 = new Tile(this.field_1976, this.field_1977, method_2992(var4.openStream()));
                return var5;
            } catch (IOException var7) {
                return null;
            }
        }
    }

    public abstract URL getTileUrl(int var1, int var2, int var3);
}
