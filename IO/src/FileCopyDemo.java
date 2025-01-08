import java.io.*;

public class FileCopyDemo {
    // copies content from src to dest byte by byte or char by char
    private static void copyTextFile(File src, File dest) {
        try {
            try (var reader = new FileReader(src);
                 var writer = new FileWriter(dest)) {
                int b;
                while ((b = reader.read()) != -1) {
                    writer.write(b);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void copyFileWithBuffer(File src, File dest) {
        try {
            try (var reader = new BufferedInputStream(new FileInputStream(src));
                 var writer = new BufferedOutputStream(new FileOutputStream(dest))) {
                var buffer = new byte[1024];
                int lengthRead;
                while ((lengthRead = reader.read(buffer)) != -1) {
                    writer.write(buffer, 0, lengthRead);
                    writer.flush();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        File file1 = new File("IO/examples/months.txt");
        File file2 = new File("IO/examples/months-copy.txt");
        copyTextFile(file1, file2);
        File file3 = new File("IO/examples/days.txt");
        File file4 = new File("IO/examples/days-copy.txt");
        copyFileWithBuffer(file3, file4);
    }
}

