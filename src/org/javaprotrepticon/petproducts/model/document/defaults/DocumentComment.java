package org.javaprotrepticon.petproducts.model.document.defaults;

import org.javaprotrepticon.petproducts.model.document.field.AbsDocumentField;
import org.javaprotrepticon.petproducts.model.document.meta.DocumentFieldDescription;
import org.javaprotrepticon.petproducts.model.document.meta.DocumentFieldName;

public class DocumentComment extends AbsDocumentField {
	
	@Override
	public DocumentFieldName fieldName() {
		return new DocumentFieldName() {
			
			@Override
			public String toString() {
				return "Комментарий документа";
			}
			
		};
	}

	@Override
	public DocumentFieldDescription fieldDescription() {
		return new DocumentFieldDescription() {
			
			@Override
			public String toString() {
				return "";
			}
			
		};
	}
	
}
