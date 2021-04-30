1. python 数字字符 asicll 码相互转换  
    1. ord() 数字字符 -> asicll
    2. chr() asicll -> 数字字符
2. 取列表出现次数最多的数字 maxlabel = max(a,key=a.count)
3. 去除字符串中的空格 ''.join(s.split(" "))
4. 记忆化递归 
    1. 导入 from functools import lru_cache
    2. 函数前加上 @lru_cache(size), @lru_cache(None) 使用默认的缓存大小
    3. fun_name.cache_clear()  缓存清除
5. python 浮点数的精度问题解决方案 
    1. from fractions import Fraction 
    2. Fraction(A,B) 求A/B,直接用分数表示
6. Python中的一些数学处理公式 https://www.codenong.com/cs106984924/
7. python 自定义排序规则 
    1. from functools import cmp_to_key 
    2. cmp_key = cmp_to_key(compare)
    3. nums.sort(key = cmp_key, reverse=True)
8. python 二分查找相关方法 bisect_left bisect_right insort_left insort_right
    
```
例子：查找元素出现的位置
        def index(ls, tar):
            i = bisect_left(ls, tar)
            if i != len(ls) and ls[i] == x:
                return i
            else:
                return -1
```

9. any(<list>)，all(<list>)，sum(<list>)
10. s.isalpha(), s.isalnum(), s.islower(), s.isupper(), s.isdigit(), istitle()
    1. isalpha 判断是否字母
    2. isalnum 判断是否数字和字母的组合
    3. isdigit 判断是否数字
    4. 字符串.istitle() 所有单词都是首字母大写，为真返回 Ture，否则返回 False
11. 合并两个有序列表技巧,可以直接使用堆  result = [i * i for i in heapq.merge(ls1, ls2)]
12. python 队列 deque，常用方法 append appendleft  pop  popleft
13. python计算阶乘  math.factorial(num)
14. py求最大公约数 
    
```
class Solution:
    def gcf(x, y) -> int:
        while y:
            x, y = y, x % y
        return x
```
15. py中插入删除均为 logN的有序结构 
    1. from sortedcontainers import SortedList
16. py求对数 import numpy as np 
    1. np.log(x) 以e为底的对数(自然对数)
    2. np.log10(x) 以10为底的对数
    3. np.log2(x) 以2为底的对数
    4. np.log1p(x) 等价于：np.log(x + 1)
18. py求中位数
    1. #均值 np.mean(nums)
    2. #中位数 np.median(nums)
19. itertools 库里有很多实用的枚举姿势
    
```
from itertools import permutations, combinations, product
permutations(list, r = len(list))        # list 里长度为 r 的所有排列
combinations(list, r)                    # list 里长度为 r 的所有组合
product(list1, list2, ...)               # 所有 list 的笛卡尔积
```
20. 常见的私有方法
    1. __doc__	描述信息，即定义开头长注释里的字符串；可用于模块、函数、类。
    2. __new__，__init__	前者用于类对象的创建（静态方法），后者用于对象的初始化（实例方法）。前者必须要给出返回值（对象），作为后者的第一个参数。
    3. __del__	类的析构函数
    4. __module__，__class__	前者表示对象所在模块，后者表示对象所属的类
    5. __dict__	类或对象中的所有成员（dict 形式）
    6. __str__	类需要转为字符串时（比如打印该对象）触发，类似于 Java 的 toString
    7. __call__	当对象后面接 () 后会触发
    8. __getitem__	当对象后面接 [] 后会触发
    9. __setitem__，__delitem__	连同上面的 __getitem__，使类像 dict 一样使用
    10. __iter__， __next__	使该类变得可迭代，可以用 for ... in ... 遍历

21. ~(num ^ 0xffffffff) 假如num > max_int，将 num 转为负数表示的方法
22. 









