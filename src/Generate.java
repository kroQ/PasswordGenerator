import java.util.Scanner;

public class Generate {
	// TODO Auto-generated method stub
	// ABC // abc // 012 // !@# // 4 min.
	public static void main(String[] args) {

		boolean digit = false;
		boolean ABC = false;
		boolean abc = false;
		boolean special = false;
		String generatedPassword = "";
		int passwordLength;
		int[] typesUsed;
		Scanner input = new Scanner(System.in);
		System.out.println("Podaj dlugosc hasla (minimum 4): ");
		passwordLength = input.nextInt();
		input.nextLine();

		while (digit == false || abc == false || ABC == false || special == false) {
			digit = false;
			ABC = false;
			abc = false;
			special = false;
			generatedPassword = "";

			int choseType = (int) (100 * Math.random() % 4); // 0 1 2 3
			typesUsed = new int[passwordLength];

			for (int i = 0; i < passwordLength; i++) {

				typesUsed[i] = choseType;

				switch (choseType) {
				case 0:
					generatedPassword += (int) (10 * Math.random());
					break;
				case 1:
					generatedPassword += Character.toString((char) ((1000 * Math.random() % 26) + 65));// AZ
					break;
				case 2:
					generatedPassword += Character.toString((char) ((1000 * Math.random() % 26) + 97));// az
					break;

				case 3: // rozne typy znakow specjalnych
					int nextType = (int) (10 * Math.random() % 4);
					switch (nextType) {
					case 0:
						generatedPassword += Character.toString((char) ((1000 * Math.random() % 15) + 33));
						break;
					case 1:
						generatedPassword += Character.toString((char) ((1000 * Math.random() % 7) + 58));
						break;
					case 2:
						generatedPassword += Character.toString((char) ((1000 * Math.random() % 6) + 91));
						break;
					case 3:
						generatedPassword += Character.toString((char) ((1000 * Math.random() % 4) + 123));
						break;
					}
					break;
				}

				choseType = (int) (100 * Math.random() % 4); // 0 1 2 3

				if (i + 1 == passwordLength) {
					for (int a : typesUsed) {
						// System.out.println(a);
						if (a == 0)
							digit = true;
						if (a == 1)
							ABC = true;
						if (a == 2)
							abc = true;
						if (a == 3)
							special = true;
					}
				}
			}
		}

		input.close();
		System.out.println(generatedPassword);
	}

}
