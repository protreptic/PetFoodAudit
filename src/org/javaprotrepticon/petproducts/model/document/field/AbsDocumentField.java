package org.javaprotrepticon.petproducts.model.document.field;

public abstract class AbsDocumentField implements DocumentField {

	private boolean mIsEditable;
	
	protected DocumentFieldObservable mDocumentFieldObservable;
	
	@Override
	public boolean isEditable() {
		return mIsEditable;
	}

	@Override
	public void registerDocumentFieldObserver(DocumentFieldObserver documentFieldObserver) {
		mDocumentFieldObservable.registerObserver(documentFieldObserver);
	}

	@Override
	public void unregisterDocumentFieldObserver(DocumentFieldObserver documentFieldObserver) {
		mDocumentFieldObservable.unregisterObserver(documentFieldObserver);
	}
	
}
