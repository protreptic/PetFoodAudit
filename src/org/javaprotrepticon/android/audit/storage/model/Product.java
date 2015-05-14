package org.javaprotrepticon.android.audit.storage.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable
public class Product {
	
    @DatabaseField(id = true)
    private Integer id;

	@DatabaseField
    private String name;
    
	@DatabaseField(foreign = true, foreignAutoRefresh = true)
	private Brand brand;
	
	@DatabaseField(foreign = true, foreignAutoRefresh = true)
	private ProductType productType;
	
    public Product() {}
    
}
