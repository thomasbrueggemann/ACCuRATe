package android.support.graphics.drawable;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.Resources.Theme;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.Build.VERSION;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.graphics.drawable.AndroidResources;
import android.support.graphics.drawable.VectorDrawableCommon;
import android.support.graphics.drawable.VectorDrawableCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.util.ArrayMap;
import android.util.AttributeSet;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

@TargetApi(21)
public class AnimatedVectorDrawableCompat extends VectorDrawableCommon implements Animatable {
   private static final String ANIMATED_VECTOR = "animated-vector";
   private static final boolean DBG_ANIMATION_VECTOR_DRAWABLE = false;
   private static final String LOGTAG = "AnimatedVDCompat";
   private static final String TARGET = "target";
   private AnimatedVectorDrawableCompat.AnimatedVectorDrawableCompatState mAnimatedVectorState;
   private ArgbEvaluator mArgbEvaluator;
   AnimatedVectorDrawableCompat.AnimatedVectorDrawableDelegateState mCachedConstantStateDelegate;
   private final Callback mCallback;
   private Context mContext;

   private AnimatedVectorDrawableCompat() {
      this((Context)null, (AnimatedVectorDrawableCompat.AnimatedVectorDrawableCompatState)null, (Resources)null);
   }

   private AnimatedVectorDrawableCompat(@Nullable Context var1) {
      this(var1, (AnimatedVectorDrawableCompat.AnimatedVectorDrawableCompatState)null, (Resources)null);
   }

   private AnimatedVectorDrawableCompat(@Nullable Context var1, @Nullable AnimatedVectorDrawableCompat.AnimatedVectorDrawableCompatState var2, @Nullable Resources var3) {
      this.mArgbEvaluator = null;
      this.mCallback = new Callback() {
         public void invalidateDrawable(Drawable var1) {
            AnimatedVectorDrawableCompat.this.invalidateSelf();
         }

         public void scheduleDrawable(Drawable var1, Runnable var2, long var3) {
            AnimatedVectorDrawableCompat.this.scheduleSelf(var2, var3);
         }

         public void unscheduleDrawable(Drawable var1, Runnable var2) {
            AnimatedVectorDrawableCompat.this.unscheduleSelf(var2);
         }
      };
      this.mContext = var1;
      if(var2 != null) {
         this.mAnimatedVectorState = var2;
      } else {
         this.mAnimatedVectorState = new AnimatedVectorDrawableCompat.AnimatedVectorDrawableCompatState(var1, var2, this.mCallback, var3);
      }
   }

   // $FF: synthetic method
   AnimatedVectorDrawableCompat(Object var1) {
      this();
   }

   @Nullable
   public static AnimatedVectorDrawableCompat create(@NonNull Context param0, @DrawableRes int param1) {
      // $FF: Couldn't be decompiled
   }

   public static AnimatedVectorDrawableCompat createFromXmlInner(Context var0, Resources var1, XmlPullParser var2, AttributeSet var3, Theme var4) throws XmlPullParserException, IOException {
      AnimatedVectorDrawableCompat var5 = new AnimatedVectorDrawableCompat(var0);
      var5.inflate(var1, var2, var3, var4);
      return var5;
   }

   private boolean isStarted() {
      ArrayList var1 = this.mAnimatedVectorState.mAnimators;
      if(var1 != null) {
         int var2 = var1.size();

         for(int var3 = 0; var3 < var2; ++var3) {
            if(((Animator)var1.get(var3)).isRunning()) {
               return true;
            }
         }
      }

      return false;
   }

   static TypedArray obtainAttributes(Resources var0, Theme var1, AttributeSet var2, int[] var3) {
      return var1 == null?var0.obtainAttributes(var2, var3):var1.obtainStyledAttributes(var2, var3, 0, 0);
   }

   private void setupAnimatorsForTarget(String var1, Animator var2) {
      var2.setTarget(this.mAnimatedVectorState.mVectorDrawable.getTargetByName(var1));
      if(VERSION.SDK_INT < 21) {
         this.setupColorAnimator(var2);
      }

      if(this.mAnimatedVectorState.mAnimators == null) {
         this.mAnimatedVectorState.mAnimators = new ArrayList();
         this.mAnimatedVectorState.mTargetNameMap = new ArrayMap();
      }

      this.mAnimatedVectorState.mAnimators.add(var2);
      this.mAnimatedVectorState.mTargetNameMap.put(var2, var1);
   }

