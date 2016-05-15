package com.newrelic.agent.android.analytics;

import com.newrelic.agent.android.AgentConfiguration;
import com.newrelic.agent.android.AgentImpl;
import com.newrelic.agent.android.analytics.AnalyticAttribute;
import com.newrelic.agent.android.analytics.AnalyticsController;
import com.newrelic.agent.android.analytics.AnalyticsEvent;
import com.newrelic.agent.android.analytics.AnalyticsEventCategory;
import com.newrelic.agent.android.analytics.AnalyticsEventFactory;
import com.newrelic.agent.android.analytics.EventManager;
import com.newrelic.agent.android.analytics.EventManagerImpl;
import com.newrelic.agent.android.harvest.DeviceInformation;
import com.newrelic.agent.android.harvest.EnvironmentInformation;
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import com.newrelic.agent.android.tracing.ActivityTrace;
import com.newrelic.agent.android.tracing.TraceLifecycleAware;
import com.newrelic.agent.android.tracing.TraceMachine;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

public class AnalyticsControllerImpl implements AnalyticsController {
   protected static final int MAX_ATTRIBUTES = 64;
   private static final String NEW_RELIC_PREFIX = "newRelic";
   private static final String NR_PREFIX = "nr.";
   private static final AtomicBoolean initialized = new AtomicBoolean(false);
   private static final AnalyticsControllerImpl instance = new AnalyticsControllerImpl();
   static final AgentLog log = AgentLogManager.getAgentLog();
   private static final List<String> reservedNames = new ArrayList();
   private AgentConfiguration agentConfiguration;
   private AgentImpl agentImpl;
   private EventManager eventManager = new EventManagerImpl();
   private boolean isEnabled;
   private AnalyticsControllerImpl.InteractionCompleteListener listener = new AnalyticsControllerImpl.InteractionCompleteListener();
   private Set<AnalyticAttribute> systemAttributes = Collections.synchronizedSet(new HashSet());
   private Set<AnalyticAttribute> userAttributes = Collections.synchronizedSet(new HashSet());

   private void clear() {
      if(log.getLevel() == 4) {
         log.verbose("AnalyticsControllerImpl.clear - clearing out attributes and events");
      }

      this.systemAttributes.clear();
      this.userAttributes.clear();
      this.eventManager.empty();
   }

   public static AnalyticsControllerImpl getInstance() {
      return instance;
   }

   private AnalyticAttribute getSystemAttribute(String var1) {
      Iterator var2 = this.systemAttributes.iterator();

      AnalyticAttribute var4;
      while(true) {
         boolean var3 = var2.hasNext();
         var4 = null;
         if(!var3) {
            break;
         }

         AnalyticAttribute var5 = (AnalyticAttribute)var2.next();
         if(var5.getName().equals(var1)) {
            var4 = var5;
            break;
         }
      }

      return var4;
   }

   private AnalyticAttribute getUserAttribute(String var1) {
      Iterator var2 = this.userAttributes.iterator();

      AnalyticAttribute var4;
      while(true) {
         boolean var3 = var2.hasNext();
         var4 = null;
         if(!var3) {
            break;
         }

         AnalyticAttribute var5 = (AnalyticAttribute)var2.next();
         if(var5.getName().equals(var1)) {
            var4 = var5;
            break;
         }
      }

      return var4;
   }

   public static void initialize(AgentConfiguration var0, AgentImpl var1) {
      log.verbose("AnalyticsControllerImpl.initialize invoked.");
      if(!initialized.compareAndSet(false, true)) {
         log.verbose("AnalyticsControllerImpl has already been initialized.  Bypassing..");
      } else {
         instance.clear();
         reservedNames.add("eventType");
         reservedNames.add("type");
         reservedNames.add("timestamp");
         reservedNames.add("category");
         reservedNames.add("accountId");
         reservedNames.add("appId");
         reservedNames.add("appName");
         reservedNames.add("uuid");
         reservedNames.add("sessionId");
         reservedNames.add("osName");
         reservedNames.add("osVersion");
         reservedNames.add("osMajorVersion");
         reservedNames.add("deviceManufacturer");
         reservedNames.add("deviceModel");
         reservedNames.add("memUsageMb");
         reservedNames.add("carrier");
         reservedNames.add("newRelicVersion");
         reservedNames.add("interactionDuration");
         reservedNames.add("install");
         reservedNames.add("upgradeFrom");
         instance.reinitialize(var0, var1);
         TraceMachine.addTraceListener(instance.listener);
         log.info("Analytics Controller started.");
      }
   }

