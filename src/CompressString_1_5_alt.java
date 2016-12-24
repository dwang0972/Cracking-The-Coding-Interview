public class CompressString_1_5_alt {
	int size = 0;
	int index_char = 0;
	
	public static void main(String[] args) {
		CompressString_1_5_alt test = new CompressString_1_5_alt();
		System.out.println(test.compressString("aaaaaaaaaaaaabbb"));
	}

	public CompressString_1_5_alt() {}

	public String compressString(String s) {
		if (findCompressedSize(s) > s.length()) {
			return s;
		} else {
			char[] compressedString = new char[size];
			char last = s.charAt(0);
			int count = 1;
			

			for (int i = 1; i < s.length(); i++) {
				char currChar = s.charAt(i);
				if (currChar == last) {
					count++;
				} else {
					// System.out.println("index_char " + index_char);
					// System.out.println("count of " + last + " " + count);
					// System.out.println("--------------");
					setChar(compressedString, count, last);
					last = s.charAt(i);
					count = 1;
				}
			}

			setChar(compressedString, count, last);
			return String.valueOf(compressedString);
		}

	}

	public void setChar(char[] charArray, int count, char ch) {
		charArray[index_char] = ch;
		index_char++;
		// System.out.println("index_char " + index_char);
		// System.out.println("--------------");

		char[] cnt = String.valueOf(count).toCharArray();
		for (char c: cnt) {
			charArray[index_char] = c;
			index_char++;
			// System.out.println("index_char " + index_char);
			// System.out.println("--------------");
		}
	}

	int findCompressedSize(String s) {
		char last = s.charAt(0);
		int count = 1;

		
		for (int i = 1; i < s.length(); i++) {
			char currChar = s.charAt(i);
			if (currChar == last) {
				count++;
			} else {
				size += 1 + String.valueOf(count).length();
				count = 1; 
				last = currChar; 
			}
		}
		size += 1 + String.valueOf(count).length();
		return size;
	}
}