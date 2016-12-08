/*
 Author Phang Chun Wai
 */
package domain;



import java.net.URL;
import javax.swing.ImageIcon;


public class Icon {
     private ImageIcon image;
     private URL url;

    public Icon() {
    }

    public Icon(ImageIcon photo) {
        this.image = photo;
    }

    
    public Icon(ImageIcon photo, URL url) {
        this.image = photo;
        this.url = url;
    }

    public ImageIcon getImage() {
        return image;
    }

    public void setImage(ImageIcon photo) {
        this.image = photo;
    }

    public URL getUrl() {
        return url;
    }

    public void setUrl(URL url) {
        this.url = url;
    }
  
    
}
