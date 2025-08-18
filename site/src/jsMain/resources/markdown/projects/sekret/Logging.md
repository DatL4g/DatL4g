---
layout: .components.layouts.MarkdownLayout
title: Sekret - Logging
---

# Sekret - Secure Logging

**Repository:** https://github.com/DatL4g/Sekret

> [!TIP]
> Keep sensitive values out of logs without breaking your developer experience.

## Why this exists

Logs are gold for debugging—and a liability for privacy. Too often, tokens, passwords, or personal data slip into log statements via `toString()`, string interpolation, or careless debug prints. Sekret’s **Secure Logging** part exists to make the safe thing the easy thing: it lets you mark fields as secret and automatically redacts them anywhere they could leak through logs.

## What you get

- Annotation-based redaction – mark data as secret and Sekret's Compiler/Gradle plugin takes care of masking it at log time.
- Works with normal Kotlin – you keep using data classes, string templates, and your favorite logging framework.
- Multiplatform by design – one approach for Android, iOS, JVM, and more.
- Minimal runtime overhead – the heavy lifting happens at build/compile time.

## How it works (high-level)

Sekret introduces an annotation to mark values as sensitive. During compilation, it instruments common leak paths (like `toString()` and string interpolation) so that, when logs happen, redacted placeholders (e.g., `••••••`) are emitted instead of raw values. You don’t have to change your logging API - Sekret focuses on the data.

```kotlin
data class Credentials(
    @Secret val username: String,
    @Secret val password: String
)

val creds = Credentials("demo@example.com", "SuperSecret123")
// Even if you accidentally log it:
println("Trying login with $creds")
// -> Trying login with Credentials(username=••••••, password=••••••)
```

> [!CAUTION]
> The goal is to reduce accidental leaks. It does not decrypt production errors or magically hide secrets from a determined attacker with device access - no client-side solution can. The point is safer defaults and fewer foot-guns.

## Quick start

**Step 1:** Apply the plugin from Maven Central

In your `build.gradle.kts` add:

```gradle
plugins {
    id("dev.datlag.sekret") version "2.2.0"
}
```

**Step 2:** Annotate sensitive values and keep logging like usual.

## When to use it

- You handle API keys, session tokens, auth headers, or PII in memory.
- You want strong guarantees that “oops, I logged it” won’t end up in your files, Crashlytics, or consoles.
- You’re working across platforms and want one redaction story for KMP.

## Limitations & expectations

- Redaction happens where Sekret can intercept - Don’t bypass it by manually crafting strings from raw byte arrays, etc.
- Logging safety is not the same as storage safety. Use the Application Secrets part of Sekret (see the companion page) for embedding secrets more safely in your binaries.

## Related functionality

If you are more interested in keeping application secrets safe, see the companion page about [**Application Secrets**](Secrets.md)