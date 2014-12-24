package word.vector.common;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;

/**
 * 哈夫曼树
 * 
 * @author wanggang
 *
 */
public class HuffmanTree {

	//    private TreeSet<HuffmanNode> tree = new TreeSet<HuffmanNode>();

	public static void make(Collection<? extends HuffmanNode> nodes) {
		TreeSet<HuffmanNode> tree = new TreeSet<>(nodes);
		while (tree.size() > 1) {
			HuffmanNode left = tree.pollFirst();
			HuffmanNode right = tree.pollFirst();
			HuffmanNode parent = left.merge(right);
			tree.add(parent);
		}
	}

	public static List<HuffmanNode> getPath(HuffmanNode leafNode) {
		List<HuffmanNode> nodes = new ArrayList<>();
		for (HuffmanNode hn = leafNode; hn != null; hn = hn.getParent()) {
			nodes.add(hn);
		}
		Collections.reverse(nodes);

		return nodes;
	}

}