plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.wearfinancemanager_finalproject_sec2"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.wearfinancemanager_finalproject_sec2"
        minSdk = 33
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

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

dependencies {
    dependencies {
        implementation ("org.jetbrains.kotlin:kotlin-stdlib:1.8.22") // Consolidated Kotlin version
        implementation("com.google.android.gms:play-services-wearable:18.0.0")
        implementation("androidx.appcompat:appcompat:1.4.1")
        implementation("com.google.android.material:material:1.5.0")
        implementation("androidx.activity:activity-ktx:1.4.0")
        implementation("androidx.constraintlayout:constraintlayout:2.1.3")
        implementation("androidx.recyclerview:recyclerview:1.2.1")
        implementation("com.squareup.retrofit2:retrofit:2.9.0")
        implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    }

}
