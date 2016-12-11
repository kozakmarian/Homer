package sk.upjs.paz1c.homer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 *
 * @author dyske
 */
public class FileStorage {
    public static final File TEMPDIR = new File(System.getProperty("java.io.tempdir") + File.separator + "homer");
    
    public static File getFile(String filename) {
        if (!TEMPDIR.exists()) {
            TEMPDIR.mkdirs();
            return null;
        }
        File userFile = new File(TEMPDIR.getAbsolutePath() + File.separator + filename);
        if (!userFile.exists()) return null;
        System.err.println(userFile.getAbsolutePath());
        return userFile;
    }
    
    public static File getFile(String filename, URL url) {
        File f = FileStorage.getFile(filename);
        if(f != null) return f;
        System.err.println("Downloading from " + url);
        f = new File(TEMPDIR.getAbsolutePath() + File.separator + filename);
        try (OutputStream out = new FileOutputStream(f)) {
            URLConnection conn = url.openConnection();
            conn.setRequestProperty("User-Agent",
                    "Mozilla/5.0 (Windows; U; WindowsNT 5.1; en-US; rv1.8.1.6) Gecko/20070725 Firefox/2.0.0.6");
            conn.connect();
            InputStream serverResponse = conn.getInputStream();
            byte[] buffer = new byte[4096];
            int n = -1;
            while ((n = serverResponse.read(buffer)) != -1) {
                out.write(buffer, 0, n);
            }
        } catch (IOException e) {
            
        }
        return f;
    }
}