   private boolean isAttributeNameValid(String var1) {
      boolean var2 = this.isNameValid(var1);
      if(var2) {
         if(!this.isNameReserved(var1)) {
            var2 = true;
         } else {
            var2 = false;
         }

         if(!var2) {
            log.error("Attribute name " + var1 + " is reserved for internal use and will be ignored.");
         }
      }

      return var2;
   }

   private boolean isInitializedAndEnabled() {
      if(!initialized.get()) {
         log.warning("Analytics controller is not initialized!");
         return false;
      } else if(!this.isEnabled) {
         log.warning("Analytics controller is not enabled!");
         return false;
      } else {
         return true;
      }
   }

   private boolean isNameReserved(String var1) {
      boolean var2 = reservedNames.contains(var1);
      if(var2) {
         if(log.getLevel() == 4) {
            log.verbose("Name " + var1 + " is in the reserved names list.");
         }

         return var2;
      } else {
         boolean var3;
         if(!var2 && !var1.startsWith("newRelic")) {
            var3 = false;
         } else {
            var3 = true;
         }

         if(var3) {
            if(log.getLevel() == 4) {
               log.verbose("Name " + var1 + " starts with reserved prefix " + "newRelic");
            }

            return var3;
         } else {
            boolean var4;
            if(!var3 && !var1.startsWith("nr.")) {
               var4 = false;
            } else {
               var4 = true;
            }

            if(var4 && log.getLevel() == 4) {
               log.verbose("Name " + var1 + " starts with reserved prefix " + "nr.");
            }

            return var4;
         }
      }
   }

   private boolean isNameValid(String var1) {
      boolean var2;
      if(var1 != null && !var1.equals("") && var1.length() < 256) {
         var2 = true;
      } else {
         var2 = false;
      }

      if(!var2) {
         log.error("Attribute name " + var1 + " is null, empty, or exceeds the maximum length of " + 256 + " characters.");
      }

      return var2;
   }

   private boolean isStringValueValid(String var1, String var2) {
      boolean var3;
      if(var2 != null && !var2.equals("") && var2.getBytes().length < 4096) {
         var3 = true;
      } else {
         var3 = false;
      }

      if(!var3) {
         log.error("Attribute value for name " + var1 + " is null, empty, or exceeds the maximum length of " + 4096 + " bytes.");
      }

      return var3;
   }

   public static void shutdown() {
      TraceMachine.removeTraceListener(instance.listener);
      initialized.compareAndSet(true, false);
      instance.getEventManager().shutdown();
   }

   public boolean addAttributeUnchecked(AnalyticAttribute var1, boolean var2) {
      String var3 = var1.getName();
      String var4 = var1.valueAsString();
      AgentLog var5 = log;
      StringBuilder var6 = (new StringBuilder()).append("AnalyticsControllerImpl.setAttributeUnchecked - ").append(var3).append(": ").append(var4);
      String var7;
      if(var2) {
         var7 = " (persistent)";
      } else {
         var7 = " (transient)";
      }

      var5.verbose(var6.append(var7).toString());
      if(!initialized.get()) {
         log.warning("Analytics controller is not initialized!");
      } else {
         if(!this.isEnabled) {
            log.warning("Analytics controller is not enabled!");
            return false;
         }

         if(this.isNameValid(var3)) {
            AnalyticAttribute var8 = this.getAttribute(var1.getName());
            if(var8 == null) {
               this.userAttributes.add(var1);
               if(var1.isPersistent()) {
                  this.agentConfiguration.getAnalyticAttributeStore().store(var1);
                  boolean var12 = this.agentConfiguration.getAnalyticAttributeStore().store(var1);
                  if(!var12) {
                     log.error("Failed to store attribute " + var1 + " to attribute store.");
                     return var12;
                  }
               }
            } else {
               switch(null.$SwitchMap$com$newrelic$agent$android$analytics$AnalyticAttribute$AttributeDataType[var1.getAttributeDataType().ordinal()]) {
               case 1:
                  var8.setStringValue(var1.getStringValue());
                  break;
               case 2:
                  var8.setFloatValue(var1.getFloatValue());
                  break;
               case 3:
                  var8.setBooleanValue(var1.getBooleanValue());
               }

               var8.setPersistent(var2);
               if(var8.isPersistent()) {
                  boolean var9 = this.agentConfiguration.getAnalyticAttributeStore().store(var8);
                  if(!var9) {
                     log.error("Failed to store attribute " + var8 + " to attribute store.");
                     return var9;
                  }
               } else {
                  this.agentConfiguration.getAnalyticAttributeStore().delete(var8);
               }
            }

            return true;
         }
      }

      return false;
   }

