package com.google.android.gms.games.snapshot;

import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.google.android.gms.drive.Contents;
import java.io.IOException;

public interface SnapshotContents extends Parcelable {
   void close();

   ParcelFileDescriptor getParcelFileDescriptor();

   // $FF: renamed from: ir () com.google.android.gms.drive.Contents
   Contents method_1061();

   boolean isClosed();

   boolean modifyBytes(int var1, byte[] var2, int var3, int var4);

   byte[] readFully() throws IOException;

   boolean writeBytes(byte[] var1);
}
