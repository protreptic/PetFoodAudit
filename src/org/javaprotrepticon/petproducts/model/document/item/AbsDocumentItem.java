package org.javaprotrepticon.petproducts.model.document.item;

public abstract class AbsDocumentItem implements DocumentItem {

	private DocumentItemObservable mDocumentItemObservable;
	
	@Override
	public void registerDocumentItemObserver(DocumentItemObserver documentItemObserver) {
		mDocumentItemObservable.registerObserver(documentItemObserver); 
	}

	@Override
	public void unregisterDocumentItemObserver(DocumentItemObserver documentItemObserver) {
		mDocumentItemObservable.unregisterObserver(documentItemObserver);
	} 

}
