# Lab 3: Forms

A console-based form system implemented in Java, built around the **Template Method** design pattern.

The form collects user input field by field, validating each entry in a loop until the user provides an accepted value.

---

## Design Pattern: Template Method

The `prompt()` method in `AbstractField` defines a fixed algorithm skeleton: print the label, read input, check validity, and if invalid print an error and repeat. The steps that vary between field types — `isValid()` and `printErrorMessage()` — are declared abstract and implemented by each concrete subclass.

This is the Template Method pattern: the **invariant part of the algorithm lives in the parent class**, while the **variant steps are deferred to subclasses**.

```
AbstractField  (template)
├── prompt()              ← fixed algorithm: loop { read → validate → error? }
├── isValid(value)        ← abstract: subclass decides what is valid
└── printErrorMessage()   ← abstract: subclass decides what to print

TextField      → letters only
NumericField   → digits only
ChoiceField    → must match one of the provided options
```

The `Field` interface adds a layer of abstraction above that, allowing `Form` to hold a heterogeneous list of fields and call `prompt()` on all of them uniformly — a secondary use of polymorphism.

---

## Project Structure

```
src/main/java/es/uniovi/eii/ds/
├── main/
│   └── Main.java                 # Entry point, builds and runs a sample form
└── forms/
    ├── Field.java                # Interface: prompt(), label(), value()
    ├── AbstractField.java        # Template Method: implements prompt(), declares isValid() and printErrorMessage()
    ├── TextField.java            # Accepts letters only
    ├── NumericField.java         # Accepts digits only
    └── ChoiceField.java          # Accepts one of a fixed set of options (case-insensitive)
    └── Form.java                 # Holds a list of Fields; fill() prompts each, show() prints results
```

---

## Field Types

| Field | Validation rule | Error message |
|---|---|---|
| `TextField` | All characters must be letters | `Please enter letters only.` |
| `NumericField` | All characters must be digits | `Please enter digits only.` |
| `ChoiceField` | Input must match one of the given options (case-insensitive) | Lists the valid options |

New field types can be added by extending `AbstractField` and implementing only `isValid()` and `printErrorMessage()`. The `new-fields.txt` file lists several examples of fields that could be implemented this way (product codes, postal codes, age ranges, salary ranges, compound validations, etc.).

---

## Example Usage

```java
Form form = new Form();

form.add(new TextField("First name"))
    .add(new TextField("Surname"))
    .add(new NumericField("Phone"))
    .add(new ChoiceField("City", "Oviedo", "Gijón", "Avilés"));

form.fill();
form.show();
```

```
First name: 123
Please enter letters only.
First name: Ana
Surname: García
Phone: abc
Please enter digits only.
Phone: 612345678
City: Madrid
Please enter one of the following options: Oviedo, Gijón or Avilés.
City: Oviedo

--- Form values ---
First name     : Ana
Surname        : García
Phone          : 612345678
City           : Oviedo
```

---

## Running

Requires Java 11+ and Maven 3.6+.

```bash
mvn compile
mvn exec:java
```