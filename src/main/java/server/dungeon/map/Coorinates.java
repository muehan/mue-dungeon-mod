package server.dungeon.map;

public class Coorinates {
    
    public static Coorinates STARTPOINT = new Coorinates(3.382418103057578, 60.0, 9.251549817625655);

    public Coorinates(
        double x,
        double y,
        double z
    ) {
        this.X = x;
        this.Y = y;
        this.Z = z;
    }

    double X;
    double Y;
    double Z;
}
