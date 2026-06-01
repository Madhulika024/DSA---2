class AVLNode {
    int key, height;
    AVLNode left, right;

    AVLNode(int d) {
        key = d;
        height = 1;
    }
}

public class AVLDemo {

    AVLNode root;

    int height(AVLNode N) {
        return (N == null) ? 0 : N.height;
    }

    int getBalance(AVLNode N) {
        return (N == null) ? 0 :
                height(N.left) - height(N.right);
    }

    AVLNode rightRotate(AVLNode y) {
        AVLNode x = y.left;
        AVLNode T2 = x.right;

        x.right = y;
        y.left = T2;

        y.height = Math.max(height(y.left),
                height(y.right)) + 1;
        x.height = Math.max(height(x.left),
                height(x.right)) + 1;

        return x;
    }

    AVLNode leftRotate(AVLNode x) {
        AVLNode y = x.right;
        AVLNode T2 = y.left;

        y.left = x;
        x.right = T2;

        x.height = Math.max(height(x.left),
                height(x.right)) + 1;
        y.height = Math.max(height(y.left),
                height(y.right)) + 1;

        return y;
    }

    AVLNode insert(AVLNode node, int key) {

        if (node == null)
            return new AVLNode(key);

        if (key < node.key)
            node.left = insert(node.left, key);
        else if (key > node.key)
            node.right = insert(node.right, key);
        else
            return node;

        node.height = 1 + Math.max(
                height(node.left),
                height(node.right));

        int balance = getBalance(node);

        if (balance > 1 &&
                key < node.left.key)
            return rightRotate(node);

        if (balance < -1 &&
                key > node.right.key)
            return leftRotate(node);

        if (balance > 1 &&
                key > node.left.key) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        if (balance < -1 &&
                key < node.right.key) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    AVLNode minValueNode(AVLNode node) {
        AVLNode current = node;
        while (current.left != null)
            current = current.left;
        return current;
    }

    AVLNode deleteNode(AVLNode root, int key) {

        if (root == null)
            return root;

        if (key < root.key)
            root.left = deleteNode(root.left, key);

        else if (key > root.key)
            root.right = deleteNode(root.right, key);

        else {

            if ((root.left == null)
                    || (root.right == null)) {

                AVLNode temp;

                if (root.left != null)
                    temp = root.left;
                else
                    temp = root.right;

                if (temp == null) {
                    root = null;
                } else {
                    root = temp;
                }

            } else {

                AVLNode temp =
                        minValueNode(root.right);

                root.key = temp.key;

                root.right =
                        deleteNode(root.right,
                                temp.key);
            }
        }

        if (root == null)
            return root;

        root.height = Math.max(
                height(root.left),
                height(root.right)) + 1;

        int balance = getBalance(root);

        if (balance > 1 &&
                getBalance(root.left) >= 0)
            return rightRotate(root);

        if (balance > 1 &&
                getBalance(root.left) < 0) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }

        if (balance < -1 &&
                getBalance(root.right) <= 0)
            return leftRotate(root);

        if (balance < -1 &&
                getBalance(root.right) > 0) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }

        return root;
    }

    void inorder(AVLNode node) {
        if (node != null) {
            inorder(node.left);
            System.out.print(node.key + " ");
            inorder(node.right);
        }
    }

    public static void main(String[] args) {

        AVLDemo tree = new AVLDemo();

        int ids[] = {20,30,35,40,45,50,60,65,70,75,80,85,90};

        for(int id : ids)
            tree.root = tree.insert(tree.root,id);

        System.out.print("AVL Inorder before deletion: ");
        tree.inorder(tree.root);

        tree.root = tree.deleteNode(tree.root,30);
        tree.root = tree.deleteNode(tree.root,70);
        tree.root = tree.deleteNode(tree.root,50);

        System.out.print("\nAVL Inorder after deletion: ");
        tree.inorder(tree.root);
    }
}