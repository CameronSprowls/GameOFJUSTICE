import java.util.ArrayList;
public class Demo
{
    private static int calc()
    {
        return 0;
    }
    
    public static void main(String[] args)
    {
        ArrayList<Double> something;
        something = new ArrayList<Double>();
        
        for(double i = 0; i < 10; i++)
        {
            something.add(i);
        }
        
        int test;
        
        for(int i = 0; i < something.size(); i++)
        {
            test = calc();
            
            something.remove(test);
            
            System.out.println(something);
        }
        
    }
    
    
}