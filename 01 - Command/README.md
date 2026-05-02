# Lab 1: Virtual Machine

A stack-based virtual machine implemented in Java using the **Command design pattern**.

The VM reads a program from a text file, parses each line into an instruction object, and executes them sequentially.

---

## Design Pattern: Command

Each instruction is encapsulated as an object implementing the `Instruction` interface. This decouples the invoker (`Processor`) from the concrete operations, replacing the original monolithic `if-else` dispatch with a clean, extensible structure.

| Role | Classes |
|---|---|
| **Command** (interface) | `Instruction` |
| **Concrete Commands** | `InstructionAdd`, `InstructionSub`, `InstructionMul`, `InstructionPush`, `InstructionLoad`, `InstructionStore`, `InstructionInput`, `InstructionOutput`, `InstructionJmp`, `InstructionJmpg` |
| **Receiver** | `VirtualMachine` (holds stack, memory, processor) |
| **Invoker** | `Processor` (iterates the list and calls `execute()`) |
| **Client** | `VirtualMachine.loadSentence()` (parses lines and instantiates commands) |

---

## Project Structure

```
src/main/java/es/uniovi/eii/ds/
├── Instruction.java              # Command interface: execute(VirtualMachine vm)
├── VirtualMachine.java           # Receiver + Client
├── Processor.java                # Invoker
├── Memory.java                   # 1024-cell integer memory
├── MyStack.java                  # Integer stack (size 32)
└── instructions/
    ├── InstructionAdd.java
    ├── InstructionSub.java
    ├── InstructionMul.java
    ├── InstructionPush.java
    ├── InstructionLoad.java
    ├── InstructionStore.java
    ├── InstructionInput.java
    ├── InstructionOutput.java
    ├── InstructionJmp.java
    └── InstructionJmpg.java
```

---

## Instruction Set

| Instruction | Operand | Description |
|---|---|---|
| `push N` | integer | Pushes literal `N` onto the stack |
| `add` | — | Pops two values, pushes their sum |
| `sub` | — | Pops two values, pushes their difference |
| `mul` | — | Pops two values, pushes their product |
| `load` | — | Pops an address, pushes the value stored there |
| `store` | — | Pops a value and an address, writes value to memory |
| `input` | — | Reads an integer from stdin and pushes it |
| `output` | — | Pops a value and prints it |
| `jmp N` | line index | Unconditionally sets the instruction pointer to `N` |
| `jmpg N` | line index | Pops `b` then `a`; jumps to `N` if `a > b`, otherwise continues |

---

## Example: Factorial

The included `factorial.txt` computes `n!` for a user-supplied `n`:

```
push 0    # memory[0] = n (user input)
input
store

push 1    # memory[1] = index (starts at 1)
push 1
store

push 2    # memory[2] = result (starts at 1)
push 1
store

          # loop: if index > n, jump to end (line 28)
push 1
load
push 0
load
jmpg 28

          # result = result * index
push 2
push 2
load
push 1
load
mul
store

          # index = index + 1
push 1
push 1
load
push 1
add
store

jmp 9     # repeat loop

push 2    # print result
load
output
```

---

## Running

Requires Java 11+ and Maven 3.6+.

```bash
mvn compile
mvn exec:java
```

The program will prompt for an integer and print its factorial.
