plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)

    //ROOM DATABASE
    id("kotlin-kapt")
    id("com.google.devtools.ksp") version "1.6.21-1.0.5"
}

android {
    namespace = "com.maraloedev.examen_eduardo_martin_sonseca_kotlin"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.maraloedev.examen_eduardo_martin_sonseca_kotlin"
        minSdk = 33
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        viewBinding = true
        dataBinding = true
    }
}

dependencies {

    val room_version = "2.6.1"
    implementation("androidx.room:room-runtime:$room_version")
    annotationProcessor("androidx.room:room-compiler:$room_version")
// To use Kotlin annotation processing tool (kapt)
    kapt("androidx.room:room-compiler:$room_version")
// To use Kotlin Symbol Processing (KSP)
    ksp("androidx.room:room-compiler:$room_version")
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.lifecycle.livedata.ktx)
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}