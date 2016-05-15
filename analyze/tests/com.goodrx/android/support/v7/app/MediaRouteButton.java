package android.support.v7.app;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v7.app.MediaRouteChooserDialogFragment;
import android.support.v7.app.MediaRouteDialogFactory;
import android.support.v7.app.MediaRouterThemeHelper;
import android.support.v7.media.MediaRouteSelector;
import android.support.v7.media.MediaRouter;
import android.support.v7.mediarouter.class_16;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.Toast;

public class MediaRouteButton extends View {
   private static final int[] CHECKABLE_STATE_SET = new int[]{16842911};
   private static final int[] CHECKED_STATE_SET = new int[]{16842912};
   private static final String CHOOSER_FRAGMENT_TAG = "android.support.v7.mediarouter:MediaRouteChooserDialogFragment";
   private static final String CONTROLLER_FRAGMENT_TAG = "android.support.v7.mediarouter:MediaRouteControllerDialogFragment";
   private static final String TAG = "MediaRouteButton";
   private boolean mAttachedToWindow;
   private final MediaRouteButton.MediaRouterCallback mCallback;
   private boolean mCheatSheetEnabled;
   private MediaRouteDialogFactory mDialogFactory;
   private boolean mIsConnecting;
   private int mMinHeight;
   private int mMinWidth;
   private boolean mRemoteActive;
   private Drawable mRemoteIndicator;
   private final MediaRouter mRouter;
   private MediaRouteSelector mSelector;

   public MediaRouteButton(Context var1) {
      this(var1, (AttributeSet)null);
   }

   public MediaRouteButton(Context var1, AttributeSet var2) {
      this(var1, var2, class_16.attr.mediaRouteButtonStyle);
   }

   public MediaRouteButton(Context var1, AttributeSet var2, int var3) {
      super(MediaRouterThemeHelper.createThemedContext(var1), var2, var3);
      this.mSelector = MediaRouteSelector.EMPTY;
      this.mDialogFactory = MediaRouteDialogFactory.getDefault();
      Context var4 = this.getContext();
      this.mRouter = MediaRouter.getInstance(var4);
      this.mCallback = new MediaRouteButton.MediaRouterCallback();
      TypedArray var5 = var4.obtainStyledAttributes(var2, class_16.styleable.MediaRouteButton, var3, 0);
      this.setRemoteIndicatorDrawable(var5.getDrawable(class_16.styleable.MediaRouteButton_externalRouteEnabledDrawable));
      this.mMinWidth = var5.getDimensionPixelSize(class_16.styleable.MediaRouteButton_android_minWidth, 0);
      this.mMinHeight = var5.getDimensionPixelSize(class_16.styleable.MediaRouteButton_android_minHeight, 0);
      var5.recycle();
      this.setClickable(true);
      this.setLongClickable(true);
   }

   private Activity getActivity() {
      for(Context var1 = this.getContext(); var1 instanceof ContextWrapper; var1 = ((ContextWrapper)var1).getBaseContext()) {
         if(var1 instanceof Activity) {
            return (Activity)var1;
         }
      }

      return null;
   }

   private FragmentManager getFragmentManager() {
      Activity var1 = this.getActivity();
      return var1 instanceof FragmentActivity?((FragmentActivity)var1).getSupportFragmentManager():null;
   }

   private void refreshRoute() {
      if(this.mAttachedToWindow) {
         MediaRouter.RouteInfo var1 = this.mRouter.getSelectedRoute();
         boolean var2;
         if(!var1.isDefault() && var1.matchesSelector(this.mSelector)) {
            var2 = true;
         } else {
            var2 = false;
         }

         boolean var3 = false;
         if(var2) {
            boolean var7 = var1.isConnecting();
            var3 = false;
            if(var7) {
               var3 = true;
            }
         }

         boolean var4 = this.mRemoteActive;
         boolean var5 = false;
         if(var4 != var2) {
            this.mRemoteActive = var2;
            var5 = true;
         }

         if(this.mIsConnecting != var3) {
            this.mIsConnecting = var3;
            var5 = true;
         }

         if(var5) {
            this.refreshDrawableState();
            if(this.mIsConnecting && this.mRemoteIndicator.getCurrent() instanceof AnimationDrawable) {
               AnimationDrawable var6 = (AnimationDrawable)this.mRemoteIndicator.getCurrent();
               if(!var6.isRunning()) {
                  var6.start();
               }
            }
         }

         this.setEnabled(this.mRouter.isRouteAvailable(this.mSelector, 1));
      }

   }

   protected void drawableStateChanged() {
      super.drawableStateChanged();
      if(this.mRemoteIndicator != null) {
         int[] var1 = this.getDrawableState();
         this.mRemoteIndicator.setState(var1);
         this.invalidate();
      }

   }

   @NonNull
   public MediaRouteDialogFactory getDialogFactory() {
      return this.mDialogFactory;
   }

