<div align="center">

```
███████╗███╗   ██╗ ██████╗██╗      █████╗ ██╗   ██╗███████╗
██╔════╝████╗  ██║██╔════╝██║     ██╔══██╗██║   ██║██╔════╝
█████╗  ██╔██╗ ██║██║     ██║     ███████║██║   ██║█████╗  
██╔══╝  ██║╚██╗██║██║     ██║     ██╔══██║╚██╗ ██╔╝██╔══╝  
███████╗██║ ╚████║╚██████╗███████╗██║  ██║ ╚████╔╝ ███████╗
╚══════╝╚═╝  ╚═══╝ ╚═════╝╚══════╝╚═╝  ╚═╝  ╚═══╝  ╚══════╝
```

### *Your hidden territory. Inside your phone.*

<br/>

![Android](https://img.shields.io/badge/Android-3DDC84?style=for-the-badge&logo=android&logoColor=white)
![Kotlin](https://img.shields.io/badge/Kotlin-7F52FF?style=for-the-badge&logo=kotlin&logoColor=white)
![Jetpack Compose](https://img.shields.io/badge/Jetpack%20Compose-4285F4?style=for-the-badge&logo=jetpackcompose&logoColor=white)
![Min SDK](https://img.shields.io/badge/Min%20SDK-24-orange?style=for-the-badge)
![License](https://img.shields.io/badge/License-MIT-teal?style=for-the-badge)

<br/>

> **Enclave** is not just an app. It's a dimension living inside your Android device —
> a self-contained virtual space that holds your mini-apps, tools, and shortcuts,
> all wrapped in buttery-smooth animations and a stunning dark UI.

<br/>

</div>

---

## ✦ What is Enclave?

Imagine opening your phone and stepping into a **personal universe** — your own space, your own apps, your own rules. That's Enclave.

Enclave is a **Virtual Space Application** for Android. It acts as a beautiful mini-launcher that lives *inside* a single app. No root required. No system modifications. Just pure, fluid experience.

You get:
- 🌌 A stunning animated virtual space as your home
- 📱 Mini-apps living inside the space as floating cards
- 📌 One-tap shortcut pinning to your Android home screen
- ⚡ 60fps animations. Always. No compromises.

---

## ✦ Why Enclave Exists

Most phones are cluttered. Apps everywhere. No personality. No flow.

Enclave gives you **a space that is entirely yours** — organized, beautiful, and blazing fast. Think of it like having a premium private dashboard inside your phone. Everything you need, nothing you don't, wrapped in a UI that actually feels good to use every single day.

---

## ✦ Features

| Feature | Status |
|---|---|
| 🌌 Animated virtual space home | ✅ Phase 1 |
| 🔲 4-column app icon grid with staggered animations | ✅ Phase 1 |
| 🎯 Spring-physics icon press animations | ✅ Phase 1 |
| 🪄 Slide-up mini-app viewer with swipe-to-close | ✅ Phase 1 |
| 📌 Pin any Space App to Android home screen | ✅ Phase 1 |
| 🔗 Deep link from home screen shortcut | ✅ Phase 1 |
| 🌊 Frosted glass bottom dock | ✅ Phase 1 |
| 🎨 Animated gradient mesh wallpaper | ✅ Phase 1 |
| 📝 Notes mini-app | 🔜 Phase 2 |
| 🧮 Calculator mini-app | 🔜 Phase 2 |
| 🌤️ Weather mini-app | 🔜 Phase 2 |
| 🎵 Music mini-app | 🔜 Phase 2 |
| 🌐 Browser mini-app | 🔜 Phase 2 |
| 🎨 Custom themes & wallpapers | 🔜 Phase 3 |
| 🔐 Space lock with biometrics | 🔜 Phase 3 |
| ☁️ Cloud sync across devices | 🔜 Phase 4 |

---

## ✦ Tech Stack

```
┌─────────────────────────────────────────────────┐
│                    ENCLAVE CORE                   │
├─────────────────┬───────────────────────────────┤
│  Language       │  Kotlin 2.0                   │
│  UI             │  Jetpack Compose (BOM Latest)  │
│  Animations     │  Compose Animation + Lottie    │
│  Navigation     │  Compose Navigation            │
│  State          │  ViewModel + StateFlow         │
│  DI             │  Hilt                          │
│  Storage        │  DataStore Preferences         │
│  Shortcuts      │  ShortcutManagerCompat         │
│  Build          │  Gradle Kotlin DSL             │
│  Min SDK        │  24 (Android 7.0)              │
│  Target SDK     │  35 (Android 15)               │
└─────────────────┴───────────────────────────────┘
```

> 💡 **Every library in this project is 100% free and open source.**

---

## ✦ Architecture

Enclave follows **Clean Architecture** with a unidirectional data flow:

```
                        ┌─────────────┐
                        │     UI      │  Jetpack Compose Screens
                        └──────┬──────┘
                               │ observes
                        ┌──────▼──────┐
                        │  ViewModel  │  StateFlow + UI State
                        └──────┬──────┘
                               │ calls
                        ┌──────▼──────┐
                        │ Repository  │  Single source of truth
                        └──────┬──────┘
                               │ reads/writes
                   ┌───────────┴───────────┐
                   │                       │
            ┌──────▼──────┐       ┌────────▼───────┐
            │  DataStore  │       │  Android APIs  │
            │ Preferences │       │  (Shortcuts)   │
            └─────────────┘       └────────────────┘
```

---

## ✦ Project Structure

```
EnclaveApp/
├── 📁 core/
│   ├── navigation/       → Routes & NavGraph
│   ├── theme/            → Colors, Typography, Shapes
│   └── utils/            → Shortcut logic, Animation specs
│
├── 📁 data/
│   ├── model/            → SpaceApp data model
│   ├── repository/       → App data source
│   └── datastore/        → Persisted preferences
│
├── 📁 ui/
│   ├── space/            → Virtual Space home screen
│   │   └── components/   → Grid, Icon, Dock, Wallpaper, TopBar
│   └── appviewer/        → Mini-app container screen
│
└── 📁 miniapps/          → Individual mini-app screens
    ├── notes/
    ├── calculator/
    └── ...
```

---

## ✦ Getting Started

### Prerequisites

Make sure you have the following installed:

- [Android Studio Koala](https://developer.android.com/studio) or newer
- JDK 17+
- Android SDK (API 24–35)

### Clone & Run

```bash
# Clone the repository
git clone https://github.com/yourusername/enclave-virtual-space.git

# Navigate into the project
cd enclave-virtual-space

# Open in Android Studio
# File → Open → select the project folder

# Build & run on emulator or device
./gradlew assembleDebug
```

### Build Variants

| Variant | Purpose |
|---|---|
| `debug` | Development, logging enabled |
| `release` | Production, R8 minification + shrinking |

---

## ✦ Animation Philosophy

Enclave is built on one rule: **every interaction must feel alive.**

We use **spring physics** — not just easing curves — so animations feel physical and natural, never robotic.

```kotlin
// Every icon tap uses this — feels like pressing a real button
spring(
    dampingRatio = Spring.DampingRatioMediumBouncy,
    stiffness = Spring.StiffnessLow
)
```

Performance targets:

- 🎯 **60fps** minimum on all supported devices
- 🚀 **120fps** on high refresh rate displays
- 🪶 **Zero jank** — all animations run on GPU via `graphicsLayer`

---

## ✦ Home Screen Shortcuts

Enclave lets you **pin any mini-app directly to your Android home screen** — one tap and you're inside your space, directly in the right app. No unlocking. No navigating. Just instant access.

```
Home Screen Shortcut
       ↓
Opens Enclave
       ↓
Deep links directly into the pinned mini-app
       ↓
You're there in < 1 second
```

Powered by Android's native `ShortcutManagerCompat` — works on all launchers that support pinned shortcuts (most major ones do).

---

## ✦ Performance Rules

These rules are enforced throughout the entire codebase:

1. **Vector Drawables only** — no PNG icons, ever
2. **`graphicsLayer` for all animations** — GPU-accelerated, zero jank
3. **`key()` in every list item** — prevents unnecessary recomposition
4. **`derivedStateOf` for computed values** — no redundant calculations
5. **Low-RAM device detection** — static fallback for older phones
6. **R8 full mode in release** — smallest possible APK size

---

## ✦ Roadmap

```
Phase 1 ──── Virtual Space Shell          ← YOU ARE HERE
    │
Phase 2 ──── Mini-Apps (Notes, Calc, etc.)
    │
Phase 3 ──── Custom Themes, Biometric Lock
    │
Phase 4 ──── Cloud Sync, Multi-Space Support
    │
Phase 5 ──── Enclave Store (community mini-apps)
```

---

## ✦ Contributing

Enclave is in active development. Contributions are welcome!

1. Fork the repository
2. Create your feature branch: `git checkout -b feature/your-feature`
3. Commit your changes: `git commit -m 'Add: your feature description'`
4. Push to the branch: `git push origin feature/your-feature`
5. Open a Pull Request

Please follow the existing code style and architecture patterns.

---

## ✦ License

```
MIT License

Copyright (c) 2026 Enclave

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.
```

---

## ✦ Acknowledgements

Built with love using:
- [Jetpack Compose](https://developer.android.com/compose) by Google
- [Lottie](https://airbnb.io/lottie) by Airbnb
- [Hilt](https://dagger.dev/hilt/) by Google
- [Kotlin](https://kotlinlang.org/) by JetBrains

---

<div align="center">

<br/>

```
E N C L A V E  —  Your hidden territory. Inside your phone.
```

<br/>

*Made with 🖤 for people who want more from their phone*

</div>
