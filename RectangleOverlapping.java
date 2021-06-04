package ;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.util.Assert;

class Coordinate {
    int x;
    int y;

    Coordinate (int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Coordinate{" +
            "x=" + x +
            ", y=" + y +
            '}';
    }
}
class Rectangle {
    Coordinate bl;
    Coordinate tr;

    Rectangle (Coordinate bl, Coordinate tr) {
        this.bl = bl;
        this.tr = tr;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
            "bl=" + bl +
            ", tr=" + tr +
            '}';
    }
}
public class RectangleOverlapping {

    public boolean doesOverlap(Rectangle r1, Rectangle r2) {
        // compare overlap x-coordinate
        List<Integer> hAxis1 = IntStream.rangeClosed(r1.bl.x, r1.tr.x).boxed().collect(Collectors.toList());
        List<Integer> hAxis2 = IntStream.rangeClosed(r2.bl.x, r2.tr.x).boxed().collect(Collectors.toList());

        Boolean hOverlap = !Collections.disjoint(hAxis1, hAxis2);

        List<Integer> vAxis1 = IntStream.rangeClosed(r1.bl.y, r1.tr.y).boxed().collect(Collectors.toList());
        List<Integer> vAxis2 = IntStream.rangeClosed(r2.bl.y, r2.tr.y).boxed().collect(Collectors.toList());

        Boolean vOverlap = !Collections.disjoint(vAxis1, vAxis2);

        return vOverlap && hOverlap;
    }

    public static void main(String[] args) {

        //Rectangles overlap
        Rectangle r11 = new Rectangle(new Coordinate(1,1), new Coordinate(7,3));
        Rectangle r12 = new Rectangle(new Coordinate(2,0), new Coordinate(6,2));

        Boolean isTrue = new RectangleOverlapping().doesOverlap(r11, r12);
        System.out.println("Does " +r11+ " overlaps " + r12 + " : " + isTrue);
        Assert.isTrue(isTrue);

        Rectangle r21 = new Rectangle(new Coordinate(1,0), new Coordinate(5,4));
        Rectangle r22 = new Rectangle(new Coordinate(2,5), new Coordinate(6,9));

        Boolean isTrue2 = new RectangleOverlapping().doesOverlap(r21, r22);
        System.out.println("Does " +r21+ " overlaps " + r22 + " : " + isTrue2);

    }
}
