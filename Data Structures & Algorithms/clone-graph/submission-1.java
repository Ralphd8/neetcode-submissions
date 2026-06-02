/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null){return null;}
        HashMap<Node,Node> map = new HashMap<>();

        Queue<Node> q = new LinkedList<>();

        q.add(node);
        Node n = new Node(node.val);
        map.put(node,n);

        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                Node nd = q.poll();
                for(Node nei : nd.neighbors){
                    if(!map.containsKey(nei)){
                        Node nw = new Node(nei.val);
                        map.put(nei,nw);
                        q.add(nei);
                    }
                    map.get(nd).neighbors.add(map.get(nei));
                }
            }
        }

        return map.get(node);
    }
}