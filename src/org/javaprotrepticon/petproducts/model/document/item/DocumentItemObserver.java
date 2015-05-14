package org.javaprotrepticon.petproducts.model.document.item;

import org.javaprotrepticon.petproducts.model.base.ObjectObserver;

public interface DocumentItemObserver extends ObjectObserver {
	
	public void onDocumentItemChanged(DocumentItem documentItem);
	
}
