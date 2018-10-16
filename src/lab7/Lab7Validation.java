package lab7;

import java.util.Scanner;

public class Lab7Validation {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		System.out.println("Hi. What do you want to validate? Type: \n\n\"Name\" to check a name \n\"Email\" to check an email address\n\"Phone\" to check a phone number \n\"Date\" to check a date");
		String input = read.nextLine();
		switch (input) { // This switch assigns each months string to a string format readable by the formatter.
		case "Name":
			System.out.println("Okay, go ahead and give us that name to check.");
			String userName = read.nextLine();
			if (isName(userName)) {
			System.out.println("Right on! That name is valid!");
			}else {
				System.out.println("Sorry, that name isn't valid.");
			}
			break;
		case "Email":
			System.out.println("Alright, let's have that email address to check.");
			String userMail = read.nextLine();
			if (isMail(userMail)) {
			System.out.println("Good deal! That's a valid email address!");
			}else {
				System.out.println("Sorry, that email isn't valid.");
			}
			break;
		case "Phone":
			System.out.println("Sure. So, we need that phone number to check.");
			String userPhone = read.nextLine();
			if (isPhone(userPhone)) {
			System.out.println("Good job! That phone number is valid!");
			}else {
				System.out.println("Sorry, that phone number isn't valid.");
			}
			break;
		case "Date":
			System.out.println("So, we need you to enter that date for us to check in MM/DD/YYYY format.");
			String userDate = read.nextLine();
			if (isDate(userDate)) {
			System.out.println("You got it! That date is totally valid!");
			}else {
				System.out.println("Sorry, that date isn't valid.");
			}
			break;
		default:
			System.out.println("We weren't able to quite parse that correctly, but that's okay. Just type what you were going to enter anyway, and we'll try to figure it out!");
			String unSure = read.nextLine();
			System.out.println(howAllAIUltimatelyWorks(unSure));
			break;
		}

	}

	private static String howAllAIUltimatelyWorks(String unSure) {
		if (isName(unSure)) {
			return "Looks like you entered a name, and it's totally valid! Rad!";
		}
		else if (isMail(unSure)) {
			return "Looks like you entered a valid email address. Awesome!";
		}
		else if (isPhone(unSure)) {
			return "Hey, Verizon called, and they want their completely valid phone number back!";
		}
		else if (isDate(unSure)) {
			return "That is a valid date. It exists, has existed, or will exist, as is the nature of time and our illusory measurement thereof. Congrats.";
		}
		else {
			return "Okay, we have to be honest. We have no idea what that was. But it's not a valid name, email address, phone number, or date.";
		}		
	}

	public static boolean isName(String userName) {
		boolean isValid = false;

//		if (userName.matches("[A-Z][a-z]*\\s?[A-Z]?[a-z]*?")) {
		if (userName.matches("[A-Z][a-z]{1,30}")) {
			isValid = true;
		} else {
			isValid = false;
		}
		return isValid;
	}

	public static boolean isMail(String userMail) {
		boolean isValid;
		if (userMail.matches("[a-zA-Z\\d]{5,30}@[a-zA-Z\\d]{5,10}.[a-zA-Z\\d]{2,3}")) {
			isValid = true;
		} else {
			isValid = false;
		}
		return isValid;
	}

	public static boolean isPhone(String userPhone) {
		boolean isValid;
		if (userPhone.matches("\\(\\d{3}\\) \\d{3}-\\d{4}")) {
			isValid = true;
		} else {
			isValid = false;
		}
		return isValid;
	}

	public static boolean isDate(String userDate) {
		boolean isValid = true;

		if (userDate.matches("\\d\\d/\\d\\d/\\d{4}")) {
			String[] date = userDate.split("/");
			System.out.println(date[0] + " " + date[1] + " " + date[2]);
			if (Integer.parseInt(date[0]) <= 12 && Integer.parseInt(date[0]) > 0) {
				if (Integer.parseInt(date[0]) == 6 || Integer.parseInt(date[0]) == 4 || Integer.parseInt(date[0]) == 9
						|| Integer.parseInt(date[0]) == 11) {
					if (Integer.parseInt(date[1]) <= 30 && Integer.parseInt(date[1]) > 0) {
						isValid = true;
					} else {
						isValid = false;
					}
				} else if (Integer.parseInt(date[0]) == 1 || Integer.parseInt(date[0]) == 3
						|| Integer.parseInt(date[0]) == 5 || Integer.parseInt(date[0]) == 7
						|| Integer.parseInt(date[0]) == 8 || Integer.parseInt(date[0]) == 10
						|| Integer.parseInt(date[0]) == 12) {
					if (Integer.parseInt(date[1]) <= 31 && Integer.parseInt(date[1]) > 0) {
						isValid = true;
					} else {
						isValid = false;
					}
				} else if (Integer.parseInt(date[0]) == 2
						&& ((Integer.parseInt(date[2]) % 100 == 0) && ((Integer.parseInt(date[2]) % 400 != 0))
								|| ((Integer.parseInt(date[2]) % 4 == 0)))) {
					if (Integer.parseInt(date[1]) <= 29 && Integer.parseInt(date[1]) > 0) {
						isValid = true;
					} else {
						isValid = false;
					}
				} else if (Integer.parseInt(date[0]) == 2) {
					if (Integer.parseInt(date[1]) <= 28 && Integer.parseInt(date[1]) > 0) {
						isValid = true;
					} else {
						isValid = false;
					}
				}
				else {
					isValid = false;
				}
			}else {
				isValid = false;
			}

		} else {
			isValid = false;
		}
		return isValid;
	}

}
