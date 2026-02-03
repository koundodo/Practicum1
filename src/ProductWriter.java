import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.ArrayList;

import static java.nio.file.StandardOpenOption.CREATE;

public class ProductWriter
{
    public static void main(String[] args)
    {

        Scanner in = new Scanner(System.in);
        ArrayList<String> recs = new ArrayList<>();

        String productID;
        String name;
        String description;
        double cost;

        boolean isDone = false;

        String rec;

        do {

            productID = SafeInput.getNonZeroLenString(in, "Enter your ID?");
            name = SafeInput.getNonZeroLenString(in, "Enter the name of your product?");
            description = SafeInput.getNonZeroLenString(in, "Enter product description");
            cost = SafeInput.getDouble(in, "Enter price of your product?" );

            rec =  String.format("%s, %s, %s, %.1f",
                    productID, name, description, cost);

            recs.add(rec);
            System.out.println(rec);
            isDone = SafeInput.getYNConfirm(in, "Are you done?");

        }while(!isDone);

        File workingDirectory = new File(System.getProperty("user.dir"));
        Path file = Paths.get(workingDirectory.getPath() + "/src/ProductTestData.txt");

        try
        {
            // Typical java pattern of inherited classes
            // we wrap a BufferedWriter around a lower level BufferedOutputStream
            OutputStream out =
                    new BufferedOutputStream(Files.newOutputStream(file, CREATE));
            BufferedWriter writer =
                    new BufferedWriter(new OutputStreamWriter(out));

            // Finally can write the file LOL!

            for(String r : recs)
            {
                writer.write(r, 0, r.length());  // stupid syntax for write rec
                // 0 is where to start (1st char) the write
                // rec. length() is how many chars to write (all)
                writer.newLine();  // adds the new line

            }
            writer.close(); // must close the file to seal it and flush buffer
            System.out.println("Data file written!");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        in.close();
    }


}
