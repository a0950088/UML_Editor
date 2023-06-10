package toolkit;

import java.awt.Point;

import objects.AssociationLineObject;
import objects.BasicObject;
import objects.ClassObject;
import objects.CompositionLineObject;
import objects.GeneralizationLineObject;
import objects.Objects;
import objects.UseCaseObject;

public class ObjectFactory {
	public static Objects createBasicObject(String type, Point point) {
		if(type == "CLASS") {
			return new ClassObject(point);
		}
		else if(type == "USECASE") {
			return new UseCaseObject(point);
		}
		return null;
	}
	
	public static Objects createLineObject(String type, Point start, Point end, BasicObject startObj, BasicObject endObj) {
		if(type == "ASSOCIATION") {
			return new AssociationLineObject(start, end, startObj, endObj);
		}
		else if(type == "GENERALIZATION") {
			return new GeneralizationLineObject(start, end, startObj, endObj);
		}
		else if(type == "COMPOSITION") {
			return new CompositionLineObject(start, end, startObj, endObj);
		}
		return null;
	}
}
