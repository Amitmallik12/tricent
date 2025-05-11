package GenericUtitlity;

import java.util.Random;
import org.testng.Reporter;

import java.util.logging.Logger;

public class JavaUtility {
	
	 Logger logger = Logger.getLogger(JavaUtility.class.getName());

	
	public int getRandomNumber() {
		Random ran=new Random();
		return ran.nextInt(1000);
	}
	
	
	
	
	 public static String generateRandomEmail() {
	        String[] names = {"john", "emma", "liam", "olivia", "noah", "ava", "william", "sophia"};
	        Random random = new Random();

	        String name = names[random.nextInt(names.length)];
	        int number = 1000 + random.nextInt(9000); // generates number between 1000–9999

	        return name + number + "@gmail.com";
	    }
	 
	 
	 
	 public static String generateRandomPassword() {
	        String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	        String lower = "abcdefghijklmnopqrstuvwxyz";
	        String digits = "0123456789";
	        String symbols = "!@#$%^&*";
	        String allChars = upper + lower + digits + symbols;

	        Random random = new Random();
	        int length = 8 + random.nextInt(5); // 8 to 12 characters

	        StringBuilder password = new StringBuilder();
	        for (int i = 0; i < length; i++) {
	            password.append(allChars.charAt(random.nextInt(allChars.length())));
	        }
	        return password.toString();
	    }

	    // Generate a name with a single random alphabet + a real name
	    public static String generateRandomCharacterName() {
	        String[] names = {"john", "emma", "liam", "olivia", "noah", "ava", "william", "sophia"};
	        Random random = new Random();
	        char randomChar = (char) ('a' + random.nextInt(26)); // random a–z
	        String name = names[random.nextInt(names.length)];
	        return randomChar + name;
	    }

	    public static String generateRandomPhoneNumber() {
	        Random random = new Random();
	        // Generate a 10-digit phone number starting with 7, 8, or 9
	        int firstDigit = 7 + random.nextInt(3); // 7, 8, or 9
	        long remainingDigits = 100000000L + (long)(random.nextDouble() * 900000000L);
	        return firstDigit + String.valueOf(remainingDigits);
	    }
	    
	    public static String generateRandomPincode() {
	        Random random = new Random();
	        int pincode = 100000 + random.nextInt(900000); // ensures a 6-digit number
	        return String.valueOf(pincode);
	    }
	    
	    
	    public static String generateRandomAddress() {
	        String[] streets = {
	            "mainstreet", "oaklane", "elmroad", "mapleavenue",
	            "pinecircle", "cedardrive", "birchway", "willowstreet"
	        };
	        Random random = new Random();
	        char randomChar = (char) ('a' + random.nextInt(26)); // random a–z
	        String street = streets[random.nextInt(streets.length)];
	        return randomChar + street;
	    }
	   
	    
	    public static String generateRandomCityName() {
	        String[] cities = {
	            "newyork", "london", "tokyo", "paris", "berlin",
	            "sydney", "toronto", "mumbai", "moscow", "dubai"
	        };
	        Random random = new Random();
	        char randomChar = (char) ('a' + random.nextInt(26)); // random a–z
	        String city = cities[random.nextInt(cities.length)];
	        return randomChar + city;
	    }
	    
	    public String getValidatedAlphabetString(String input) {
	        if (input == null || !input.matches("[a-zA-Z]+")) {
	            logger.warning("Invalid input: contains non-alphabet characters -> " + input);
	            throw new IllegalArgumentException("Input must contain only alphabetic characters. Found: " + input);
	        }
	        return input;
	    }
 
	    public String validateAlphabetInput(String input) {
	        if (input != null && input.matches("[a-zA-Z]+")) {
	            String message = "Valid input: contains only alphabets.";
	            Reporter.log(message);
	            return message;
	        } else {
	            String message = "Invalid input: contains non-alphabetic characters.";
	            Reporter.log(message);
	            return message;
	        }
	  
	        
	        
	        
	        
	    }
}
