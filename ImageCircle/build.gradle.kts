plugins {
    id("com.android.library")
    id("maven-publish")
}

android {
    namespace = "com.androidbulb.circleimage"
    compileSdk = 34

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

//Punlishing AAR By AndroidBULB
publishing {
    publications {
        create<MavenPublication>("bar") {
            groupId = "com.github.androidbulb"
            artifactId = "CircleImageViewLibrary"
            version = "1.0"

            pom {
                description = "This is Circle Image Library Created By Androidbulb"
            }
        }
    }
    repositories {               // << --- ADD This
        mavenLocal()
    }
}

dependencies {

    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}