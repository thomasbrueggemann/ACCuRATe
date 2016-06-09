package android.support.graphics.drawable;

import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.Resources.Theme;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.Bitmap.Config;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff.Mode;
import android.graphics.Region.Op;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.graphics.drawable.AndroidResources;
import android.support.graphics.drawable.PathParser;
import android.support.graphics.drawable.TypedArrayUtils;
import android.support.graphics.drawable.VectorDrawableCommon;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.util.ArrayMap;
import android.util.AttributeSet;
import android.util.Log;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

@TargetApi(21)
public class VectorDrawableCompat extends VectorDrawableCommon {
   private static final boolean DBG_VECTOR_DRAWABLE = false;
   static final Mode DEFAULT_TINT_MODE;
   private static final int LINECAP_BUTT = 0;
   private static final int LINECAP_ROUND = 1;
   private static final int LINECAP_SQUARE = 2;
   private static final int LINEJOIN_BEVEL = 2;
   private static final int LINEJOIN_MITER = 0;
   private static final int LINEJOIN_ROUND = 1;
   static final String LOGTAG = "VectorDrawableCompat";
   private static final int MAX_CACHED_BITMAP_SIZE = 2048;
   private static final String SHAPE_CLIP_PATH = "clip-path";
   private static final String SHAPE_GROUP = "group";
   private static final String SHAPE_PATH = "path";
   private static final String SHAPE_VECTOR = "vector";
   private boolean mAllowCaching;
   private ConstantState mCachedConstantStateDelegate;
   private ColorFilter mColorFilter;
   private boolean mMutated;
   private PorterDuffColorFilter mTintFilter;
   private final Rect mTmpBounds;
   private final float[] mTmpFloats;
   private final Matrix mTmpMatrix;
   private VectorDrawableCompat.VectorDrawableCompatState mVectorState;

   static {
      DEFAULT_TINT_MODE = Mode.SRC_IN;
   }

   private VectorDrawableCompat() {
      this.mAllowCaching = true;
      this.mTmpFloats = new float[9];
      this.mTmpMatrix = new Matrix();
      this.mTmpBounds = new Rect();
      this.mVectorState = new VectorDrawableCompat.VectorDrawableCompatState();
   }

   // $FF: synthetic method
   VectorDrawableCompat(Object var1) {
      this();
   }

   private VectorDrawableCompat(@NonNull VectorDrawableCompat.VectorDrawableCompatState var1) {
      this.mAllowCaching = true;
      this.mTmpFloats = new float[9];
      this.mTmpMatrix = new Matrix();
      this.mTmpBounds = new Rect();
      this.mVectorState = var1;
      this.mTintFilter = this.updateTintFilter(this.mTintFilter, var1.mTint, var1.mTintMode);
   }

   // $FF: synthetic method
   VectorDrawableCompat(VectorDrawableCompat.VectorDrawableCompatState var1, Object var2) {
      this(var1);
   }

   private static int applyAlpha(int var0, float var1) {
      int var2 = Color.alpha(var0);
      return var0 & 16777215 | (int)(var1 * (float)var2) << 24;
   }

   @Nullable
   public static VectorDrawableCompat create(@NonNull Resources param0, @DrawableRes int param1, @Nullable Theme param2) {
      // $FF: Couldn't be decompiled
   }

   public static VectorDrawableCompat createFromXmlInner(Resources var0, XmlPullParser var1, AttributeSet var2, Theme var3) throws XmlPullParserException, IOException {
      VectorDrawableCompat var4 = new VectorDrawableCompat();
      var4.inflate(var0, var1, var2, var3);
      return var4;
   }

   private void inflateInternal(Resources var1, XmlPullParser var2, AttributeSet var3, Theme var4) throws XmlPullParserException, IOException {
      VectorDrawableCompat.VectorDrawableCompatState var5 = this.mVectorState;
      VectorDrawableCompat.VPathRenderer var6 = var5.mVPathRenderer;
      boolean var7 = true;
      Stack var8 = new Stack();
      var8.push(var6.mRootGroup);

      for(int var10 = var2.getEventType(); var10 != 1; var10 = var2.next()) {
         if(var10 == 2) {
            String var15 = var2.getName();
            VectorDrawableCompat.VGroup var16 = (VectorDrawableCompat.VGroup)var8.peek();
            if("path".equals(var15)) {
               VectorDrawableCompat.VFullPath var17 = new VectorDrawableCompat.VFullPath();
               var17.inflate(var1, var3, var4, var2);
               var16.mChildren.add(var17);
               if(var17.getPathName() != null) {
                  var6.mVGTargetsMap.put(var17.getPathName(), var17);
               }

               var7 = false;
               var5.mChangingConfigurations |= var17.mChangingConfigurations;
            } else if("clip-path".equals(var15)) {
               VectorDrawableCompat.VClipPath var20 = new VectorDrawableCompat.VClipPath();
               var20.inflate(var1, var3, var4, var2);
               var16.mChildren.add(var20);
               if(var20.getPathName() != null) {
                  var6.mVGTargetsMap.put(var20.getPathName(), var20);
               }

               var5.mChangingConfigurations |= var20.mChangingConfigurations;
            } else if("group".equals(var15)) {
               VectorDrawableCompat.VGroup var23 = new VectorDrawableCompat.VGroup();
               var23.inflate(var1, var3, var4, var2);
               var16.mChildren.add(var23);
               var8.push(var23);
               if(var23.getGroupName() != null) {
                  var6.mVGTargetsMap.put(var23.getGroupName(), var23);
               }

               var5.mChangingConfigurations |= var23.mChangingConfigurations;
            }
         } else if(var10 == 3 && "group".equals(var2.getName())) {
            var8.pop();
         }
      }

      if(var7) {
         StringBuffer var11 = new StringBuffer();
         if(var11.length() > 0) {
            var11.append(" or ");
         }

         var11.append("path");
         throw new XmlPullParserException("no " + var11 + " defined");
      }
   }

   private boolean needMirroring() {
      return false;
   }

