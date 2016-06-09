.class public Lorg/apache/commons/lang3/SystemUtils;
.super Ljava/lang/Object;
.source "SystemUtils.java"


# static fields
.field public static final AWT_TOOLKIT:Ljava/lang/String;

.field public static final FILE_ENCODING:Ljava/lang/String;

.field public static final FILE_SEPARATOR:Ljava/lang/String;

.field public static final IS_JAVA_1_1:Z

.field public static final IS_JAVA_1_2:Z

.field public static final IS_JAVA_1_3:Z

.field public static final IS_JAVA_1_4:Z

.field public static final IS_JAVA_1_5:Z

.field public static final IS_JAVA_1_6:Z

.field public static final IS_JAVA_1_7:Z

.field public static final IS_JAVA_1_8:Z

.field public static final IS_JAVA_1_9:Z

.field public static final IS_OS_400:Z

.field public static final IS_OS_AIX:Z

.field public static final IS_OS_FREE_BSD:Z

.field public static final IS_OS_HP_UX:Z

.field public static final IS_OS_IRIX:Z

.field public static final IS_OS_LINUX:Z

.field public static final IS_OS_MAC:Z

.field public static final IS_OS_MAC_OSX:Z

.field public static final IS_OS_MAC_OSX_CHEETAH:Z

.field public static final IS_OS_MAC_OSX_JAGUAR:Z

.field public static final IS_OS_MAC_OSX_LEOPARD:Z

.field public static final IS_OS_MAC_OSX_LION:Z

.field public static final IS_OS_MAC_OSX_MAVERICKS:Z

.field public static final IS_OS_MAC_OSX_MOUNTAIN_LION:Z

.field public static final IS_OS_MAC_OSX_PANTHER:Z

.field public static final IS_OS_MAC_OSX_PUMA:Z

.field public static final IS_OS_MAC_OSX_SNOW_LEOPARD:Z

.field public static final IS_OS_MAC_OSX_TIGER:Z

.field public static final IS_OS_MAC_OSX_YOSEMITE:Z

.field public static final IS_OS_NET_BSD:Z

.field public static final IS_OS_OPEN_BSD:Z

.field public static final IS_OS_OS2:Z

.field public static final IS_OS_SOLARIS:Z

.field public static final IS_OS_SUN_OS:Z

.field public static final IS_OS_UNIX:Z

.field public static final IS_OS_WINDOWS:Z

.field public static final IS_OS_WINDOWS_2000:Z

.field public static final IS_OS_WINDOWS_2003:Z

.field public static final IS_OS_WINDOWS_2008:Z

.field public static final IS_OS_WINDOWS_2012:Z

.field public static final IS_OS_WINDOWS_7:Z

.field public static final IS_OS_WINDOWS_8:Z

.field public static final IS_OS_WINDOWS_95:Z

.field public static final IS_OS_WINDOWS_98:Z

.field public static final IS_OS_WINDOWS_ME:Z

.field public static final IS_OS_WINDOWS_NT:Z

.field public static final IS_OS_WINDOWS_VISTA:Z

.field public static final IS_OS_WINDOWS_XP:Z

.field public static final JAVA_AWT_FONTS:Ljava/lang/String;

.field public static final JAVA_AWT_GRAPHICSENV:Ljava/lang/String;

.field public static final JAVA_AWT_HEADLESS:Ljava/lang/String;

.field public static final JAVA_AWT_PRINTERJOB:Ljava/lang/String;

.field public static final JAVA_CLASS_PATH:Ljava/lang/String;

.field public static final JAVA_CLASS_VERSION:Ljava/lang/String;

.field public static final JAVA_COMPILER:Ljava/lang/String;

.field public static final JAVA_ENDORSED_DIRS:Ljava/lang/String;

.field public static final JAVA_EXT_DIRS:Ljava/lang/String;

.field public static final JAVA_HOME:Ljava/lang/String;

.field public static final JAVA_IO_TMPDIR:Ljava/lang/String;

.field public static final JAVA_LIBRARY_PATH:Ljava/lang/String;

.field public static final JAVA_RUNTIME_NAME:Ljava/lang/String;

.field public static final JAVA_RUNTIME_VERSION:Ljava/lang/String;

.field public static final JAVA_SPECIFICATION_NAME:Ljava/lang/String;

.field public static final JAVA_SPECIFICATION_VENDOR:Ljava/lang/String;

.field public static final JAVA_SPECIFICATION_VERSION:Ljava/lang/String;

.field private static final JAVA_SPECIFICATION_VERSION_AS_ENUM:Lorg/apache/commons/lang3/JavaVersion;

.field public static final JAVA_UTIL_PREFS_PREFERENCES_FACTORY:Ljava/lang/String;

.field public static final JAVA_VENDOR:Ljava/lang/String;

.field public static final JAVA_VENDOR_URL:Ljava/lang/String;

.field public static final JAVA_VERSION:Ljava/lang/String;

.field public static final JAVA_VM_INFO:Ljava/lang/String;

.field public static final JAVA_VM_NAME:Ljava/lang/String;

.field public static final JAVA_VM_SPECIFICATION_NAME:Ljava/lang/String;

.field public static final JAVA_VM_SPECIFICATION_VENDOR:Ljava/lang/String;

.field public static final JAVA_VM_SPECIFICATION_VERSION:Ljava/lang/String;

.field public static final JAVA_VM_VENDOR:Ljava/lang/String;

