.class public Lcz/msebera/android/httpclient/message/BasicHeaderElement;
.super Ljava/lang/Object;
.source "BasicHeaderElement.java"

# interfaces
.implements Lcz/msebera/android/httpclient/HeaderElement;
.implements Ljava/lang/Cloneable;


# instance fields
.field private final name:Ljava/lang/String;

.field private final parameters:[Lcz/msebera/android/httpclient/NameValuePair;

.field private final value:Ljava/lang/String;


# direct methods
.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;)V
    .locals 1
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "value"    # Ljava/lang/String;

    .prologue
    .line 77
    const/4 v0, 0x0

    invoke-direct {p0, p1, p2, v0}, Lcz/msebera/android/httpclient/message/BasicHeaderElement;-><init>(Ljava/lang/String;Ljava/lang/String;[Lcz/msebera/android/httpclient/NameValuePair;)V

    .line 78
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;[Lcz/msebera/android/httpclient/NameValuePair;)V
    .locals 1
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "value"    # Ljava/lang/String;
    .param p3, "parameters"    # [Lcz/msebera/android/httpclient/NameValuePair;

    .prologue
    .line 60
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 61
    const-string v0, "Name"

    invoke-static {p1, v0}, Lcz/msebera/android/httpclient/util/Args;->notNull(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    iput-object v0, p0, Lcz/msebera/android/httpclient/message/BasicHeaderElement;->name:Ljava/lang/String;

    .line 62
    iput-object p2, p0, Lcz/msebera/android/httpclient/message/BasicHeaderElement;->value:Ljava/lang/String;

    .line 63
    if-eqz p3, :cond_0

    .line 64
    iput-object p3, p0, Lcz/msebera/android/httpclient/message/BasicHeaderElement;->parameters:[Lcz/msebera/android/httpclient/NameValuePair;

    .line 68
    :goto_0
    return-void

    .line 66
    :cond_0
    const/4 v0, 0x0

    new-array v0, v0, [Lcz/msebera/android/httpclient/NameValuePair;

    iput-object v0, p0, Lcz/msebera/android/httpclient/message/BasicHeaderElement;->parameters:[Lcz/msebera/android/httpclient/NameValuePair;

    goto :goto_0
.end method


# virtual methods
.method public clone()Ljava/lang/Object;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/CloneNotSupportedException;
        }
    .end annotation

    .prologue
    .line 158
    invoke-super {p0}, Ljava/lang/Object;->clone()Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public equals(Ljava/lang/Object;)Z
    .locals 5
    .param p1, "object"    # Ljava/lang/Object;

    .prologue
    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 115
    if-ne p0, p1, :cond_1

    .line 124
    :cond_0
    :goto_0
    return v1

    .line 118
    :cond_1
    instance-of v3, p1, Lcz/msebera/android/httpclient/HeaderElement;

    if-eqz v3, :cond_3

    move-object v0, p1

    .line 119
    check-cast v0, Lcz/msebera/android/httpclient/message/BasicHeaderElement;

    .line 120
    .local v0, "that":Lcz/msebera/android/httpclient/message/BasicHeaderElement;
    iget-object v3, p0, Lcz/msebera/android/httpclient/message/BasicHeaderElement;->name:Ljava/lang/String;

    iget-object v4, v0, Lcz/msebera/android/httpclient/message/BasicHeaderElement;->name:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_2

    iget-object v3, p0, Lcz/msebera/android/httpclient/message/BasicHeaderElement;->value:Ljava/lang/String;

    iget-object v4, v0, Lcz/msebera/android/httpclient/message/BasicHeaderElement;->value:Ljava/lang/String;

    .line 121
    invoke-static {v3, v4}, Lcz/msebera/android/httpclient/util/LangUtils;->equals(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_2

    iget-object v3, p0, Lcz/msebera/android/httpclient/message/BasicHeaderElement;->parameters:[Lcz/msebera/android/httpclient/NameValuePair;

    iget-object v4, v0, Lcz/msebera/android/httpclient/message/BasicHeaderElement;->parameters:[Lcz/msebera/android/httpclient/NameValuePair;

    .line 122
    invoke-static {v3, v4}, Lcz/msebera/android/httpclient/util/LangUtils;->equals([Ljava/lang/Object;[Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_0

    :cond_2
    move v1, v2

    goto :goto_0

    .end local v0    # "that":Lcz/msebera/android/httpclient/message/BasicHeaderElement;
    :cond_3
    move v1, v2

    .line 124
    goto :goto_0
.end method

.method public getName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 81
    iget-object v0, p0, Lcz/msebera/android/httpclient/message/BasicHeaderElement;->name:Ljava/lang/String;

    return-object v0
.end method

.method public getParameter(I)Lcz/msebera/android/httpclient/NameValuePair;
    .locals 1
    .param p1, "index"    # I

    .prologue
    .line 98
    iget-object v0, p0, Lcz/msebera/android/httpclient/message/BasicHeaderElement;->parameters:[Lcz/msebera/android/httpclient/NameValuePair;

    aget-object v0, v0, p1

    return-object v0
.end method

.method public getParameterByName(Ljava/lang/String;)Lcz/msebera/android/httpclient/NameValuePair;
    .locals 6
    .param p1, "name"    # Ljava/lang/String;

    .prologue
    .line 102
    const-string v2, "Name"

    invoke-static {p1, v2}, Lcz/msebera/android/httpclient/util/Args;->notNull(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;

    .line 103
    const/4 v1, 0x0

    .line 104
    .local v1, "found":Lcz/msebera/android/httpclient/NameValuePair;
    iget-object v3, p0, Lcz/msebera/android/httpclient/message/BasicHeaderElement;->parameters:[Lcz/msebera/android/httpclient/NameValuePair;

    array-length v4, v3

    const/4 v2, 0x0

    :goto_0
    if-ge v2, v4, :cond_0

    aget-object v0, v3, v2

    .line 105
    .local v0, "current":Lcz/msebera/android/httpclient/NameValuePair;
    invoke-interface {v0}, Lcz/msebera/android/httpclient/NameValuePair;->getName()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v5, p1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_1

    .line 106
    move-object v1, v0

    .line 110
    .end local v0    # "current":Lcz/msebera/android/httpclient/NameValuePair;
    :cond_0
    return-object v1

    .line 104
    .restart local v0    # "current":Lcz/msebera/android/httpclient/NameValuePair;
    :cond_1
    add-int/lit8 v2, v2, 0x1

    goto :goto_0
.end method

.method public getParameterCount()I
    .locals 1

    .prologue
    .line 93
    iget-object v0, p0, Lcz/msebera/android/httpclient/message/BasicHeaderElement;->parameters:[Lcz/msebera/android/httpclient/NameValuePair;

    array-length v0, v0

    return v0
.end method

.method public getParameters()[Lcz/msebera/android/httpclient/NameValuePair;
    .locals 1

    .prologue
    .line 89
    iget-object v0, p0, Lcz/msebera/android/httpclient/message/BasicHeaderElement;->parameters:[Lcz/msebera/android/httpclient/NameValuePair;

    invoke-virtual {v0}, [Lcz/msebera/android/httpclient/NameValuePair;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcz/msebera/android/httpclient/NameValuePair;

    return-object v0
.end method

.method public getValue()Ljava/lang/String;
    .locals 1

    .prologue
    .line 85
    iget-object v0, p0, Lcz/msebera/android/httpclient/message/BasicHeaderElement;->value:Ljava/lang/String;

    return-object v0
.end method

.method public hashCode()I
    .locals 5

    .prologue
    .line 130
    const/16 v0, 0x11

    .line 131
    .local v0, "hash":I
    iget-object v2, p0, Lcz/msebera/android/httpclient/message/BasicHeaderElement;->name:Ljava/lang/String;

    invoke-static {v0, v2}, Lcz/msebera/android/httpclient/util/LangUtils;->hashCode(ILjava/lang/Object;)I

    move-result v0

    .line 132
    iget-object v2, p0, Lcz/msebera/android/httpclient/message/BasicHeaderElement;->value:Ljava/lang/String;

    invoke-static {v0, v2}, Lcz/msebera/android/httpclient/util/LangUtils;->hashCode(ILjava/lang/Object;)I

    move-result v0

    .line 133
    iget-object v3, p0, Lcz/msebera/android/httpclient/message/BasicHeaderElement;->parameters:[Lcz/msebera/android/httpclient/NameValuePair;

    array-length v4, v3

    const/4 v2, 0x0

    :goto_0
    if-ge v2, v4, :cond_0

    aget-object v1, v3, v2

    .line 134
    .local v1, "parameter":Lcz/msebera/android/httpclient/NameValuePair;
    invoke-static {v0, v1}, Lcz/msebera/android/httpclient/util/LangUtils;->hashCode(ILjava/lang/Object;)I

    move-result v0

    .line 133
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 136
    .end local v1    # "parameter":Lcz/msebera/android/httpclient/NameValuePair;
    :cond_0
    return v0
.end method

.method public toString()Ljava/lang/String;
    .locals 6

    .prologue
    .line 141
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    .line 142
    .local v0, "buffer":Ljava/lang/StringBuilder;
    iget-object v2, p0, Lcz/msebera/android/httpclient/message/BasicHeaderElement;->name:Ljava/lang/String;

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 143
    iget-object v2, p0, Lcz/msebera/android/httpclient/message/BasicHeaderElement;->value:Ljava/lang/String;

    if-eqz v2, :cond_0

    .line 144
    const-string v2, "="

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 145
    iget-object v2, p0, Lcz/msebera/android/httpclient/message/BasicHeaderElement;->value:Ljava/lang/String;

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 147
    :cond_0
    iget-object v3, p0, Lcz/msebera/android/httpclient/message/BasicHeaderElement;->parameters:[Lcz/msebera/android/httpclient/NameValuePair;

    array-length v4, v3

    const/4 v2, 0x0

    :goto_0
    if-ge v2, v4, :cond_1

    aget-object v1, v3, v2

    .line 148
    .local v1, "parameter":Lcz/msebera/android/httpclient/NameValuePair;
    const-string v5, "; "

    invoke-virtual {v0, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 149
    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    .line 147
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 151
    .end local v1    # "parameter":Lcz/msebera/android/httpclient/NameValuePair;
    :cond_1
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    return-object v2
.end method
