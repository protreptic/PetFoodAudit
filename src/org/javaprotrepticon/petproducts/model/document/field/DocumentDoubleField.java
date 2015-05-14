package org.javaprotrepticon.petproducts.model.document.field;

import org.javaprotrepticon.petproducts.model.document.meta.DocumentFieldDescription;
import org.javaprotrepticon.petproducts.model.document.meta.DocumentFieldName;

public class DocumentDoubleField extends AbsDocumentField {

	private Double mValue;
	
	public void setValue(Double value) {
		mValue = value;
		
		mDocumentFieldObservable.onDocumentFieldChanged(this); 
	}
	
	public Double getValue() {
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