   private static Mode parseTintModeCompat(int var0, Mode var1) {
      switch(var0) {
      case 3:
         return Mode.SRC_OVER;
      case 4:
      case 6:
      case 7:
      case 8:
      case 10:
      case 11:
      case 12:
      case 13:
      default:
         return var1;
      case 5:
         return Mode.SRC_IN;
      case 9:
         return Mode.SRC_ATOP;
      case 14:
         return Mode.MULTIPLY;
      case 15:
         return Mode.SCREEN;
      case 16:
         return Mode.ADD;
      }
   }

   private void printGroupTree(VectorDrawableCompat.VGroup var1, int var2) {
      String var3 = "";

      for(int var4 = 0; var4 < var2; ++var4) {
         var3 = var3 + "    ";
      }

      Log.v("VectorDrawableCompat", var3 + "current group is :" + var1.getGroupName() + " rotation is " + var1.mRotate);
      Log.v("VectorDrawableCompat", var3 + "matrix is :" + var1.getLocalMatrix().toString());

      for(int var7 = 0; var7 < var1.mChildren.size(); ++var7) {
         Object var8 = var1.mChildren.get(var7);
         if(var8 instanceof VectorDrawableCompat.VGroup) {
            this.printGroupTree((VectorDrawableCompat.VGroup)var8, var2 + 1);
         } else {
            ((VectorDrawableCompat.VPath)var8).printVPath(var2 + 1);
         }
      }

   }

   private void updateStateFromTypedArray(TypedArray var1, XmlPullParser var2) throws XmlPullParserException {
      VectorDrawableCompat.VectorDrawableCompatState var3 = this.mVectorState;
      VectorDrawableCompat.VPathRenderer var4 = var3.mVPathRenderer;
      var3.mTintMode = parseTintModeCompat(TypedArrayUtils.getNamedInt(var1, var2, "tintMode", 6, -1), Mode.SRC_IN);
      ColorStateList var5 = var1.getColorStateList(1);
      if(var5 != null) {
         var3.mTint = var5;
      }

      var3.mAutoMirrored = TypedArrayUtils.getNamedBoolean(var1, var2, "autoMirrored", 5, var3.mAutoMirrored);
      var4.mViewportWidth = TypedArrayUtils.getNamedFloat(var1, var2, "viewportWidth", 7, var4.mViewportWidth);
      var4.mViewportHeight = TypedArrayUtils.getNamedFloat(var1, var2, "viewportHeight", 8, var4.mViewportHeight);
      if(var4.mViewportWidth <= 0.0F) {
         throw new XmlPullParserException(var1.getPositionDescription() + "<vector> tag requires viewportWidth > 0");
      } else if(var4.mViewportHeight <= 0.0F) {
         throw new XmlPullParserException(var1.getPositionDescription() + "<vector> tag requires viewportHeight > 0");
      } else {
         var4.mBaseWidth = var1.getDimension(3, var4.mBaseWidth);
         var4.mBaseHeight = var1.getDimension(2, var4.mBaseHeight);
         if(var4.mBaseWidth <= 0.0F) {
            throw new XmlPullParserException(var1.getPositionDescription() + "<vector> tag requires width > 0");
         } else if(var4.mBaseHeight <= 0.0F) {
            throw new XmlPullParserException(var1.getPositionDescription() + "<vector> tag requires height > 0");
         } else {
            var4.setAlpha(TypedArrayUtils.getNamedFloat(var1, var2, "alpha", 4, var4.getAlpha()));
            String var6 = var1.getString(0);
            if(var6 != null) {
               var4.mRootName = var6;
               var4.mVGTargetsMap.put(var6, var4);
            }

         }
      }
   }

   public boolean canApplyTheme() {
      if(this.mDelegateDrawable != null) {
         DrawableCompat.canApplyTheme(this.mDelegateDrawable);
      }

      return false;
   }

   public void draw(Canvas var1) {
      if(this.mDelegateDrawable != null) {
         this.mDelegateDrawable.draw(var1);
      } else {
         this.copyBounds(this.mTmpBounds);
         if(this.mTmpBounds.width() > 0 && this.mTmpBounds.height() > 0) {
            Object var2;
            if(this.mColorFilter == null) {
               var2 = this.mTintFilter;
            } else {
               var2 = this.mColorFilter;
            }

            var1.getMatrix(this.mTmpMatrix);
            this.mTmpMatrix.getValues(this.mTmpFloats);
            float var3 = Math.abs(this.mTmpFloats[0]);
            float var4 = Math.abs(this.mTmpFloats[4]);
            float var5 = Math.abs(this.mTmpFloats[1]);
            float var6 = Math.abs(this.mTmpFloats[3]);
            if(var5 != 0.0F || var6 != 0.0F) {
               var3 = 1.0F;
               var4 = 1.0F;
            }

            int var7 = (int)(var3 * (float)this.mTmpBounds.width());
            int var8 = (int)(var4 * (float)this.mTmpBounds.height());
            int var9 = Math.min(2048, var7);
            int var10 = Math.min(2048, var8);
            if(var9 > 0 && var10 > 0) {
               int var11 = var1.save();
               var1.translate((float)this.mTmpBounds.left, (float)this.mTmpBounds.top);
               if(this.needMirroring()) {
                  var1.translate((float)this.mTmpBounds.width(), 0.0F);
                  var1.scale(-1.0F, 1.0F);
               }

               this.mTmpBounds.offsetTo(0, 0);
               this.mVectorState.createCachedBitmapIfNeeded(var9, var10);
               if(!this.mAllowCaching) {
                  this.mVectorState.updateCachedBitmap(var9, var10);
               } else if(!this.mVectorState.canReuseCache()) {
                  this.mVectorState.updateCachedBitmap(var9, var10);
                  this.mVectorState.updateCacheStates();
               }

               this.mVectorState.drawCachedBitmapWithRootAlpha(var1, (ColorFilter)var2, this.mTmpBounds);
               var1.restoreToCount(var11);
               return;
            }
         }
      }

   }

   public int getAlpha() {
      return this.mDelegateDrawable != null?DrawableCompat.getAlpha(this.mDelegateDrawable):this.mVectorState.mVPathRenderer.getRootAlpha();
   }

