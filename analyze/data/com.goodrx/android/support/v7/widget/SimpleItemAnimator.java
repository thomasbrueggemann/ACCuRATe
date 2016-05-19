package android.support.v7.widget;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public abstract class SimpleItemAnimator extends RecyclerView.ItemAnimator {
   private static final boolean DEBUG = false;
   private static final String TAG = "SimpleItemAnimator";
   boolean mSupportsChangeAnimations = true;

   public abstract boolean animateAdd(RecyclerView.ViewHolder var1);

   public boolean animateAppearance(@NonNull RecyclerView.ViewHolder var1, @Nullable RecyclerView.ItemHolderInfo var2, @NonNull RecyclerView.ItemHolderInfo var3) {
      return var2 == null || var2.left == var3.left && var2.top == var3.top?this.animateAdd(var1):this.animateMove(var1, var2.left, var2.top, var3.left, var3.top);
   }

   public abstract boolean animateChange(RecyclerView.ViewHolder var1, RecyclerView.ViewHolder var2, int var3, int var4, int var5, int var6);

   public boolean animateChange(@NonNull RecyclerView.ViewHolder var1, @NonNull RecyclerView.ViewHolder var2, @NonNull RecyclerView.ItemHolderInfo var3, @NonNull RecyclerView.ItemHolderInfo var4) {
      int var5 = var3.left;
      int var6 = var3.top;
      int var7;
      int var8;
      if(var2.shouldIgnore()) {
         var7 = var3.left;
         var8 = var3.top;
      } else {
         var7 = var4.left;
         var8 = var4.top;
      }

      return this.animateChange(var1, var2, var5, var6, var7, var8);
   }

   public boolean animateDisappearance(@NonNull RecyclerView.ViewHolder var1, @NonNull RecyclerView.ItemHolderInfo var2, @Nullable RecyclerView.ItemHolderInfo var3) {
      int var4 = var2.left;
      int var5 = var2.top;
      View var6 = var1.itemView;
      int var7;
      if(var3 == null) {
         var7 = var6.getLeft();
      } else {
         var7 = var3.left;
      }

      int var8;
      if(var3 == null) {
         var8 = var6.getTop();
      } else {
         var8 = var3.top;
      }

      if(var1.isRemoved() || var4 == var7 && var5 == var8) {
         return this.animateRemove(var1);
      } else {
         var6.layout(var7, var8, var7 + var6.getWidth(), var8 + var6.getHeight());
         return this.animateMove(var1, var4, var5, var7, var8);
      }
   }

   public abstract boolean animateMove(RecyclerView.ViewHolder var1, int var2, int var3, int var4, int var5);

   public boolean animatePersistence(@NonNull RecyclerView.ViewHolder var1, @NonNull RecyclerView.ItemHolderInfo var2, @NonNull RecyclerView.ItemHolderInfo var3) {
      if(var2.left == var3.left && var2.top == var3.top) {
         this.dispatchMoveFinished(var1);
         return false;
      } else {
         return this.animateMove(var1, var2.left, var2.top, var3.left, var3.top);
      }
   }

   public abstract boolean animateRemove(RecyclerView.ViewHolder var1);

   public boolean canReuseUpdatedViewHolder(@NonNull RecyclerView.ViewHolder var1) {
      return !this.mSupportsChangeAnimations || var1.isInvalid();
   }

   public final void dispatchAddFinished(RecyclerView.ViewHolder var1) {
      this.onAddFinished(var1);
      this.dispatchAnimationFinished(var1);
   }

   public final void dispatchAddStarting(RecyclerView.ViewHolder var1) {
      this.onAddStarting(var1);
   }

   public final void dispatchChangeFinished(RecyclerView.ViewHolder var1, boolean var2) {
      this.onChangeFinished(var1, var2);
      this.dispatchAnimationFinished(var1);
   }

   public final void dispatchChangeStarting(RecyclerView.ViewHolder var1, boolean var2) {
      this.onChangeStarting(var1, var2);
   }

   public final void dispatchMoveFinished(RecyclerView.ViewHolder var1) {
      this.onMoveFinished(var1);
      this.dispatchAnimationFinished(var1);
   }

   public final void dispatchMoveStarting(RecyclerView.ViewHolder var1) {
      this.onMoveStarting(var1);
   }

   public final void dispatchRemoveFinished(RecyclerView.ViewHolder var1) {
      this.onRemoveFinished(var1);
      this.dispatchAnimationFinished(var1);
   }

   public final void dispatchRemoveStarting(RecyclerView.ViewHolder var1) {
      this.onRemoveStarting(var1);
   }

   public boolean getSupportsChangeAnimations() {
      return this.mSupportsChangeAnimations;
   }

   public void onAddFinished(RecyclerView.ViewHolder var1) {
   }

   public void onAddStarting(RecyclerView.ViewHolder var1) {
   }

   public void onChangeFinished(RecyclerView.ViewHolder var1, boolean var2) {
   }

   public void onChangeStarting(RecyclerView.ViewHolder var1, boolean var2) {
   }

   public void onMoveFinished(RecyclerView.ViewHolder var1) {
   }

   public void onMoveStarting(RecyclerView.ViewHolder var1) {
   }

   public void onRemoveFinished(RecyclerView.ViewHolder var1) {
   }

   public void onRemoveStarting(RecyclerView.ViewHolder var1) {
   }

   public void setSupportsChangeAnimations(boolean var1) {
      this.mSupportsChangeAnimations = var1;
   }
}
