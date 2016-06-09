package com.koushikdutta.async;

import java.util.Iterator;
import java.util.Queue;

public interface Deque<E> extends Queue<E> {
   boolean add(E var1);

   void addFirst(E var1);

   void addLast(E var1);

   boolean contains(Object var1);

   Iterator<E> descendingIterator();

   E element();

   E getFirst();

   E getLast();

   Iterator<E> iterator();

   boolean offer(E var1);

   boolean offerFirst(E var1);

   boolean offerLast(E var1);

   E peek();

   E peekFirst();

   E peekLast();

   E poll();

   E pollFirst();

   E pollLast();

   E pop();

   void push(E var1);

   E remove();

   boolean remove(Object var1);

   E removeFirst();

   boolean removeFirstOccurrence(Object var1);

   E removeLast();

   boolean removeLastOccurrence(Object var1);

   int size();
}
