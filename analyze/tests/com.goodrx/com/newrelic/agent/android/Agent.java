package com.newrelic.agent.android;

import com.newrelic.agent.android.AgentImpl;
import com.newrelic.agent.android.NullAgentImpl;
import com.newrelic.agent.android.api.common.TransactionData;
import com.newrelic.agent.android.harvest.ApplicationInformation;
import com.newrelic.agent.android.harvest.DeviceInformation;
import com.newrelic.agent.android.util.Encoder;
import java.util.List;

public class Agent {
   public static final String DEFAULT_BUILD_ID = "";
   private static final AgentImpl NULL_AGENT_IMPL = new NullAgentImpl();
   public static final String UNITY_INSTRUMENTATION_FLAG = "NO";
   public static final String VERSION = "5.5.0";
   private static AgentImpl impl;
   private static Object implLock = new Object();

   static {
      impl = NULL_AGENT_IMPL;
   }

   public static void addTransactionData(TransactionData var0) {
      getImpl().addTransactionData(var0);
   }

   public static void disable() {
      getImpl().disable();
   }

   public static String getActiveNetworkCarrier() {
      return getImpl().getNetworkCarrier();
   }

   public static String getActiveNetworkWanType() {
      return getImpl().getNetworkWanType();
   }

   public static List<TransactionData> getAndClearTransactionData() {
      return getImpl().getAndClearTransactionData();
   }

   public static ApplicationInformation getApplicationInformation() {
      return getImpl().getApplicationInformation();
   }

   public static String getBuildId() {
      return getUnityInstrumentationFlag().equals("YES")?"":"";
   }

   public static String getCrossProcessId() {
      return getImpl().getCrossProcessId();
   }

   public static DeviceInformation getDeviceInformation() {
      return getImpl().getDeviceInformation();
   }

   public static Encoder getEncoder() {
      return getImpl().getEncoder();
   }

   public static AgentImpl getImpl() {
      // $FF: Couldn't be decompiled
   }

   public static int getResponseBodyLimit() {
      return getImpl().getResponseBodyLimit();
   }

   public static int getStackTraceLimit() {
      return getImpl().getStackTraceLimit();
   }

   public static String getUnityInstrumentationFlag() {
      return "NO";
   }

   public static String getVersion() {
      return "5.5.0";
   }

   public static boolean isDisabled() {
      return getImpl().isDisabled();
   }

   public static void mergeTransactionData(List<TransactionData> var0) {
      getImpl().mergeTransactionData(var0);
   }

   public static void setImpl(AgentImpl param0) {
      // $FF: Couldn't be decompiled
   }

   public static void setLocation(String var0, String var1) {
      getImpl().setLocation(var0, var1);
   }

   public static void start() {
      getImpl().start();
   }

   public static void stop() {
      getImpl().stop();
   }
}
