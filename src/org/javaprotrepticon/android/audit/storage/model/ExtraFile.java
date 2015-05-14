package org.javaprotrepticon.android.audit.storage.model;

import java.util.StringTokenizer;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable
public class ExtraFile {
	
    @DatabaseField(id = true)
    private Integer id;

	@DatabaseField
    private String name;
	
	@DatabaseField
	private String file;
	
	@DatabaseField
	private String screens;
	
    public ExtraFile() {}
    
    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getScreens() {
		return screens;
	}

	public String[] getScreensAsArray() {
		StringTokenizer tokenizer = new StringTokenizer(screens);
		
		String[] screensArray = new String[tokenizer.countTokens()];
		
		int count = 0;
		
		while (tokenizer.hasMoreElements()) {
			screensArray[count] = (String) tokenizer.nextElement();
			count++;
		}
		
		return screensArray;
	}
	
	public void setScreens(String screens) {
		this.screens = screens;
	}

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}
	
}

