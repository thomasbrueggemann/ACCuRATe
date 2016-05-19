package com.google.android.gms.common.internal;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.internal.GetServiceRequest;
import com.google.android.gms.common.internal.ValidateAccountRequest;
import com.google.android.gms.common.internal.zzr;

public interface zzs extends IInterface {
   void zza(zzr var1, int var2) throws RemoteException;

   void zza(zzr var1, int var2, String var3) throws RemoteException;

   void zza(zzr var1, int var2, String var3, Bundle var4) throws RemoteException;

   void zza(zzr var1, int var2, String var3, IBinder var4, Bundle var5) throws RemoteException;

   void zza(zzr var1, int var2, String var3, String var4) throws RemoteException;

   void zza(zzr var1, int var2, String var3, String var4, String var5, String[] var6) throws RemoteException;

   void zza(zzr var1, int var2, String var3, String var4, String[] var5) throws RemoteException;

   void zza(zzr var1, int var2, String var3, String var4, String[] var5, Bundle var6) throws RemoteException;

   void zza(zzr var1, int var2, String var3, String var4, String[] var5, String var6, Bundle var7) throws RemoteException;

   void zza(zzr var1, int var2, String var3, String var4, String[] var5, String var6, IBinder var7, String var8, Bundle var9) throws RemoteException;

   void zza(zzr var1, int var2, String var3, String[] var4, String var5, Bundle var6) throws RemoteException;

   void zza(zzr var1, GetServiceRequest var2) throws RemoteException;

   void zza(zzr var1, ValidateAccountRequest var2) throws RemoteException;

   void zzb(zzr var1, int var2, String var3) throws RemoteException;

   void zzb(zzr var1, int var2, String var3, Bundle var4) throws RemoteException;

   void zzc(zzr var1, int var2, String var3) throws RemoteException;

   void zzc(zzr var1, int var2, String var3, Bundle var4) throws RemoteException;

   void zzd(zzr var1, int var2, String var3) throws RemoteException;

   void zzd(zzr var1, int var2, String var3, Bundle var4) throws RemoteException;

   void zze(zzr var1, int var2, String var3) throws RemoteException;

   void zze(zzr var1, int var2, String var3, Bundle var4) throws RemoteException;

   void zzf(zzr var1, int var2, String var3) throws RemoteException;

   void zzf(zzr var1, int var2, String var3, Bundle var4) throws RemoteException;

   void zzg(zzr var1, int var2, String var3) throws RemoteException;

   void zzg(zzr var1, int var2, String var3, Bundle var4) throws RemoteException;

   void zzh(zzr var1, int var2, String var3) throws RemoteException;

   void zzh(zzr var1, int var2, String var3, Bundle var4) throws RemoteException;

   void zzi(zzr var1, int var2, String var3) throws RemoteException;

   void zzi(zzr var1, int var2, String var3, Bundle var4) throws RemoteException;

   void zzj(zzr var1, int var2, String var3) throws RemoteException;

   void zzj(zzr var1, int var2, String var3, Bundle var4) throws RemoteException;

   void zzk(zzr var1, int var2, String var3) throws RemoteException;

   void zzk(zzr var1, int var2, String var3, Bundle var4) throws RemoteException;

   void zzl(zzr var1, int var2, String var3) throws RemoteException;

   void zzl(zzr var1, int var2, String var3, Bundle var4) throws RemoteException;

   void zzm(zzr var1, int var2, String var3) throws RemoteException;

   void zzm(zzr var1, int var2, String var3, Bundle var4) throws RemoteException;

   void zzn(zzr var1, int var2, String var3, Bundle var4) throws RemoteException;

   void zzo(zzr var1, int var2, String var3, Bundle var4) throws RemoteException;

   void zzp(zzr var1, int var2, String var3, Bundle var4) throws RemoteException;

   void zzq(zzr var1, int var2, String var3, Bundle var4) throws RemoteException;

   void zzqV() throws RemoteException;

   void zzr(zzr var1, int var2, String var3, Bundle var4) throws RemoteException;

   void zzs(zzr var1, int var2, String var3, Bundle var4) throws RemoteException;

   void zzt(zzr var1, int var2, String var3, Bundle var4) throws RemoteException;

