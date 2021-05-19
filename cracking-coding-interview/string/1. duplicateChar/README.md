# Question 1

1. 문자열은 **char의 배열**이다.
2. 각 **char는 ascii 코드와 매칭**이 된다
### 자료구조
- ascii의 경우, **크기 127인 배열**로 표현가능하다
- extend ascii의 경우, **크기 256인 배열로** 표현이 가능하다
- bit mask로 해당 ascii의 자리수가 있는지 판별 가능하다
## Check point

Ask to interviewer
- Is string an ASCII string or Unicode string
- ASCII need a total 128 storage size
- Extended ASCII need a total 256 storage size
- [ASCII vs Unicode](https://whatisthenext.tistory.com/103)

### ASCII
- 128 characters
- Only Enlish
- It has a lowercase, uppercase letter and symbols
- Its character code are 7bit long

### Extended ASCII
- 256 characters
- its character code are 8bit long

### Unicode
- Wide range of characters
- Supports different languages
- 8bit, 16bit or 32bit depending on encoding type

## Attempt

### 1. boolean array

You should check
- It only takes **true and false**
- You can also return false immediately
- If you use an array, you must check this **index out of bound**

Time Complexity
- `O(n)`
- Length of string
- If it was an int array, it could have been `O(n^2)` (Length of string x int array size) 
  
Space Complexity
- `O(1)`
- fixed size boolean array in heap (one address)

### 2. bit vector

You should check
- bit vector consists of 0 and 1 == boolean array
- It can be fill up with 1 from right to left
  - `1111`
- Check **each digits**
  - `111 & 10`, `111 & 100`, ...
- Add **each digits**
  -  `100 | 10`, `100 | 1`, ...

Time Complexity
- `O(n)`
- Length of string

Space Complexity
- `O(1)`
- Primitive int value

## Tips
```
3 & (1 << 2)  // 111 & 10 = 1 
5 & (1 << 2)  // 101 & 10 = 0 
```
- `3 & (1 << 2)` : the second 1 from behind exist
- `5 & (1 << 2)` : the second 1 from behind not exist

```
3 | (1 << 2)  // 111 | 10 = 1111 
5 | (1 << 2)  // 101 | 10 = 111
```
- `3 | (1 << 2)` : add 1 at second 1 from behind
- `5 | (1 << 2)` : add 1 at second 1 from behind

### In a nutshell
1. **boolean array == bit mask**
2. Use **add**(`|`), **check**(`&`) operation to check each index
