package com.parse;

import com.parse.CacheQueryController;
import com.parse.CachedCurrentInstallationController;
import com.parse.CachedCurrentUserController;
import com.parse.FileObjectStore;
import com.parse.LocalIdManager;
import com.parse.NetworkObjectController;
import com.parse.NetworkQueryController;
import com.parse.NetworkSessionController;
import com.parse.NetworkUserController;
import com.parse.OfflineObjectStore;
import com.parse.OfflineQueryController;
import com.parse.Parse;
import com.parse.ParseAnalyticsController;
import com.parse.ParseAuthenticationManager;
import com.parse.ParseCloudCodeController;
import com.parse.ParseConfigController;
import com.parse.ParseCurrentConfigController;
import com.parse.ParseCurrentInstallationController;
import com.parse.ParseCurrentUserController;
import com.parse.ParseDefaultACLController;
import com.parse.ParseFileController;
import com.parse.ParseInstallation;
import com.parse.ParseObjectController;
import com.parse.ParseObjectCurrentCoder;
import com.parse.ParseObjectStore;
import com.parse.ParseObjectSubclassingController;
import com.parse.ParsePlugins;
import com.parse.ParsePushChannelsController;
import com.parse.ParsePushController;
import com.parse.ParseQueryController;
import com.parse.ParseSessionController;
import com.parse.ParseUser;
import com.parse.ParseUserController;
import com.parse.ParseUserCurrentCoder;
import java.io.File;
import java.util.concurrent.atomic.AtomicReference;

class ParseCorePlugins {
   static final String FILENAME_CURRENT_CONFIG = "currentConfig";
   static final String FILENAME_CURRENT_INSTALLATION = "currentInstallation";
   static final String FILENAME_CURRENT_USER = "currentUser";
   private static final ParseCorePlugins INSTANCE = new ParseCorePlugins();
   static final String PIN_CURRENT_INSTALLATION = "_currentInstallation";
   static final String PIN_CURRENT_USER = "_currentUser";
   private AtomicReference<ParseAnalyticsController> analyticsController = new AtomicReference();
   private AtomicReference<ParseAuthenticationManager> authenticationController = new AtomicReference();
   private AtomicReference<ParseCloudCodeController> cloudCodeController = new AtomicReference();
   private AtomicReference<ParseConfigController> configController = new AtomicReference();
   private AtomicReference<ParseCurrentInstallationController> currentInstallationController = new AtomicReference();
   private AtomicReference<ParseCurrentUserController> currentUserController = new AtomicReference();
   private AtomicReference<ParseDefaultACLController> defaultACLController = new AtomicReference();
   private AtomicReference<ParseFileController> fileController = new AtomicReference();
   private AtomicReference<LocalIdManager> localIdManager = new AtomicReference();
   private AtomicReference<ParseObjectController> objectController = new AtomicReference();
   private AtomicReference<ParsePushChannelsController> pushChannelsController = new AtomicReference();
   private AtomicReference<ParsePushController> pushController = new AtomicReference();
   private AtomicReference<ParseQueryController> queryController = new AtomicReference();
   private AtomicReference<ParseSessionController> sessionController = new AtomicReference();
   private AtomicReference<ParseObjectSubclassingController> subclassingController = new AtomicReference();
   private AtomicReference<ParseUserController> userController = new AtomicReference();

   public static ParseCorePlugins getInstance() {
      return INSTANCE;
   }

   public ParseAnalyticsController getAnalyticsController() {
      if(this.analyticsController.get() == null) {
         this.analyticsController.compareAndSet((Object)null, new ParseAnalyticsController(Parse.getEventuallyQueue()));
      }

      return (ParseAnalyticsController)this.analyticsController.get();
   }

   public ParseAuthenticationManager getAuthenticationManager() {
      if(this.authenticationController.get() == null) {
         ParseAuthenticationManager var1 = new ParseAuthenticationManager(this.getCurrentUserController());
         this.authenticationController.compareAndSet((Object)null, var1);
      }

      return (ParseAuthenticationManager)this.authenticationController.get();
   }

   public ParseCloudCodeController getCloudCodeController() {
      if(this.cloudCodeController.get() == null) {
         this.cloudCodeController.compareAndSet((Object)null, new ParseCloudCodeController(ParsePlugins.get().restClient()));
      }

      return (ParseCloudCodeController)this.cloudCodeController.get();
   }

   public ParseConfigController getConfigController() {
      if(this.configController.get() == null) {
         ParseCurrentConfigController var1 = new ParseCurrentConfigController(new File(ParsePlugins.get().getParseDir(), "currentConfig"));
         this.configController.compareAndSet((Object)null, new ParseConfigController(ParsePlugins.get().restClient(), var1));
      }

      return (ParseConfigController)this.configController.get();
   }

