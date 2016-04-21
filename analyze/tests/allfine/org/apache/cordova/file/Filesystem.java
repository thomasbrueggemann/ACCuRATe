package org.apache.cordova.file;

import android.net.Uri;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.cordova.file.EncodingException;
import org.apache.cordova.file.FileExistsException;
import org.apache.cordova.file.InvalidModificationException;
import org.apache.cordova.file.LocalFilesystemURL;
import org.apache.cordova.file.NoModificationAllowedException;
import org.apache.cordova.file.TypeMismatchException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class Filesystem {
    public final String name;
    private final JSONObject rootEntry;
    protected final Uri rootUri;

    public Filesystem(Uri var1, String var2) {
        this.rootUri = var1;
        this.name = var2;
        this.rootEntry = makeEntryForPath("/", var2, Boolean.valueOf(true), var1.toString());
    }

    public static JSONObject makeEntryForPath(String param0, String param1, Boolean param2, String param3) {
        // $FF: Couldn't be decompiled
    }

    public static JSONObject makeEntryForURL(LocalFilesystemURL var0, Boolean var1, String var2) {
        return makeEntryForPath(var0.fullPath, var0.filesystemName, var1, var2);
    }

    abstract LocalFilesystemURL URLforFilesystemPath(String var1);

    abstract boolean canRemoveFileAtLocalURL(LocalFilesystemURL var1);

    JSONObject copyFileToURL(LocalFilesystemURL var1, String var2, Filesystem var3, LocalFilesystemURL var4, boolean var5) throws IOException, InvalidModificationException, JSONException, NoModificationAllowedException, FileExistsException {
        if(var5 && !var3.canRemoveFileAtLocalURL(var4)) {
            throw new NoModificationAllowedException("Cannot move file at source URL");
        } else {
            final LocalFilesystemURL var6 = this.makeDestinationURL(var2, var4, var1);
            var3.readFileAtURL(var4, 0L, -1L, new Filesystem.ReadFileCallback() {
                public void handleData(InputStream var1, String var2) throws IOException {
                    if(var1 == null) {
                        throw new IOException("Cannot read file at source URL");
                    } else {
                        OutputStream var3 = Filesystem.this.getOutputStreamForURL(var6);
                        byte[] var4 = new byte[8192];

                        while(true) {
                            int var5 = var1.read(var4, 0, 8192);
                            if(var5 <= 0) {
                                var3.close();
                                return;
                            }

                            var3.write(var4, 0, var5);
                        }
                    }
                }
            });
            if(var5) {
                var3.removeFileAtLocalURL(var4);
            }

            return this.getEntryForLocalURL(var6);
        }
    }

    abstract String filesystemPathForURL(LocalFilesystemURL var1);

    abstract JSONObject getEntryForLocalURL(LocalFilesystemURL var1) throws IOException;

    abstract JSONObject getFileForLocalURL(LocalFilesystemURL var1, String var2, JSONObject var3, boolean var4) throws FileExistsException, IOException, TypeMismatchException, EncodingException, JSONException;

    abstract JSONObject getFileMetadataForLocalURL(LocalFilesystemURL var1) throws FileNotFoundException;

    abstract OutputStream getOutputStreamForURL(LocalFilesystemURL var1) throws IOException;

    public JSONObject getParentForLocalURL(LocalFilesystemURL var1) throws IOException {
        LocalFilesystemURL var2 = new LocalFilesystemURL(var1.URL);
        if(!"".equals(var1.fullPath) && !"/".equals(var1.fullPath)) {
            int var3 = 1 + var1.fullPath.replaceAll("/+$", "").lastIndexOf(47);
            var2.fullPath = var2.fullPath.substring(0, var3);
        }

        return this.getEntryForLocalURL(var2);
    }

    public JSONObject getRootEntry() {
        return this.rootEntry;
    }

    public Uri getRootUri() {
        return this.rootUri;
    }

    protected LocalFilesystemURL makeDestinationURL(String var1, LocalFilesystemURL var2, LocalFilesystemURL var3) {
        if("null".equals(var1) || "".equals(var1)) {
            var1 = var2.URL.getLastPathSegment();
        }

        String var4 = var3.URL.toString();
        String var5;
        if(var4.endsWith("/")) {
            var5 = var4 + var1;
        } else {
            var5 = var4 + "/" + var1;
        }

        return new LocalFilesystemURL(var5);
    }

    public JSONObject makeEntryForFile(File var1) throws JSONException {
        return null;
    }

    abstract JSONArray readEntriesAtLocalURL(LocalFilesystemURL var1) throws FileNotFoundException;

    abstract void readFileAtURL(LocalFilesystemURL var1, long var2, long var4, Filesystem.ReadFileCallback var6) throws IOException;

    abstract boolean recursiveRemoveFileAtLocalURL(LocalFilesystemURL var1) throws FileExistsException, NoModificationAllowedException;

    abstract boolean removeFileAtLocalURL(LocalFilesystemURL var1) throws InvalidModificationException, NoModificationAllowedException;

    abstract long truncateFileAtURL(LocalFilesystemURL var1, long var2) throws IOException, NoModificationAllowedException;

    abstract long writeToFileAtURL(LocalFilesystemURL var1, String var2, int var3, boolean var4) throws NoModificationAllowedException, IOException;

    protected class LimitedInputStream extends FilterInputStream {
        long numBytesToRead;

        public LimitedInputStream(InputStream var2, long var3) {
            super(var2);
            this.numBytesToRead = var3;
        }

        public int read() throws IOException {
            if(this.numBytesToRead <= 0L) {
                return -1;
            } else {
                --this.numBytesToRead;
                return this.in.read();
            }
        }

        public int read(byte[] var1, int var2, int var3) throws IOException {
            if(this.numBytesToRead <= 0L) {
                return -1;
            } else {
                int var4 = var3;
                if((long)var3 > this.numBytesToRead) {
                    var4 = (int)this.numBytesToRead;
                }

                int var5 = this.in.read(var1, var2, var4);
                this.numBytesToRead -= (long)var5;
                return var5;
            }
        }
    }

    public interface ReadFileCallback {
        void handleData(InputStream var1, String var2) throws IOException;
    }
}