   @NonNull
   public MediaRouteSelector getRouteSelector() {
      return this.mSelector;
   }

   public void jumpDrawablesToCurrentState() {
      if(this.getBackground() != null) {
         DrawableCompat.jumpToCurrentState(this.getBackground());
      }

      if(this.mRemoteIndicator != null) {
         DrawableCompat.jumpToCurrentState(this.mRemoteIndicator);
      }

   }

   public void onAttachedToWindow() {
      super.onAttachedToWindow();
      this.mAttachedToWindow = true;
      if(!this.mSelector.isEmpty()) {
         this.mRouter.addCallback(this.mSelector, this.mCallback);
      }

      this.refreshRoute();
   }

   protected int[] onCreateDrawableState(int var1) {
      int[] var2 = super.onCreateDrawableState(var1 + 1);
      if(this.mIsConnecting) {
         mergeDrawableStates(var2, CHECKABLE_STATE_SET);
      } else if(this.mRemoteActive) {
         mergeDrawableStates(var2, CHECKED_STATE_SET);
         return var2;
      }

      return var2;
   }

   public void onDetachedFromWindow() {
      this.mAttachedToWindow = false;
      if(!this.mSelector.isEmpty()) {
         this.mRouter.removeCallback(this.mCallback);
      }

      super.onDetachedFromWindow();
   }

   protected void onDraw(Canvas var1) {
      super.onDraw(var1);
      if(this.mRemoteIndicator != null) {
         int var2 = this.getPaddingLeft();
         int var3 = this.getWidth() - this.getPaddingRight();
         int var4 = this.getPaddingTop();
         int var5 = this.getHeight() - this.getPaddingBottom();
         int var6 = this.mRemoteIndicator.getIntrinsicWidth();
         int var7 = this.mRemoteIndicator.getIntrinsicHeight();
         int var8 = var2 + (var3 - var2 - var6) / 2;
         int var9 = var4 + (var5 - var4 - var7) / 2;
         this.mRemoteIndicator.setBounds(var8, var9, var8 + var6, var9 + var7);
         this.mRemoteIndicator.draw(var1);
      }

   }

   protected void onMeasure(int var1, int var2) {
      int var3 = MeasureSpec.getSize(var1);
      int var4 = MeasureSpec.getSize(var2);
      int var5 = MeasureSpec.getMode(var1);
      int var6 = MeasureSpec.getMode(var2);
      int var7 = this.mMinWidth;
      int var8;
      if(this.mRemoteIndicator != null) {
         var8 = this.mRemoteIndicator.getIntrinsicWidth();
      } else {
         var8 = 0;
      }

      int var9 = Math.max(var7, var8);
      int var10 = this.mMinHeight;
      Drawable var11 = this.mRemoteIndicator;
      int var12 = 0;
      if(var11 != null) {
         var12 = this.mRemoteIndicator.getIntrinsicHeight();
      }

      int var13 = Math.max(var10, var12);
      int var14;
      switch(var5) {
      case Integer.MIN_VALUE:
         var14 = Math.min(var3, var9 + this.getPaddingLeft() + this.getPaddingRight());
         break;
      case 1073741824:
         var14 = var3;
         break;
      default:
         var14 = var9 + this.getPaddingLeft() + this.getPaddingRight();
      }

      int var15;
      switch(var6) {
      case Integer.MIN_VALUE:
         var15 = Math.min(var4, var13 + this.getPaddingTop() + this.getPaddingBottom());
         break;
      case 1073741824:
         var15 = var4;
         break;
      default:
         var15 = var13 + this.getPaddingTop() + this.getPaddingBottom();
      }

      this.setMeasuredDimension(var14, var15);
   }

   public boolean performClick() {
      boolean var1 = super.performClick();
      if(!var1) {
         this.playSoundEffect(0);
      }

      boolean var2;
      if(!this.showDialog()) {
         var2 = false;
         if(!var1) {
            return var2;
         }
      }

      var2 = true;
      return var2;
   }

   public boolean performLongClick() {
      if(super.performLongClick()) {
         return true;
      } else if(!this.mCheatSheetEnabled) {
         return false;
      } else {
         CharSequence var1 = this.getContentDescription();
         if(TextUtils.isEmpty(var1)) {
            return false;
         } else {
            int[] var2 = new int[2];
            Rect var3 = new Rect();
            this.getLocationOnScreen(var2);
            this.getWindowVisibleDisplayFrame(var3);
            Context var4 = this.getContext();
            int var5 = this.getWidth();
            int var6 = this.getHeight();
            int var7 = var2[1] + var6 / 2;
            int var8 = var4.getResources().getDisplayMetrics().widthPixels;
            Toast var9 = Toast.makeText(var4, var1, 0);
            if(var7 < var3.height()) {
               var9.setGravity(8388661, var8 - var2[0] - var5 / 2, var6);
            } else {
               var9.setGravity(81, 0, var6);
            }

            var9.show();
            this.performHapticFeedback(0);
            return true;
         }
      }
   }