   public ParseCurrentInstallationController getCurrentInstallationController() {
      if(this.currentInstallationController.get() == null) {
         FileObjectStore var1 = new FileObjectStore(ParseInstallation.class, new File(ParsePlugins.get().getParseDir(), "currentInstallation"), ParseObjectCurrentCoder.get());
         Object var2;
         if(Parse.isLocalDatastoreEnabled()) {
            var2 = new OfflineObjectStore(ParseInstallation.class, "_currentInstallation", var1);
         } else {
            var2 = var1;
         }

         CachedCurrentInstallationController var3 = new CachedCurrentInstallationController((ParseObjectStore)var2, ParsePlugins.get().installationId());
         this.currentInstallationController.compareAndSet((Object)null, var3);
      }

      return (ParseCurrentInstallationController)this.currentInstallationController.get();
   }

   public ParseCurrentUserController getCurrentUserController() {
      if(this.currentUserController.get() == null) {
         FileObjectStore var1 = new FileObjectStore(ParseUser.class, new File(Parse.getParseDir(), "currentUser"), ParseUserCurrentCoder.get());
         Object var2;
         if(Parse.isLocalDatastoreEnabled()) {
            var2 = new OfflineObjectStore(ParseUser.class, "_currentUser", var1);
         } else {
            var2 = var1;
         }

         CachedCurrentUserController var3 = new CachedCurrentUserController((ParseObjectStore)var2);
         this.currentUserController.compareAndSet((Object)null, var3);
      }

      return (ParseCurrentUserController)this.currentUserController.get();
   }

   public ParseDefaultACLController getDefaultACLController() {
      if(this.defaultACLController.get() == null) {
         ParseDefaultACLController var1 = new ParseDefaultACLController();
         this.defaultACLController.compareAndSet((Object)null, var1);
      }

      return (ParseDefaultACLController)this.defaultACLController.get();
   }

   public ParseFileController getFileController() {
      if(this.fileController.get() == null) {
         this.fileController.compareAndSet((Object)null, new ParseFileController(ParsePlugins.get().restClient(), Parse.getParseCacheDir("files")));
      }

      return (ParseFileController)this.fileController.get();
   }

   public LocalIdManager getLocalIdManager() {
      if(this.localIdManager.get() == null) {
         LocalIdManager var1 = new LocalIdManager(Parse.getParseDir());
         this.localIdManager.compareAndSet((Object)null, var1);
      }

      return (LocalIdManager)this.localIdManager.get();
   }

   public ParseObjectController getObjectController() {
      if(this.objectController.get() == null) {
         this.objectController.compareAndSet((Object)null, new NetworkObjectController(ParsePlugins.get().restClient()));
      }

      return (ParseObjectController)this.objectController.get();
   }

   public ParsePushChannelsController getPushChannelsController() {
      if(this.pushChannelsController.get() == null) {
         this.pushChannelsController.compareAndSet((Object)null, new ParsePushChannelsController());
      }

      return (ParsePushChannelsController)this.pushChannelsController.get();
   }

   public ParsePushController getPushController() {
      if(this.pushController.get() == null) {
         this.pushController.compareAndSet((Object)null, new ParsePushController(ParsePlugins.get().restClient()));
      }

      return (ParsePushController)this.pushController.get();
   }

   public ParseQueryController getQueryController() {
      if(this.queryController.get() == null) {
         NetworkQueryController var1 = new NetworkQueryController(ParsePlugins.get().restClient());
         Object var2;
         if(Parse.isLocalDatastoreEnabled()) {
            var2 = new OfflineQueryController(Parse.getLocalDatastore(), var1);
         } else {
            var2 = new CacheQueryController(var1);
         }

         this.queryController.compareAndSet((Object)null, var2);
      }

      return (ParseQueryController)this.queryController.get();
   }

   public ParseSessionController getSessionController() {
      if(this.sessionController.get() == null) {
         this.sessionController.compareAndSet((Object)null, new NetworkSessionController(ParsePlugins.get().restClient()));
      }

      return (ParseSessionController)this.sessionController.get();
   }

   public ParseObjectSubclassingController getSubclassingController() {
      if(this.subclassingController.get() == null) {
         ParseObjectSubclassingController var1 = new ParseObjectSubclassingController();
         this.subclassingController.compareAndSet((Object)null, var1);
      }

      return (ParseObjectSubclassingController)this.subclassingController.get();
   }

   public ParseUserController getUserController() {
      if(this.userController.get() == null) {
         this.userController.compareAndSet((Object)null, new NetworkUserController(ParsePlugins.get().restClient()));
      }

      return (ParseUserController)this.userController.get();
   }

