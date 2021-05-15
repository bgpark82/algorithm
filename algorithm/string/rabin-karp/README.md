# Rabin Karp

- text와 pattern의 각 문자의 해시값을 비교하여 패턴을 찾는다
- text에서 다음 pattern의 크기만큼 옮길 때 rolling hash 알고리즘을 사용한다 (O(1))
- 시간 복잡도
  - 최소 : O(n+m) 
  - 최대 : O(n^2)
- [Rabin Karp](https://www.geeksforgeeks.org/rabin-karp-algorithm-for-pattern-searching/)
- [Stable Sort(Youtube)](https://www.youtube.com/watch?v=BfUejqd07yo)