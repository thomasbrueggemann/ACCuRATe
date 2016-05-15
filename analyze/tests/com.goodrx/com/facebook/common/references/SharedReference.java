package com.facebook.common.references;

import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.references.ResourceReleaser;
import java.util.IdentityHashMap;
import java.util.Map;
import javax.annotation.concurrent.GuardedBy;

@VisibleForTesting
public class SharedReference<T> {
   @GuardedBy("itself")
   private static final Map<Object, Integer> sLiveObjects = new IdentityHashMap();
   @GuardedBy("this")
   private int mRefCount;
   private final ResourceReleaser<T> mResourceReleaser;
   @GuardedBy("this")
   private T mValue;

   public SharedReference(T var1, ResourceReleaser<T> var2) {
      this.mValue = Preconditions.checkNotNull(var1);
      this.mResourceReleaser = (ResourceReleaser)Preconditions.checkNotNull(var2);
      this.mRefCount = 1;
      addLiveReference(var1);
   }

   private static void addLiveReference(Object param0) {
      // $FF: Couldn't be decompiled
   }

   private int decreaseRefCount() {
      // $FF: Couldn't be decompiled
   }

   private void ensureValid() {
      if(!isValid(this)) {
         throw new SharedReference.NullReferenceException();
      }
   }

   public static boolean isValid(SharedReference<?> var0) {
      return var0 != null && var0.isValid();
   }

   private static void removeLiveReference(Object param0) {
      // $FF: Couldn't be decompiled
   }

   public void addReference() {
      synchronized(this){}

      try {
         this.ensureValid();
         ++this.mRefCount;
      } finally {
         ;
      }

   }

   public void deleteReference() {
      // $FF: Couldn't be decompiled
   }

   public T get() {
      synchronized(this){}

      Object var2;
      try {
         var2 = this.mValue;
      } finally {
         ;
      }

      return var2;
   }

   public int getRefCountTestOnly() {
      synchronized(this){}

      int var2;
      try {
         var2 = this.mRefCount;
      } finally {
         ;
      }

      return var2;
   }

   public boolean isValid() {
      synchronized(this){}
      boolean var5 = false;

      int var2;
      try {
         var5 = true;
         var2 = this.mRefCount;
         var5 = false;
      } finally {
         if(var5) {
            ;
         }
      }

      boolean var3;
      if(var2 > 0) {
         var3 = true;
      } else {
         var3 = false;
      }

      return var3;
   }

   public static class NullReferenceException extends RuntimeException {
      public NullReferenceException() {
         super("Null shared reference");
      }
   }
}
