---
layout: .components.layouts.MarkdownLayout
title: Mimasu
---

# Mimasu

> [!TIP]
> A sleek, simple guide to the world of film and television - discover trending movies, explore popular series, and dive into details. Powered by TMDB.

**Repository:** https://github.com/DatL4g/Mimasu  
**Google Play:** https://play.google.com/store/apps/details?id=dev.datlag.mimasu

## Why Mimasu?

Finding what to watch shouldn’t feel like work. Mimasu (みます) focuses on fast browsing, clean presentation, and rich detail so you can pick your next movie night pick without the fluff. It’s designed for phones, tablets, and even Android TV, with a UI that scales gracefully across form factors.

## Key Features

- Browse trending movies and discover popular TV series, with detail pages that help you decide quickly.
- Built on The Movie Database (TMDB) for fresh data and imagery.
- UI optimized for Smartphones, Tablets, and Android TV.
- Actively evolving - recent updates simplified onboarding (e.g., account no longer required).

## Extension Support (Providers & Integrations)

Mimasu supports an extension system so streaming providers can integrate **directly in the app**. That means services (for example, Netflix or Crunchyroll) could ship an extension to enable discovery and playback inside Mimasu—subject to their terms, DRM, and platform policies. Extensions are packaged as separate apps that Mimasu can discover and use seamlessly once installed.

> [!NOTE]
> Mimasu does **not** bypass DRM or provider restrictions. Extensions must comply with each service’s terms and legal requirements. The extension mechanism simply provides a clean, official path for providers to plug in their catalogs and players.

## Great UX by Design

- **Speed first:** snappy lists, fast search, and minimal taps to details.
- **Readable by default:** clean typography, balanced spacing, and accessible color use.
- **Consistent layouts:** a single mental model across phone, tablet, and TV.
- **Delightful details:** subtle motion and clear affordances without getting in your way.

## Screenshots

| <img src="/mimasu_1.webp" width="350" height="720" loading="lazy" decoding="async" alt="Home" /> | <img src="/mimasu_2.webp" width="350" height="720" loading="lazy" decoding="async" alt="Series" /> | <img src="/mimasu_3.webp" width="350" height="720" loading="lazy" decoding="async" alt="Movie" /> |
|--------------------------------------------------------------------------------------------------|----------------------------------------------------------------------------------------------------|---------------------------------------------------------------------------------------------------|

## How Extensions Work (High-Level)

1. A provider ships an **extension app** implementing the Mimasu extension interface.
2. The user installs the provider’s extension alongside Mimasu.
3. Mimasu discovers the extension and surfaces the provider’s catalog/results; playback uses the provider’s allowed methods.

This architecture keeps providers in control of their content and policies while giving users a unified, polished browsing experience.

## Privacy & Data Safety

On Google Play, the listing declares:  
- **No data shared with third parties**.
- Data may include personal info and app activity; **data is encrypted in transit** and **deletion can be requested**. See the Play “Data safety” section for details.

## Credits

This product uses the **TMDB** API but is not endorsed or certified by TMDB.

## Links

- Google Play: https://play.google.com/store/apps/details?id=dev.datlag.mimasu
- Extensions (example repository): https://github.com/DatL4g/Mimasu-Extension

_Last updated: based on Google Play listing dated July 31, 2025._

### Notes for collaborators

- If you’re a streaming service interested in official integration, reach out to discuss the extension API and distribution model.
- All extensions must adhere to content licensing, DRM, store policies, and regional regulations.