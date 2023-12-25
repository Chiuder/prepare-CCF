import java.util.HashMap;

/**
 * @BelongsPackage: PACKAGE_NAME
 * @Description:
 * @author: Chiuder
 * @create: 2023-03-04 16:38
 */
//实现LRU缓存机制（hashmap + 双向链表）
public class LRUCache {
    //首先定义双向链表节点结构
    class DLinkNode {
        int key;
        int value;
        DLinkNode prev;
        DLinkNode next;

        public DLinkNode() {}

        public DLinkNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    //然后定义hashmap，双向链表及其容量，并实现几个LRU需要的API接口方法
    private HashMap<Integer, DLinkNode> cache = new HashMap<Integer, DLinkNode>();
    private int size;//当前缓存长度
    private int capacity;//定义的缓存容量
    private DLinkNode head, tail; // 使用伪头部和伪尾部节点

    //添加节点到链表头部(在伪头节点的后面)
    private void addToHead(DLinkNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    //删除链表中的一个节点
    private void removeNode(DLinkNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    //移动链表中某个节点到链表头部（伪头节点后面）
    private void moveToHead(DLinkNode node) {
        removeNode(node);
        addToHead(node);
    }

    //删除链表最后一个节点（伪尾节点前面那个节点）
    private DLinkNode removeTail() {
        DLinkNode res = tail.prev;
        removeNode(res);
        return res;
    }

    //初始化缓存（双向链表）
    public LRUCache(int capacity) {
        size = 0;
        this.capacity = capacity;
        head = new DLinkNode();
        tail = new DLinkNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        //先通过哈希表定位
        DLinkNode node = cache.get(key);
        //如果key不存在
        if (node == null)
            return -1;
        //如果key存在，就找到了那个节点，再将那个节点移动到链表头部
        moveToHead(node);
        //返回找到的那个节点的value
        return node.value;
    }

    public void put(int key, int value) {
        //先通过哈希表定位
        DLinkNode node = cache.get(key);
        if (node == null) {
            // 如果 key 不存在，创建一个新的节点
            DLinkNode newNode = new DLinkNode(key, value);
            //先添加进hashmap
            cache.put(key, newNode);
            //然后添加至双向链表的头部，也就是伪头节点的后面
            addToHead(newNode);
            ++size; //链表长度+1
            if (size > capacity) {
                // 如果超出容量，删除双向链表的尾部节点
                DLinkNode delNode = removeTail();
                // 删除哈希表中对应的项
                cache.remove(delNode.key);
                --size;
            }
        } else {
            // 如果 key 存在，先通过哈希表定位，再修改 DLinkNode中的 value，并移到链表头部
            node.value = value;
            moveToHead(node);
        }
    }
}
