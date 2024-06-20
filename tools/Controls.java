package tools;

public class Controls {
    public static void cls()
    {
                // cls
        System.out.print("\033[H\033[2J");  
        System.out.flush(); 
    }
    
    public static void printxy(int col, int row, String val)
    {
        char escCode = 0x1B;
        System.out.print(String.format("%s[%d;%df",escCode,row,col));
        System.out.print(val);
    } 

    public static void printxy(int col, int row, int val)
    {
        char escCode = 0x1B;
        System.out.print(String.format("%s[%d;%df",escCode,row,col));
        System.out.print(val);
    } 
    
    public static void printxy(int col, int row, char val)
    {
        char escCode = 0x1B;
        System.out.print(String.format("%s[%d;%df",escCode,row,col));
        System.out.print(val);
    } 

    public static void SetForegroundBackgroundColor(String f, String b)
    {
        System.out.print(f+b+"");
    }

    public static final char getAscii(int code) 
    {
            return Symbols.EXTENDED[code];
    }

    public static void Box(int x, int y, int w, int h, int ascii, String fcolor,String bcolor)
    {
        char val = getAscii(ascii);
        for (int i=0; i < w; i++)
        {
            for (int j=0; j< h; j++)
            {                
                printxy(x+i,y+j,fcolor + bcolor + val);
            }
        }
    }

    public static void Circle(int x, int y, int w, int h, int ascii, String fcolor,String bcolor) 
    {
        char val = getAscii(ascii);
        for (int i=0; i < w; i++)
        {
            for (int j=0; j< h; j++)
            {                
                printxy(x+i,y+j,fcolor + bcolor + val);
            }
        }
    }
}
