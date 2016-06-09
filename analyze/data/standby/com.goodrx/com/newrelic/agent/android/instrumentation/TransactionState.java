package com.newrelic.agent.android.instrumentation;

import com.newrelic.agent.android.api.common.TransactionData;
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.newrelic.agent.android.util.Util;
import java.net.MalformedURLException;
import java.net.URL;

public final class TransactionState {
   private static final AgentLog log = AgentLogManager.getAgentLog();
   private String appData;
   private long bytesReceived;
   private long bytesSent;
   private String carrier = "unknown";
   private String contentType;
   private long endTime;
   private int errorCode;
   private String httpMethod;
   private long startTime = System.currentTimeMillis();
   private TransactionState.State state;
   private int statusCode;
   private TransactionData transactionData;
   private String url;
   private String wanType = "unknown";

   public TransactionState() {
      this.state = TransactionState.State.READY;
      TraceMachine.enterNetworkSegment("External/unknownhost");
   }

   private TransactionData toTransactionData() {
      if(!this.isComplete()) {
         log.warning("toTransactionData() called on incomplete TransactionState");
      }

      if(this.url == null) {
         log.error("Attempted to convert a TransactionState instance with no URL into a TransactionData");
         return null;
      } else {
         if(this.transactionData == null) {
            this.transactionData = new TransactionData(this.url, this.httpMethod, this.carrier, (float)(this.endTime - this.startTime) / 1000.0F, this.statusCode, this.errorCode, this.bytesSent, this.bytesReceived, this.appData, this.wanType);
         }

         return this.transactionData;
      }
   }

   public TransactionData end() {
      if(!this.isComplete()) {
         this.state = TransactionState.State.COMPLETE;
         this.endTime = System.currentTimeMillis();
         TraceMachine.exitMethod();
      }

      return this.toTransactionData();
   }

   public long getBytesReceived() {
      return this.bytesReceived;
   }

   public String getContentType() {
      return this.contentType;
   }

   public int getErrorCode() {
      return this.errorCode;
   }

   public String getHttpMethod() {
      return this.httpMethod;
   }

   public int getStatusCode() {
      return this.statusCode;
   }

   public String getUrl() {
      return this.url;
   }

   public boolean isComplete() {
      return this.state.ordinal() >= TransactionState.State.COMPLETE.ordinal();
   }

   public boolean isSent() {
      return this.state.ordinal() >= TransactionState.State.SENT.ordinal();
   }

   public void setAppData(String var1) {
      if(!this.isComplete()) {
         this.appData = var1;
         TraceMachine.setCurrentTraceParam("encoded_app_data", var1);
      } else {
         log.warning("setAppData(...) called on TransactionState in " + this.state.toString() + " state");
      }
   }

   public void setBytesReceived(long var1) {
      if(!this.isComplete()) {
         this.bytesReceived = var1;
         TraceMachine.setCurrentTraceParam("bytes_received", Long.valueOf(var1));
      } else {
         log.warning("setBytesReceived(...) called on TransactionState in " + this.state.toString() + " state");
      }
   }

   public void setBytesSent(long var1) {
      if(!this.isComplete()) {
         this.bytesSent = var1;
         TraceMachine.setCurrentTraceParam("bytes_sent", Long.valueOf(var1));
         this.state = TransactionState.State.SENT;
      } else {
         log.warning("setBytesSent(...) called on TransactionState in " + this.state.toString() + " state");
      }
   }

   public void setCarrier(String var1) {
      if(!this.isSent()) {
         this.carrier = var1;
         TraceMachine.setCurrentTraceParam("carrier", var1);
      } else {
         log.warning("setCarrier(...) called on TransactionState in " + this.state.toString() + " state");
      }
   }

   public void setContentType(String var1) {
      this.contentType = var1;
   }

   public void setErrorCode(int var1) {
      if(!this.isComplete()) {
         this.errorCode = var1;
         TraceMachine.setCurrentTraceParam("error_code", Integer.valueOf(var1));
      } else {
         if(this.transactionData != null) {
            this.transactionData.setErrorCode(var1);
         }

         log.warning("setErrorCode(...) called on TransactionState in " + this.state.toString() + " state");
      }
   }

   public void setHttpMethod(String var1) {
      if(!this.isSent()) {
         this.httpMethod = var1;
         TraceMachine.setCurrentTraceParam("http_method", var1);
      } else {
         log.warning("setHttpMethod(...) called on TransactionState in " + this.state.toString() + " state");
      }
   }

   public void setStatusCode(int var1) {
      if(!this.isComplete()) {
         this.statusCode = var1;
         TraceMachine.setCurrentTraceParam("status_code", Integer.valueOf(var1));
      } else {
         log.warning("setStatusCode(...) called on TransactionState in " + this.state.toString() + " state");
      }
   }

   public void setUrl(String var1) {
      String var2 = Util.sanitizeUrl(var1);
      if(var2 != null) {
         if(!this.isSent()) {
            this.url = var2;

            try {
               TraceMachine.setCurrentDisplayName("External/" + (new URL(var2)).getHost());
            } catch (MalformedURLException var4) {
               log.error("unable to parse host name from " + var2);
            }

            TraceMachine.setCurrentTraceParam("uri", var2);
         } else {
            log.warning("setUrl(...) called on TransactionState in " + this.state.toString() + " state");
         }
      }
   }

   public void setWanType(String var1) {
      if(!this.isSent()) {
         this.wanType = var1;
         TraceMachine.setCurrentTraceParam("wan_type", var1);
      } else {
         log.warning("setWanType(...) called on TransactionState in " + this.state.toString() + " state");
      }
   }

   public String toString() {
      return "TransactionState{url=\'" + this.url + '\'' + ", httpMethod=\'" + this.httpMethod + '\'' + ", statusCode=" + this.statusCode + ", errorCode=" + this.errorCode + ", bytesSent=" + this.bytesSent + ", bytesReceived=" + this.bytesReceived + ", startTime=" + this.startTime + ", endTime=" + this.endTime + ", appData=\'" + this.appData + '\'' + ", carrier=\'" + this.carrier + '\'' + ", wanType=\'" + this.wanType + '\'' + ", state=" + this.state + ", contentType=\'" + this.contentType + '\'' + ", transactionData=" + this.transactionData + '}';
   }

   private static enum State {
      COMPLETE,
      READY,
      SENT;

      static {
         TransactionState.State[] var0 = new TransactionState.State[]{READY, SENT, COMPLETE};
      }
   }
}
