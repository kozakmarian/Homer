package sk.upjs.paz1c.homer;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

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
    
    
    public static final File getFile(String filename, URL url, boolean downsample) throws IOException {
        File f = FileStorage.getFile(filename, url);
        if (!downsample) return f;
        
        String name[] = filename.split("\\.");
        String newName = name[0] + ".icon." + name[1];
        f = new File(TEMPDIR.getAbsolutePath() + File.separator + newName);
        if (f.exists()) return f;
        
        BufferedImage originalImage = ImageIO.read(new File(TEMPDIR.getAbsolutePath() + File.separator + filename));
        BufferedImage resizedImage = new BufferedImage(70, 40, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = resizedImage.createGraphics();
        g.drawImage(originalImage, 0, 0, 70, 40, null);
        g.dispose();
        ImageIO.write(resizedImage, "jpg", f);
        
        return f;
    }
}
