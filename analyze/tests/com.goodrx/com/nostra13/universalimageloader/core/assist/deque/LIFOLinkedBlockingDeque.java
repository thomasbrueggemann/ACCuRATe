package com.nostra13.universalimageloader.core.assist.deque;

import com.nostra13.universalimageloader.core.assist.deque.LinkedBlockingDeque;

public class LIFOLinkedBlockingDeque<T> extends LinkedBlockingDeque<T> {
   public boolean offer(T var1) {
      return super.offerFirst(var1);
   }

   public T remove() {
      return super.removeFirst();
   }
}
