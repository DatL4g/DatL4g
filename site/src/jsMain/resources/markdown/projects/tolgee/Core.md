---
layout: .components.layouts.MarkdownLayout
title: Tolgee - Core
---

# Tolgee Kotlin Multiplatform SDK - Core

**Repository:** https://github.com/tolgee/tolgee-mobile-kotlin-sdk

A Kotlin Multiplatform core library for pulling translations from Tolgee at runtime and serving them to any UI layer - Android Views, Compose, SwiftUI, desktop, or WASM.

## Why this exists

- **Stop shipping new builds just to change wording.** Fetch translations over-the-air (OTA) from Tolgee at runtime instead of baking strings into each binary.
- **Truly multiplatform.** One SDK that targets Android, iOS, macOS, tvOS, Linux, Windows (MinGW), and even WASM/JS - so you keep a single localization flow across platforms.
- **One source of truth.** Keep translators, developers, and reviewers in sync via Tolgee’s platform while apps consume the same keys live.

## What the Core module does (at a glance)

- Provides **runtime access** to your Tolgee project’s keys and values, suitable for any UI toolkit.
- Handles **platform coverage** via published artifacts per target.
- Serves as the **foundation** for higher-level integrations (e.g., the Compose module depends on Core).

## When to choose Core

- You don’t use Compose everywhere (e.g., Android Views, SwiftUI, KVision, or custom UI layers).
- You need a **headless translation layer** to power background work, prefetching, or analytics without UI coupling.
- You want **maximum control** over caching, fallbacks, and how strings are injected into your UI.

## Supported platforms

- Android
- JVM
- iOS
- macOS
- tvOS
- watchOS
- Android Native
- Linux
- Windows
- Javascript
- WasmJS

## Project setup (high level)

- **Add Core to your KMP project** in `commonMain` and/or platform source sets using the `io.tolgee.mobile-kotlin-sdk:core` coordinates.
- **Provision Tolgee access** (CDN url) and point the client to your Tolgee project environment.

## Migration tips (from static resources)

- **Start hybrid.** Keep existing resources while introducing Tolgee for a subset of screens.
- **Protect first-run UX.** Ship minimal fallback bundle to avoid blank UI.
- **Fallbacks** are crucial, so even if you haven't uploaded all keys (yet) Tolgee will make sure to display your static resources.

## Versioning status

- Artifacts are available as `1.0.0-alpha01` (published August 12, 2025). Expect breaking changes until stable.

## Related functionality

If you are looking for a compose ready integration take a look here: [Compose](Compose.md)