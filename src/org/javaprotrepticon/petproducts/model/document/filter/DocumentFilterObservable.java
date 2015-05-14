package org.javaprotrepticon.petproducts.model.document.filter;

import org.javaprotrepticon.petproducts.model.base.ObjectObservable;

public class DocumentFilterObservable extends ObjectObservable<DocumentFilterObserver> implements DocumentFilterObserver {

	@Override
	public void onDocumentFilterChanged(DocumentFilter documentFilter) {
        synchronized (mObservers) {
            for (int i = mObservers.size() - 1; i >= 0; i--) {
                mObservers.get(i).onDocumentFilterChanged(documentFilter);
            }
        }
	}
	
}
