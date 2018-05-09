import java.io.*;

/**
 * This class for writing text in the output file.
 *
 * @author Irina
 *
 */
public class Writer {

    private static PrintWriter writer;

    /**
     * Constructor for Writer class
     *
     * @param String filename
     * @throws Exception e
     */
    Writer(String filename) {
        try {
            writer = new PrintWriter(filename, "ascii");
        } catch (Exception e) {
        }
    }

    /**
     * This method is used to write string in the input file.
     *
     * @param String line
     */
    static void write(String line) {
        writer.print(line);
    }

    /**
     * This method is used to close the input file.
     *
     */
    static void close() {
        writer.close();
    }
}