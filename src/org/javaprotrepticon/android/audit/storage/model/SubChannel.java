package org.javaprotrepticon.android.audit.storage.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "subchannel")
public class SubChannel {
	
    @DatabaseField(columnName = "id", id = true)
    private Integer id;

    @DatabaseField(columnName = "channel_id")
    private Integer channelId;
    
	@DatabaseField(columnName = "name")
    private String name;
    
    public SubChannel() {}
    
    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

    public Integer getChannelId() {
		return channelId;
	}

	public void setChannelId(Integer id) {
		this.channelId = id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return name;
	}
	
}
