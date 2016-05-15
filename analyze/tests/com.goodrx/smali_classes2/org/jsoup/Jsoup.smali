.class public Lorg/jsoup/Jsoup;
.super Ljava/lang/Object;
.source "Jsoup.java"


# direct methods
.method public static parse(Ljava/lang/String;)Lorg/jsoup/nodes/Document;
    .locals 1
    .param p0, "html"    # Ljava/lang/String;

    .prologue
    .line 58
    const-string v0, ""

    invoke-static {p0, v0}, Lorg/jsoup/parser/Parser;->parse(Ljava/lang/String;Ljava/lang/String;)Lorg/jsoup/nodes/Document;

    move-result-object v0

    return-object v0
.end method
