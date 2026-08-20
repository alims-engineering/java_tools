# java_tools

A Java library that can be used directly as a Gradle Git source dependency.

## How to use

### Gradle Groovy DSL

In your `settings.gradle`, add:

```groovy
sourceControl {
    gitRepository("https://github.com/alims-engineering/java_tools.git") {
        producesModule("com.alims:java_tools")
    }
}
```

Then, in your `build.gradle`, add:

```groovy
dependencies {
    implementation "com.alims:java_tools"
}
```

### Gradle Kotlin DSL

If your `settings.gradle.kts`, add:

```kotlin
sourceControl {
    gitRepository("https://github.com/alims-engineering/java_tools.git") {
        producesModule("com.alims:java_tools")
    }
}
```

Then, in your `build.gradle.kts`, add:

```kotlin
dependencies {
    implementation("com.alims:java_tools")
}
```


com.alims:java_tools:1.0.0
```
