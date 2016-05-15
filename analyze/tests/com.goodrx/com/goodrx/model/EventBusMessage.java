package com.goodrx.model;

public class EventBusMessage<T> {
   private T messageContent;
   private String type;

   public EventBusMessage(String var1, T var2) {
      this.type = var1;
      this.messageContent = var2;
   }

   public T getMessageContent() {
      return this.messageContent;
   }

   public String getType() {
      return this.type;
   }
}
