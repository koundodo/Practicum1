import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.ArrayList;

import static java.nio.file.StandardOpenOption.CREATE;

public class PersonGenerator {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        ArrayList<String> recs = new ArrayList<>();

        String personID;
        String firstName;
        String lastName;
        String title;
        int yearOfBirth;

        boolean isDone = false;

        String rec;
        do {

            personID = SafeInput.getNonZeroLenString(in, "Enter your ID?");
            firstName = SafeInput.getNonZeroLenString(in, "Enter your first name?");
            lastName = SafeInput.getNonZeroLenString(in, "Enter your last name?");
            title = SafeInput.getNonZeroLenString(in, "Enter your title [Mrs, Mr, Esq, Miss, etc..]? ");
            yearOfBirth = SafeInput.getInt(in, "Enter your birth year");


            rec = personID + ", " + firstName + ", " + lastName + ", " + title + ", " + yearOfBirth;
            recs.add(rec);
            System.out.println(rec);
            isDone = SafeInput.getYNConfirm(in, "Are you done?");
        } while (!isDone);

        File workingDirectory = new File(System.getProperty("user.dir"));
        Path file = Paths.get(workingDirectory.getPath() + "/src/PersonTestData.txt");

        try {
            // Typical java pattern of inherited classes
            // we wrap a BufferedWriter around a lower level BufferedOutputStream
            OutputStream out =
                    new BufferedOutputStream(Files.newOutputStream(file, CREATE));
            BufferedWriter writer =
                    new BufferedWriter(new OutputStreamWriter(out));

            // Finally can write the file LOL!

            for (String r : recs) {
                writer.write(r, 0, r.length());  // stupid syntax for write rec
                // 0 is where to start (1st char) the write
                // rec. length() is how many chars to write (all)
                writer.newLine();  // adds the new line

            }
            writer.close(); // must close the file to seal it and flush buffer
            System.out.println("Data file written successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
        in.close();



    }

}
