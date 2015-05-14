package org.javaprotrepticon.petproducts.model.document.field;

import org.javaprotrepticon.petproducts.model.document.meta.DocumentFieldDescription;
import org.javaprotrepticon.petproducts.model.document.meta.DocumentFieldName;

public class DocumentFloatField extends AbsDocumentField {

	private Float mValue;
	
	public void setValue(Float value) {
		mValue = value;
		
		mDocumentFieldObservable.onDocumentFieldChanged(this); 
	}
	
	public Float getValue() {
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
