
package domain;
import java.io.Serializable;
import java.net.URL;
import javax.swing.ImageIcon;
/**
 *
 * @author HuiWen
 */
public class ItemImg implements Serializable {
    private ImageIcon image;
     private URL url;

    public ItemImg() {
    }

    public ItemImg(ImageIcon photo) {
        this.image = photo;
    }

    
    public ItemImg(ImageIcon photo, URL url) {
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


