package com.google.android.gms.iid;

import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.os.Build.VERSION;
import android.os.Parcelable.Creator;
import com.google.android.gms.iid.zzb;

public class MessengerCompat implements Parcelable {
   public static final Creator<MessengerCompat> CREATOR = new Creator() {
      // $FF: synthetic method
      public Object createFromParcel(Parcel var1) {
         return this.zzeO(var1);
      }

      // $FF: synthetic method
      public Object[] newArray(int var1) {
         return this.zzhm(var1);
      }

      public MessengerCompat zzeO(Parcel var1) {
         IBinder var2 = var1.readStrongBinder();
         return var2 != null?new MessengerCompat(var2):null;
      }

      public MessengerCompat[] zzhm(int var1) {
         return new MessengerCompat[var1];
      }
   };
   Messenger zzaNd;
   zzb zzaNe;

   public MessengerCompat(IBinder var1) {
      if(VERSION.SDK_INT >= 21) {
         this.zzaNd = new Messenger(var1);
      } else {
         this.zzaNe = zzb.zza.zzcd(var1);
      }
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      if(var1 == null) {
         return false;
      } else {
         try {
            boolean var3 = this.getBinder().equals(((MessengerCompat)var1).getBinder());
            return var3;
         } catch (ClassCastException var4) {
            return false;
         }
      }
   }

   public IBinder getBinder() {
      return this.zzaNd != null?this.zzaNd.getBinder():this.zzaNe.asBinder();
   }

   public int hashCode() {
      return this.getBinder().hashCode();
   }

   public void send(Message var1) throws RemoteException {
      if(this.zzaNd != null) {
         this.zzaNd.send(var1);
      } else {
         this.zzaNe.send(var1);
      }
   }

   public void writeToParcel(Parcel var1, int var2) {
      if(this.zzaNd != null) {
         var1.writeStrongBinder(this.zzaNd.getBinder());
      } else {
         var1.writeStrongBinder(this.zzaNe.asBinder());
      }
   }
}