   public int getChangingConfigurations() {
      return this.mDelegateDrawable != null?this.mDelegateDrawable.getChangingConfigurations():super.getChangingConfigurations() | this.mVectorState.getChangingConfigurations();
   }

   public ConstantState getConstantState() {
      if(this.mDelegateDrawable != null) {
         return new VectorDrawableCompat.VectorDrawableDelegateState(this.mDelegateDrawable.getConstantState());
      } else {
         this.mVectorState.mChangingConfigurations = this.getChangingConfigurations();
         return this.mVectorState;
      }
   }

   public int getIntrinsicHeight() {
      return this.mDelegateDrawable != null?this.mDelegateDrawable.getIntrinsicHeight():(int)this.mVectorState.mVPathRenderer.mBaseHeight;
   }

   public int getIntrinsicWidth() {
      return this.mDelegateDrawable != null?this.mDelegateDrawable.getIntrinsicWidth():(int)this.mVectorState.mVPathRenderer.mBaseWidth;
   }

   public int getOpacity() {
      return this.mDelegateDrawable != null?this.mDelegateDrawable.getOpacity():-3;
   }

   public float getPixelSize() {
      if((this.mVectorState != null || this.mVectorState.mVPathRenderer != null) && this.mVectorState.mVPathRenderer.mBaseWidth != 0.0F && this.mVectorState.mVPathRenderer.mBaseHeight != 0.0F && this.mVectorState.mVPathRenderer.mViewportHeight != 0.0F && this.mVectorState.mVPathRenderer.mViewportWidth != 0.0F) {
         float var1 = this.mVectorState.mVPathRenderer.mBaseWidth;
         float var2 = this.mVectorState.mVPathRenderer.mBaseHeight;
         float var3 = this.mVectorState.mVPathRenderer.mViewportWidth;
         float var4 = this.mVectorState.mVPathRenderer.mViewportHeight;
         return Math.min(var3 / var1, var4 / var2);
      } else {
         return 1.0F;
      }
   }

   Object getTargetByName(String var1) {
      return this.mVectorState.mVPathRenderer.mVGTargetsMap.get(var1);
   }

   public void inflate(Resources var1, XmlPullParser var2, AttributeSet var3) throws XmlPullParserException, IOException {
      if(this.mDelegateDrawable != null) {
         this.mDelegateDrawable.inflate(var1, var2, var3);
      } else {
         this.inflate(var1, var2, var3, (Theme)null);
      }
   }

   public void inflate(Resources var1, XmlPullParser var2, AttributeSet var3, Theme var4) throws XmlPullParserException, IOException {
      if(this.mDelegateDrawable != null) {
         DrawableCompat.inflate(this.mDelegateDrawable, var1, var2, var3, var4);
      } else {
         VectorDrawableCompat.VectorDrawableCompatState var5 = this.mVectorState;
         var5.mVPathRenderer = new VectorDrawableCompat.VPathRenderer();
         TypedArray var6 = obtainAttributes(var1, var4, var3, AndroidResources.styleable_VectorDrawableTypeArray);
         this.updateStateFromTypedArray(var6, var2);
         var6.recycle();
         var5.mChangingConfigurations = this.getChangingConfigurations();
         var5.mCacheDirty = true;
         this.inflateInternal(var1, var2, var3, var4);
         this.mTintFilter = this.updateTintFilter(this.mTintFilter, var5.mTint, var5.mTintMode);
      }
   }

   public void invalidateSelf() {
      if(this.mDelegateDrawable != null) {
         this.mDelegateDrawable.invalidateSelf();
      } else {
         super.invalidateSelf();
      }
   }

   public boolean isStateful() {
      return this.mDelegateDrawable != null?this.mDelegateDrawable.isStateful():super.isStateful() || this.mVectorState != null && this.mVectorState.mTint != null && this.mVectorState.mTint.isStateful();
   }

   public Drawable mutate() {
      if(this.mDelegateDrawable != null) {
         this.mDelegateDrawable.mutate();
      } else if(!this.mMutated && super.mutate() == this) {
         this.mVectorState = new VectorDrawableCompat.VectorDrawableCompatState(this.mVectorState);
         this.mMutated = true;
         return this;
      }

      return this;
   }

   protected boolean onStateChange(int[] var1) {
      if(this.mDelegateDrawable != null) {
         return this.mDelegateDrawable.setState(var1);
      } else {
         VectorDrawableCompat.VectorDrawableCompatState var2 = this.mVectorState;
         if(var2.mTint != null && var2.mTintMode != null) {
            this.mTintFilter = this.updateTintFilter(this.mTintFilter, var2.mTint, var2.mTintMode);
            this.invalidateSelf();
            return true;
         } else {
            return false;
         }
      }
   }

   public void scheduleSelf(Runnable var1, long var2) {
      if(this.mDelegateDrawable != null) {
         this.mDelegateDrawable.scheduleSelf(var1, var2);
      } else {
         super.scheduleSelf(var1, var2);
      }
   }

   void setAllowCaching(boolean var1) {
      this.mAllowCaching = var1;
   }

   public void setAlpha(int var1) {
      if(this.mDelegateDrawable != null) {
         this.mDelegateDrawable.setAlpha(var1);
      } else if(this.mVectorState.mVPathRenderer.getRootAlpha() != var1) {
         this.mVectorState.mVPathRenderer.setRootAlpha(var1);
         this.invalidateSelf();
         return;
      }

   }

   public void setBounds(int var1, int var2, int var3, int var4) {
      if(this.mDelegateDrawable != null) {
         this.mDelegateDrawable.setBounds(var1, var2, var3, var4);
      } else {
         super.setBounds(var1, var2, var3, var4);
      }
   }

   public void setBounds(Rect var1) {
      if(this.mDelegateDrawable != null) {
         this.mDelegateDrawable.setBounds(var1);
      } else {
         super.setBounds(var1);
      }
   }

   public void setColorFilter(ColorFilter var1) {
      if(this.mDelegateDrawable != null) {
         this.mDelegateDrawable.setColorFilter(var1);
      } else {
         this.mColorFilter = var1;
         this.invalidateSelf();
      }
   }

