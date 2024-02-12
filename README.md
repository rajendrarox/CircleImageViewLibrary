# Efficient Canvas CircleImageView


Welcome to the Efficient Canvas CircleImageView Library! This library allows you to easily display Efficient CircleImageView in your Android applications.

## Installation

## Step 1.
>Add the JitPack repository to your build file

```kotlin
dependencyResolutionManagement {
		repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
		repositories {
			mavenCentral()
			maven { url 'https://jitpack.io' } /// For Kt use this only  maven("https://jitpack.io")
		}
	}
```

## Step 2.
>Add the dependency library // Canvas UI

```kotlin
dependencies {
	        implementation 'com.github.androidbulb:CircleImageViewLibrary:1.0'
	}
```

## Step 3.
>Efficient CircleImageView Canvas in your View.xml Example

```kotlin

 <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:gravity="center">
        <com.androidbulb.circleimage.CircleImageView
            android:id="@+id/img_icon"
            android:layout_width="150dp"
            android:layout_height="150dp"
            android:src="@drawable/test" />

    </LinearLayout>

```

## Happy coding with AndroidBulb! 🎉
