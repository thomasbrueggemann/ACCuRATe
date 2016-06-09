package com.newrelic.agent.android.measurement;

public class ThreadInfo {
   // $FF: renamed from: id long
   private long field_663;
   private String name;

   public ThreadInfo() {
      this(Thread.currentThread());
   }

   public ThreadInfo(long var1, String var3) {
      this.field_663 = var1;
      this.name = var3;
   }

   public ThreadInfo(Thread var1) {
      this(var1.getId(), var1.getName());
   }

   public static ThreadInfo fromThread(Thread var0) {
      return new ThreadInfo(var0);
   }

   public long getId() {
      return this.field_663;
   }

   public String getName() {
      return this.name;
   }

   public void setId(long var1) {
      this.field_663 = var1;
   }

   public void setName(String var1) {
      this.name = var1;
   }

   public String toString() {
      return "ThreadInfo{id=" + this.field_663 + ", name=\'" + this.name + '\'' + '}';
   }
}
