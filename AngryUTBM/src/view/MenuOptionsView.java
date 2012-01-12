package view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import main.GameFrame;

@SuppressWarnings("serial")
public class MenuOptionsView extends GameViewMenu
{
	final int frameWidth = GameFrame.getFrameSize().width;
	final int frameHeight = GameFrame.getFrameSize().height;
	
	private JLabel controlsLabel;
	private JLabel controlsImageLabel;
	private String controlsImagePath = "res/images/controls.png";
	private Image image;
	
	public MenuOptionsView()
	{
		ImageIcon ii = new ImageIcon(controlsImagePath);
	    image = ii.getImage();
	    
	    controlsLabel = new JLabel("Controls :");
        controlsLabel.setSize(200, 30);
        controlsLabel.setLocation(frameWidth/2-200,150);
        
        controlsImageLabel= new JLabel() {

			public void paint(Graphics g) {
				g.drawImage(image,frameWidth/2 - 345/2,frameHeight/2 - 245/2, 345,245, null);
			
			}
		};
		
		controlsImageLabel.setSize(new Dimension(frameWidth, frameHeight));
	    setFocusable(true);
        setDoubleBuffered(true);
		
		this.add(controlsLabel,new Integer(1));
		this.add(controlsImageLabel, new Integer(1));
	}

}
