package com.explr.explravenue.firebase.firestore.controller

import com.google.firebase.cloud.FirestoreClient
import org.springframework.stereotype.Service

@Service
object FirestoreController {

    fun create(collection: String, any: Any) {
        FirestoreClient.getFirestore().collection(collection).document().set(any)
    }

    fun create(collectionL1: String, documentId: String, collectionL2: String, any: Any) {
        FirestoreClient.getFirestore().collection(collectionL1).document(documentId).collection(collectionL2).document().set(any)
    }

    fun create(collectionL1: String, documentIdL1: String, collectionL2: String, documentIdL2: String, collectionL3: String, any: Any) {
        FirestoreClient.getFirestore().collection(collectionL1).document(documentIdL1).collection(collectionL2).document(documentIdL2).collection(collectionL3).document().set(any)
    }

    fun update(documentId: String, collection: String, any: Any) {
        FirestoreClient.getFirestore().collection(collection).document(documentId).set(any)
    }

    fun update(documentId: String, collectionL1: String, documentIdL1: String, collectionL2: String, any: Any) {
        FirestoreClient.getFirestore().collection(collectionL1).document(documentId).collection(collectionL2).document(documentIdL1).set(any)
    }

    fun update(documentId: String, collectionL1: String, documentIdL1: String, collectionL2: String, documentIdL2: String, collectionL3: String, any: Any) {
        FirestoreClient.getFirestore().collection(collectionL1).document(documentId).collection(collectionL2).document(documentIdL1).collection(collectionL3).document(documentIdL2).set(any)
    }

    fun delete(documentId: String, collection: String) {
        FirestoreClient.getFirestore().collection(collection).document(documentId).delete()
    }

    fun delete(documentId: String, collectionL1: String, documentIdL1: String, collectionL2: String) {
        FirestoreClient.getFirestore().collection(collectionL1).document(documentId).collection(collectionL2).document(documentIdL1).delete()
    }

    fun delete(documentId: String, collectionL1: String, documentIdL1: String, collectionL2: String, documentIdL2: String, collectionL3: String) {
        FirestoreClient.getFirestore().collection(collectionL1).document(documentId).collection(collectionL2).document(documentIdL1).collection(collectionL3).document(documentIdL2).delete()
    }
}