.field public static final JAVA_VM_VERSION:Ljava/lang/String;

.field public static final LINE_SEPARATOR:Ljava/lang/String;

.field public static final OS_ARCH:Ljava/lang/String;

.field public static final OS_NAME:Ljava/lang/String;

.field public static final OS_VERSION:Ljava/lang/String;

.field public static final PATH_SEPARATOR:Ljava/lang/String;

.field public static final USER_COUNTRY:Ljava/lang/String;

.field public static final USER_DIR:Ljava/lang/String;

.field public static final USER_HOME:Ljava/lang/String;

.field public static final USER_LANGUAGE:Ljava/lang/String;

.field public static final USER_NAME:Ljava/lang/String;

.field public static final USER_TIMEZONE:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 4

    .prologue
    const/4 v2, 0x1

    const/4 v1, 0x0

    .line 89
    const-string v0, "awt.toolkit"

    invoke-static {v0}, Lorg/apache/commons/lang3/SystemUtils;->getSystemProperty(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lorg/apache/commons/lang3/SystemUtils;->AWT_TOOLKIT:Ljava/lang/String;

    .line 111
    const-string v0, "file.encoding"

    invoke-static {v0}, Lorg/apache/commons/lang3/SystemUtils;->getSystemProperty(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lorg/apache/commons/lang3/SystemUtils;->FILE_ENCODING:Ljava/lang/String;

    .line 135
    const-string v0, "file.separator"

    invoke-static {v0}, Lorg/apache/commons/lang3/SystemUtils;->getSystemProperty(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lorg/apache/commons/lang3/SystemUtils;->FILE_SEPARATOR:Ljava/lang/String;

    .line 153
    const-string v0, "java.awt.fonts"

    invoke-static {v0}, Lorg/apache/commons/lang3/SystemUtils;->getSystemProperty(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lorg/apache/commons/lang3/SystemUtils;->JAVA_AWT_FONTS:Ljava/lang/String;

    .line 171
    const-string v0, "java.awt.graphicsenv"

    invoke-static {v0}, Lorg/apache/commons/lang3/SystemUtils;->getSystemProperty(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lorg/apache/commons/lang3/SystemUtils;->JAVA_AWT_GRAPHICSENV:Ljava/lang/String;

    .line 192
    const-string v0, "java.awt.headless"

    invoke-static {v0}, Lorg/apache/commons/lang3/SystemUtils;->getSystemProperty(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lorg/apache/commons/lang3/SystemUtils;->JAVA_AWT_HEADLESS:Ljava/lang/String;

    .line 210
    const-string v0, "java.awt.printerjob"

    invoke-static {v0}, Lorg/apache/commons/lang3/SystemUtils;->getSystemProperty(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lorg/apache/commons/lang3/SystemUtils;->JAVA_AWT_PRINTERJOB:Ljava/lang/String;

    .line 228
    const-string v0, "java.class.path"

    invoke-static {v0}, Lorg/apache/commons/lang3/SystemUtils;->getSystemProperty(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lorg/apache/commons/lang3/SystemUtils;->JAVA_CLASS_PATH:Ljava/lang/String;

    .line 246
    const-string v0, "java.class.version"

    invoke-static {v0}, Lorg/apache/commons/lang3/SystemUtils;->getSystemProperty(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lorg/apache/commons/lang3/SystemUtils;->JAVA_CLASS_VERSION:Ljava/lang/String;

    .line 265
    const-string v0, "java.compiler"

    invoke-static {v0}, Lorg/apache/commons/lang3/SystemUtils;->getSystemProperty(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lorg/apache/commons/lang3/SystemUtils;->JAVA_COMPILER:Ljava/lang/String;

    .line 283
    const-string v0, "java.endorsed.dirs"

    invoke-static {v0}, Lorg/apache/commons/lang3/SystemUtils;->getSystemProperty(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lorg/apache/commons/lang3/SystemUtils;->JAVA_ENDORSED_DIRS:Ljava/lang/String;

    .line 301
    const-string v0, "java.ext.dirs"

    invoke-static {v0}, Lorg/apache/commons/lang3/SystemUtils;->getSystemProperty(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lorg/apache/commons/lang3/SystemUtils;->JAVA_EXT_DIRS:Ljava/lang/String;

    .line 319
    const-string v0, "java.home"

    invoke-static {v0}, Lorg/apache/commons/lang3/SystemUtils;->getSystemProperty(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lorg/apache/commons/lang3/SystemUtils;->JAVA_HOME:Ljava/lang/String;

    .line 337
    const-string v0, "java.io.tmpdir"

    invoke-static {v0}, Lorg/apache/commons/lang3/SystemUtils;->getSystemProperty(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lorg/apache/commons/lang3/SystemUtils;->JAVA_IO_TMPDIR:Ljava/lang/String;

    .line 355
    const-string v0, "java.library.path"

    invoke-static {v0}, Lorg/apache/commons/lang3/SystemUtils;->getSystemProperty(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lorg/apache/commons/lang3/SystemUtils;->JAVA_LIBRARY_PATH:Ljava/lang/String;

    .line 374
    const-string v0, "java.runtime.name"

    invoke-static {v0}, Lorg/apache/commons/lang3/SystemUtils;->getSystemProperty(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lorg/apache/commons/lang3/SystemUtils;->JAVA_RUNTIME_NAME:Ljava/lang/String;

    .line 393
    const-string v0, "java.runtime.version"

    invoke-static {v0}, Lorg/apache/commons/lang3/SystemUtils;->getSystemProperty(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lorg/apache/commons/lang3/SystemUtils;->JAVA_RUNTIME_VERSION:Ljava/lang/String;

    .line 411
    const-string v0, "java.specification.name"

    invoke-static {v0}, Lorg/apache/commons/lang3/SystemUtils;->getSystemProperty(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lorg/apache/commons/lang3/SystemUtils;->JAVA_SPECIFICATION_NAME:Ljava/lang/String;

    .line 429
    const-string v0, "java.specification.vendor"

    invoke-static {v0}, Lorg/apache/commons/lang3/SystemUtils;->getSystemProperty(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lorg/apache/commons/lang3/SystemUtils;->JAVA_SPECIFICATION_VENDOR:Ljava/lang/String;

    .line 447
    const-string v0, "java.specification.version"

    invoke-static {v0}, Lorg/apache/commons/lang3/SystemUtils;->getSystemProperty(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lorg/apache/commons/lang3/SystemUtils;->JAVA_SPECIFICATION_VERSION:Ljava/lang/String;

    .line 448
    sget-object v0, Lorg/apache/commons/lang3/SystemUtils;->JAVA_SPECIFICATION_VERSION:Ljava/lang/String;

    invoke-static {v0}, Lorg/apache/commons/lang3/JavaVersion;->get(Ljava/lang/String;)Lorg/apache/commons/lang3/JavaVersion;

    move-result-object v0

    sput-object v0, Lorg/apache/commons/lang3/SystemUtils;->JAVA_SPECIFICATION_VERSION_AS_ENUM:Lorg/apache/commons/lang3/JavaVersion;

    .line 467
    const-string v0, "java.util.prefs.PreferencesFactory"

    invoke-static {v0}, Lorg/apache/commons/lang3/SystemUtils;->getSystemProperty(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lorg/apache/commons/lang3/SystemUtils;->JAVA_UTIL_PREFS_PREFERENCES_FACTORY:Ljava/lang/String;

    .line 486
    const-string v0, "java.vendor"

    invoke-static {v0}, Lorg/apache/commons/lang3/SystemUtils;->getSystemProperty(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lorg/apache/commons/lang3/SystemUtils;->JAVA_VENDOR:Ljava/lang/String;

    .line 504
    const-string v0, "java.vendor.url"

    invoke-static {v0}, Lorg/apache/commons/lang3/SystemUtils;->getSystemProperty(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lorg/apache/commons/lang3/SystemUtils;->JAVA_VENDOR_URL:Ljava/lang/String;

    .line 522
    const-string v0, "java.version"

    invoke-static {v0}, Lorg/apache/commons/lang3/SystemUtils;->getSystemProperty(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lorg/apache/commons/lang3/SystemUtils;->JAVA_VERSION:Ljava/lang/String;

    .line 541
    const-string v0, "java.vm.info"

    invoke-static {v0}, Lorg/apache/commons/lang3/SystemUtils;->getSystemProperty(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lorg/apache/commons/lang3/SystemUtils;->JAVA_VM_INFO:Ljava/lang/String;

    .line 559
    const-string v0, "java.vm.name"

    invoke-static {v0}, Lorg/apache/commons/lang3/SystemUtils;->getSystemProperty(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lorg/apache/commons/lang3/SystemUtils;->JAVA_VM_NAME:Ljava/lang/String;

    .line 577
    const-string v0, "java.vm.specification.name"

    invoke-static {v0}, Lorg/apache/commons/lang3/SystemUtils;->getSystemProperty(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lorg/apache/commons/lang3/SystemUtils;->JAVA_VM_SPECIFICATION_NAME:Ljava/lang/String;

    .line 595
    const-string v0, "java.vm.specification.vendor"

    invoke-static {v0}, Lorg/apache/commons/lang3/SystemUtils;->getSystemProperty(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lorg/apache/commons/lang3/SystemUtils;->JAVA_VM_SPECIFICATION_VENDOR:Ljava/lang/String;

    .line 613
    const-string v0, "java.vm.specification.version"

    invoke-static {v0}, Lorg/apache/commons/lang3/SystemUtils;->getSystemProperty(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lorg/apache/commons/lang3/SystemUtils;->JAVA_VM_SPECIFICATION_VERSION:Ljava/lang/String;

    .line 631
    const-string v0, "java.vm.vendor"

    invoke-static {v0}, Lorg/apache/commons/lang3/SystemUtils;->getSystemProperty(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lorg/apache/commons/lang3/SystemUtils;->JAVA_VM_VENDOR:Ljava/lang/String;

    .line 649
    const-string v0, "java.vm.version"

    invoke-static {v0}, Lorg/apache/commons/lang3/SystemUtils;->getSystemProperty(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lorg/apache/commons/lang3/SystemUtils;->JAVA_VM_VERSION:Ljava/lang/String;

    .line 667
    const-string v0, "line.separator"

    invoke-static {v0}, Lorg/apache/commons/lang3/SystemUtils;->getSystemProperty(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lorg/apache/commons/lang3/SystemUtils;->LINE_SEPARATOR:Ljava/lang/String;

    .line 685
    const-string v0, "os.arch"

    invoke-static {v0}, Lorg/apache/commons/lang3/SystemUtils;->getSystemProperty(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lorg/apache/commons/lang3/SystemUtils;->OS_ARCH:Ljava/lang/String;

    .line 703
    const-string v0, "os.name"

    invoke-static {v0}, Lorg/apache/commons/lang3/SystemUtils;->getSystemProperty(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lorg/apache/commons/lang3/SystemUtils;->OS_NAME:Ljava/lang/String;

    .line 721
    const-string v0, "os.version"

    invoke-static {v0}, Lorg/apache/commons/lang3/SystemUtils;->getSystemProperty(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lorg/apache/commons/lang3/SystemUtils;->OS_VERSION:Ljava/lang/String;

    .line 739
    const-string v0, "path.separator"

    invoke-static {v0}, Lorg/apache/commons/lang3/SystemUtils;->getSystemProperty(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lorg/apache/commons/lang3/SystemUtils;->PATH_SEPARATOR:Ljava/lang/String;

    .line 759
    const-string v0, "user.country"

    invoke-static {v0}, Lorg/apache/commons/lang3/SystemUtils;->getSystemProperty(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    if-nez v0, :cond_3

    const-string v0, "user.region"

    invoke-static {v0}, Lorg/apache/commons/lang3/SystemUtils;->getSystemProperty(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    :goto_0
    sput-object v0, Lorg/apache/commons/lang3/SystemUtils;->USER_COUNTRY:Ljava/lang/String;

    .line 778
    const-string v0, "user.dir"

    invoke-static {v0}, Lorg/apache/commons/lang3/SystemUtils;->getSystemProperty(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lorg/apache/commons/lang3/SystemUtils;->USER_DIR:Ljava/lang/String;

    .line 796
    const-string v0, "user.home"

    invoke-static {v0}, Lorg/apache/commons/lang3/SystemUtils;->getSystemProperty(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lorg/apache/commons/lang3/SystemUtils;->USER_HOME:Ljava/lang/String;

    .line 815
    const-string v0, "user.language"

    invoke-static {v0}, Lorg/apache/commons/lang3/SystemUtils;->getSystemProperty(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lorg/apache/commons/lang3/SystemUtils;->USER_LANGUAGE:Ljava/lang/String;

    .line 833
    const-string v0, "user.name"

    invoke-static {v0}, Lorg/apache/commons/lang3/SystemUtils;->getSystemProperty(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lorg/apache/commons/lang3/SystemUtils;->USER_NAME:Ljava/lang/String;

    .line 851
    const-string v0, "user.timezone"

    invoke-static {v0}, Lorg/apache/commons/lang3/SystemUtils;->getSystemProperty(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lorg/apache/commons/lang3/SystemUtils;->USER_TIMEZONE:Ljava/lang/String;

    .line 866
    const-string v0, "1.1"

    invoke-static {v0}, Lorg/apache/commons/lang3/SystemUtils;->getJavaVersionMatches(Ljava/lang/String;)Z

    move-result v0

    sput-boolean v0, Lorg/apache/commons/lang3/SystemUtils;->IS_JAVA_1_1:Z

    .line 876
    const-string v0, "1.2"

    invoke-static {v0}, Lorg/apache/commons/lang3/SystemUtils;->getJavaVersionMatches(Ljava/lang/String;)Z

    move-result v0

    sput-boolean v0, Lorg/apache/commons/lang3/SystemUtils;->IS_JAVA_1_2:Z

    .line 886
    const-string v0, "1.3"

    invoke-static {v0}, Lorg/apache/commons/lang3/SystemUtils;->getJavaVersionMatches(Ljava/lang/String;)Z

    move-result v0

    sput-boolean v0, Lorg/apache/commons/lang3/SystemUtils;->IS_JAVA_1_3:Z

    .line 896
    const-string v0, "1.4"

    invoke-static {v0}, Lorg/apache/commons/lang3/SystemUtils;->getJavaVersionMatches(Ljava/lang/String;)Z

    move-result v0

    sput-boolean v0, Lorg/apache/commons/lang3/SystemUtils;->IS_JAVA_1_4:Z

    .line 906
    const-string v0, "1.5"

    invoke-static {v0}, Lorg/apache/commons/lang3/SystemUtils;->getJavaVersionMatches(Ljava/lang/String;)Z

    move-result v0

    sput-boolean v0, Lorg/apache/commons/lang3/SystemUtils;->IS_JAVA_1_5:Z

    .line 916
    const-string v0, "1.6"

    invoke-static {v0}, Lorg/apache/commons/lang3/SystemUtils;->getJavaVersionMatches(Ljava/lang/String;)Z

    move-result v0

    sput-boolean v0, Lorg/apache/commons/lang3/SystemUtils;->IS_JAVA_1_6:Z

    .line 928
    const-string v0, "1.7"

    invoke-static {v0}, Lorg/apache/commons/lang3/SystemUtils;->getJavaVersionMatches(Ljava/lang/String;)Z

    move-result v0

    sput-boolean v0, Lorg/apache/commons/lang3/SystemUtils;->IS_JAVA_1_7:Z

    .line 940
    const-string v0, "1.8"

    invoke-static {v0}, Lorg/apache/commons/lang3/SystemUtils;->getJavaVersionMatches(Ljava/lang/String;)Z

    move-result v0

    sput-boolean v0, Lorg/apache/commons/lang3/SystemUtils;->IS_JAVA_1_8:Z

    .line 952
    const-string v0, "1.9"

    invoke-static {v0}, Lorg/apache/commons/lang3/SystemUtils;->getJavaVersionMatches(Ljava/lang/String;)Z

    move-result v0

    sput-boolean v0, Lorg/apache/commons/lang3/SystemUtils;->IS_JAVA_1_9:Z

    .line 972
    const-string v0, "AIX"

    invoke-static {v0}, Lorg/apache/commons/lang3/SystemUtils;->getOSMatchesName(Ljava/lang/String;)Z

    move-result v0

    sput-boolean v0, Lorg/apache/commons/lang3/SystemUtils;->IS_OS_AIX:Z

    .line 984
    const-string v0, "HP-UX"

    invoke-static {v0}, Lorg/apache/commons/lang3/SystemUtils;->getOSMatchesName(Ljava/lang/String;)Z

    move-result v0

    sput-boolean v0, Lorg/apache/commons/lang3/SystemUtils;->IS_OS_HP_UX:Z

    .line 996
    const-string v0, "OS/400"

    invoke-static {v0}, Lorg/apache/commons/lang3/SystemUtils;->getOSMatchesName(Ljava/lang/String;)Z

    move-result v0

    sput-boolean v0, Lorg/apache/commons/lang3/SystemUtils;->IS_OS_400:Z

    .line 1008
    const-string v0, "Irix"

    invoke-static {v0}, Lorg/apache/commons/lang3/SystemUtils;->getOSMatchesName(Ljava/lang/String;)Z

    move-result v0

    sput-boolean v0, Lorg/apache/commons/lang3/SystemUtils;->IS_OS_IRIX:Z

    .line 1020
    const-string v0, "Linux"

    invoke-static {v0}, Lorg/apache/commons/lang3/SystemUtils;->getOSMatchesName(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_0

    const-string v0, "LINUX"

    invoke-static {v0}, Lorg/apache/commons/lang3/SystemUtils;->getOSMatchesName(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_4

    :cond_0
    move v0, v2

    :goto_1
    sput-boolean v0, Lorg/apache/commons/lang3/SystemUtils;->IS_OS_LINUX:Z

    .line 1032
    const-string v0, "Mac"

    invoke-static {v0}, Lorg/apache/commons/lang3/SystemUtils;->getOSMatchesName(Ljava/lang/String;)Z

    move-result v0

    sput-boolean v0, Lorg/apache/commons/lang3/SystemUtils;->IS_OS_MAC:Z

    .line 1044
    const-string v0, "Mac OS X"

    invoke-static {v0}, Lorg/apache/commons/lang3/SystemUtils;->getOSMatchesName(Ljava/lang/String;)Z

    move-result v0

    sput-boolean v0, Lorg/apache/commons/lang3/SystemUtils;->IS_OS_MAC_OSX:Z

    .line 1056
    const-string v0, "Mac OS X"

    const-string v3, "10.0"

    invoke-static {v0, v3}, Lorg/apache/commons/lang3/SystemUtils;->getOSMatches(Ljava/lang/String;Ljava/lang/String;)Z

    move-result v0

    sput-boolean v0, Lorg/apache/commons/lang3/SystemUtils;->IS_OS_MAC_OSX_CHEETAH:Z

    .line 1068
    const-string v0, "Mac OS X"

    const-string v3, "10.1"

    invoke-static {v0, v3}, Lorg/apache/commons/lang3/SystemUtils;->getOSMatches(Ljava/lang/String;Ljava/lang/String;)Z

    move-result v0

    sput-boolean v0, Lorg/apache/commons/lang3/SystemUtils;->IS_OS_MAC_OSX_PUMA:Z

    .line 1080
    const-string v0, "Mac OS X"

    const-string v3, "10.2"

    invoke-static {v0, v3}, Lorg/apache/commons/lang3/SystemUtils;->getOSMatches(Ljava/lang/String;Ljava/lang/String;)Z

    move-result v0

    sput-boolean v0, Lorg/apache/commons/lang3/SystemUtils;->IS_OS_MAC_OSX_JAGUAR:Z

    .line 1092
    const-string v0, "Mac OS X"

    const-string v3, "10.3"

    invoke-static {v0, v3}, Lorg/apache/commons/lang3/SystemUtils;->getOSMatches(Ljava/lang/String;Ljava/lang/String;)Z

    move-result v0

    sput-boolean v0, Lorg/apache/commons/lang3/SystemUtils;->IS_OS_MAC_OSX_PANTHER:Z

    .line 1104
    const-string v0, "Mac OS X"

    const-string v3, "10.4"

    invoke-static {v0, v3}, Lorg/apache/commons/lang3/SystemUtils;->getOSMatches(Ljava/lang/String;Ljava/lang/String;)Z

    move-result v0

    sput-boolean v0, Lorg/apache/commons/lang3/SystemUtils;->IS_OS_MAC_OSX_TIGER:Z

    .line 1116
    const-string v0, "Mac OS X"

    const-string v3, "10.5"

    invoke-static {v0, v3}, Lorg/apache/commons/lang3/SystemUtils;->getOSMatches(Ljava/lang/String;Ljava/lang/String;)Z

    move-result v0

    sput-boolean v0, Lorg/apache/commons/lang3/SystemUtils;->IS_OS_MAC_OSX_LEOPARD:Z

    .line 1128
    const-string v0, "Mac OS X"

    const-string v3, "10.6"

    invoke-static {v0, v3}, Lorg/apache/commons/lang3/SystemUtils;->getOSMatches(Ljava/lang/String;Ljava/lang/String;)Z

    move-result v0

    sput-boolean v0, Lorg/apache/commons/lang3/SystemUtils;->IS_OS_MAC_OSX_SNOW_LEOPARD:Z

    .line 1140
    const-string v0, "Mac OS X"

    const-string v3, "10.7"

    invoke-static {v0, v3}, Lorg/apache/commons/lang3/SystemUtils;->getOSMatches(Ljava/lang/String;Ljava/lang/String;)Z

    move-result v0

    sput-boolean v0, Lorg/apache/commons/lang3/SystemUtils;->IS_OS_MAC_OSX_LION:Z

    .line 1152
    const-string v0, "Mac OS X"

    const-string v3, "10.8"

    invoke-static {v0, v3}, Lorg/apache/commons/lang3/SystemUtils;->getOSMatches(Ljava/lang/String;Ljava/lang/String;)Z

    move-result v0

    sput-boolean v0, Lorg/apache/commons/lang3/SystemUtils;->IS_OS_MAC_OSX_MOUNTAIN_LION:Z

    .line 1164
    const-string v0, "Mac OS X"

    const-string v3, "10.9"

    invoke-static {v0, v3}, Lorg/apache/commons/lang3/SystemUtils;->getOSMatches(Ljava/lang/String;Ljava/lang/String;)Z

    move-result v0

    sput-boolean v0, Lorg/apache/commons/lang3/SystemUtils;->IS_OS_MAC_OSX_MAVERICKS:Z

    .line 1176
    const-string v0, "Mac OS X"

    const-string v3, "10.10"

    invoke-static {v0, v3}, Lorg/apache/commons/lang3/SystemUtils;->getOSMatches(Ljava/lang/String;Ljava/lang/String;)Z

    move-result v0

    sput-boolean v0, Lorg/apache/commons/lang3/SystemUtils;->IS_OS_MAC_OSX_YOSEMITE:Z

    .line 1188
    const-string v0, "FreeBSD"

    invoke-static {v0}, Lorg/apache/commons/lang3/SystemUtils;->getOSMatchesName(Ljava/lang/String;)Z

    move-result v0

    sput-boolean v0, Lorg/apache/commons/lang3/SystemUtils;->IS_OS_FREE_BSD:Z

    .line 1200
    const-string v0, "OpenBSD"

    invoke-static {v0}, Lorg/apache/commons/lang3/SystemUtils;->getOSMatchesName(Ljava/lang/String;)Z

    move-result v0

    sput-boolean v0, Lorg/apache/commons/lang3/SystemUtils;->IS_OS_OPEN_BSD:Z

    .line 1212
    const-string v0, "NetBSD"

    invoke-static {v0}, Lorg/apache/commons/lang3/SystemUtils;->getOSMatchesName(Ljava/lang/String;)Z

    move-result v0

    sput-boolean v0, Lorg/apache/commons/lang3/SystemUtils;->IS_OS_NET_BSD:Z

    .line 1224
    const-string v0, "OS/2"

    invoke-static {v0}, Lorg/apache/commons/lang3/SystemUtils;->getOSMatchesName(Ljava/lang/String;)Z

    move-result v0

    sput-boolean v0, Lorg/apache/commons/lang3/SystemUtils;->IS_OS_OS2:Z

    .line 1236
    const-string v0, "Solaris"

    invoke-static {v0}, Lorg/apache/commons/lang3/SystemUtils;->getOSMatchesName(Ljava/lang/String;)Z

    move-result v0

    sput-boolean v0, Lorg/apache/commons/lang3/SystemUtils;->IS_OS_SOLARIS:Z

    .line 1248
    const-string v0, "SunOS"

    invoke-static {v0}, Lorg/apache/commons/lang3/SystemUtils;->getOSMatchesName(Ljava/lang/String;)Z

    move-result v0

    sput-boolean v0, Lorg/apache/commons/lang3/SystemUtils;->IS_OS_SUN_OS:Z

    .line 1260
    sget-boolean v0, Lorg/apache/commons/lang3/SystemUtils;->IS_OS_AIX:Z

    if-nez v0, :cond_1

    sget-boolean v0, Lorg/apache/commons/lang3/SystemUtils;->IS_OS_HP_UX:Z

    if-nez v0, :cond_1

    sget-boolean v0, Lorg/apache/commons/lang3/SystemUtils;->IS_OS_IRIX:Z

    if-nez v0, :cond_1

    sget-boolean v0, Lorg/apache/commons/lang3/SystemUtils;->IS_OS_LINUX:Z

    if-nez v0, :cond_1

    sget-boolean v0, Lorg/apache/commons/lang3/SystemUtils;->IS_OS_MAC_OSX:Z

    if-nez v0, :cond_1

    sget-boolean v0, Lorg/apache/commons/lang3/SystemUtils;->IS_OS_SOLARIS:Z

    if-nez v0, :cond_1

    sget-boolean v0, Lorg/apache/commons/lang3/SystemUtils;->IS_OS_SUN_OS:Z

    if-nez v0, :cond_1

    sget-boolean v0, Lorg/apache/commons/lang3/SystemUtils;->IS_OS_FREE_BSD:Z

    if-nez v0, :cond_1

    sget-boolean v0, Lorg/apache/commons/lang3/SystemUtils;->IS_OS_OPEN_BSD:Z

    if-nez v0, :cond_1

    sget-boolean v0, Lorg/apache/commons/lang3/SystemUtils;->IS_OS_NET_BSD:Z

    if-eqz v0, :cond_2

    :cond_1
    move v1, v2

    :cond_2
    sput-boolean v1, Lorg/apache/commons/lang3/SystemUtils;->IS_OS_UNIX:Z

    .line 1273
    const-string v0, "Windows"

    invoke-static {v0}, Lorg/apache/commons/lang3/SystemUtils;->getOSMatchesName(Ljava/lang/String;)Z

    move-result v0

    sput-boolean v0, Lorg/apache/commons/lang3/SystemUtils;->IS_OS_WINDOWS:Z

    .line 1285
    const-string v0, "Windows 2000"

    invoke-static {v0}, Lorg/apache/commons/lang3/SystemUtils;->getOSMatchesName(Ljava/lang/String;)Z

    move-result v0

    sput-boolean v0, Lorg/apache/commons/lang3/SystemUtils;->IS_OS_WINDOWS_2000:Z

    .line 1297
    const-string v0, "Windows 2003"

    invoke-static {v0}, Lorg/apache/commons/lang3/SystemUtils;->getOSMatchesName(Ljava/lang/String;)Z

    move-result v0

    sput-boolean v0, Lorg/apache/commons/lang3/SystemUtils;->IS_OS_WINDOWS_2003:Z

    .line 1309
    const-string v0, "Windows Server 2008"

    invoke-static {v0}, Lorg/apache/commons/lang3/SystemUtils;->getOSMatchesName(Ljava/lang/String;)Z

    move-result v0

    sput-boolean v0, Lorg/apache/commons/lang3/SystemUtils;->IS_OS_WINDOWS_2008:Z

    .line 1321
    const-string v0, "Windows Server 2012"

    invoke-static {v0}, Lorg/apache/commons/lang3/SystemUtils;->getOSMatchesName(Ljava/lang/String;)Z

    move-result v0

    sput-boolean v0, Lorg/apache/commons/lang3/SystemUtils;->IS_OS_WINDOWS_2012:Z

    .line 1333
    const-string v0, "Windows 95"

    invoke-static {v0}, Lorg/apache/commons/lang3/SystemUtils;->getOSMatchesName(Ljava/lang/String;)Z

    move-result v0

    sput-boolean v0, Lorg/apache/commons/lang3/SystemUtils;->IS_OS_WINDOWS_95:Z

    .line 1345
    const-string v0, "Windows 98"

    invoke-static {v0}, Lorg/apache/commons/lang3/SystemUtils;->getOSMatchesName(Ljava/lang/String;)Z

    move-result v0

    sput-boolean v0, Lorg/apache/commons/lang3/SystemUtils;->IS_OS_WINDOWS_98:Z

    .line 1357
    const-string v0, "Windows Me"

    invoke-static {v0}, Lorg/apache/commons/lang3/SystemUtils;->getOSMatchesName(Ljava/lang/String;)Z

    move-result v0

    sput-boolean v0, Lorg/apache/commons/lang3/SystemUtils;->IS_OS_WINDOWS_ME:Z

    .line 1369
    const-string v0, "Windows NT"

    invoke-static {v0}, Lorg/apache/commons/lang3/SystemUtils;->getOSMatchesName(Ljava/lang/String;)Z

    move-result v0

    sput-boolean v0, Lorg/apache/commons/lang3/SystemUtils;->IS_OS_WINDOWS_NT:Z

    .line 1381
    const-string v0, "Windows XP"

    invoke-static {v0}, Lorg/apache/commons/lang3/SystemUtils;->getOSMatchesName(Ljava/lang/String;)Z

    move-result v0

    sput-boolean v0, Lorg/apache/commons/lang3/SystemUtils;->IS_OS_WINDOWS_XP:Z

    .line 1394
    const-string v0, "Windows Vista"

    invoke-static {v0}, Lorg/apache/commons/lang3/SystemUtils;->getOSMatchesName(Ljava/lang/String;)Z

    move-result v0

    sput-boolean v0, Lorg/apache/commons/lang3/SystemUtils;->IS_OS_WINDOWS_VISTA:Z

    .line 1406
    const-string v0, "Windows 7"

    invoke-static {v0}, Lorg/apache/commons/lang3/SystemUtils;->getOSMatchesName(Ljava/lang/String;)Z

    move-result v0

    sput-boolean v0, Lorg/apache/commons/lang3/SystemUtils;->IS_OS_WINDOWS_7:Z

    .line 1418
    const-string v0, "Windows 8"

    invoke-static {v0}, Lorg/apache/commons/lang3/SystemUtils;->getOSMatchesName(Ljava/lang/String;)Z

    move-result v0

    sput-boolean v0, Lorg/apache/commons/lang3/SystemUtils;->IS_OS_WINDOWS_8:Z

    return-void

    .line 759
    :cond_3
    const-string v0, "user.country"

    invoke-static {v0}, Lorg/apache/commons/lang3/SystemUtils;->getSystemProperty(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    goto/16 :goto_0

    :cond_4
    move v0, v1

    .line 1020
    goto/16 :goto_1
.end method

.method private static getJavaVersionMatches(Ljava/lang/String;)Z
    .locals 1
    .param p0, "versionPrefix"    # Ljava/lang/String;

    .prologue
    .line 1459
    sget-object v0, Lorg/apache/commons/lang3/SystemUtils;->JAVA_SPECIFICATION_VERSION:Ljava/lang/String;

    invoke-static {v0, p0}, Lorg/apache/commons/lang3/SystemUtils;->isJavaVersionMatch(Ljava/lang/String;Ljava/lang/String;)Z

    move-result v0

    return v0
.end method

.method private static getOSMatches(Ljava/lang/String;Ljava/lang/String;)Z
    .locals 2
    .param p0, "osNamePrefix"    # Ljava/lang/String;
    .param p1, "osVersionPrefix"    # Ljava/lang/String;

    .prologue
    .line 1470
    sget-object v0, Lorg/apache/commons/lang3/SystemUtils;->OS_NAME:Ljava/lang/String;

    sget-object v1, Lorg/apache/commons/lang3/SystemUtils;->OS_VERSION:Ljava/lang/String;

    invoke-static {v0, v1, p0, p1}, Lorg/apache/commons/lang3/SystemUtils;->isOSMatch(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z

    move-result v0

    return v0
.end method

.method private static getOSMatchesName(Ljava/lang/String;)Z
    .locals 1
    .param p0, "osNamePrefix"    # Ljava/lang/String;

    .prologue
    .line 1480
    sget-object v0, Lorg/apache/commons/lang3/SystemUtils;->OS_NAME:Ljava/lang/String;

    invoke-static {v0, p0}, Lorg/apache/commons/lang3/SystemUtils;->isOSNameMatch(Ljava/lang/String;Ljava/lang/String;)Z

    move-result v0

    return v0
.end method

.method private static getSystemProperty(Ljava/lang/String;)Ljava/lang/String;
    .locals 4
    .param p0, "property"    # Ljava/lang/String;

    .prologue
    .line 1498
    :try_start_0
    invoke-static {p0}, Ljava/lang/System;->getProperty(Ljava/lang/String;)Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/SecurityException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v1

    .line 1503
    :goto_0
    return-object v1

    .line 1499
    :catch_0
    move-exception v0

    .line 1501
    .local v0, "ex":Ljava/lang/SecurityException;
    sget-object v1, Ljava/lang/System;->err:Ljava/io/PrintStream;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Caught a SecurityException reading the system property \'"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "\'; the SystemUtils property value will default to null."

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/io/PrintStream;->println(Ljava/lang/String;)V

    .line 1503
    const/4 v1, 0x0

    goto :goto_0
.end method

.method static isJavaVersionMatch(Ljava/lang/String;Ljava/lang/String;)Z
    .locals 1
    .param p0, "version"    # Ljava/lang/String;
    .param p1, "versionPrefix"    # Ljava/lang/String;

    .prologue
    .line 1581
    if-nez p0, :cond_0

    .line 1582
    const/4 v0, 0x0

    .line 1584
    :goto_0
    return v0

    :cond_0
    invoke-virtual {p0, p1}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v0

    goto :goto_0
.end method

.method static isOSMatch(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z
    .locals 2
    .param p0, "osName"    # Ljava/lang/String;
    .param p1, "osVersion"    # Ljava/lang/String;
    .param p2, "osNamePrefix"    # Ljava/lang/String;
    .param p3, "osVersionPrefix"    # Ljava/lang/String;

    .prologue
    const/4 v0, 0x0

    .line 1600
    if-eqz p0, :cond_0

    if-nez p1, :cond_1

    .line 1603
    :cond_0
    :goto_0
    return v0

    :cond_1
    invoke-static {p0, p2}, Lorg/apache/commons/lang3/SystemUtils;->isOSNameMatch(Ljava/lang/String;Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_0

    invoke-static {p1, p3}, Lorg/apache/commons/lang3/SystemUtils;->isOSVersionMatch(Ljava/lang/String;Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_0

    const/4 v0, 0x1

    goto :goto_0
.end method

.method static isOSNameMatch(Ljava/lang/String;Ljava/lang/String;)Z
    .locals 1
    .param p0, "osName"    # Ljava/lang/String;
    .param p1, "osNamePrefix"    # Ljava/lang/String;

    .prologue
    .line 1617
    if-nez p0, :cond_0

    .line 1618
    const/4 v0, 0x0

    .line 1620
    :goto_0
    return v0

    :cond_0
    invoke-virtual {p0, p1}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v0

    goto :goto_0
.end method

.method static isOSVersionMatch(Ljava/lang/String;Ljava/lang/String;)Z
    .locals 6
    .param p0, "osVersion"    # Ljava/lang/String;
    .param p1, "osVersionPrefix"    # Ljava/lang/String;

    .prologue
    const/4 v3, 0x0

    .line 1634
    invoke-static {p0}, Lorg/apache/commons/lang3/StringUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v4

    if-eqz v4, :cond_1

    .line 1646
    :cond_0
    :goto_0
    return v3

    .line 1639
    :cond_1
    const-string v4, "\\."

    invoke-virtual {p1, v4}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v2

    .line 1640
    .local v2, "versionPrefixParts":[Ljava/lang/String;
    const-string v4, "\\."

    invoke-virtual {p0, v4}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v1

    .line 1641
    .local v1, "versionParts":[Ljava/lang/String;
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_1
    array-length v4, v2

    array-length v5, v1

    invoke-static {v4, v5}, Ljava/lang/Math;->min(II)I

    move-result v4

    if-ge v0, v4, :cond_2

    .line 1642
    aget-object v4, v2, v0

    aget-object v5, v1, v0

    invoke-virtual {v4, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_0

    .line 1641
    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    .line 1646
    :cond_2
    const/4 v3, 0x1

    goto :goto_0
.end method
