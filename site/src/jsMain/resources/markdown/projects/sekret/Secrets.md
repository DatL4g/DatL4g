---
layout: .components.layouts.MarkdownLayout
title: Sekret - Logging
---

# Sekret - Application Secrets

**Repository:** https://github.com/DatL4g/Sekret

> [!TIP]
> Make client-side secrets harder to extract by generating a native, multiplatform layer for them.

## The problem

Every app ships some secret (API keys, salts, license tokens). On client devices, perfect secrecy doesn’t exist - given enough time, attackers can reverse-engineer binaries.  
But we can raise the cost: don’t ship plain strings, don’t leave them in resources, don’t make static analysis trivial.

## What Sekret does

- Generates a dedicated module for your secrets at build time - no cloud service required.
- Embeds secrets deep in native binaries (Kotlin/Native targets where appropriate) with transformations and obfuscation to resist simple static string extraction.
- Exposes a typed API you can call from your app code, so usage stays ergonomic and multiplatform.

## Why this is better than just keep it in a file

Keeping secrets in `local.properties` or environment files avoids checking them into VCS (good!) but once compiled straight into strings, anyone can grab them via APK or IPA inspection.  
Sekret focuses on the compiled form and access pattern, splitting and transforming data and surfacing it through generated code so it’s no longer an obvious constant in bytecode.

## What this is and isn’t

- Is: A pragmatic way to store secrets that resists copy-paste scrapers and common static tooling.
- Isn’t: A silver bullet. If a secret must be truly protected, keep it server-side and issue short-lived tokens. Client-side only ever buys you work factor, not absolute secrecy.

## Quick start

**Step 1:** Apply the plugin

```gradle
plugins {
    id("dev.datlag.sekret") version "2.2.0"
}
```

**Step 2:** Define your secrets via the plugin’s configuration (kept out of VCS) and use the generated API in code.  
**Step 3:** Check configuration here: https://github.com/DatL4g/Sekret/blob/master/Secrets.md  
**Step 4:** Build - Sekret creates or updates the generated module and wires it into your KMP targets.

> [!TIP]
> Keep the file that holds your raw secret inputs git-ignored. Commit only the generated module and configuration stubs - never the real values.

## Good use cases

- Public apps that still need a key (maps, analytics, vendor SDKs) where usage limits or abuse would hurt you.
- Speed bump protection to reduce automated scraping of tokens from your binaries.
- Cross-platform teams that want a single, consistent secrets pipeline.

## Caveats

- Skilled reverse engineers can still recover secrets with enough effort (debug hooks, runtime tracing, emulators). Design your backend with that assumption.
- Rotate keys periodically - Sekret reduces exposure windows but can’t eliminate them.

## Related functionality

If you are more interested in preventing secrets from being accidentally leaked into logs (for example via toString or string interpolation), see the companion page about [**Secure Logging**](SekretLogging.md)