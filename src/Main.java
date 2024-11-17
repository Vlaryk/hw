import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) throws IOException {
        File dirTarget = new File("./dir");
        copyDir(dirTarget);
    }

    public static void copyDir(File dir) throws IOException {
        File backup = new File("./backup");

        if (backup.exists()) {
            for (File file : backup.listFiles()) {
                file.delete();
            }
            backup.delete();
        }
        backup.mkdir();

        if(!dir.exists()) {
            System.out.println("Директории которую вы пытаетесь скопировать не существует");
        }

        File[] files =  dir.listFiles();

        if (files != null)
        {
            for (File file: files) {
                if (file.isFile()) {
                    Files.copy(file.toPath(),Paths.get(backup.getAbsolutePath(),file.getName()));
                }
            }
        }
    }
}