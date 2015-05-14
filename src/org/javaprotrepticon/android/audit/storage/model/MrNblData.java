package org.javaprotrepticon.android.audit.storage.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable
public class MrNblData {
	
    @DatabaseField(generatedId = true)
    private Integer id;

    @DatabaseField(canBeNull = false, foreign = true)
    private Cluster cluster; 
    
    @DatabaseField(canBeNull = false, foreign = true)
	private Channel channel; 
	
    @DatabaseField(canBeNull = false, foreign = true)
    private SubChannel subChannel; 
    
    @DatabaseField(canBeNull = false, foreign = true)
    private StoreType store_type;
	
    @DatabaseField(canBeNull = false, foreign = true)
	private Product product;
	
	@DatabaseField(columnName = "mr_value")
	private Integer mr;
    
	@DatabaseField(columnName = "nbl_value")
	private Integer nbl;
    
    public MrNblData() {}
    
    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Cluster getCluster() {
		return cluster;
	}

	public void setCluster(Cluster cluster) {
		this.cluster = cluster;
	}

	public Channel getChannel() {
		return channel;
	}

	public void setChannel(Channel channel) {
		this.channel = channel;
	}
	
	public SubChannel getSubChannel() {
		return subChannel;
	}

	public void setSubChannel(SubChannel subChannel) {
		this.subChannel = subChannel;
	}

	public StoreType getStoreType() {
		return store_type;
	}

	public void setStoreType(StoreType storeType) {
		this.store_type = storeType;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Integer getMr() {
		return mr;
	}

	public void setMr(Integer value) {
		this.mr = value;
	}
	
	public Integer getNbl() {
		return nbl;
	}

	public void setNbl(Integer value) {
		this.nbl = value;
	}
	
}
