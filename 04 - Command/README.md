# Lab 4: Graphical Editor with Undo/Redo

An extension of the graphical editor from the previous lab, adding **undo and redo** support via the **Command** design pattern. The Strategy pattern (tools and figures) is carried over from the previous version.

---

## Design Patterns

### Command (new in this lab)

Every user action that modifies the drawing is now encapsulated as an `Action` object with two methods: `execute()` and `undo()`. The `Editor` maintains two stacks — one for executed actions (undo history) and one for undone actions (redo history).

| Role | Class(es) |
|---|---|
| **Command** (interface) | `Action` |
| **Concrete Commands** | `CreateAction`, `MoveAction` |
| **Invoker** | `Editor` — calls `execute()`, manages both stacks |
| **Receiver** | `Drawing` (add/remove figures), `Figure` (move) |

**Undo/redo flow:**

```
editor.execute(action)  →  action.execute()  →  pushed onto actions stack
editor.undo()           →  actions.pop()     →  action.undo()  →  pushed onto redoActions
editor.redo()           →  redoActions.pop() →  action.execute() again → pushed back onto actions
```

`CreateAction` undoes itself by removing the figure from the drawing. `MoveAction` undoes itself by applying the inverse displacement (`-x, -y`).

### Strategy (carried over from previous lab)

`Tool` and `Figure` remain Strategy interfaces. The `Editor` holds one active `Tool` at a time, and `Drawing` holds a polymorphic list of `Figure` objects.

---

## Project Structure

```
src/main/java/es/uniovi/eii/ds/
├── main/
│   └── Main.java                          # Entry point, simulates UI events
└── editor/core/
    ├── Action.java                        # Command interface: execute(editor), undo(editor)
    ├── CreateAction.java                  # Adds a figure; undo removes it
    ├── MoveAction.java                    # Moves a figure; undo reverses the displacement
    ├── Editor.java                        # Invoker: holds undo/redo stacks, active tool, drawing
    ├── Drawing.java                       # Manages the figure list (add, delete, draw)
    ├── Figure.java                        # Strategy interface for figures
    ├── Tool.java                          # Strategy interface for tools
    ├── Point.java                         # Simple (x, y) value class
    ├── figures/
    │   ├── Circle.java
    │   ├── Rectangle.java
    │   └── Triangle.java
    └── tools/
        ├── SelectTool.java                # On release: creates MoveAction
        ├── CircleTool.java                # On release: creates CreateAction(Circle)
        ├── RectangleTool.java             # On release: creates CreateAction(Rectangle)
        └── TriangleTool.java              # On 3rd click: creates CreateAction(Triangle)
```

---

## Available Commands

```
Tools:        selection  rectangle  circle  triangle
Mouse events: click <x>,<y>   move <x>,<y>   release <x>,<y>
Other:        draw   undo   redo   help   exit
```

### Example session

```
% rectangle
% click 10, 20
% release 60, 80
% circle
% click 100, 100
% release 130, 100
% draw
Rectangle at (10, 20) with width 50 and height 60
Circle at (100, 100) with radius 30
% undo
% draw
Rectangle at (10, 20) with width 50 and height 60
% redo
% draw
Rectangle at (10, 20) with width 50 and height 60
Circle at (100, 100) with radius 30
```

---

## Running

Requires Java 11+ and Maven 3.6+.

```bash
mvn compile
mvn exec:java
```