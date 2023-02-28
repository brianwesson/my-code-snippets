import java.io.File;

public class FileAndDirectory {
    public static void main(String[] args) {
        // Create a directory
        File directory = new File("mydirectory");
        if (!directory.exists()) {
            boolean result = directory.mkdir();
            if (result) {
                System.out.println("Directory created successfully");
            } else {
                System.out.println("Failed to create directory");
            }
        } else {
            System.out.println("Directory already exists");
        }
        
        // Create a file in the directory
        File file = new File("mydirectory/myfile.txt");
        try {
            boolean result = file.createNewFile();
            if (result) {
                System.out.println("File created successfully");
            } else {
                System.out.println("Failed to create file");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
