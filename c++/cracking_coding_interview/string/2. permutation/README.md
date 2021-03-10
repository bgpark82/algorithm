### Permutation

## What you should ask
1. is it case sensitive?
2. whitespace does matter?

## Condition to be premutation
1. The same length
2. The same character, but different order
3. Two words with the same number of characters

## Solution
1. first solution
    - The same length
    - The same character, but different order
```
bool isPermutation(string &origin, string &target)
{
    sort(origin.begin(), origin.end());
    sort(target.begin(), target.end());

    // the same size
    if (origin.length() != target.length())
    {
        return false;
    };

    // the same character
    bool ans = origin == target;
    
    return ans;
};
```
- Time complexity : `O(n)`

2. second solution
    - Two words with the same number of characters
```
bool isPermutation(string origin, string target)
{
    sort(origin.begin(), origin.end());
    sort(target.begin(), target.end());

    // the same size
    if (origin.length() != target.length())
    {
        return false;
    };

    // the same character
    bool ans = origin == target;
    
    return ans;
};
```
- It is only valid when character is an ASCII code;
- Time complexity : `O(n)`

## Tips
```
bool ans = origin == target;
```
- It was possible to `==` compare in c++ not like Java
- If you still want to compare without `==`, you should use compare method()
```
string a = "aaaaa";
string b = "aaa";

cout << a.compare(b) << endl;  // 1
cout << b.compare(a) << endl;  // -1
```
- if result is 0, then both strings are equal
- if result is greater than 0, then origin is less than target
- if result is less than 0, then origin is larger than target

```
int arr[128] = {0}
```
initialize with 0 values in array