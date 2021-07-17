package chace.catbox;

public class Example {
	public static void main(String[] args) {
		JCatbox
			.theAPI()
				.setFilePath("C:\\Users\\chace\\Desktop\\CatsAreCool.txt")
					.setExpiryTime("2h")
						.executeUploader();
	}
}
