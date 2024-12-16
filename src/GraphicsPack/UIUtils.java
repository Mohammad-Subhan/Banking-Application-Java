package GraphicsPack;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.HashMap;

public class UIUtils {

    public static final String IMAGES_PATH = "./Images/";
    public static final Color BG_COLOR = new Color(0x192731);
    public static final Color SC_COLOR = new Color(0x6cd89e);
    public static final Color SP_COLOR = new Color(0x34414a);
    public static final Color RG_COLOR = new Color(0x677078);
    public static final Color TXT_COLOR = new Color(0xc6c6c6);
    public static final int BT_ROUNDNESS = 8;

    public static Graphics2D get2dGraphics(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.addRenderingHints(new HashMap<RenderingHints.Key, Object>() {
            {
                put(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                put(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_LCD_HRGB);
            }
        });
        return g2;
    }

}