# vector

### sequence container
* List in java = enable to change its size, size handle by container
* it grows the size when it needs to allocate more elements
* allocate new array and move all elements into
* but do not allocate each time
* so they prepare extra space for storage for the future
* constant time complexity anyway
* less heavier than array, but more efficient

### container
holding the collection object

### properties 
1. sequence : linear order
2. dynamic array : enable to change size dynamically (fast addition, removal)
3. allocator aware 

### constructor
```
vector<int> a;
vector<int> b(3);    // size : 3, element : 0
vector<int> c(3, 2); // size : 3, element : 2
vector<int> d(c);    // size : 3, element : 2
```
### function
**int**
```
d.size()     // length of vector
d.capacity() // size of allocated capacity of vector
d.at(0)
d[1]
d.front()
d.back()
```
**void**
```
d.assign(5, 2);
d.resize(10, 3);
d.clear();
d.push_back(5);
d.pop_back();
```
**iterator**
```
d.begin();
d.end();
d.rbegin();
d.rend();
```

### size vs capacity
```
vector<int> h;
for (int i = 0; i < 50; i++)
{
    h.push_back(i);
    cout << h[i] << ":" << h.size() << ":" << h.capacity() << endl;
}
```
* size : its size grows linear as insersion
* capacity : its size grow twice than previous capacity
  
result
```
0 0 0 
0:1:1
1:2:2
2:3:4
3:4:4
4:5:8
5:6:8
6:7:8
7:8:8
8:9:16
9:10:16
10:11:16
11:12:16
12:13:16
13:14:16
14:15:16
15:16:16
16:17:32
17:18:32
18:19:32
19:20:32
20:21:32
21:22:32
22:23:32
23:24:32
24:25:32
25:26:32
26:27:32
27:28:32
28:29:32
29:30:32
30:31:32
31:32:32
32:33:64
33:34:64
34:35:64
35:36:64
36:37:64
37:38:64
38:39:64
39:40:64
40:41:64
41:42:64
42:43:64
43:44:64
44:45:64
45:46:64
46:47:64
47:48:64
48:49:64
49:50:64
```



reference : [cplusplus.com](https://www.cplusplus.com/reference/vector/vector/)