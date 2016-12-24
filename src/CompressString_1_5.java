public class CompressString_1_5 {

	public static void main(String[] args) {
		CompressString_1_5 test = new CompressString_1_5();
		System.out.println(test.compressString("aaaaaaaaaaaaaaaaaaaaaab"));
	}


	public CompressString_1_5() {}

	public String compressString(String s) {
		if (compressedLength(s) > s.length()) {
			return s;
		} else {
			return compressStringHelper(s);																		
		}
	}

	public String compressStringHelper(String s) {
		StringBuffer compString = new StringBuffer();
		char last = s.charAt(0);
		int count = 1;

		for (int i = 1; i < s.length(); i++) {
			if (s.charAt(i) == last) {
				count++;
			} else {
				compString.append(last);
				compString.append(count);
				last = s.charAt(i);
				count = 1;
			}
		}

		compString.append(last);
		compString.append(count);

		return compString.toString();					
	}






	public static int compressedLength(String s) {
		if (s == null || s.isEmpty()) {
			return 0;
		} else {
			char last = s.charAt(0);
			int count = 1;
			int size = 0;
			// System.out.println("last " + last);
			// System.out.println("size " + size);
			// System.out.println("--------------");

			for (int i = 1; i < s.length(); i++) {
				if (s.charAt(i) == (last)) {
					count++;
					// System.out.println("last " + last);
					// System.out.println("count " + count);
					// System.out.println("size " + size);
					// System.out.println("--------------");
				} else {
					size += 1 + String.valueOf(count).length();
					last = s.charAt(i);
					count = 1;
					// System.out.println("last " + last);
					// System.out.println("count " + count);
					// System.out.println("size " + size);
					// System.out.println("--------------");
				}
			}

			return size += 1 + String.valueOf(count).length();

		}
	}
}