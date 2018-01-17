import tasks.MusicTask;
import tasks.WallpaperTask;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

public class Main {


    public static void main(String [] args) throws InterruptedException, ExecutionException, TimeoutException {

        if ( canExecute()){
            int duration = 10;
            new WallpaperTask(duration).execute();
            new MusicTask(duration).execute();
        }
    }

    private static boolean canExecute(){
        try {
            String startDateFormatted = new String(Files.readAllBytes(Paths.get("startup.conf")));
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date currentDate = new Date(System.currentTimeMillis());
            Date startDate = dateFormat.parse(startDateFormatted);
            return currentDate.getTime() - startDate.getTime() >=0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }
}
