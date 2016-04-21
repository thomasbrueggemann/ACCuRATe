package org.apache.cordova.file;

import android.content.Intent;
import android.net.Uri;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.file.EncodingException;
import org.apache.cordova.file.FileExistsException;
import org.apache.cordova.file.Filesystem;
import org.apache.cordova.file.InvalidModificationException;
import org.apache.cordova.file.LocalFilesystemURL;
import org.apache.cordova.file.NoModificationAllowedException;
import org.apache.cordova.file.TypeMismatchException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class LocalFilesystem extends Filesystem {
    private CordovaInterface cordova;

    public LocalFilesystem(String var1, CordovaInterface var2, Uri var3) {
        super(var3, var1);
        this.cordova = var2;
    }

    public LocalFilesystem(String var1, CordovaInterface var2, String var3) {
        this(var1, var2, Uri.fromFile(new File(var3)));
    }

    private void broadcastNewFile(LocalFilesystemURL var1) {
        File var2 = new File(this.filesystemPathForURL(var1));
        if(var2.exists()) {
            this.cordova.getActivity().getApplicationContext().sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.fromFile(var2)));
        }

    }

    private void copyAction(File var1, File var2) throws FileNotFoundException, IOException {
        FileInputStream var3 = new FileInputStream(var1);
        FileOutputStream var4 = new FileOutputStream(var2);
        FileChannel var5 = var3.getChannel();
        FileChannel var6 = var4.getChannel();

        try {
            var5.transferTo(0L, var5.size(), var6);
        } finally {
            var3.close();
            var4.close();
            var5.close();
            var6.close();
        }

    }

    private JSONObject copyDirectory(File var1, File var2) throws JSONException, IOException, NoModificationAllowedException, InvalidModificationException {
        if(var2.exists() && var2.isFile()) {
            throw new InvalidModificationException("Can\'t rename a file to a directory");
        } else if(this.isCopyOnItself(var1.getAbsolutePath(), var2.getAbsolutePath())) {
            throw new InvalidModificationException("Can\'t copy itself into itself");
        } else if(!var2.exists() && !var2.mkdir()) {
            throw new NoModificationAllowedException("Couldn\'t create the destination directory");
        } else {
            File[] var3 = var1.listFiles();
            int var4 = var3.length;

            for(int var5 = 0; var5 < var4; ++var5) {
                File var6 = var3[var5];
                File var7 = new File(var2.getAbsoluteFile() + File.separator + var6.getName());
                if(var6.isDirectory()) {
                    this.copyDirectory(var6, var7);
                } else {
                    this.copyFile(var6, var7);
                }
            }

            return this.makeEntryForFile(var2);
        }
    }

    private JSONObject copyFile(File var1, File var2) throws IOException, InvalidModificationException, JSONException {
        if(var2.exists() && var2.isDirectory()) {
            throw new InvalidModificationException("Can\'t rename a file to a directory");
        } else {
            this.copyAction(var1, var2);
            return this.makeEntryForFile(var2);
        }
    }

    private String fullPathForFilesystemPath(String var1) {
        return var1 != null && var1.startsWith(this.rootUri.getPath())?var1.substring(this.rootUri.getPath().length()):null;
    }

    private boolean isCopyOnItself(String var1, String var2) {
        return var2.equals(var1) || var2.startsWith(var1 + File.separator);
    }

    private JSONObject moveDirectory(File var1, File var2) throws IOException, JSONException, InvalidModificationException, NoModificationAllowedException, FileExistsException {
        if(var2.exists() && var2.isFile()) {
            throw new InvalidModificationException("Can\'t rename a file to a directory");
        } else if(this.isCopyOnItself(var1.getAbsolutePath(), var2.getAbsolutePath())) {
            throw new InvalidModificationException("Can\'t move itself into itself");
        } else if(var2.exists() && var2.list().length > 0) {
            throw new InvalidModificationException("directory is not empty");
        } else {
            if(!var1.renameTo(var2)) {
                this.copyDirectory(var1, var2);
                if(!var2.exists()) {
                    throw new IOException("moved failed");
                }

                this.removeDirRecursively(var1);
            }

            return this.makeEntryForFile(var2);
        }
    }

    private JSONObject moveFile(File var1, File var2) throws IOException, JSONException, InvalidModificationException {
        if(var2.exists() && var2.isDirectory()) {
            throw new InvalidModificationException("Can\'t rename a file to a directory");
        } else {
            if(!var1.renameTo(var2)) {
                this.copyAction(var1, var2);
                if(!var2.exists()) {
                    throw new IOException("moved failed");
                }

                var1.delete();
            }

            return this.makeEntryForFile(var2);
        }
    }

    public LocalFilesystemURL URLforFilesystemPath(String var1) {
        return this.URLforFullPath(this.fullPathForFilesystemPath(var1));
    }

    protected LocalFilesystemURL URLforFullPath(String var1) {
        return var1 != null?(var1.startsWith("/")?new LocalFilesystemURL("cdvfile://localhost/" + this.name + var1):new LocalFilesystemURL("cdvfile://localhost/" + this.name + "/" + var1)):null;
    }

    public boolean canRemoveFileAtLocalURL(LocalFilesystemURL var1) {
        return (new File(this.filesystemPathForURL(var1))).exists();
    }

    public JSONObject copyFileToURL(LocalFilesystemURL var1, String var2, Filesystem var3, LocalFilesystemURL var4, boolean var5) throws IOException, InvalidModificationException, JSONException, NoModificationAllowedException, FileExistsException {
        if(!(new File(this.filesystemPathForURL(var1))).exists()) {
            throw new FileNotFoundException("The source does not exist");
        } else if(LocalFilesystem.class.isInstance(var3)) {
            LocalFilesystemURL var6 = this.makeDestinationURL(var2, var4, var1);
            File var7 = new File(var3.filesystemPathForURL(var4));
            File var8 = new File(this.filesystemPathForURL(var6));
            if(!var7.exists()) {
                throw new FileNotFoundException("The source does not exist");
            } else if(var7.getAbsolutePath().equals(var8.getAbsolutePath())) {
                throw new InvalidModificationException("Can\'t copy a file onto itself");
            } else {
                return var7.isDirectory()?(var5?this.moveDirectory(var7, var8):this.copyDirectory(var7, var8)):(var5?this.moveFile(var7, var8):this.copyFile(var7, var8));
            }
        } else {
            return super.copyFileToURL(var1, var2, var3, var4, var5);
        }
    }

    public String filesystemPathForFullPath(String var1) {
        String var2 = (new File(this.rootUri.getPath(), var1)).toString();
        int var3 = var2.indexOf("?");
        if(var3 >= 0) {
            var2 = var2.substring(0, var3);
        }

        if(var2.length() > 1 && var2.endsWith("/")) {
            var2 = var2.substring(0, -1 + var2.length());
        }

        return var2;
    }

    public String filesystemPathForURL(LocalFilesystemURL var1) {
        return this.filesystemPathForFullPath(var1.fullPath);
    }

    public JSONObject getEntryForLocalURL(LocalFilesystemURL var1) throws IOException {
        File var2 = new File(this.filesystemPathForURL(var1));
        if(!var2.exists()) {
            throw new FileNotFoundException();
        } else if(!var2.canRead()) {
            throw new IOException();
        } else {
            return makeEntryForURL(var1, Boolean.valueOf(var2.isDirectory()), Uri.fromFile(var2).toString());
        }
    }

    public JSONObject getFileForLocalURL(LocalFilesystemURL var1, String var2, JSONObject var3, boolean var4) throws FileExistsException, IOException, TypeMismatchException, EncodingException, JSONException {
        boolean var5 = false;
        boolean var6 = false;
        if(var3 != null) {
            var5 = var3.optBoolean("create");
            var6 = false;
            if(var5) {
                var6 = var3.optBoolean("exclusive");
            }
        }

        if(var2.contains(":")) {
            throw new EncodingException("This path has an invalid \":\" in it.");
        } else {
            LocalFilesystemURL var7;
            if(var2.startsWith("/")) {
                var7 = this.URLforFilesystemPath(var2);
            } else {
                var7 = this.URLforFullPath(this.normalizePath(var1.fullPath + "/" + var2));
            }

            File var8 = new File(this.filesystemPathForURL(var7));
            if(var5) {
                if(var6 && var8.exists()) {
                    throw new FileExistsException("create/exclusive fails");
                }

                if(var4) {
                    var8.mkdir();
                } else {
                    var8.createNewFile();
                }

                if(!var8.exists()) {
                    throw new FileExistsException("create fails");
                }
            } else {
                if(!var8.exists()) {
                    throw new FileNotFoundException("path does not exist");
                }

                if(var4) {
                    if(var8.isFile()) {
                        throw new TypeMismatchException("path doesn\'t exist or is file");
                    }
                } else if(var8.isDirectory()) {
                    throw new TypeMismatchException("path doesn\'t exist or is directory");
                }
            }

            return makeEntryForPath(var7.fullPath, var7.filesystemName, Boolean.valueOf(var4), Uri.fromFile(var8).toString());
        }
    }

    public JSONObject getFileMetadataForLocalURL(LocalFilesystemURL param1) throws FileNotFoundException {
        // $FF: Couldn't be decompiled
    }

    OutputStream getOutputStreamForURL(LocalFilesystemURL var1) throws FileNotFoundException {
        return new FileOutputStream(new File(this.filesystemPathForURL(var1)));
    }

    public JSONObject makeEntryForFile(File var1) throws JSONException {
        String var2 = this.fullPathForFilesystemPath(var1.getAbsolutePath());
        return var2 != null?makeEntryForPath(var2, this.name, Boolean.valueOf(var1.isDirectory()), Uri.fromFile(var1).toString()):null;
    }

    protected String normalizePath(String var1) {
        boolean var2 = var1.startsWith("/");
        if(var2) {
            var1 = var1.substring(1);
        }

        ArrayList var3 = new ArrayList(Arrays.asList(var1.split("/+")));

        for(int var4 = 0; var4 < var3.size(); ++var4) {
            if(((String)var3.get(var4)).equals("..")) {
                var3.remove(var4);
                if(var4 > 0) {
                    var3.remove(var4 - 1);
                    --var4;
                }
            }
        }

        StringBuilder var5 = new StringBuilder();
        Iterator var6 = var3.iterator();

        while(var6.hasNext()) {
            String var7 = (String)var6.next();
            var5.append("/");
            var5.append(var7);
        }

        return var2?var5.toString():var5.toString().substring(1);
    }

    public JSONArray readEntriesAtLocalURL(LocalFilesystemURL var1) throws FileNotFoundException {
        File var2 = new File(this.filesystemPathForURL(var1));
        if(!var2.exists()) {
            throw new FileNotFoundException();
        } else {
            JSONArray var3 = new JSONArray();
            if(var2.isDirectory()) {
                File[] var4 = var2.listFiles();

                for(int var5 = 0; var5 < var4.length; ++var5) {
                    if(var4[var5].canRead()) {
                        var3.put(makeEntryForPath(this.fullPathForFilesystemPath(var4[var5].getAbsolutePath()), var1.filesystemName, Boolean.valueOf(var4[var5].isDirectory()), Uri.fromFile(var4[var5]).toString()));
                    }
                }
            }

            return var3;
        }
    }

    public void readFileAtURL(LocalFilesystemURL param1, long param2, long param4, Filesystem.ReadFileCallback param6) throws IOException {
        // $FF: Couldn't be decompiled
    }

    public boolean recursiveRemoveFileAtLocalURL(LocalFilesystemURL var1) throws FileExistsException {
        return this.removeDirRecursively(new File(this.filesystemPathForURL(var1)));
    }

    protected boolean removeDirRecursively(File var1) throws FileExistsException {
        if(var1.isDirectory()) {
            File[] var2 = var1.listFiles();
            int var3 = var2.length;

            for(int var4 = 0; var4 < var3; ++var4) {
                this.removeDirRecursively(var2[var4]);
            }
        }

        if(!var1.delete()) {
            throw new FileExistsException("could not delete: " + var1.getName());
        } else {
            return true;
        }
    }

    public boolean removeFileAtLocalURL(LocalFilesystemURL var1) throws InvalidModificationException {
        File var2 = new File(this.filesystemPathForURL(var1));
        if(var2.isDirectory() && var2.list().length > 0) {
            throw new InvalidModificationException("You can\'t delete a directory that is not empty.");
        } else {
            return var2.delete();
        }
    }

    public long truncateFileAtURL(LocalFilesystemURL var1, long var2) throws IOException {
        if(!(new File(this.filesystemPathForURL(var1))).exists()) {
            throw new FileNotFoundException("File at " + var1.URL + " does not exist.");
        } else {
            RandomAccessFile var4 = new RandomAccessFile(this.filesystemPathForURL(var1), "rw");
            boolean var9 = false;

            label46: {
                long var6;
                try {
                    var9 = true;
                    if(var4.length() >= var2) {
                        var4.getChannel().truncate(var2);
                        var9 = false;
                        break label46;
                    }

                    var6 = var4.length();
                    var9 = false;
                } finally {
                    if(var9) {
                        var4.close();
                    }
                }

                var2 = var6;
            }

            var4.close();
            return var2;
        }
    }

    public long writeToFileAtURL(LocalFilesystemURL param1, String param2, int param3, boolean param4) throws IOException, NoModificationAllowedException {
        // $FF: Couldn't be decompiled
    }
}
