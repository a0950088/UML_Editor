package gui;

import javax.swing.ImageIcon;
import mode.BasicObjectMode;
import mode.LineObjectMode;
import mode.SelectMode;
import mode.ModeSelector;
public enum AllButton {
	SELECT(new SelectMode(), new ImageIcon("image\\Select.png")),
	ASSOCIATION(new LineObjectMode(), new ImageIcon("image\\Association.png")),
	GENERALIZATION(new LineObjectMode(), new ImageIcon("image\\Generalization.png")),
	COMPOSITION(new LineObjectMode(), new ImageIcon("image\\Composition.png")),
	CLASS(new BasicObjectMode(), new ImageIcon("image\\Class.png")),
	USECASE(new BasicObjectMode(), new ImageIcon("image\\UseCase.png"));
	  
	private ImageIcon imageIcon;
	private ModeSelector modeselector;
	private AllButton(ModeSelector mode, ImageIcon icon) {
	  imageIcon = icon;
	  modeselector = mode;
	}
	  
	public ImageIcon getImageIcon() {
	  return imageIcon;
	}
	public ModeSelector getMode() {
		return modeselector;
	}
	
}
