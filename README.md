# ☕ java_tools

A reusable Java library that can be integrated into your project using either:

* **Gradle Git Source Dependency**
* **Direct Git Clone**

---

# 🚀 Gradle Git Source Dependency

## Groovy DSL

### Step 1 — Configure the Git Repository

Add the following to your `settings.gradle`:

```groovy
sourceControl {
    gitRepository("https://github.com/alims-engineering/java_tools.git") {
        producesModule("com.alims:java_tools")
    }
}
```

### Step 2 — Add the Dependency

Add the following to your `build.gradle`:

```groovy
dependencies {
    implementation "com.alims:java_tools:1.0.0"
}
```

---

## Kotlin DSL

### Step 1 — Configure the Git Repository

Add the following to your `settings.gradle.kts`:

```kotlin
sourceControl {
    gitRepository("https://github.com/alims-engineering/java_tools.git") {
        producesModule("com.alims:java_tools")
    }
}
```

### Step 2 — Add the Dependency

Add the following to your `build.gradle.kts`:

```kotlin
dependencies {
    implementation("com.alims:java_tools:1.0.0")
}
```

---

# 📥 Git Clone

You can also clone `java_tools` directly into your local development environment.

## 🐧 Linux

Clone the repository:

```bash
git clone https://github.com/alims-engineering/java_tools.git "/Alims/engineering/java_tools"
```

Then include the project in your build configuration.

---

## 🪟 Windows

Clone the repository:

```bash
git clone https://github.com/alims-engineering/java_tools.git "C:/Alims/engineering/java_tools"
```

Then include the project in your build configuration.

---

# 📦 Dependency Information

| Property | Value        |
| -------- | ------------ |
| Group    | `com.alims`  |
| Artifact | `java_tools` |
| Version  | `1.0.0`      |

---

