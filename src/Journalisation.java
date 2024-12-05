import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Journalisation {
    private static Journalisation instance;
    private List<String> logs;
    private static final String FILENAME = "logs/journal.txt";

    private Journalisation() {
        logs = new ArrayList<>();
        File logFile = new File(FILENAME);
        logFile.getParentFile().mkdirs(); // Crée le répertoire si nécessaire
    }

    public static Journalisation getInstance() {
        if (instance == null) {
            instance = new Journalisation();
        }
        return instance;
    }

    public void ajouterLog(String log) {
        logs.add(log);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILENAME, true))) {
            writer.write(log);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void afficherLogs() {
        for (String log : logs) {
            System.out.println(log);
        }
    }
}
