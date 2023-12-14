enum LightColors {
    RED, YELLOW, GREEN;

    String changeColor() {
        String status;
        switch (this) {
            case RED:
                status="The traffic lights color switched to " + this;
                break;
            case YELLOW:
                status="The traffic lights color switched to " + this;
                break;
            case GREEN:
                status="The traffic lights color switched to " + this;
                break;
            default:
                status="The traffic lights hasn't been switched.";
        }
        return status;
    }

    public String ToString(){
        return "Traffic light coolor: "+ this;
    }
}
public class TrafficLights {
    public static void main(String[] args) {
        LightColors lightColor;
        lightColor=LightColors.RED;
        for(int i=0;i<7;i++) {
            if(lightColor==LightColors.RED){
                lightColor=LightColors.YELLOW;
                System.out.println(lightColor.ToString());
                System.out.println(lightColor.changeColor());}
            else if (lightColor==LightColors.YELLOW) {
                lightColor=LightColors.GREEN;
                System.out.println(lightColor.ToString());
                System.out.println(lightColor.changeColor());
            }
            else{
                lightColor=LightColors.RED;
                System.out.println(lightColor.ToString());
                System.out.println(lightColor.changeColor());
            }

        }

    }
}