   public void setTint(int var1) {
      if(this.mDelegateDrawable != null) {
         DrawableCompat.setTint(this.mDelegateDrawable, var1);
      } else {
         this.setTintList(ColorStateList.valueOf(var1));
      }
   }

   public void setTintList(ColorStateList var1) {
      if(this.mDelegateDrawable != null) {
         DrawableCompat.setTintList(this.mDelegateDrawable, var1);
      } else {
         VectorDrawableCompat.VectorDrawableCompatState var2 = this.mVectorState;
         if(var2.mTint != var1) {
            var2.mTint = var1;
            this.mTintFilter = this.updateTintFilter(this.mTintFilter, var1, var2.mTintMode);
            this.invalidateSelf();
            return;
         }
      }

   }

   public void setTintMode(Mode var1) {
      if(this.mDelegateDrawable != null) {
         DrawableCompat.setTintMode(this.mDelegateDrawable, var1);
      } else {
         VectorDrawableCompat.VectorDrawableCompatState var2 = this.mVectorState;
         if(var2.mTintMode != var1) {
            var2.mTintMode = var1;
            this.mTintFilter = this.updateTintFilter(this.mTintFilter, var2.mTint, var1);
            this.invalidateSelf();
            return;
         }
      }

   }

   public boolean setVisible(boolean var1, boolean var2) {
      return this.mDelegateDrawable != null?this.mDelegateDrawable.setVisible(var1, var2):super.setVisible(var1, var2);
   }

   public void unscheduleSelf(Runnable var1) {
      if(this.mDelegateDrawable != null) {
         this.mDelegateDrawable.unscheduleSelf(var1);
      } else {
         super.unscheduleSelf(var1);
      }
   }

   PorterDuffColorFilter updateTintFilter(PorterDuffColorFilter var1, ColorStateList var2, Mode var3) {
      return var2 != null && var3 != null?new PorterDuffColorFilter(var2.getColorForState(this.getState(), 0), var3):null;
   }

   private static class VClipPath extends VectorDrawableCompat.VPath {
      public VClipPath() {
      }

      public VClipPath(VectorDrawableCompat.VClipPath var1) {
         super(var1);
      }

      private void updateStateFromTypedArray(TypedArray var1) {
         String var2 = var1.getString(0);
         if(var2 != null) {
            this.mPathName = var2;
         }

         String var3 = var1.getString(1);
         if(var3 != null) {
            this.mNodes = PathParser.createNodesFromPathData(var3);
         }

      }

      public void inflate(Resources var1, AttributeSet var2, Theme var3, XmlPullParser var4) {
         if(TypedArrayUtils.hasAttribute(var4, "pathData")) {
            TypedArray var5 = VectorDrawableCommon.obtainAttributes(var1, var3, var2, AndroidResources.styleable_VectorDrawableClipPath);
            this.updateStateFromTypedArray(var5);
            var5.recycle();
         }
      }

      public boolean isClipPath() {
         return true;
      }
   }

   private static class VFullPath extends VectorDrawableCompat.VPath {
      float mFillAlpha = 1.0F;
      int mFillColor = 0;
      int mFillRule;
      float mStrokeAlpha = 1.0F;
      int mStrokeColor = 0;
      Cap mStrokeLineCap;
      Join mStrokeLineJoin;
      float mStrokeMiterlimit;
      float mStrokeWidth = 0.0F;
      private int[] mThemeAttrs;
      float mTrimPathEnd = 1.0F;
      float mTrimPathOffset = 0.0F;
      float mTrimPathStart = 0.0F;

      public VFullPath() {
         this.mStrokeLineCap = Cap.BUTT;
         this.mStrokeLineJoin = Join.MITER;
         this.mStrokeMiterlimit = 4.0F;
      }

      public VFullPath(VectorDrawableCompat.VFullPath var1) {
         super(var1);
         this.mStrokeLineCap = Cap.BUTT;
         this.mStrokeLineJoin = Join.MITER;
         this.mStrokeMiterlimit = 4.0F;
         this.mThemeAttrs = var1.mThemeAttrs;
         this.mStrokeColor = var1.mStrokeColor;
         this.mStrokeWidth = var1.mStrokeWidth;
         this.mStrokeAlpha = var1.mStrokeAlpha;
         this.mFillColor = var1.mFillColor;
         this.mFillRule = var1.mFillRule;
         this.mFillAlpha = var1.mFillAlpha;
         this.mTrimPathStart = var1.mTrimPathStart;
         this.mTrimPathEnd = var1.mTrimPathEnd;
         this.mTrimPathOffset = var1.mTrimPathOffset;
         this.mStrokeLineCap = var1.mStrokeLineCap;
         this.mStrokeLineJoin = var1.mStrokeLineJoin;
         this.mStrokeMiterlimit = var1.mStrokeMiterlimit;
      }

      private Cap getStrokeLineCap(int var1, Cap var2) {
         switch(var1) {
         case 0:
            return Cap.BUTT;
         case 1:
            return Cap.ROUND;
         case 2:
            return Cap.SQUARE;
         default:
            return var2;
         }
      }

      private Join getStrokeLineJoin(int var1, Join var2) {
         switch(var1) {
         case 0:
            return Join.MITER;
         case 1:
            return Join.ROUND;
         case 2:
            return Join.BEVEL;
         default:
            return var2;
         }
      }

