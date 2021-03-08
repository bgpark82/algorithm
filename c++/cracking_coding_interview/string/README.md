# Question 1

## Check point

Ask to interviewer
    - Is string an ASCII string or Unicode string
    - ASCII need a total 128 storage size
    - Extended ASCII need a total 256 storage size
    - [ASCII vs Unicode](https://whatisthenext.tistory.com/103)

## Attempt

### 1. boolean array

You should check
    - It only takes true and false
    - You can also return false immediately
    - If you use an array, you must check this **index out of bound**

Time Complexity
    - O(n)
    - Length of string
    - If it was an int array, it could have been O(n^2) (Length of string x int array size) 
Space Complexity
    - O(1)
    - fixed size boolean array in heap (one address)