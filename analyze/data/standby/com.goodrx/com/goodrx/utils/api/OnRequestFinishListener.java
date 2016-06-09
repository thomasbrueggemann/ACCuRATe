package com.goodrx.utils.api;

public abstract class OnRequestFinishListener<T> {
   public void onFailure(int var1, String var2) {
   }

   public abstract void onSuccess(T var1);
}
