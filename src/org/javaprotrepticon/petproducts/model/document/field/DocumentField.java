package org.javaprotrepticon.petproducts.model.document.field;

import org.javaprotrepticon.petproducts.model.document.meta.DocumentFieldDescription;
import org.javaprotrepticon.petproducts.model.document.meta.DocumentFieldName;

public interface DocumentField {
	
	public DocumentFieldName fieldName();
	public DocumentFieldDescription fieldDescription();
	
	public boolean isEditable();
	
	public void registerDocumentFieldObserver(DocumentFieldObserver documentFieldObserver);
	public void unregisterDocumentFieldObserver(DocumentFieldObserver documentFieldObserver);
	
}