   public abstract static class zza extends Binder implements zzs {
      public static zzs zzaS(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
            return (zzs)(var1 != null && var1 instanceof zzs?(zzs)var1:new zzs.zza(var0));
         }
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
            zzr var137 = zzr.zza.zzaR(var2.readStrongBinder());
            int var138 = var2.readInt();
            String var139 = var2.readString();
            String var140 = var2.readString();
            String[] var141 = var2.createStringArray();
            String var142 = var2.readString();
            Bundle var143;
            if(var2.readInt() != 0) {
               var143 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
            } else {
               var143 = null;
            }

            this.zza(var137, var138, var139, var140, var141, var142, var143);
            var3.writeNoException();
            return true;
         case 2:
            var2.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
            zzr var132 = zzr.zza.zzaR(var2.readStrongBinder());
            int var133 = var2.readInt();
            String var134 = var2.readString();
            int var135 = var2.readInt();
            Bundle var136 = null;
            if(var135 != 0) {
               var136 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
            }

            this.zza(var132, var133, var134, var136);
            var3.writeNoException();
            return true;
         case 3:
            var2.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
            this.zza(zzr.zza.zzaR(var2.readStrongBinder()), var2.readInt(), var2.readString());
            var3.writeNoException();
            return true;
         case 4:
            var2.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
            this.zza(zzr.zza.zzaR(var2.readStrongBinder()), var2.readInt());
            var3.writeNoException();
            return true;
         case 5:
            var2.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
            zzr var127 = zzr.zza.zzaR(var2.readStrongBinder());
            int var128 = var2.readInt();
            String var129 = var2.readString();
            int var130 = var2.readInt();
            Bundle var131 = null;
            if(var130 != 0) {
               var131 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
            }

            this.zzb(var127, var128, var129, var131);
            var3.writeNoException();
            return true;
         case 6:
            var2.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
            zzr var122 = zzr.zza.zzaR(var2.readStrongBinder());
            int var123 = var2.readInt();
            String var124 = var2.readString();
            int var125 = var2.readInt();
            Bundle var126 = null;
            if(var125 != 0) {
               var126 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
            }

            this.zzc(var122, var123, var124, var126);
            var3.writeNoException();
            return true;
         case 7:
            var2.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
            zzr var117 = zzr.zza.zzaR(var2.readStrongBinder());
            int var118 = var2.readInt();
            String var119 = var2.readString();
            int var120 = var2.readInt();
            Bundle var121 = null;
            if(var120 != 0) {
               var121 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
            }

            this.zzd(var117, var118, var119, var121);
            var3.writeNoException();
            return true;
         case 8:
            var2.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
            zzr var112 = zzr.zza.zzaR(var2.readStrongBinder());
            int var113 = var2.readInt();
            String var114 = var2.readString();
            int var115 = var2.readInt();
            Bundle var116 = null;
            if(var115 != 0) {
               var116 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
            }

            this.zze(var112, var113, var114, var116);
            var3.writeNoException();
            return true;
         case 9:
            var2.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
            zzr var103 = zzr.zza.zzaR(var2.readStrongBinder());
            int var104 = var2.readInt();
            String var105 = var2.readString();
            String var106 = var2.readString();
            String[] var107 = var2.createStringArray();
            String var108 = var2.readString();
            IBinder var109 = var2.readStrongBinder();
            String var110 = var2.readString();
            Bundle var111;
            if(var2.readInt() != 0) {
               var111 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
            } else {
               var111 = null;
            }

            this.zza(var103, var104, var105, var106, var107, var108, var109, var110, var111);
            var3.writeNoException();
            return true;
         case 10:
            var2.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
            this.zza(zzr.zza.zzaR(var2.readStrongBinder()), var2.readInt(), var2.readString(), var2.readString(), var2.createStringArray());
            var3.writeNoException();
            return true;
         case 11:
            var2.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
            zzr var98 = zzr.zza.zzaR(var2.readStrongBinder());
            int var99 = var2.readInt();
            String var100 = var2.readString();
            int var101 = var2.readInt();
            Bundle var102 = null;
            if(var101 != 0) {
               var102 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
            }

            this.zzf(var98, var99, var100, var102);
            var3.writeNoException();
            return true;
         case 12:
            var2.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
            zzr var93 = zzr.zza.zzaR(var2.readStrongBinder());
            int var94 = var2.readInt();
            String var95 = var2.readString();
            int var96 = var2.readInt();
            Bundle var97 = null;
            if(var96 != 0) {
               var97 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
            }

