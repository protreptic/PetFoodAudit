package org.javaprotrepticon.android.audit.storage.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "product_type")
public class ProductType {
	
    @DatabaseField(columnName = "id", id = true)
    private Integer id;

	@DatabaseField(columnName = "name")
    private String name;
    
    public ProductType() {}
    
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
	
}