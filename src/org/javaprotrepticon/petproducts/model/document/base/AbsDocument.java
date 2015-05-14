package org.javaprotrepticon.petproducts.model.document.base;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.javaprotrepticon.petproducts.model.base.ObjectId;
import org.javaprotrepticon.petproducts.model.document.defaults.DocumentComment;
import org.javaprotrepticon.petproducts.model.document.defaults.DocumentCreateDate;
import org.javaprotrepticon.petproducts.model.document.defaults.DocumentId;
import org.javaprotrepticon.petproducts.model.document.defaults.DocumentLastModifiedDate;
import org.javaprotrepticon.petproducts.model.document.field.DocumentField;
import org.javaprotrepticon.petproducts.model.document.item.DocumentItem;
import org.javaprotrepticon.petproducts.model.document.meta.DocumentDescription;
import org.javaprotrepticon.petproducts.model.document.meta.DocumentName;

public abstract class AbsDocument implements Document {
	
	protected DocumentId mDocumentId; 
	protected DocumentCreateDate mDocumentCreateDate;
	protected DocumentLastModifiedDate mDocumentLastModifiedDate;
	protected DocumentComment mDocumentComment;
	
	protected List<DocumentField> mDocumentFields = new ArrayList<DocumentField>();
	protected Map<ObjectId, DocumentItem> mDocumentItems = new HashMap<ObjectId, DocumentItem>();
	
	private DocumentObservable mDocumentObservable;
	
	protected void setDefaultFields() {
		mDocumentFields.add(new DocumentId());
		mDocumentFields.add(new DocumentCreateDate());
		mDocumentFields.add(new DocumentLastModifiedDate());
		mDocumentFields.add(new DocumentComment());
	}
	
	public void setDocumentId(DocumentId documentId) {
		mDocumentId = documentId;
	}
	
	public void setDocumentCreateDate(DocumentCreateDate documentCreateDate) {
		mDocumentCreateDate = documentCreateDate;
	}
	
	public void setDocumentLastModifiedDate(DocumentLastModifiedDate documentLastModifiedDate) {
		mDocumentLastModifiedDate = documentLastModifiedDate;
	}
	
	public void setDocumentComment(DocumentComment documentComment) {
		mDocumentComment = documentComment;
	}
	
	public DocumentId getDocumentId() {
		return mDocumentId;
	}
	
	public DocumentCreateDate getDocumentCreateDate() {
		return mDocumentCreateDate;
	}
	
	public DocumentLastModifiedDate getDocumentLastModifiedDate() {
		return mDocumentLastModifiedDate;
	}
	
	public DocumentComment getDocumentComment() {
		return mDocumentComment;
	}
	
	public List<DocumentField> getDocumentFields() {
		return mDocumentFields;
	}
	
	public Map<ObjectId, DocumentItem> getDocumentItems() {
		return mDocumentItems;
	}
	
	public int getFielsCount() {
		return mDocumentFields.size();
	}
	
	public int getItemsCount() {
		return mDocumentItems.size();
	}

	@Override
	public void registerDocumentObserver(DocumentObserver documentObserver) {
		mDocumentObservable.registerObserver(documentObserver);
	}

	@Override
	public void unregisterDocumentObserver(DocumentObserver documentObserver) {
		mDocumentObservable.unregisterObserver(documentObserver); 
	}

	@Override
	public void openDocument() {
		mDocumentObservable.onDocumentOpened(this);
	}

	@Override
	public void closeDocument() {
		mDocumentObservable.onDocumentClosed(this);
	}

	@Override
	public DocumentName documentName() {	
		return new DocumentName() {
			
			@Override
			public String toString() {
				return "Abstract document name";
			}
			
		};
	}
	
	@Override
	public DocumentDescription documentDescription() {
		return new DocumentDescription() {
			
			@Override
			public String toString() {
				return "Abstract document description";	
			}
			
		};
	}
	
	@Override
	public int hashCode() {
		return super.hashCode();
	}
	
	@Override
	public String toString() {
		return super.toString();
	}
	
}
