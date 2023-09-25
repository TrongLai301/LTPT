public class Myclass1 {
    public String publicField = "Public Field";
    private int privateField = 42;
    public final String finalField = "Final Field";

    public void printFields(){
        System.out.println(publicField);
        System.out.println(privateField);
        System.out.println(finalField);
    }
}
