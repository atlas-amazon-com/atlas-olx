package olx.classifieds;

import java.util.List;
import java.util.Map;

public interface IClassifiedDAO {

	public List<ClassifiedModel> getAllClassifieds();

	public ClassifiedModel getClassified(int classfiedID);

	public void addClassified(ClassifiedModel classified);

	public void updateClassified(ClassifiedModel classified);

	public void deleteClassified(int deleteClassified);
	
	public Map<Integer, ClassifiedModel> displayAllClassifieds();
	
	//public void displayClassifiedByUser(long userID);
	
}
