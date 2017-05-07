package test.Erokan;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.CharMatcher;

public class FeeSelectionJson {

	public static void main(String[] args) throws Exception {

		String json = new String(Files.readAllBytes(Paths.get("src/main/resources/Input.json")));

		ObjectMapper mapper = new ObjectMapper();
		HashMap<String, HashMap<String, HashMap<String, HashMap<String, Object>>>> Level0_Map = new HashMap<String, HashMap<String, HashMap<String, HashMap<String, Object>>>>();
		Scanner reader = new Scanner(System.in);
		int fee_Amount = 0;

		String Level_1 = null, Level_2 = null, Level_3 = null, Level_4 = null;

		try {
			Level0_Map = mapper.readValue(json,
					new TypeReference<HashMap<String, HashMap<String, HashMap<String, HashMap<String, Object>>>>>() {
			});
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		loop: while (true)
		{
			System.out.println(
					"\nSelect the type of fee\n  1."+Level0_Map.keySet().toArray()[0].toString()+"\n  2."+Level0_Map.keySet().toArray()[1].toString()+"\n  3.Exit\n\nEnter your Choice");
			String user_Input = reader.nextLine();

			if(Level0_Map.keySet().toString().contains(user_Input))
			{
				Level_1=user_Input;
				String json_Level_1 = new ObjectMapper().writeValueAsString(Level0_Map.get(user_Input));
				
				HashMap<String, HashMap<String, HashMap<String, Object>>> Level1_Map = mapper.readValue(json_Level_1,
						new TypeReference<HashMap<String, HashMap<String, HashMap<String, Object>>>>() {
				});
				
				System.out.println("\nSelect "+Level1_Map.keySet().toString());
				user_Input = reader.nextLine();

				
				if(Level1_Map.keySet().toString().contains(user_Input))
				{
					Level_2=user_Input;
					String json_Level_2 = new ObjectMapper().writeValueAsString(Level1_Map.get(user_Input));
					
					HashMap<String, HashMap<String, Object>> Level2_Map = mapper.readValue(json_Level_2,
							new TypeReference<HashMap<String, HashMap<String, Object>>>() {
					});
					System.out.println("\nSelect "+Level2_Map.keySet().toString());
					
					user_Input = reader.nextLine();
					
					
					if(Level2_Map.keySet().toString().contains(user_Input))
					{
						Level_3=user_Input;
						String json_Level_3 = new ObjectMapper().writeValueAsString(Level2_Map.get(user_Input));
						
						HashMap<String, HashMap<String, Object>> Level3_Map = mapper.readValue(json_Level_3,
								new TypeReference<HashMap<String, HashMap<String, Object>>>() {
						});
						System.out.println("\nSelect "+Level3_Map.keySet().toString());
						
						user_Input = reader.nextLine();
						
						
						if(Level3_Map.keySet().toString().contains(user_Input))
						{
							Level_4=user_Input;							
							
							String c = CharMatcher.DIGIT
									.retainFrom(Level0_Map.get(Level_1).get(Level_2).get(Level_3).get(Level_4).toString());
							fee_Amount = Integer.parseInt(c);
							System.out.println("\nThe amount of fees to be paid is = " + fee_Amount);
																					
						}
					}
				}
			}
			else if(user_Input.equalsIgnoreCase("exit"))
			{
				System.out.println("** Application Exited **");
				System.exit(0);
			}
			else
			{
				System.out.println("Invalid Input, Try again..!!");
				break loop;
			}
		
			
		}
		}

}
