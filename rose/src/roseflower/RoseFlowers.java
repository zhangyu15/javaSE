package roseflower;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

import com.sun.awt.AWTUtilities;
 
public class RoseFlowers extends JFrame {
 
    private static final long serialVersionUID = -8037287523655159012L;
 
    private int num = 99;// 花朵数量
    private int speed = 3;// 下降速度
    private boolean flag = true;
    //JLabel 对象可以显示文本、图像或同时显示二者
    private List<JLabel> labelList = new ArrayList<JLabel>(num);
    //Dimension 类封装单个对象中组件的宽度和高度（精确到整数）。
    private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
   // private ImageIcon icon = new ImageIcon(ImageIO.read(this.getClass().getResourceAsStream("红玫瑰1.gif")));// 花朵图片
    //private ImageIcon icon = new ImageIcon(ImageIO.read(new FileInputStream("红玫瑰1.gif")));// 花朵图片
    private List<ImageIcon> list=new ArrayList<ImageIcon>();
    File file=new File("玫瑰打包");  
    File [] files =file.listFiles();
    public RoseFlowers() throws Exception {
        for(File f:files){
        	String fname="玫瑰打包\\"+f.getName();
        	System.out.println(fname);
        	list.add(new ImageIcon(ImageIO.read(new FileInputStream(fname))));
        }
        getContentPane().setLayout(null);
        setTitle("漫天花雨");
        setSize(screenSize);
        setResizable(false);
        setUndecorated(true);
        setAlwaysOnTop(true);
        setLocationRelativeTo(null);
       // setIconImage(icon.getImage());
        AWTUtilities.setWindowOpaque(this, false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        // 防止最小化
        addWindowStateListener(new WindowStateListener() {
            public void windowStateChanged(WindowEvent e) {
                if (getState() == 1) {
                    setState(0);
                }
            }
        });
 
        // Ctrl + E 关闭窗口
        addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_E) {
                    dispatchEvent(new WindowEvent(RoseFlowers.this, WindowEvent.WINDOW_CLOSING));
                }
            }
        });
 
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                flag = false;// 将线程循环标志置为false
            }
        });
 
        for (int i = 0; i < 30; i++) {
        	
			for (ImageIcon image : list) {
				JLabel jlbl = new JLabel(image);
				jlbl.setSize(200, 300);
				jlbl.setLocation(random(screenSize.width)-160,
						random(screenSize.height)-150);
				labelList.add(jlbl);
				add(jlbl);
			}
        }
 
    }
 
    public void move() {
        new Thread() {
            public void run() {
                while (flag) {
                    try {
                        SwingUtilities.invokeLater(new Runnable() {
                            public void run() {
                                for (int i = 0; i < labelList.size(); i++) {
                                    JLabel jlbl = labelList.get(i);
                                    Point location = jlbl.getLocation();
 
                                    jlbl.setLocation(location.x + (i % 5 - 2), location.y + speed);
 
                                    location = jlbl.getLocation();
                                    if (location.y >= screenSize.height || location.x <= 0 || location.x >= screenSize.width) {
                                        jlbl.setLocation(random(screenSize.width), 0);
                                    }
                                }
                            }
                        });
                        Thread.sleep(100);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            };
        }.start();
 
    }
 
    public void start() {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
                    setVisible(true);
                    move();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
 
    public int random(int max) {
        return (int) (Math.random() * max);
    }
 
    public int random(int min, int max) {
        return random(max - min) + min;
    }
 
}