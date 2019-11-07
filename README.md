# Mobitech Ads
Implements the mobitech ads

# Steps to add Ads

# Setup.
1.Add gradle dependency on build.gradle (app)
'''
  implementation 'com.github.nixswinner:mobitechads:0.2.7'
'''
2.Add on build.gradle project under all allprojects repositories

'''
allprojects {
    repositories {
        ....
       .....
        maven { url 'https://www.jitpack.io' }

    }
}
'''

3.Android manifect make sure your Internet Permission

'''
  <uses-permission android:name="android.permission.INTERNET" />
'''

# Add Banner ads.
1. On your xml layout 
'''
<com.ads.mobitechadslib.MobiAdBanner
        android:id="@+id/bannerAd"
        android:layout_gravity="center"
        android:scaleType="fitXY"
        android:layout_width="320dp"
        android:layout_height="50dp"/>
'''