      private void updateStateFromTypedArray(TypedArray var1, XmlPullParser var2) {
         this.mThemeAttrs = null;
         if(TypedArrayUtils.hasAttribute(var2, "pathData")) {
            String var3 = var1.getString(0);
            if(var3 != null) {
               this.mPathName = var3;
            }

            String var4 = var1.getString(2);
            if(var4 != null) {
               this.mNodes = PathParser.createNodesFromPathData(var4);
            }

            this.mFillColor = TypedArrayUtils.getNamedColor(var1, var2, "fillColor", 1, this.mFillColor);
            this.mFillAlpha = TypedArrayUtils.getNamedFloat(var1, var2, "fillAlpha", 12, this.mFillAlpha);
            this.mStrokeLineCap = this.getStrokeLineCap(TypedArrayUtils.getNamedInt(var1, var2, "strokeLineCap", 8, -1), this.mStrokeLineCap);
            this.mStrokeLineJoin = this.getStrokeLineJoin(TypedArrayUtils.getNamedInt(var1, var2, "strokeLineJoin", 9, -1), this.mStrokeLineJoin);
            this.mStrokeMiterlimit = TypedArrayUtils.getNamedFloat(var1, var2, "strokeMiterLimit", 10, this.mStrokeMiterlimit);
            this.mStrokeColor = TypedArrayUtils.getNamedColor(var1, var2, "strokeColor", 3, this.mStrokeColor);
            this.mStrokeAlpha = TypedArrayUtils.getNamedFloat(var1, var2, "strokeAlpha", 11, this.mStrokeAlpha);
            this.mStrokeWidth = TypedArrayUtils.getNamedFloat(var1, var2, "strokeWidth", 4, this.mStrokeWidth);
            this.mTrimPathEnd = TypedArrayUtils.getNamedFloat(var1, var2, "trimPathEnd", 6, this.mTrimPathEnd);
            this.mTrimPathOffset = TypedArrayUtils.getNamedFloat(var1, var2, "trimPathOffset", 7, this.mTrimPathOffset);
            this.mTrimPathStart = TypedArrayUtils.getNamedFloat(var1, var2, "trimPathStart", 5, this.mTrimPathStart);
         }
      }

      public void applyTheme(Theme var1) {
         if(this.mThemeAttrs == null) {
            ;
         }

      }

      public boolean canApplyTheme() {
         return this.mThemeAttrs != null;
      }

      float getFillAlpha() {
         return this.mFillAlpha;
      }

      int getFillColor() {
         return this.mFillColor;
      }

      float getStrokeAlpha() {
         return this.mStrokeAlpha;
      }

      int getStrokeColor() {
         return this.mStrokeColor;
      }

      float getStrokeWidth() {
         return this.mStrokeWidth;
      }

      float getTrimPathEnd() {
         return this.mTrimPathEnd;
      }

      float getTrimPathOffset() {
         return this.mTrimPathOffset;
      }

      float getTrimPathStart() {
         return this.mTrimPathStart;
      }

      public void inflate(Resources var1, AttributeSet var2, Theme var3, XmlPullParser var4) {
         TypedArray var5 = VectorDrawableCommon.obtainAttributes(var1, var3, var2, AndroidResources.styleable_VectorDrawablePath);
         this.updateStateFromTypedArray(var5, var4);
         var5.recycle();
      }

      void setFillAlpha(float var1) {
         this.mFillAlpha = var1;
      }

      void setFillColor(int var1) {
         this.mFillColor = var1;
      }

      void setStrokeAlpha(float var1) {
         this.mStrokeAlpha = var1;
      }

      void setStrokeColor(int var1) {
         this.mStrokeColor = var1;
      }

      void setStrokeWidth(float var1) {
         this.mStrokeWidth = var1;
      }

      void setTrimPathEnd(float var1) {
         this.mTrimPathEnd = var1;
      }

      void setTrimPathOffset(float var1) {
         this.mTrimPathOffset = var1;
      }

      void setTrimPathStart(float var1) {
         this.mTrimPathStart = var1;
      }
   }

   private static class VGroup {
      private int mChangingConfigurations;
      final ArrayList<Object> mChildren = new ArrayList();
      private String mGroupName = null;
      private final Matrix mLocalMatrix = new Matrix();
      private float mPivotX = 0.0F;
      private float mPivotY = 0.0F;
      private float mRotate = 0.0F;
      private float mScaleX = 1.0F;
      private float mScaleY = 1.0F;
      private final Matrix mStackedMatrix = new Matrix();
      private int[] mThemeAttrs;
      private float mTranslateX = 0.0F;
      private float mTranslateY = 0.0F;

      public VGroup() {
      }

      public VGroup(VectorDrawableCompat.VGroup var1, ArrayMap<String, Object> var2) {
         this.mRotate = var1.mRotate;
         this.mPivotX = var1.mPivotX;
         this.mPivotY = var1.mPivotY;
         this.mScaleX = var1.mScaleX;
         this.mScaleY = var1.mScaleY;
         this.mTranslateX = var1.mTranslateX;
         this.mTranslateY = var1.mTranslateY;
         this.mThemeAttrs = var1.mThemeAttrs;
         this.mGroupName = var1.mGroupName;
         this.mChangingConfigurations = var1.mChangingConfigurations;
         if(this.mGroupName != null) {
            var2.put(this.mGroupName, this);
         }

         this.mLocalMatrix.set(var1.mLocalMatrix);
         ArrayList var3 = var1.mChildren;

         for(int var4 = 0; var4 < var3.size(); ++var4) {
            Object var5 = var3.get(var4);
            if(var5 instanceof VectorDrawableCompat.VGroup) {
               VectorDrawableCompat.VGroup var9 = (VectorDrawableCompat.VGroup)var5;
               this.mChildren.add(new VectorDrawableCompat.VGroup(var9, var2));
            } else {
               Object var6;
               if(var5 instanceof VectorDrawableCompat.VFullPath) {
                  var6 = new VectorDrawableCompat.VFullPath((VectorDrawableCompat.VFullPath)var5);
               } else {
                  if(!(var5 instanceof VectorDrawableCompat.VClipPath)) {
                     throw new IllegalStateException("Unknown object in the tree!");
                  }

                  var6 = new VectorDrawableCompat.VClipPath((VectorDrawableCompat.VClipPath)var5);
               }

               this.mChildren.add(var6);
               if(((VectorDrawableCompat.VPath)var6).mPathName != null) {
                  var2.put(((VectorDrawableCompat.VPath)var6).mPathName, var6);
               }
            }
         }

      }

