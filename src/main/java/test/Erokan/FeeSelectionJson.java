package test.Erokan;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Scanner;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.CharMatcher;

public class FeeSelectionJson {

	public static void main(String[] args) throws Exception {

		String json = new String(Files.readAllBytes(Paths.get("src/main/resources/Input.json")));

		ObjectMapper mapper = new ObjectMapper();
		HashMap<String, HashMap<String, HashMap<String, HashMap<String, Object>>>> map = new HashMap<String, HashMap<String, HashMap<String, HashMap<String, Object>>>>();
		Scanner reader = new Scanner(System.in);
		int fee_Amount = 0;

		String Level_1 = null, Level_2 = null, Level_3 = null, Level_4 = null;

		try {
			map = mapper.readValue(json,
					new TypeReference<HashMap<String, HashMap<String, HashMap<String, HashMap<String, Object>>>>>() {
					});
			System.out.println(map);
		} catch (Exception e) {
			e.printStackTrace();
		}

		loop: while (true)

		{
			System.out.println(
					"\nSelect the type of fee\n  1.Exam Fee\n  2.Application Fee\n  3.Exit\n\nEnter your Choice");
			String user_Input = reader.nextLine().toLowerCase();

			switch (user_Input) {

			case "exam fee":
				System.out.println("	Exam Fee\n");
				Level_1 = "Exam Fee";
				System.out.println("Select type of Student\n INDIAN, FOREIGN, NRI, SAARC\nEnter your Choice");

				user_Input = reader.nextLine().toLowerCase();

				if (user_Input.equalsIgnoreCase("indian")) {
					System.out.println("	Indian\n");
					Level_2 = "INDIAN";
					System.out.println("Select type of Course\n ALL_COURSES \nEnter your Choice");
					user_Input = reader.nextLine().toLowerCase();

					if (user_Input.equalsIgnoreCase("all_courses")) {
						Level_3 = "ALL_COURSES";
						System.out.println("	All Courses\n");
						System.out.println("Select type of Level of Course\n ALL_LEVEL \nEnter your Choice");
						user_Input = reader.nextLine().toLowerCase();

						if (user_Input.equalsIgnoreCase("all_level")) {
							Level_4 = "ALL_LEVEL";
							break;

						}
					}
				} else if (user_Input.equalsIgnoreCase("foreign")) {
					Level_2 = "FOREIGN";
					System.out.println("Select type of Course\n ALL_COURSES \nEnter your Choice");
					user_Input = reader.nextLine().toLowerCase();

					if (user_Input.equalsIgnoreCase("all_courses")) {
						Level_3 = "ALL_COURSES";
						System.out.println("Select type of Level of Course\n ALL_LEVEL \nEnter your Choice");
						user_Input = reader.nextLine().toLowerCase();

						if (user_Input.equalsIgnoreCase("all_level")) {
							Level_4 = "ALL_LEVEL";

						}
					}
				}

				else if (user_Input.equalsIgnoreCase("nri")) {
					Level_2 = "NRI";
					System.out.println("Select type of Course\n ALL_COURSES \nEnter your Choice");
					user_Input = reader.nextLine().toLowerCase();

					if (user_Input.equalsIgnoreCase("all_courses")) {
						Level_3 = "ALL_COURSES";
						System.out.println("Select type of Level of Course\n ALL_LEVEL \nEnter your Choice");
						user_Input = reader.nextLine().toLowerCase();

						if (user_Input.equalsIgnoreCase("all_level")) {
							Level_4 = "ALL_LEVEL";

						}

					}

				} else if (user_Input.equalsIgnoreCase("saarc")) {
					Level_2 = "SAARC";
					System.out.println("Select type of Course\n ALL_COURSES \nEnter your Choice");
					user_Input = reader.nextLine().toLowerCase();

					if (user_Input.equalsIgnoreCase("all_courses")) {
						Level_3 = "ALL_COURSES";
						System.out.println("Select type of Level of Course\n ALL_LEVEL \nEnter your Choice");
						user_Input = reader.nextLine().toLowerCase();

						if (user_Input.equalsIgnoreCase("all_level")) {
							Level_4 = "ALL_LEVEL";

						}
					}
				}
				break;

			case "application fee":
				System.out.println("	Application Fee\n");
				Level_1 = "Application Fee";
				System.out.println("Select type of Student\n INDIAN, FOREIGN\nEnter your Choice");
				user_Input = reader.nextLine().toLowerCase();

				if (user_Input.equalsIgnoreCase("indian")) {
					Level_2 = "INDIAN";
					System.out.println("Select type of Course\n ALL_COURSES \nEnter your Choice");
					user_Input = reader.nextLine().toLowerCase();

					if (user_Input.equalsIgnoreCase("all_courses")) {
						Level_3 = "ALL_COURSES";
						System.out.println("Select type of Level of Course\n UG, UG-DIPLOMA, PG \nEnter your Choice");
						user_Input = reader.nextLine().toLowerCase();

						if (user_Input.equalsIgnoreCase("ug")) {
							Level_4 = "UG";

						} else if (user_Input.equalsIgnoreCase("ug-diploma")) {
							Level_4 = "UG-DIPLOMA";

						} else if (user_Input.equalsIgnoreCase("pg")) {
							Level_4 = "PG";

						}

					}

				} else if (user_Input.equalsIgnoreCase("foreign")) {
					Level_2 = "FOREIGN";
					System.out.println("Select type of Course\n ALL_COURSES \nEnter your Choice");
					user_Input = reader.nextLine().toLowerCase();

					if (user_Input.equalsIgnoreCase("all_courses")) {
						Level_3 = "ALL_COURSES";
						System.out.println("Select type of Level of Course\n UG, UG-DIPLOMA, PG \nEnter your Choice");
						user_Input = reader.nextLine().toLowerCase();

						if (user_Input.equalsIgnoreCase("ug")) {
							Level_4 = "UG";

						} else if (user_Input.equalsIgnoreCase("ug-diploma")) {
							Level_4 = "UG-DIPLOMA";

						} else if (user_Input.equalsIgnoreCase("pg")) {
							Level_4 = "PG";

						}
					}
				}

				break;
			case "exit":
				System.exit(0);
			default:
				System.out.print("Incorrect Entry\n Retry..!!\n");

			}


			try {
				
				String c = CharMatcher.DIGIT
						.retainFrom(map.get(Level_1).get(Level_2).get(Level_3).get(Level_4).toString());
				fee_Amount = Integer.parseInt(c);
				System.out.println("The amount of fees that needs to be paid is = " + fee_Amount);

			} catch (Exception e) {
				e.printStackTrace();
				break loop;
			}
		}
		
	}

}
