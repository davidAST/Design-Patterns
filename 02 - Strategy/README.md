# Lab 3: Graphical Editor

A text-based graphical editor implemented in Java, applying two classic GoF design patterns: **Strategy** and **Template Method** (implicit through the `Tool` interface).

The editor manages a drawing composed of figures. The user selects a tool, interacts with the canvas via mouse events, and the active tool decides what to do with those events.

---

## Design Patterns

### Strategy

The **Strategy** pattern is the core of this project. It is used in two places:

**Tools** — the `Editor` holds a reference to a `Tool`, which can be swapped at runtime when the user selects a different tool button. Each tool implements the same interface (`mousePressed`, `mouseMoved`, `mouseReleased`) but behaves completely differently.

**Figures** — the `Drawing` holds a list of `Figure` objects. Each figure implements `draw()`, `figureSelected()`, and `move()` in its own way, allowing the editor to treat all shapes uniformly without knowing their concrete type.

| Role | Tool strategy | Figure strategy |
|---|---|---|
| **Strategy** (interface) | `Tool` | `Figure` |
| **Concrete Strategies** | `SelectTool`, `RectangleTool`, `CircleTool`, `TriangleTool` | `Circle`, `Rectangle`, `Triangle` |
| **Context** | `Editor` (delegates mouse events to the active `Tool`) | `Drawing` (iterates figures and calls `draw()` / `getFigure()`) |

The key characteristic that makes this Strategy and not Command: the `Editor` always has **one active tool at a time**, and swapping it changes the behavior of all future mouse events. There is no queue of actions — the tool is simply the current behavioral strategy.

---

## Project Structure

```
src/main/java/es/uniovi/eii/ds/
├── main/
│   └── Main.java                        # Entry point, simulates UI events
└── editor/core/
    ├── Editor.java                      # Context: holds active Tool and Drawing
    ├── Drawing.java                     # Manages the list of Figure objects
    ├── Figure.java                      # Strategy interface for figures
    ├── Tool.java                        # Strategy interface for tools
    ├── Point.java                       # Simple (x, y) value class
    ├── figures/
    │   ├── Circle.java                  # Defined by center + radius
    │   ├── Rectangle.java               # Defined by origin + width + height
    │   └── Triangle.java                # Defined by three vertices
    └── tools/
        ├── SelectTool.java              # Click to select, drag to move
        ├── CircleTool.java              # Press + release to define radius
        ├── RectangleTool.java           # Press + release to define bounds
        └── TriangleTool.java            # Three clicks to define vertices
```

---

## How Each Tool Works

| Tool | mousePressed | mouseMoved | mouseReleased |
|---|---|---|---|
| `SelectTool` | Finds figure at click point | Moves the selected figure | Drops the figure, switches back to selection |
| `RectangleTool` | Records start corner | — | Creates rectangle from start to release point, switches to selection |
| `CircleTool` | Records center | — | Computes radius from distance to release point, switches to selection |
| `TriangleTool` | Records each of the 3 vertices on successive clicks | — | Creates triangle on 3rd click, switches to selection |

After creating a figure, drawing tools automatically switch back to `SelectTool`.

---

## Running

Requires Java 11+ and Maven 3.6+.

```bash
mvn compile
mvn exec:java
```

### Available commands

```
Tools:        selection  rectangle  circle  triangle
Mouse events: click <x>,<y>   move <x>,<y>   release <x>,<y>
Other:        draw   help   exit
```

### Example session

```
% rectangle
% click 10, 20
% release 50, 80
% circle
% click 100, 100
% release 130, 100
% draw
Rectangle at (10, 20) with width 40 and height 60
Circle at (100, 100) with radius 30
```