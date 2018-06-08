package klassen;

public class TestMenge {
public static void main(String args[]) {
java.util.Random rand = new java.util.Random();
IntMenge im = new IntMengeImpl();
while (im.getSize() < 5) {
int r = rand.nextInt(5); boolean c = im.contains(r); im.add(r);
System.out.printf("Element %2d ist %15s, Mengen-Größe ist %2d, " +
"mit: ", r, ((c ? "" : "nicht ") + "vorhanden"), im.getSize());
im.print(); System.out.println();
}
System.out.println("Element-Summe ist " + im.getSum());
}
}