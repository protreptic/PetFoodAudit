package org.javaprotrepticon.petproducts.model.document.filter;

public abstract class AbsDocumentFilter implements DocumentFilter {
	
	private DocumentFilterObservable mDocumentFilterObservable;

	@Override
	public void registerDocumentFilterObserver(DocumentFilterObserver documentFilterObserver) {
		mDocumentFilterObservable.registerObserver(documentFilterObserver);
	}

	@Override
	public void unregisterDocumentFilterObserver(DocumentFilterObserver documentFilterObserver) {
		mDocumentFilterObservable.unregisterObserver(documentFilterObserver);
	}
	
}
