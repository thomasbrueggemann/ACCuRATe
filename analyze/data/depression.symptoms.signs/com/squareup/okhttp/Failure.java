package com.squareup.okhttp;

import com.squareup.okhttp.Request;

class Failure {
   private final Throwable exception;
   private final Request request;

   private Failure(Failure.Builder var1) {
      this.request = var1.request;
      this.exception = var1.exception;
   }

   // $FF: synthetic method
   Failure(Failure.Builder var1, Object var2) {
      this(var1);
   }

   public Throwable exception() {
      return this.exception;
   }

   public Request request() {
      return this.request;
   }

   public static class Builder {
      private Throwable exception;
      private Request request;

      public Failure build() {
         return new Failure(this);
      }

      public Failure.Builder exception(Throwable var1) {
         this.exception = var1;
         return this;
      }

      public Failure.Builder request(Request var1) {
         this.request = var1;
         return this;
      }
   }
}