      private void updateLocalMatrix() {
         this.mLocalMatrix.reset();
         this.mLocalMatrix.postTranslate(-this.mPivotX, -this.mPivotY);
         this.mLocalMatrix.postScale(this.mScaleX, this.mScaleY);
         this.mLocalMatrix.postRotate(this.mRotate, 0.0F, 0.0F);
         this.mLocalMatrix.postTranslate(this.mTranslateX + this.mPivotX, this.mTranslateY + this.mPivotY);
      }

      private void updateStateFromTypedArray(TypedArray var1, XmlPullParser var2) {
         this.mThemeAttrs = null;
         this.mRotate = TypedArrayUtils.getNamedFloat(var1, var2, "rotation", 5, this.mRotate);
         this.mPivotX = var1.getFloat(1, this.mPivotX);
         this.mPivotY = var1.getFloat(2, this.mPivotY);
         this.mScaleX = TypedArrayUtils.getNamedFloat(var1, var2, "scaleX", 3, this.mScaleX);
         this.mScaleY = TypedArrayUtils.getNamedFloat(var1, var2, "scaleY", 4, this.mScaleY);
         this.mTranslateX = TypedArrayUtils.getNamedFloat(var1, var2, "translateX", 6, this.mTranslateX);
         this.mTranslateY = TypedArrayUtils.getNamedFloat(var1, var2, "translateY", 7, this.mTranslateY);
         String var3 = var1.getString(0);
         if(var3 != null) {
            this.mGroupName = var3;
         }

         this.updateLocalMatrix();
      }

      public String getGroupName() {
         return this.mGroupName;
      }

      public Matrix getLocalMatrix() {
         return this.mLocalMatrix;
      }

      public float getPivotX() {
         return this.mPivotX;
      }

      public float getPivotY() {
         return this.mPivotY;
      }

      public float getRotation() {
         return this.mRotate;
      }

      public float getScaleX() {
         return this.mScaleX;
      }

      public float getScaleY() {
         return this.mScaleY;
      }

      public float getTranslateX() {
         return this.mTranslateX;
      }

      public float getTranslateY() {
         return this.mTranslateY;
      }

      public void inflate(Resources var1, AttributeSet var2, Theme var3, XmlPullParser var4) {
         TypedArray var5 = VectorDrawableCommon.obtainAttributes(var1, var3, var2, AndroidResources.styleable_VectorDrawableGroup);
         this.updateStateFromTypedArray(var5, var4);
         var5.recycle();
      }

      public void setPivotX(float var1) {
         if(var1 != this.mPivotX) {
            this.mPivotX = var1;
            this.updateLocalMatrix();
         }

      }

      public void setPivotY(float var1) {
         if(var1 != this.mPivotY) {
            this.mPivotY = var1;
            this.updateLocalMatrix();
         }

      }

      public void setRotation(float var1) {
         if(var1 != this.mRotate) {
            this.mRotate = var1;
            this.updateLocalMatrix();
         }

      }

      public void setScaleX(float var1) {
         if(var1 != this.mScaleX) {
            this.mScaleX = var1;
            this.updateLocalMatrix();
         }

      }

      public void setScaleY(float var1) {
         if(var1 != this.mScaleY) {
            this.mScaleY = var1;
            this.updateLocalMatrix();
         }

      }

      public void setTranslateX(float var1) {
         if(var1 != this.mTranslateX) {
            this.mTranslateX = var1;
            this.updateLocalMatrix();
         }

      }

      public void setTranslateY(float var1) {
         if(var1 != this.mTranslateY) {
            this.mTranslateY = var1;
            this.updateLocalMatrix();
         }

      }
   }

   private static class VPath {
      int mChangingConfigurations;
      protected PathParser.PathDataNode[] mNodes = null;
      String mPathName;

      public VPath() {
      }

      public VPath(VectorDrawableCompat.VPath var1) {
         this.mPathName = var1.mPathName;
         this.mChangingConfigurations = var1.mChangingConfigurations;
         this.mNodes = PathParser.deepCopyNodes(var1.mNodes);
      }

      public String NodesToString(PathParser.PathDataNode[] var1) {
         String var2 = " ";

         for(int var3 = 0; var3 < var1.length; ++var3) {
            var2 = var2 + var1[var3].type + ":";
            float[] var4 = var1[var3].params;

            for(int var5 = 0; var5 < var4.length; ++var5) {
               var2 = var2 + var4[var5] + ",";
            }
         }

         return var2;
      }

      public void applyTheme(Theme var1) {
      }

      public boolean canApplyTheme() {
         return false;
      }

      public PathParser.PathDataNode[] getPathData() {
         return this.mNodes;
      }

      public String getPathName() {
         return this.mPathName;
      }

      public boolean isClipPath() {
         return false;
      }

      public void printVPath(int var1) {
         String var2 = "";

         for(int var3 = 0; var3 < var1; ++var3) {
            var2 = var2 + "    ";
         }

         Log.v("VectorDrawableCompat", var2 + "current path is :" + this.mPathName + " pathData is " + this.NodesToString(this.mNodes));
      }

      public void setPathData(PathParser.PathDataNode[] var1) {
         if(!PathParser.canMorph(this.mNodes, var1)) {
            this.mNodes = PathParser.deepCopyNodes(var1);
         } else {
            PathParser.updateNodes(this.mNodes, var1);
         }
      }

      public void toPath(Path var1) {
         var1.reset();
         if(this.mNodes != null) {
            PathParser.PathDataNode.nodesToPath(this.mNodes, var1);
         }

      }
   }

   private static class VPathRenderer {
      private static final Matrix IDENTITY_MATRIX = new Matrix();
      float mBaseHeight = 0.0F;
      float mBaseWidth = 0.0F;
      private int mChangingConfigurations;
      private Paint mFillPaint;
      private final Matrix mFinalPathMatrix = new Matrix();
      private final Path mPath;
      private PathMeasure mPathMeasure;
      private final Path mRenderPath;
      int mRootAlpha = 255;
      private final VectorDrawableCompat.VGroup mRootGroup;
      String mRootName = null;
      private Paint mStrokePaint;
      final ArrayMap<String, Object> mVGTargetsMap = new ArrayMap();
      float mViewportHeight = 0.0F;
      float mViewportWidth = 0.0F;

