public class Main {
    public static void main(String[] args) {
        if (args.length < 3 || (args.length - 1) % 2 != 0) {
            System.out.println("Example: DrawableTest 2 circle 22.5 cube 23.6");
            return;
        }

        try {
            int arraySize = Integer.parseInt(args[0]);
            drawable[] drawables = new drawable[arraySize];
            int index = 0;

            for (int i = 1; i < args.length; i += 2) {
                if (index >= arraySize) {
                    System.out.println("Extra shapes ignored.");
                    break;
                }

                String type = args[i];
                double size = Double.parseDouble(args[i + 1]);
                //String color =null;
                if (type.equalsIgnoreCase("circle")) {
                    drawables[index++] = new Circle(size);
                } else if (type.equalsIgnoreCase("cube")) {
                    drawables[index++] = new Cube(size);
                } else {
                    System.out.println("Invalid shape type: " + type + ". Use 'circle' or 'cube'.");
                }
            }

            double totalArea = 0;
            for (drawable d : drawables) {
                if (d != null) {
                    totalArea +=  ((Shape)d).getArea();
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
