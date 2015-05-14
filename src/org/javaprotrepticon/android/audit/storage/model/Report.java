package org.javaprotrepticon.android.audit.storage.model;

import java.sql.Date;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable
public class Report {
	
    @DatabaseField(generatedId = true)
    private Integer id;
    
    @DatabaseField
    private Date createDate;
    
    @DatabaseField(foreign = true, foreignAutoRefresh = true)
    private Store store;
    
    @DatabaseField
    private String data;

//	@ForeignCollectionField(eager = false)
//	private ForeignCollection<Picture> pictures;
    
    public Report() {}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

}
