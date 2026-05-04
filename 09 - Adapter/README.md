# Lab 9: Ball Game

A cross-platform ball game implemented in Java, built around the **Adapter** design pattern.

The same game logic runs unmodified on Android, Windows, and PS5. Each platform exposes different native methods with different names, so an adapter class per platform translates them into the common `API` interface that `BallGame` depends on.

---

## Design Pattern: Adapter

`BallGame` only knows the `API` interface — three methods with stable, platform-agnostic names. Each platform has its own native operations with different names and behaviors. The adapter classes (`AndroidAPI`, `WindowsAPI`, `Playstation5API`) implement `API` and delegate each call to the corresponding native method.

```
«interface» API                    Native platform methods
+ loadImage(file)   
+ getPosition()        AndroidAPI  →  loadResource(), getTouch(), draw()
+ drawBall(x, y, img)  WindowsAPI  →  loadFile(), getMouseClick(), paint()
                       PS5API      →  loadGraphics(), getJoystick(), render()
        ▲
        │ depends on
    BallGame
    + play()
```

This is the same structure as a classic object adapter: the target interface (`API`) is what the client (`BallGame`) expects, and the adapters wrap the incompatible implementations without modifying them.

---

## Project Structure

```
src/main/java/es/uniovi/eii/ds/
├── main/
│   └── Main.java                        # Runs the game on all three platforms
├── API.java                             # Target interface: loadImage, getPosition, drawBall
├── graphics/
│   └── Image2D.java                     # Shared image class
├── ballgame/
│   └── BallGame.java                    # Client: game loop, only uses API
├── android/
│   └── AndroidAPI.java                  # Adapter: API → loadResource, getTouch, draw
├── windows/
│   └── WindowsAPI.java                  # Adapter: API → loadFile, getMouseClick, paint
├── playstation/
│   └── Playstation5API.java             # Adapter: API → loadGraphics, getJoystick, render
└── Platforms/
    ├── AndroidGame.java                 # Wires BallGame + AndroidAPI
    ├── WindowsGame.java                 # Wires BallGame + WindowsAPI
    └── PS5Game.java                     # Wires BallGame + Playstation5API
```

---

## Adapter Mapping

| `API` method | `AndroidAPI` | `WindowsAPI` | `Playstation5API` |
|---|---|---|---|
| `loadImage(file)` | `loadResource()` — from flash memory | `loadFile()` — from disk | `loadGraphics()` — from DVD |
| `getPosition()` | `getTouch()` — touch screen | `getMouseClick()` — mouse | `getJoystick()` — X button |
| `drawBall(x, y, img)` | `draw()` — draws on screen | `paint()` — paints on screen | `render()` — renders on screen |

---

## Example Output

```
ANDROID Game
(Android) Image 'ball.png' loaded from flash memory.
(Android) Drawing 'ball.png' at (10, 10)
(Android) Drawing 'ball.png' at (20, 20)
...

WINDOWS Game
(Windows) Image 'ball.png' loaded from disk.
(Windows) Drawing 'ball.png' at (10, 10)
...

PS5 Game
(PS5) Image loaded 'ball.png' from DVD.
(PS5) Drawing 'ball.png' at (10, 10)
...
```

---

## Running

Requires Java 11+ and Maven 3.6+.

```bash
mvn compile
mvn exec:java
```