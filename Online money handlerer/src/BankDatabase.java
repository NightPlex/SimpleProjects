
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.util.Random;

public class BankDatabase {

	public boolean add(String name, String lastName, String username, String password) {

		Random random = new Random();
		String accountNumber = "";
		for (int i = 0; i < 9; i++) {

			accountNumber = accountNumber + random.nextInt(9);

		}

		try {

			boolean append = true;
			boolean autoFlush = true;
			String charset = "UTF-8";
			String filePath = "users/" + username + ".txt";

			File file = new File(filePath);
			if (!file.exists()) {
				FileOutputStream fos = new FileOutputStream(file, append);
				OutputStreamWriter osw = new OutputStreamWriter(fos, charset);
				BufferedWriter bw = new BufferedWriter(osw);
				PrintWriter pw = new PrintWriter(bw, autoFlush);
				pw.write(name + "\n");
				pw.write(lastName + "\n");
				pw.write(accountNumber + "\n");
				pw.write(username + "\n");
				pw.write(password + "\n");
				pw.write("100.00");

				pw.close();
				return true;
			} else {
				return false;

			}
		} catch (Exception e) {

			System.out.println("Something went wrong");
			return false;

		}

	}

	public String getFirstName(String username) {

		try {
			String firstName = Files.readAllLines(Paths.get("users/" + username + ".txt")).get(0);
			return firstName;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}

	}

	public String getLastName(String username) {

		try {
			String lastName = Files.readAllLines(Paths.get("users/" + username + ".txt")).get(1);
			return lastName;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}

	}

	public String getAccountNumber(String username) {

		try {
			String account = Files.readAllLines(Paths.get("users/" + username + ".txt")).get(2);
			return account;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}

	}

	public String getUsername(String username) {

		try {
			String user = Files.readAllLines(Paths.get("users/" + username + ".txt")).get(3);
			return user;
		} catch (IOException e) {
			return null;
		}

	}

	public String getPassword(String username) {

		try {
			String password = Files.readAllLines(Paths.get("users/" + username + ".txt")).get(4);
			return password;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}

	}

	public double getCredits(String username) {
		DecimalFormat df = new DecimalFormat("0.00");
		
		try {
			String credit = Files.readAllLines(Paths.get("users/" + username + ".txt")).get(5).trim();
			String credits = df.format(Double.parseDouble(credit));
			double newCredits = Double.parseDouble(credits);
			return newCredits;
		} catch (IOException e) {
			e.printStackTrace();
			return 0.00;
		}

	}

	public void deleteUser(String username) {
		File varTmpDir = new File("users/" + username + ".txt");
		varTmpDir.delete();

	}

	public boolean addCredit(String username, double amount) {
		File varTmpDir = new File("users/" + username + ".txt");
		boolean exists = varTmpDir.exists();
		String first = getFirstName(username);
		String last = getLastName(username);
		String account = getAccountNumber(username);
		String accountUsername = getUsername(username);
		String password = getPassword(username);

		if (exists) {

			double credits = getCredits(username) + amount;
			String cred = Double.toString(credits);

			try {
				File myFoo = new File("users/" + username + ".txt");
				FileWriter pw = new FileWriter(myFoo, false); // true to append
																// false to
																// overwrite.
				pw.write(first + "\n");
				pw.write(last + "\n");
				pw.write(account + "\n");
				pw.write(accountUsername + "\n");
				pw.write(password + "\n");
				pw.write(cred);
				pw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

			return true;
		} else {

			return false;

		}
	}

	public boolean removeCredit(String username, double amount) {

		String first = getFirstName(username);
		String last = getLastName(username);
		String account = getAccountNumber(username);
		String accountUsername = getUsername(username);
		String password = getPassword(username);

		if (getCredits(username) - amount >= 0) {

			double credits = getCredits(username) - amount;
			String cred = Double.toString(credits);

			try {
				File myFoo = new File("users/" + username + ".txt");
				FileWriter pw = new FileWriter(myFoo, false); // true to append
																// false to
																// overwrite.
				pw.write(first + "\n");
				pw.write(last + "\n");
				pw.write(account + "\n");
				pw.write(accountUsername + "\n");
				pw.write(password + "\n");
				pw.write(cred);
				pw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

			return true;
		} else {

			return false;

		}

	}

}
