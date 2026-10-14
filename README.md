# java-dsa

Data structures and algorithms practice in Java, grouped by pattern. Each solution file starts with the problem link, its pattern, its time and space complexity, and the one idea that cracks it, followed by my own test cases.

## Layout

| Folder | Pattern |
| --- | --- |
| `01-hash-maps` | Hash maps and counting |
| `02-two-pointers` | Two pointers |
| `03-sliding-window` | Sliding window |
| `04-prefix-sums` | Prefix sums |
| `05-sorting-greedy-intervals` | Sorting, greedy and intervals |
| `06-stacks` | Stacks |
| `07-binary-search` | Binary search |
| `08-grids-matrices` | Grids and matrices |
| `09-dynamic-programming` | Dynamic programming |
| `10-heaps` | Heaps and top K |
| `11-implementation-parsing` | Implementation and string parsing |
| `12-linked-lists` | Linked lists |
| `13-trees` | Trees |
| `14-graphs` | Graphs |
| `15-backtracking` | Backtracking |

Folders appear as problems are added.

## Run a solution

Each file runs on its own with Java 21, no build tool needed:

```bash
java 01-hash-maps/P0001TwoSum.java
```

It prints PASS or FAIL for each test case in `main`.

## Add a problem

```bash
python3 tools/new_problem.py 01-hash-maps 1 "Two Sum" Easy https://leetcode.com/problems/two-sum/
```

That creates `01-hash-maps/P0001TwoSum.java` from `templates/ProblemTemplate.java` with the header filled in. After solving, fill in Time, Space and Idea, then refresh the table below:

```bash
python3 tools/build_index.py
```

## Index

<!-- INDEX:START -->
| # | Problem | Difficulty | Pattern | Time | Space | Solved |
| --- | --- | --- | --- | --- | --- | --- |
<!-- INDEX:END -->
