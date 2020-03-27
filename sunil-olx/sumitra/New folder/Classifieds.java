package olx.classifieds;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Date;

import olx.category.CategoryHelper;
import olx.category.CategoryModel;
import olx.constants.OlxConstants.ClassifiedStatus;

public class Classifieds {
	Connection con;
	Statement stmt;
	CategoryHelper categoryHelper;
	ClassifiedDAOImpl classifiedDAOImpl;

	Classifieds() {
		categoryHelper = new CategoryHelper();
		classifiedDAOImpl = new ClassifiedDAOImpl();
		try {
			// Loading and registering Oracle database thin driver
			Class.forName("oracle.jdbc.driver.OracleDriver");

			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xepdb1", "amazon", "amazon");
			stmt = con.createStatement();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

//TODO : Exceptional Handling for every scanner.
	void addClassifieds() {
		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter the number of Classifieds you want to add\n");
			int totalClassfieds = Integer.parseInt(sc.nextLine().trim());
			for (int i = 0; i < totalClassfieds; i++) {
				String confirm;
				ClassifiedModel classified = new ClassifiedModel();
				do {
					System.out.println("Following is the list of categories you can select from:");
					Map<Integer, CategoryModel> categoryMap = categoryHelper.displayCatergoriesTable();

					CategoryModel categoryModel;
					do {
						System.out.println("Enter a valid category/sub-category ID: ");
						int categoryID = Integer.parseInt(sc.nextLine());
						categoryModel = categoryMap.get(categoryID);
						classified.setCategoryID(categoryID);
					} while (categoryModel == null);

					ClassifiedStatus state = ClassifiedStatus.POSTED;
					classified.setState(state);

					Date createDate = new Date();
					// to check if the date can be created at the DB
					classified.setDateCreated(createDate);
					classified.setDateUpdated(createDate); // At creation, createDate and updateDate are same.

					System.out.println("Enter the new classified Title: ");
					String title = sc.nextLine();
					classified.setTitle(title);

					System.out.println("Enter the new classified description: ");
					String description = sc.nextLine();
					classified.setDescription(description);

					System.out.println("Enter the new classified price: ");
					double price = Double.parseDouble(sc.nextLine());
					classified.setPrice(price);

					/*
					 * TODO get the userModel and do userModel.getId(), userModel.getPhone(),
					 * userModel.getEmail(); and set them to the classified model userID; phone;
					 * email;
					 */
					classified.setUserID(0);
					classified.setPhone("1234567890");
					classified.setEmail("dummy@gmail.com");
					System.out.println("The entered classified is: " + previewClassified(classified, categoryModel));

					System.out.println("Do you wish to post the above classified ?(Y/N): ");
					confirm = sc.nextLine();
				} while (!"Y".equalsIgnoreCase(confirm));

				addClassifiedToDB(classified);

			}
			sc.close();
		} catch (NumberFormatException e) {
			e.printStackTrace();
			System.out.println("Kindly enter a valid input:");
			addClassifieds();
		}
	}

	private void addClassifiedToDB(ClassifiedModel classified) {
		classifiedDAOImpl.addClassified(classified);
	}

	String previewClassified(ClassifiedModel classified, CategoryModel categoryModel) {
		return "\n Category:" + categoryModel.getPrimaryCategory() + "\n Sub-category: "
				+ categoryModel.getSubCategory() + "\n Title:" + classified.getTitle() + "\n Description:"
				+ classified.getDescription() + "\n Price:" + classified.getPrice();
	}

	void displayAllClassifieds() {
		classifiedDAOImpl.displayAllClassifieds();
	}

	void displayClassifiedsByUser(int userID) {

	}
	
	void updateClassified() {
	}
	
	void deleteClassifieds() {
		Scanner del = new Scanner(System.in);
		Map<Integer, ClassifiedModel> classifieds = classifiedDAOImpl.displayAllClassifieds();
		System.out.println("Select the number of classifieds you want to delete:\n");
		int totalDelNumber = Integer.parseInt(del.nextLine());
		ClassifiedModel classifiedModel;
		for (int i = 0; i < totalDelNumber; i++) {
			do {
				System.out.println("Enter the classified you want to delete");
				int deleteClassified = Integer.parseInt(del.nextLine());
				classifiedModel = classifieds.get(deleteClassified);
				classifiedDAOImpl.deleteClassified(deleteClassified);
			} while (classifiedModel == null);
		}

		del.close();
	}
}
