package org.javaprotrepticon.petproducts.model.document.field;

import org.javaprotrepticon.petproducts.model.base.ObjectObservable;

public class DocumentFieldObservable extends ObjectObservable<DocumentFieldObserver> implements DocumentFieldObserver {

	@Override
	public void onDocumentFieldChanged(DocumentField documentField) {
        synchronized (mObservers) {
            for (int i = mObservers.size() - 1; i >= 0; i--) {
                mObservers.get(i).onDocumentFieldChanged(documentField);
            }
        }
	}
	
}
