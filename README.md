# LoadingView
> 高仿微信进入小程序的loading，三个点循环，可以自定义颜色，数量，时间间隔，大小等

[![](https://jitpack.io/v/kekegdsz/WeChatLoadingView.svg)](https://jitpack.io/#kekegdsz/WeChatLoadingView)

* 2019年7月9日 22:59:45
> 1.0.0版本，loading

* 2019年7月10日11:55:22
> 1.0.1版本，修复由于是Androidx不能导入问题

*2019年7月11日 00:20:19
> 1.0.2版本，增加6种自定义属性用于用户拓展

LoadingView|
---------- |
![LoadingView](https://github.com/kekegdsz/WeChatLoadingView/blob/master/git/loading.gif)

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
## Tag:
[![](https://jitpack.io/v/kekegdsz/WeChatLoadingView.svg)](https://jitpack.io/#kekegdsz/WeChatLoadingView)

Add the dependency
```gradle
dependencies {
        implementation 'com.github.kekegdsz:WeChatLoadingView:Tag'
}
```
## Use LoadingView
```xml
 <com.kekegdsz.view.LoadingView
        android:id="@+id/loading_view"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_centerInParent="true"
        app:loading_view_circleColor="@android:color/holo_blue_bright"
        app:loading_view_circleColorHighlight="@android:color/holo_red_dark"
        app:loading_view_num="8"
        app:loading_view_radius="5dp"
        app:loading_view_spacing="30dp"
        app:loading_view_speed="250" />
```

## LoadingView has the following xml attributes

You can customize the look and behavior of the `LoadingView` in xml. Use the following attributes in xml.

| attribute | description |
| --------------- | --------------------- |
|loading_view_circleColor|Point默认颜色|
|loading_view_circleColorHighlight|Point高亮颜色|
|loading_view_num|Point数量|
|loading_view_radius|Point半径|
|loading_view_spacing|Point间隔大小|
|loading_view_speed|Point移动时间间隔|


License
----------
```text
Copyright 2019 Ke Ke

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```

