# Lab 7: Poll

A console-based poll application implemented in Java, built around the **Observer** design pattern.

When a vote is recorded, the observable automatically notifies all subscribed observers, which react independently — updating charts, refreshing a status bar, saving to a database, etc. — without the `Poll` model knowing anything about them.

---

## Design Pattern: Observer

`PollObservable` is the subject: it wraps a `Poll`, exposes `recordYes()` and `recordNo()`, and maintains a list of `PollObserver` subscribers. Every time a vote is recorded it calls `update(poll)` on each observer.

| Role | Class(es) |
|---|---|
| **Observer** (interface) | `PollObserver` |
| **Concrete Observers** | `UpdateBarChart`, `UpdatePieChart`, `SaveResults`, `StatusBar`, `UpdateBarChartEveryXVote`, `UpdatePieChartFromXVote`, `StatusBarFromXEveryYVotes` |
| **Subject** | `PollObservable` — manages the subscriber list and triggers notifications |
| **Model** | `Poll` — stores yes/no counts, has no knowledge of observers |

The original `Poll` class had `updateBarChart()`, `updatePieChart()` and `saveResults()` called directly inside `recordYes()`/`recordNo()` (visible in the commented-out code). The refactor moves all that logic out into observers, keeping `Poll` a clean model class.

---

## Project Structure

```
src/main/java/es/uniovi/eii/ds/
├── main/
│   └── Main.java                              # Wires observers and runs the UI
├── PollObserver.java                          # Observer interface: update(Poll poll)
├── PollObservable.java                        # Subject: wraps Poll, manages subscribers
├── poll/
│   ├── model/Poll.java                        # Model: tracks yes/no vote counts
│   └── ui/PollConsoleUI.java                  # Reads yes/no/exit from stdin
└── observers/
    ├── UpdateBarChart.java                    # Redraws bar chart on every vote
    ├── UpdateBarChartEveryXVote.java          # Redraws bar chart every X votes
    ├── UpdatePieChart.java                    # Redraws pie chart on every vote
    ├── UpdatePieChartFromXVote.java           # Redraws pie chart starting from vote X
    ├── StatusBar.java                         # Prints yes/no counts on every vote
    ├── StatusBarFromXEveryYVotes.java         # Prints counts starting from vote X, every Y votes
    └── SaveResults.java                       # Saves results to database on every vote
```

---

## Observers

| Observer | Trigger condition |
|---|---|
| `UpdateBarChart` | Every vote |
| `UpdateBarChartEveryXVote(x)` | Every X-th vote (total votes % x == 0) |
| `UpdatePieChart` | Every vote |
| `UpdatePieChartFromXVote(x)` | Once total votes reach X, on every vote |
| `StatusBar` | Every vote |
| `StatusBarFromXEveryYVotes(x, y)` | Starting from vote X, every Y votes |
| `SaveResults` | Every vote |

---

## Example Configurations

```java
PollObservable observable = new PollObservable(new Poll("Are you in favor of nuclear energy?"));

// Pie chart from vote 3, status bar from vote 4 every 2 votes, bar chart every 3 votes
observable.subscribe(new UpdatePieChartFromXVote(3));
observable.subscribe(new StatusBarFromXEveryYVotes(4, 2));
observable.subscribe(new UpdateBarChartEveryXVote(3));

new PollConsoleUI().fill(observable);
```

Observers can be added or removed at runtime via `subscribe(observer)` and `unsubscribe(observer)` without touching any other class.

---

## Running

Requires Java 11+ and Maven 3.6+.

```bash
mvn compile
mvn exec:java
```

Valid inputs: `yes`, `no`, `exit`.