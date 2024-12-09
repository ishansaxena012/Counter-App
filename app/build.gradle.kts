plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "ishan.tutorial.qrcodescanner"
    compileSdk = 34

    defaultConfig {
        applicationId = "ishan.tutorial.qrcodescanner"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables.useSupportLibrary = true
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
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
        kotlinCompilerExtensionVersion = "1.5.1" // Should be compatible with Kotlin 1.9.0
    }

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    val navVersion = "2.7.4"
    val roomVersion = "2.6.0-beta01"
    val composeVersion = "1.5.3"
    val gsonVersion = "2.8.9"

    // Jetpack Compose dependencies (using BOM)
    implementation(platform("androidx.compose:compose-bom:2023.10.00")) // Use the latest BOM version
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.material3:material3")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.activity:activity-compose:1.9.2")


    implementation(platform("androidx.compose:compose-bom:2023.08.00"))
    implementation("androidx.compose.ui:ui:$composeVersion")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")

    // Navigation Component for Compose
    implementation("androidx.navigation:navigation-compose:$navVersion")

    // Lifecycle and ViewModel
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.6.1")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.1")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.1")

    // Activity Compose
    implementation("androidx.activity:activity-compose:1.7.2")


    // Core and Lifecycle Libraries
    implementation("androidx.core:core-ktx:1.15.0") // Latest stable version
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.8.7") // Latest stable version
    implementation("androidx.appcompat:appcompat:1.7.0") // Latest stable version
    implementation("androidx.activity:activity-ktx:1.9.3") // For Activity Result APIs

    // ZXing for QR scanning
    implementation("com.journeyapps:zxing-android-embedded:4.3.0")

    // Google Sheets API and Authentication Libraries
    implementation("com.google.api-client:google-api-client-android:1.32.1")
    implementation("com.google.api-client:google-api-client-gson:1.32.1")
    implementation("com.google.apis:google-api-services-sheets:v4-rev20230509-1.32.1")

    // Jackson dependencies for JSON parsing
    implementation("com.fasterxml.jackson.core:jackson-core:2.15.0")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.15.0")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.15.0")

    // Testing Dependencies
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.2.1")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.6.1")
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")

    // Debugging Dependencies
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")

    // ML Kit Barcode Scanning
    implementation("com.google.mlkit:barcode-scanning:18.1.0")

    // CameraX dependencies
    implementation("androidx.camera:camera-core:1.4.0")
    implementation("androidx.camera:camera-camera2:1.4.0")
    implementation("androidx.camera:camera-lifecycle:1.4.0")
    implementation("androidx.camera:camera-view:1.4.0")
    implementation("androidx.camera:camera-extensions:1.4.0")

    // Apache POI for Excel file handling
    implementation("org.apache.poi:poi:5.2.2")
    implementation("org.apache.poi:poi-ooxml:5.2.2")
}