   void setCheatSheetEnabled(boolean var1) {
      this.mCheatSheetEnabled = var1;
   }

   public void setDialogFactory(@NonNull MediaRouteDialogFactory var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("factory must not be null");
      } else {
         this.mDialogFactory = var1;
      }
   }

   public void setRemoteIndicatorDrawable(Drawable var1) {
      if(this.mRemoteIndicator != null) {
         this.mRemoteIndicator.setCallback((Callback)null);
         this.unscheduleDrawable(this.mRemoteIndicator);
      }

      this.mRemoteIndicator = var1;
      if(var1 != null) {
         var1.setCallback(this);
         var1.setState(this.getDrawableState());
         boolean var3;
         if(this.getVisibility() == 0) {
            var3 = true;
         } else {
            var3 = false;
         }

         var1.setVisible(var3, false);
      }

      this.refreshDrawableState();
   }

   public void setRouteSelector(MediaRouteSelector var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("selector must not be null");
      } else {
         if(!this.mSelector.equals(var1)) {
            if(this.mAttachedToWindow) {
               if(!this.mSelector.isEmpty()) {
                  this.mRouter.removeCallback(this.mCallback);
               }

               if(!var1.isEmpty()) {
                  this.mRouter.addCallback(var1, this.mCallback);
               }
            }

            this.mSelector = var1;
            this.refreshRoute();
         }

      }
   }

   public void setVisibility(int var1) {
      super.setVisibility(var1);
      if(this.mRemoteIndicator != null) {
         Drawable var2 = this.mRemoteIndicator;
         boolean var3;
         if(this.getVisibility() == 0) {
            var3 = true;
         } else {
            var3 = false;
         }

         var2.setVisible(var3, false);
      }

   }

   public boolean showDialog() {
      if(!this.mAttachedToWindow) {
         return false;
      } else {
         FragmentManager var1 = this.getFragmentManager();
         if(var1 == null) {
            throw new IllegalStateException("The activity must be a subclass of FragmentActivity");
         } else {
            MediaRouter.RouteInfo var2 = this.mRouter.getSelectedRoute();
            if(!var2.isDefault() && var2.matchesSelector(this.mSelector)) {
               if(var1.findFragmentByTag("android.support.v7.mediarouter:MediaRouteControllerDialogFragment") != null) {
                  Log.w("MediaRouteButton", "showDialog(): Route controller dialog already showing!");
                  return false;
               }

               this.mDialogFactory.onCreateControllerDialogFragment().show(var1, "android.support.v7.mediarouter:MediaRouteControllerDialogFragment");
            } else {
               if(var1.findFragmentByTag("android.support.v7.mediarouter:MediaRouteChooserDialogFragment") != null) {
                  Log.w("MediaRouteButton", "showDialog(): Route chooser dialog already showing!");
                  return false;
               }

               MediaRouteChooserDialogFragment var3 = this.mDialogFactory.onCreateChooserDialogFragment();
               var3.setRouteSelector(this.mSelector);
               var3.show(var1, "android.support.v7.mediarouter:MediaRouteChooserDialogFragment");
            }

            return true;
         }
      }
   }

   protected boolean verifyDrawable(Drawable var1) {
      return super.verifyDrawable(var1) || var1 == this.mRemoteIndicator;
   }

   private final class MediaRouterCallback extends MediaRouter.Callback {
      private MediaRouterCallback() {
      }

      // $FF: synthetic method
      MediaRouterCallback(Object var2) {
         this();
      }

      public void onProviderAdded(MediaRouter var1, MediaRouter.ProviderInfo var2) {
         MediaRouteButton.this.refreshRoute();
      }

      public void onProviderChanged(MediaRouter var1, MediaRouter.ProviderInfo var2) {
         MediaRouteButton.this.refreshRoute();
      }

      public void onProviderRemoved(MediaRouter var1, MediaRouter.ProviderInfo var2) {
         MediaRouteButton.this.refreshRoute();
      }

      public void onRouteAdded(MediaRouter var1, MediaRouter.RouteInfo var2) {
         MediaRouteButton.this.refreshRoute();
      }

      public void onRouteChanged(MediaRouter var1, MediaRouter.RouteInfo var2) {
         MediaRouteButton.this.refreshRoute();
      }

      public void onRouteRemoved(MediaRouter var1, MediaRouter.RouteInfo var2) {
         MediaRouteButton.this.refreshRoute();
      }

      public void onRouteSelected(MediaRouter var1, MediaRouter.RouteInfo var2) {
         MediaRouteButton.this.refreshRoute();
      }

      public void onRouteUnselected(MediaRouter var1, MediaRouter.RouteInfo var2) {
         MediaRouteButton.this.refreshRoute();
      }
   }
}
