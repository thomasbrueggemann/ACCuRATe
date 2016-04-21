package org.apache.cordova.file;

import android.net.Uri;
import java.util.List;

public class LocalFilesystemURL {
    public static final String FILESYSTEM_PROTOCOL = "cdvfile";
    Uri URL;
    String filesystemName;
    String fullPath;

    public LocalFilesystemURL(Uri var1) {
        this.URL = var1;
        this.filesystemName = this.filesystemNameForLocalURL(var1);
        this.fullPath = this.fullPathForLocalURL(var1);
    }

    public LocalFilesystemURL(String var1) {
        this(Uri.parse(var1));
    }

    private String filesystemNameForLocalURL(Uri var1) {
        String var3;
        if("cdvfile".equals(var1.getScheme()) && "localhost".equals(var1.getHost())) {
            List var4 = var1.getPathSegments();
            var3 = null;
            if(var4 != null) {
                int var5 = var4.size();
                var3 = null;
                if(var5 > 0) {
                    var3 = (String)var4.get(0);
                }
            }
        } else {
            boolean var2 = "content".equals(var1.getScheme());
            var3 = null;
            if(var2) {
                return "content";
            }
        }

        return var3;
    }

    private String fullPathForLocalURL(Uri var1) {
        if("cdvfile".equals(var1.getScheme()) && "localhost".equals(var1.getHost())) {
            String var2 = var1.getPath();
            if(var1.getQuery() != null) {
                var2 = var2 + "?" + var1.getQuery();
            }

            return var2.substring(var2.indexOf(47, 1));
        } else {
            return "content".equals(var1.getScheme())?Uri.encode('/' + var1.getHost() + var1.getPath(), "/"):null;
        }
    }

    public String toString() {
        return "cdvfile://localhost/" + this.filesystemName + this.fullPath;
    }
}
