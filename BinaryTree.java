//Devaansh Mann
//Binary Tree Project
//April 2, 2023


import java.util.PriorityQueue;

import tools.Colors;
import tools.Controls;

public class BinaryTree {
    
    int[][] AdjacencyMatrix = new int[25][25];
    public Node root;

    private Node addRecursive(Node current, int value) {
        if (current == null) {
            return new Node(value,0);
        }
    
        if (value < current.intvalue) {
            current.left = addRecursive(current.left, value);
        } else if (value > current.intvalue) {
            current.right = addRecursive(current.right, value);
        } else {
            // value already exists
            return current;
        }
    
        return current;
    }

    public void Insert(int value) {
        root = addRecursive(root, value);
    }

    private boolean containsNodeRecursive(Node current, int value) {
        if (current == null) {
            return false;
        } 
        if (value == current.value) {
            return true;
        } 
        return value < current.value
          ? containsNodeRecursive(current.left, value)
          : containsNodeRecursive(current.right, value);
    }

    public boolean containsNode(int value) {
        return containsNodeRecursive(root, value);
    }

    private int findSmallestValue(Node root) {
        return root.left == null ? root.value : findSmallestValue(root.left);
    }

    private Node deleteRecursive(Node current, int value) {
        if (current == null) {
            return null;
        }
    
        if (value == current.value) 
        {
            if (current.left == null && current.right == null) {
                return null;
            }
            if (current.right == null) {
                return current.left;
            }
            
            if (current.left == null) {
                return current.right;
            }  

            int smallestValue = findSmallestValue(current.right);
            current.intvalue = smallestValue;
            current.right = deleteRecursive(current.right, smallestValue);
            return current;

        } 
        if (value < current.value) {
            current.left = deleteRecursive(current.left, value);
            return current;
        }
        current.right = deleteRecursive(current.right, value);
        return current;
    }

    public void delete(int value) {
        root = deleteRecursive(root, value);
    }

    public void traverseInOrder(Node node) {
        if (node!= null)
        {   
            traverseInOrder(node.left);
            System.out.print("-->" + node.get_intValue());
            traverseInOrder(node.right);
        }
    }

    public void traversePreOrder(Node node) {
        if (node != null)
        { 
            System.out.print("-->" + node.get_intValue());
            traversePreOrder(node.left);
            traversePreOrder(node.right);
        }
    }
    
    public void traversePostOrder(Node node) {
        if (node != null) 
        {
            traversePostOrder(node.left);
            traversePostOrder(node.right);
            System.out.print("-->" + node.get_intValue());
        }
    }

    public void printnodes(Node node,int x, int y, int w, int h)
    {
        if (node != null) 
        {
            Controls.Box(x-2,y-1,6,3,91,Colors.RED,Colors.WHITE_BACKGROUND);
            Controls.SetForegroundBackgroundColor(Colors.WHITE,Colors.RED_BACKGROUND+ "");
            Controls.printxy(x,y,node.get_intValue());
            Controls.SetForegroundBackgroundColor(Colors.BLACK,Colors.WHITE_BACKGROUND+"");

            if(node.left!=null){
                Controls.Box(x-12,y+1,6,3,91,Colors.BLACK,Colors.BLACK_BACKGROUND);
                Controls.SetForegroundBackgroundColor(Colors.WHITE ,Colors.BLACK_BACKGROUND+ "");
                Controls.SetForegroundBackgroundColor(Colors.WHITE,Colors.BLACK_BACKGROUND+"/");
            }
            if(node.right!=null){
                Controls.Box(x+5,y+3,1,1,91,Colors.BLACK,Colors.BLACK_BACKGROUND);
                Controls.SetForegroundBackgroundColor(Colors.WHITE,Colors.BLACK_BACKGROUND+ "");
                Controls.SetForegroundBackgroundColor(Colors.WHITE,Colors.BLACK_BACKGROUND+"\\");
            }
            printnodes(node.left,x - (w/2),y + (h/2), w, h);
            printnodes(node.right,x + (w/2),y + (h/2), w, h);

        }
    }

