### **문자 하나씩 2차원 배열에 담기**

[https://m.blog.naver.com/ruvendix/220953194013](https://m.blog.naver.com/ruvendix/220953194013)

```cpp
vector<string> v(size)

for(int i = 0; i < size; i++) {
	cin >> v[i];                   // HHT를 string으로 받는다
}
```

입력

```cpp
HHT
THH
THT
```

출력

```cpp
for(int i = 0; i < size; i++) {
	for(int j = 0; j < size; j++) {
		printf("%c", v[i][j]);        // string HHT를 하나의 인덱스로 받아 char로 출력한다
	}
}
```

**scanf**

- 띄어쓰기, \n모두 읽는다

**cin**

- 띄어 쓰기에서 자른다
- \n도 함께 읽는다

**getline**

- \n전까지 읽는다
- `scanf("%[^/n]")`와 동일

![https://s3-us-west-2.amazonaws.com/secure.notion-static.com/e79b856d-23ce-48d8-a1e2-184a944c0d9d/Untitled.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/e79b856d-23ce-48d8-a1e2-184a944c0d9d/Untitled.png)

### 브루트포스: 비트마스크

모든 경우를 for문으로 돌리기에 너무 많을 경우
앞,뒤 등 두가지의 경우가 있는 경우

1. **3개의 동전을 뒤집는 조합의 수**
    - 첫번재 동전 : 2가지
    - 두번째 동전 : 2가지
    - 세번째 동전 : 2가지

    총 2*2*2 = 2^3가지

    비트마스크로 표시하면 1<<2 -1 = 2^3 - 1

    ```jsx
    000
    001
    010
    100
    011
    101
    111
    ```

2. **두번째 세번째 동전을 뒤집을 것이라는 전재하에, 3개의 동전을 한번에 하나씩 뒤집어 일치하는 조합의 수**

    두번째 세번째 동전이 뒤집는 경우

    ```jsx
    011 = 3
    ```

    3개의 동전을 하나씩 뒤집는 경우

    ```jsx
    000
    001
    010
    100
    ```

    1 & (1 << 3)

    ```jsx
    011 & 000 = 000 
    011 & 001 = 001 = 2 -> 가능한 경우
    011 & 010 = 010 = 4 -> 가능한 경우
    011 & 100 = 000 
    ```