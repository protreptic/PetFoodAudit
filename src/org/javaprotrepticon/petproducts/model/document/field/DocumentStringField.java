package org.javaprotrepticon.petproducts.model.document.field;

import org.javaprotrepticon.petproducts.model.document.meta.DocumentFieldDescription;
import org.javaprotrepticon.petproducts.model.document.meta.DocumentFieldName;

public class DocumentStringField extends AbsDocumentField {

	private String mValue;
	
	public void setValue(String value) {
		mValue = value;
		
		mDocumentFieldObservable.onDocumentFieldChanged(this); 
	}
	
	public String getValue() {
		return mValue;
	}
	
	@Override
	public DocumentFieldName fieldName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DocumentFieldDescription fieldDescription() {
		// TODO Auto-generated method stub
		return null;
	}

}