   public boolean addEvent(AnalyticsEvent var1) {
      if(!this.isInitializedAndEnabled()) {
         return false;
      } else {
         HashSet var2 = new HashSet();
         long var3 = this.agentImpl.getSessionDurationMillis();
         if(0L == var3) {
            log.error("Harvest instance is not running! Session duration will be invalid");
         } else {
            var2.add(new AnalyticAttribute("timeSinceLoad", (float)var3 / 1000.0F));
            var1.addAttributes(var2);
         }

         return this.eventManager.addEvent(var1);
      }
   }

   public boolean addEvent(String var1, AnalyticsEventCategory var2, String var3, Set<AnalyticAttribute> var4) {
      log.verbose("AnalyticsControllerImpl.addEvent - " + var1 + ": category=" + var2 + ", eventType: " + var3 + ", eventAttributes:" + var4);
      if(!this.isInitializedAndEnabled()) {
         return false;
      } else {
         HashSet var5 = new HashSet();
         Iterator var6 = var4.iterator();

         while(var6.hasNext()) {
            AnalyticAttribute var7 = (AnalyticAttribute)var6.next();
            if(this.isAttributeNameValid(var7.getName())) {
               var5.add(var7);
            }
         }

         return this.addEvent(AnalyticsEventFactory.createEvent(var1, var2, var3, var5));
      }
   }

   public boolean addEvent(String var1, Set<AnalyticAttribute> var2) {
      return this.addEvent(var1, AnalyticsEventCategory.Custom, "Mobile", var2);
   }

   public AnalyticAttribute getAttribute(String var1) {
      log.verbose("AnalyticsControllerImpl.getAttribute - retrieving " + var1);
      AnalyticAttribute var2 = this.getUserAttribute(var1);
      if(var2 == null) {
         var2 = this.getSystemAttribute(var1);
      }

      return var2;
   }

   public EventManager getEventManager() {
      return this.eventManager;
   }

   public int getMaxEventBufferTime() {
      return this.eventManager.getMaxEventBufferTime();
   }

   public int getMaxEventPoolSize() {
      return this.eventManager.getMaxEventPoolSize();
   }

   public int getSessionAttributeCount() {
      return this.systemAttributes.size() + this.userAttributes.size();
   }

   public Set<AnalyticAttribute> getSessionAttributes() {
      HashSet var1 = new HashSet(this.getSessionAttributeCount());
      var1.addAll(this.getSystemAttributes());
      var1.addAll(this.getUserAttributes());
      return Collections.unmodifiableSet(var1);
   }

   public int getSystemAttributeCount() {
      return this.systemAttributes.size();
   }

   public Set<AnalyticAttribute> getSystemAttributes() {
      HashSet var1 = new HashSet(this.systemAttributes.size());
      Iterator var2 = this.systemAttributes.iterator();

      while(var2.hasNext()) {
         var1.add(new AnalyticAttribute((AnalyticAttribute)var2.next()));
      }

      return Collections.unmodifiableSet(var1);
   }

   public int getUserAttributeCount() {
      return this.userAttributes.size();
   }

   public Set<AnalyticAttribute> getUserAttributes() {
      HashSet var1 = new HashSet(this.userAttributes.size());
      Iterator var2 = this.userAttributes.iterator();

      while(var2.hasNext()) {
         var1.add(new AnalyticAttribute((AnalyticAttribute)var2.next()));
      }

      return Collections.unmodifiableSet(var1);
   }

   public boolean incrementAttribute(String var1, float var2) {
      log.verbose("AnalyticsControllerImpl.incrementAttribute - " + var1 + ": " + var2);
      return this.incrementAttribute(var1, var2, true);
   }

