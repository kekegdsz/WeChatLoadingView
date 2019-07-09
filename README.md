# LoadingView
> 一个简单的高仿微信进入小程序的loading，三个点循环

[![](https://jitpack.io/v/kekegdsz/WeChatLoadingView.svg)](https://jitpack.io/#kekegdsz/WeChatLoadingView)｛:width = "300" height = "600"｝

* 2019年7月9日 22:59:45
> 1.0.0版本，loading


LoadingView|
---------- |
![LoadingView](https://github.com/kekegdsz/WeChatLoadingView/blob/master/git/loading.gif?raw=true)

## Gradle:
Add it in your root build.gradle at the end of repositories:
```gradle
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```
Add the dependency
```gradle
	dependencies {
	        implementation 'com.github.kekegdsz:WeChatLoadingView:1.0.0'
	}
```
## Use LoadingView
```xml
    <com.kekegdsz.view.LoadingView
        android:layout_width="wrap_content"
        android:id="@+id/loading_view"
        android:layout_height="wrap_content"
        android:layout_centerInParent="true" />
```
