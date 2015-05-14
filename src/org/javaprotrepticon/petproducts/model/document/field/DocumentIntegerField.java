package org.javaprotrepticon.petproducts.model.document.field;

import org.javaprotrepticon.petproducts.model.document.meta.DocumentFieldDescription;
import org.javaprotrepticon.petproducts.model.document.meta.DocumentFieldName;

public class DocumentIntegerField extends AbsDocumentField {

	private Integer mValue;
	
	public void setValue(Integer value) {
		mValue = value;
		
		mDocumentFieldObservable.onDocumentFieldChanged(this); 
	}
	
	public Integer getValue() {
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
