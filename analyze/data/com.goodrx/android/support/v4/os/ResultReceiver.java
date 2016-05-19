package android.support.v4.os;

import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.os.Parcelable.Creator;
import android.support.v4.os.IResultReceiver;

public class ResultReceiver implements Parcelable {
   public static final Creator<ResultReceiver> CREATOR = new Creator() {
      public ResultReceiver createFromParcel(Parcel var1) {
         return new ResultReceiver(var1);
      }

      public ResultReceiver[] newArray(int var1) {
         return new ResultReceiver[var1];
      }
   };
   final Handler mHandler;
   final boolean mLocal;
   IResultReceiver mReceiver;

   public ResultReceiver(Handler var1) {
      this.mLocal = true;
      this.mHandler = var1;
   }

   ResultReceiver(Parcel var1) {
      this.mLocal = false;
      this.mHandler = null;
      this.mReceiver = IResultReceiver.Stub.asInterface(var1.readStrongBinder());
   }

   public int describeContents() {
      return 0;
   }

   protected void onReceiveResult(int var1, Bundle var2) {
   }

   public void send(int var1, Bundle var2) {
      if(this.mLocal) {
         if(this.mHandler == null) {
            this.onReceiveResult(var1, var2);
            return;
         }

         this.mHandler.post(new ResultReceiver.MyRunnable(var1, var2));
      } else if(this.mReceiver != null) {
         try {
            this.mReceiver.send(var1, var2);
            return;
         } catch (RemoteException var4) {
            return;
         }
      }

   }

   public void writeToParcel(Parcel param1, int param2) {
      // $FF: Couldn't be decompiled
   }

   class MyResultReceiver extends IResultReceiver.Stub {
      public void send(int var1, Bundle var2) {
         if(ResultReceiver.this.mHandler != null) {
            ResultReceiver.this.mHandler.post(ResultReceiver.this.new MyRunnable(var1, var2));
         } else {
            ResultReceiver.this.onReceiveResult(var1, var2);
         }
      }
   }

   class MyRunnable implements Runnable {
      final int mResultCode;
      final Bundle mResultData;

      MyRunnable(int var2, Bundle var3) {
         this.mResultCode = var2;
         this.mResultData = var3;
      }

      public void run() {
         ResultReceiver.this.onReceiveResult(this.mResultCode, this.mResultData);
      }
   }
}
