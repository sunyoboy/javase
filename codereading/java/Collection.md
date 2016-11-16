# Collection
1. Map
2. List
3. Set
4. Queue

## Map
 * HashMap * 
       (如果没有其他的限制，HashMap应该成为默认选项，因为它对速度进行了优化，其他实现强调了其他的特性，因此都不如HashMap快)
 * TreeMap
 * LinkedHashMap
 * WeakHashMap
 * ConcurrentHashMap
 * IdentityHashMap

## Note

**默认的Object.equals()只是比较对象的地址，因此要使用自定义的类作为HashMap的键，必须
  同时重载hashCode()和equals().**

## List

## Set

## Queue(队列)
  不支持并发
 * LinkedList
 * PriorityQueue
  差异：排序行为，而不是性能