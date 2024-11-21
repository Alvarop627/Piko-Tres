plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
}

android {
    namespace = "com.pikotres.app"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.pikotres.app"
        minSdk = 21
        targetSdk = 35
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }

    composeOptions{
        kotlinCompilerExtensionVersion = "1.5.14"
    }
}

dependencies {
    // AndroidX
    implementation(libs.androidx.core.ktx)  // Extensiones para AndroidX
    implementation(libs.androidx.lifecycle.runtime.ktx)  // Dependencia de ciclo de vida de Android
    // Compose dependencies
    implementation(libs.androidx.core.ktx.v1131)
    implementation(libs.androidx.activity.compose.v190)
    implementation(libs.ui)
    implementation(libs.ui.graphics)
    implementation(libs.ui.tooling.preview)
    implementation (libs.androidx.material3)
    debugImplementation(libs.ui.tooling)
    implementation(libs.androidx.runtime.livedata)
    implementation (libs.androidx.lifecycle.runtime.ktx.v241)
    implementation (libs.androidx.compose.ui.ui.tooling)

    //Coroutines
    implementation (libs.kotlinx.coroutines.core)
    implementation (libs.kotlinx.coroutines.android)

    //Compose
    implementation (libs.androidx.lifecycle.runtime.compose.android)
    implementation (libs.androidx.navigation.compose)

    // ViewModel y LiveData
    implementation(libs.androidx.lifecycle.viewmodel.ktx.v261) // Reemplaza con la versión más reciente si es necesario
    implementation(libs.androidx.lifecycle.livedata.ktx)

    // Testing
    testImplementation(libs.junit)  // JUnit para pruebas unitarias
    androidTestImplementation(libs.androidx.junit)  // JUnit para pruebas Android
    androidTestImplementation(libs.androidx.espresso.core)  // Espresso para pruebas de UI
    androidTestImplementation(platform(libs.androidx.compose.bom))  // BOM de Compose para pruebas
    androidTestImplementation(libs.androidx.ui.test.junit4)  // JUnit 4 para pruebas en Compose

    // Debugging
    debugImplementation(libs.androidx.ui.tooling)  // Herramientas de depuración para Compose
    debugImplementation(libs.androidx.ui.test.manifest)  // Manifesto de pruebas para Compose

    // Retrofit (para llamadas HTTP)
    implementation(libs.retrofit)  // Retrofit para la gestión de APIs REST
    implementation(libs.converter.gson)  // Convertidor Gson para Retrofit

    // Interceptor de Logging para Retrofit (opcional)
    implementation(libs.logging.interceptor)  // Interceptor de OkHttp para log de requests/responses
}

