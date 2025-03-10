plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
}

android {
    namespace = "com.android.mvvm_with_jetpack"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.android.mvvm_with_jetpack"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
    implementation("androidx.compose.material:material-android:1.5.4")


    // lifecycler
    implementation ("androidx.lifecycle:lifecycle-livedata-ktx:2.6.2")
    implementation  ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.2")
    implementation  ("androidx.lifecycle:lifecycle-runtime-ktx:2.3.1")


    // Retrofit
    implementation  ("com.squareup.retrofit2:retrofit:2.9.0")
    implementation  ("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation  ("com.squareup.retrofit2:converter-scalars:2.9.0")
    implementation  ("com.squareup.okhttp3:okhttp:5.0.0-alpha.7")


    implementation ("com.github.bumptech.glide:glide:4.13.2")
//    implementation ("com.github.bumptech.glide:glide:4.14.2")
    annotationProcessor ("com.github.bumptech.glide:compiler:4.13.2")

    implementation ("com.google.accompanist:accompanist-coil:0.14.0") // For image loading
}