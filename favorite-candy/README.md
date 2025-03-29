# Flipping Favorites

## Overview
In the magical Land of Snacks, every child has a favorite snack, represented by a number. However, debates arise over which snack is the best. To make things fair and fun, the children devised a game where they "flip" their favorite snack numbers following a simple rule.

## Problem Statement
Each child’s favorite snack number changes at the end of the day:
- If the favorite snack number is less than the maximum snack number `k`, it increments by `1`.
- If the favorite snack number is already at `k`, it resets back to `1`.

Your task is to determine the new favorite snack numbers after applying this flipping rule for one day.

## Input Format
- The first line contains two integers `n` and `k`:
  - `n` — the number of children.
  - `k` — the maximum snack number.
- The second line contains `a` space-separated integers representing the initial favorite snack numbers of the children.

## Constraints
- `1 <= n <= 100`
- `1 <= k <= 100`
- `1 <= a <= k`

## Output Format
- Output `n` space-separated integers representing the new favorite snack numbers of the children after flipping.

## Sample Input & Output
### Example 1
#### Input:
```
5 4
1 2 3 4 2
```
#### Output:
```
2 3 4 1 3
```

### Example 2
#### Input:
```
3 5
5 5 1
```
#### Output:
```
1 1 2
```

## License
This problem statement is intended for educational and problem-solving purposes.