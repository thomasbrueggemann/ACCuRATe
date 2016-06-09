package android.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.app.BackStackRecord;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManagerImpl;
import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;

final class BackStackState implements Parcelable {
   public static final Creator<BackStackState> CREATOR = new Creator() {
      public BackStackState createFromParcel(Parcel var1) {
         return new BackStackState(var1);
      }

      public BackStackState[] newArray(int var1) {
         return new BackStackState[var1];
      }
   };
   final int mBreadCrumbShortTitleRes;
   final CharSequence mBreadCrumbShortTitleText;
   final int mBreadCrumbTitleRes;
   final CharSequence mBreadCrumbTitleText;
   final int mIndex;
   final String mName;
   final int[] mOps;
   final int mTransition;
   final int mTransitionStyle;

   public BackStackState(Parcel var1) {
      this.mOps = var1.createIntArray();
      this.mTransition = var1.readInt();
      this.mTransitionStyle = var1.readInt();
      this.mName = var1.readString();
      this.mIndex = var1.readInt();
      this.mBreadCrumbTitleRes = var1.readInt();
      this.mBreadCrumbTitleText = (CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(var1);
      this.mBreadCrumbShortTitleRes = var1.readInt();
      this.mBreadCrumbShortTitleText = (CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(var1);
   }

   public BackStackState(FragmentManagerImpl var1, BackStackRecord var2) {
      int var3 = 0;

      for(BackStackRecord.class_11 var4 = var2.mHead; var4 != null; var4 = var4.next) {
         if(var4.removed != null) {
            var3 += var4.removed.size();
         }
      }

      this.mOps = new int[var3 + 7 * var2.mNumOp];
      if(!var2.mAddToBackStack) {
         throw new IllegalStateException("Not on back stack");
      } else {
         BackStackRecord.class_11 var5 = var2.mHead;

         int var21;
         for(int var6 = 0; var5 != null; var6 = var21) {
            int[] var7 = this.mOps;
            int var8 = var6 + 1;
            var7[var6] = var5.cmd;
            int[] var9 = this.mOps;
            int var10 = var8 + 1;
            int var11;
            if(var5.fragment != null) {
               var11 = var5.fragment.mIndex;
            } else {
               var11 = -1;
            }

            var9[var8] = var11;
            int[] var12 = this.mOps;
            int var13 = var10 + 1;
            var12[var10] = var5.enterAnim;
            int[] var14 = this.mOps;
            int var15 = var13 + 1;
            var14[var13] = var5.exitAnim;
            int[] var16 = this.mOps;
            int var17 = var15 + 1;
            var16[var15] = var5.popEnterAnim;
            int[] var18 = this.mOps;
            int var19 = var17 + 1;
            var18[var17] = var5.popExitAnim;
            if(var5.removed == null) {
               int[] var20 = this.mOps;
               var21 = var19 + 1;
               var20[var19] = 0;
            } else {
               int var22 = var5.removed.size();
               int[] var23 = this.mOps;
               int var24 = var19 + 1;
               var23[var19] = var22;
               int var25 = 0;

               int var26;
               int var28;
               for(var26 = var24; var25 < var22; var26 = var28) {
                  int[] var27 = this.mOps;
                  var28 = var26 + 1;
                  var27[var26] = ((Fragment)var5.removed.get(var25)).mIndex;
                  ++var25;
               }

               var21 = var26;
            }

            var5 = var5.next;
         }

         this.mTransition = var2.mTransition;
         this.mTransitionStyle = var2.mTransitionStyle;
         this.mName = var2.mName;
         this.mIndex = var2.mIndex;
         this.mBreadCrumbTitleRes = var2.mBreadCrumbTitleRes;
         this.mBreadCrumbTitleText = var2.mBreadCrumbTitleText;
         this.mBreadCrumbShortTitleRes = var2.mBreadCrumbShortTitleRes;
         this.mBreadCrumbShortTitleText = var2.mBreadCrumbShortTitleText;
      }
   }

   public int describeContents() {
      return 0;
   }

   public BackStackRecord instantiate(FragmentManagerImpl var1) {
      BackStackRecord var2 = new BackStackRecord(var1);
      int var3 = 0;

      for(int var4 = 0; var3 < this.mOps.length; ++var4) {
         BackStackRecord.class_11 var5 = new BackStackRecord.class_11();
         int[] var6 = this.mOps;
         int var7 = var3 + 1;
         var5.cmd = var6[var3];
         if(FragmentManagerImpl.DEBUG) {
            Log.v("FragmentManager", "Instantiate " + var2 + " op #" + var4 + " base fragment #" + this.mOps[var7]);
         }

         int[] var8 = this.mOps;
         int var9 = var7 + 1;
         int var10 = var8[var7];
         if(var10 >= 0) {
            var5.fragment = (Fragment)var1.mActive.get(var10);
         } else {
            var5.fragment = null;
         }

         int[] var11 = this.mOps;
         int var12 = var9 + 1;
         var5.enterAnim = var11[var9];
         int[] var13 = this.mOps;
         int var14 = var12 + 1;
         var5.exitAnim = var13[var12];
         int[] var15 = this.mOps;
         int var16 = var14 + 1;
         var5.popEnterAnim = var15[var14];
         int[] var17 = this.mOps;
         int var18 = var16 + 1;
         var5.popExitAnim = var17[var16];
         int[] var19 = this.mOps;
         int var20 = var18 + 1;
         int var21 = var19[var18];
         if(var21 > 0) {
            var5.removed = new ArrayList(var21);

            int var25;
            for(int var22 = 0; var22 < var21; var20 = var25) {
               if(FragmentManagerImpl.DEBUG) {
                  Log.v("FragmentManager", "Instantiate " + var2 + " set remove fragment #" + this.mOps[var20]);
               }

               ArrayList var23 = var1.mActive;
               int[] var24 = this.mOps;
               var25 = var20 + 1;
               Fragment var26 = (Fragment)var23.get(var24[var20]);
               var5.removed.add(var26);
               ++var22;
            }
         }

         var3 = var20;
         var2.addOp(var5);
      }

      var2.mTransition = this.mTransition;
      var2.mTransitionStyle = this.mTransitionStyle;
      var2.mName = this.mName;
      var2.mIndex = this.mIndex;
      var2.mAddToBackStack = true;
      var2.mBreadCrumbTitleRes = this.mBreadCrumbTitleRes;
      var2.mBreadCrumbTitleText = this.mBreadCrumbTitleText;
      var2.mBreadCrumbShortTitleRes = this.mBreadCrumbShortTitleRes;
      var2.mBreadCrumbShortTitleText = this.mBreadCrumbShortTitleText;
      var2.bumpBackStackNesting(1);
      return var2;
   }

   public void writeToParcel(Parcel var1, int var2) {
      var1.writeIntArray(this.mOps);
      var1.writeInt(this.mTransition);
      var1.writeInt(this.mTransitionStyle);
      var1.writeString(this.mName);
      var1.writeInt(this.mIndex);
      var1.writeInt(this.mBreadCrumbTitleRes);
      TextUtils.writeToParcel(this.mBreadCrumbTitleText, var1, 0);
      var1.writeInt(this.mBreadCrumbShortTitleRes);
      TextUtils.writeToParcel(this.mBreadCrumbShortTitleText, var1, 0);
   }
}
