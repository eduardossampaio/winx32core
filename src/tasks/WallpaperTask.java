package tasks;

import util.Wallpaper;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class WallpaperTask extends Task {

    private String directory = "imagesource";
    private String jequitiFileName = "jqt";

    public WallpaperTask(int duration) {
        super(duration);
    }

    @Override
    protected void doTask() {
        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(Paths.get(directory))) {
            for (Path path : directoryStream) {
                String imagePath = path.toAbsolutePath().toString().replaceAll("/","\\");
                System.out.println(imagePath);
                Wallpaper.setWallPaper(imagePath);
                if(imagePath.endsWith(jequitiFileName)){
                    Thread.sleep(300);
                }else {
                    Thread.sleep(4000);
                }
            }
        } catch (IOException ex) {} catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
