package org.javaprotrepticon.petproducts.model.document.field;

import org.javaprotrepticon.petproducts.model.document.meta.DocumentFieldDescription;
import org.javaprotrepticon.petproducts.model.document.meta.DocumentFieldName;

public class DocumentBooleanField extends AbsDocumentField {

	private Boolean mValue;
	
	public void setValue(Boolean value) {
		mValue = value;
	}
	
	public Boolean getValue() {
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