            this.zzg(var93, var94, var95, var97);
            var3.writeNoException();
            return true;
         case 13:
            var2.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
            zzr var88 = zzr.zza.zzaR(var2.readStrongBinder());
            int var89 = var2.readInt();
            String var90 = var2.readString();
            int var91 = var2.readInt();
            Bundle var92 = null;
            if(var91 != 0) {
               var92 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
            }

            this.zzh(var88, var89, var90, var92);
            var3.writeNoException();
            return true;
         case 14:
            var2.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
            zzr var83 = zzr.zza.zzaR(var2.readStrongBinder());
            int var84 = var2.readInt();
            String var85 = var2.readString();
            int var86 = var2.readInt();
            Bundle var87 = null;
            if(var86 != 0) {
               var87 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
            }

            this.zzi(var83, var84, var85, var87);
            var3.writeNoException();
            return true;
         case 15:
            var2.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
            zzr var78 = zzr.zza.zzaR(var2.readStrongBinder());
            int var79 = var2.readInt();
            String var80 = var2.readString();
            int var81 = var2.readInt();
            Bundle var82 = null;
            if(var81 != 0) {
               var82 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
            }

            this.zzj(var78, var79, var80, var82);
            var3.writeNoException();
            return true;
         case 16:
            var2.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
            zzr var73 = zzr.zza.zzaR(var2.readStrongBinder());
            int var74 = var2.readInt();
            String var75 = var2.readString();
            int var76 = var2.readInt();
            Bundle var77 = null;
            if(var76 != 0) {
               var77 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
            }

            this.zzk(var73, var74, var75, var77);
            var3.writeNoException();
            return true;
         case 17:
            var2.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
            zzr var68 = zzr.zza.zzaR(var2.readStrongBinder());
            int var69 = var2.readInt();
            String var70 = var2.readString();
            int var71 = var2.readInt();
            Bundle var72 = null;
            if(var71 != 0) {
               var72 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
            }

            this.zzl(var68, var69, var70, var72);
            var3.writeNoException();
            return true;
         case 18:
            var2.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
            zzr var63 = zzr.zza.zzaR(var2.readStrongBinder());
            int var64 = var2.readInt();
            String var65 = var2.readString();
            int var66 = var2.readInt();
            Bundle var67 = null;
            if(var66 != 0) {
               var67 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
            }

            this.zzm(var63, var64, var65, var67);
            var3.writeNoException();
            return true;
         case 19:
            var2.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
            zzr var58 = zzr.zza.zzaR(var2.readStrongBinder());
            int var59 = var2.readInt();
            String var60 = var2.readString();
            IBinder var61 = var2.readStrongBinder();
            Bundle var62;
            if(var2.readInt() != 0) {
               var62 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
            } else {
               var62 = null;
            }

            this.zza(var58, var59, var60, var61, var62);
            var3.writeNoException();
            return true;
         case 20:
            var2.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
            zzr var52 = zzr.zza.zzaR(var2.readStrongBinder());
            int var53 = var2.readInt();
            String var54 = var2.readString();
            String[] var55 = var2.createStringArray();
            String var56 = var2.readString();
            Bundle var57;
            if(var2.readInt() != 0) {
               var57 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
            } else {
               var57 = null;
            }

            this.zza(var52, var53, var54, var55, var56, var57);
            var3.writeNoException();
            return true;
         case 21:
            var2.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
            this.zzb(zzr.zza.zzaR(var2.readStrongBinder()), var2.readInt(), var2.readString());
            var3.writeNoException();
            return true;
         case 22:
            var2.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
            this.zzc(zzr.zza.zzaR(var2.readStrongBinder()), var2.readInt(), var2.readString());
            var3.writeNoException();
            return true;
         case 23:
            var2.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
            zzr var47 = zzr.zza.zzaR(var2.readStrongBinder());
            int var48 = var2.readInt();
            String var49 = var2.readString();
            int var50 = var2.readInt();
            Bundle var51 = null;
            if(var50 != 0) {
               var51 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
            }

            this.zzn(var47, var48, var49, var51);
            var3.writeNoException();
            return true;
         case 24:
            var2.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
            this.zzd(zzr.zza.zzaR(var2.readStrongBinder()), var2.readInt(), var2.readString());
            var3.writeNoException();
            return true;
         case 25:
            var2.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
            zzr var42 = zzr.zza.zzaR(var2.readStrongBinder());
            int var43 = var2.readInt();
            String var44 = var2.readString();
            int var45 = var2.readInt();
            Bundle var46 = null;
            if(var45 != 0) {
               var46 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
            }