   private void setupColorAnimator(Animator var1) {
      if(var1 instanceof AnimatorSet) {
         ArrayList var4 = ((AnimatorSet)var1).getChildAnimations();
         if(var4 != null) {
            for(int var5 = 0; var5 < var4.size(); ++var5) {
               this.setupColorAnimator((Animator)var4.get(var5));
            }
         }
      }

      if(var1 instanceof ObjectAnimator) {
         ObjectAnimator var2 = (ObjectAnimator)var1;
         String var3 = var2.getPropertyName();
         if("fillColor".equals(var3) || "strokeColor".equals(var3)) {
            if(this.mArgbEvaluator == null) {
               this.mArgbEvaluator = new ArgbEvaluator();
            }

            var2.setEvaluator(this.mArgbEvaluator);
         }
      }

   }

   public void applyTheme(Theme var1) {
      if(this.mDelegateDrawable != null) {
         DrawableCompat.applyTheme(this.mDelegateDrawable, var1);
      }

   }

   public boolean canApplyTheme() {
      return this.mDelegateDrawable != null?DrawableCompat.canApplyTheme(this.mDelegateDrawable):false;
   }

   public void draw(Canvas var1) {
      if(this.mDelegateDrawable != null) {
         this.mDelegateDrawable.draw(var1);
      } else {
         this.mAnimatedVectorState.mVectorDrawable.draw(var1);
         if(this.isStarted()) {
            this.invalidateSelf();
            return;
         }
      }

   }

   public int getAlpha() {
      return this.mDelegateDrawable != null?DrawableCompat.getAlpha(this.mDelegateDrawable):this.mAnimatedVectorState.mVectorDrawable.getAlpha();
   }

   public int getChangingConfigurations() {
      return this.mDelegateDrawable != null?this.mDelegateDrawable.getChangingConfigurations():super.getChangingConfigurations() | this.mAnimatedVectorState.mChangingConfigurations;
   }

   public ConstantState getConstantState() {
      return this.mDelegateDrawable != null?new AnimatedVectorDrawableCompat.AnimatedVectorDrawableDelegateState(this.mDelegateDrawable.getConstantState()):null;
   }

   public int getIntrinsicHeight() {
      return this.mDelegateDrawable != null?this.mDelegateDrawable.getIntrinsicHeight():this.mAnimatedVectorState.mVectorDrawable.getIntrinsicHeight();
   }

   public int getIntrinsicWidth() {
      return this.mDelegateDrawable != null?this.mDelegateDrawable.getIntrinsicWidth():this.mAnimatedVectorState.mVectorDrawable.getIntrinsicWidth();
   }

   public int getOpacity() {
      return this.mDelegateDrawable != null?this.mDelegateDrawable.getOpacity():this.mAnimatedVectorState.mVectorDrawable.getOpacity();
   }

   public void inflate(Resources var1, XmlPullParser var2, AttributeSet var3) throws XmlPullParserException, IOException {
      this.inflate(var1, var2, var3, (Theme)null);
   }

   public void inflate(Resources var1, XmlPullParser var2, AttributeSet var3, Theme var4) throws XmlPullParserException, IOException {
      if(this.mDelegateDrawable != null) {
         DrawableCompat.inflate(this.mDelegateDrawable, var1, var2, var3, var4);
      } else {
         for(int var5 = var2.getEventType(); var5 != 1; var5 = var2.next()) {
            if(var5 == 2) {
               String var6 = var2.getName();
               if("animated-vector".equals(var6)) {
                  TypedArray var10 = obtainAttributes(var1, var4, var3, AndroidResources.styleable_AnimatedVectorDrawable);
                  int var11 = var10.getResourceId(0, 0);
                  if(var11 != 0) {
                     VectorDrawableCompat var12 = VectorDrawableCompat.create(var1, var11, var4);
                     var12.setAllowCaching(false);
                     var12.setCallback(this.mCallback);
                     if(this.mAnimatedVectorState.mVectorDrawable != null) {
                        this.mAnimatedVectorState.mVectorDrawable.setCallback((Callback)null);
                     }

                     this.mAnimatedVectorState.mVectorDrawable = var12;
                  }

                  var10.recycle();
               } else if("target".equals(var6)) {
                  TypedArray var7 = var1.obtainAttributes(var3, AndroidResources.styleable_AnimatedVectorDrawableTarget);
                  String var8 = var7.getString(0);
                  int var9 = var7.getResourceId(1, 0);
                  if(var9 != 0) {
                     if(this.mContext == null) {
                        throw new IllegalStateException("Context can\'t be null when inflating animators");
                     }

                     this.setupAnimatorsForTarget(var8, AnimatorInflater.loadAnimator(this.mContext, var9));
                  }

                  var7.recycle();
               }
            }
         }
      }

   }

