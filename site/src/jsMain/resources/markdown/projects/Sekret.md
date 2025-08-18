---
layout: .components.layouts.MarkdownLayout
title: Sekret
---

# Sekret - Overview

> [!TIP]
> A Kotlin Multiplatform solution to handle secrets safely, both in memory/logs and in client-side binaries.

**Repository:** https://github.com/DatL4g/Sekret

Sekret is split into two complementary parts:

## 1. Secure Logging

Link: [Logging](SekretLogging.md)

**Purpose:** Automatically redact sensitive data from logs to prevent accidental leaks.  
**Usage recommendation:** Use this whenever your app handles tokens, passwords, API keys, or any personal data in memory and may log it. It reduces the risk of exposing secrets in console output, Crashlytics, or log files.

## 2. Application Secrets

Link: [Secrets](SekretSecrets.md)

**Purpose:** Embed secrets in a safer, obfuscated way inside your client-side binaries.  
**Usage recommendation:** Use this when your app requires API keys or other secrets at runtime. This makes extracting secrets from APKs or IPAs harder, though client-side secrets are never perfectly secure. For full coverage, combine this with Secure Logging to avoid accidental leaks at runtime.

## Recommendation

For best security and developer experience, use **both parts together**:
- Application Secrets to reduce extraction from binaries.
- Secure Logging to prevent accidental logging of secrets during development and production monitoring.

Full source code and documentation: https://github.com/DatL4g/Sekret