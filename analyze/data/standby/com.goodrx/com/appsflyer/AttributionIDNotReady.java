package com.appsflyer;

public class AttributionIDNotReady extends Exception {
   public AttributionIDNotReady() {
      super("Data was not received from server yet.");
   }
}
