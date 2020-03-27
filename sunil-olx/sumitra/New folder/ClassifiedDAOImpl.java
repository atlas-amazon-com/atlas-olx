package olx.classifieds;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dbConnection.DBConnection;
import olx.constants.OlxConstants.ClassifiedColumnNames;
import olx.constants.OlxConstants.ClassifiedStatus;
import olx.constants.OlxConstants.DateFormats;

public class ClassifiedDAOImpl implements IClassifiedDAO {

	ClassifiedDAOImpl() {

//		try {
//			//DBConnection.getConnection();
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

	@Override
	public List<ClassifiedModel> getAllClassifieds() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ClassifiedModel getClassified(int classfiedID) {
		// TODO Auto-generated method stub
		return null;
	}

	// TODO CHECK FOR INSERTION AFTER UPDATING THE TABLE
	@Override
	public void addClassified(ClassifiedModel classified) {
		SimpleDateFormat formatter = new SimpleDateFormat(DateFormats.DEFAULT);
		String sqlCreateDate = formatter.format(classified.getDateCreated());
		String sqlUpdateDate = formatter.format(classified.getDateUpdated());

		String query = "insert into classifieds(" + ClassifiedColumnNames.CATEGORY_ID + ","
				+ ClassifiedColumnNames.PRICE + "," + ClassifiedColumnNames.TITLE + ","
				+ ClassifiedColumnNames.DESCRIPTION + "," + ClassifiedColumnNames.EMAIL + ","
				+ ClassifiedColumnNames.PHONE + "," + ClassifiedColumnNames.DATE_CREATED + ","
				+ ClassifiedColumnNames.DATE_UPDATED + "," + ClassifiedColumnNames.STATE + ","
				+ ClassifiedColumnNames.USER_ID + ") values (" + classified.getCategoryID() + ","
				+ classified.getPrice() + "," + "'" + classified.getTitle() + "','" + classified.getDescription()
				+ "','" + classified.getEmail() + "','" + classified.getPhone() + "',to_date('" + sqlCreateDate + "', '"
				+ DateFormats.DB + "'),to_date('" + sqlUpdateDate + "', '" + DateFormats.DB + "'),'"
				+ classified.getState() + "'," + classified.getUserID() + ")";
		try {
			ResultSet rs = DBConnection.executeQuery(query);
			System.out.println("Successfully created classified: " + classified.getTitle());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void updateClassified(ClassifiedModel classified) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteClassified(int deleteClassified) {
		
		String query = "delete from classifieds where ID="+deleteClassified ;  
		try {
		 DBConnection.executeQuery(query);
		 System.out.println("The selected classified has been deleted");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	// TODO Auto-generated method stub

	@Override
	public Map<Integer, ClassifiedModel> displayAllClassifieds() {

		Map<Integer, ClassifiedModel> classifiedMap = new HashMap<>();
		String query = "select * from classifieds";
	//	String query = "Select * from classifieds where UserID"
		try {
			ResultSet rs = DBConnection.executeQuery(query); //TODO make the output better.
			System.out.println("ID\t\t Title \t\t Description \t\t Price \t\t\t Phone \t\t Email \t\t Date Created");
			while (rs.next()) {
				int ID = rs.getInt("ID");
				ClassifiedModel classifiedModel = createClassifiedModel(rs);
				classifiedMap.put(ID, classifiedModel);
				System.out.println(ID + "\t\t" + classifiedModel.getTitle() + "\t\t" + classifiedModel.getDescription()
						+ "\t\t" + classifiedModel.getPrice() + "\t\t" + classifiedModel.getPhone() + "\t\t" + "\t\t"
						+ classifiedModel.getEmail() + "\t\t" + classifiedModel.getDateCreated());
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return classifiedMap;
	}

	private ClassifiedModel createClassifiedModel(ResultSet rs) throws SQLException {
		int ID = rs.getInt(ClassifiedColumnNames.ID);
		int userID = rs.getInt(ClassifiedColumnNames.USER_ID);
		int categoryID = rs.getInt(ClassifiedColumnNames.CATEGORY_ID);
		String title = rs.getString(ClassifiedColumnNames.TITLE);
		String description = rs.getString(ClassifiedColumnNames.DESCRIPTION);
		double price = rs.getDouble(ClassifiedColumnNames.PRICE);
		String email = rs.getString(ClassifiedColumnNames.EMAIL);
		String phone = rs.getString(ClassifiedColumnNames.PHONE);
		ClassifiedStatus state = ClassifiedStatus.valueOf(rs.getString(ClassifiedColumnNames.STATE));
		Date dateCreated = rs.getDate(ClassifiedColumnNames.DATE_CREATED); // cross verify
		Date dateUpdated = rs.getDate(ClassifiedColumnNames.DATE_UPDATED);
		ClassifiedModel classifiedModel = new ClassifiedModel(ID, title, description, userID, dateCreated, dateUpdated,
				phone, email, state, price, categoryID);
		return classifiedModel;
	}

}
