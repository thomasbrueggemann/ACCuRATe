package org.apache.cordova.file;

import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore.Images.Media;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaResourceApi;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.PluginManager;
import org.apache.cordova.file.FileExistsException;
import org.apache.cordova.file.Filesystem;
import org.apache.cordova.file.InvalidModificationException;
import org.apache.cordova.file.LocalFilesystem;
import org.apache.cordova.file.LocalFilesystemURL;
import org.apache.cordova.file.NoModificationAllowedException;
import org.apache.cordova.file.TypeMismatchException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ContentFilesystem extends Filesystem {
    private CordovaInterface cordova;
    private CordovaResourceApi resourceApi;

    public ContentFilesystem(CordovaInterface var1, CordovaWebView var2) {
        super(Uri.parse("content://"), "content");
        this.cordova = var1;
        Class var3 = var2.getClass();

        PluginManager var5;
        try {
            var5 = (PluginManager)var3.getMethod("getPluginManager", new Class[0]).invoke(var2, new Object[0]);
        } catch (NoSuchMethodException var12) {
            var5 = null;
        } catch (IllegalAccessException var13) {
            var5 = null;
        } catch (InvocationTargetException var14) {
            var5 = null;
        }

        if(var5 == null) {
            try {
                var5 = (PluginManager)var3.getField("pluginManager").get(var2);
            } catch (NoSuchFieldException var10) {
                ;
            } catch (IllegalAccessException var11) {
                ;
            }
        }

        this.resourceApi = new CordovaResourceApi(var2.getContext(), var5);
    }

    public LocalFilesystemURL URLforFilesystemPath(String var1) {
        return null;
    }

    public boolean canRemoveFileAtLocalURL(LocalFilesystemURL var1) {
        return (new File(this.filesystemPathForURL(var1))).exists();
    }

    public JSONObject copyFileToURL(LocalFilesystemURL var1, String var2, Filesystem var3, LocalFilesystemURL var4, boolean var5) throws IOException, InvalidModificationException, JSONException, NoModificationAllowedException, FileExistsException {
        if(LocalFilesystem.class.isInstance(var3)) {
            LocalFilesystemURL var6 = this.makeDestinationURL(var2, var4, var1);
            OutputStream var7 = this.resourceApi.openOutputStream(var1.URL);
            CordovaResourceApi.OpenForReadResult var8 = this.resourceApi.openForRead(var4.URL);
            if(var5 && !var3.canRemoveFileAtLocalURL(var4)) {
                throw new NoModificationAllowedException("Cannot move file at source URL");
            } else {
                try {
                    this.resourceApi.copyResource(var8, var7);
                } catch (IOException var10) {
                    throw new IOException("Cannot read file at source URL");
                }

                if(var5) {
                    var3.removeFileAtLocalURL(var4);
                }

                return makeEntryForURL(var6, Boolean.valueOf(false), var6.URL.toString());
            }
        } else {
            return super.copyFileToURL(var1, var2, var3, var4, var5);
        }
    }

    protected String filesystemPathForCursor(Cursor var1) {
        int var2 = var1.getColumnIndex((new String[] {"_data"})[0]);
        return var2 != -1?var1.getString(var2):null;
    }

    public String filesystemPathForURL(LocalFilesystemURL var1) {
        Cursor var2 = this.openCursorForURL(var1);
        if(var2 != null) {
            try {
                if(var2.moveToFirst()) {
                    String var4 = this.filesystemPathForCursor(var2);
                    return var4;
                }
            } finally {
                if(var2 != null) {
                    var2.close();
                }

            }
        }

        return null;
    }

    public JSONObject getEntryForLocalURL(LocalFilesystemURL param1) throws IOException {
        // $FF: Couldn't be decompiled
    }

    public JSONObject getFileForLocalURL(LocalFilesystemURL var1, String var2, JSONObject var3, boolean var4) throws IOException, TypeMismatchException, JSONException {
        if(var3 != null && var3.optBoolean("create")) {
            throw new IOException("Cannot create content url");
        } else {
            LocalFilesystemURL var5 = new LocalFilesystemURL(Uri.withAppendedPath(var1.URL, var2));
            File var6 = new File(this.filesystemPathForURL(var5));
            if(!var6.exists()) {
                throw new FileNotFoundException("path does not exist");
            } else {
                if(var4) {
                    if(var6.isFile()) {
                        throw new TypeMismatchException("path doesn\'t exist or is file");
                    }
                } else if(var6.isDirectory()) {
                    throw new TypeMismatchException("path doesn\'t exist or is directory");
                }

                return makeEntryForPath(var5.fullPath, var5.filesystemName, Boolean.valueOf(var4), Uri.fromFile(var6).toString());
            }
        }
    }

    public JSONObject getFileMetadataForLocalURL(LocalFilesystemURL param1) throws FileNotFoundException {
        // $FF: Couldn't be decompiled
    }

    OutputStream getOutputStreamForURL(LocalFilesystemURL var1) throws IOException {
        return this.resourceApi.openOutputStream(var1.URL);
    }

    protected Integer lastModifiedDateForCursor(Cursor var1) {
        int var2 = var1.getColumnIndex((new String[] {"date_modified"})[0]);
        if(var2 != -1) {
            String var3 = var1.getString(var2);
            if(var3 != null) {
                return Integer.valueOf(Integer.parseInt(var3, 10));
            }
        }

        return null;
    }

    protected Cursor openCursorForURL(LocalFilesystemURL var1) {
        return this.cordova.getActivity().getContentResolver().query(var1.URL, (String[])null, (String)null, (String[])null, (String)null);
    }

    public JSONArray readEntriesAtLocalURL(LocalFilesystemURL var1) throws FileNotFoundException {
        return null;
    }

    public void readFileAtURL(LocalFilesystemURL param1, long param2, long param4, Filesystem.ReadFileCallback param6) throws IOException {
        // $FF: Couldn't be decompiled
    }

    public boolean recursiveRemoveFileAtLocalURL(LocalFilesystemURL var1) throws NoModificationAllowedException {
        throw new NoModificationAllowedException("Cannot remove content url");
    }

    public boolean removeFileAtLocalURL(LocalFilesystemURL var1) throws NoModificationAllowedException {
        String var2 = this.filesystemPathForURL(var1);
        File var3 = new File(var2);

        try {
            this.cordova.getActivity().getContentResolver().delete(Media.EXTERNAL_CONTENT_URI, "_data = ?", new String[] {var2});
        } catch (UnsupportedOperationException var5) {
            ;
        }

        return var3.delete();
    }

    protected Integer resourceSizeForCursor(Cursor var1) {
        int var2 = var1.getColumnIndex("_size");
        if(var2 != -1) {
            String var3 = var1.getString(var2);
            if(var3 != null) {
                return Integer.valueOf(Integer.parseInt(var3, 10));
            }
        }

        return null;
    }

    public long truncateFileAtURL(LocalFilesystemURL var1, long var2) throws NoModificationAllowedException {
        throw new NoModificationAllowedException("Couldn\'t truncate file given its content URI");
    }

    public long writeToFileAtURL(LocalFilesystemURL var1, String var2, int var3, boolean var4) throws NoModificationAllowedException {
        throw new NoModificationAllowedException("Couldn\'t write to file given its content URI");
    }
}
