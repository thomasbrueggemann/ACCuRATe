.class public Lorg/droidparts/adapter/widget/TextWatcherAdapter;
.super Ljava/lang/Object;
.source "TextWatcherAdapter.java"

# interfaces
.implements Landroid/text/TextWatcher;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lorg/droidparts/adapter/widget/TextWatcherAdapter$TextWatcherListener;
    }
.end annotation


# instance fields
.field private final listener:Lorg/droidparts/adapter/widget/TextWatcherAdapter$TextWatcherListener;

.field private final view:Landroid/widget/EditText;


# direct methods
.method public constructor <init>(Landroid/widget/EditText;Lorg/droidparts/adapter/widget/TextWatcherAdapter$TextWatcherListener;)V
    .locals 0
    .param p1, "editText"    # Landroid/widget/EditText;
    .param p2, "listener"    # Lorg/droidparts/adapter/widget/TextWatcherAdapter$TextWatcherListener;

    .prologue
    .line 33
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 34
    iput-object p1, p0, Lorg/droidparts/adapter/widget/TextWatcherAdapter;->view:Landroid/widget/EditText;

    .line 35
    iput-object p2, p0, Lorg/droidparts/adapter/widget/TextWatcherAdapter;->listener:Lorg/droidparts/adapter/widget/TextWatcherAdapter$TextWatcherListener;

    .line 36
    return-void
.end method


# virtual methods
.method public afterTextChanged(Landroid/text/Editable;)V
    .locals 0
    .param p1, "s"    # Landroid/text/Editable;

    .prologue
    .line 52
    return-void
.end method

.method public beforeTextChanged(Ljava/lang/CharSequence;III)V
    .locals 0
    .param p1, "s"    # Ljava/lang/CharSequence;
    .param p2, "start"    # I
    .param p3, "count"    # I
    .param p4, "after"    # I

    .prologue
    .line 47
    return-void
.end method

.method public onTextChanged(Ljava/lang/CharSequence;III)V
    .locals 3
    .param p1, "s"    # Ljava/lang/CharSequence;
    .param p2, "start"    # I
    .param p3, "before"    # I
    .param p4, "count"    # I

    .prologue
    .line 40
    iget-object v0, p0, Lorg/droidparts/adapter/widget/TextWatcherAdapter;->listener:Lorg/droidparts/adapter/widget/TextWatcherAdapter$TextWatcherListener;

    iget-object v1, p0, Lorg/droidparts/adapter/widget/TextWatcherAdapter;->view:Landroid/widget/EditText;

    invoke-interface {p1}, Ljava/lang/CharSequence;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Lorg/droidparts/adapter/widget/TextWatcherAdapter$TextWatcherListener;->onTextChanged(Landroid/widget/EditText;Ljava/lang/String;)V

    .line 41
    return-void
.end method