   public boolean isRunning() {
      if(this.mDelegateDrawable != null) {
         return ((AnimatedVectorDrawable)this.mDelegateDrawable).isRunning();
      } else {
         ArrayList var1 = this.mAnimatedVectorState.mAnimators;
         int var2 = var1.size();

         for(int var3 = 0; var3 < var2; ++var3) {
            if(((Animator)var1.get(var3)).isRunning()) {
               return true;
            }
         }

         return false;
      }
   }

   public boolean isStateful() {
      return this.mDelegateDrawable != null?this.mDelegateDrawable.isStateful():this.mAnimatedVectorState.mVectorDrawable.isStateful();
   }

   public Drawable mutate() {
      if(this.mDelegateDrawable != null) {
         this.mDelegateDrawable.mutate();
         return this;
      } else {
         throw new IllegalStateException("Mutate() is not supported for older platform");
      }
   }

   protected void onBoundsChange(Rect var1) {
      if(this.mDelegateDrawable != null) {
         this.mDelegateDrawable.setBounds(var1);
      } else {
         this.mAnimatedVectorState.mVectorDrawable.setBounds(var1);
      }
   }

   protected boolean onLevelChange(int var1) {
      return this.mDelegateDrawable != null?this.mDelegateDrawable.setLevel(var1):this.mAnimatedVectorState.mVectorDrawable.setLevel(var1);
   }

   protected boolean onStateChange(int[] var1) {
      return this.mDelegateDrawable != null?this.mDelegateDrawable.setState(var1):this.mAnimatedVectorState.mVectorDrawable.setState(var1);
   }

   public void setAlpha(int var1) {
      if(this.mDelegateDrawable != null) {
         this.mDelegateDrawable.setAlpha(var1);
      } else {
         this.mAnimatedVectorState.mVectorDrawable.setAlpha(var1);
      }
   }

   public void setColorFilter(ColorFilter var1) {
      if(this.mDelegateDrawable != null) {
         this.mDelegateDrawable.setColorFilter(var1);
      } else {
         this.mAnimatedVectorState.mVectorDrawable.setColorFilter(var1);
      }
   }

   public void setTint(int var1) {
      if(this.mDelegateDrawable != null) {
         DrawableCompat.setTint(this.mDelegateDrawable, var1);
      } else {
         this.mAnimatedVectorState.mVectorDrawable.setTint(var1);
      }
   }

   public void setTintList(ColorStateList var1) {
      if(this.mDelegateDrawable != null) {
         DrawableCompat.setTintList(this.mDelegateDrawable, var1);
      } else {
         this.mAnimatedVectorState.mVectorDrawable.setTintList(var1);
      }
   }

   public void setTintMode(Mode var1) {
      if(this.mDelegateDrawable != null) {
         DrawableCompat.setTintMode(this.mDelegateDrawable, var1);
      } else {
         this.mAnimatedVectorState.mVectorDrawable.setTintMode(var1);
      }
   }

   public boolean setVisible(boolean var1, boolean var2) {
      if(this.mDelegateDrawable != null) {
         return this.mDelegateDrawable.setVisible(var1, var2);
      } else {
         this.mAnimatedVectorState.mVectorDrawable.setVisible(var1, var2);
         return super.setVisible(var1, var2);
      }
   }

