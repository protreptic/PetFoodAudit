package org.javaprotrepticon.petproducts.model.document.field;

import org.javaprotrepticon.petproducts.model.base.ObjectObserver;

public interface DocumentFieldObserver extends ObjectObserver {
	
	public void onDocumentFieldChanged(DocumentField documentField);
	
}
