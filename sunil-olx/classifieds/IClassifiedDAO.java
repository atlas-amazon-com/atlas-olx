package classifieds;

import java.sql.ResultSet;

//import java.util.Map;

public interface IClassifiedDAO {

	public void addClassified(ClassifiedModel classified);

	public void deleteClassified(ClassifiedModel classifiedModel);

	public ResultSet displayAllClassifieds(int userID);

	public void updateClassified(ClassifiedModel classifiedModel);

}
