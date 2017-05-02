import java.util.*;

public class SerializeTree {
static class TreeNode {
      int data;
      TreeNode left;
      TreeNode right;
      TreeNode(int data, TreeNode left, TreeNode right) {
      this.data = data;
      this.left = left;
      this.right = right;
      }
  }

public static String serializeTree(TreeNode root){
    StringBuilder sb = new StringBuilder();
    serializeTreeHelper(root,sb);
    if(sb.length() > 0) sb.deleteCharAt(0);
    return sb.toString();
}

private static StringBuilder serializeTreeHelper(TreeNode t, StringBuilder sb){
    if(t == null) sb.append(",null");
    else {
        sb.append(","+t.data);
        serializeTreeHelper(t.left, sb);
        serializeTreeHelper(t.right, sb);
    }
    return sb;
}

public static TreeNode restoreTree(String str){
    String[] nodesSplit = str.split(",");
    LinkedList<String> nodesList = new LinkedList<>(Arrays.asList(nodesSplit));
    return restoreTreeHelper(nodesList);
}

public static TreeNode restoreTreeHelper(LinkedList<String> nodes){
    String nodeDataStr = nodes.remove();
    if(nodeDataStr.equals("null")) return null;
    TreeNode t = new TreeNode(Integer.valueOf(nodeDataStr), null, null);
    t.left = restoreTreeHelper(nodes);
    t.right = restoreTreeHelper(nodes);
    return t;
}

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, null, null);
        TreeNode cur = root;
        for (int i = 2; i < 51; i++) {
            TreeNode t = new TreeNode(i, null, null);
            cur.right = t;
            cur = t;
        }
        String s = serializeTree(root);
        System.out.println(s);
        System.out.println(serializeTree(restoreTree(s)));
    }
}
