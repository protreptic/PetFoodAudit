package org.javaprotrepticon.petproducts.model.document.base;

import org.javaprotrepticon.petproducts.model.base.ObjectObservable;

public class DocumentObservable extends ObjectObservable<DocumentObserver> implements DocumentObserver {

	@Override
	public void onDocumentOpened(Document document) {
        synchronized (mObservers) {
            for (int i = mObservers.size() - 1; i >= 0; i--) {
                mObservers.get(i).onDocumentOpened(document);
            }
        }
	}

	@Override
	public void onDocumentClosed(Document document) {
        synchronized (mObservers) {
            for (int i = mObservers.size() - 1; i >= 0; i--) {
                mObservers.get(i).onDocumentClosed(document);
            }
        }
	}

	@Override
	public void onDocumentChanged(Document document) {
        synchronized (mObservers) {
            for (int i = mObservers.size() - 1; i >= 0; i--) {
                mObservers.get(i).onDocumentChanged(document);
            }
        }
	}

}
