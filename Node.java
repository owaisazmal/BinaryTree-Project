public class Node implements Comparable<Node>
{
    int weight;
    char value;
    int intvalue;
    Node left;
    Node right;

    public int get_intValue()
    {
        return intvalue;
    }
    
    public char get_Value()
    {
        return value;
    }


    Node(char value, int w) {
        this.value = value;
        intvalue = 0;
        weight = w;
        right = null;
        left = null;
    }

    Node(int value, int w) {
        this.intvalue = value;
        value=' ';
        weight = w;
        right = null;
        left = null;
    }

    @Override
    public int compareTo(Node other) {
        // Compare by age
        return Integer.compare(weight, other.weight);
    }
}