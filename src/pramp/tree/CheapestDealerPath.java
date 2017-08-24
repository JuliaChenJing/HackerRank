package pramp.tree;
class CheapestDealerPath {

	/*
	 * 
	 * https://www.pramp.com/question/15oxrQx6LjtQj9JK9XqA
	 * 
	 * The car manufacturer Honda holds their distribution system in the form of
	 * a tree (not necessarily binary). The root is the company itself, and
	 * every node in the tree represents a car distributor that receives cars
	 * from the parent node and ships them to its children nodes. The leaf nodes
	 * are car dealerships that sell cars direct to consumers. In addition,
	 * every node holds an integer that is the cost of shipping a car to it.
	 * 
	 * 
	 */

	static int getCheapestCost(Node rootNode) {

		if (rootNode == null)
			return 0;

		if (rootNode.children == null || rootNode.children.length == 0)
			return rootNode.key;
		else {
			// initialize minCost to the largest integer in the system
			int minCost = Integer.MAX_VALUE;
			for (int i = 0; i < rootNode.children.length; i++) {
				int tempCost = getCheapestCost(rootNode.children[i]);
				if (tempCost < minCost)
					minCost = tempCost;
			}

			return minCost + rootNode.key;
		}

	}

	static int minSum = Integer.MAX_VALUE;

	int getCheapestCostWithRecurtion(Node rootNode) {
		if (rootNode == null)
			return 0;

		getCheapestCostHelper(rootNode, 0);

		return minSum;
	}

	static void getCheapestCostHelper(Node rootNode, int sum) {

		if (rootNode == null)
			return;

		if (rootNode.children == null) {// leaf node
			if (minSum > sum)
				minSum = sum;
		}

		for (Node node : rootNode.children) {
			getCheapestCostHelper(node, node.key + sum);
		}

	}

	static class Node {

		int key;
		Node[] children;
		Node parent;

		Node(int cost) {
			key = cost;
			children = null;
			parent = null;
		}
	}
}