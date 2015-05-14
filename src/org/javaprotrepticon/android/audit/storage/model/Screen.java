package org.javaprotrepticon.android.audit.storage.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "screen_new")
public class Screen {

    @DatabaseField(columnName = "id", id = true)
    private Integer id;

	@DatabaseField(columnName = "name")
    private String name;
    
	@DatabaseField(columnName = "extras")
    private String extras;
	
    public Screen() {}
    
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

	public String getExtras() {
		return extras;
	}

	public void setExtras(String extras) {
		this.extras = extras;
	}
	
}
