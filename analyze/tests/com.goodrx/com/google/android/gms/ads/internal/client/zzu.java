package com.google.android.gms.ads.internal.client;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.zzp;
import com.google.android.gms.ads.internal.client.zzq;
import com.google.android.gms.ads.internal.client.zzw;
import com.google.android.gms.ads.internal.client.zzx;
import com.google.android.gms.internal.zzcf;
import com.google.android.gms.internal.zzgd;

public interface zzu extends IInterface {
   String getMediationAdapterClassName() throws RemoteException;

   void setManualImpressionsEnabled(boolean var1) throws RemoteException;

   void zza(AdSizeParcel var1) throws RemoteException;

   void zza(zzp var1) throws RemoteException;

   void zza(zzq var1) throws RemoteException;

   void zza(zzw var1) throws RemoteException;

   void zza(zzx var1) throws RemoteException;

   void zza(zzcf var1) throws RemoteException;

   void zza(zzgd var1) throws RemoteException;

   AdSizeParcel zzaN() throws RemoteException;
}