   public boolean incrementAttribute(String var1, float var2, boolean var3) {
      AgentLog var4 = log;
      StringBuilder var5 = (new StringBuilder()).append("AnalyticsControllerImpl.incrementAttribute - ").append(var1).append(": ").append(var2);
      String var6;
      if(var3) {
         var6 = " (persistent)";
      } else {
         var6 = " (transient)";
      }

      var4.verbose(var5.append(var6).toString());
      if(this.isInitializedAndEnabled() && this.isAttributeNameValid(var1)) {
         AnalyticAttribute var7 = this.getAttribute(var1);
         if(var7 != null && var7.isFloatAttribute()) {
            var7.setFloatValue(var2 + var7.getFloatValue());
            var7.setPersistent(var3);
            if(var7.isPersistent()) {
               boolean var12 = this.agentConfiguration.getAnalyticAttributeStore().store(var7);
               if(!var12) {
                  log.error("Failed to store attribute " + var7 + " to attribute store.");
                  return var12;
               }
            }
         } else {
            if(var7 != null) {
               log.warning("Cannot increment attribute " + var1 + ": the attribute is already defined as a non-float value.");
               return false;
            }

            if(this.userAttributes.size() < 64) {
               AnalyticAttribute var8 = new AnalyticAttribute(var1, var2, var3);
               this.userAttributes.add(var8);
               if(var8.isPersistent()) {
                  this.agentConfiguration.getAnalyticAttributeStore().store(var8);
                  boolean var11 = this.agentConfiguration.getAnalyticAttributeStore().store(var8);
                  if(!var11) {
                     log.error("Failed to store attribute " + var8 + " to attribute store.");
                     return var11;
                  }
               } else {
                  this.agentConfiguration.getAnalyticAttributeStore().delete(var8);
               }
            }
         }

         return true;
      } else {
         return false;
      }
   }

   void loadPersistentAttributes() {
      if(log.getLevel() == 4) {
         log.verbose("AnalyticsControllerImpl.loadPersistentAttributes - loading userAttributes from the attribute store...");
      }

      List var1 = this.agentConfiguration.getAnalyticAttributeStore().fetchAll();
      if(log.getLevel() == 4) {
         log.verbose("AnalyticsControllerImpl.loadPersistentAttributes - found " + var1.size() + " userAttributes in the attribute store...");
      }

      Iterator var2 = var1.iterator();

      while(var2.hasNext()) {
         AnalyticAttribute var3 = (AnalyticAttribute)var2.next();
         this.userAttributes.add(var3);
      }

   }

   public boolean recordEvent(String param1, Map<String, Object> param2) {
      // $FF: Couldn't be decompiled
   }

   void reinitialize(AgentConfiguration var1, AgentImpl var2) {
      this.agentImpl = var2;
      this.agentConfiguration = var1;
      this.eventManager.initialize();
      this.isEnabled = var1.getEnableAnalyticsEvents();
      this.loadPersistentAttributes();
      DeviceInformation var3 = var2.getDeviceInformation();
      String var4 = var3.getOsVersion().replace(" ", "");
      String[] var5 = var4.split("[.:-]");
      String var6;
      if(var5.length > 0) {
         var6 = var5[0];
      } else {
         var6 = var4;
      }

      EnvironmentInformation var7 = var2.getEnvironmentInformation();
      this.systemAttributes.add(new AnalyticAttribute("osName", var3.getOsName()));
      this.systemAttributes.add(new AnalyticAttribute("osVersion", var4));
      this.systemAttributes.add(new AnalyticAttribute("osMajorVersion", var6));
      this.systemAttributes.add(new AnalyticAttribute("deviceManufacturer", var3.getManufacturer()));
      this.systemAttributes.add(new AnalyticAttribute("deviceModel", var3.getModel()));
      this.systemAttributes.add(new AnalyticAttribute("uuid", var3.getDeviceId()));
      this.systemAttributes.add(new AnalyticAttribute("carrier", var2.getNetworkCarrier()));
      this.systemAttributes.add(new AnalyticAttribute("newRelicVersion", var3.getAgentVersion()));
      this.systemAttributes.add(new AnalyticAttribute("memUsageMb", (float)var7.getMemoryUsage()));
      this.systemAttributes.add(new AnalyticAttribute("sessionId", var1.getSessionID()));
   }

