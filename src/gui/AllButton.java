package gui;

import javax.swing.ImageIcon;
import mode.BasicObjectMode;
import mode.LineObjectMode;
import mode.SelectMode;
import mode.ModeSelector;
public enum AllButton {
	SELECT(new ImageIcon("image\\Select.png")),
	ASSOCIATION(new ImageIcon("image\\Association.png")),
	GENERALIZATION(new ImageIcon("image\\Generalization.png")),
	COMPOSITION(new ImageIcon("image\\Composition.png")),
	CLASS(new ImageIcon("image\\Class.png")),
	USECASE(new ImageIcon("image\\UseCase.png"));
	  
	private ImageIcon imageIcon;
	private AllButton(ImageIcon icon) {
	  imageIcon = icon;
	}
	  
	public ImageIcon getImageIcon() {
	  return imageIcon;
	}
}
