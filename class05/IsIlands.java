package NowCoder.class05;

/**
 *
 * 有关并查集应用的岛问题
 * 1.简单DFS
 * 2.当矩阵很大的时候，希望通过多台机器并行计算时，可以使用并查集进行优化：由于要使用多态机器计算，因此需要将矩阵进行切分，那么问题就是边界的处理
 * 当2等分的时候，使用2台机器分别计算左右部分的岛的数量，并且使用1个集合来记录每个岛是由哪个节点激发的，那么进行边界合并的时候，如果两边都是1，那么将各自的集合中的元素
 * 进行合并，然后总数量-1，下次勘察两边为1的部分是否在同一个集合中，是的话不-1，不是的话依然-1
 *
 */
public class IsIlands {
}
