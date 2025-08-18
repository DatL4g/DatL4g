---
layout: .components.layouts.MarkdownLayout
title: Tolgee - Compose
---

# Tolgee Kotlin Multiplatform SDK - Compose

A Compose-first layer on top of the Core module that wires translations into Jetpack Compose and Compose Multiplatform UIs with proper recomposition on locale changes and live updates.

## Why a Compose module?

- **Idiomatic Compose integration.** Manage locale as state; trigger recompositions when translations update.
- **OTA-friendly UIs.** Change copy live from Tolgee without shipping new app versions.
- **Multiplatform reach.** Artifacts exist for Android, JVM/Desktop, and WASM/JS Compose targets.

## What the Compose module adds

- **Compose-aware runtime**: Hooks/providers to surface the Core translation layer to Composables.
- **State-driven language changes**: Switching languages re-renders affected UI.
- **Format compatibility**: Works with Tolgee’s Android XML and Compose Multiplatform XML resources.

## Supported platforms

- Android
- JVM
- iOS
- macOS
- Javascript
- WasmJS

## Setup (high level)

- Add the `compose` artifact for your target.
- Provide Tolgee credentials (CDN url) and initialize early in app startup.

## Compose Multiplatform XML resources

- Tolgee supports **Compose Multiplatform XML Resources**, similar to Android XML.
- Useful for migrating Android apps to KMP and keeping translators in familiar structures.

## Performance & UX tips

- **Avoid excessive recomposition.** Call translations at leaf nodes.
- **Cache warmed locales.** Preload user’s locale and fallback.
- **Android specifics.** Use storage saving for better responsiveness. (Can be done for other targets as well)

## Versioning status

- Artifacts are available as `1.0.0-alpha01` (published August 12, 2025). API may change until stable.

## Related functionality

If you are looking for a core module, not targeting compose take a look here: [Core](Core.md)