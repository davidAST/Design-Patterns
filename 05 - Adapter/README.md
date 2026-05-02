# Lab 5: Maps

A Google Maps-style application implemented in Java, built around the **Adapter** design pattern.

The system displays different types of places (monuments, photos, restaurants) as markers on a map, even though those place classes were not originally designed to work with the map's `Marker` interface.

---

## Design Pattern: Adapter

The `Map` class belongs to a pre-existing Google Maps library and works exclusively with `Marker` objects. The domain model classes (`Monument`, `Photo`, `Restaurant`) come from a separate package and were not designed with that interface in mind.

The **Adapter** pattern bridges this gap: `Place` is an abstract class that implements `Marker`, adapting the domain model to the map library's interface. Each concrete place subclass inherits this adaptation and provides the specific data the `Marker` interface needs.

```
google.maps package          places package
─────────────────            ──────────────────────────────────────
«interface»                  abstract Place implements Marker
Marker                  ←──  ├── getTitle()      → name/description
+ getTitle()                 ├── getPosition()   → coordinates
+ getPosition()              ├── getHTMLInfo()   → formatted HTML summary
+ getHTMLInfo()              └── open()          → subclass-specific action
+ open()
                             Monument extends Place
Map                          ├── open() → Navigator.getDirectionsTo(address)
+ add(Marker)          ←──   Photo extends Place
+ draw()                     ├── open() → show() (displays the photo)
+ userTouch()                Restaurant extends Place
+ userLongTouch()            └── open() → call() (dials the phone number)
```

The `open()` method in each subclass is where the **type-specific behavior** lives: navigating to a monument, displaying a photo, or calling a restaurant. This lets `Map` trigger the right action with a simple `marker.open()` call, without knowing the concrete type.

---

## Project Structure

```
src/main/java/es/uniovi/eii/ds/
├── main/
│   └── Main.java                          # Loads DB, adds markers to map, simulates touch events
├── google/maps/                           # Pre-existing library (not to be modified)
│   ├── Marker.java                        # Interface the map works with
│   ├── Map.java                           # Displays markers, handles touch events
│   ├── Navigator.java                     # Converts addresses ↔ coordinates, gives directions
│   └── Coordinates.java                   # Longitude/latitude value class
└── places/
    ├── Place.java                         # Abstract Adapter: implements Marker for all place types
    ├── PlaceMarker.java                   # (Unused stub)
    ├── database/
    │   └── Database.java                  # Simulated DB with monuments, photos and restaurants
    ├── form/
    │   ├── Form.java                      # Edits monument fields interactively
    │   └── main/Main.java                 # Entry point for the form feature
    └── model/
        ├── Monument.java                  # Name, author, address — open() navigates to it
        ├── Photo.java                     # Description, user, coordinates — open() shows it
        └── Restaurant.java               # Name, address, phone — open() calls it
```

---

## How It Works

Each place type adapts the `Marker` interface differently:

| Type | `getTitle()` | `getHTMLInfo()` | `open()` |
|---|---|---|---|
| `Monument` | Name | `"Name. Created by Author"` | GPS navigation to address |
| `Photo` | Description | `"Description (by User)"` | Displays the photo |
| `Restaurant` | Name | Name + address + phone | Calls the phone number |

Coordinates are resolved via `Navigator.coordinatesOf(address)` for monuments and restaurants; photos store their coordinates directly.

---

## Sample Output

```
 1. Adding markers to the map...

 2. Show map:
Colosseum at [longitude = 160.0, latitude = 160.0]
Fontana di Trevi at [longitude = 200.0, latitude = 200.0]
Photo: Colosseum in Rome, Italy - April 2007 at [longitude = 20.0, latitude = 20.0]
...

 3. Short touch: a tooltip is shown with a summary of the marker
An emergent window is open: Colosseum. Created by Vespasiano
An emergent window is open: Colosseum in Rome, Italy - April 2007 (by DAVID ILIFF)
...

 4. Long touch: an action is performed for the marker
GPS: Turn right [...] You have reached your destination: Piazza del Colosseo, 1, 00184 Roma, Italia
Opening photo Colosseum in Rome, Italy - April 2007...
Calling +39 06 6798643...
```

---

## Running

Requires Java 11+ and Maven 3.6+.

```bash
mvn compile
mvn exec:java
```