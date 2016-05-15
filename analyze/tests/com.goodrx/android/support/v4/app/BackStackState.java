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
   final ArrayList<String> mSharedElementSourceNames;
   final ArrayList<String> mSharedElementTargetNames;
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
      this.mSharedElementSourceNames = var1.createStringArrayList();
      this.mSharedElementTargetNames = var1.createStringArrayList();
   }

   public BackStackState(BackStackRecord var1) {
      int var2 = 0;

      for(BackStackRecord.class_103 var3 = var1.mHead; var3 != null; var3 = var3.next) {
         if(var3.removed != null) {
            var2 += var3.removed.size();
         }
      }

      this.mOps = new int[var2 + 7 * var1.mNumOp];
      if(!var1.mAddToBackStack) {
         throw new IllegalStateException("Not on back stack");
      } else {
         BackStackRecord.class_103 var4 = var1.mHead;

         int var20;
         for(int var5 = 0; var4 != null; var5 = var20) {
            int[] var6 = this.mOps;
            int var7 = var5 + 1;
            var6[var5] = var4.cmd;
            int[] var8 = this.mOps;
            int var9 = var7 + 1;
            int var10;
            if(var4.fragment != null) {
               var10 = var4.fragment.mIndex;
            } else {
               var10 = -1;
            }

            var8[var7] = var10;
            int[] var11 = this.mOps;
            int var12 = var9 + 1;
            var11[var9] = var4.enterAnim;
            int[] var13 = this.mOps;
            int var14 = var12 + 1;
            var13[var12] = var4.exitAnim;
            int[] var15 = this.mOps;
            int var16 = var14 + 1;
            var15[var14] = var4.popEnterAnim;
            int[] var17 = this.mOps;
            int var18 = var16 + 1;
            var17[var16] = var4.popExitAnim;
            if(var4.removed == null) {
               int[] var19 = this.mOps;
               var20 = var18 + 1;
               var19[var18] = 0;
            } else {
               int var21 = var4.removed.size();
               int[] var22 = this.mOps;
               int var23 = var18 + 1;
               var22[var18] = var21;
               int var24 = 0;

               int var25;
               int var27;
               for(var25 = var23; var24 < var21; var25 = var27) {
                  int[] var26 = this.mOps;
                  var27 = var25 + 1;
                  var26[var25] = ((Fragment)var4.removed.get(var24)).mIndex;
                  ++var24;
               }

               var20 = var25;
            }

            var4 = var4.next;
         }

         this.mTransition = var1.mTransition;
         this.mTransitionStyle = var1.mTransitionStyle;
         this.mName = var1.mName;
         this.mIndex = var1.mIndex;
         this.mBreadCrumbTitleRes = var1.mBreadCrumbTitleRes;
         this.mBreadCrumbTitleText = var1.mBreadCrumbTitleText;
         this.mBreadCrumbShortTitleRes = var1.mBreadCrumbShortTitleRes;
         this.mBreadCrumbShortTitleText = var1.mBreadCrumbShortTitleText;
         this.mSharedElementSourceNames = var1.mSharedElementSourceNames;
         this.mSharedElementTargetNames = var1.mSharedElementTargetNames;
      }
   }

   public int describeContents() {
      return 0;
   }

   public BackStackRecord instantiate(FragmentManagerImpl var1) {
      BackStackRecord var2 = new BackStackRecord(var1);
      int var3 = 0;

      for(int var4 = 0; var3 < this.mOps.length; ++var4) {
         BackStackRecord.class_103 var5 = new BackStackRecord.class_103();
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
      var2.mSharedElementSourceNames = this.mSharedElementSourceNames;
      var2.mSharedElementTargetNames = this.mSharedElementTargetNames;
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
      var1.writeStringList(this.mSharedElementSourceNames);
      var1.writeStringList(this.mSharedElementTargetNames);
   }
}
