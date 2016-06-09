package com.newrelic.agent.android;

import com.newrelic.agent.android.AgentConfiguration;
import com.newrelic.agent.android.AgentImpl;
import com.newrelic.agent.android.api.common.TransactionData;
import com.newrelic.agent.android.harvest.ApplicationInformation;
import com.newrelic.agent.android.harvest.DeviceInformation;
import com.newrelic.agent.android.harvest.EnvironmentInformation;
import com.newrelic.agent.android.util.Encoder;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class NullAgentImpl implements AgentImpl {
   public static final NullAgentImpl instance = new NullAgentImpl();
   private final AgentConfiguration agentConfiguration = new AgentConfiguration();
   private final ReentrantLock lock = new ReentrantLock();
   private int responseBodyLimit;
   private long sessionStartTimeMillis = 0L;

   public void addTransactionData(TransactionData var1) {
   }

   public void disable() {
   }

   public List<TransactionData> getAndClearTransactionData() {
      return new ArrayList();
   }

   public ApplicationInformation getApplicationInformation() {
      return new ApplicationInformation("null", "0.0", "null", "0");
   }

   public String getCrossProcessId() {
      return null;
   }

   public DeviceInformation getDeviceInformation() {
      DeviceInformation var1 = new DeviceInformation();
      var1.setOsName("Android");
      var1.setOsVersion("2.3");
      var1.setOsBuild("a.b.c");
      var1.setManufacturer("Fake");
      var1.setModel("NullAgent");
      var1.setAgentName("AndroidAgent");
      var1.setAgentVersion("2.123");
      var1.setDeviceId("389C9738-A761-44DE-8A66-1668CFD67DA1");
      var1.setArchitecture("Fake Arch");
      var1.setRunTime("1.7.0");
      var1.setSize("Fake Size");
      return var1;
   }

   public Encoder getEncoder() {
      return new Encoder() {
         public String encode(byte[] var1) {
            return new String(var1);
         }
      };
   }

   public EnvironmentInformation getEnvironmentInformation() {
      return new EnvironmentInformation(0L, 1, "none", "none", new long[]{0L, 0L});
   }

   public String getNetworkCarrier() {
      return "unknown";
   }

   public String getNetworkWanType() {
      return "unknown";
   }

   public int getResponseBodyLimit() {
      return this.responseBodyLimit;
   }

   public long getSessionDurationMillis() {
      return this.sessionStartTimeMillis;
   }

   public int getStackTraceLimit() {
      return 0;
   }

   public boolean isDisabled() {
      return true;
   }

   public void mergeTransactionData(List<TransactionData> var1) {
   }

   public void setLocation(String var1, String var2) {
   }

   public void setResponseBodyLimit(int var1) {
      this.responseBodyLimit = var1;
   }

   public void start() {
   }

   public void stop() {
   }

   public boolean updateSavedConnectInformation() {
      return false;
   }
}
