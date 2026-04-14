# Shelf Sort Algorithm

![Java](https://img.shields.io/badge/Java-8%2B-ED8B00?style=flat-square&logo=openjdk&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-3.x-C71A36?style=flat-square&logo=apache-maven&logoColor=white)
![License](https://img.shields.io/github/license/R-Alothaim/ShelfSort?style=flat-square)
![Tests](https://img.shields.io/badge/tests-passing-brightgreen?style=flat-square)

A custom integer sorting algorithm that leverages a multi-dimensional array structure (the "shelf") to categorize numbers by digit length, handle duplicates via insertion sort, and merge them back into a single sorted sequence -- achieving **O(n) time** when there are no duplicates.

---

## Table of Contents

- [Algorithm Overview](#algorithm-overview)
- [Complexity](#complexity)
- [Architecture](#architecture)
- [Getting Started](#getting-started)
- [Example](#example)
- [Documentation](#documentation)
- [Contributing](#contributing)
- [License](#license)
- [Author](#author)

---

## Algorithm Overview

ShelfSort operates in three distinct phases:

### 1. Categorization

Each element is placed into a slot within a two-dimensional array (the "shelf") based on its digit length. Numbers with 1-2 digits share one row, while numbers with 3+ digits are placed into rows corresponding to their length. The column index is derived from the number's value, which means each number is placed directly into its sorted position within its row.

### 2. Duplicate Handling

When a number is encountered that already occupies its designated slot, it is identified as a duplicate. Duplicates are collected into a separate array and kept in sorted order using an **insertion sort** approach as they are added.

### 3. Merge

The algorithm walks through each row of the shelf in order, pulling out non-empty values. As it reconstructs the original array, it checks the duplicate list and inserts any matching duplicates at the correct position. The result is a fully sorted array.

---

## Complexity

| Metric | Complexity |
|---|---|
| **Time (Best Case)** | O(n) -- no duplicates; each element is placed and retrieved in constant time |
| **Time (Average Case)** | O(n + k^2) -- where k is the number of duplicate elements |
| **Time (Worst Case)** | O(n^2) -- all elements are duplicates; insertion sort dominates |
| **Space** | O(n * d) -- where d is the number of distinct digit lengths |

---

## Architecture

```
Shelf-Sorting-Algorithm/
├── pom.xml
├── LICENSE
├── README.md
├── .editorconfig
├── .gitattributes
├── .gitignore
├── docs/
│   └── ALGORITHM.md
└── src/
    ├── main/
    │   └── java/
    │       └── com/
    │           └── shelfproject/
    │               ├── ShelfSort.java            # Core algorithm (sort + merge)
    │               ├── ShelfSortDemo.java         # Demo with example usage
    │               └── util/
    │                   └── ArrayUtils.java        # Array formatting and generation helpers
    └── test/
        └── java/
            └── com/
                └── shelfproject/
                    ├── ShelfSortTest.java         # Unit tests
                    └── ShelfSortBenchmark.java    # Performance benchmarks
```

---

## Getting Started

### Prerequisites

- **Java** 8 or higher
- **Apache Maven** 3.x

### Build

```bash
git clone https://github.com/R-Alothaim/ShelfSort.git
cd ShelfSort
mvn compile
```

### Run the Demo

```bash
mvn exec:java -Dexec.mainClass="com.shelfproject.ShelfSortDemo"
```

### Run Tests

```bash
mvn test
```

### Run Benchmarks

```bash
mvn test -Dtest=ShelfSortBenchmark
```

---

## Example

**Input:**
```
[3, 4, 3, 11, 23, 4421, 2, 11, 2]
```

**Output:**
```
[2, 2, 3, 3, 4, 11, 11, 23, 4421]
```

---

## Documentation

For a detailed explanation of the algorithm, including phase-by-phase breakdown, complexity analysis, and limitations, see [docs/ALGORITHM.md](docs/ALGORITHM.md).

---

## Contributing

Contributions are welcome. Please open an issue first to discuss what you would like to change, then submit a pull request.

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/my-feature`)
3. Commit your changes (`git commit -m 'Add my feature'`)
4. Push to the branch (`git push origin feature/my-feature`)
5. Open a Pull Request

---

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

---

## Author

**R-Alothaim** -- [GitHub](https://github.com/R-Alothaim)
