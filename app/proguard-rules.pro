-optimizationpasses 5

-dontusemixedcaseclassnames

-dontskipnonpubliclibraryclasses

-dontpreverify

-verbose

-optimizations !code/simplification/arithmetic,!field/*,!class/merging/*

-ignorewarnings

-dontnote retrofit2.Platform

-dontwarn retrofit2.Platform$Java8

-keepattributes Signature

-keepattributes Exceptions

-keep public class org.jsoup.** {
public *;
   }