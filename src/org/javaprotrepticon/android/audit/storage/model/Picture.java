package org.javaprotrepticon.android.audit.storage.model;

import java.io.InputStream;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;

public class Picture {
	
    @DatabaseField(generatedId = true)
    private Integer id;
	
	@DatabaseField(dataType = DataType.BYTE_ARRAY)
	private InputStream data;
	
	public Picture() {}
	
	public InputStream getData() {
		return data;
	}
	
	public void setData(InputStream data) {
		this.data = data;
	}
	
}
