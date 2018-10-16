package lab7;

import java.util.Scanner;

public class Lab7Validation {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		System.out.println("Enter a valid java id.");
		String input = read.nextLine();
		
		System.out.println(isDate(input));
		// RegEx for name [A-Z][a-z]*\s?[A-Z]?[a-z]*?
		//
		// RegEx for phone numbers \(\d{3}\) \d{3}-\d{4}

		read.close();
	}

	public static boolean isName(String userName) {
		boolean isValid = false;

		if (userName.matches("[A-Z][a-z]*\\s?[A-Z]?[a-z]*?")) {
			isValid = true;
		} else {
			isValid = false;
		}
		return isValid;
	}

	public static boolean isEmail(String userMail) {
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
