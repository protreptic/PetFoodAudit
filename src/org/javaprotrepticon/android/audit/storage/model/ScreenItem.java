package org.javaprotrepticon.android.audit.storage.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "screen_item_new")
public class ScreenItem {
	
    @DatabaseField(columnName = "id", id = true)
    private Integer id;

    @DatabaseField(columnName = "screenId")
    private Integer screenId;
    
	@DatabaseField(columnName = "name")
    private String name;
    
	@DatabaseField(columnName = "type")
	private String type;
	
	@DatabaseField(columnName = "isGlobal")
	private Boolean isGlobal;
	
	@DatabaseField(columnName = "depends")
	private String depends;
	
	@DatabaseField(columnName = "spinnerData")
	private String spinnerData;
	
	@DatabaseField(columnName = "isFinal")
	private Boolean isFinal;
	
    @DatabaseField(columnName = "orderliness")
    private Integer orderliness;
	
    public ScreenItem() {}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getScreenId() {
		return screenId;
	}

	public void setScreenId(Integer screenId) {
		this.screenId = screenId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Boolean getIsGlobal() {
		return isGlobal;
	}

	public void setIsGlobal(Boolean isGlobal) {
		this.isGlobal = isGlobal;
	}

	public String getDepends() {
		return depends;
	}

	public void setDepends(String depends) {
		this.depends = depends;
	}

	public String getSpinnerData() {
		return spinnerData;
	}

	public void setSpinnerData(String spinnerData) {
		this.spinnerData = spinnerData;
	}
	
	public Boolean getIsFinal() {
		return isFinal;
	}

	public void setIsFinal(Boolean isFinal) {
		this.isFinal = isFinal;
	}

	public Integer getOrderliness() {
		return orderliness;
	}

	public void setOrderliness(Integer orderliness) {
		this.orderliness = orderliness;
	}
    
}
