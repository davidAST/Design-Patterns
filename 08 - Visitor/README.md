# Lab 8: Visitor

A mini-language interpreter implemented in Java, built around the **Visitor** design pattern.

The system constructs an Abstract Syntax Tree (AST) from a small expression language and then traverses it with different visitors — one to pretty-print the program, another to execute it.

---

## Design Pattern: Visitor

The AST node classes (`Program`, `Assignment`, `Sum`, `Variable`, etc.) each implement a single method: `accept(Visitor visitor, Object param)`. All they do is call `visitor.visit(this, param)`, delegating the actual logic to the visitor.

This keeps the node classes simple and stable. New operations over the AST (type checking, code generation, optimization…) can be added by writing a new `Visitor` implementation without touching any node class.

| Role | Class(es) |
|---|---|
| **Visitor** (interface) | `Visitor` — one `visit()` overload per node type |
| **Concrete Visitors** | `PrintVisitor`, `ExecutorVisitor` |
| **Element** (interface) | `Node` — declares `accept(Visitor, Object)` |
| **Concrete Elements** | `Program`, `Assignment`, `Read`, `Print`, `Sum`, `Product`, `Division`, `Variable`, `IntegerLiteral` |

**Why Visitor and not a recursive `instanceof` chain?**

`RecursivePrint.java` (included in the project) shows exactly the alternative: a single method with a long `if (node instanceof X) ... else if (node instanceof Y) ...` chain. It works, but adding a new node type requires modifying that method. The `IdealPrint.java` file shows the approach that would feel most natural — overloaded `visit()` methods dispatched by argument type — and explains why it doesn't compile: Java only dispatches on the static type, not the runtime type, so `visit(Node)` would always be called. The Visitor pattern works around this limitation using double dispatch: the node's `accept()` resolves the concrete type, then calls the correctly overloaded `visit()` on the visitor.

---

## Language

The supported language has four statement types and four expression types:

| Construct | Syntax | Example |
|---|---|---|
| Read | `read <var>;` | `read ancho;` |
| Assignment | `<var> = <expr>;` | `area = alto * ancho / 2;` |
| Print | `print <expr>;` | `print area + 10;` |
| Sum | `<expr> + <expr>` | `area + 10` |
| Product | `<expr> * <expr>` | `alto * ancho` |
| Division | `<expr> / <expr>` | `prod / 2` |
| Variable | identifier | `area` |
| Integer literal | number | `2`, `10` |

---

## Project Structure

```
src/main/java/es/uniovi/eii/ds/
├── main/
│   └── Main.java                        # Builds the AST manually and runs both visitors
└── interpreter/
    ├── Visitor.java                     # Visitor interface: one visit() per node type
    ├── PrintVisitor.java                # Reconstructs the source code from the AST
    ├── ExecutorVisitor.java             # Executes the program (stores variables, reads stdin)
    ├── RecursivePrint.java              # Alternative without Visitor (instanceof chain)
    ├── IdealPrint.java                  # Commented out — shows why multiple dispatch fails in Java
    └── ast/
        ├── Node.java                    # Element interface: accept(Visitor, Object)
        ├── Statement.java               # Marker interface for statements
        ├── Expression.java              # Marker interface for expressions
        ├── Program.java                 # List of statements
        ├── Assignment.java              # variable = expression
        ├── Read.java                    # read variable
        ├── Print.java                   # print expression
        ├── Sum.java                     # left + right
        ├── Product.java                 # left * right
        ├── Division.java                # left / right
        ├── Variable.java                # Named variable reference
        └── IntegerLiteral.java          # Integer constant
```

---

## Example

The program built in `Main.java`:

```
read ancho;
read alto;
area = alto * ancho / 2;
print area + 10;
```

Running it produces:

```
--- Recursive print
read ancho;
read alto;
area = alto * ancho / 2;
print area + 10;

--- Print with Visitor
read ancho;
read alto;
area = alto * ancho / 2;
print area + 10;

--- Execution
> 4
> 6
22
```

---

## Running

Requires Java 11+ and Maven 3.6+.

```bash
mvn compile
mvn exec:java
```

The program will prompt for two integers (`ancho` and `alto`) and print the result.