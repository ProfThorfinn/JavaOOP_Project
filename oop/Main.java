public class Main {
    public static void main(String[] args) {
        if (args.length < 3 || (args.length - 1) % 2 != 0) {
            System.out.println("Example: Main 2 circle 22.5 cube 23.6");
            DrawableGUI gui = new DrawableGUI(10);
            gui.createGUI();
            return;
        }

        try {
            int arraySize = Integer.parseInt(args[0]);
            Shape[] drawables = new Shape[arraySize];
            int index = 0;

            for (int i = 1; i < args.length; i += 2) {
                String type = args[i];
                double size = Double.parseDouble(args[i + 1]);
                switch (type.toLowerCase()) {
                    case "circle":
                        drawables[index++] = new Circle(size);
                        break;
                    case "cube":
                        drawables[index++] = new Cube(size);
                        break;
                    default:
                        System.out.println("Invalid shape type: " + type + ". Use 'circle' or 'cube'.");
                        break;
                }
            }
            double totalArea = 0;
            for (Shape shape : drawables) {
                if (shape != null) {
                    totalArea += shape.getArea();
                }
                    System.out.println(shape+shape.howToPaint());
            }

            System.out.println("\nTotal Area of Drawable Array: " + totalArea);

           DrawableGUI gui = new DrawableGUI(10);
             gui.createGUI();

        } catch (NumberFormatException e) {
            System.out.println("Invalid input.");
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}