            this.zzo(var42, var43, var44, var46);
            var3.writeNoException();
            return true;
         case 26:
            var2.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
            this.zze(zzr.zza.zzaR(var2.readStrongBinder()), var2.readInt(), var2.readString());
            var3.writeNoException();
            return true;
         case 27:
            var2.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
            zzr var37 = zzr.zza.zzaR(var2.readStrongBinder());
            int var38 = var2.readInt();
            String var39 = var2.readString();
            int var40 = var2.readInt();
            Bundle var41 = null;
            if(var40 != 0) {
               var41 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
            }

            this.zzp(var37, var38, var39, var41);
            var3.writeNoException();
            return true;
         case 28:
            var2.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
            this.zzqV();
            var3.writeNoException();
            return true;
         case 30:
            var2.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
            zzr var31 = zzr.zza.zzaR(var2.readStrongBinder());
            int var32 = var2.readInt();
            String var33 = var2.readString();
            String var34 = var2.readString();
            String[] var35 = var2.createStringArray();
            Bundle var36;
            if(var2.readInt() != 0) {
               var36 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
            } else {
               var36 = null;
            }

            this.zza(var31, var32, var33, var34, var35, var36);
            var3.writeNoException();
            return true;
         case 31:
            var2.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
            this.zzf(zzr.zza.zzaR(var2.readStrongBinder()), var2.readInt(), var2.readString());
            var3.writeNoException();
            return true;
         case 32:
            var2.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
            this.zzg(zzr.zza.zzaR(var2.readStrongBinder()), var2.readInt(), var2.readString());
            var3.writeNoException();
            return true;
         case 33:
            var2.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
            this.zza(zzr.zza.zzaR(var2.readStrongBinder()), var2.readInt(), var2.readString(), var2.readString(), var2.readString(), var2.createStringArray());
            var3.writeNoException();
            return true;
         case 34:
            var2.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
            this.zza(zzr.zza.zzaR(var2.readStrongBinder()), var2.readInt(), var2.readString(), var2.readString());
            var3.writeNoException();
            return true;
         case 35:
            var2.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
            this.zzh(zzr.zza.zzaR(var2.readStrongBinder()), var2.readInt(), var2.readString());
            var3.writeNoException();
            return true;
         case 36:
            var2.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
            this.zzi(zzr.zza.zzaR(var2.readStrongBinder()), var2.readInt(), var2.readString());
            var3.writeNoException();
            return true;
         case 37:
            var2.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
            zzr var26 = zzr.zza.zzaR(var2.readStrongBinder());
            int var27 = var2.readInt();
            String var28 = var2.readString();
            int var29 = var2.readInt();
            Bundle var30 = null;
            if(var29 != 0) {
               var30 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
            }

            this.zzq(var26, var27, var28, var30);
            var3.writeNoException();
            return true;
         case 38:
            var2.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
            zzr var21 = zzr.zza.zzaR(var2.readStrongBinder());
            int var22 = var2.readInt();
            String var23 = var2.readString();
            int var24 = var2.readInt();
            Bundle var25 = null;
            if(var24 != 0) {
               var25 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
            }

            this.zzr(var21, var22, var23, var25);
            var3.writeNoException();
            return true;
         case 40:
            var2.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
            this.zzj(zzr.zza.zzaR(var2.readStrongBinder()), var2.readInt(), var2.readString());
            var3.writeNoException();
            return true;
         case 41:
            var2.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
            zzr var16 = zzr.zza.zzaR(var2.readStrongBinder());
            int var17 = var2.readInt();
            String var18 = var2.readString();
            int var19 = var2.readInt();
            Bundle var20 = null;
            if(var19 != 0) {
               var20 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
            }

            this.zzs(var16, var17, var18, var20);
            var3.writeNoException();
            return true;
         case 42:
            var2.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
            this.zzk(zzr.zza.zzaR(var2.readStrongBinder()), var2.readInt(), var2.readString());
            var3.writeNoException();
            return true;
         case 43:
            var2.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
            zzr var11 = zzr.zza.zzaR(var2.readStrongBinder());
            int var12 = var2.readInt();
            String var13 = var2.readString();
            int var14 = var2.readInt();
            Bundle var15 = null;
            if(var14 != 0) {
               var15 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
            }