   public void registerAnalyticsController(ParseAnalyticsController var1) {
      if(!this.analyticsController.compareAndSet((Object)null, var1)) {
         throw new IllegalStateException("Another analytics controller was already registered: " + this.analyticsController.get());
      }
   }

   public void registerAuthenticationManager(ParseAuthenticationManager var1) {
      if(!this.authenticationController.compareAndSet((Object)null, var1)) {
         throw new IllegalStateException("Another authentication manager was already registered: " + this.authenticationController.get());
      }
   }

   public void registerCloudCodeController(ParseCloudCodeController var1) {
      if(!this.cloudCodeController.compareAndSet((Object)null, var1)) {
         throw new IllegalStateException("Another cloud code controller was already registered: " + this.cloudCodeController.get());
      }
   }

   public void registerConfigController(ParseConfigController var1) {
      if(!this.configController.compareAndSet((Object)null, var1)) {
         throw new IllegalStateException("Another config controller was already registered: " + this.configController.get());
      }
   }

   public void registerCurrentInstallationController(ParseCurrentInstallationController var1) {
      if(!this.currentInstallationController.compareAndSet((Object)null, var1)) {
         throw new IllegalStateException("Another currentInstallation controller was already registered: " + this.currentInstallationController.get());
      }
   }

   public void registerCurrentUserController(ParseCurrentUserController var1) {
      if(!this.currentUserController.compareAndSet((Object)null, var1)) {
         throw new IllegalStateException("Another currentUser controller was already registered: " + this.currentUserController.get());
      }
   }

   public void registerDefaultACLController(ParseDefaultACLController var1) {
      if(!this.defaultACLController.compareAndSet((Object)null, var1)) {
         throw new IllegalStateException("Another defaultACL controller was already registered: " + this.defaultACLController.get());
      }
   }

   public void registerFileController(ParseFileController var1) {
      if(!this.fileController.compareAndSet((Object)null, var1)) {
         throw new IllegalStateException("Another file controller was already registered: " + this.fileController.get());
      }
   }

   public void registerLocalIdManager(LocalIdManager var1) {
      if(!this.localIdManager.compareAndSet((Object)null, var1)) {
         throw new IllegalStateException("Another localId manager was already registered: " + this.localIdManager.get());
      }
   }

   public void registerObjectController(ParseObjectController var1) {
      if(!this.objectController.compareAndSet((Object)null, var1)) {
         throw new IllegalStateException("Another object controller was already registered: " + this.objectController.get());
      }
   }

   public void registerPushChannelsController(ParsePushChannelsController var1) {
      if(!this.pushChannelsController.compareAndSet((Object)null, var1)) {
         throw new IllegalStateException("Another pushChannels controller was already registered: " + this.pushChannelsController.get());
      }
   }

   public void registerPushController(ParsePushController var1) {
      if(!this.pushController.compareAndSet((Object)null, var1)) {
         throw new IllegalStateException("Another push controller was already registered: " + this.pushController.get());
      }
   }

   public void registerQueryController(ParseQueryController var1) {
      if(!this.queryController.compareAndSet((Object)null, var1)) {
         throw new IllegalStateException("Another query controller was already registered: " + this.queryController.get());
      }
   }

   public void registerSessionController(ParseSessionController var1) {
      if(!this.sessionController.compareAndSet((Object)null, var1)) {
         throw new IllegalStateException("Another session controller was already registered: " + this.sessionController.get());
      }
   }

   public void registerSubclassingController(ParseObjectSubclassingController var1) {
      if(!this.subclassingController.compareAndSet((Object)null, var1)) {
         throw new IllegalStateException("Another subclassing controller was already registered: " + this.subclassingController.get());
      }
   }

   public void registerUserController(ParseUserController var1) {
      if(!this.userController.compareAndSet((Object)null, var1)) {
         throw new IllegalStateException("Another user controller was already registered: " + this.userController.get());
      }
   }

   void reset() {
      this.objectController.set((Object)null);
      this.userController.set((Object)null);
      this.sessionController.set((Object)null);
      this.currentUserController.set((Object)null);
      this.currentInstallationController.set((Object)null);
      this.authenticationController.set((Object)null);
      this.queryController.set((Object)null);
      this.fileController.set((Object)null);
      this.analyticsController.set((Object)null);
      this.cloudCodeController.set((Object)null);
      this.configController.set((Object)null);
      this.pushController.set((Object)null);
      this.pushChannelsController.set((Object)null);
      this.defaultACLController.set((Object)null);
      this.localIdManager.set((Object)null);
   }
}
