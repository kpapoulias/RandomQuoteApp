# Clean Architecture Random Quote App

A simple, modern Android application built from scratch to demonstrate a robust implementation of Clean Architecture. This project fetches a random quote from an online API and displays it using Jetpack Compose. It is designed to be a solid template for building scalable and maintainable Android apps.

---

## Tech Stack & Key Features

This project showcases a collection of modern libraries and best practices for Android development:

* **[Kotlin](https://kotlinlang.org/)**: The official language for Android development.
* **[Jetpack Compose](https://developer.android.com/jetpack/compose)**: Android's modern, declarative UI toolkit for building native user interfaces.
* **[Clean Architecture](https://blog.cleancoder.com/uncle-bob/2012/08/13/the-clean-architecture.html)**: A layered architecture that separates the application into independent, testable, and maintainable layers (Data, Domain, Presentation).
* **[Hilt](https://developer.android.com/training/dependency-injection/hilt-android)**: A dependency injection library for Android that reduces the boilerplate of doing manual dependency injection.
* **[Retrofit](https://square.github.io/retrofit/)**: A type-safe HTTP client for making network requests.
* **[Kotlinx Serialization](https://github.com/Kotlin/kotlinx.serialization)**: A modern library for converting Kotlin objects to and from JSON.
* **[Coroutines & Flows](https://developer.android.com/kotlin/coroutines)**: For managing asynchronous operations and handling streams of data in a structured way.
* **[ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel)**: To store and manage UI-related data in a lifecycle-conscious way.
* **[StateFlow](https://developer.android.com/kotlin/flow/stateflow-and-sharedflow)**: To expose UI state from the ViewModel to the Composable UI, ensuring a reactive and unidirectional data flow.
* **[Gradle Version Catalog (libs.versions.toml)](https://docs.gradle.org/current/userguide/platforms.html)**: For centralized and type-safe management of project dependencies.

---

## Architecture

The project follows the principles of Clean Architecture, resulting in the following package structure:

```
com.example.randomquoteapp
│
├── data                # Data Layer
│   ├── di              # Hilt modules for the data layer
│   ├── mapper          # Mapping functions (e.g., DTO to Domain model)
│   ├── remote          # Networking components
│   │   ├── api         # Retrofit API interface
│   │   └── dto         # Data Transfer Objects (models matching JSON response)
│   └── repository      # Implementation of the repository interface
│
├── domain              # Domain Layer
│   ├── di              # Hilt modules for the domain layer
│   ├── model           # Core business models (e.g., Quote)
│   ├── repository      # Repository interfaces (contracts for the data layer)
│   └── usecase         # Business logic interactors
│
└── presentation        # Presentation Layer
    ├── quote           # UI-related components for the quote feature
    │   ├── QuoteScreen.kt
    │   ├── QuoteState.kt
    │   └── QuoteViewModel.kt
    └── MainActivity.kt
```

* **`presentation`**: Contains the UI (Jetpack Compose) and state holders (ViewModels). It depends only on the `domain` layer.
* **`domain`**: The core of the application. Contains business logic (Use Cases) and model classes. It is completely independent and has no knowledge of the other layers.
* **`data`**: Responsible for providing data to the `domain` layer. It contains the implementation of the repository, network API calls (Retrofit), and data mapping logic.

---

## API Used

This application uses the [**DummyJSON**](https://dummyjson.com/docs/quotes) public API to fetch random quotes.

---

## How To Use

To build and run this project, follow these steps:

1.  **Clone the repository:**
    ```bash
    git clone https://github.com/kpapoulias/RandomQuoteApp.git
    ```

2.  **Open in Android Studio:**
    Open the project in the latest stable version of Android Studio.

3.  **Sync and Run:**
    Let Gradle sync the dependencies, then build and run the app on an emulator or a physical device.

---

## License

This project is licensed under the MIT License - see the `LICENSE` file for details.
