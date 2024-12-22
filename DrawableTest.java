package mycompany.oop_drmaged3skr;

public class DrawableTest {
    public static void main(String[] args) {
        if (args.length < 3 || (args.length - 1) % 2 != 0) {
            System.out.println("Example: DrawableTest 2 circle 22.5 cube 23.6");
            return;
        }

        try {
            int arraySize = Integer.parseInt(args[0]);
            if (arraySize < 2) {
                System.out.println("Array size must be at least 2.");
                return;
            }

            Drawable[] drawables = new Drawable[arraySize];
            int index = 0;

            for (int i = 1; i < args.length; i += 2) {
                if (index >= arraySize) {
                    System.out.println("Extra shapes ignored.");
                    break;
                }

                String type = args[i];
                double size = Double.parseDouble(args[i + 1]);

                if (type.equalsIgnoreCase("circle")) {
                    drawables[index++] = new Circle("white", size);
                } else if (type.equalsIgnoreCase("cube")) {
                    drawables[index++] = new Cube("white", size);
                } else {
                    System.out.println("Invalid shape type: " + type + ". Use 'circle' or 'cube'.");
                }
            }

            double totalArea = 0;
            System.out.println("Shapes List:");
            for (Drawable drawable : drawables) {
                if (drawable != null) {
                    if (drawable instanceof Shape) {
                        totalArea += ((Shape) drawable).getArea();
                        System.out.println(drawable.toString());
                    }
                }
            }

            System.out.println("\nTotal Area of Drawable Array: " + totalArea);

        } catch (NumberFormatException e) {
            System.out.println("Invalid input.");
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}