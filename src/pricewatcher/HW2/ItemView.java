package pricewatcher.HW2;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;

/** A special panel to display the detail of an item. */

@SuppressWarnings("serial")
public class ItemView extends JPanel{
    //fixed item, it will become a list of items later
    Item item = new Item("https://www.amazon.com/Cards-Against-Humanity-LLC-CAHUS/dp/B004S8F7QM/ref=br_asw_pdt-2?pf_rd_m=ATVPDKIKX0DER&pf_rd_s=&pf_rd_r=5AKCTP4FR3Y4DQDMK62F&pf_rd_t=36701&pf_rd_p=da24e60a-b03f-4464-a877-3327db3bc407&pf_rd_i=desktop","Cards Against Humanity", 25.0);

    /** Interface to notify a click on the view page icon. */
    public interface ClickListener {

        /** Callback to be invoked when the view page icon is clicked. */
        void clicked();
    }

    /** Directory for image files: src/image in Eclipse. */
    private final static String IMAGE_DIR = "image/";

    /** View-page clicking listener. */
    private ClickListener listener;

    /** Create a new instance. */
    public ItemView() {
        setPreferredSize(new Dimension(100, 160));
        setBackground(Color.PINK);
        addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (isViewPageClicked(e.getX(), e.getY()) && listener != null) {
                    listener.clicked();
                }
            }
        });
    }

    /** Set the view-page click listener. */
    public void setClickListener(ClickListener listener) {
        this.listener = listener;
    }

    /** Overridden here to display the details of the item. */

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Dimension dim = getSize();

        //--
        //-- WRITE YOUR CODE HERE!
        //--

        g.setColor(Color.BLACK);
        //g.setFont(new Font("San-serif", Font.BOLD, 12));
        int x = 20, y = 30;

        g.drawImage(getImage("view.png"),x,15, null);
        y += 20;
        /* this didnt work, the text never jump to the next line...*/
        //g.drawString(item.toString(),x,y);
        g.drawString("Name:      " + item.getName(),x,y);
        y += 20;
        g.drawString("URL:         " + item.getUrl(), x, y);
        y += 20;
        g.drawString("Price:        " + item.getPrice(), x, y);
        y += 20;
        g.drawString("Change:   " + item.getPriceChange(), x, y);
        //g.setColor(item.getPrice() < 0.0F ? Color.BLUE : item.getPrice() > 0.0F ? Color.RED : Color.BLACK);
        y += 20;
        g.drawString("Added:     " + item.getDate() + " ( $ "+item.getPrice()+")", x, y);


    }

    /** Return true if the given screen coordinate is inside the viewPage icon. */
    private boolean isViewPageClicked(int x, int y) {
        //--
        //-- WRITE YOUR CODE HERE
        //--
        if(x == 20 && y == 30){
            return true;
        }
        else
            return new Rectangle(20, 20, 30, 20).contains(x,  y);
    }

    /** Return the image stored in the given file. */
    public Image getImage(String file) {
        try {
            URL url = new URL(getClass().getResource(IMAGE_DIR), file);
            return ImageIO.read(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}