    public void printnodesWeightAndChar(Node node, int x, int y, int w, int h)
    {
        if (node != null) 
        {
            Controls.SetForegroundBackgroundColor(Colors.WHITE,Colors.RED_BACKGROUND);
            Controls.printxy(x,y,node.weight);
            Controls.printxy(x,y+1,node.value);
            Controls.SetForegroundBackgroundColor(Colors.WHITE,Colors.BLACK_BACKGROUND);
            printnodesWeightAndChar(node.left,x - (w/2),y + (h/2), w, h);
            printnodesWeightAndChar(node.right,x + (w/2),y + (h/2), w, h);
        }
    }

    public void PrintQueueTree(PriorityQueue<Node> Q2)
    {
        int x,y;
        x = 10;
        y = 1;
        
        Controls.cls();

        while (Q2.isEmpty()) 
        {
            Node p = Q2.peek();          
            printnodesWeightAndChar(p, x, y, 20, 15);
            x = x + 25;    
        }
    }


    public void PrintQueueTree2(PriorityQueue<Node> Q3)
    {
        int a,b;
        a = 10;
        b = 1;
        
        Controls.cls();

        while (!Q3.isEmpty()) 
        {
            Node p = Q3.peek();          
            printnodesWeightAndChar(p, a, b, 20, 15);
            a = a + 25;    
        }
    }

    public void FillAdjacencyMatrix(Node pntr)
    {
        if (pntr == null) 
        {
            return;    
        }

        if (pntr.left != null) 
        {
            AdjacencyMatrix[pntr.get_intValue()][pntr.left.get_intValue()] = 1;    
        }

        if (pntr.right != null) 
        {
            AdjacencyMatrix[pntr.get_intValue()][pntr.right.get_intValue()] = 1;    
        }

        FillAdjacencyMatrix(pntr.left);
        FillAdjacencyMatrix(pntr.right);

    }

    
    public void PrintAdjacencyMatrix()
    {
        FillAdjacencyMatrix(root);

        System.out.print("    ");
        for (int i=0; i< AdjacencyMatrix.length; i++){
            if (i<10)
            System.out.print(i + "  ");
            else
            System.out.print(i + " ");
        } 
        System.out.println("");



        for (int i=0; i< AdjacencyMatrix.length; i++)
        {
            if (i<10)
            System.out.print(i + ":  ");
            else
            System.out.print(i + ": ");
            for (int j=0; j< AdjacencyMatrix.length; j++)
            {
              System.out.print(AdjacencyMatrix[i][j]+ "  ");
            }
            System.out.println("");
        }

    }

    
    
    public void CreateNodes()
    {
        PriorityQueue<Node> Q = new PriorityQueue<Node>();
        
        Q.add(new Node('A',5));
        Q.add(new Node('Z',1));
        Q.add(new Node('X',9));
        Q.add(new Node('T',2));
        Q.add(new Node('R',13));


        while (Q.size() != 1) 
        {
            Node p = Q.poll();
            Node p2 = Q.poll();
            Node newNode = new Node(0, p.weight + p2.weight);
            newNode.left = p;
            newNode.right = p2;
            Q.add(newNode);
            PrintQueueTree(Q); 
            PrintQueueTree2(Q);   
        }


    }
    



    public void DisplayTree()
    {
        System.out.print("\u001B[40m");  // set background color to black
       
        Controls.cls();
        
        System.out.println("\t\t\tBINARY TREE: ");
        printnodes(root,70,5,20,10);
        System.out.println();
        System.out.println();

        System.out.println();
        System.out.println();
        System.out.println();

        System.out.println();
        System.out.println();
        System.out.println();

        System.out.println();
        System.out.println();
        System.out.println();

        System.out.println();
        System.out.println();
        System.out.println();

        System.out.print("In order traverse: ");
        traverseInOrder(root);
        System.out.println();
        System.out.println();

        System.out.print("Pre order traverse: ");
        traversePreOrder(root);
        System.out.println();
        System.out.println();
        
        System.out.print("Post order traverse: ");
        traversePostOrder(root);
        System.out.println();
        System.out.println();
        
        System.out.println();
        System.out.println();
        System.out.println();


        System.out.println("Adjacency Matrix for the Binary Tree");
        System.out.println();
        PrintAdjacencyMatrix();

        
       
       
    }    


}

