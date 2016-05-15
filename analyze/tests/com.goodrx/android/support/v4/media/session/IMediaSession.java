package android.support.v4.media.session;

import android.app.PendingIntent;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.RatingCompat;
import android.support.v4.media.session.IMediaControllerCallback;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.ParcelableVolumeInfo;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import android.view.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public interface IMediaSession extends IInterface {
   void adjustVolume(int var1, int var2, String var3) throws RemoteException;

   void fastForward() throws RemoteException;

   Bundle getExtras() throws RemoteException;

   long getFlags() throws RemoteException;

   PendingIntent getLaunchPendingIntent() throws RemoteException;

   MediaMetadataCompat getMetadata() throws RemoteException;

   String getPackageName() throws RemoteException;

   PlaybackStateCompat getPlaybackState() throws RemoteException;

   List<MediaSessionCompat.QueueItem> getQueue() throws RemoteException;

   CharSequence getQueueTitle() throws RemoteException;

   int getRatingType() throws RemoteException;

   String getTag() throws RemoteException;

   ParcelableVolumeInfo getVolumeAttributes() throws RemoteException;

   boolean isTransportControlEnabled() throws RemoteException;

   void next() throws RemoteException;

   void pause() throws RemoteException;

   void play() throws RemoteException;

   void playFromMediaId(String var1, Bundle var2) throws RemoteException;

   void playFromSearch(String var1, Bundle var2) throws RemoteException;

   void playFromUri(Uri var1, Bundle var2) throws RemoteException;

   void previous() throws RemoteException;

   void rate(RatingCompat var1) throws RemoteException;

   void registerCallbackListener(IMediaControllerCallback var1) throws RemoteException;

   void rewind() throws RemoteException;

   void seekTo(long var1) throws RemoteException;

   void sendCommand(String var1, Bundle var2, MediaSessionCompat.ResultReceiverWrapper var3) throws RemoteException;

   void sendCustomAction(String var1, Bundle var2) throws RemoteException;

   boolean sendMediaButton(KeyEvent var1) throws RemoteException;

   void setVolumeTo(int var1, int var2, String var3) throws RemoteException;

   void skipToQueueItem(long var1) throws RemoteException;

   void stop() throws RemoteException;

   void unregisterCallbackListener(IMediaControllerCallback var1) throws RemoteException;

   public abstract static class Stub extends Binder implements IMediaSession {
      private static final String DESCRIPTOR = "android.support.v4.media.session.IMediaSession";
      static final int TRANSACTION_adjustVolume = 11;
      static final int TRANSACTION_fastForward = 22;
      static final int TRANSACTION_getExtras = 31;
      static final int TRANSACTION_getFlags = 9;
      static final int TRANSACTION_getLaunchPendingIntent = 8;
      static final int TRANSACTION_getMetadata = 27;
      static final int TRANSACTION_getPackageName = 6;
      static final int TRANSACTION_getPlaybackState = 28;
      static final int TRANSACTION_getQueue = 29;
      static final int TRANSACTION_getQueueTitle = 30;
      static final int TRANSACTION_getRatingType = 32;
      static final int TRANSACTION_getTag = 7;
      static final int TRANSACTION_getVolumeAttributes = 10;
      static final int TRANSACTION_isTransportControlEnabled = 5;
      static final int TRANSACTION_next = 20;
      static final int TRANSACTION_pause = 18;
      static final int TRANSACTION_play = 13;
      static final int TRANSACTION_playFromMediaId = 14;
      static final int TRANSACTION_playFromSearch = 15;
      static final int TRANSACTION_playFromUri = 16;
      static final int TRANSACTION_previous = 21;
      static final int TRANSACTION_rate = 25;
      static final int TRANSACTION_registerCallbackListener = 3;
      static final int TRANSACTION_rewind = 23;
      static final int TRANSACTION_seekTo = 24;
      static final int TRANSACTION_sendCommand = 1;
      static final int TRANSACTION_sendCustomAction = 26;
      static final int TRANSACTION_sendMediaButton = 2;
      static final int TRANSACTION_setVolumeTo = 12;
      static final int TRANSACTION_skipToQueueItem = 17;
      static final int TRANSACTION_stop = 19;
      static final int TRANSACTION_unregisterCallbackListener = 4;

      public Stub() {
         this.attachInterface(this, "android.support.v4.media.session.IMediaSession");
      }

      public static IMediaSession asInterface(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("android.support.v4.media.session.IMediaSession");
            return (IMediaSession)(var1 != null && var1 instanceof IMediaSession?(IMediaSession)var1:new IMediaSession.Proxy(var0));
         }
      }

      public IBinder asBinder() {
         return this;
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("android.support.v4.media.session.IMediaSession");
            String var31 = var2.readString();
            Bundle var32;
            if(var2.readInt() != 0) {
               var32 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
            } else {
               var32 = null;
            }

            MediaSessionCompat.ResultReceiverWrapper var33;
            if(var2.readInt() != 0) {
               var33 = (MediaSessionCompat.ResultReceiverWrapper)MediaSessionCompat.ResultReceiverWrapper.CREATOR.createFromParcel(var2);
            } else {
               var33 = null;
            }

            this.sendCommand(var31, var32, var33);
            var3.writeNoException();
            return true;
         case 2:
            var2.enforceInterface("android.support.v4.media.session.IMediaSession");
            KeyEvent var28;
            if(var2.readInt() != 0) {
               var28 = (KeyEvent)KeyEvent.CREATOR.createFromParcel(var2);
            } else {
               var28 = null;
            }

            boolean var29 = this.sendMediaButton(var28);
            var3.writeNoException();
            byte var30 = 0;
            if(var29) {
               var30 = 1;
            }

            var3.writeInt(var30);
            return true;
         case 3:
            var2.enforceInterface("android.support.v4.media.session.IMediaSession");
            this.registerCallbackListener(IMediaControllerCallback.Stub.asInterface(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 4:
            var2.enforceInterface("android.support.v4.media.session.IMediaSession");
            this.unregisterCallbackListener(IMediaControllerCallback.Stub.asInterface(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 5:
            var2.enforceInterface("android.support.v4.media.session.IMediaSession");
            boolean var26 = this.isTransportControlEnabled();
            var3.writeNoException();
            byte var27 = 0;
            if(var26) {
               var27 = 1;
            }

            var3.writeInt(var27);
            return true;
         case 6:
            var2.enforceInterface("android.support.v4.media.session.IMediaSession");
            String var25 = this.getPackageName();
            var3.writeNoException();
            var3.writeString(var25);
            return true;
         case 7:
            var2.enforceInterface("android.support.v4.media.session.IMediaSession");
            String var24 = this.getTag();
            var3.writeNoException();
            var3.writeString(var24);
            return true;
         case 8:
            var2.enforceInterface("android.support.v4.media.session.IMediaSession");
            PendingIntent var23 = this.getLaunchPendingIntent();
            var3.writeNoException();
            if(var23 != null) {
               var3.writeInt(1);
               var23.writeToParcel(var3, 1);
               return true;
            }

            var3.writeInt(0);
            return true;
         case 9:
            var2.enforceInterface("android.support.v4.media.session.IMediaSession");
            long var21 = this.getFlags();
            var3.writeNoException();
            var3.writeLong(var21);
            return true;
         case 10:
            var2.enforceInterface("android.support.v4.media.session.IMediaSession");
            ParcelableVolumeInfo var20 = this.getVolumeAttributes();
            var3.writeNoException();
            if(var20 != null) {
               var3.writeInt(1);
               var20.writeToParcel(var3, 1);
               return true;
            }

            var3.writeInt(0);
            return true;
         case 11:
            var2.enforceInterface("android.support.v4.media.session.IMediaSession");
            this.adjustVolume(var2.readInt(), var2.readInt(), var2.readString());
            var3.writeNoException();
            return true;
         case 12:
            var2.enforceInterface("android.support.v4.media.session.IMediaSession");
            this.setVolumeTo(var2.readInt(), var2.readInt(), var2.readString());
            var3.writeNoException();
            return true;
         case 13:
            var2.enforceInterface("android.support.v4.media.session.IMediaSession");
            this.play();
            var3.writeNoException();
            return true;
         case 14:
            var2.enforceInterface("android.support.v4.media.session.IMediaSession");
            String var18 = var2.readString();
            Bundle var19;
            if(var2.readInt() != 0) {
               var19 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
            } else {
               var19 = null;
            }

            this.playFromMediaId(var18, var19);
            var3.writeNoException();
            return true;
         case 15:
            var2.enforceInterface("android.support.v4.media.session.IMediaSession");
            String var16 = var2.readString();
            Bundle var17;
            if(var2.readInt() != 0) {
               var17 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
            } else {
               var17 = null;
            }

            this.playFromSearch(var16, var17);
            var3.writeNoException();
            return true;
         case 16:
            var2.enforceInterface("android.support.v4.media.session.IMediaSession");
            Uri var14;
            if(var2.readInt() != 0) {
               var14 = (Uri)Uri.CREATOR.createFromParcel(var2);
            } else {
               var14 = null;
            }

            Bundle var15;
            if(var2.readInt() != 0) {
               var15 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
            } else {
               var15 = null;
            }

            this.playFromUri(var14, var15);
            var3.writeNoException();
            return true;
         case 17:
            var2.enforceInterface("android.support.v4.media.session.IMediaSession");
            this.skipToQueueItem(var2.readLong());
            var3.writeNoException();
            return true;
         case 18:
            var2.enforceInterface("android.support.v4.media.session.IMediaSession");
            this.pause();
            var3.writeNoException();
            return true;
         case 19:
            var2.enforceInterface("android.support.v4.media.session.IMediaSession");
            this.stop();
            var3.writeNoException();
            return true;
         case 20:
            var2.enforceInterface("android.support.v4.media.session.IMediaSession");
            this.next();
            var3.writeNoException();
            return true;
         case 21:
            var2.enforceInterface("android.support.v4.media.session.IMediaSession");
            this.previous();
            var3.writeNoException();
            return true;
         case 22:
            var2.enforceInterface("android.support.v4.media.session.IMediaSession");
            this.fastForward();
            var3.writeNoException();
            return true;
         case 23:
            var2.enforceInterface("android.support.v4.media.session.IMediaSession");
            this.rewind();
            var3.writeNoException();
            return true;
         case 24:
            var2.enforceInterface("android.support.v4.media.session.IMediaSession");
            this.seekTo(var2.readLong());
            var3.writeNoException();
            return true;
         case 25:
            var2.enforceInterface("android.support.v4.media.session.IMediaSession");
            RatingCompat var13;
            if(var2.readInt() != 0) {
               var13 = (RatingCompat)RatingCompat.CREATOR.createFromParcel(var2);
            } else {
               var13 = null;
            }

            this.rate(var13);
            var3.writeNoException();
            return true;
         case 26:
            var2.enforceInterface("android.support.v4.media.session.IMediaSession");
            String var11 = var2.readString();
            Bundle var12;
            if(var2.readInt() != 0) {
               var12 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
            } else {
               var12 = null;
            }

            this.sendCustomAction(var11, var12);
            var3.writeNoException();
            return true;
         case 27:
            var2.enforceInterface("android.support.v4.media.session.IMediaSession");
            MediaMetadataCompat var10 = this.getMetadata();
            var3.writeNoException();
            if(var10 != null) {
               var3.writeInt(1);
               var10.writeToParcel(var3, 1);
               return true;
            }

            var3.writeInt(0);
            return true;
         case 28:
            var2.enforceInterface("android.support.v4.media.session.IMediaSession");
            PlaybackStateCompat var9 = this.getPlaybackState();
            var3.writeNoException();
            if(var9 != null) {
               var3.writeInt(1);
               var9.writeToParcel(var3, 1);
               return true;
            }

            var3.writeInt(0);
            return true;
         case 29:
            var2.enforceInterface("android.support.v4.media.session.IMediaSession");
            List var8 = this.getQueue();
            var3.writeNoException();
            var3.writeTypedList(var8);
            return true;
         case 30:
            var2.enforceInterface("android.support.v4.media.session.IMediaSession");
            CharSequence var7 = this.getQueueTitle();
            var3.writeNoException();
            if(var7 != null) {
               var3.writeInt(1);
               TextUtils.writeToParcel(var7, var3, 1);
               return true;
            }

            var3.writeInt(0);
            return true;
         case 31:
            var2.enforceInterface("android.support.v4.media.session.IMediaSession");
            Bundle var6 = this.getExtras();
            var3.writeNoException();
            if(var6 != null) {
               var3.writeInt(1);
               var6.writeToParcel(var3, 1);
               return true;
            }

            var3.writeInt(0);
            return true;
         case 32:
            var2.enforceInterface("android.support.v4.media.session.IMediaSession");
            int var5 = this.getRatingType();
            var3.writeNoException();
            var3.writeInt(var5);
            return true;
         case 1598968902:
            var3.writeString("android.support.v4.media.session.IMediaSession");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class Proxy implements IMediaSession {
      private IBinder mRemote;

      Proxy(IBinder var1) {
         this.mRemote = var1;
      }

      public void adjustVolume(int var1, int var2, String var3) throws RemoteException {
         Parcel var4 = Parcel.obtain();
         Parcel var5 = Parcel.obtain();

         try {
            var4.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
            var4.writeInt(var1);
            var4.writeInt(var2);
            var4.writeString(var3);
            this.mRemote.transact(11, var4, var5, 0);
            var5.readException();
         } finally {
            var5.recycle();
            var4.recycle();
         }

      }

      public IBinder asBinder() {
         return this.mRemote;
      }

      public void fastForward() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         try {
            var1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
            this.mRemote.transact(22, var1, var2, 0);
            var2.readException();
         } finally {
            var2.recycle();
            var1.recycle();
         }

      }

      public Bundle getExtras() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();
         boolean var7 = false;

         Bundle var5;
         label36: {
            try {
               var7 = true;
               var1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
               this.mRemote.transact(31, var1, var2, 0);
               var2.readException();
               if(var2.readInt() != 0) {
                  var5 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
                  var7 = false;
                  break label36;
               }

               var7 = false;
            } finally {
               if(var7) {
                  var2.recycle();
                  var1.recycle();
               }
            }

            var5 = null;
         }

         var2.recycle();
         var1.recycle();
         return var5;
      }

      public long getFlags() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         long var5;
         try {
            var1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
            this.mRemote.transact(9, var1, var2, 0);
            var2.readException();
            var5 = var2.readLong();
         } finally {
            var2.recycle();
            var1.recycle();
         }

         return var5;
      }

      public String getInterfaceDescriptor() {
         return "android.support.v4.media.session.IMediaSession";
      }

      public PendingIntent getLaunchPendingIntent() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();
         boolean var7 = false;

         PendingIntent var5;
         label36: {
            try {
               var7 = true;
               var1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
               this.mRemote.transact(8, var1, var2, 0);
               var2.readException();
               if(var2.readInt() != 0) {
                  var5 = (PendingIntent)PendingIntent.CREATOR.createFromParcel(var2);
                  var7 = false;
                  break label36;
               }

               var7 = false;
            } finally {
               if(var7) {
                  var2.recycle();
                  var1.recycle();
               }
            }

            var5 = null;
         }

         var2.recycle();
         var1.recycle();
         return var5;
      }

      public MediaMetadataCompat getMetadata() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();
         boolean var7 = false;

         MediaMetadataCompat var5;
         label36: {
            try {
               var7 = true;
               var1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
               this.mRemote.transact(27, var1, var2, 0);
               var2.readException();
               if(var2.readInt() != 0) {
                  var5 = (MediaMetadataCompat)MediaMetadataCompat.CREATOR.createFromParcel(var2);
                  var7 = false;
                  break label36;
               }

               var7 = false;
            } finally {
               if(var7) {
                  var2.recycle();
                  var1.recycle();
               }
            }

            var5 = null;
         }

         var2.recycle();
         var1.recycle();
         return var5;
      }

      public String getPackageName() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         String var5;
         try {
            var1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
            this.mRemote.transact(6, var1, var2, 0);
            var2.readException();
            var5 = var2.readString();
         } finally {
            var2.recycle();
            var1.recycle();
         }

         return var5;
      }

      public PlaybackStateCompat getPlaybackState() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();
         boolean var7 = false;

         PlaybackStateCompat var5;
         label36: {
            try {
               var7 = true;
               var1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
               this.mRemote.transact(28, var1, var2, 0);
               var2.readException();
               if(var2.readInt() != 0) {
                  var5 = (PlaybackStateCompat)PlaybackStateCompat.CREATOR.createFromParcel(var2);
                  var7 = false;
                  break label36;
               }

               var7 = false;
            } finally {
               if(var7) {
                  var2.recycle();
                  var1.recycle();
               }
            }

            var5 = null;
         }

         var2.recycle();
         var1.recycle();
         return var5;
      }

      public List<MediaSessionCompat.QueueItem> getQueue() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         ArrayList var5;
         try {
            var1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
            this.mRemote.transact(29, var1, var2, 0);
            var2.readException();
            var5 = var2.createTypedArrayList(MediaSessionCompat.QueueItem.CREATOR);
         } finally {
            var2.recycle();
            var1.recycle();
         }

         return var5;
      }

      public CharSequence getQueueTitle() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();
         boolean var7 = false;

         CharSequence var5;
         label36: {
            try {
               var7 = true;
               var1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
               this.mRemote.transact(30, var1, var2, 0);
               var2.readException();
               if(var2.readInt() != 0) {
                  var5 = (CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(var2);
                  var7 = false;
                  break label36;
               }

               var7 = false;
            } finally {
               if(var7) {
                  var2.recycle();
                  var1.recycle();
               }
            }

            var5 = null;
         }

         var2.recycle();
         var1.recycle();
         return var5;
      }

      public int getRatingType() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         int var5;
         try {
            var1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
            this.mRemote.transact(32, var1, var2, 0);
            var2.readException();
            var5 = var2.readInt();
         } finally {
            var2.recycle();
            var1.recycle();
         }

         return var5;
      }

      public String getTag() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         String var5;
         try {
            var1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
            this.mRemote.transact(7, var1, var2, 0);
            var2.readException();
            var5 = var2.readString();
         } finally {
            var2.recycle();
            var1.recycle();
         }

         return var5;
      }

      public ParcelableVolumeInfo getVolumeAttributes() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();
         boolean var7 = false;

         ParcelableVolumeInfo var5;
         label36: {
            try {
               var7 = true;
               var1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
               this.mRemote.transact(10, var1, var2, 0);
               var2.readException();
               if(var2.readInt() != 0) {
                  var5 = (ParcelableVolumeInfo)ParcelableVolumeInfo.CREATOR.createFromParcel(var2);
                  var7 = false;
                  break label36;
               }

               var7 = false;
            } finally {
               if(var7) {
                  var2.recycle();
                  var1.recycle();
               }
            }

            var5 = null;
         }

         var2.recycle();
         var1.recycle();
         return var5;
      }

      public boolean isTransportControlEnabled() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();
         boolean var8 = false;

         int var5;
         try {
            var8 = true;
            var1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
            this.mRemote.transact(5, var1, var2, 0);
            var2.readException();
            var5 = var2.readInt();
            var8 = false;
         } finally {
            if(var8) {
               var2.recycle();
               var1.recycle();
            }
         }

         boolean var6 = false;
         if(var5 != 0) {
            var6 = true;
         }

         var2.recycle();
         var1.recycle();
         return var6;
      }

      public void next() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         try {
            var1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
            this.mRemote.transact(20, var1, var2, 0);
            var2.readException();
         } finally {
            var2.recycle();
            var1.recycle();
         }

      }

      public void pause() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         try {
            var1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
            this.mRemote.transact(18, var1, var2, 0);
            var2.readException();
         } finally {
            var2.recycle();
            var1.recycle();
         }

      }

      public void play() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         try {
            var1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
            this.mRemote.transact(13, var1, var2, 0);
            var2.readException();
         } finally {
            var2.recycle();
            var1.recycle();
         }

      }

      public void playFromMediaId(String param1, Bundle param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void playFromSearch(String param1, Bundle param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void playFromUri(Uri param1, Bundle param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void previous() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         try {
            var1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
            this.mRemote.transact(21, var1, var2, 0);
            var2.readException();
         } finally {
            var2.recycle();
            var1.recycle();
         }

      }

      public void rate(RatingCompat param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void registerCallbackListener(IMediaControllerCallback param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void rewind() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         try {
            var1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
            this.mRemote.transact(23, var1, var2, 0);
            var2.readException();
         } finally {
            var2.recycle();
            var1.recycle();
         }

      }

      public void seekTo(long var1) throws RemoteException {
         Parcel var3 = Parcel.obtain();
         Parcel var4 = Parcel.obtain();

         try {
            var3.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
            var3.writeLong(var1);
            this.mRemote.transact(24, var3, var4, 0);
            var4.readException();
         } finally {
            var4.recycle();
            var3.recycle();
         }

      }

      public void sendCommand(String param1, Bundle param2, MediaSessionCompat.ResultReceiverWrapper param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void sendCustomAction(String param1, Bundle param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public boolean sendMediaButton(KeyEvent param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void setVolumeTo(int var1, int var2, String var3) throws RemoteException {
         Parcel var4 = Parcel.obtain();
         Parcel var5 = Parcel.obtain();

         try {
            var4.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
            var4.writeInt(var1);
            var4.writeInt(var2);
            var4.writeString(var3);
            this.mRemote.transact(12, var4, var5, 0);
            var5.readException();
         } finally {
            var5.recycle();
            var4.recycle();
         }

      }

      public void skipToQueueItem(long var1) throws RemoteException {
         Parcel var3 = Parcel.obtain();
         Parcel var4 = Parcel.obtain();

         try {
            var3.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
            var3.writeLong(var1);
            this.mRemote.transact(17, var3, var4, 0);
            var4.readException();
         } finally {
            var4.recycle();
            var3.recycle();
         }

      }

      public void stop() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         try {
            var1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
            this.mRemote.transact(19, var1, var2, 0);
            var2.readException();
         } finally {
            var2.recycle();
            var1.recycle();
         }

      }

      public void unregisterCallbackListener(IMediaControllerCallback param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }
   }
}
