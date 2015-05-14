package org.javaprotrepticon.petproducts.model.document.filter;

import org.javaprotrepticon.petproducts.model.base.ObjectObserver;

public interface DocumentFilterObserver extends ObjectObserver {
	
	public void onDocumentFilterChanged(DocumentFilter documentFilter);
	
}
