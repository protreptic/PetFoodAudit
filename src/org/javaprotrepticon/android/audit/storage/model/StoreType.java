package org.javaprotrepticon.android.audit.storage.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable
public class StoreType {
	
    @DatabaseField(generatedId = true)
    private Integer id;

	@DatabaseField
    private String name;
    
    @DatabaseField(foreign = true, foreignAutoRefresh = true)
    private Cluster cluster;
	
    @DatabaseField(foreign = true, foreignAutoRefresh = true)
    private Channel channel;
    
    @DatabaseField(foreign = true, foreignAutoRefresh = true)
    private SubChannel subChannel;
    
    public StoreType() {}
    
}
