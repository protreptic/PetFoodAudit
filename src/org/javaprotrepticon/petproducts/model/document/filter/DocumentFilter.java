package org.javaprotrepticon.petproducts.model.document.filter;

public interface DocumentFilter {
	
	public void registerDocumentFilterObserver(DocumentFilterObserver documentFilterObserver);
	public void unregisterDocumentFilterObserver(DocumentFilterObserver documentFilterObserver);
	
}
