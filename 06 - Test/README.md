# Lab 6: File System

A file copying system implemented in Java, built around the **Decorator** design pattern.

The system copies files to different destinations (file, internet, Bluetooth) and allows transformations — normalization, encryption, space removal, character counting — to be stacked on top of any output, in any order, without modifying the underlying classes.

---

## Design Pattern: Decorator

All outputs and decorators implement the same `Output` interface (`open`, `write`, `close`). A decorator wraps another `Output`, intercepts calls to `write()`, applies its transformation, and forwards the result to the inner output.

This makes decorators **composable**: each one is both an `Output` (so it can be wrapped) and a wrapper of another `Output` (so it can wrap). Stacking them builds a processing pipeline that `FileSystem.copyFile()` drives character by character.

```
«interface» Output
+ open()
+ write(char c)
+ close()
        ▲
        │ implements
  ┌─────┴──────────────────────────────┐
  │                                    │
Concrete outputs              Decorators (wrap another Output)
  ├── FileOutput               ├── NormalizeDecorator
  ├── Internet                 ├── EncryptDecorator
  └── Bluetooth                ├── RemoveSpacesDecorator
                               └── CountCharactersDecorator
```

**Example pipeline:**

```java
// Characters flow right to left through the chain:
// FileSystem → RemoveSpaces → Encrypt → Bluetooth
system.copyFile("private.txt",
    new RemoveSpacesDecorator(
        new EncryptDecorator(
            new Bluetooth("César's iPhone"))));
```

---

## Project Structure

```
src/main/java/es/uniovi/eii/ds/
├── main/
│   └── Main.java                              # Demonstrates all pipeline combinations
└── fylesystem/
    ├── Output.java                            # Component interface
    ├── FileSystem.java                        # Reads a resource file and writes it to an Output
    ├── outputs/                               # Concrete outputs (leaf nodes)
    │   ├── FileOutput.java                    # Writes to a file in the output/ folder
    │   ├── Internet.java                      # Simulates sending over the network
    │   └── Bluetooth.java                     # Simulates sending via Bluetooth
    └── decorators/                            # Decorators (wrap any Output)
        ├── NormalizeDecorator.java            # Converts CRLF → LF (Windows → Unix line endings)
        ├── EncryptDecorator.java              # Shifts each alphanumeric character by +1
        ├── RemoveSpacesDecorator.java         # Collapses consecutive spaces into one
        └── CountCharactersDecorator.java      # Counts characters written; exposes getCount()
```

---

## Decorators

| Decorator | What it does |
|---|---|
| `NormalizeDecorator` | Strips `\r` from `\r\n` sequences, normalizing Windows line endings to Unix |
| `EncryptDecorator` | Shifts every letter or digit by +1 (e.g. `a→b`, `1→2`) |
| `RemoveSpacesDecorator` | Collapses runs of consecutive spaces into a single space |
| `CountCharactersDecorator` | Transparent pass-through that counts characters; call `getCount()` after copying |

---

## Example Pipelines

```java
FileSystem system = new FileSystem();

// Plain copy to a file
system.copyFile("private.txt", new FileOutput("copy.txt"));

// Normalize line endings before writing to file
system.copyFile("private.txt",
    new NormalizeDecorator(new FileOutput("copy-normalized.txt")));

// Encrypt before sending over the internet
system.copyFile("private.txt",
    new EncryptDecorator(new Internet("156.35.233.143")));

// Remove spaces, then encrypt, then send via Bluetooth
system.copyFile("private.txt",
    new RemoveSpacesDecorator(
        new EncryptDecorator(
            new Bluetooth("César's iPhone"))));

// Count characters written to the network
CountCharactersDecorator counter = new CountCharactersDecorator(new Internet("1.1.1.1"));
system.copyFile("private.txt", counter);
System.out.println(counter.getCount() + " characters copied");
```

---

## Running

Requires Java 11+ and Maven 3.6+.

```bash
mvn compile
mvn exec:java
```