# Shelf Sort Algorithm

## Overview

Shelf Sort is a custom integer sorting algorithm that achieves O(n) time complexity for arrays with no duplicate elements by leveraging a multi-dimensional array structure (the "shelf").

## How It Works

### Phase 1: Categorization

Numbers are placed into rows of a 2D array based on their digit length:
- Row 1: Numbers with 1-2 digits (0-99)
- Row 3: Numbers with 3 digits (100-999)
- Row 4: Numbers with 4 digits (1000-9999)
- ...and so on

Within each row, the number is placed at an index derived from its value, effectively sorting it into position.

### Phase 2: Duplicate Detection

When a number maps to a slot that is already occupied, it is identified as a duplicate. Duplicates are stored in a separate array and maintained in sorted order using insertion sort.

### Phase 3: Merge

The algorithm walks through each row of the shelf sequentially, collecting non-empty values. As it rebuilds the output array, it checks the duplicate list and inserts matching values at their correct positions.

## Complexity

| Case | Time | Space |
|------|------|-------|
| Best (no duplicates) | O(n) | O(n * d) |
| Average | O(n + k^2) | O(n * d) |
| Worst (all duplicates) | O(n^2) | O(n * d) |

Where:
- n = number of elements
- d = number of distinct digit lengths
- k = number of duplicate elements

## Limitations

- Only works with positive integers
- Maximum element value is constrained by the shelf array dimensions
- Space usage scales with the range of values, not just the count
