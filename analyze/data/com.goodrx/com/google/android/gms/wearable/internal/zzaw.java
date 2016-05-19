package com.google.android.gms.wearable.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.wearable.internal.AmsEntityUpdateParcelable;
import com.google.android.gms.wearable.internal.AncsNotificationParcelable;
import com.google.android.gms.wearable.internal.CapabilityInfoParcelable;
import com.google.android.gms.wearable.internal.ChannelEventParcelable;
import com.google.android.gms.wearable.internal.MessageEventParcelable;
import com.google.android.gms.wearable.internal.NodeParcelable;
import java.util.List;

public interface zzaw extends IInterface {
   void onConnectedNodes(List<NodeParcelable> var1) throws RemoteException;

   void zza(AmsEntityUpdateParcelable var1) throws RemoteException;

   void zza(AncsNotificationParcelable var1) throws RemoteException;

   void zza(CapabilityInfoParcelable var1) throws RemoteException;

   void zza(ChannelEventParcelable var1) throws RemoteException;

   void zza(MessageEventParcelable var1) throws RemoteException;

   void zza(NodeParcelable var1) throws RemoteException;

   void zzag(DataHolder var1) throws RemoteException;

   void zzb(NodeParcelable var1) throws RemoteException;

   public abstract static class zza extends Binder implements zzaw {
      public static zzaw zzet(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.wearable.internal.IWearableListener");
            return (zzaw)(var1 != null && var1 instanceof zzaw?(zzaw)var1:new zzaw.zza(var0));
         }
      }

      public IBinder asBinder() {
         return this;
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.wearable.internal.IWearableListener");
            int var19 = var2.readInt();
            DataHolder var20 = null;
            if(var19 != 0) {
               var20 = DataHolder.CREATOR.zzak(var2);
            }

            this.zzag(var20);
            return true;
         case 2:
            var2.enforceInterface("com.google.android.gms.wearable.internal.IWearableListener");
            int var17 = var2.readInt();
            MessageEventParcelable var18 = null;
            if(var17 != 0) {
               var18 = (MessageEventParcelable)MessageEventParcelable.CREATOR.createFromParcel(var2);
            }

            this.zza(var18);
            return true;
         case 3:
            var2.enforceInterface("com.google.android.gms.wearable.internal.IWearableListener");
            int var15 = var2.readInt();
            NodeParcelable var16 = null;
            if(var15 != 0) {
               var16 = (NodeParcelable)NodeParcelable.CREATOR.createFromParcel(var2);
            }

            this.zza(var16);
            return true;
         case 4:
            var2.enforceInterface("com.google.android.gms.wearable.internal.IWearableListener");
            int var13 = var2.readInt();
            NodeParcelable var14 = null;
            if(var13 != 0) {
               var14 = (NodeParcelable)NodeParcelable.CREATOR.createFromParcel(var2);
            }

            this.zzb(var14);
            return true;
         case 5:
            var2.enforceInterface("com.google.android.gms.wearable.internal.IWearableListener");
            this.onConnectedNodes(var2.createTypedArrayList(NodeParcelable.CREATOR));
            return true;
         case 6:
            var2.enforceInterface("com.google.android.gms.wearable.internal.IWearableListener");
            int var11 = var2.readInt();
            AncsNotificationParcelable var12 = null;
            if(var11 != 0) {
               var12 = (AncsNotificationParcelable)AncsNotificationParcelable.CREATOR.createFromParcel(var2);
            }

            this.zza(var12);
            return true;
         case 7:
            var2.enforceInterface("com.google.android.gms.wearable.internal.IWearableListener");
            int var9 = var2.readInt();
            ChannelEventParcelable var10 = null;
            if(var9 != 0) {
               var10 = (ChannelEventParcelable)ChannelEventParcelable.CREATOR.createFromParcel(var2);
            }

            this.zza(var10);
            return true;
         case 8:
            var2.enforceInterface("com.google.android.gms.wearable.internal.IWearableListener");
            int var7 = var2.readInt();
            CapabilityInfoParcelable var8 = null;
            if(var7 != 0) {
               var8 = (CapabilityInfoParcelable)CapabilityInfoParcelable.CREATOR.createFromParcel(var2);
            }

            this.zza(var8);
            return true;
         case 9:
            var2.enforceInterface("com.google.android.gms.wearable.internal.IWearableListener");
            int var5 = var2.readInt();
            AmsEntityUpdateParcelable var6 = null;
            if(var5 != 0) {
               var6 = (AmsEntityUpdateParcelable)AmsEntityUpdateParcelable.CREATOR.createFromParcel(var2);
            }

            this.zza(var6);
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.wearable.internal.IWearableListener");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class zza implements zzaw {
      private IBinder zzoz;

      zza(IBinder var1) {
         this.zzoz = var1;
      }

      public IBinder asBinder() {
         return this.zzoz;
      }

      public void onConnectedNodes(List<NodeParcelable> var1) throws RemoteException {
         Parcel var2 = Parcel.obtain();

         try {
            var2.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableListener");
            var2.writeTypedList(var1);
            this.zzoz.transact(5, var2, (Parcel)null, 1);
         } finally {
            var2.recycle();
         }

      }

      public void zza(AmsEntityUpdateParcelable param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void zza(AncsNotificationParcelable param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void zza(CapabilityInfoParcelable param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void zza(ChannelEventParcelable param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void zza(MessageEventParcelable param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void zza(NodeParcelable param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void zzag(DataHolder param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void zzb(NodeParcelable param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }
   }
}