      public VPathRenderer() {
         this.mRootGroup = new VectorDrawableCompat.VGroup();
         this.mPath = new Path();
         this.mRenderPath = new Path();
      }

      public VPathRenderer(VectorDrawableCompat.VPathRenderer var1) {
         this.mRootGroup = new VectorDrawableCompat.VGroup(var1.mRootGroup, this.mVGTargetsMap);
         this.mPath = new Path(var1.mPath);
         this.mRenderPath = new Path(var1.mRenderPath);
         this.mBaseWidth = var1.mBaseWidth;
         this.mBaseHeight = var1.mBaseHeight;
         this.mViewportWidth = var1.mViewportWidth;
         this.mViewportHeight = var1.mViewportHeight;
         this.mChangingConfigurations = var1.mChangingConfigurations;
         this.mRootAlpha = var1.mRootAlpha;
         this.mRootName = var1.mRootName;
         if(var1.mRootName != null) {
            this.mVGTargetsMap.put(var1.mRootName, this);
         }

      }

      private static float cross(float var0, float var1, float var2, float var3) {
         return var0 * var3 - var1 * var2;
      }

      private void drawGroupTree(VectorDrawableCompat.VGroup var1, Matrix var2, Canvas var3, int var4, int var5, ColorFilter var6) {
         var1.mStackedMatrix.set(var2);
         var1.mStackedMatrix.preConcat(var1.mLocalMatrix);

         for(int var8 = 0; var8 < var1.mChildren.size(); ++var8) {
            Object var9 = var1.mChildren.get(var8);
            if(var9 instanceof VectorDrawableCompat.VGroup) {
               this.drawGroupTree((VectorDrawableCompat.VGroup)var9, var1.mStackedMatrix, var3, var4, var5, var6);
            } else if(var9 instanceof VectorDrawableCompat.VPath) {
               this.drawPath(var1, (VectorDrawableCompat.VPath)var9, var3, var4, var5, var6);
            }
         }

      }

      private void drawPath(VectorDrawableCompat.VGroup var1, VectorDrawableCompat.VPath var2, Canvas var3, int var4, int var5, ColorFilter var6) {
         float var7 = (float)var4 / this.mViewportWidth;
         float var8 = (float)var5 / this.mViewportHeight;
         float var9 = Math.min(var7, var8);
         Matrix var10 = var1.mStackedMatrix;
         this.mFinalPathMatrix.set(var10);
         this.mFinalPathMatrix.postScale(var7, var8);
         float var12 = this.getMatrixScale(var10);
         if(var12 != 0.0F) {
            var2.toPath(this.mPath);
            Path var13 = this.mPath;
            this.mRenderPath.reset();
            if(var2.isClipPath()) {
               this.mRenderPath.addPath(var13, this.mFinalPathMatrix);
               var3.clipPath(this.mRenderPath, Op.REPLACE);
               return;
            }

            VectorDrawableCompat.VFullPath var14 = (VectorDrawableCompat.VFullPath)var2;
            if(var14.mTrimPathStart != 0.0F || var14.mTrimPathEnd != 1.0F) {
               float var15 = (var14.mTrimPathStart + var14.mTrimPathOffset) % 1.0F;
               float var16 = (var14.mTrimPathEnd + var14.mTrimPathOffset) % 1.0F;
               if(this.mPathMeasure == null) {
                  this.mPathMeasure = new PathMeasure();
               }

               this.mPathMeasure.setPath(this.mPath, false);
               float var17 = this.mPathMeasure.getLength();
               float var18 = var15 * var17;
               float var19 = var16 * var17;
               var13.reset();
               if(var18 > var19) {
                  this.mPathMeasure.getSegment(var18, var17, var13, true);
                  this.mPathMeasure.getSegment(0.0F, var19, var13, true);
               } else {
                  this.mPathMeasure.getSegment(var18, var19, var13, true);
               }

               var13.rLineTo(0.0F, 0.0F);
            }

            this.mRenderPath.addPath(var13, this.mFinalPathMatrix);
            if(var14.mFillColor != 0) {
               if(this.mFillPaint == null) {
                  this.mFillPaint = new Paint();
                  this.mFillPaint.setStyle(Style.FILL);
                  this.mFillPaint.setAntiAlias(true);
               }

               Paint var23 = this.mFillPaint;
               var23.setColor(VectorDrawableCompat.applyAlpha(var14.mFillColor, var14.mFillAlpha));
               var23.setColorFilter(var6);
               var3.drawPath(this.mRenderPath, var23);
            }

            if(var14.mStrokeColor != 0) {
               if(this.mStrokePaint == null) {
                  this.mStrokePaint = new Paint();
                  this.mStrokePaint.setStyle(Style.STROKE);
                  this.mStrokePaint.setAntiAlias(true);
               }

               Paint var21 = this.mStrokePaint;
               if(var14.mStrokeLineJoin != null) {
                  var21.setStrokeJoin(var14.mStrokeLineJoin);
               }

               if(var14.mStrokeLineCap != null) {
                  var21.setStrokeCap(var14.mStrokeLineCap);
               }

               var21.setStrokeMiter(var14.mStrokeMiterlimit);
               var21.setColor(VectorDrawableCompat.applyAlpha(var14.mStrokeColor, var14.mStrokeAlpha));
               var21.setColorFilter(var6);
               var21.setStrokeWidth(var9 * var12 * var14.mStrokeWidth);
               var3.drawPath(this.mRenderPath, var21);
               return;
            }
         }

      }

      private float getMatrixScale(Matrix var1) {
         float[] var2 = new float[]{0.0F, 1.0F, 1.0F, 0.0F};
         var1.mapVectors(var2);
         float var3 = (float)Math.hypot((double)var2[0], (double)var2[1]);
         float var4 = (float)Math.hypot((double)var2[2], (double)var2[3]);
         float var5 = cross(var2[0], var2[1], var2[2], var2[3]);
         float var6 = Math.max(var3, var4);
         float var9;
         int var7 = (var9 = var6 - 0.0F) == 0.0F?0:(var9 < 0.0F?-1:1);
         float var8 = 0.0F;
         if(var7 > 0) {
            var8 = Math.abs(var5) / var6;
         }

         return var8;
      }

