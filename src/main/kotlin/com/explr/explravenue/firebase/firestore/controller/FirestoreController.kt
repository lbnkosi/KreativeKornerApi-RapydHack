package com.explr.explravenue.firebase.firestore.controller

import com.explr.explravenue.kreativeapi.checkout.models.FirebaseCheckoutRequest
import com.google.cloud.firestore.DocumentReference
import com.google.firebase.cloud.FirestoreClient
import org.springframework.stereotype.Service


@Service
object FirestoreController {

    fun create(uid: String? = "", collection: String, any: Any) {
        if (uid.isNullOrEmpty()) {
            FirestoreClient.getFirestore().collection(collection).document().set(any)
        } else {
            FirestoreClient.getFirestore().collection(collection).document(uid).set(any)
        }
    }

    fun create(collectionL1: String, documentId: String, collectionL2: String, any: Any) {
        FirestoreClient.getFirestore().collection(collectionL1).document(documentId).collection(collectionL2).document().set(any)
    }

    fun create(uid: String? = "", collectionL1: String, documentId: String, collectionL2: String, any: Any) {
        if (uid.isNullOrEmpty()) {
            FirestoreClient.getFirestore().collection(collectionL1).document(documentId).collection(collectionL2).document().set(any)
        } else {
            FirestoreClient.getFirestore().collection(collectionL1).document(documentId).collection(collectionL2).document(uid).set(any)
        }
        //FirestoreClient.getFirestore().collection(collectionL1).document(documentId).collection(collectionL2).document().set(any)
    }

    fun create(collectionL1: String, documentIdL1: String, collectionL2: String, documentIdL2: String, collectionL3: String, any: Any) {
        FirestoreClient.getFirestore().collection(collectionL1).document(documentIdL1).collection(collectionL2).document(documentIdL2).collection(collectionL3).document().set(any)
    }

    fun update(documentId: String, collection: String, any: Any) {
        FirestoreClient.getFirestore().collection(collection).document(documentId).set(any)
    }

    fun update(documentId: String, collectionL1: String, documentIdL1: String, collectionL2: String, any: Any?) {
        any?.let { FirestoreClient.getFirestore().collection(collectionL1).document(documentId).collection(collectionL2).document(documentIdL1).set(it) }
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

    fun updatePaid(documentId: String, collectionL1: String, documentIdL1: String, collectionL2: String) {
        val docRef: DocumentReference = FirestoreClient.getFirestore().collection(collectionL1).document(documentId).collection(collectionL2).document(documentIdL1)
        val future = docRef.get()
        val document = future.get()
        val checkout: FirebaseCheckoutRequest?
        if (document.exists()) {
            checkout = document.toObject(FirebaseCheckoutRequest::class.java)
            checkout?.paid =  true
            update(documentId, collectionL1, documentIdL1, collectionL2, checkout)
        } else {
            println("No such document!")
        }
    }
}