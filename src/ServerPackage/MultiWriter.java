package ServerPackage;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;



public class MultiWriter {

    private static List<PrintWriter> writers = new ArrayList<PrintWriter>();

    public void addWriter(PrintWriter p) {
        writers.add(p);
    }

    public void removeWriter(PrintWriter p) {
        writers.remove(p);
    }

    public void print(String s){
        for (PrintWriter writer : writers) {
            writer.println(s);
        }
    }

}