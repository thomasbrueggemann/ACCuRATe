package com.google.tagmanager;

import com.google.tagmanager.Clock;
import com.google.tagmanager.Container;
import com.google.tagmanager.Log;
import com.google.tagmanager.TagManager;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Semaphore;

public class ContainerOpener {
    public static final long DEFAULT_TIMEOUT_IN_MILLIS = 2000L;
    private static final Map<String, List<ContainerOpener.Notifier>> mContainerIdNotifiersMap = new HashMap();
    private Clock mClock = new Clock() {
        public long currentTimeMillis() {
            return System.currentTimeMillis();
        }
    };
    private volatile Container mContainer;
    private final String mContainerId;
    private boolean mHaveNotified;
    private ContainerOpener.Notifier mNotifier;
    private final TagManager mTagManager;
    private final long mTimeoutInMillis;

    private ContainerOpener(TagManager var1, String var2, Long var3, ContainerOpener.Notifier var4) {
        this.mTagManager = var1;
        this.mContainerId = var2;
        long var5;
        if(var3 != null) {
            var5 = Math.max(1L, var3.longValue());
        } else {
            var5 = 2000L;
        }

        this.mTimeoutInMillis = var5;
        this.mNotifier = var4;
    }

    private void callNotifiers(Container param1) {
        // $FF: Couldn't be decompiled
    }

    private void open(Container.RefreshType param1) {
        // $FF: Couldn't be decompiled
    }

    public static ContainerOpener.ContainerFuture openContainer(TagManager var0, String var1, ContainerOpener.OpenType var2, Long var3) {
        final ContainerOpener.ContainerFutureImpl var4 = new ContainerOpener.ContainerFutureImpl(null);
        openContainer(var0, var1, var2, var3, new ContainerOpener.Notifier() {
            public void containerAvailable(Container var1) {
                var4.setContainer(var1);
            }
        });
        return var4;
    }

    public static void openContainer(TagManager var0, String var1, ContainerOpener.OpenType var2, Long var3, ContainerOpener.Notifier var4) {
        if(var0 == null) {
            throw new NullPointerException("TagManager cannot be null.");
        } else if(var1 == null) {
            throw new NullPointerException("ContainerId cannot be null.");
        } else if(var2 == null) {
            throw new NullPointerException("OpenType cannot be null.");
        } else if(var4 == null) {
            throw new NullPointerException("Notifier cannot be null.");
        } else {
            ContainerOpener var5 = new ContainerOpener(var0, var1, var3, var4);
            Container.RefreshType var6;
            if(var2 == ContainerOpener.OpenType.PREFER_FRESH) {
                var6 = Container.RefreshType.NETWORK;
            } else {
                var6 = Container.RefreshType.SAVED;
            }

            var5.open(var6);
        }
    }

    private void setTimer(long var1) {
        TimerTask var3 = new TimerTask() {
            public void run() {
                Log.method_5505("Timer expired.");
                ContainerOpener.this.callNotifiers(ContainerOpener.this.mContainer);
            }
        };
        (new Timer("ContainerOpener")).schedule(var3, var1);
    }

    public interface ContainerFuture {
        Container get();

        boolean isDone();
    }

    private static class ContainerFutureImpl implements ContainerOpener.ContainerFuture {
        private volatile Container mContainer;
        private Semaphore mContainerIsReady;
        private volatile boolean mHaveGotten;

        private ContainerFutureImpl() {
            this.mContainerIsReady = new Semaphore(0);
        }

        // $FF: synthetic method
        ContainerFutureImpl(Object var1) {
            this();
        }

        public Container get() {
            if(this.mHaveGotten) {
                return this.mContainer;
            } else {
                try {
                    this.mContainerIsReady.acquire();
                } catch (InterruptedException var2) {
                    ;
                }

                this.mHaveGotten = true;
                return this.mContainer;
            }
        }

        public boolean isDone() {
            return this.mHaveGotten || this.mContainerIsReady.availablePermits() > 0;
        }

        public void setContainer(Container var1) {
            this.mContainer = var1;
            this.mContainerIsReady.release();
        }
    }

    public interface Notifier {
        void containerAvailable(Container var1);
    }

    public static enum OpenType {
        PREFER_FRESH,
        PREFER_NON_DEFAULT;

        static {
            ContainerOpener.OpenType[] var0 = new ContainerOpener.OpenType[]{PREFER_NON_DEFAULT, PREFER_FRESH};
        }
    }

    private class WaitForFresh implements Container.Callback {
        private final long mOldestTimeToBeFresh;

        public WaitForFresh(long var2) {
            this.mOldestTimeToBeFresh = var2;
        }

        private boolean isFresh() {
            return this.mOldestTimeToBeFresh < ContainerOpener.this.mContainer.getLastRefreshTime();
        }

        public void containerRefreshBegin(Container var1, Container.RefreshType var2) {
        }

        public void containerRefreshFailure(Container var1, Container.RefreshType var2, Container.RefreshFailure var3) {
            if(var2 == Container.RefreshType.NETWORK) {
                ContainerOpener.this.callNotifiers(var1);
            }

        }

        public void containerRefreshSuccess(Container var1, Container.RefreshType var2) {
            if(var2 == Container.RefreshType.NETWORK || this.isFresh()) {
                ContainerOpener.this.callNotifiers(var1);
            }

        }
    }

    private class WaitForNonDefaultRefresh implements Container.Callback {
        public void containerRefreshBegin(Container var1, Container.RefreshType var2) {
        }

        public void containerRefreshFailure(Container var1, Container.RefreshType var2, Container.RefreshFailure var3) {
            if(var2 == Container.RefreshType.NETWORK) {
                ContainerOpener.this.callNotifiers(var1);
            }

        }

        public void containerRefreshSuccess(Container var1, Container.RefreshType var2) {
            ContainerOpener.this.callNotifiers(var1);
        }
    }
}