      public void draw(Canvas var1, int var2, int var3, ColorFilter var4) {
         this.drawGroupTree(this.mRootGroup, IDENTITY_MATRIX, var1, var2, var3, var4);
      }

      public float getAlpha() {
         return (float)this.getRootAlpha() / 255.0F;
      }

      public int getRootAlpha() {
         return this.mRootAlpha;
      }

      public void setAlpha(float var1) {
         this.setRootAlpha((int)(255.0F * var1));
      }

      public void setRootAlpha(int var1) {
         this.mRootAlpha = var1;
      }
   }

   private static class VectorDrawableCompatState extends ConstantState {
      boolean mAutoMirrored;
      boolean mCacheDirty;
      boolean mCachedAutoMirrored;
      Bitmap mCachedBitmap;
      int mCachedRootAlpha;
      int[] mCachedThemeAttrs;
      ColorStateList mCachedTint;
      Mode mCachedTintMode;
      int mChangingConfigurations;
      Paint mTempPaint;
      ColorStateList mTint = null;
      Mode mTintMode;
      VectorDrawableCompat.VPathRenderer mVPathRenderer;

      public VectorDrawableCompatState() {
         this.mTintMode = VectorDrawableCompat.DEFAULT_TINT_MODE;
         this.mVPathRenderer = new VectorDrawableCompat.VPathRenderer();
      }

      public VectorDrawableCompatState(VectorDrawableCompat.VectorDrawableCompatState var1) {
         this.mTintMode = VectorDrawableCompat.DEFAULT_TINT_MODE;
         if(var1 != null) {
            this.mChangingConfigurations = var1.mChangingConfigurations;
            this.mVPathRenderer = new VectorDrawableCompat.VPathRenderer(var1.mVPathRenderer);
            if(var1.mVPathRenderer.mFillPaint != null) {
               this.mVPathRenderer.mFillPaint = new Paint(var1.mVPathRenderer.mFillPaint);
            }

            if(var1.mVPathRenderer.mStrokePaint != null) {
               this.mVPathRenderer.mStrokePaint = new Paint(var1.mVPathRenderer.mStrokePaint);
            }

            this.mTint = var1.mTint;
            this.mTintMode = var1.mTintMode;
            this.mAutoMirrored = var1.mAutoMirrored;
         }

      }

      public boolean canReuseBitmap(int var1, int var2) {
         return var1 == this.mCachedBitmap.getWidth() && var2 == this.mCachedBitmap.getHeight();
      }

      public boolean canReuseCache() {
         return !this.mCacheDirty && this.mCachedTint == this.mTint && this.mCachedTintMode == this.mTintMode && this.mCachedAutoMirrored == this.mAutoMirrored && this.mCachedRootAlpha == this.mVPathRenderer.getRootAlpha();
      }

      public void createCachedBitmapIfNeeded(int var1, int var2) {
         if(this.mCachedBitmap == null || !this.canReuseBitmap(var1, var2)) {
            this.mCachedBitmap = Bitmap.createBitmap(var1, var2, Config.ARGB_8888);
            this.mCacheDirty = true;
         }

      }

      public void drawCachedBitmapWithRootAlpha(Canvas var1, ColorFilter var2, Rect var3) {
         Paint var4 = this.getPaint(var2);
         var1.drawBitmap(this.mCachedBitmap, (Rect)null, var3, var4);
      }

      public int getChangingConfigurations() {
         return this.mChangingConfigurations;
      }

      public Paint getPaint(ColorFilter var1) {
         if(!this.hasTranslucentRoot() && var1 == null) {
            return null;
         } else {
            if(this.mTempPaint == null) {
               this.mTempPaint = new Paint();
               this.mTempPaint.setFilterBitmap(true);
            }

            this.mTempPaint.setAlpha(this.mVPathRenderer.getRootAlpha());
            this.mTempPaint.setColorFilter(var1);
            return this.mTempPaint;
         }
      }

      public boolean hasTranslucentRoot() {
         return this.mVPathRenderer.getRootAlpha() < 255;
      }

      public Drawable newDrawable() {
         return new VectorDrawableCompat(this);
      }

      public Drawable newDrawable(Resources var1) {
         return new VectorDrawableCompat(this);
      }

      public void updateCacheStates() {
         this.mCachedTint = this.mTint;
         this.mCachedTintMode = this.mTintMode;
         this.mCachedRootAlpha = this.mVPathRenderer.getRootAlpha();
         this.mCachedAutoMirrored = this.mAutoMirrored;
         this.mCacheDirty = false;
      }

      public void updateCachedBitmap(int var1, int var2) {
         this.mCachedBitmap.eraseColor(0);
         Canvas var3 = new Canvas(this.mCachedBitmap);
         this.mVPathRenderer.draw(var3, var1, var2, (ColorFilter)null);
      }
   }

   private static class VectorDrawableDelegateState extends ConstantState {
      private final ConstantState mDelegateState;

      public VectorDrawableDelegateState(ConstantState var1) {
         this.mDelegateState = var1;
      }

      public boolean canApplyTheme() {
         return this.mDelegateState.canApplyTheme();
      }

      public int getChangingConfigurations() {
         return this.mDelegateState.getChangingConfigurations();
      }

      public Drawable newDrawable() {
         VectorDrawableCompat var1 = new VectorDrawableCompat();
         var1.mDelegateDrawable = (VectorDrawable)this.mDelegateState.newDrawable();
         return var1;
      }

      public Drawable newDrawable(Resources var1) {
         VectorDrawableCompat var2 = new VectorDrawableCompat();
         var2.mDelegateDrawable = (VectorDrawable)this.mDelegateState.newDrawable(var1);
         return var2;
      }

      public Drawable newDrawable(Resources var1, Theme var2) {
         VectorDrawableCompat var3 = new VectorDrawableCompat();
         var3.mDelegateDrawable = (VectorDrawable)this.mDelegateState.newDrawable(var1, var2);
         return var3;
      }
   }
}
