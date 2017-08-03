# Add project specific ProGuard rules here.
# By default, the flags in this file are appended to flags specified
# in C:\Application\ADT\adt-bundle-windows-x86_64-20140702\sdk/tools/proguard/proguard-android.txt
# You can edit the include path and order by changing the proguardFiles
# directive in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# Add any project specific keep options here:

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

#-optimizationpasses 5           # 指定代码的压缩级别
#-dontusemixedcaseclassnames     # 是否使用大小写混合
#-dontpreverify                  # 混淆时是否做预校验
#-verbose                        # 混淆时是否记录日志
#-ignorewarnings                 # 抑制警告

-ignorewarnings

# 避免混淆泛型
-keepattributes Signature

# fastjson
-keepattributes Signature
-dontwarn com.alibaba.fastjson.**
-keep class com.alibaba.fastjson.**{*; }

# T-Mvp
-keep public class * extends com.mntp.ui.base.BasePresenter

#保留一个完整的包 实体类
-keep class com.mntp.entity.bean.** {*;}

#Annotation  注释混淆
-keepattributes Annotation

#Annotation  js混淆
-keepattributes JavascriptInterface

#org.apache.http.entity 混淆
-dontwarn org.apache.http.entity.**
-keep class org.apache.http.entity.** { *; }

# ButterKnife
-keep class butterknife.** { *; }
-dontwarn butterknife.internal.**
-keep class **$$ViewBinder { *; }


# RxJava RxAndroid
-dontwarn sun.misc.**
-keepclassmembers class rx.internal.util.unsafe.*ArrayQueue*Field* {
    long producerIndex;
    long consumerIndex;
}
-keepclassmembers class rx.internal.util.unsafe.BaseLinkedQueueProducerNodeRef {
    rx.internal.util.atomic.LinkedQueueNode producerNode;
}
-keepclassmembers class rx.internal.util.unsafe.BaseLinkedQueueConsumerNodeRef {
    rx.internal.util.atomic.LinkedQueueNode consumerNode;
}

# Retrolambda
-dontwarn java.lang.invoke.*

# 保留枚举类不被混淆
-keepclassmembers enum * {
    public static **[] values();
    public static ** valueOf(java.lang.String);
}
