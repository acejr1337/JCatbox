package chace.catbox;

import java.io.File;
import java.util.List;

import kong.unirest.Unirest;

public class JCatbox {

	private String filePath;
	private String expiryTime;
	private List<File> filesToRemove;
	
	public JCatbox() {}
	
	public JCatbox(String filePath) {
		this.filePath = filePath;
	}
	
	public JCatbox(String filePath, String expiryTime) {
		this.filePath = filePath;
		this.expiryTime = expiryTime;
	}
	
	public JCatbox(List<File> filesToRemove) {
		this.filesToRemove = filesToRemove;
	}
	
	public JCatbox setFilePath(String filePath) {
		this.filePath = filePath;
		return this;
	}
	
	public JCatbox setExpiryTime(String expiryTime) {
		this.expiryTime = expiryTime;
		return this;
	}
	
	public JCatbox setFilesToRemove(List<File> filesToRemove) {
		this.filesToRemove = filesToRemove;
		return this;
	}
	public void executeUploader() {
		if (expiryTime != null) {
			Unirest.post("https://litterbox.catbox.moe/resources/internals/api.php")
			.field("reqtype", "fileupload")
			.field("time", expiryTime)
			.field("fileToUpload", new File(filePath)).asStringAsync(response -> {
				System.out.println("File upload complete -> "+response.getBody() + "\nExpiryTime -> " + expiryTime);
			});
		}
		else {
			Unirest.post("https://catbox.moe/user/api.php")
			.field("reqtype", "fileupload")
			.field("fileToUpload", new File(filePath)).asStringAsync(response -> {
				System.out.println("File upload complete -> "+response.getBody());
			});
		}
	}
	
	@Deprecated
	public void executeRemovalist() {
		Unirest.post("https://litterbox.catbox.moe/resources/internals/api.php")
		.field("reqtype", "deletefiles")
		.field("files", filesToRemove).asStringAsync(response -> {
			System.out.println(response.getBody());
		});
	}
	public static JCatbox theAPI() {
		return new JCatbox();
	}
}
