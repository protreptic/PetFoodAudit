package org.javaprotrepticon.petproducts.model.document.item;

public interface DocumentItem {
	
	public void registerDocumentItemObserver(DocumentItemObserver documentItemObserver);
	public void unregisterDocumentItemObserver(DocumentItemObserver documentItemObserver);
	
}
