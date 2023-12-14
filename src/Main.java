enum Figures{
    SQUARE(1),RECTANGLE(4),CIRCLE(2),TRAPEZOID(7),RHOMBUS(9),TRIANGLE(8),OVAL(6),HEXAGON(7);

    private final int initialValue;
    Figures(int value){
        this.initialValue=value;
    }

    public int getInitialValue() {
        return initialValue;
    }
}
public class Main {
    public static void main(String[] args) {

        System.out.println("Here are all the figures and their initial values:");
        for (Figures figure:Figures.values()){
            System.out.println(figure+" "+figure.getInitialValue());
        }

        System.out.println("Here are all the figures and their ordinal values:");
        for (Figures figure:Figures.values()){
           System.out.println(figure+" "+figure.ordinal());
       }

    }
}