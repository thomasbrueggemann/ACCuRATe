package com.parse;

interface ParseCallback2<T1, T2 extends Throwable> {
   void done(T1 var1, T2 var2);
}
