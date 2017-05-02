public class JavaHungry
{
     public void m1(String arg1)
     {
          arg1 = "Am I going to disappear?";
     }

     public static void main(String[] args)
     {
           JavaHungry test = new JavaHungry();
           String argumentI = "I am born new";
           test.m1(argumentI);
           System.out.println(argumentI);
     }
}
