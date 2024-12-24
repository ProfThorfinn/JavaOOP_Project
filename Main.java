public class Main {
    public static void main(String[] args) {
            int arraySize = Integer.parseInt(args[0]);
            if (arraySize < 2) {
                System.out.println("size must be at least 2.");
                return;
            }
            Drawable[] drawables = new Drawable[arraySize];
            int index = 0;

            for (int i = 1; i < args.length; i++) {
                if (index >= arraySize) {
                    System.out.println("Extra shapes ignored." + " Only 2 Shapes");
                    break;
                }
                String type = args[i];
                double size = Double.parseDouble(args[i]);

                if (type.equalsIgnoreCase("circle")) {
                    drawables[index] = new Circle(size);
                } else if (type.equalsIgnoreCase("cube")) {
                    drawables[index] = new Cube(size);
                } else {
                    System.out.println("Invalid shape type: " + type + ". Use 'circle' or 'cube'.");
                }
            }
            double totalArea = 0;
            for (Drawable drawable : drawables) // for each 
            {
                if (drawable != null) {
                    if (drawable instanceof Shape);
                    }
                }
            }
            System.out.println("\nTotal Area of Drawable Array: " + totalArea);
    }
}
