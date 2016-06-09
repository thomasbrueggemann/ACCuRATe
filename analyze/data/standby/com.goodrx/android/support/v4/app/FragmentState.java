package android.support.v4.app;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentHostCallback;
import android.support.v4.app.FragmentManagerImpl;
import android.util.Log;

final class FragmentState implements Parcelable {
   public static final Creator<FragmentState> CREATOR = new Creator() {
      public FragmentState createFromParcel(Parcel var1) {
         return new FragmentState(var1);
      }

      public FragmentState[] newArray(int var1) {
         return new FragmentState[var1];
      }
   };
   final Bundle mArguments;
   final String mClassName;
   final int mContainerId;
   final boolean mDetached;
   final int mFragmentId;
   final boolean mFromLayout;
   final int mIndex;
   Fragment mInstance;
   final boolean mRetainInstance;
   Bundle mSavedFragmentState;
   final String mTag;

   public FragmentState(Parcel var1) {
      boolean var2 = true;
      super();
      this.mClassName = var1.readString();
      this.mIndex = var1.readInt();
      boolean var3;
      if(var1.readInt() != 0) {
         var3 = var2;
      } else {
         var3 = false;
      }

      this.mFromLayout = var3;
      this.mFragmentId = var1.readInt();
      this.mContainerId = var1.readInt();
      this.mTag = var1.readString();
      boolean var4;
      if(var1.readInt() != 0) {
         var4 = var2;
      } else {
         var4 = false;
      }

      this.mRetainInstance = var4;
      if(var1.readInt() == 0) {
         var2 = false;
      }

      this.mDetached = var2;
      this.mArguments = var1.readBundle();
      this.mSavedFragmentState = var1.readBundle();
   }

   public FragmentState(Fragment var1) {
      this.mClassName = var1.getClass().getName();
      this.mIndex = var1.mIndex;
      this.mFromLayout = var1.mFromLayout;
      this.mFragmentId = var1.mFragmentId;
      this.mContainerId = var1.mContainerId;
      this.mTag = var1.mTag;
      this.mRetainInstance = var1.mRetainInstance;
      this.mDetached = var1.mDetached;
      this.mArguments = var1.mArguments;
   }

   public int describeContents() {
      return 0;
   }

   public Fragment instantiate(FragmentHostCallback var1, Fragment var2) {
      if(this.mInstance != null) {
         return this.mInstance;
      } else {
         Context var3 = var1.getContext();
         if(this.mArguments != null) {
            this.mArguments.setClassLoader(var3.getClassLoader());
         }

         this.mInstance = Fragment.instantiate(var3, this.mClassName, this.mArguments);
         if(this.mSavedFragmentState != null) {
            this.mSavedFragmentState.setClassLoader(var3.getClassLoader());
            this.mInstance.mSavedFragmentState = this.mSavedFragmentState;
         }

         this.mInstance.setIndex(this.mIndex, var2);
         this.mInstance.mFromLayout = this.mFromLayout;
         this.mInstance.mRestored = true;
         this.mInstance.mFragmentId = this.mFragmentId;
         this.mInstance.mContainerId = this.mContainerId;
         this.mInstance.mTag = this.mTag;
         this.mInstance.mRetainInstance = this.mRetainInstance;
         this.mInstance.mDetached = this.mDetached;
         this.mInstance.mFragmentManager = var1.mFragmentManager;
         if(FragmentManagerImpl.DEBUG) {
            Log.v("FragmentManager", "Instantiated fragment " + this.mInstance);
         }

         return this.mInstance;
      }
   }

   public void writeToParcel(Parcel var1, int var2) {
      byte var3 = 1;
      var1.writeString(this.mClassName);
      var1.writeInt(this.mIndex);
      byte var4;
      if(this.mFromLayout) {
         var4 = var3;
      } else {
         var4 = 0;
      }

      var1.writeInt(var4);
      var1.writeInt(this.mFragmentId);
      var1.writeInt(this.mContainerId);
      var1.writeString(this.mTag);
      byte var5;
      if(this.mRetainInstance) {
         var5 = var3;
      } else {
         var5 = 0;
      }

      var1.writeInt(var5);
      if(!this.mDetached) {
         var3 = 0;
      }

      var1.writeInt(var3);
      var1.writeBundle(this.mArguments);
      var1.writeBundle(this.mSavedFragmentState);
   }
}
