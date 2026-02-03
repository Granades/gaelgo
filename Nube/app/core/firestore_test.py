from google.cloud import firestore

def run_test():
    db = firestore.Client()
    doc_ref = db.collection("test").document("hello")
    doc_ref.set({"message": "Firestore is connected"})
    doc = doc_ref.get()
    print("Firestore read:", doc.to_dict())

if __name__ == "__main__":
    run_test()
