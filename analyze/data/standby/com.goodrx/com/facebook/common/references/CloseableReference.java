package com.facebook.common.references;

import com.facebook.common.internal.Closeables;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.references.ResourceReleaser;
import com.facebook.common.references.SharedReference;
import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

public final class CloseableReference<T> implements Closeable, Cloneable {
   private static final ResourceReleaser<Closeable> DEFAULT_CLOSEABLE_RELEASER = new ResourceReleaser() {
      public void release(Closeable var1) {
         try {
            Closeables.close(var1, true);
         } catch (IOException var3) {
            ;
         }
      }
   };
   private static Class<CloseableReference> TAG = CloseableReference.class;
   @GuardedBy("this")
   private boolean mIsClosed = false;
   private final SharedReference<T> mSharedReference;

   private CloseableReference(SharedReference<T> var1) {
      this.mSharedReference = (SharedReference)Preconditions.checkNotNull(var1);
      var1.addReference();
   }

   private CloseableReference(T var1, ResourceReleaser<T> var2) {
      this.mSharedReference = new SharedReference(var1, var2);
   }

   @Nullable
   public static <T> CloseableReference<T> cloneOrNull(@Nullable CloseableReference<T> var0) {
      return var0 != null?var0.cloneOrNull():null;
   }

   public static <T> List<CloseableReference<T>> cloneOrNull(Collection<CloseableReference<T>> var0) {
      ArrayList var1;
      if(var0 == null) {
         var1 = null;
      } else {
         var1 = new ArrayList(var0.size());
         Iterator var2 = var0.iterator();

         while(var2.hasNext()) {
            var1.add(cloneOrNull((CloseableReference)var2.next()));
         }
      }

      return var1;
   }

   public static void closeSafely(@Nullable CloseableReference<?> var0) {
      if(var0 != null) {
         var0.close();
      }

   }

   public static void closeSafely(@Nullable Iterable<? extends CloseableReference<?>> var0) {
      if(var0 != null) {
         Iterator var1 = var0.iterator();

         while(var1.hasNext()) {
            closeSafely((CloseableReference)var1.next());
         }
      }

   }

   public static boolean isValid(@Nullable CloseableReference<?> var0) {
      return var0 != null && var0.isValid();
   }

   // $FF: renamed from: of (java.io.Closeable) com.facebook.common.references.CloseableReference
   @Nullable
   public static <T extends Closeable> CloseableReference<T> method_306(@Nullable T var0) {
      return var0 == null?null:new CloseableReference(var0, DEFAULT_CLOSEABLE_RELEASER);
   }

   // $FF: renamed from: of (java.lang.Object, com.facebook.common.references.ResourceReleaser) com.facebook.common.references.CloseableReference
   @Nullable
   public static <T> CloseableReference<T> method_307(@Nullable T var0, ResourceReleaser<T> var1) {
      return var0 == null?null:new CloseableReference(var0, var1);
   }

   public CloseableReference<T> clone() {
      synchronized(this){}

      CloseableReference var2;
      try {
         Preconditions.checkState(this.isValid());
         var2 = new CloseableReference(this.mSharedReference);
      } finally {
         ;
      }

      return var2;
   }

   public CloseableReference<T> cloneOrNull() {
      synchronized(this){}
      boolean var4 = false;

      CloseableReference var2;
      try {
         var4 = true;
         if(this.isValid()) {
            var2 = new CloseableReference(this.mSharedReference);
            var4 = false;
            return var2;
         }

         var4 = false;
      } finally {
         if(var4) {
            ;
         }
      }

      var2 = null;
      return var2;
   }

   public void close() {
      // $FF: Couldn't be decompiled
   }

   protected void finalize() throws Throwable {
      // $FF: Couldn't be decompiled
   }

   public T get() {
      // $FF: Couldn't be decompiled
   }

   @VisibleForTesting
   public SharedReference<T> getUnderlyingReferenceTestOnly() {
      synchronized(this){}

      SharedReference var2;
      try {
         var2 = this.mSharedReference;
      } finally {
         ;
      }

      return var2;
   }

   public int getValueHash() {
      synchronized(this){}
      boolean var5 = false;

      int var2;
      int var3;
      label50: {
         try {
            var5 = true;
            if(this.isValid()) {
               var3 = System.identityHashCode(this.mSharedReference.get());
               var5 = false;
               break label50;
            }

            var5 = false;
         } finally {
            if(var5) {
               ;
            }
         }

         var2 = 0;
         return var2;
      }

      var2 = var3;
      return var2;
   }

   public boolean isValid() {
      synchronized(this){}
      boolean var5 = false;

      boolean var2;
      try {
         var5 = true;
         var2 = this.mIsClosed;
         var5 = false;
      } finally {
         if(var5) {
            ;
         }
      }

      boolean var3;
      if(!var2) {
         var3 = true;
      } else {
         var3 = false;
      }

      return var3;
   }
}
