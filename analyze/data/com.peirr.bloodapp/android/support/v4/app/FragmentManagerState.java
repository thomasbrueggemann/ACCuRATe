package android.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.app.BackStackState;
import android.support.v4.app.FragmentState;

final class FragmentManagerState implements Parcelable {
   public static final Creator<FragmentManagerState> CREATOR = new Creator() {
      public FragmentManagerState createFromParcel(Parcel var1) {
         return new FragmentManagerState(var1);
      }

      public FragmentManagerState[] newArray(int var1) {
         return new FragmentManagerState[var1];
      }
   };
   FragmentState[] mActive;
   int[] mAdded;
   BackStackState[] mBackStack;

   public FragmentManagerState() {
   }

   public FragmentManagerState(Parcel var1) {
      this.mActive = (FragmentState[])var1.createTypedArray(FragmentState.CREATOR);
      this.mAdded = var1.createIntArray();
      this.mBackStack = (BackStackState[])var1.createTypedArray(BackStackState.CREATOR);
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      var1.writeTypedArray(this.mActive, var2);
      var1.writeIntArray(this.mAdded);
      var1.writeTypedArray(this.mBackStack, var2);
   }
}