   public void start() {
      if(this.mDelegateDrawable != null) {
         ((AnimatedVectorDrawable)this.mDelegateDrawable).start();
      } else if(!this.isStarted()) {
         ArrayList var1 = this.mAnimatedVectorState.mAnimators;
         int var2 = var1.size();

         for(int var3 = 0; var3 < var2; ++var3) {
            ((Animator)var1.get(var3)).start();
         }

         this.invalidateSelf();
         return;
      }

   }

   public void stop() {
      if(this.mDelegateDrawable != null) {
         ((AnimatedVectorDrawable)this.mDelegateDrawable).stop();
      } else {
         ArrayList var1 = this.mAnimatedVectorState.mAnimators;
         int var2 = var1.size();

         for(int var3 = 0; var3 < var2; ++var3) {
            ((Animator)var1.get(var3)).end();
         }
      }

   }

   private static class AnimatedVectorDrawableCompatState extends ConstantState {
      ArrayList<Animator> mAnimators;
      int mChangingConfigurations;
      ArrayMap<Animator, String> mTargetNameMap;
      VectorDrawableCompat mVectorDrawable;

      public AnimatedVectorDrawableCompatState(Context var1, AnimatedVectorDrawableCompat.AnimatedVectorDrawableCompatState var2, Callback var3, Resources var4) {
         if(var2 != null) {
            this.mChangingConfigurations = var2.mChangingConfigurations;
            if(var2.mVectorDrawable != null) {
               ConstantState var12 = var2.mVectorDrawable.getConstantState();
               if(var4 != null) {
                  this.mVectorDrawable = (VectorDrawableCompat)var12.newDrawable(var4);
               } else {
                  this.mVectorDrawable = (VectorDrawableCompat)var12.newDrawable();
               }

               this.mVectorDrawable = (VectorDrawableCompat)this.mVectorDrawable.mutate();
               this.mVectorDrawable.setCallback(var3);
               this.mVectorDrawable.setBounds(var2.mVectorDrawable.getBounds());
               this.mVectorDrawable.setAllowCaching(false);
            }

            if(var2.mAnimators != null) {
               int var5 = var2.mAnimators.size();
               this.mAnimators = new ArrayList(var5);
               this.mTargetNameMap = new ArrayMap(var5);

               for(int var6 = 0; var6 < var5; ++var6) {
                  Animator var7 = (Animator)var2.mAnimators.get(var6);
                  Animator var8 = var7.clone();
                  String var9 = (String)var2.mTargetNameMap.get(var7);
                  var8.setTarget(this.mVectorDrawable.getTargetByName(var9));
                  this.mAnimators.add(var8);
                  this.mTargetNameMap.put(var8, var9);
               }
            }
         }

      }

      public int getChangingConfigurations() {
         return this.mChangingConfigurations;
      }

      public Drawable newDrawable() {
         throw new IllegalStateException("No constant state support for SDK < 21.");
      }

      public Drawable newDrawable(Resources var1) {
         throw new IllegalStateException("No constant state support for SDK < 21.");
      }
   }

   private static class AnimatedVectorDrawableDelegateState extends ConstantState {
      private final ConstantState mDelegateState;

      public AnimatedVectorDrawableDelegateState(ConstantState var1) {
         this.mDelegateState = var1;
      }

      public boolean canApplyTheme() {
         return this.mDelegateState.canApplyTheme();
      }

      public int getChangingConfigurations() {
         return this.mDelegateState.getChangingConfigurations();
      }

      public Drawable newDrawable() {
         AnimatedVectorDrawableCompat var1 = new AnimatedVectorDrawableCompat(null);
         var1.mDelegateDrawable = this.mDelegateState.newDrawable();
         var1.mDelegateDrawable.setCallback(var1.mCallback);
         return var1;
      }

      public Drawable newDrawable(Resources var1) {
         AnimatedVectorDrawableCompat var2 = new AnimatedVectorDrawableCompat(null);
         var2.mDelegateDrawable = this.mDelegateState.newDrawable(var1);
         var2.mDelegateDrawable.setCallback(var2.mCallback);
         return var2;
      }

      public Drawable newDrawable(Resources var1, Theme var2) {
         AnimatedVectorDrawableCompat var3 = new AnimatedVectorDrawableCompat(null);
         var3.mDelegateDrawable = this.mDelegateState.newDrawable(var1, var2);
         var3.mDelegateDrawable.setCallback(var3.mCallback);
         return var3;
      }
   }
}
