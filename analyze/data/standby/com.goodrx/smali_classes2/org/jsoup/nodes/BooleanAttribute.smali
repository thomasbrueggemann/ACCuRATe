.class public Lorg/jsoup/nodes/BooleanAttribute;
.super Lorg/jsoup/nodes/Attribute;
.source "BooleanAttribute.java"


# direct methods
.method public constructor <init>(Ljava/lang/String;)V
    .locals 1
    .param p1, "key"    # Ljava/lang/String;

    .prologue
    .line 12
    const-string v0, ""

    invoke-direct {p0, p1, v0}, Lorg/jsoup/nodes/Attribute;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 13
    return-void
.end method


# virtual methods
.method protected isBooleanAttribute()Z
    .locals 1

    .prologue
    .line 17
    const/4 v0, 0x1

    return v0
.end method
