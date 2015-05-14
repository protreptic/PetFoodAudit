package org.javaprotrepticon.petproducts.model.document.item;

import org.javaprotrepticon.petproducts.model.base.ObjectObservable;

public class DocumentItemObservable extends ObjectObservable<DocumentItemObserver> implements DocumentItemObserver {

	@Override
	public void onDocumentItemChanged(DocumentItem documentItem) {
        synchronized (mObservers) {
            for (int i = mObservers.size() - 1; i >= 0; i--) {
                mObservers.get(i).onDocumentItemChanged(documentItem);
            }
        }
	}
	
}
