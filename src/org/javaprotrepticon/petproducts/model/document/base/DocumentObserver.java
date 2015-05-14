package org.javaprotrepticon.petproducts.model.document.base;

import org.javaprotrepticon.petproducts.model.base.ObjectObserver;

public interface DocumentObserver extends ObjectObserver {
	
	public void onDocumentOpened(Document document);
	public void onDocumentClosed(Document document);
	public void onDocumentChanged(Document document);
	
}