            this.zzt(var11, var12, var13, var15);
            var3.writeNoException();
            return true;
         case 44:
            var2.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
            this.zzl(zzr.zza.zzaR(var2.readStrongBinder()), var2.readInt(), var2.readString());
            var3.writeNoException();
            return true;
         case 45:
            var2.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
            this.zzm(zzr.zza.zzaR(var2.readStrongBinder()), var2.readInt(), var2.readString());
            var3.writeNoException();
            return true;
         case 46:
            var2.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
            zzr var8 = zzr.zza.zzaR(var2.readStrongBinder());
            int var9 = var2.readInt();
            GetServiceRequest var10 = null;
            if(var9 != 0) {
               var10 = (GetServiceRequest)GetServiceRequest.CREATOR.createFromParcel(var2);
            }

            this.zza(var8, var10);
            var3.writeNoException();
            return true;
         case 47:
            var2.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
            zzr var5 = zzr.zza.zzaR(var2.readStrongBinder());
            int var6 = var2.readInt();
            ValidateAccountRequest var7 = null;
            if(var6 != 0) {
               var7 = (ValidateAccountRequest)ValidateAccountRequest.CREATOR.createFromParcel(var2);
            }

            this.zza(var5, var7);
            var3.writeNoException();
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.common.internal.IGmsServiceBroker");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class zza implements zzs {
      private IBinder zzoz;

      zza(IBinder var1) {
         this.zzoz = var1;
      }

      public IBinder asBinder() {
         return this.zzoz;
      }

      public void zza(zzr param1, int param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void zza(zzr param1, int param2, String param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void zza(zzr param1, int param2, String param3, Bundle param4) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void zza(zzr param1, int param2, String param3, IBinder param4, Bundle param5) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void zza(zzr param1, int param2, String param3, String param4) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void zza(zzr param1, int param2, String param3, String param4, String param5, String[] param6) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void zza(zzr param1, int param2, String param3, String param4, String[] param5) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void zza(zzr param1, int param2, String param3, String param4, String[] param5, Bundle param6) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void zza(zzr param1, int param2, String param3, String param4, String[] param5, String param6, Bundle param7) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void zza(zzr param1, int param2, String param3, String param4, String[] param5, String param6, IBinder param7, String param8, Bundle param9) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void zza(zzr param1, int param2, String param3, String[] param4, String param5, Bundle param6) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void zza(zzr param1, GetServiceRequest param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void zza(zzr param1, ValidateAccountRequest param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void zzb(zzr param1, int param2, String param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void zzb(zzr param1, int param2, String param3, Bundle param4) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void zzc(zzr param1, int param2, String param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void zzc(zzr param1, int param2, String param3, Bundle param4) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void zzd(zzr param1, int param2, String param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void zzd(zzr param1, int param2, String param3, Bundle param4) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void zze(zzr param1, int param2, String param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void zze(zzr param1, int param2, String param3, Bundle param4) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void zzf(zzr param1, int param2, String param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void zzf(zzr param1, int param2, String param3, Bundle param4) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void zzg(zzr param1, int param2, String param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void zzg(zzr param1, int param2, String param3, Bundle param4) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void zzh(zzr param1, int param2, String param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void zzh(zzr param1, int param2, String param3, Bundle param4) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void zzi(zzr param1, int param2, String param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void zzi(zzr param1, int param2, String param3, Bundle param4) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void zzj(zzr param1, int param2, String param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void zzj(zzr param1, int param2, String param3, Bundle param4) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void zzk(zzr param1, int param2, String param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void zzk(zzr param1, int param2, String param3, Bundle param4) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void zzl(zzr param1, int param2, String param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void zzl(zzr param1, int param2, String param3, Bundle param4) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void zzm(zzr param1, int param2, String param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void zzm(zzr param1, int param2, String param3, Bundle param4) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void zzn(zzr param1, int param2, String param3, Bundle param4) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void zzo(zzr param1, int param2, String param3, Bundle param4) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void zzp(zzr param1, int param2, String param3, Bundle param4) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void zzq(zzr param1, int param2, String param3, Bundle param4) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void zzqV() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         try {
            var1.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
            this.zzoz.transact(28, var1, var2, 0);
            var2.readException();
         } finally {
            var2.recycle();
            var1.recycle();
         }

      }

      public void zzr(zzr param1, int param2, String param3, Bundle param4) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void zzs(zzr param1, int param2, String param3, Bundle param4) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void zzt(zzr param1, int param2, String param3, Bundle param4) throws RemoteException {
         // $FF: Couldn't be decompiled
      }
   }
}
