package com.goodrx.model;

public class PagingResource {
   private int end;
   private int start;
   private int total_results;

   public int getEnd() {
      return this.end;
   }

   public int getStart() {
      return this.start;
   }

   public int getTotal_results() {
      return this.total_results;
   }
}
