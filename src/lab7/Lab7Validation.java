package lab7;

import java.util.Scanner;

//Did not end up using any of the methods from the Validator class. PArtly because it was more fun to write them myself. Partly because they returned things other than booleans. And partly because i thought that, like keeping the sysouts from the methods, we weren't supposed to be passing scanners to them, either. So i built methods strictly to handle validation, trying to limit what an individual method did as much as possible. A lot less to comment on that way, too.
public class Lab7Validation {
//look at that! No variables here!
	public static void main(String[] args) {
		// Scanner.
		Scanner read = new Scanner(System.in);
		// Menu prompt. Also practicing using escape characters.
		System.out.println(
				"Hi. What do you want to validate? Type: \n\n\"Name\" to check a name \n\"Email\" to check an email address\n\"Phone\" to check a phone number \n\"Date\" to check a date \n\"HTML\" to check an HTML tag.");
		// Stores the user's choice.
		String input = read.nextLine();
		// Switch handles the menu. We user toLowerCase method to broaden the
		// possibility of user correctly choosing an option, but it doesn't really
		// matter. Each case will call the appropriate method to handle the validation.
		// If user fails to choose an option, program will "guess" what they want to
		// validate.
		switch (input.toLowerCase()) {
		case "name":
			System.out.println("Okay, go ahead and give us that name to check.");
			String userName = read.nextLine();
			if (isName(userName)) {
				System.out.println("Right on! That name is valid!");
			} else {
				System.out.println("Sorry, that name isn't valid.");
			}
			break;
		case "email":
			System.out.println("Alright, let's have that email address to check.");
			String userMail = read.nextLine();
			if (isMail(userMail)) {
				System.out.println("Good deal! That's a valid email address!");
			} else {
				System.out.println("Sorry, that email isn't valid.");
			}
			break;
		case "phone":
			System.out.println("Sure. So, we need that phone number to check.");
			String userPhone = read.nextLine();
			if (isPhone(userPhone)) {
				System.out.println("Good job! That phone number is valid!");
			} else {
				System.out.println("Sorry, that phone number isn't valid.");
			}
			break;
		case "date":
			System.out.println("So, we need you to enter that date for us to check.");
			String userDate = read.nextLine();
			if (isDate(userDate)) {
				System.out.println("You got it! That date is totally valid!");
			} else {
				System.out.println("Sorry, that date isn't valid.");
			}
			break;
		case "html":
			System.out.println("So, go on ahead and enter that HTML tag for us to check.");
			String userHTML = read.nextLine();
			if (isHTML(userHTML)) {
				System.out.println("You got it right! That HTML tag is completely valid!");
			} else {
				System.out.println("Sorry, that HTML tag isn't valid.");
			}
			break;
		default:
			System.out.println(
					"We weren't able to quite parse that correctly, but that's okay. Just type what you were going to enter for validation anyway, and we'll try to figure it out!");
			String unSure = read.nextLine();
			System.out.println(howAllAIUltimatelyWorks(unSure));
			break;
		}
		read.close();
	}
	//HTML method is hacky and incomplete. Figuring out how to parse for the slash and compare the two halfs of the tag.
	public static boolean isHTML(String userHTML) {
			boolean isValid = false;
			if (userHTML.matches("<[a-zA-Z]>\\s?</[A-Za-z]>")) {
				String[] tags = userHTML.split(">");
				System.out.println(tags[0] + " " + tags [1] + " " + tags[1].substring(3) + " " + tags[0].substring(1));
				if ((tags[0].substring(1).equals(tags[1].substring(3)) || tags[0].substring(1).equals(tags[1].substring(2))) /*&& (tags[1].substring(2).equals("/"))  || tags[1].substring(1).equals("/")*/) {
				isValid = true;
				}
			} else {
				isValid = false;
			}
			return isValid;
	}

	// I know this is outside of the purview of this exercise, but I felt it made
	// the program feel more cohesive and complete. I did not want to code more
	// cases in the main method, though, so i allow this one to just return Strings
	// to be printed. Stuck to the no sysout in the methods rule, though.
	private static String howAllAIUltimatelyWorks(String unSure) {
		// Method will return a string based on what, if any, format the passed string
		// held that the other methods can look for.
		if (isName(unSure)) {
			return "Looks like you entered a name, and it's totally valid! Rad!";
		} else if (isMail(unSure)) {
			return "Looks like you entered a valid email address. Awesome!";
		} else if (isPhone(unSure)) {
			return "Hey, Verizon called, and they want their completely valid phone number back!";
		} else if (isDate(unSure)) {
			return "That is a valid date. It exists, has existed, or will exist, as is the nature of time and our illusory measurement thereof. Congrats.";
		} 
		else if (isHTML(unSure)) {
			return "That's a totally valid HTML tag. Good jub keeping it together!";
		}
		else {
			return "Okay, we have to be honest. We have no idea what that was. But it's not a valid name, email address, phone number, date, or HTML tag.";
		}
	}

	// Checks that the string is in "name" format (initial cap and lowercase
	// everything else. true if it is, false if it's not, natch.
	public static boolean isName(String userName) {
		boolean isValid = false;
		// This commented out line of code was my attempt to account for first and last
		// names, which was what I immediately assumed was necessary. I removed it
		// because I couldn't reliably get it to accept both single names or first and last
		// names within a single expression. Also I had missed the 30 character thing.
//		if (userName.matches("[A-Z][a-z]*\\s?[A-Z]?[a-z]*?")) {
		if (userName.matches("[A-Z][a-z]{1,30}")) {
			isValid = true;
		} else {
			isValid = false;
		}
		return isValid;
	}

	// Checks if the string is in email format, as per the instructions. No
	// underscores, dashes, or full stops.
	public static boolean isMail(String userMail) {
		boolean isValid;
		if (userMail.matches("[a-zA-Z\\d]{5,30}@[a-zA-Z\\d]{5,10}.[a-zA-Z\\d]{2,3}")) {
			isValid = true;
		} else {
			isValid = false;
		}
		return isValid;
	}

	// Checks if the input is in this phone number format.
	public static boolean isPhone(String userPhone) {
		boolean isValid;
		if (userPhone.matches("\\(\\d{3}\\) \\d{3}-\\d{4}")) {
			isValid = true;
		} else {
			isValid = false;
		}
		return isValid;
	}

	// Checks to see if the input is a date I pulled in a lot of code from the
	// Pre-work exercise to help validate that the date was not only in the right
	// format, but also corresponded to an actual date., accounting for leap years,
	// etc.
	public static boolean isDate(String userDate) {
		boolean isValid = true;
		// These nested statements simply work to determine which months should have how
		// many days and so on. If we get February 29, 1999, program should return
		// false, even if it's in the right format.
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
				} else {
					isValid = false;
				}
			} else {
				isValid = false;
			}

		} else {
			isValid = false;
		}
		return isValid;
	}

}