   public boolean removeAllAttributes() {
      log.verbose("AnalyticsControllerImpl.removeAttributes - ");
      if(!this.isInitializedAndEnabled()) {
         return false;
      } else {
         this.agentConfiguration.getAnalyticAttributeStore().clear();
         this.userAttributes.clear();
         return false;
      }
   }

   public boolean removeAttribute(String var1) {
      log.verbose("AnalyticsControllerImpl.removeAttribute - " + var1);
      if(!this.isInitializedAndEnabled()) {
         return false;
      } else {
         AnalyticAttribute var2 = this.getAttribute(var1);
         if(var2 != null) {
            this.userAttributes.remove(var2);
            if(var2.isPersistent()) {
               this.agentConfiguration.getAnalyticAttributeStore().delete(var2);
            }
         }

         return true;
      }
   }

   public boolean setAttribute(String var1, float var2) {
      log.verbose("AnalyticsControllerImpl.setAttribute - " + var1 + ": " + var2);
      return this.setAttribute(var1, var2, true);
   }

   public boolean setAttribute(String var1, float var2, boolean var3) {
      AgentLog var4 = log;
      StringBuilder var5 = (new StringBuilder()).append("AnalyticsControllerImpl.setAttribute - ").append(var1).append(": ").append(var2);
      String var6;
      if(var3) {
         var6 = " (persistent)";
      } else {
         var6 = " (transient)";
      }

      var4.verbose(var5.append(var6).toString());
      if(this.isInitializedAndEnabled() && this.isAttributeNameValid(var1)) {
         AnalyticAttribute var7 = this.getAttribute(var1);
         if(var7 == null) {
            if(this.userAttributes.size() < 64) {
               AnalyticAttribute var9 = new AnalyticAttribute(var1, var2, var3);
               this.userAttributes.add(var9);
               if(var9.isPersistent()) {
                  this.agentConfiguration.getAnalyticAttributeStore().store(var9);
                  boolean var12 = this.agentConfiguration.getAnalyticAttributeStore().store(var9);
                  if(!var12) {
                     log.error("Failed to store attribute " + var9 + " to attribute store.");
                     return var12;
                  }
               }
            } else {
               log.warning("Attribute limit exceeded: at most 64 are allowed.");
               log.warning("Currently defined attributes:");
               Iterator var13 = this.userAttributes.iterator();

               while(var13.hasNext()) {
                  AnalyticAttribute var14 = (AnalyticAttribute)var13.next();
                  log.warning("\t" + var14.getName() + ": " + var14.valueAsString());
               }
            }
         } else {
            var7.setFloatValue(var2);
            var7.setPersistent(var3);
            if(var7.isPersistent()) {
               boolean var8 = this.agentConfiguration.getAnalyticAttributeStore().store(var7);
               if(!var8) {
                  log.error("Failed to store attribute " + var7 + " to attribute store.");
                  return var8;
               }
            } else {
               this.agentConfiguration.getAnalyticAttributeStore().delete(var7);
            }
         }

         return true;
      } else {
         return false;
      }
   }

   public boolean setAttribute(String var1, String var2) {
      log.verbose("AnalyticsControllerImpl.setAttribute - " + var1 + ": " + var2);
      return this.setAttribute(var1, var2, true);
   }

   public boolean setAttribute(String var1, String var2, boolean var3) {
      AgentLog var4 = log;
      StringBuilder var5 = (new StringBuilder()).append("AnalyticsControllerImpl.setAttribute - ").append(var1).append(": ").append(var2);
      String var6;
      if(var3) {
         var6 = " (persistent)";
      } else {
         var6 = " (transient)";
      }

      var4.verbose(var5.append(var6).toString());
      if(this.isInitializedAndEnabled() && this.isAttributeNameValid(var1) && this.isStringValueValid(var1, var2)) {
         AnalyticAttribute var7 = this.getAttribute(var1);
         if(var7 == null) {
            if(this.userAttributes.size() < 64) {
               AnalyticAttribute var9 = new AnalyticAttribute(var1, var2, var3);
               this.userAttributes.add(var9);
               if(var9.isPersistent()) {
                  boolean var11 = this.agentConfiguration.getAnalyticAttributeStore().store(var9);
                  if(!var11) {
                     log.error("Failed to store attribute " + var9 + " to attribute store.");
                     return var11;
                  }
               }
            } else {
               log.warning("Attribute limit exceeded: at most 64 are allowed.");
               log.warning("Currently defined attributes:");
               Iterator var12 = this.userAttributes.iterator();

               while(var12.hasNext()) {
                  AnalyticAttribute var13 = (AnalyticAttribute)var12.next();
                  log.warning("\t" + var13.getName() + ": " + var13.valueAsString());
               }
            }
         } else {
            var7.setStringValue(var2);
            var7.setPersistent(var3);
            if(var7.isPersistent()) {
               boolean var8 = this.agentConfiguration.getAnalyticAttributeStore().store(var7);
               if(!var8) {
                  log.error("Failed to store attribute " + var7 + " to attribute store.");
                  return var8;
               }
            } else {
               this.agentConfiguration.getAnalyticAttributeStore().delete(var7);
            }
         }

         return true;
      } else {
         return false;
      }
   }

