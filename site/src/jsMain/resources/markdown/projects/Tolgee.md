---
layout: .components.layouts.MarkdownLayout
title: Tolgee
---

# Tolgee Kotlin Multiplatform SDK

**Repository:** https://github.com/tolgee/tolgee-mobile-kotlin-sdk

> [!TIP]
> A Kotlin Multiplatform SDK for integrating Tolgee's localization services into your multiplatform applications.

Tolgee provides a seamless way to manage translations and localization in your apps using Kotlin Multiplatform. This SDK is designed to work across different platforms, ensuring a consistent localization experience.

## Motivation

I created this SDK because I noticed a significant gap in the localization ecosystem for Kotlin developers. Most existing localization solutions did not truly support **Kotlin Multiplatform**, and even fewer had **Jetpack Compose** compatibility. I wanted a solution that genuinely works on any platform while being fully compatible with **Compose Multiplatform**.

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

From a developer perspective, no other service offered a smooth, flexible, and modern experience. Once Tolgee announced support for importing Compose Multiplatform resources, I was hooked - no other major localization service offered this capability at the time. I saw tremendous potential in Tolgee, and building this SDK gave me the opportunity to help shape its path and improve its adoption for multiplatform projects.

## Modules Overview

### Core Module

Link: [Core](tolgee/Core.md)

**Purpose:** The Core module offers the foundational components for integrating Tolgee's localization services into traditional Android applications. It provides essential functionalities such as content delivery and storage management.

**Usage Recommendation:** Use the Core module if you are developing a traditional Android application and require a straightforward integration with Tolgee's localization services.

### Compose Module

Link: [Compose](tolgee/Compose.md)

**Purpose:** The Compose module is tailored for applications built using Jetpack Compose or Compose Multiplatform. It provides ready-to-use components and utilities that simplify the integration of Tolgee's localization services into Compose-based applications.

**Usage Recommendation:** Opt for the Compose module if you are developing an application using Jetpack Compose or Compose Multiplatform and wish to leverage Tolgee's localization services with minimal setup.

## Getting Started

To begin using the Tolgee Mobile Kotlin SDK, choose the module that best fits your application's architecture and follow the detailed instructions provided in the respective documentation.

For more information and resources, visit the [official Tolgee documentation](https://tolgee.io).

Feel free to explore the demo projects for practical examples:

- [Example Android](https://github.com/tolgee/tolgee-mobile-kotlin-sdk/tree/master/demo/exampleandroid)
- [Example Jetpack Compose](https://github.com/tolgee/tolgee-mobile-kotlin-sdk/tree/master/demo/examplejetpack)
- [Example Multiplatform Compose](https://github.com/tolgee/tolgee-mobile-kotlin-sdk/tree/master/demo/multiplatform-compose)

## License

This project is licensed under the Apache License 2.0 see the LICENSE file for details.

## Learn More

Full source code and documentation: https://github.com/tolgee/tolgee-mobile-kotlin-sdk