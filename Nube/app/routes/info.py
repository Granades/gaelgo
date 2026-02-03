from fastapi import APIRouter
from app.core.db import get_db

router = APIRouter(prefix="/api")

@router.get("/info")
def info():
    return {
        "service" : "Nube API",
        "version" : "1.0",
        "cloud_ready" : True
    }
@router.get("/firestore-check")
def firestore_check():
    db = get_db()
    ref = db.collection("checks").document("fastapi")
    ref.set({"status" : "ok"})
    return ref.get().to_dict()