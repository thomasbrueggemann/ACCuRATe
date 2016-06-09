package com.facebook.drawee.view;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.drawee.interfaces.DraweeHierarchy;
import com.facebook.drawee.view.DraweeHolder;
import java.util.ArrayList;

public class MultiDraweeHolder<DH extends DraweeHierarchy> {
   @VisibleForTesting
   ArrayList<DraweeHolder<DH>> mHolders = new ArrayList();
   @VisibleForTesting
   boolean mIsAttached = false;

   public void add(int var1, DraweeHolder<DH> var2) {
      Preconditions.checkNotNull(var2);
      Preconditions.checkElementIndex(var1, 1 + this.mHolders.size());
      this.mHolders.add(var1, var2);
      if(this.mIsAttached) {
         var2.onAttach();
      }

   }

   public void add(DraweeHolder<DH> var1) {
      this.add(this.mHolders.size(), var1);
   }

   public void clear() {
      if(this.mIsAttached) {
         for(int var1 = 0; var1 < this.mHolders.size(); ++var1) {
            ((DraweeHolder)this.mHolders.get(var1)).onDetach();
         }
      }

      this.mHolders.clear();
   }

   public void draw(Canvas var1) {
      for(int var2 = 0; var2 < this.mHolders.size(); ++var2) {
         Drawable var3 = this.get(var2).getTopLevelDrawable();
         if(var3 != null) {
            var3.draw(var1);
         }
      }

   }

   public DraweeHolder<DH> get(int var1) {
      return (DraweeHolder)this.mHolders.get(var1);
   }

   public void onAttach() {
      if(!this.mIsAttached) {
         this.mIsAttached = true;

         for(int var1 = 0; var1 < this.mHolders.size(); ++var1) {
            ((DraweeHolder)this.mHolders.get(var1)).onAttach();
         }
      }

   }

   public void onDetach() {
      if(this.mIsAttached) {
         this.mIsAttached = false;

         for(int var1 = 0; var1 < this.mHolders.size(); ++var1) {
            ((DraweeHolder)this.mHolders.get(var1)).onDetach();
         }
      }

   }

   public boolean onTouchEvent(MotionEvent var1) {
      for(int var2 = 0; var2 < this.mHolders.size(); ++var2) {
         if(((DraweeHolder)this.mHolders.get(var2)).onTouchEvent(var1)) {
            return true;
         }
      }

      return false;
   }

   public void remove(int var1) {
      DraweeHolder var2 = (DraweeHolder)this.mHolders.get(var1);
      if(this.mIsAttached) {
         var2.onDetach();
      }

      this.mHolders.remove(var1);
   }

   public int size() {
      return this.mHolders.size();
   }

   public boolean verifyDrawable(Drawable var1) {
      for(int var2 = 0; var2 < this.mHolders.size(); ++var2) {
         if(var1 == this.get(var2).getTopLevelDrawable()) {
            return true;
         }
      }

      return false;
   }
}
