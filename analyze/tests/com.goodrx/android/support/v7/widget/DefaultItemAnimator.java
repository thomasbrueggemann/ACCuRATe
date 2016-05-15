package android.support.v7.widget;

import android.support.annotation.NonNull;
import android.support.v4.animation.AnimatorCompatHelper;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v4.view.ViewPropertyAnimatorListener;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SimpleItemAnimator;
import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DefaultItemAnimator extends SimpleItemAnimator {
   private static final boolean DEBUG;
   private ArrayList<RecyclerView.ViewHolder> mAddAnimations = new ArrayList();
   private ArrayList<ArrayList<RecyclerView.ViewHolder>> mAdditionsList = new ArrayList();
   private ArrayList<RecyclerView.ViewHolder> mChangeAnimations = new ArrayList();
   private ArrayList<ArrayList<DefaultItemAnimator.ChangeInfo>> mChangesList = new ArrayList();
   private ArrayList<RecyclerView.ViewHolder> mMoveAnimations = new ArrayList();
   private ArrayList<ArrayList<DefaultItemAnimator.MoveInfo>> mMovesList = new ArrayList();
   private ArrayList<RecyclerView.ViewHolder> mPendingAdditions = new ArrayList();
   private ArrayList<DefaultItemAnimator.ChangeInfo> mPendingChanges = new ArrayList();
   private ArrayList<DefaultItemAnimator.MoveInfo> mPendingMoves = new ArrayList();
   private ArrayList<RecyclerView.ViewHolder> mPendingRemovals = new ArrayList();
   private ArrayList<RecyclerView.ViewHolder> mRemoveAnimations = new ArrayList();

   private void animateAddImpl(final RecyclerView.ViewHolder var1) {
      final ViewPropertyAnimatorCompat var2 = ViewCompat.animate(var1.itemView);
      this.mAddAnimations.add(var1);
      var2.alpha(1.0F).setDuration(this.getAddDuration()).setListener(new DefaultItemAnimator.VpaListenerAdapter(null) {
         public void onAnimationCancel(View var1x) {
            ViewCompat.setAlpha(var1x, 1.0F);
         }

         public void onAnimationEnd(View var1x) {
            var2.setListener((ViewPropertyAnimatorListener)null);
            DefaultItemAnimator.this.dispatchAddFinished(var1);
            DefaultItemAnimator.this.mAddAnimations.remove(var1);
            DefaultItemAnimator.this.dispatchFinishedWhenDone();
         }

         public void onAnimationStart(View var1x) {
            DefaultItemAnimator.this.dispatchAddStarting(var1);
         }
      }).start();
   }

   private void animateChangeImpl(final DefaultItemAnimator.ChangeInfo var1) {
      RecyclerView.ViewHolder var2 = var1.oldHolder;
      View var3;
      if(var2 == null) {
         var3 = null;
      } else {
         var3 = var2.itemView;
      }

      RecyclerView.ViewHolder var4 = var1.newHolder;
      final View var5;
      if(var4 != null) {
         var5 = var4.itemView;
      } else {
         var5 = null;
      }

      if(var3 != null) {
         final ViewPropertyAnimatorCompat var8 = ViewCompat.animate(var3).setDuration(this.getChangeDuration());
         this.mChangeAnimations.add(var1.oldHolder);
         var8.translationX((float)(var1.toX - var1.fromX));
         var8.translationY((float)(var1.toY - var1.fromY));
         var8.alpha(0.0F).setListener(new DefaultItemAnimator.VpaListenerAdapter(null) {
            public void onAnimationEnd(View var1x) {
               var8.setListener((ViewPropertyAnimatorListener)null);
               ViewCompat.setAlpha(var1x, 1.0F);
               ViewCompat.setTranslationX(var1x, 0.0F);
               ViewCompat.setTranslationY(var1x, 0.0F);
               DefaultItemAnimator.this.dispatchChangeFinished(var1.oldHolder, true);
               DefaultItemAnimator.this.mChangeAnimations.remove(var1.oldHolder);
               DefaultItemAnimator.this.dispatchFinishedWhenDone();
            }

            public void onAnimationStart(View var1x) {
               DefaultItemAnimator.this.dispatchChangeStarting(var1.oldHolder, true);
            }
         }).start();
      }

      if(var5 != null) {
         final ViewPropertyAnimatorCompat var6 = ViewCompat.animate(var5);
         this.mChangeAnimations.add(var1.newHolder);
         var6.translationX(0.0F).translationY(0.0F).setDuration(this.getChangeDuration()).alpha(1.0F).setListener(new DefaultItemAnimator.VpaListenerAdapter(null) {
            public void onAnimationEnd(View var1x) {
               var6.setListener((ViewPropertyAnimatorListener)null);
               ViewCompat.setAlpha(var5, 1.0F);
               ViewCompat.setTranslationX(var5, 0.0F);
               ViewCompat.setTranslationY(var5, 0.0F);
               DefaultItemAnimator.this.dispatchChangeFinished(var1.newHolder, false);
               DefaultItemAnimator.this.mChangeAnimations.remove(var1.newHolder);
               DefaultItemAnimator.this.dispatchFinishedWhenDone();
            }

            public void onAnimationStart(View var1x) {
               DefaultItemAnimator.this.dispatchChangeStarting(var1.newHolder, false);
            }
         }).start();
      }

   }

   private void animateMoveImpl(final RecyclerView.ViewHolder var1, int var2, int var3, int var4, int var5) {
      View var6 = var1.itemView;
      final int var7 = var4 - var2;
      final int var8 = var5 - var3;
      if(var7 != 0) {
         ViewCompat.animate(var6).translationX(0.0F);
      }

      if(var8 != 0) {
         ViewCompat.animate(var6).translationY(0.0F);
      }

      final ViewPropertyAnimatorCompat var9 = ViewCompat.animate(var6);
      this.mMoveAnimations.add(var1);
      var9.setDuration(this.getMoveDuration()).setListener(new DefaultItemAnimator.VpaListenerAdapter(null) {
         public void onAnimationCancel(View var1x) {
            if(var7 != 0) {
               ViewCompat.setTranslationX(var1x, 0.0F);
            }

            if(var8 != 0) {
               ViewCompat.setTranslationY(var1x, 0.0F);
            }

         }

         public void onAnimationEnd(View var1x) {
            var9.setListener((ViewPropertyAnimatorListener)null);
            DefaultItemAnimator.this.dispatchMoveFinished(var1);
            DefaultItemAnimator.this.mMoveAnimations.remove(var1);
            DefaultItemAnimator.this.dispatchFinishedWhenDone();
         }

         public void onAnimationStart(View var1x) {
            DefaultItemAnimator.this.dispatchMoveStarting(var1);
         }
      }).start();
   }

   private void animateRemoveImpl(final RecyclerView.ViewHolder var1) {
      final ViewPropertyAnimatorCompat var2 = ViewCompat.animate(var1.itemView);
      this.mRemoveAnimations.add(var1);
      var2.setDuration(this.getRemoveDuration()).alpha(0.0F).setListener(new DefaultItemAnimator.VpaListenerAdapter(null) {
         public void onAnimationEnd(View var1x) {
            var2.setListener((ViewPropertyAnimatorListener)null);
            ViewCompat.setAlpha(var1x, 1.0F);
            DefaultItemAnimator.this.dispatchRemoveFinished(var1);
            DefaultItemAnimator.this.mRemoveAnimations.remove(var1);
            DefaultItemAnimator.this.dispatchFinishedWhenDone();
         }

         public void onAnimationStart(View var1x) {
            DefaultItemAnimator.this.dispatchRemoveStarting(var1);
         }
      }).start();
   }

   private void dispatchFinishedWhenDone() {
      if(!this.isRunning()) {
         this.dispatchAnimationsFinished();
      }

   }

   private void endChangeAnimation(List<DefaultItemAnimator.ChangeInfo> var1, RecyclerView.ViewHolder var2) {
      for(int var3 = -1 + var1.size(); var3 >= 0; --var3) {
         DefaultItemAnimator.ChangeInfo var4 = (DefaultItemAnimator.ChangeInfo)var1.get(var3);
         if(this.endChangeAnimationIfNecessary(var4, var2) && var4.oldHolder == null && var4.newHolder == null) {
            var1.remove(var4);
         }
      }

   }

   private void endChangeAnimationIfNecessary(DefaultItemAnimator.ChangeInfo var1) {
      if(var1.oldHolder != null) {
         this.endChangeAnimationIfNecessary(var1, var1.oldHolder);
      }

      if(var1.newHolder != null) {
         this.endChangeAnimationIfNecessary(var1, var1.newHolder);
      }

   }

   private boolean endChangeAnimationIfNecessary(DefaultItemAnimator.ChangeInfo var1, RecyclerView.ViewHolder var2) {
      boolean var3 = false;
      if(var1.newHolder == var2) {
         var1.newHolder = null;
      } else {
         if(var1.oldHolder != var2) {
            return false;
         }

         var1.oldHolder = null;
         var3 = true;
      }

      ViewCompat.setAlpha(var2.itemView, 1.0F);
      ViewCompat.setTranslationX(var2.itemView, 0.0F);
      ViewCompat.setTranslationY(var2.itemView, 0.0F);
      this.dispatchChangeFinished(var2, var3);
      return true;
   }

   private void resetAnimation(RecyclerView.ViewHolder var1) {
      AnimatorCompatHelper.clearInterpolator(var1.itemView);
      this.endAnimation(var1);
   }

   public boolean animateAdd(RecyclerView.ViewHolder var1) {
      this.resetAnimation(var1);
      ViewCompat.setAlpha(var1.itemView, 0.0F);
      this.mPendingAdditions.add(var1);
      return true;
   }

   public boolean animateChange(RecyclerView.ViewHolder var1, RecyclerView.ViewHolder var2, int var3, int var4, int var5, int var6) {
      if(var1 == var2) {
         return this.animateMove(var1, var3, var4, var5, var6);
      } else {
         float var7 = ViewCompat.getTranslationX(var1.itemView);
         float var8 = ViewCompat.getTranslationY(var1.itemView);
         float var9 = ViewCompat.getAlpha(var1.itemView);
         this.resetAnimation(var1);
         int var10 = (int)((float)(var5 - var3) - var7);
         int var11 = (int)((float)(var6 - var4) - var8);
         ViewCompat.setTranslationX(var1.itemView, var7);
         ViewCompat.setTranslationY(var1.itemView, var8);
         ViewCompat.setAlpha(var1.itemView, var9);
         if(var2 != null) {
            this.resetAnimation(var2);
            ViewCompat.setTranslationX(var2.itemView, (float)(-var10));
            ViewCompat.setTranslationY(var2.itemView, (float)(-var11));
            ViewCompat.setAlpha(var2.itemView, 0.0F);
         }

         this.mPendingChanges.add(new DefaultItemAnimator.ChangeInfo(var1, var2, var3, var4, var5, var6, null));
         return true;
      }
   }

   public boolean animateMove(RecyclerView.ViewHolder var1, int var2, int var3, int var4, int var5) {
      View var6 = var1.itemView;
      int var7 = (int)((float)var2 + ViewCompat.getTranslationX(var1.itemView));
      int var8 = (int)((float)var3 + ViewCompat.getTranslationY(var1.itemView));
      this.resetAnimation(var1);
      int var9 = var4 - var7;
      int var10 = var5 - var8;
      if(var9 == 0 && var10 == 0) {
         this.dispatchMoveFinished(var1);
         return false;
      } else {
         if(var9 != 0) {
            ViewCompat.setTranslationX(var6, (float)(-var9));
         }

         if(var10 != 0) {
            ViewCompat.setTranslationY(var6, (float)(-var10));
         }

         this.mPendingMoves.add(new DefaultItemAnimator.MoveInfo(var1, var7, var8, var4, var5, null));
         return true;
      }
   }

   public boolean animateRemove(RecyclerView.ViewHolder var1) {
      this.resetAnimation(var1);
      this.mPendingRemovals.add(var1);
      return true;
   }

   public boolean canReuseUpdatedViewHolder(@NonNull RecyclerView.ViewHolder var1, @NonNull List<Object> var2) {
      return !var2.isEmpty() || super.canReuseUpdatedViewHolder(var1, var2);
   }

   void cancelAll(List<RecyclerView.ViewHolder> var1) {
      for(int var2 = -1 + var1.size(); var2 >= 0; --var2) {
         ViewCompat.animate(((RecyclerView.ViewHolder)var1.get(var2)).itemView).cancel();
      }

   }

   public void endAnimation(RecyclerView.ViewHolder var1) {
      View var2 = var1.itemView;
      ViewCompat.animate(var2).cancel();

      for(int var3 = -1 + this.mPendingMoves.size(); var3 >= 0; --var3) {
         if(((DefaultItemAnimator.MoveInfo)this.mPendingMoves.get(var3)).holder == var1) {
            ViewCompat.setTranslationY(var2, 0.0F);
            ViewCompat.setTranslationX(var2, 0.0F);
            this.dispatchMoveFinished(var1);
            this.mPendingMoves.remove(var3);
         }
      }

      this.endChangeAnimation(this.mPendingChanges, var1);
      if(this.mPendingRemovals.remove(var1)) {
         ViewCompat.setAlpha(var2, 1.0F);
         this.dispatchRemoveFinished(var1);
      }

      if(this.mPendingAdditions.remove(var1)) {
         ViewCompat.setAlpha(var2, 1.0F);
         this.dispatchAddFinished(var1);
      }

      for(int var4 = -1 + this.mChangesList.size(); var4 >= 0; --var4) {
         ArrayList var13 = (ArrayList)this.mChangesList.get(var4);
         this.endChangeAnimation(var13, var1);
         if(var13.isEmpty()) {
            this.mChangesList.remove(var4);
         }
      }

      for(int var5 = -1 + this.mMovesList.size(); var5 >= 0; --var5) {
         ArrayList var9 = (ArrayList)this.mMovesList.get(var5);

         for(int var10 = -1 + var9.size(); var10 >= 0; --var10) {
            if(((DefaultItemAnimator.MoveInfo)var9.get(var10)).holder == var1) {
               ViewCompat.setTranslationY(var2, 0.0F);
               ViewCompat.setTranslationX(var2, 0.0F);
               this.dispatchMoveFinished(var1);
               var9.remove(var10);
               if(var9.isEmpty()) {
                  this.mMovesList.remove(var5);
               }
               break;
            }
         }
      }

      for(int var6 = -1 + this.mAdditionsList.size(); var6 >= 0; --var6) {
         ArrayList var7 = (ArrayList)this.mAdditionsList.get(var6);
         if(var7.remove(var1)) {
            ViewCompat.setAlpha(var2, 1.0F);
            this.dispatchAddFinished(var1);
            if(var7.isEmpty()) {
               this.mAdditionsList.remove(var6);
            }
         }
      }

      if(this.mRemoveAnimations.remove(var1)) {
         ;
      }

      if(this.mAddAnimations.remove(var1)) {
         ;
      }

      if(this.mChangeAnimations.remove(var1)) {
         ;
      }

      if(this.mMoveAnimations.remove(var1)) {
         ;
      }

      this.dispatchFinishedWhenDone();
   }

   public void endAnimations() {
      for(int var1 = -1 + this.mPendingMoves.size(); var1 >= 0; --var1) {
         DefaultItemAnimator.MoveInfo var25 = (DefaultItemAnimator.MoveInfo)this.mPendingMoves.get(var1);
         View var26 = var25.holder.itemView;
         ViewCompat.setTranslationY(var26, 0.0F);
         ViewCompat.setTranslationX(var26, 0.0F);
         this.dispatchMoveFinished(var25.holder);
         this.mPendingMoves.remove(var1);
      }

      for(int var2 = -1 + this.mPendingRemovals.size(); var2 >= 0; --var2) {
         this.dispatchRemoveFinished((RecyclerView.ViewHolder)this.mPendingRemovals.get(var2));
         this.mPendingRemovals.remove(var2);
      }

      for(int var3 = -1 + this.mPendingAdditions.size(); var3 >= 0; --var3) {
         RecyclerView.ViewHolder var22 = (RecyclerView.ViewHolder)this.mPendingAdditions.get(var3);
         ViewCompat.setAlpha(var22.itemView, 1.0F);
         this.dispatchAddFinished(var22);
         this.mPendingAdditions.remove(var3);
      }

      for(int var4 = -1 + this.mPendingChanges.size(); var4 >= 0; --var4) {
         this.endChangeAnimationIfNecessary((DefaultItemAnimator.ChangeInfo)this.mPendingChanges.get(var4));
      }

      this.mPendingChanges.clear();
      if(this.isRunning()) {
         for(int var5 = -1 + this.mMovesList.size(); var5 >= 0; --var5) {
            ArrayList var16 = (ArrayList)this.mMovesList.get(var5);

            for(int var17 = -1 + var16.size(); var17 >= 0; --var17) {
               DefaultItemAnimator.MoveInfo var18 = (DefaultItemAnimator.MoveInfo)var16.get(var17);
               View var19 = var18.holder.itemView;
               ViewCompat.setTranslationY(var19, 0.0F);
               ViewCompat.setTranslationX(var19, 0.0F);
               this.dispatchMoveFinished(var18.holder);
               var16.remove(var17);
               if(var16.isEmpty()) {
                  this.mMovesList.remove(var16);
               }
            }
         }

         for(int var6 = -1 + this.mAdditionsList.size(); var6 >= 0; --var6) {
            ArrayList var11 = (ArrayList)this.mAdditionsList.get(var6);

            for(int var12 = -1 + var11.size(); var12 >= 0; --var12) {
               RecyclerView.ViewHolder var13 = (RecyclerView.ViewHolder)var11.get(var12);
               ViewCompat.setAlpha(var13.itemView, 1.0F);
               this.dispatchAddFinished(var13);
               var11.remove(var12);
               if(var11.isEmpty()) {
                  this.mAdditionsList.remove(var11);
               }
            }
         }

         for(int var7 = -1 + this.mChangesList.size(); var7 >= 0; --var7) {
            ArrayList var8 = (ArrayList)this.mChangesList.get(var7);

            for(int var9 = -1 + var8.size(); var9 >= 0; --var9) {
               this.endChangeAnimationIfNecessary((DefaultItemAnimator.ChangeInfo)var8.get(var9));
               if(var8.isEmpty()) {
                  this.mChangesList.remove(var8);
               }
            }
         }

         this.cancelAll(this.mRemoveAnimations);
         this.cancelAll(this.mMoveAnimations);
         this.cancelAll(this.mAddAnimations);
         this.cancelAll(this.mChangeAnimations);
         this.dispatchAnimationsFinished();
      }
   }

   public boolean isRunning() {
      return !this.mPendingAdditions.isEmpty() || !this.mPendingChanges.isEmpty() || !this.mPendingMoves.isEmpty() || !this.mPendingRemovals.isEmpty() || !this.mMoveAnimations.isEmpty() || !this.mRemoveAnimations.isEmpty() || !this.mAddAnimations.isEmpty() || !this.mChangeAnimations.isEmpty() || !this.mMovesList.isEmpty() || !this.mAdditionsList.isEmpty() || !this.mChangesList.isEmpty();
   }

   public void runPendingAnimations() {
      boolean var1;
      if(!this.mPendingRemovals.isEmpty()) {
         var1 = true;
      } else {
         var1 = false;
      }

      boolean var2;
      if(!this.mPendingMoves.isEmpty()) {
         var2 = true;
      } else {
         var2 = false;
      }

      boolean var3;
      if(!this.mPendingChanges.isEmpty()) {
         var3 = true;
      } else {
         var3 = false;
      }

      boolean var4;
      if(!this.mPendingAdditions.isEmpty()) {
         var4 = true;
      } else {
         var4 = false;
      }

      if(var1 || var2 || var4 || var3) {
         Iterator var5 = this.mPendingRemovals.iterator();

         while(var5.hasNext()) {
            this.animateRemoveImpl((RecyclerView.ViewHolder)var5.next());
         }

         this.mPendingRemovals.clear();
         if(var2) {
            final ArrayList var6 = new ArrayList();
            var6.addAll(this.mPendingMoves);
            this.mMovesList.add(var6);
            this.mPendingMoves.clear();
            Runnable var9 = new Runnable() {
               public void run() {
                  Iterator var1 = var6.iterator();

                  while(var1.hasNext()) {
                     DefaultItemAnimator.MoveInfo var3 = (DefaultItemAnimator.MoveInfo)var1.next();
                     DefaultItemAnimator.this.animateMoveImpl(var3.holder, var3.fromX, var3.fromY, var3.toX, var3.toY);
                  }

                  var6.clear();
                  DefaultItemAnimator.this.mMovesList.remove(var6);
               }
            };
            if(var1) {
               ViewCompat.postOnAnimationDelayed(((DefaultItemAnimator.MoveInfo)var6.get(0)).holder.itemView, var9, this.getRemoveDuration());
            } else {
               var9.run();
            }
         }

         if(var3) {
            final ArrayList var10 = new ArrayList();
            var10.addAll(this.mPendingChanges);
            this.mChangesList.add(var10);
            this.mPendingChanges.clear();
            Runnable var13 = new Runnable() {
               public void run() {
                  Iterator var1 = var10.iterator();

                  while(var1.hasNext()) {
                     DefaultItemAnimator.ChangeInfo var3 = (DefaultItemAnimator.ChangeInfo)var1.next();
                     DefaultItemAnimator.this.animateChangeImpl(var3);
                  }

                  var10.clear();
                  DefaultItemAnimator.this.mChangesList.remove(var10);
               }
            };
            if(var1) {
               ViewCompat.postOnAnimationDelayed(((DefaultItemAnimator.ChangeInfo)var10.get(0)).oldHolder.itemView, var13, this.getRemoveDuration());
            } else {
               var13.run();
            }
         }

         if(var4) {
            final ArrayList var14 = new ArrayList();
            var14.addAll(this.mPendingAdditions);
            this.mAdditionsList.add(var14);
            this.mPendingAdditions.clear();
            Runnable var17 = new Runnable() {
               public void run() {
                  Iterator var1 = var14.iterator();

                  while(var1.hasNext()) {
                     RecyclerView.ViewHolder var3 = (RecyclerView.ViewHolder)var1.next();
                     DefaultItemAnimator.this.animateAddImpl(var3);
                  }

                  var14.clear();
                  DefaultItemAnimator.this.mAdditionsList.remove(var14);
               }
            };
            if(!var1 && !var2 && !var3) {
               var17.run();
               return;
            }

            long var18;
            if(var1) {
               var18 = this.getRemoveDuration();
            } else {
               var18 = 0L;
            }

            long var20;
            if(var2) {
               var20 = this.getMoveDuration();
            } else {
               var20 = 0L;
            }

            long var22;
            if(var3) {
               var22 = this.getChangeDuration();
            } else {
               var22 = 0L;
            }

            long var24 = var18 + Math.max(var20, var22);
            ViewCompat.postOnAnimationDelayed(((RecyclerView.ViewHolder)var14.get(0)).itemView, var17, var24);
            return;
         }
      }

   }

   private static class ChangeInfo {
      public int fromX;
      public int fromY;
      public RecyclerView.ViewHolder newHolder;
      public RecyclerView.ViewHolder oldHolder;
      public int toX;
      public int toY;

      private ChangeInfo(RecyclerView.ViewHolder var1, RecyclerView.ViewHolder var2) {
         this.oldHolder = var1;
         this.newHolder = var2;
      }

      private ChangeInfo(RecyclerView.ViewHolder var1, RecyclerView.ViewHolder var2, int var3, int var4, int var5, int var6) {
         this(var1, var2);
         this.fromX = var3;
         this.fromY = var4;
         this.toX = var5;
         this.toY = var6;
      }

      // $FF: synthetic method
      ChangeInfo(RecyclerView.ViewHolder var1, RecyclerView.ViewHolder var2, int var3, int var4, int var5, int var6, Object var7) {
         this(var1, var2, var3, var4, var5, var6);
      }

      public String toString() {
         return "ChangeInfo{oldHolder=" + this.oldHolder + ", newHolder=" + this.newHolder + ", fromX=" + this.fromX + ", fromY=" + this.fromY + ", toX=" + this.toX + ", toY=" + this.toY + '}';
      }
   }

   private static class MoveInfo {
      public int fromX;
      public int fromY;
      public RecyclerView.ViewHolder holder;
      public int toX;
      public int toY;

      private MoveInfo(RecyclerView.ViewHolder var1, int var2, int var3, int var4, int var5) {
         this.holder = var1;
         this.fromX = var2;
         this.fromY = var3;
         this.toX = var4;
         this.toY = var5;
      }

      // $FF: synthetic method
      MoveInfo(RecyclerView.ViewHolder var1, int var2, int var3, int var4, int var5, Object var6) {
         this(var1, var2, var3, var4, var5);
      }
   }

   private static class VpaListenerAdapter implements ViewPropertyAnimatorListener {
      private VpaListenerAdapter() {
      }

      // $FF: synthetic method
      VpaListenerAdapter(Object var1) {
         this();
      }

      public void onAnimationCancel(View var1) {
      }

      public void onAnimationEnd(View var1) {
      }

      public void onAnimationStart(View var1) {
      }
   }
}
