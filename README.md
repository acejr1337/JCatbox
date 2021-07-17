# JCatbox
Simple Java wrapper to upload files to Catbox.moe and Litterbox.catbox.moe written in java.

# Before using you must agree to the LICENSE

Simple Java Wrapper for JCatbox utilizing REST api.
Upload files and remove files with this API.

Example:
```css
JCatbox
			.theAPI()
				.setFilePath("C:\\Users\\chace\\Desktop\\CatsAreCool.txt")
					.setExpiryTime("2h")
						.executeUploader();
```
