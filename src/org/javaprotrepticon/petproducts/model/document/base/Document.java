package org.javaprotrepticon.petproducts.model.document.base;

import org.javaprotrepticon.petproducts.model.document.meta.DocumentDescription;
import org.javaprotrepticon.petproducts.model.document.meta.DocumentName;

public interface Document {
	
	public static final int MODE_VIEW = 0;
	public static final int MODE_EDIT = 1;
	
	public DocumentName documentName();
	public DocumentDescription documentDescription();
	
	public void openDocument();
	public void closeDocument();
	
	public void registerDocumentObserver(DocumentObserver documentObserver);
	public void unregisterDocumentObserver(DocumentObserver documentObserver);

}