   public boolean setAttribute(String var1, boolean var2) {
      log.verbose("AnalyticsControllerImpl.setAttribute - " + var1 + ": " + var2);
      return this.setAttribute(var1, var2, true);
   }

   public boolean setAttribute(String var1, boolean var2, boolean var3) {
      AgentLog var4 = log;
      StringBuilder var5 = (new StringBuilder()).append("AnalyticsControllerImpl.setAttribute - ").append(var1).append(": ").append(var2);
      String var6;
      if(var3) {
         var6 = " (persistent)";
      } else {
         var6 = " (transient)";
      }

      var4.verbose(var5.append(var6).toString());
      if(this.isInitializedAndEnabled() && this.isAttributeNameValid(var1)) {
         AnalyticAttribute var7 = this.getAttribute(var1);
         if(var7 == null) {
            if(this.userAttributes.size() < 64) {
               AnalyticAttribute var9 = new AnalyticAttribute(var1, var2, var3);
               this.userAttributes.add(var9);
               if(var9.isPersistent()) {
                  boolean var11 = this.agentConfiguration.getAnalyticAttributeStore().store(var9);
                  if(!var11) {
                     log.error("Failed to store attribute " + var9 + " to attribute store.");
                     return var11;
                  }
               }
            } else {
               log.warning("Attribute limit exceeded: at most 64 are allowed.");
               log.warning("Currently defined attributes:");
               Iterator var12 = this.userAttributes.iterator();

               while(var12.hasNext()) {
                  AnalyticAttribute var13 = (AnalyticAttribute)var12.next();
                  log.warning("\t" + var13.getName() + ": " + var13.valueAsString());
               }
            }
         } else {
            var7.setBooleanValue(var2);
            var7.setPersistent(var3);
            if(var7.isPersistent()) {
               boolean var8 = this.agentConfiguration.getAnalyticAttributeStore().store(var7);
               if(!var8) {
                  log.error("Failed to store attribute " + var7 + " to attribute store.");
                  return var8;
               }
            } else {
               this.agentConfiguration.getAnalyticAttributeStore().delete(var7);
            }
         }

         return true;
      } else {
         return false;
      }
   }

   public void setMaxEventBufferTime(int var1) {
      this.eventManager.setMaxEventBufferTime(var1);
   }

   public void setMaxEventPoolSize(int var1) {
      this.eventManager.setMaxEventPoolSize(var1);
   }

   class InteractionCompleteListener implements TraceLifecycleAware {
      private AnalyticsEvent createTraceEvent(ActivityTrace var1) {
         float var2 = var1.rootTrace.getDurationAsSeconds();
         HashSet var3 = new HashSet();
         var3.add(new AnalyticAttribute("interactionDuration", var2));
         return AnalyticsEventFactory.createEvent(var1.rootTrace.displayName, AnalyticsEventCategory.Interaction, "Mobile", var3);
      }

      public void onEnterMethod() {
      }

      public void onExitMethod() {
      }

      public void onTraceComplete(ActivityTrace var1) {
         AnalyticsControllerImpl.log.verbose("AnalyticsControllerImpl.InteractionCompleteListener.onTraceComplete invoke.");
         AnalyticsEvent var2 = this.createTraceEvent(var1);
         AnalyticsControllerImpl.instance.addEvent(var2);
      }

      public void onTraceStart(ActivityTrace var1) {
      }
   }
}
